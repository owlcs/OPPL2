package org.coode.owl.structural.position.test;

import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.Variable;
import org.coode.oppl.utils.PositionBasedVariableComparator;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class VariableExtractorSortVariablesTest {
    @Test
    public void testVariableExtractor() throws Exception {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = manager.createOntology();
        OWLDataFactory dataFactory = manager.getOWLDataFactory();
        OPPLFactory opplFactory = new OPPLFactory(manager, ontology, null);
        ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
        Variable<?> x = constraintSystem.createVariable("?x",
                VariableTypeFactory.getCLASSVariableType(), null);
        Variable<?> y = constraintSystem.createVariable("?y",
                VariableTypeFactory.getOBJECTPROPERTYTypeVariableType(), null);
        Variable<?> z = constraintSystem.createVariable("?z",
                VariableTypeFactory.getCLASSVariableType(), null);
        OWLClass xClass = dataFactory.getOWLClass(x.getIRI());
        OWLClass zClass = dataFactory.getOWLClass(z.getIRI());
        OWLObjectProperty yObjectProperty = dataFactory.getOWLObjectProperty(y.getIRI());
        OWLObjectIntersectionOf xANDySOMEx = dataFactory.getOWLObjectIntersectionOf(
                xClass, dataFactory.getOWLObjectSomeValuesFrom(yObjectProperty, xClass));
        OWLObjectIntersectionOf xANDySOMEz = dataFactory.getOWLObjectIntersectionOf(
                xClass, dataFactory.getOWLObjectSomeValuesFrom(yObjectProperty, zClass));
        VariableExtractor variableExtractor = new VariableExtractor(constraintSystem,
                false);
        Set<Variable<?>> variables = variableExtractor.extractVariables(xANDySOMEx);
        assertTrue(variables.size() == 2);
        PositionBasedVariableComparator positionBasedVariableComparator = new PositionBasedVariableComparator(
                xANDySOMEx, dataFactory);
        SortedSet<Variable<?>> sortedVariables = new TreeSet<Variable<?>>(
                positionBasedVariableComparator);
        sortedVariables.addAll(variables);
        assertTrue(sortedVariables.size() == 2);
        assertTrue(sortedVariables.first().equals(x));
        assertTrue(sortedVariables.last().equals(y));
        OWLObjectIntersectionOf xANDySOMExANDySOMEz = dataFactory
                .getOWLObjectIntersectionOf(xClass, xANDySOMEx, xANDySOMEz);
        variables = variableExtractor.extractVariables(xANDySOMExANDySOMEz);
        positionBasedVariableComparator = new PositionBasedVariableComparator(
                xANDySOMExANDySOMEz, dataFactory);
        sortedVariables = new TreeSet<Variable<?>>(positionBasedVariableComparator);
        sortedVariables.addAll(variables);
        assertTrue(sortedVariables.size() == 3);
        assertTrue(sortedVariables.first().equals(x));
        assertTrue(sortedVariables.last().equals(z));
    }
}
