package org.coode.patterns.test;

import java.io.File;
import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.bindingtree.BindingNode;
import org.coode.parsers.SystemErrorEcho;
import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.OPPLPatternParser;
import org.coode.patterns.ParserFactory;
import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternOPPLScript;
import org.coode.patterns.locality.LocalityChecker;
import org.coode.patterns.locality.SigmaPlusSigmaMinus;
import org.coode.patterns.ui.LocalityCheckResultTableModel;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.OWLOntologyURIMapper;
import org.semanticweb.owl.util.AutoURIMapper;
import org.semanticweb.owl.util.OWLEntityCollector;
import org.semanticweb.reasonerfactory.factpp.FaCTPlusPlusReasonerFactory;
import org.semanticweb.reasonerfactory.pellet.PelletReasonerFactory;

public class LocalityCheckerTest {
	public static void main(String[] args) throws Exception {
		String string = "?x:CLASS\n" +
				"BEGIN\n" +
				"ADD ?x subClassOf Thing\n" +
				"END;";
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLOntologyURIMapper siemensmapper = new AutoURIMapper(new File("/Users/ignazio/ontologies/test_caches/"),
				true);
		manager.addURIMapper(siemensmapper);
		OWLOntology ontology = manager.loadOntologyFromPhysicalURI(URI.create("file:///Users/ignazio/ontologies/test_caches/test_caches.owl"));
		PelletReasonerFactory prf=new PelletReasonerFactory();
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
		System.out.println(toTest.isLocal(ontology));
		print( toTest);
	}

	public static void print( LocalityChecker toTest) {
		
		LocalityCheckResultTableModel m = new LocalityCheckResultTableModel(toTest);
		for(String[] st:m.getDataArray()) {
			for(String s:st) {
				System.out.print("| "+s+"\t");
			}
			System.out.println("|");
		}
	}
}
