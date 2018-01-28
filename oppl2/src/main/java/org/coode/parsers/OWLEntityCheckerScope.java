package org.coode.parsers;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.Set;
import java.util.stream.Stream;

import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Scope based on an OWLEntityChecker instance. All the symbols are derived from the entities
 * recognised by the OWLEntityChecker.
 * 
 * @author Luigi Iannone
 */
@SuppressWarnings("incomplete-switch")
public class OWLEntityCheckerScope implements Scope {

    static class VariableFinder implements TypeVisitorEx<Stream<Symbol>> {
        private OWLEntityRenderer renderer;
        private EntityFinder finder;

        public VariableFinder(EntityFinder f, OWLEntityRenderer r) {
            finder = f;
            renderer = r;
        }

        @Override
        public Stream<Symbol> visitOWLAxiomType(OWLAxiomType owlAxiomType) {
            return Stream.empty();
        }

        @Override
        public Stream<Symbol> visitNonOWLType(Type t) {
            return Stream.empty();
        }

        @Override
        public Stream<Symbol> visitOWLType(OWLType owlType) {
            switch (owlType) {
                case OWL_CLASS:
                    return finder.getMatchingOWLClasses("*").stream()
                        .map(o -> new OWLEntitySymbol(renderer.render(o), o));
                case OWL_DATA_PROPERTY:
                    return finder.getMatchingOWLDataProperties("*").stream()
                        .map(o -> new OWLEntitySymbol(renderer.render(o), o));
                case OWL_OBJECT_PROPERTY:
                    return finder.getMatchingOWLObjectProperties("*").stream()
                        .map(o -> new OWLEntitySymbol(renderer.render(o), o));
                case OWL_INDIVIDUAL:
                    return finder.getMatchingOWLIndividuals("*").stream()
                        .map(o -> new OWLEntitySymbol(renderer.render(o), o));
                default:
                    break;
            }
            return Stream.empty();
        }
    }

    private final DisposableOWLEntityChecker owlEntityChecker;
    private final EntityFinder entityFinder;
    private final OWLEntityRenderer owlEntityRenderer;
    private final VariableFinder finder;

    /**
     * @param owlEntityChecker owlEntityChecker
     * @param entityFinder entityFinder
     * @param owlEntityRenderer owlEntityRenderer
     */
    public OWLEntityCheckerScope(DisposableOWLEntityChecker owlEntityChecker,
        EntityFinder entityFinder, OWLEntityRenderer owlEntityRenderer) {
        this.owlEntityChecker = checkNotNull(owlEntityChecker, "owlEntityChecker");
        this.entityFinder = checkNotNull(entityFinder, "entityFinder");
        this.owlEntityRenderer = checkNotNull(owlEntityRenderer, "owlEntityRenderer");
        finder = new VariableFinder(entityFinder, owlEntityRenderer);
    }

    @Override
    public void define(Symbol symbol) {
        // Cannot define new symbols
    }

    @Override
    public Scope getEnclosingScope() {
        return null;
    }

    @Override
    public String getScopeName() {
        return "global";
    }

    @Override
    public Symbol resolve(String name) {
        Symbol toReturn = null;
        OWLEntity owlEntity = getOWLEntityChecker().getOWLClass(name);
        if (owlEntity != null) {
            toReturn = new OWLEntitySymbol(name, owlEntity);
        } else {
            owlEntity = getOWLEntityChecker().getOWLDataProperty(name);
            if (owlEntity != null) {
                toReturn = new OWLEntitySymbol(name, owlEntity);
            } else {
                owlEntity = getOWLEntityChecker().getOWLObjectProperty(name);
                if (owlEntity != null) {
                    toReturn = new OWLEntitySymbol(name, owlEntity);
                } else {
                    owlEntity = getOWLEntityChecker().getOWLIndividual(name);
                    if (owlEntity != null) {
                        toReturn = new OWLEntitySymbol(name, owlEntity);
                    } else {
                        owlEntity = getOWLEntityChecker().getOWLDatatype(name);
                        if (owlEntity != null) {
                            toReturn = new OWLEntitySymbol(name, owlEntity);
                        } else {
                            owlEntity = getOWLEntityChecker().getOWLAnnotationProperty(name);
                            if (owlEntity != null) {
                                toReturn = new OWLEntitySymbol(name, owlEntity);
                            }
                        }
                    }
                }
            }
        }
        return toReturn;
    }

    @Override
    public Set<Symbol> match(String prefix) {
        return asSet(getEntityFinder().getEntities(checkNotNull(prefix, "prefix")).stream()
            .map(o -> new OWLEntitySymbol(getOWLEntityRenderer().render(o), o)));
    }

    /**
     * @return the owlEntityChecker
     */
    public DisposableOWLEntityChecker getOWLEntityChecker() {
        return owlEntityChecker;
    }

    /**
     * @return the entityFinder
     */
    public EntityFinder getEntityFinder() {
        return entityFinder;
    }

    /**
     * @return the owlEntityRenderer
     */
    public OWLEntityRenderer getOWLEntityRenderer() {
        return owlEntityRenderer;
    }

    @Override
    public Set<Symbol> getAllSymbols() {
        return asSet(getEntityFinder().getEntities("").stream()
            .map(o -> new OWLEntitySymbol(getOWLEntityRenderer().render(o), o)));
    }

    @Override
    public Set<Symbol> getAllSymbols(Type type) {
        return asSet(type.accept(finder));
    }

    @Override
    public void dispose() {
        getOWLEntityChecker().dispose();
    }
}
