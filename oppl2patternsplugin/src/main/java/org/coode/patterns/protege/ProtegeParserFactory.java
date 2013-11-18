/**
 * 
 */
package org.coode.patterns.protege;

import java.util.Collection;
import java.util.Set;
import java.util.logging.Logger;

import org.coode.parsers.DisposableOWLEntityChecker;
import org.coode.parsers.DisposableShortFormEntityChecker;
import org.coode.parsers.EntityFinder;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.LoggerErrorListener;
import org.coode.parsers.ShortFormEntityRenderer;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLScope;
import org.coode.parsers.oppl.patterns.OPPLPatternsSymbolTable;
import org.coode.patterns.AbstractPatternModelFactory;
import org.coode.patterns.OPPLPatternParser;
import org.coode.patterns.OPPLPatternParser.AbstractParserFactory;
import org.coode.patterns.VisitedPatternReferenceResolver;
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

/** @author Luigi Iannone */
public class ProtegeParserFactory implements AbstractParserFactory {
    private class ProtegeEntityFinder implements EntityFinder {
        public ProtegeEntityFinder() {}

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
    }

    private class ProtegeOWLEntityChecker implements OWLEntityChecker {
        public ProtegeOWLEntityChecker() {}

        @Override
        public OWLClass getOWLClass(String name) {
            OWLClass toReturn = null;
            OWLEntity owlEntity = getOWLEditorKit().getOWLModelManager()
                    .getOWLEntityFinder().getOWLEntity(name);
            if (owlEntity != null) {
                toReturn = owlEntity.accept(new OWLObjectVisitorExAdapter<OWLClass>() {
                    @Override
                    public OWLClass visit(OWLClass desc) {
                        return desc;
                    }
                });
            }
            return toReturn;
        }

        @Override
        public OWLAnnotationProperty getOWLAnnotationProperty(String name) {
            OWLAnnotationProperty toReturn = null;
            OWLEntity owlEntity = getOWLEditorKit().getOWLModelManager()
                    .getOWLEntityFinder().getOWLEntity(name);
            if (owlEntity != null) {
                toReturn = owlEntity
                        .accept(new OWLObjectVisitorExAdapter<OWLAnnotationProperty>() {
                            @Override
                            public OWLAnnotationProperty visit(
                                    OWLAnnotationProperty property) {
                                return property;
                            }
                        });
            }
            return toReturn;
        }

        @Override
        public OWLDataProperty getOWLDataProperty(String name) {
            OWLDataProperty toReturn = null;
            OWLEntity owlEntity = getOWLEditorKit().getOWLModelManager()
                    .getOWLEntityFinder().getOWLEntity(name);
            if (owlEntity != null) {
                toReturn = owlEntity
                        .accept(new OWLObjectVisitorExAdapter<OWLDataProperty>() {
                            @Override
                            public OWLDataProperty visit(OWLDataProperty property) {
                                return property;
                            }
                        });
            }
            return toReturn;
        }

        @Override
        public OWLObjectProperty getOWLObjectProperty(String name) {
            OWLObjectProperty toReturn = null;
            OWLEntity owlEntity = getOWLEditorKit().getOWLModelManager()
                    .getOWLEntityFinder().getOWLEntity(name);
            if (owlEntity != null) {
                toReturn = owlEntity
                        .accept(new OWLObjectVisitorExAdapter<OWLObjectProperty>() {
                            @Override
                            public OWLObjectProperty visit(OWLObjectProperty property) {
                                return property;
                            }
                        });
            }
            return toReturn;
        }

        @Override
        public OWLDatatype getOWLDatatype(String name) {
            OWLDatatype toReturn = null;
            OWLEntity owlEntity = getOWLEditorKit().getOWLModelManager()
                    .getOWLEntityFinder().getOWLEntity(name);
            if (owlEntity != null) {
                toReturn = owlEntity.accept(new OWLObjectVisitorExAdapter<OWLDatatype>() {
                    @Override
                    public OWLDatatype visit(OWLDatatype node) {
                        return node;
                    }
                });
            }
            return toReturn;
        }

