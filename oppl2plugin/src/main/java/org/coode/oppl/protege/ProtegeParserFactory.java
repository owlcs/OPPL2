package org.coode.oppl.protege;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Set;

import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLParser;
import org.coode.oppl.OPPLParser.AbstractParserFactory;
import org.coode.parsers.DisposableOWLEntityChecker;
import org.coode.parsers.DisposableShortFormEntityChecker;
import org.coode.parsers.EntityFinder;
import org.coode.parsers.ErrorListener;
import org.coode.parsers.ShortFormEntityRenderer;
import org.coode.parsers.factory.SymbolTableFactory;
import org.coode.parsers.oppl.OPPLScope;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.protege.editor.core.Disposable;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;

/**
 * @author Luigi Iannone
 */
public class ProtegeParserFactory implements AbstractParserFactory, Disposable {

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

    private class ProtegeSymbolTableFactory implements
        SymbolTableFactory<OPPLSymbolTable> {

        public ProtegeSymbolTableFactory() {}

        @Override
        public OPPLSymbolTable createSymbolTable() {
            DisposableOWLEntityChecker entityChecker = new DisposableShortFormEntityChecker(
                getOWLEntityChecker());
            EntityFinder entityFinder = getEntityFinder();
            return new OPPLSymbolTable(new OPPLScope(entityChecker, entityFinder,
                entityRenderer), getOWLEditorKit().getOWLModelManager()
                    .getOWLDataFactory());
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

    private static ProtegeParserFactory instance = null;
    private final OWLEditorKit owlEditorKit;
    private final ProtegeOWLEntityChecker protegeOWLEntityChecker;
    private final EntityFinder protegeEntityFinder;
    private final OPPLAbstractFactory opplFactory;
    protected final ShortFormEntityRenderer entityRenderer;
    private static final OWLModelManagerListener modelManagerListener = new OWLModelManagerListener() {

        @Override
        public void handleChange(OWLModelManagerChangeEvent event) {
            reset();
        }
    };

    /**
     * @param owlEditorKit
     *        owlEditorKit
     */
    private ProtegeParserFactory(OWLEditorKit owlEditorKit) {
        assert owlEditorKit != null;
        this.owlEditorKit = owlEditorKit;
        this.owlEditorKit.getOWLModelManager().addListener(modelManagerListener);
        protegeOWLEntityChecker = new ProtegeOWLEntityChecker(getOWLEditorKit());
        protegeEntityFinder = new ProtegeEntityFinder();
        opplFactory = new ProtegeOPPLFactory(getOWLEditorKit());
        entityRenderer = new ProtegeOWLEntityRenderer();
        this.owlEditorKit.put("ProtegeParserFactory", this);
    }

    @Override
    public OPPLParser build(ErrorListener errorListener) {
        SymbolTableFactory<OPPLSymbolTable> symbolTableFactory = new ProtegeSymbolTableFactory();
        OPPLParser parser = new OPPLParser(getOPPLFactory(), errorListener,
            symbolTableFactory);
        return parser;
    }

    /**
     * @param owlEditorKit
     *        owlEditorKit
     * @return parser factory
     */
    public static ProtegeParserFactory getInstance(OWLEditorKit owlEditorKit) {
        if (instance == null) {
            instance = new ProtegeParserFactory(
                checkNotNull(owlEditorKit, "owlEditorKit"));
        }
        return instance;
    }

    /**
     * @return the owlEditorKit
     */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    /**
     * @return entity checker
     */
    public OWLEntityChecker getOWLEntityChecker() {
        return protegeOWLEntityChecker;
    }

    /**
     * @return entity finder
     */
    public EntityFinder getEntityFinder() {
        return protegeEntityFinder;
    }

    /**
     * @return the opplFactory
     */
    @Override
    public OPPLAbstractFactory getOPPLFactory() {
        return opplFactory;
    }

    /**
     * @return the entityRenderer
     */
    public ShortFormEntityRenderer getEntityRenderer() {
        return entityRenderer;
    }

    @Override
    public void dispose() {
        owlEditorKit.getOWLModelManager().removeListener(modelManagerListener);
        reset();
    }

    /**
     * 
     */
    public static void reset() {
        instance = null;
    }
}
