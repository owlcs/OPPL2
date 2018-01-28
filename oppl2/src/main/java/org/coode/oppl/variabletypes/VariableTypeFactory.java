package org.coode.oppl.variabletypes;

import static org.coode.oppl.variabletypes.VariableTypeName.ANNOTATIONPROPERTY;
import static org.coode.oppl.variabletypes.VariableTypeName.CLASS;
import static org.coode.oppl.variabletypes.VariableTypeName.CONSTANT;
import static org.coode.oppl.variabletypes.VariableTypeName.DATAPROPERTY;
import static org.coode.oppl.variabletypes.VariableTypeName.INDIVIDUAL;
import static org.coode.oppl.variabletypes.VariableTypeName.OBJECTPROPERTY;
import static org.coode.oppl.variabletypes.VariableTypeName.getVariableTypeName;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectInverseOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;

/**
 * @author Luigi Iannone
 */
public class VariableTypeFactory {

    private static final EnumMap<VariableTypeName, VariableType<?>> typesCache = cache();
    private static final Set<VariableType<?>> allTypes =
        Collections.unmodifiableSet(new HashSet<>(typesCache.values()));

    static EnumMap<VariableTypeName, VariableType<?>> cache() {
        EnumMap<VariableTypeName, VariableType<?>> map = new EnumMap<>(VariableTypeName.class);
        map.put(CLASS, new CLASSVariableType(CLASS));
        map.put(OBJECTPROPERTY, new OBJECTPROPERTYVariableType(OBJECTPROPERTY));
        map.put(DATAPROPERTY, new DATAPROPERTYVariableType(DATAPROPERTY));
        map.put(ANNOTATIONPROPERTY, new ANNOTATIONPROPERTYVariableType(ANNOTATIONPROPERTY));
        map.put(INDIVIDUAL, new INDIVIDUALVariableType(INDIVIDUAL));
        map.put(CONSTANT, new CONSTANTVariableType(CONSTANT));
        return map;
    }

    /**
     * @param owlObject owlObject
     * @return variable type
     */
    public static VariableType<?> getVariableType(OWLObject owlObject) {
        return owlObject.accept(new OWLObjectVisitorEx<VariableType<?>>() {

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
            public VariableType<OWLObjectPropertyExpression> visit(OWLObjectProperty property) {
                return VariableTypeFactory.getOBJECTPROPERTYTypeVariableType();
            }

            @Override
            public VariableType<OWLObjectPropertyExpression> visit(OWLObjectInverseOf property) {
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
        return (VariableType<OWLClassExpression>) getVariableType(CLASS);
    }

    /**
     * @return variable type
     */
    @SuppressWarnings("unchecked")
    public static VariableType<OWLObjectPropertyExpression> getOBJECTPROPERTYTypeVariableType() {
        return (VariableType<OWLObjectPropertyExpression>) getVariableType(OBJECTPROPERTY);
    }

    /**
     * @return variable type
     */
    @SuppressWarnings("unchecked")
    public static VariableType<OWLDataPropertyExpression> getDATAPROPERTYVariableType() {
        return (VariableType<OWLDataPropertyExpression>) getVariableType(DATAPROPERTY);
    }

    /**
     * @return variable type
     */
    @SuppressWarnings("unchecked")
    public static VariableType<OWLAnnotationProperty> getANNOTATIONPROPERTYVariableType() {
        return (VariableType<OWLAnnotationProperty>) getVariableType(ANNOTATIONPROPERTY);
    }

    /**
     * @return variable type
     */
    @SuppressWarnings("unchecked")
    public static VariableType<OWLIndividual> getINDIVIDUALVariableType() {
        return (VariableType<OWLIndividual>) getVariableType(INDIVIDUAL);
    }

    /**
     * @return variable type
     */
    @SuppressWarnings("unchecked")
    public static VariableType<OWLLiteral> getCONSTANTVariableType() {
        return (VariableType<OWLLiteral>) getVariableType(CONSTANT);
    }

    /**
     * @param variableTypeName variableTypeName
     * @return variable type
     */
    public static VariableType<?> getVariableType(VariableTypeName variableTypeName) {
        return variableTypeName == null ? null : typesCache.get(variableTypeName);
    }

    /**
     * @param variableTypeName variableTypeName
     * @return variable type
     */
    public static VariableType<?> getVariableType(String variableTypeName) {
        return getVariableType(getVariableTypeName(variableTypeName));
    }

    /**
     * @return set of variable type
     */
    public static Set<VariableType<?>> getAllVariableTypes() {
        return allTypes;
    }
}
