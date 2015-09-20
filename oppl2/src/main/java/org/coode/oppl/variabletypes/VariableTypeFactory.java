package org.coode.oppl.variabletypes;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;

/**
 * @author Luigi Iannone
 */
public class VariableTypeFactory {

    private static final EnumMap<VariableTypeName, VariableType<?>> typesCache = new EnumMap<>(
        VariableTypeName.class);

    static {
        typesCache.put(VariableTypeName.CLASS, new CLASSVariableType(
            VariableTypeName.CLASS));
        typesCache.put(VariableTypeName.OBJECTPROPERTY, new OBJECTPROPERTYVariableType(
            VariableTypeName.OBJECTPROPERTY));
        typesCache.put(VariableTypeName.DATAPROPERTY, new DATAPROPERTYVariableType(
            VariableTypeName.DATAPROPERTY));
        typesCache.put(VariableTypeName.ANNOTATIONPROPERTY,
            new ANNOTATIONPROPERTYVariableType(VariableTypeName.ANNOTATIONPROPERTY));
        typesCache.put(VariableTypeName.INDIVIDUAL, new INDIVIDUALVariableType(
            VariableTypeName.INDIVIDUAL));
        typesCache.put(VariableTypeName.CONSTANT, new CONSTANTVariableType(
            VariableTypeName.CONSTANT));
    }

    /**
     * @param owlObject
     *        owlObject
     * @return variable type
     */
    public static VariableType<?> getVariableType(OWLObject owlObject) {
        return owlObject.accept(new OWLObjectVisitorExAdapter<VariableType<?>>(null) {

            @Override
            public VariableType<OWLClassExpression> visit(OWLClass ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLObjectIntersectionOf ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLObjectUnionOf ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLObjectComplementOf ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLObjectSomeValuesFrom ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLObjectAllValuesFrom ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLObjectHasValue ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLObjectMinCardinality ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLObjectExactCardinality ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLObjectMaxCardinality ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLObjectHasSelf ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLObjectOneOf ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLDataSomeValuesFrom ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLDataAllValuesFrom ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLDataHasValue ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLDataMinCardinality ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLDataExactCardinality ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLClassExpression> visit(OWLDataMaxCardinality ce) {
                return VariableTypeFactory.getCLASSVariableType();
            }

            @Override
            public VariableType<OWLDataPropertyExpression> visit(OWLDataProperty property) {
                return VariableTypeFactory.getDATAPROPERTYVariableType();
            }

            @Override
            public VariableType<OWLObjectPropertyExpression> visit(
                OWLObjectProperty property) {
                return VariableTypeFactory.getOBJECTPROPERTYTypeVariableType();
            }

            @Override
            public VariableType<OWLObjectPropertyExpression> visit(
                OWLObjectInverseOf property) {
                return VariableTypeFactory.getOBJECTPROPERTYTypeVariableType();
            }

            @Override
            public VariableType<OWLIndividual> visit(OWLAnonymousIndividual individual) {
                return VariableTypeFactory.getINDIVIDUALVariableType();
            }

            @Override
            public VariableType<OWLIndividual> visit(OWLNamedIndividual individual) {
                return VariableTypeFactory.getINDIVIDUALVariableType();
            }

            @Override
            public VariableType<OWLLiteral> visit(OWLLiteral literal) {
                return VariableTypeFactory.getCONSTANTVariableType();
            }

            @Override
            public VariableType<?> visit(OWLAnnotationProperty property) {
                return VariableTypeFactory.getANNOTATIONPROPERTYVariableType();
            }
        });
    }

    /**
     * @return variable type
     */
    @SuppressWarnings("unchecked")
    public static VariableType<OWLClassExpression> getCLASSVariableType() {
        return (VariableType<OWLClassExpression>) getVariableType(VariableTypeName.CLASS);
    }

    /**
     * @return variable type
     */
    @SuppressWarnings("unchecked")
    public static VariableType<OWLObjectPropertyExpression> getOBJECTPROPERTYTypeVariableType() {
        return (VariableType<OWLObjectPropertyExpression>) getVariableType(VariableTypeName.OBJECTPROPERTY);
    }

    /**
     * @return variable type
     */
    @SuppressWarnings("unchecked")
    public static VariableType<OWLDataPropertyExpression> getDATAPROPERTYVariableType() {
        return (VariableType<OWLDataPropertyExpression>) getVariableType(VariableTypeName.DATAPROPERTY);
    }

    /**
     * @return variable type
     */
    @SuppressWarnings("unchecked")
    public static VariableType<OWLAnnotationProperty> getANNOTATIONPROPERTYVariableType() {
        return (VariableType<OWLAnnotationProperty>) getVariableType(VariableTypeName.ANNOTATIONPROPERTY);
    }

    /**
     * @return variable type
     */
    @SuppressWarnings("unchecked")
    public static VariableType<OWLIndividual> getINDIVIDUALVariableType() {
        return (VariableType<OWLIndividual>) getVariableType(VariableTypeName.INDIVIDUAL);
    }

    /**
     * @return variable type
     */
    @SuppressWarnings("unchecked")
    public static VariableType<OWLLiteral> getCONSTANTVariableType() {
        return (VariableType<OWLLiteral>) getVariableType(VariableTypeName.CONSTANT);
    }

    /**
     * @param variableTypeName
     *        variableTypeName
     * @return variable type
     */
    public static VariableType<?> getVariableType(VariableTypeName variableTypeName) {
        return variableTypeName == null ? null : typesCache.get(variableTypeName);
    }

    /**
     * @param variableTypeName
     *        variableTypeName
     * @return variable type
     */
    public static VariableType<?> getVariableType(String variableTypeName) {
        return getVariableType(VariableTypeName.getVariableTypeName(variableTypeName));
    }

    /**
     * @return set of variable type
     */
    public static Set<VariableType<?>> getAllVariableTypes() {
        Set<VariableType<?>> toReturn = new HashSet<>();
        toReturn.add(getANNOTATIONPROPERTYVariableType());
        toReturn.add(getCONSTANTVariableType());
        toReturn.add(getDATAPROPERTYVariableType());
        toReturn.add(getOBJECTPROPERTYTypeVariableType());
        toReturn.add(getCLASSVariableType());
        toReturn.add(getINDIVIDUALVariableType());
        return toReturn;
    }
}
