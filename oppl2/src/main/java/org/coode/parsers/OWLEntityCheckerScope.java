package org.coode.parsers;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Scope based on an OWLEntityChecker instance. All the symbols are derived from
 * the entities recognised by the OWLEntityChecker.
 * 
 * @author Luigi Iannone
 */
@SuppressWarnings("incomplete-switch")
public class OWLEntityCheckerScope implements Scope {

    private final DisposableOWLEntityChecker owlEntityChecker;
    private final EntityFinder entityFinder;
    private final OWLEntityRenderer owlEntityRenderer;

    /**
     * @param owlEntityChecker
     *        owlEntityChecker
     * @param entityFinder
     *        entityFinder
     * @param owlEntityRenderer
     *        owlEntityRenderer
     */
    public OWLEntityCheckerScope(DisposableOWLEntityChecker owlEntityChecker,
        EntityFinder entityFinder, OWLEntityRenderer owlEntityRenderer) {
        this.owlEntityChecker = checkNotNull(owlEntityChecker, "owlEntityChecker");
        this.entityFinder = checkNotNull(entityFinder, "entityFinder");
        this.owlEntityRenderer = checkNotNull(owlEntityRenderer, "owlEntityRenderer");
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
                            owlEntity = getOWLEntityChecker().getOWLAnnotationProperty(
                                name);
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
        Set<Symbol> toReturn = new HashSet<>();
        Set<OWLEntity> entities = getEntityFinder().getEntities(
            checkNotNull(prefix, "prefix"));
        for (OWLEntity owlEntity : entities) {
            toReturn.add(new OWLEntitySymbol(getOWLEntityRenderer().render(owlEntity),
                owlEntity));
        }
        return toReturn;
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
        Set<OWLEntity> entities = getEntityFinder().getEntities("");
        Set<Symbol> toReturn = new HashSet<>(entities.size());
        for (OWLEntity owlEntity : entities) {
            toReturn.add(new OWLEntitySymbol(getOWLEntityRenderer().render(owlEntity),
                owlEntity));
        }
        return toReturn;
    }

    @Override
    public Set<Symbol> getAllSymbols(Type type) {
        Set<OWLEntity> entities = type.accept(new TypeVisitorEx<Set<OWLEntity>>() {

            @Override
            public Set<OWLEntity> visitOWLAxiomType(OWLAxiomType owlAxiomType) {
                return Collections.emptySet();
            }

            @Override
            public Set<OWLEntity> visitNonOWLType(Type t) {
                return Collections.emptySet();
            }

            @Override
            public Set<OWLEntity> visitOWLType(OWLType owlType) {
                Set<OWLEntity> toReturn = new HashSet<>();
                switch (owlType) {
                    case OWL_CLASS:
                        toReturn.addAll(OWLEntityCheckerScope.this.getEntityFinder()
                            .getMatchingOWLClasses("*"));
                        break;
                    case OWL_DATA_PROPERTY:
                        toReturn.addAll(OWLEntityCheckerScope.this.getEntityFinder()
                            .getMatchingOWLDataProperties("*"));
                        break;
                    case OWL_OBJECT_PROPERTY:
                        toReturn.addAll(OWLEntityCheckerScope.this.getEntityFinder()
                            .getMatchingOWLObjectProperties("*"));
                        break;
                    case OWL_INDIVIDUAL:
                        toReturn.addAll(OWLEntityCheckerScope.this.getEntityFinder()
                            .getMatchingOWLIndividuals("*"));
                        break;
                    default:
                        break;
                }
                return toReturn;
            }
        });
        Set<Symbol> toReturn = new HashSet<>(entities.size());
        for (OWLEntity owlEntity : entities) {
            toReturn.add(new OWLEntitySymbol(getOWLEntityRenderer().render(owlEntity),
                owlEntity));
        }
        return toReturn;
    }

    @Override
    public void dispose() {
        getOWLEntityChecker().dispose();
    }
}
