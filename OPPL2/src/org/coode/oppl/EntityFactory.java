package org.coode.oppl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.coode.oppl.entity.OWLEntityCreationException;
import org.coode.oppl.entity.OWLEntityCreationSet;
import org.semanticweb.owl.model.AddAxiom;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDeclarationAxiom;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLLabelAnnotation;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLOntologyChange;

public class EntityFactory implements org.coode.oppl.entity.OWLEntityFactory {
	private OPPLAbstractFactory factory;

	public EntityFactory(OPPLAbstractFactory f) {
		this.factory = f;
	}

	/**
	 * @param shortName
	 * @return
	 */
	private URI buildURI(String shortName) {
		return URI.create(this.factory.getOntology().getURI().toString() + "#" + shortName);
	}

	/**
	 * @return a valid URI fragment built from the input string (which can be
	 *         either a valid fragment or a string suitable to be used as label)
	 * 
	 *         The relevant grammar (from http://www.ietf.org/rfc/rfc2396.txt)
	 *         is: <br>
	 * 
	 *         uric = reserved | unreserved | escaped<br>
	 *         reserved = ";" | "/" | "?" | ":" | "@" | "&" | "=" | "+" | "$" |
	 *         ","<br>
	 *         unreserved = alphanum | mark<br>
	 *         mark = "-" | "_" | "." | "!" | "~" | "*" | "'" | "(" | ")"<br>
	 * 
	 *         escaped = "%" hex hex<br>
	 *         hex = digit | "A" | "B" | "C" | "D" | "E" | "F" | "a" | "b" | "c"
	 *         | "d" | "e" | "f"<br>
	 * 
	 *         alphanum = alpha | digit<br>
	 *         alpha = lowalpha | upalpha<br>
	 * 
	 *         however, to simplify the method and remove ambiguities (i.e., '
	 *         and , are used in the Manchester syntax grammar as well), only
	 *         alphanumeric characters will be left in, while any other
	 *         character will be replaced by "_"; sequences of one or more
	 *         underscores will be trimmed to one.
	 */
	private String buildFragment(String label) {
		StringBuilder b = new StringBuilder(label);
		for (int i = 0; i < b.length(); i++) {
			char c = b.charAt(i);
			if (!(Character.isLetterOrDigit(c) || c == '_')) {
				b.setCharAt(i, '_');
			}
		}
		return b.toString().replaceAll("[_]+", "_");
	}

	/** characters which will be removed from labels */
	private static final char[] forbiddenCharacters = new char[] { '\'', '>', '<', '`', '"' };

	/**
	 * @return the original string purged of characters which are not supposed
	 *         to belong to a label (e.g., ' ", etc). Complete list is in the
	 *         forbiddenCharacters list.
	 */
	private String buildLabelString(String label) {
		String toReturn = label.trim();
		for (char c : forbiddenCharacters) {
			toReturn = toReturn.replace(c + "", "");
		}
		return toReturn;
	}

	public OWLEntityCreationSet<OWLClass> createOWLClass(String shortName, URI baseURI)
			throws OWLEntityCreationException {
		return this.createOWLEntity(OWLClass.class, shortName, baseURI);
	}

	public OWLEntityCreationSet<OWLDataProperty> createOWLDataProperty(String shortName, URI baseURI)
			throws OWLEntityCreationException {
		return this.createOWLEntity(OWLDataProperty.class, shortName, baseURI);
	}

	public <T extends OWLEntity> OWLEntityCreationSet<T> createOWLEntity(Class<T> type,
			String shortName, URI baseURI) throws OWLEntityCreationException {
		String label = this.buildLabelString(shortName);
		String realShortName = this.buildFragment(label);
		URI anURI = this.buildURI(realShortName);
		T entity = this.getOWLEntity(type, anURI);
		OWLDeclarationAxiom declarationAxiom = this.factory.getOWLDataFactory().getOWLDeclarationAxiom(
				entity);
		List<OWLOntologyChange> changes = new ArrayList<OWLOntologyChange>();
		changes.add(new AddAxiom(this.factory.getOntology(), declarationAxiom));
		if (!realShortName.equals(shortName)) {
			// add a label only if the shortname passed in input was not
			// suitable as fragment, i.e., an alternate representation gives
			// more information
			OWLLabelAnnotation labelAnnotation = this.factory.getOWLDataFactory().getOWLLabelAnnotation(
					label);
			OWLAxiomChange extraChange = new AddAxiom(this.factory.getOntology(),
					this.factory.getOWLDataFactory().getOWLEntityAnnotationAxiom(
							entity,
							labelAnnotation));
			changes.add(extraChange);
		}
		return new OWLEntityCreationSet<T>(entity, changes);
	}

	public OWLEntityCreationSet<OWLIndividual> createOWLIndividual(String shortName, URI baseURI)
			throws OWLEntityCreationException {
		return this.createOWLEntity(OWLIndividual.class, shortName, baseURI);
	}

	public OWLEntityCreationSet<OWLObjectProperty> createOWLObjectProperty(String shortName,
			URI baseURI) throws OWLEntityCreationException {
		return this.createOWLEntity(OWLObjectProperty.class, shortName, baseURI);
	}

	@SuppressWarnings("unchecked")
	private <T extends OWLEntity> T getOWLEntity(Class<T> type, URI uri) {
		if (OWLClass.class.isAssignableFrom(type)) {
			return (T) this.factory.getOWLDataFactory().getOWLClass(uri);
		} else if (OWLObjectProperty.class.isAssignableFrom(type)) {
			return (T) this.factory.getOWLDataFactory().getOWLObjectProperty(uri);
		} else if (OWLDataProperty.class.isAssignableFrom(type)) {
			return (T) this.factory.getOWLDataFactory().getOWLDataProperty(uri);
		} else if (OWLIndividual.class.isAssignableFrom(type)) {
			return (T) this.factory.getOWLDataFactory().getOWLIndividual(uri);
		}
		return null;
	}

	private <T extends OWLEntity> boolean isValidNewID(String shortName, URI baseURI, Class<T> type) {
		return baseURI.equals(this.factory.getOntology().getURI());
	}

	public <T extends OWLEntity> OWLEntityCreationSet<T> preview(Class<T> type, String shortName,
			URI baseURI) throws OWLEntityCreationException {
		return this.createOWLEntity(type, shortName, baseURI);
	}

	public void tryCreate(Class<? extends OWLEntity> type, String shortName, URI baseURI)
			throws OWLEntityCreationException {
		if (!this.isValidNewID(shortName, baseURI, type)) {
			throw new OWLEntityCreationException("Invalid name: " + shortName + "for an "
					+ type.getName());
		}
	}
}