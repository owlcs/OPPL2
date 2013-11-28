package org.coode.oppl.utils;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.coode.oppl.Variable;
import org.coode.oppl.variabletypes.ANNOTATIONPROPERTYVariableType;
import org.coode.oppl.variabletypes.CLASSVariableType;
import org.coode.oppl.variabletypes.CONSTANTVariableType;
import org.coode.oppl.variabletypes.DATAPROPERTYVariableType;
import org.coode.oppl.variabletypes.INDIVIDUALVariableType;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariableType;
import org.coode.oppl.variabletypes.VariableTypeVisitorEx;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public class PositionBasedVariableComparator implements Comparator<Variable<?>> {
    private final OWLObject container;
    private final OWLDataFactory dataFactory;

    /** @param container
     * @param dataFactory */
    public PositionBasedVariableComparator(OWLObject container, OWLDataFactory dataFactory) {
        this.container = checkNotNull(container, "container");
        this.dataFactory = checkNotNull(dataFactory, "dataFactory");
    }

    @Override
    public int compare(Variable<?> aVariable, Variable<?> anotherVariable) {
        int toReturn = 0;
        if (aVariable == null) {
            if (anotherVariable != null) {
                toReturn = -1;
            }
        } else if (anotherVariable == null) {
            toReturn = 1;
        } else {
            List<List<Integer>> aVariableFindAll = OWLObjectFinder.findAll(
                    buildKey(aVariable), getContainer());
            Comparator<List<Integer>> sizeComparator = new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> aList, List<Integer> anotherList) {
                    return aList.size() - anotherList.size();
                }
            };
            List<List<Integer>> anotherVariableFindAll = OWLObjectFinder.findAll(
                    buildKey(anotherVariable), getContainer());
            Collections.sort(aVariableFindAll, Collections.reverseOrder(sizeComparator));
            Collections.sort(anotherVariableFindAll,
                    Collections.reverseOrder(sizeComparator));
            if (aVariableFindAll.isEmpty()) {
                if (anotherVariableFindAll.isEmpty()) {
                    toReturn = NameBasedVariableComparator.getInstance().compare(
                            aVariable, anotherVariable);
                } else {
                    toReturn = 1;
                }
            } else if (anotherVariableFindAll.isEmpty()) {
                toReturn = -1;
            } else {
                List<Integer> aVariableLongestPosition = aVariableFindAll.get(0);
                List<Integer> anotherVariableLongestPosition = anotherVariableFindAll
                        .get(0);
                int sizeComparison = sizeComparator.compare(aVariableLongestPosition,
                        anotherVariableLongestPosition);
                return sizeComparison == 0 ? NameBasedVariableComparator.getInstance()
                        .compare(aVariable, anotherVariable) : sizeComparison;
            }
        }
        return toReturn;
    }

    /** @return the container */
    public OWLObject getContainer() {
        return container;
    }

    private OWLObject buildKey(final Variable<?> v) {
        checkNotNull(v, "v");
        return v.getType().accept(new VariableTypeVisitorEx<OWLObject>() {
            @Override
            public OWLObject visitCLASSVariableType(CLASSVariableType classVariableType) {
                return PositionBasedVariableComparator.this.getDataFactory().getOWLClass(
                        v.getIRI());
            }

            @Override
            public OWLObject visitOBJECTPROPERTYVariableType(
                    OBJECTPROPERTYVariableType objectpropertyVariableType) {
                return PositionBasedVariableComparator.this.getDataFactory()
                        .getOWLObjectProperty(v.getIRI());
            }

            @Override
            public OWLObject visitDATAPROPERTYVariableType(
                    DATAPROPERTYVariableType datapropertyVariableType) {
                return PositionBasedVariableComparator.this.getDataFactory()
                        .getOWLDataProperty(v.getIRI());
            }

            @Override
            public OWLObject visitINDIVIDUALVariableType(
                    INDIVIDUALVariableType individualVariableType) {
                return PositionBasedVariableComparator.this.getDataFactory()
                        .getOWLNamedIndividual(v.getIRI());
            }

            @Override
            public OWLObject visitCONSTANTVariableType(
                    CONSTANTVariableType constantVariableType) {
                return PositionBasedVariableComparator.this.getDataFactory()
                        .getOWLLiteral(v.getName());
            }

            @Override
            public OWLObject visitANNOTATIONPROPERTYVariableType(
                    ANNOTATIONPROPERTYVariableType annotationpropertyVariableType) {
                return PositionBasedVariableComparator.this.getDataFactory()
                        .getOWLAnnotationProperty(v.getIRI());
            }
        });
    }

    /** @return the dataFactory */
    public OWLDataFactory getDataFactory() {
        return dataFactory;
    }
}