        @Override
        public OWLNamedIndividual getOWLIndividual(String name) {
            OWLNamedIndividual toReturn = null;
            OWLEntity owlEntity = getOWLEditorKit().getOWLModelManager()
                    .getOWLEntityFinder().getOWLEntity(name);
            if (owlEntity != null) {
                toReturn = owlEntity
                        .accept(new OWLObjectVisitorExAdapter<OWLNamedIndividual>() {
                            @Override
                            public OWLNamedIndividual
                                    visit(OWLNamedIndividual individual) {
                                return individual;
                            }
                        });
            }
            return toReturn;
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

    private class ProtegeSymbolTableFactory implements
            SymbolTableFactory<OPPLPatternsSymbolTable> {
        public ProtegeSymbolTableFactory() {}

        @Override
        public OPPLPatternsSymbolTable createSymbolTable() {
            DisposableOWLEntityChecker entityChecker = new DisposableShortFormEntityChecker(
                    getOWLEntityChecker());
            EntityFinder entityFinder = getEntityFinder();
            return new OPPLPatternsSymbolTable(new OPPLScope(entityChecker, entityFinder,
                    entityRenderer), getOWLEditorKit().getOWLModelManager()
                    .getOWLOntologyManager());
        }
    }

    private final OWLEditorKit owlEditorKit;
    private final EntityFinder protegeEntityFinder;
    protected final ShortFormEntityRenderer entityRenderer;
    private final ProtegeOWLEntityChecker protegeOWLEntityChecker;
    private static ProtegeParserFactory instance = null;

    /** @param owlEditorKit */
    public ProtegeParserFactory(OWLEditorKit owlEditorKit) {
        if (owlEditorKit == null) {
            throw new NullPointerException("The OWL editor kit cannot be null");
        }
        this.owlEditorKit = owlEditorKit;
        protegeOWLEntityChecker = new ProtegeOWLEntityChecker();
        protegeEntityFinder = new ProtegeEntityFinder();
        entityRenderer = new ProtegeOWLEntityRenderer();
    }

    @Override
    public OPPLPatternParser build(ErrorListener errorListener) {
        SymbolTableFactory<OPPLPatternsSymbolTable> symbolTableFactory = new ProtegeSymbolTableFactory();
        return new OPPLPatternParser(getPatternFactory(), errorListener,
                symbolTableFactory);
    }

    @Override
    public OPPLPatternParser build(Collection<? extends String> visitedPatterns,
            ErrorListener errorListener) {
        SymbolTableFactory<OPPLPatternsSymbolTable> symbolTableFactory = new ProtegeSymbolTableFactory();
        return new OPPLPatternParser(getPatternFactory(), errorListener,
                symbolTableFactory, new VisitedPatternReferenceResolver(visitedPatterns));
    }

    @Override
    public AbstractPatternModelFactory getPatternFactory() {
        return new ProtegePatternModelFactory(getOWLEditorKit().getModelManager());
    }

    /** @return the owlEditorKit */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    /** @return entity finder */
    public EntityFinder getEntityFinder() {
        return protegeEntityFinder;
    }

    /** @return rntity checker */
    public OWLEntityChecker getOWLEntityChecker() {
        return protegeOWLEntityChecker;
    }

    /** @return the entityRenderer */
    public ShortFormEntityRenderer getEntityRenderer() {
        return entityRenderer;
    }

    /** @param owlEditorKit
     * @return protege parser factory */
    public static ProtegeParserFactory getInstance(OWLEditorKit owlEditorKit) {
        if (owlEditorKit == null) {
            throw new NullPointerException("The OWLEditorKit cannot be null");
        }
        if (instance == null) {
            instance = new ProtegeParserFactory(owlEditorKit);
        }
        return instance;
    }

    /** @return error listener */
    public static ErrorListener getDefaultErrorListener() {
        Logger logger = Logger.getLogger("org.coode.patterns.protege");
        return new LoggerErrorListener(logger);
    }
}
