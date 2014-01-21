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

/** @author Luigi Iannone */
public class EntityFactory implements org.coode.oppl.entity.OWLEntityFactory {
    private final OPPLAbstractFactory factory;

    /** @param f
     *            f */
    public EntityFactory(OPPLAbstractFactory f) {
        factory = f;
    }

    /** @param shortName
     *            shortName
     * @return iri */
    private IRI buildIRI(String shortName) {
        IRI ontologyIRI = factory.getOntology().getOntologyID().getOntologyIRI();
        return ontologyIRI == null ? IRI.create(String.format("%s#%s", factory
                .getDefaultOntologyIRI().toString(), shortName)) : IRI.create(String
                .format("%s#%s", ontologyIRI.toString(), shortName));
    }

    /** @param label
     *            label
     * @return a valid IRI fragment built from the input string (which can be
     *         either a valid fragment or a string suitable to be used as label)
     *         The relevant grammar (from http://www.ietf.org/rfc/rfc2396.txt)
     *         is: <br>
     *         IRIc = reserved | unreserved | escaped<br>
     *         reserved = ";" | "/" | "?" | ":" | "@" | "&" | "=" | "+" | "$" |
     *         ","<br>
     *         unreserved = alphanum | mark<br>
     *         mark = "-" | "_" | "." | "!" | "~" | "*" | "'" | "(" | ")"<br>
     *         escaped = "%" hex hex<br>
     *         hex = digit | "A" | "B" | "C" | "D" | "E" | "F" | "a" | "b" | "c"
     *         | "d" | "e" | "f"<br>
     *         alphanum = alpha | digit<br>
     *         alpha = lowalpha | upalpha<br>
     *         however, to simplify the method and remove ambiguities (i.e., '
     *         and , are used in the Manchester syntax grammar as well), only
     *         alphanumeric characters will be left in, while any other
     *         character will be replaced by "_"; sequences of one or more
     *         underscores will be trimmed to one. */
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
    private static final char[] forbiddenCharacters = new char[] { '\'', '>', '<', '`',
            '"' };

    /** @param label
     *            label
     * @return the original string purged of characters which are not supposed
     *         to belong to a label (e.g., ' ", etc). Complete list is in the
     *         forbiddenCharacters list. */
    private String buildLabelString(String label) {
        String toReturn = label.trim();
        for (char c : forbiddenCharacters) {
            toReturn = toReturn.replace(c + "", "");
        }
        return toReturn;
    }

    @Override
    public OWLEntityCreationSet<OWLClass> createOWLClass(String shortName, IRI baseIRI)
            throws OWLEntityCreationException {
        return this.createOWLEntity(OWLClass.class, shortName, baseIRI);
    }

    @Override
    public OWLEntityCreationSet<OWLDataProperty> createOWLDataProperty(String shortName,
            IRI baseIRI) throws OWLEntityCreationException {
        return this.createOWLEntity(OWLDataProperty.class, shortName, baseIRI);
    }

    @Override
    public <T extends OWLEntity> OWLEntityCreationSet<T> createOWLEntity(Class<T> type,
            String shortName, IRI baseIRI) throws OWLEntityCreationException {
        String label = buildLabelString(shortName);
        String realShortName = buildFragment(label);
        IRI anIRI = buildIRI(realShortName);
        T entity = this.getOWLEntity(type, anIRI);
        OWLDeclarationAxiom declarationAxiom = factory.getOWLDataFactory()
                .getOWLDeclarationAxiom(entity);
        List<OWLOntologyChange> changes = new ArrayList<OWLOntologyChange>();
        changes.add(new AddAxiom(factory.getOntology(), declarationAxiom));
        if (!realShortName.equals(shortName)) {
            // add a label only if the shortname passed in input was not
            // suitable as fragment, i.e., an alternate representation gives
            // more information
            OWLAnnotationProperty rdfsLabel = factory.getOWLDataFactory().getRDFSLabel();
            OWLAnnotation owlAnnotation = factory.getOWLDataFactory().getOWLAnnotation(
                    rdfsLabel, factory.getOWLDataFactory().getOWLLiteral(label));
            OWLAnnotationAssertionAxiom owlAnnotationAssertionAxiom = factory
                    .getOWLDataFactory().getOWLAnnotationAssertionAxiom(entity.getIRI(),
                            owlAnnotation);
            OWLAxiomChange extraChange = new AddAxiom(factory.getOntology(),
                    owlAnnotationAssertionAxiom);
            changes.add(extraChange);
        }
        return new OWLEntityCreationSet<T>(entity, changes);
    }

    @Override
    public OWLEntityCreationSet<OWLNamedIndividual> createOWLIndividual(String shortName,
            IRI baseIRI) throws OWLEntityCreationException {
        return this.createOWLEntity(OWLNamedIndividual.class, shortName, baseIRI);
    }

    @Override
    public OWLEntityCreationSet<OWLObjectProperty> createOWLObjectProperty(
            String shortName, IRI baseIRI) throws OWLEntityCreationException {
        return this.createOWLEntity(OWLObjectProperty.class, shortName, baseIRI);
    }

    @Override
    public OWLEntityCreationSet<OWLAnnotationProperty> createOWLAnnotationProperty(
            String shortName, IRI baseIRI) throws OWLEntityCreationException {
        return this.createOWLEntity(OWLAnnotationProperty.class, shortName, baseIRI);
    }

    @SuppressWarnings("unchecked")
    private <T extends OWLEntity> T getOWLEntity(Class<T> type, IRI IRI) {
        if (OWLClass.class.isAssignableFrom(type)) {
            return (T) factory.getOWLDataFactory().getOWLClass(IRI);
        } else if (OWLObjectProperty.class.isAssignableFrom(type)) {
            return (T) factory.getOWLDataFactory().getOWLObjectProperty(IRI);
        } else if (OWLDataProperty.class.isAssignableFrom(type)) {
            return (T) factory.getOWLDataFactory().getOWLDataProperty(IRI);
        } else if (OWLNamedIndividual.class.isAssignableFrom(type)) {
            return (T) factory.getOWLDataFactory().getOWLNamedIndividual(IRI);
        }
        return null;
    }

    private <T extends OWLEntity> boolean isValidNewID(IRI baseIRI) {
        return baseIRI.equals(factory.getOntology().getOntologyID().getOntologyIRI());
    }

    @Override
    public <T extends OWLEntity> OWLEntityCreationSet<T> preview(Class<T> type,
            String shortName, IRI baseIRI) throws OWLEntityCreationException {
        return this.createOWLEntity(type, shortName, baseIRI);
    }

    @Override
    public void tryCreate(Class<? extends OWLEntity> type, String shortName, IRI baseIRI)
            throws OWLEntityCreationException {
        if (!this.isValidNewID(baseIRI)) {
            throw new OWLEntityCreationException("Invalid name: " + shortName + "for an "
                    + type.getName());
        }
    }
}
