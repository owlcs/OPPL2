package org.coode.owl.structural.position.test;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import junit.framework.TestCase;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.OPPLFactory;
import org.coode.oppl.Variable;
import org.coode.oppl.utils.PositionBasedVariableComparator;
import org.coode.oppl.utils.VariableExtractor;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.ToStringRenderer;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import uk.ac.manchester.cs.owl.owlapi.mansyntaxrenderer.ManchesterOWLSyntaxOWLObjectRendererImpl;

public class VariableExtractorSortVariablesTest extends TestCase {
	@Override
	protected void setUp() throws Exception {
		ToStringRenderer.getInstance().setRenderer(new ManchesterOWLSyntaxOWLObjectRendererImpl());
	}

	public void testVariableExtractor() {
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		try {
			OWLOntology ontology = manager.createOntology();
			OWLDataFactory dataFactory = manager.getOWLDataFactory();
			OPPLFactory opplFactory = new OPPLFactory(manager, ontology, null);
			ConstraintSystem constraintSystem = opplFactory.createConstraintSystem();
			Variable<?> x = constraintSystem.createVariable(
					"?x",
					VariableTypeFactory.getCLASSVariableType(),
					null);
			Variable<?> y = constraintSystem.createVariable(
					"?y",
					VariableTypeFactory.getOBJECTPROPERTYTypeVariableType(),
					null);
			Variable<?> z = constraintSystem.createVariable(
					"?z",
					VariableTypeFactory.getCLASSVariableType(),
					null);
			OWLClass xClass = dataFactory.getOWLClass(x.getIRI());
			OWLClass zClass = dataFactory.getOWLClass(z.getIRI());
			OWLObjectProperty yObjectProperty = dataFactory.getOWLObjectProperty(y.getIRI());
			OWLObjectIntersectionOf xANDySOMEx = dataFactory.getOWLObjectIntersectionOf(
					xClass,
					dataFactory.getOWLObjectSomeValuesFrom(yObjectProperty, xClass));
			OWLObjectIntersectionOf xANDySOMEz = dataFactory.getOWLObjectIntersectionOf(
					xClass,
					dataFactory.getOWLObjectSomeValuesFrom(yObjectProperty, zClass));
			VariableExtractor variableExtractor = new VariableExtractor(constraintSystem, false);
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
			System.out.println(sortedVariables);
			OWLObjectIntersectionOf xANDySOMExANDySOMEz = dataFactory.getOWLObjectIntersectionOf(
					xClass,
					xANDySOMEx,
					xANDySOMEz);
			variables = variableExtractor.extractVariables(xANDySOMExANDySOMEz);
			positionBasedVariableComparator = new PositionBasedVariableComparator(
					xANDySOMExANDySOMEz, dataFactory);
			sortedVariables = new TreeSet<Variable<?>>(positionBasedVariableComparator);
			sortedVariables.addAll(variables);
			assertTrue(sortedVariables.size() == 3);
			assertTrue(sortedVariables.first().equals(x));
			assertTrue(sortedVariables.last().equals(z));
			System.out.println(sortedVariables);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}