package org.coode.owl.structural.position.test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.coode.oppl.Variable;
import org.coode.oppl.utils.OWLObjectFinder;
import org.coode.oppl.utils.Position;
import org.coode.oppl.variabletypes.VariableFactory;
import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntologyManager;

@SuppressWarnings("javadoc")
public class OWLObjectFinderTest {
    @Test
    public void shouldTestFindAll() {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLDataFactory dataFactory = manager.getOWLDataFactory();
        OWLClass a = dataFactory.getOWLClass(IRI.create("blah#A"));
        OWLClass b = dataFactory.getOWLClass(IRI.create("blah#B"));
        OWLObjectProperty p = dataFactory.getOWLObjectProperty(IRI.create("blah#p"));
        OWLObjectIntersectionOf aANDb = dataFactory.getOWLObjectIntersectionOf(a, b);
        OWLObjectIntersectionOf aANDpSOMEa = dataFactory.getOWLObjectIntersectionOf(a,
                dataFactory.getOWLObjectSomeValuesFrom(p, a));
        List<List<Integer>> findAll = OWLObjectFinder.findAll(a, aANDb);
        assertTrue(findAll.size() == 1);
        for (List<Integer> position : findAll) {
            assertTrue(Position.get(aANDb, position).equals(a));
        }
        assertTrue(findAll.get(0).equals(Arrays.<Integer> asList(1)));
        findAll = OWLObjectFinder.findAll(b, aANDb);
        assertTrue(findAll.size() == 1);
        for (List<Integer> position : findAll) {
            assertTrue(Position.get(aANDb, position).equals(b));
        }
        assertTrue(findAll.get(0).equals(Arrays.<Integer> asList(2)));
        findAll = OWLObjectFinder.findAll(aANDb, aANDb);
        assertTrue(findAll.size() == 1);
        for (List<Integer> position : findAll) {
            assertTrue(Position.get(aANDb, position).equals(aANDb));
        }
        assertTrue(findAll.get(0).equals(Arrays.<Integer> asList(0)));
        findAll = OWLObjectFinder.findAll(a, aANDpSOMEa);
        assertTrue(findAll.size() == 2);
        for (List<Integer> position : findAll) {
            assertTrue(Position.get(aANDpSOMEa, position).equals(a));
        }
    }

    @Test
    public void shouldTestFindAllNoResults() {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLDataFactory dataFactory = manager.getOWLDataFactory();
        OWLClass a = dataFactory.getOWLClass(IRI.create("blah#A"));
        OWLClass b = dataFactory.getOWLClass(IRI.create("blah#B"));
        OWLClass c = dataFactory.getOWLClass(IRI.create("blah#C"));
        OWLObjectIntersectionOf aANDb = dataFactory.getOWLObjectIntersectionOf(a, b);
        List<List<Integer>> findAll = OWLObjectFinder.findAll(c, aANDb);
        assertTrue(findAll.size() == 0);
    }

    @Test
    public void shouldTestFindAllVariable() {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLDataFactory dataFactory = manager.getOWLDataFactory();
        OWLClass a = dataFactory.getOWLClass(IRI.create("blah#A"));
        OWLClass b = dataFactory.getOWLClass(IRI.create("blah#B"));
        Variable<OWLClassExpression> x = VariableFactory.getCLASSVariable("?x", null);
        OWLObjectIntersectionOf aANDb = dataFactory.getOWLObjectIntersectionOf(a, b);
        OWLClass xClass = dataFactory.getOWLClass(x.getIRI());
        List<List<Integer>> findAll = OWLObjectFinder.findAll(xClass, aANDb);
        assertTrue(findAll.size() == 0);
        OWLObjectIntersectionOf xANDb = dataFactory.getOWLObjectIntersectionOf(xClass, b);
        findAll = OWLObjectFinder.findAll(xClass, xANDb);
        assertTrue(findAll.size() == 1);
        for (List<Integer> position : findAll) {
            assertTrue(Position.get(xANDb, position).equals(xClass));
        }
    }
}
