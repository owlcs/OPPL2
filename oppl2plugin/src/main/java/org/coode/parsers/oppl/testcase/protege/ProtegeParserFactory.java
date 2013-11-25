package org.coode.parsers.oppl.testcase.protege;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Set;

import org.coode.oppl.protege.ProtegeOWLEntityChecker;
import org.coode.parsers.DisposableOWLEntityChecker;
import org.coode.parsers.DisposableShortFormEntityChecker;
import org.coode.parsers.EntityFinder;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ShortFormEntityRenderer;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLScope;
import org.coode.parsers.oppl.testcase.AbstractOPPLTestCaseFactory;
import org.coode.parsers.oppl.testcase.OPPLTestCaseParser;
import org.coode.parsers.oppl.testcase.OPPLTestCaseParser.AbstractParserFactory;
import org.coode.parsers.oppl.testcase.OPPLTestCaseSymbolTable;
import org.coode.parsers.oppl.testcase.ParserFactory;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.inference.NoOpReasoner;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

/** @author Luigi Iannone */
public class ProtegeParserFactory implements AbstractParserFactory {
    private final class ProtegeSymbolTableFactory implements
            SymbolTableFactory<OPPLTestCaseSymbolTable> {
        public ProtegeSymbolTableFactory() {}

        @Override
        public OPPLTestCaseSymbolTable createSymbolTable() {
            DisposableOWLEntityChecker entityChecker = new DisposableShortFormEntityChecker(
                    getOWLEntityChecker());
            EntityFinder entityFinder = getEntityFinder();
            return new OPPLTestCaseSymbolTable(new OPPLScope(entityChecker, entityFinder,
                    entityRenderer), getOWLEditorKit().getOWLModelManager()
                    .getOWLDataFactory());
        }
    }

    private class ProtegeEntityFinder implements EntityFinder {
        public ProtegeEntityFinder() {}

        @Override
        public Set<OWLDatatype> getMatchingOWLDataTypes(String match) {
            return getOWLEditorKit().getOWLModelManager().getOWLEntityFinder()
                    .getMatchingOWLDatatypes(match);
        }

        @Override
        public Set<OWLDatatype> getMatchingOWLDataTypes(String match, boolean fullRegExp) {
            return getOWLEditorKit().getOWLModelManager().getOWLEntityFinder()
                    .getMatchingOWLDatatypes(match, fullRegExp);
        }

        @Override
        public Set<OWLEntity> getEntities(String match) {
            return getOWLEditorKit().getOWLModelManager().getOWLEntityFinder()
                    .getMatchingOWLEntities(match);
        }

        @Override
        public Set<OWLEntity> getEntities(String match, boolean fullRegExp) {
            return getOWLEditorKit().getOWLModelManager().getOWLEntityFinder()
                    .getMatchingOWLEntities(match, fullRegExp);
        }

        @Override
        public Set<OWLClass> getMatchingOWLClasses(String match) {
            return getOWLEditorKit().getOWLModelManager().getOWLEntityFinder()
                    .getMatchingOWLClasses(match);
        }

        @Override
        public Set<OWLClass> getMatchingOWLClasses(String match, boolean fullRegExp) {
            return getOWLEditorKit().getOWLModelManager().getOWLEntityFinder()
                    .getMatchingOWLClasses(match, fullRegExp);
        }

        @Override
        public Set<OWLObjectProperty> getMatchingOWLObjectProperties(String match) {
            return getOWLEditorKit().getOWLModelManager().getOWLEntityFinder()
                    .getMatchingOWLObjectProperties(match);
        }

        @Override
        public Set<OWLObjectProperty> getMatchingOWLObjectProperties(String match,
                boolean fullRegExp) {
            return getOWLEditorKit().getOWLModelManager().getOWLEntityFinder()
                    .getMatchingOWLObjectProperties(match, fullRegExp);
        }

        @Override
        public Set<OWLDataProperty> getMatchingOWLDataProperties(String match) {
            return getOWLEditorKit().getOWLModelManager().getOWLEntityFinder()
                    .getMatchingOWLDataProperties(match);
        }

        @Override
        public Set<OWLDataProperty> getMatchingOWLDataProperties(String match,
                boolean fullRegExp) {
            return getOWLEditorKit().getOWLModelManager().getOWLEntityFinder()
                    .getMatchingOWLDataProperties(match, fullRegExp);
        }

        @Override
        public Set<OWLNamedIndividual> getMatchingOWLIndividuals(String match) {
            return getOWLEditorKit().getOWLModelManager().getOWLEntityFinder()
                    .getMatchingOWLIndividuals(match);
        }

        @Override
        public Set<OWLNamedIndividual> getMatchingOWLIndividuals(String match,
                boolean fullRegExp) {
            return getOWLEditorKit().getOWLModelManager().getOWLEntityFinder()
                    .getMatchingOWLIndividuals(match, fullRegExp);
        }
    }

    private class ProtegeOWLEntityRenderer extends ShortFormEntityRenderer {
        public ProtegeOWLEntityRenderer() {
            super(new SimpleShortFormProvider());
        }

        @Override
        public String render(OWLEntity entity) {
            return getOWLEditorKit().getOWLModelManager().getRendering(entity);
        }
    }

    private final OWLEditorKit owlEditorKit;
    protected final ShortFormEntityRenderer entityRenderer;
    private final EntityFinder protegeEntityFinder;
    private final ProtegeOWLEntityChecker protegeOWLEntityChecker;

    /** @param owlEditorKit */
    public ProtegeParserFactory(OWLEditorKit owlEditorKit) {
        this.owlEditorKit = checkNotNull(owlEditorKit, "owlEditorKit");
        protegeOWLEntityChecker = new ProtegeOWLEntityChecker(getOWLEditorKit());
        protegeEntityFinder = new ProtegeEntityFinder();
        entityRenderer = new ProtegeOWLEntityRenderer();
    }

    @Override
    public OPPLTestCaseParser build(ErrorListener errorListener) {
        OWLOntology activeOntology = getOWLEditorKit().getOWLModelManager()
                .getActiveOntology();
        OWLOntologyManager ontologyManager = getOWLEditorKit().getOWLModelManager()
                .getOWLOntologyManager();
        OWLReasoner reasoner = getOWLEditorKit().getOWLModelManager().getReasoner() instanceof NoOpReasoner ? null
                : getOWLEditorKit().getOWLModelManager().getReasoner();
        SymbolTableFactory<OPPLTestCaseSymbolTable> symbolTableFactory = new ProtegeSymbolTableFactory();
        ParserFactory parserFactory = new ParserFactory(activeOntology, ontologyManager,
                reasoner) {
            @Override
            public AbstractOPPLTestCaseFactory getOPPLTestCaseFactory() {
                return new ProtegeOPPLTestCaseFactory(
                        ProtegeParserFactory.this.getOWLEditorKit());
            }
        };
        return parserFactory.build(errorListener, symbolTableFactory);
    }

    @Override
    public AbstractOPPLTestCaseFactory getOPPLTestCaseFactory() {
        return new ProtegeOPPLTestCaseFactory(getOWLEditorKit());
    }

    /** @return the owlEditorKit */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    /** @return entity finder */
    public EntityFinder getEntityFinder() {
        return protegeEntityFinder;
    }

    /** @return the entityRenderer */
    public ShortFormEntityRenderer getEntityRenderer() {
        return entityRenderer;
    }

    /** @return entity checker */
    public OWLEntityChecker getOWLEntityChecker() {
        return protegeOWLEntityChecker;
    }
}
