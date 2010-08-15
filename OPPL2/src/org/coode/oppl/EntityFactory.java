package org.coode.oppl;

import java.util.ArrayList;
import java.util.List;

import org.coode.oppl.entity.OWLEntityCreationException;
import org.coode.oppl.entity.OWLEntityCreationSet;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntologyChange;

public class EntityFactory implements org.coode.oppl.entity.OWLEntityFactory {
	private OPPLAbstractFactory factory;

	public EntityFactory(OPPLAbstractFactory f) {
		this.factory = f;
	}

	/**
	 * @param shortName
	 * @return
	 */
	private IRI buildIRI(String shortName) {
		IRI ontologyIRI = this.factory.getOntology().getOntologyID()
				.getOntologyIRI();
		return ontologyIRI == null ? this.factory.getDefaultOntologyIRI() : IRI
				.create(ontologyIRI.toString() + "#" + shortName);
	}

	/**
	 * @return a valid IRI fragment built from the input string (which can be
	 *         either a valid fragment or a string suitable to be used as label)
	 * 
	 *         The relevant grammar (from http://www.ietf.org/rfc/rfc2396.txt)
	 *         is: <br>
	 * 
	 *         IRIc = reserved | unreserved | escaped<br>
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
	private static final char[] forbiddenCharacters = new char[] { '\'', '>',
			'<', '`', '"' };

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

	public OWLEntityCreationSet<OWLClass> createOWLClass(String shortName,
			IRI baseIRI) throws OWLEntityCreationException {
		return this.createOWLEntity(OWLClass.class, shortName, baseIRI);
	}

	public OWLEntityCreationSet<OWLDataProperty> createOWLDataProperty(
			String shortName, IRI baseIRI) throws OWLEntityCreationException {
		return this.createOWLEntity(OWLDataProperty.class, shortName, baseIRI);
	}

	public <T extends OWLEntity> OWLEntityCreationSet<T> createOWLEntity(
			Class<T> type, String shortName, IRI baseIRI)
			throws OWLEntityCreationException {
		String label = this.buildLabelString(shortName);
		String realShortName = this.buildFragment(label);
		IRI anIRI = this.buildIRI(realShortName);
		T entity = this.getOWLEntity(type, anIRI);
		OWLDeclarationAxiom declarationAxiom = this.factory.getOWLDataFactory()
				.getOWLDeclarationAxiom(entity);
		List<OWLOntologyChange> changes = new ArrayList<OWLOntologyChange>();
		changes.add(new AddAxiom(this.factory.getOntology(), declarationAxiom));
		if (!realShortName.equals(shortName)) {
			// add a label only if the shortname passed in input was not
			// suitable as fragment, i.e., an alternate representation gives
			// more information
			OWLAnnotationProperty rdfsLabel = this.factory.getOWLDataFactory()
					.getRDFSLabel();
			OWLAnnotation owlAnnotation = this.factory.getOWLDataFactory()
					.getOWLAnnotation(
							rdfsLabel,
							this.factory.getOWLDataFactory().getOWLLiteral(
									label));
			OWLAnnotationAssertionAxiom owlAnnotationAssertionAxiom = this.factory
					.getOWLDataFactory().getOWLAnnotationAssertionAxiom(
							entity.getIRI(), owlAnnotation);
			OWLAxiomChange extraChange = new AddAxiom(this.factory
					.getOntology(), owlAnnotationAssertionAxiom);
			changes.add(extraChange);
		}
		return new OWLEntityCreationSet<T>(entity, changes);
	}

	public OWLEntityCreationSet<OWLNamedIndividual> createOWLIndividual(
			String shortName, IRI baseIRI) throws OWLEntityCreationException {
		return this.createOWLEntity(OWLNamedIndividual.class, shortName,
				baseIRI);
	}

	public OWLEntityCreationSet<OWLObjectProperty> createOWLObjectProperty(
			String shortName, IRI baseIRI) throws OWLEntityCreationException {
		return this
				.createOWLEntity(OWLObjectProperty.class, shortName, baseIRI);
	}

	@SuppressWarnings("unchecked")
	private <T extends OWLEntity> T getOWLEntity(Class<T> type, IRI IRI) {
		if (OWLClass.class.isAssignableFrom(type)) {
			return (T) this.factory.getOWLDataFactory().getOWLClass(IRI);
		} else if (OWLObjectProperty.class.isAssignableFrom(type)) {
			return (T) this.factory.getOWLDataFactory().getOWLObjectProperty(
					IRI);
		} else if (OWLDataProperty.class.isAssignableFrom(type)) {
			return (T) this.factory.getOWLDataFactory().getOWLDataProperty(IRI);
		} else if (OWLNamedIndividual.class.isAssignableFrom(type)) {
			return (T) this.factory.getOWLDataFactory().getOWLNamedIndividual(
					IRI);
		}
		return null;
	}

	private <T extends OWLEntity> boolean isValidNewID(String shortName,
			IRI baseIRI, Class<T> type) {
		return baseIRI.equals(this.factory.getOntology().getOntologyID()
				.getOntologyIRI());
	}

	public <T extends OWLEntity> OWLEntityCreationSet<T> preview(Class<T> type,
			String shortName, IRI baseIRI) throws OWLEntityCreationException {
		return this.createOWLEntity(type, shortName, baseIRI);
	}

	public void tryCreate(Class<? extends OWLEntity> type, String shortName,
			IRI baseIRI) throws OWLEntityCreationException {
		if (!this.isValidNewID(shortName, baseIRI, type)) {
			throw new OWLEntityCreationException("Invalid name: " + shortName
					+ "for an " + type.getName());
		}
	}
}