/**
 * 
 */
package org.coode.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/** Helper class providing Strings for the autocompletion
 * 
 * @author Luigi Iannone */
public class AutoCompleteStrings {
    public final static String SUBCLASS_OF = "subClassOf";
    public final static String EQUIVALENT_TO = "equivalentTo";
    public final static String SUB_PROPERTY_OF = "subPropertyOf";
    public final static String SAME_AS = "sameAs";
    public final static String DIFFERENT_FROM = "differentFrom";
    public final static String INVERSE_OF = "InverseOf";
    public final static String DISJOINT_WITH = "DisjointWith";
    public final static String INVERSE_FUNCTIONAL = "InverseFunctional";
    public final static String INSTANCE_OF = "InstanceOf";
    public final static String TYPES = "types";
    public final static String AND = "and";
    public final static String OR = "or";
    public final static String NOT = "not";
    public final static String SOME = "some";
    public final static String ONLY = "only";
    public final static String MIN = "min";
    public final static String MAX = "max";
    public final static String EXACTLY = "exactly";
    public final static String VALUE = "value";
    public final static String INVERSE = "INV";
    public final static String DOMAIN = "Domain";
    public final static String RANGE = "Range";
    public final static String FUNCTIONAL = "Functional";
    public final static String SYMMETRIC = "Symmetric";
    public final static String ANTI_SYMMETRIC = "AntiSymmetric";
    public final static String REFLEXIVE = "Reflexive";
    public final static String IRREFLEXIVE = "Irreflexive";
    public final static String TRANSITIVE = "Transitive";

    public static List<String> getStandaloneClassExpressionCompletions() {
        List<String> toReturn = new ArrayList<String>(Arrays.asList(SUBCLASS_OF,
                EQUIVALENT_TO, DISJOINT_WITH));
        toReturn.addAll(getClassExpressionCompletions());
        return toReturn;
    }

    public static List<String> getIncompleteClassExpressionCompletions(
            String incompleteText) {
        List<String> toReturn = new ArrayList<String>(Arrays.asList(SUBCLASS_OF,
                EQUIVALENT_TO, DISJOINT_WITH));
        toReturn.addAll(getClassExpressionCompletions());
        filter(incompleteText, toReturn);
        return toReturn;
    }

    /** @param incompleteText
     * @param c */
    private static void filter(String incompleteText, Collection<? extends String> c) {
        Iterator<? extends String> iterator = c.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            if (!string.startsWith(incompleteText)) {
                iterator.remove();
            }
        }
    }

    public static List<String> getStandalonePropertyCompletions() {
        List<String> toReturn = new ArrayList<String>(Arrays.asList(SUB_PROPERTY_OF,
                EQUIVALENT_TO, DISJOINT_WITH, INVERSE_OF));
        toReturn.addAll(getPropertyCompletions());
        return toReturn;
    }

    public static List<String> getIncompletePropertyCompletions(String incompleteText) {
        List<String> toReturn = new ArrayList<String>(Arrays.asList(SUB_PROPERTY_OF,
                EQUIVALENT_TO, DISJOINT_WITH, INVERSE_OF));
        toReturn.addAll(getPropertyCompletions());
        filter(incompleteText, toReturn);
        return toReturn;
    }

    public static List<String> getPropertyCompletions() {
        List<String> toReturn = new ArrayList<String>(Arrays.asList(SOME, ONLY, MIN, MAX,
                EXACTLY, VALUE));
        return toReturn;
    }

    public static List<String> getClassExpressionCompletions() {
        List<String> toReturn = new ArrayList<String>(Arrays.asList(AND, OR));
        return toReturn;
    }

    public static List<String> getStandaloneIndividualCompletions() {
        List<String> toReturn = new ArrayList<String>(Arrays.asList(DIFFERENT_FROM,
                SAME_AS));
        return toReturn;
    }

    public static List<String> getIncompleteIndividualCompletions(String incompleteText) {
        List<String> toReturn = new ArrayList<String>(Arrays.asList(DIFFERENT_FROM,
                SAME_AS));
        filter(incompleteText, toReturn);
        return toReturn;
    }

    public static List<String> getStandaloneExpressionCompletions(Type type) {
        final List<String> toReturn = new ArrayList<String>();
        if (type != null) {
            type.accept(new TypeVisitor() {
                @Override
                public void visitOWLType(OWLType owlType) {
                    if (OWLType.isClassExpression(owlType)) {
                        toReturn.addAll(getStandaloneClassExpressionCompletions());
                    } else if (OWLType.isObjectPropertyExpression(owlType)) {
                        toReturn.addAll(getStandalonePropertyCompletions());
                    } else if (owlType == OWLType.OWL_DATA_PROPERTY) {
                        toReturn.addAll(getStandalonePropertyCompletions());
                    } else if (owlType == OWLType.OWL_INDIVIDUAL) {
                        toReturn.addAll(getStandaloneIndividualCompletions());
                    }
                }

                @Override
                public void visitNonOWLType(Type type) {}

                @Override
                public void visitOWLAxiomType(OWLAxiomType owlAxiomType) {}
            });
        }
        return toReturn;
    }

    public static List<String> getIncompleteExpressionCompletions(
            final String incompleteText, Type type) {
        final List<String> toReturn = new ArrayList<String>();
        if (type != null) {
            type.accept(new TypeVisitor() {
                @Override
                public void visitOWLType(OWLType owlType) {
                    if (OWLType.isClassExpression(owlType)) {
                        toReturn.addAll(getIncompleteClassExpressionCompletions(incompleteText));
                    } else if (OWLType.isObjectPropertyExpression(owlType)) {
                        toReturn.addAll(getIncompletePropertyCompletions(incompleteText));
                    } else if (owlType == OWLType.OWL_DATA_PROPERTY) {
                        toReturn.addAll(getIncompletePropertyCompletions(incompleteText));
                    } else if (owlType == OWLType.OWL_INDIVIDUAL) {
                        toReturn.addAll(getIncompleteIndividualCompletions(incompleteText));
                    }
                }

                @Override
                public void visitOWLAxiomType(OWLAxiomType owlAxiomType) {}

                @Override
                public void visitNonOWLType(Type type) {}
            });
        }
        return toReturn;
    }

    public static List<String> getExpressionCompletions(Type type) {
        final List<String> toReturn = new ArrayList<String>();
        if (type != null) {
            type.accept(new TypeVisitor() {
                @Override
                public void visitOWLType(OWLType owlType) {
                    if (OWLType.isClassExpression(owlType)) {
                        toReturn.addAll(getClassExpressionCompletions());
                    } else if (OWLType.isObjectPropertyExpression(owlType)) {
                        toReturn.addAll(getPropertyCompletions());
                    } else if (owlType == OWLType.OWL_DATA_PROPERTY) {
                        toReturn.addAll(getPropertyCompletions());
                    }
                }

                @Override
                public void visitOWLAxiomType(OWLAxiomType owlAxiomType) {}

                @Override
                public void visitNonOWLType(Type type) {}
            });
        }
        return toReturn;
    }
}
