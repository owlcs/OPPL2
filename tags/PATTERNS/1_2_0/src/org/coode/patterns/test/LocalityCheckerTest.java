package org.coode.patterns.test;

import java.io.File;
import java.net.URI;
import java.util.Arrays;
import java.util.Set;

import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.coode.patterns.InstantiatedPatternModel;
import org.coode.patterns.PatternModel;
import org.coode.patterns.PatternOPPLScript;
import org.coode.patterns.locality.LocalityChecker;
import org.coode.patterns.syntax.PatternParser;
import org.coode.patterns.ui.LocResultTableModel;
import org.coode.patterns.utils.ParserFactory;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.OWLOntologyURIMapper;
import org.semanticweb.owl.util.AutoURIMapper;
import org.semanticweb.owl.util.OWLEntityCollector;
import org.semanticweb.reasonerfactory.factpp.FaCTPlusPlusReasonerFactory;

public class LocalityCheckerTest {
	public static void main(String[] args) throws Exception {
		String string = "?element:CLASS,?exposedSubElement:CLASS,?hiddenSubElement:CLASS,?exposedFeature:CLASS,?hiddenFeature:CLASS,?quantity:CLASS,\n"
				+ "?hasExposedSubElement:CLASS = OWLObjectProperty_01241019394335806000 some ?exposedSubElement,"
				+ "?hasHiddenSubElement:CLASS = OWLObjectProperty_01241019337607959000 some ?hiddenSubElement,"
				+ "?hasExposedFeature:CLASS = OWLObjectProperty_01241018787395832000 some ?exposedFeature,"
				+ "?hasHiddenFeature:CLASS = OWLObjectProperty_01241019324612330000 some ?hiddenFeature,"
				+ "?hasQuantity:CLASS = OWLObjectProperty_01237305548139854000 some ?quantity,"
				+ "?allExposedSubElements:CLASS = createIntersection(?hasExposedSubElement . VALUES ),"
				+ "?allHiddenSubElements:CLASS = createIntersection(?hasHiddenSubElement . VALUES ),"
				+ "?allExposedFeatures:CLASS = createIntersection(?hasExposedFeature . VALUES ),"
				+ "?allHiddenFeatures:CLASS = createIntersection(?hasHiddenFeature . VALUES ),"
				+ "?allQuantities:CLASS = createIntersection(?hasQuantity . VALUES )\n"
				+ "BEGIN\n"
				+ "ADD Nothing equivalentTo ?element and ?allExposedSubElements and ?allHiddenSubElements and ?allExposedSubElements and ?allExposedFeatures and ?allHiddenFeatures and ?allQuantities\n"
				+ "END;";
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		OWLOntologyURIMapper siemensmapper = new AutoURIMapper(new File(
				"../OPPL2/ontologies/"), true);
		manager.addURIMapper(siemensmapper);
		OWLOntology ontology = manager.loadOntologyFromPhysicalURI(URI
				.create("file:../OPPL2/ontologies/AnnotatedSiemensStart.owl"));
		FaCTPlusPlusReasonerFactory prf = new FaCTPlusPlusReasonerFactory();
		OWLReasoner r = prf.createReasoner(manager);
		OWLEntityCollector collector = new OWLEntityCollector();
		for (OWLOntology o : manager.getOntologies()) {
			o.accept(collector);
		}
		LocalityChecker toTest = new LocalityChecker(manager, r, collector
				.getObjects());
		// toTest.setSignature(new HashSet<OWLEntity>());
		PatternParser parser = ParserFactory.initParser(string, ontology,
				manager, r);
		PatternOPPLScript script = parser.Start();
		PatternModel model = parser.getPatternModelFactory()
				.createPatternModel(script);
		InstantiatedPatternModel m = parser.getPatternModelFactory()
				.createInstantiatedPatternModel(model);
		toTest.setInstantiatedPatternModel(m);
		Set<BindingNode> extractBindingNodes = m.extractBindingNodes();
		m.getConstraintSystem().setLeaves(extractBindingNodes);
		System.out.println(toTest.isLocal(ontology));
		print(manager.getOWLDataFactory().getOWLNothing(), toTest);
	}

	public static void print(OWLEntity not, LocalityChecker toTest) {
		LocResultTableModel m = new LocResultTableModel(toTest, not);
		System.out.println(Arrays.toString(m.getDataArray()));
	}
}
