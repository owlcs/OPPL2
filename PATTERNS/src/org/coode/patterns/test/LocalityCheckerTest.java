package org.coode.patterns.test;

import java.io.File;
import java.util.Set;

import org.coode.oppl.bindingtree.BindingNode;
import org.coode.parsers.SystemErrorEcho;
import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.OPPLPatternParser;
import org.coode.patterns.ParserFactory;
import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternOPPLScript;
import org.coode.patterns.UnsuitableOPPLScriptException;
import org.coode.patterns.locality.LocalityChecker;
import org.coode.patterns.ui.LocalityCheckResultTableModel;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyIRIMapper;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.util.AutoIRIMapper;
import org.semanticweb.owlapi.util.OWLEntityCollector;

public class LocalityCheckerTest {
	public static void main(String[] args) throws Exception {
		String string = "?x:CLASS\n" + "BEGIN\n" + "ADD ?x subClassOf Thing\n" + "END;";
		runScript(string);
		string = "?x:CLASS, ?y:INDIVIDUAL\n" + "BEGIN\n" + "ADD ?y types ?x\n" + "END;";
		runScript(string);
	}

	private static void runScript(String string) throws OWLOntologyCreationException,
			UnsuitableOPPLScriptException {
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLOntologyIRIMapper siemensmapper = new AutoIRIMapper(new File(
				"/Users/ignazio/ontologies/test_caches/"), true);
		manager.addIRIMapper(siemensmapper);
		OWLOntology ontology = manager.loadOntology(IRI.create("file:///Users/ignazio/ontologies/test_caches/test_caches.owl"));
		PelletReasonerFactory prf = new PelletReasonerFactory();
		OWLReasoner r = prf.createReasoner(manager);
		OWLEntityCollector collector = new OWLEntityCollector();
		for (OWLOntology o : manager.getOntologies()) {
			o.accept(collector);
		}
		LocalityChecker toTest = new LocalityChecker(manager, r, collector.getObjects());
		OPPLPatternParser parser = new ParserFactory(ontology, manager).build(new SystemErrorEcho());
		PatternOPPLScript script = parser.parse(string);
		PatternModel model = parser.getOPPLPatternFactory().createPatternModel(script);
		InstantiatedPatternModel m = parser.getOPPLPatternFactory().createInstantiatedPatternModel(
				model);
		toTest.setInstantiatedPatternModel(m);
		Set<BindingNode> extractBindingNodes = m.extractBindingNodes();
		m.getConstraintSystem().setLeaves(extractBindingNodes);
		System.out.println(string);
		System.out.println(toTest.isLocal());
		print(toTest);
	}

	public static void print(LocalityChecker toTest) {
		LocalityCheckResultTableModel m = new LocalityCheckResultTableModel(toTest);
		for (String[] st : m.getDataArray()) {
			for (String s : st) {
				System.out.print("| " + s + "\t");
			}
			System.out.println("|");
		}
	}
}
