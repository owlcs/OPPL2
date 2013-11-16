package org.coode.oppl.testcaseontologies;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.StringDocumentTarget;
import org.semanticweb.owlapi.model.AddImport;
import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationSubject;
import org.semanticweb.owlapi.model.OWLAnnotationValue;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLImportsDeclaration;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;
import org.semanticweb.owlapi.vocab.XSDVocabulary;

public class TemplateTestOntologies {
    private static void declare(OWLOntology o, OWLEntity... entities) {
        for (OWLEntity e : entities) {
            o.getOWLOntologyManager().addAxiom(o, dec(e));
        }
    }

    private static void state(OWLOntology o, OWLAxiom... axioms) {
        for (OWLAxiom ax : axioms) {
            o.getOWLOntologyManager().addAxiom(o, ax);
        }
    }

    private static void state(OWLOntology o, List<OWLAxiom>... axioms) {
        for (List<OWLAxiom> axs : axioms) {
            for (OWLAxiom ax : axs) {
                o.getOWLOntologyManager().addAxiom(o, ax);
            }
        }
    }

    private static List<OWLAxiom> label(OWLEntity e, String... lines) {
        List<OWLAxiom> axioms = new ArrayList<OWLAxiom>();
        axioms.add(dec(e));
        Set<OWLAnnotation> labels = new HashSet<OWLAnnotation>();
        for (String l : lines) {
            String language = "";
            int index = l.indexOf("@");
            if (index == l.length() - 3) {
                language = l.substring(l.indexOf("@") + 1);
                l = l.substring(0, index);
            }
            axioms.add(ann(RDFSLabel(), e.getIRI(), Literal(l, language)));
        }
        return axioms;
    }

    public static OWLOntology naf(OWLOntologyManager m) {
        String naf_ns = "http://www.semanticweb.org/ontologies/2010/6/Ontology1278505688859.owl";
        try {
            OWLOntology naf = m.createOntology(IRI(naf_ns));
            OWLObjectProperty hasP = object(naf_ns + "#hasP");
            OWLClass prange = Class(naf_ns + "#P_Range");
            OWLClass a = Class(naf_ns + "#A");
            OWLClass b = Class(naf_ns + "#B");
            OWLClass c = Class(naf_ns + "#C");
            OWLClass d = Class(naf_ns + "#D");
            OWLClass aa = Class(naf_ns + "#A_A");
            OWLClass ab = Class(naf_ns + "#A_B");
            OWLClass ac = Class(naf_ns + "#A_C");
            OWLClass ad = Class(naf_ns + "#A_D");
            OWLClass bpr = Class(naf_ns + "#B_P_Range");
            OWLClass cpr = Class(naf_ns + "#C_P_Range");
            OWLClass dpr = Class(naf_ns + "#D_P_Range");
            declare(naf, a, aa, ab, ac, ad, bpr, cpr, d, dpr, prange, hasP);
            state(naf, sub(a, some(hasP, prange)), sub(bpr, prange), sub(c, a),
                    sub(ab, aa), sub(ac, aa), sub(ad, aa), sub(b, a), sub(cpr, prange),
                    sub(d, a), sub(dpr, prange), sub(ab, some(hasP, bpr)),
                    sub(b, some(hasP, bpr)), sub(c, some(hasP, cpr)),
                    sub(d, some(hasP, dpr)));
            state(naf, label(b, "B"), label(c, "C"));
            return naf;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static OWLOntology country(OWLOntologyManager m) {
        String country_ns = "http://www.co-ode.org/roberts/country.owl";
        try {
            OWLOntology country = m.createOntology(IRI(country_ns));
            OWLClass fragment = Class(country_ns + "#Fragment");
            OWLClass chunk = Class(country_ns + "#Chunk");
            OWLClass BoundaryFragment = Class(country_ns + "#BoundaryFragment");
            OWLClass LandBoundaryFragment = Class(country_ns + "#LandBoundaryFragment");
            OWLClass WaterBoundaryFragment = Class(country_ns + "#WaterBoundaryFragment");
            OWLClass Country = Class(country_ns + "#Country");
            OWLDataProperty size = DataProperty(country_ns + "#size");
            OWLObjectProperty adjacentTo = object(country_ns + "#adjacentTo");
            OWLObjectProperty hasWaterBoundary = object(country_ns + "#hasWaterBoundary");
            OWLObjectProperty borders = object(country_ns + "#borders");
            OWLObjectProperty dependencyOf = object(country_ns + "#dependencyOf");
            OWLObjectProperty hasBoundary = object(country_ns + "#hasBoundary");
            OWLObjectProperty hasLandBoundary = object(country_ns + "#hasLandBoundary");
            OWLNamedIndividual asinara = NamedIndividual(country_ns + "#Asinara");
            declare(country, chunk, fragment, size, asinara);
            state(country, sub(BoundaryFragment, fragment), eq(chunk, fragment),
                    sub(LandBoundaryFragment, BoundaryFragment),
                    sub(WaterBoundaryFragment, BoundaryFragment),
                    domain(adjacentTo, Country), range(adjacentTo, Country),
                    domain(borders, Country), range(borders, Country),
                    domain(dependencyOf, Country), range(dependencyOf, Country),
                    domain(hasBoundary, Country), range(hasBoundary, BoundaryFragment),
                    sub(hasLandBoundary, hasBoundary), domain(hasLandBoundary, Country),
                    range(hasLandBoundary, LandBoundaryFragment),
                    sub(hasWaterBoundary, hasBoundary),
                    domain(hasWaterBoundary, Country),
                    range(hasWaterBoundary, WaterBoundaryFragment),
                    range(size, OWL2Datatype.XSD_INT.getDatatype(dataFactory)),
                    ClassAssertion(Country, asinara));
            return country;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void same(OWLOntology o1, OWLOntology o2) throws OWLOntologyStorageException {
        Set<OWLAxiom> common = new HashSet<OWLAxiom>(o1.getAxioms());
        common.retainAll(o2.getAxioms());
        o1.getOWLOntologyManager().removeAxioms(o1, common);
        o2.getOWLOntologyManager().removeAxioms(o2, common);
        if (o1.getAxiomCount() == 0 && o2.getAxiomCount() == 0) {
            return;
        }
        StringDocumentTarget t1 = new StringDocumentTarget();
        StringDocumentTarget t2 = new StringDocumentTarget();
        o1.getOWLOntologyManager().saveOntology(o1, t1);
        o2.getOWLOntologyManager().saveOntology(o2, t2);
        assertEquals(
                t1.toString().replace("file:/C:/Tools/Alignement/align-4.0/temp.owl",
                        "urn:temp"), t2.toString());
    }

    // @Test
    // public void shouldnaf() throws OWLOntologyStorageException {
    // same(Ontologies.naf, naf());
    // }
    //
    // @Test
    // public void shouldondrej() throws OWLOntologyStorageException {
    // same(Ontologies.ondrejtest, ondrejtest());
    // }
    //
    // @Test
    // public void shoulddul() throws OWLOntologyStorageException {
    // same(Ontologies.dul, dul());
    // }
    //
    // @Test
    // public void shouldfood() throws OWLOntologyStorageException {
    // same(Ontologies.food, food());
    // }
    //
    // @Test
    // public void shouldpatterndul() throws OWLOntologyStorageException {
    // same(Ontologies.patternedDUL, patternedDul());
    // }
    //
    // @Test
    // public void shouldpatternpizza() throws OWLOntologyStorageException {
    // same(Ontologies.patternedPizza, patternedPizza());
    // }
    //
    // @Test
    // public void shouldluigi() throws OWLOntologyStorageException {
    // same(Ontologies.patternedPizzaLuigi, pizzaLuigi());
    // }
    //
    // @Test
    // public void shouldsequential() throws OWLOntologyStorageException {
    // same(Ontologies.sequentialUnion, sequentialUnion());
    // }
    //
    // @Test
    // public void shouldsiblings() throws OWLOntologyStorageException {
    // same(Ontologies.siblings, siblings());
    // }
    //
    // @Test
    // public void shouldsyntax() throws OWLOntologyStorageException {
    // same(Ontologies.syntax, syntax());
    // }
    //
    // @Test
    // public void shouldcountry() throws OWLOntologyStorageException {
    // same(Ontologies.test, country());
    // }
    //
    // @Test
    // public void shouldtestLongLabels() throws OWLOntologyStorageException {
    // same(Ontologies.testLongLabels, testLongLabels());
    // }
    public static OWLOntology syntax(OWLOntologyManager m) {
        String syntax_ns = "http://www.coode.org/oppl/ontologies/syntaxTest.owl";
        try {
            OWLOntology syntax = m.createOntology(IRI(syntax_ns));
            OWLDataProperty p = DataProperty(syntax_ns + "#aDataProperty");
            state(syntax, label(p, "aDataProperty"));
            state(syntax, range(p, OWL2Datatype.XSD_INT.getDatatype(dataFactory)));
            return syntax;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static OWLOntology testLongLabels(OWLOntologyManager m) {
        String ns = "http://www.coode.org/oppl/testLongLabels";
        try {
            OWLOntology testLongLabels = m.createOntology(IRI(ns));
            OWLClass a = Class(ns + "#A");
            OWLClass b = Class(ns + "#B");
            state(testLongLabels,
                    label(a, "Structure of femoral artery (body structure)"),
                    label(b, "Structure of arm artery (body structure)"));
            return testLongLabels;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static OWLOntology siblings(OWLOntologyManager m) {
        String ns = "http://www.semanticweb.org/ontologies/2011/1/siblings.owl";
        try {
            OWLOntology siblings = m.createOntology(IRI(ns));
            declare(siblings, object(ns + "#hasSibling"), NamedIndividual(ns + "#Robert"));
            return siblings;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static OWLOntology ondrejtest(OWLOntologyManager m) {
        String ns = "http://www.semanticweb.org/ontologies/2010/2/Ontology1269524218581.owl";
        try {
            OWLOntology ondrejtest = m.createOntology();
            OWLClass a = Class(ns + "#A");
            OWLClass c = Class(ns + "#C");
            OWLObjectProperty p = object(ns + "#p");
            declare(ondrejtest, a, c, p);
            state(ondrejtest, eq(a, some(p, c)), sub(c, OWLThing()));
            return ondrejtest;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static OWLOntology sequentialUnion(OWLOntologyManager m) {
        String ns1 = "http://www.semanticweb.com/mergedont";
        String ns = "urn:temp#";
        try {
            OWLOntology sequentialUnion = m.createOntology(IRI(ns));
            String nsf = "http://www.francetelecom.com/OWLWriter/DPWSWriter.owl#";
            String nsf1 = "http://www.francetelecom.com/OWLWriter/UPnPWriter.owl#";
            OWLClass DPWS_Action = Class(nsf + "DPWS_Action");
            OWLClass DPWS_Device = Class(nsf + "DPWS_Device");
            OWLClass DPWS_Service = Class(nsf + "DPWS_Service");
            OWLClass DPWS_StateVariable = Class(nsf + "DPWS_StateVariable");
            OWLClass DummyOperation = Class(nsf + "DummyOperation");
            OWLClass SeqClockStd = Class(nsf + "SeqClockStd");
            OWLClass Set1 = Class(nsf + "Set1");
            OWLClass Set2 = Class(nsf + "Set2");
            OWLClass a = Class(nsf + "a");
            OWLClass seqentialClock = Class(nsf + "seqentialClock");
            OWLClass x = Class(nsf + "x");
            OWLClass y = Class(nsf + "y");
            OWLClass newx = Class(nsf1 + "Newx");
            OWLClass newy = Class(nsf1 + "Newy");
            OWLClass sequentialunionclock = Class(nsf1 + "SequentialUnionClock");
            OWLObjectProperty has_dpws_statevariable = object(nsf
                    + "has_DPWS_StateVariable");
            OWLObjectProperty has_DPWS_Action = object(nsf + "has_DPWS_Action");
            OWLObjectProperty has_DPWS_Input = object(nsf + "has_DPWS_Input");
            OWLObjectProperty has_DPWS_Output = object(nsf + "has_DPWS_Output");
            OWLObjectProperty has_DPWS_Service = object(nsf + "has_DPWS_Service");
            OWLDataProperty a_has_DPWS_StateVariable_Type = DataProperty(nsf
                    + "a_has_DPWS_StateVariable_Type");
            OWLDataProperty has_DPWS_Logical_Device_Name = DataProperty(nsf
                    + "has_DPWS_Logical_Device_Name");
            OWLDataProperty x_has_DPWS_StateVariable_Type = DataProperty(nsf
                    + "x_has_DPWS_StateVariable_Type");
            OWLDataProperty y_has_DPWS_StateVariable_Type = DataProperty(nsf
                    + "y_has_DPWS_StateVariable_Type");
            OWLDataProperty y_has_UPnP_StateVariable_Type = DataProperty(nsf1
                    + "y_has_UPnP_StateVariable_Type");
            OWLDataProperty x_has_UPnP_StateVariable_Type = DataProperty(nsf1
                    + "x_has_UPnP_StateVariable_Type");
            OWLDataProperty has_UPnP_Service_Version = DataProperty(nsf1
                    + "has_UPnP_Service_Version");
            OWLDataProperty has_UPnP_Service_Type = DataProperty(nsf1
                    + "has_UPnP_Service_Type");
            OWLDataProperty has_UPnP_Service_ID = DataProperty(nsf1
                    + "has_UPnP_Service_ID");
            OWLDataProperty has_UPnP_Device_Type = DataProperty(nsf1
                    + "has_UPnP_Device_Type");
            OWLObjectProperty UPnP_is_instance_of_type = object(nsf1
                    + "UPnP_is_instance_of_type");
            OWLObjectProperty has_UPnP_Action = object(nsf1 + "has_UPnP_Action");
            OWLObjectProperty has_UPnP_Input = object(nsf1 + "has_UPnP_Input");
            OWLObjectProperty has_UPnP_Instance_Input = object(nsf1
                    + "has_UPnP_Instance_Input");
            OWLObjectProperty has_UPnP_Instance_Output = object(nsf1
                    + "has_UPnP_Instance_Output");
            OWLObjectProperty has_UPnP_Output = object(nsf1 + "has_UPnP_Output");
            OWLObjectProperty has_UPnP_Service = object(nsf1 + "has_UPnP_Service");
            OWLClass Set12 = Class(nsf1 + "Set12");
            OWLClass Time = Class(nsf1 + "Time");
            OWLClass UPnP_Action = Class(nsf1 + "UPnP_Action");
            OWLClass UPnP_Device = Class(nsf1 + "UPnP_Device");
            OWLClass UPnP_Service = Class(nsf1 + "UPnP_Service");
            OWLClass UPnP_StateVariable = Class(nsf1 + "UPnP_StateVariable");
            OWLClass x1 = Class(nsf1 + "x");
            OWLClass y1 = Class(nsf1 + "y");
            OWLObjectProperty Sequential_Union_Mapping_First_member = object(ns
                    + "Sequential_Union_Mapping_First_member");
            OWLObjectProperty Sequential_Union_Mapping_Second_member = object(ns
                    + "Sequential_Union_Mapping_Second_member");
            OWLObjectProperty Simple_Mapping_Input = object(ns + "Simple_Mapping_Input");
            OWLObjectProperty Simple_Mapping_Input_Output = object(ns
                    + "Simple_Mapping_Input_Output");
            OWLObjectProperty Simple_Mapping_Output = object(ns + "Simple_Mapping_Output");
            OWLObjectProperty Union_Mapping = object(ns + "Union_Mapping");
            OWLObjectProperty Union_Mapping_First_member = object(ns
                    + "Union_Mapping_First_member");
            OWLObjectProperty Union_Mapping_Second_member = object(ns
                    + "Union_Mapping_Second_member");
            OWLObjectProperty Exact_Input_Match = object(ns1 + "#Exact_Input_Match");
            OWLObjectProperty Exact_Input_Output_Match = object(ns1
                    + "#Exact_Input_Output_Match");
            OWLObjectProperty Exact_Output_Match = object(ns1 + "#Exact_Output_Match");
            OWLObjectProperty PlugIn_Input_Output_Match = object(ns1
                    + "#PlugIn_Input_Output_Match");
            OWLObjectProperty PlugIn_Output_Match = object(ns1 + "#PlugIn_Output_Match");
            OWLObjectProperty has_Next = object(ns1 + "#has_Next");
            OWLObjectProperty PlugIn_Input_Match = object(ns1 + "#PlugIn_Input_Match");
            OWLClass SequentialUnionClock = Class(nsf1 + "SequentialUnionClock");
            declare(sequentialUnion, DPWS_Action, DPWS_Device, DPWS_Service,
                    DPWS_StateVariable, DummyOperation, SeqClockStd, Set1, Set2, a,
                    seqentialClock, x, y, newx, newy, sequentialunionclock, Set12, Time,
                    UPnP_Action, UPnP_Device, UPnP_Service, UPnP_StateVariable, x1, y1,
                    Sequential_Union_Mapping_First_member,
                    Sequential_Union_Mapping_Second_member, Simple_Mapping_Input,
                    Simple_Mapping_Input_Output, Simple_Mapping_Output, Union_Mapping,
                    Union_Mapping_First_member, Union_Mapping_Second_member,
                    has_DPWS_Action, has_DPWS_Input, has_DPWS_Output, has_DPWS_Service,
                    has_dpws_statevariable, UPnP_is_instance_of_type, has_UPnP_Action,
                    has_UPnP_Input, has_UPnP_Instance_Input, has_UPnP_Instance_Output,
                    has_UPnP_Output, has_UPnP_Service, Exact_Input_Match,
                    Exact_Input_Output_Match, Exact_Output_Match, PlugIn_Input_Match,
                    PlugIn_Input_Output_Match, PlugIn_Output_Match, has_Next,
                    a_has_DPWS_StateVariable_Type, has_DPWS_Logical_Device_Name,
                    x_has_DPWS_StateVariable_Type, y_has_DPWS_StateVariable_Type,
                    has_UPnP_Device_Type, has_UPnP_Service_ID, has_UPnP_Service_Type,
                    has_UPnP_Service_Version, x_has_UPnP_StateVariable_Type,
                    y_has_UPnP_StateVariable_Type);
            state(sequentialUnion,
                    sub(DPWS_Action, some(has_dpws_statevariable, DPWS_StateVariable)),
                    sub(DPWS_Device, some(has_DPWS_Service, DPWS_Service)),
                    sub(DPWS_Service, some(has_DPWS_Action, DPWS_Action)),
                    sub(DummyOperation, DPWS_Action),
                    sub(DummyOperation, some(has_DPWS_Input, y)),
                    eq(SeqClockStd, Time),
                    sub(SeqClockStd, DPWS_Service),
                    sub(SeqClockStd, some(has_DPWS_Action, DummyOperation)),
                    sub(SeqClockStd, some(has_DPWS_Action, Set1)),
                    sub(SeqClockStd, some(has_DPWS_Action, Set2)),
                    eq(Set1, Set12),
                    sub(Set1, DPWS_Action),
                    sub(Set1, some(has_DPWS_Input, x)),
                    sub(Set1, some(has_DPWS_Output, a)),
                    sub(Set1, some(Exact_Input_Match, Set12)),
                    eq(Set2, Set12),
                    sub(Set2, DPWS_Action),
                    sub(Set2, some(has_DPWS_Input, a)),
                    sub(Set2, some(has_DPWS_Output, y)),
                    sub(Set2, some(Exact_Output_Match, Set12)),
                    sub(a, DPWS_StateVariable),
                    sub(a, some(a_has_DPWS_StateVariable_Type, string())),
                    eq(seqentialClock, SequentialUnionClock),
                    sub(seqentialClock, DPWS_Device),
                    sub(seqentialClock, some(has_DPWS_Service, SeqClockStd)),
                    sub(seqentialClock,
                            has(has_DPWS_Logical_Device_Name,
                                    Literal("hosted:seqentialClock", ""))),
                    eq(x, x1),
                    sub(x, DPWS_StateVariable),
                    sub(x, some(x_has_DPWS_StateVariable_Type, string())),
                    eq(y, y1),
                    sub(y, DPWS_StateVariable),
                    sub(y, some(y_has_DPWS_StateVariable_Type, string())),
                    sub(newx, x1),
                    sub(newx, some(UPnP_is_instance_of_type, x1)),
                    sub(newy, y1),
                    sub(newy, some(UPnP_is_instance_of_type, y1)),
                    sub(SequentialUnionClock, UPnP_Device),
                    sub(SequentialUnionClock, some(has_UPnP_Service, Time)),
                    sub(SequentialUnionClock,
                            has(has_UPnP_Device_Type,
                                    Literal("urn:schemas-upnp-org:device:SequentialUnionClock:1",
                                            ""))),
                    sub(Set12, UPnP_Action),
                    sub(Set12, some(Simple_Mapping_Input, Set1)),
                    sub(Set12, some(Simple_Mapping_Output, Set2)),
                    sub(Set12, some(Union_Mapping, Set1)),
                    sub(Set12, some(has_UPnP_Input, x1)),
                    sub(Set12, some(has_UPnP_Instance_Input, newx)),
                    sub(Set12, some(has_UPnP_Instance_Output, newy)),
                    sub(Set12, some(has_UPnP_Output, y1)),
                    sub(Set12, some(Exact_Input_Match, Set1)),
                    sub(Set12, some(Exact_Output_Match, Set2)),
                    sub(Time, UPnP_Service),
                    sub(Time, some(has_UPnP_Action, Set12)),
                    sub(Time,
                            has(has_UPnP_Service_ID,
                                    Literal("urn:upnp-org:serviceId:Time.1", ""))),
                    sub(Time,
                            has(has_UPnP_Service_Type,
                                    Literal("urn:schemas-upnp-org:service:Time:1", ""))),
                    sub(Time, has(has_UPnP_Service_Version, Literal("1", ""))),
                    sub(UPnP_Action, some(has_UPnP_Input, UPnP_StateVariable)),
                    sub(UPnP_Action, some(has_UPnP_Output, UPnP_StateVariable)),
                    sub(UPnP_Device, some(has_UPnP_Service, UPnP_Service)),
                    sub(UPnP_Service, some(has_UPnP_Action, UPnP_Action)),
                    sub(x1, UPnP_StateVariable),
                    sub(x1, some(x_has_UPnP_StateVariable_Type, string())),
                    sub(y1, UPnP_StateVariable),
                    sub(y1, some(y_has_UPnP_StateVariable_Type, string())));
            return sequentialUnion;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static OWLDatatype string() {
        return OWL2Datatype.XSD_STRING.getDatatype(dataFactory);
    }

    public static OWLOntology food(OWLOntologyManager m) {
        String ns = "http://www.coode.org/patterns/examples/food#";
        String ns1 = "http://www.co-ode.org/patterns#";
        try {
            OWLOntology siblings = m
                    .createOntology(IRI("http://www.coode.org/patterns/examples/food"));
            OWLClass Course = Class(ns + "Course");
            OWLClass Food = Class(ns + "Food");
            OWLClass Meat = Class(ns + "Meat");
            OWLClass Menu = Class(ns + "Menu");
            OWLClass Probe = Class(ns + "Probe");
            OWLClass Vegetable = Class(ns + "Vegetable");
            OWLClass VegetarianCourse = Class(ns + "VegetarianCourse");
            OWLClass VegetarianMenu = Class(ns + "VegetarianMenu");
            OWLObjectProperty contains = object(ns + "contains");
            OWLAnnotationProperty Free = ann(ns1 + "Free");
            OWLAnnotationProperty FreeMenu = ann(ns1 + "FreeMenu");
            OWLAnnotationProperty Hierarchy = ann(ns1 + "Hierarchy");
            OWLAnnotationProperty VegetarianCourseFreePatternInstantiation = ann(ns1
                    + "VegetarianCourseFreePatternInstantiation");
            OWLAnnotationProperty VegetarianCoursenullPatternInstantiation = ann(ns1
                    + "VegetarianCoursenullPatternInstantiation");
            OWLAnnotationProperty VegetarianMenuFreeMenuPatternInstantiation = ann(ns1
                    + "VegetarianMenuFreeMenuPatternInstantiation");
            OWLAnnotationProperty createdBy = ann(ns1 + "createdBy");
            OWLLiteral pattern1 = Literal("?x:CLASS,?forbiddenContent:CLASS=createUnion(?x.VALUES) BEGIN ADD $thisClass equivalentTo contains only (not ?forbiddenContent ) END;  A ?x free stuff ; RETURN $thisClass");
            OWLLiteral pattern2 = Literal("?x:CLASS BEGIN ADD $thisClass subClassOf contains only ($Free(?x) ) END;  A ?x free menu");
            m.applyChange(new AddOntologyAnnotation(siblings, ann(Free, pattern1)));
            m.applyChange(new AddOntologyAnnotation(siblings, ann(FreeMenu, pattern2)));
            declare(siblings, Probe, Free, FreeMenu, Hierarchy,
                    VegetarianCourseFreePatternInstantiation,
                    VegetarianCoursenullPatternInstantiation,
                    VegetarianMenuFreeMenuPatternInstantiation, createdBy);
            Set<OWLAnnotation> ann1 = Collections
                    .singleton(ann(
                            createdBy,
                            Literal("http://www.co-ode.org/patterns#VegetarianCourseFreePatternInstantiation",
                                    string())));
            Set<OWLAnnotation> ann2 = Collections
                    .singleton(ann(
                            createdBy,
                            Literal("http://www.co-ode.org/patterns#VegetarianMenuFreeMenuPatternInstantiation",
                                    string())));
            OWLObjectAllValuesFrom nonveg = all(contains, c(Meat));
            OWLObjectAllValuesFrom veg = all(contains, nonveg);
            state(siblings, label(Course, "Portata@it"), label(Food, "Cibo@it"),
                    label(contains, "contiene@it"), label(Meat, "Carne@it"),
                    label(Menu, "Menù@it"), label(Vegetable, "Verdura@it"),
                    label(VegetarianCourse, "Portata_Vegetariana@it"),
                    label(VegetarianMenu, "Menù_Vegetariano@it"));
            state(siblings,
                    ann(VegetarianCourseFreePatternInstantiation,
                            VegetarianCourse.getIRI(), Literal("$Free(Meat)", string())),
                    ann(VegetarianMenuFreeMenuPatternInstantiation,
                            VegetarianMenu.getIRI(), Literal("$FreeMenu(Meat)", string())),
                    sub(Course, OWLThing()), sub(Food, OWLThing()), sub(Meat, Food),
                    sub(Menu, OWLThing()), sub(Probe, Menu), sub(Vegetable, Food),
                    sub(VegetarianCourse, Course), sub(VegetarianMenu, Menu),
                    eq(ann1, VegetarianCourse, nonveg), sub(VegetarianMenu, veg, ann2));
            return siblings;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static OWLOntology pizza(OWLOntologyManager m) {
        String ns = "http://pizza.com/pizza.owl#";
        try {
            OWLOntology pizza = m.createOntology(IRI("http://pizza.com/pizza.owl"));
            OWLClass American = Class(ns + "American");
            OWLClass AmericanHot = Class(ns + "AmericanHot");
            OWLClass AnchoviesTopping = Class(ns + "AnchoviesTopping");
            OWLClass ArtichokeTopping = Class(ns + "ArtichokeTopping");
            OWLClass AsparagusTopping = Class(ns + "AsparagusTopping");
            OWLClass Cajun = Class(ns + "Cajun");
            OWLClass CajunSpiceTopping = Class(ns + "CajunSpiceTopping");
            OWLClass CaperTopping = Class(ns + "CaperTopping");
            OWLClass Capricciosa = Class(ns + "Capricciosa");
            OWLClass Caprina = Class(ns + "Caprina");
            OWLClass CheeseTopping = Class(ns + "CheeseTopping");
            OWLClass CheeseyPizza = Class(ns + "CheeseyPizza");
            OWLClass CheeseyVegetableTopping = Class(ns + "CheeseyVegetableTopping");
            OWLClass ChickenTopping = Class(ns + "ChickenTopping");
            OWLClass Country = Class(ns + "Country");
            OWLClass DeepPanBase = Class(ns + "DeepPanBase");
            OWLClass DomainConcept = Class(ns + "DomainConcept");
            OWLClass Fiorentina = Class(ns + "Fiorentina");
            OWLClass FishTopping = Class(ns + "FishTopping");
            OWLClass FourCheesesTopping = Class(ns + "FourCheesesTopping");
            OWLClass FourSeasons = Class(ns + "FourSeasons");
            OWLClass FruitTopping = Class(ns + "FruitTopping");
            OWLClass FruttiDiMare = Class(ns + "FruttiDiMare");
            OWLClass GarlicTopping = Class(ns + "GarlicTopping");
            OWLClass Giardiniera = Class(ns + "Giardiniera");
            OWLClass GoatsCheeseTopping = Class(ns + "GoatsCheeseTopping");
            OWLClass GorgonzolaTopping = Class(ns + "GorgonzolaTopping");
            OWLClass GreenPepperTopping = Class(ns + "GreenPepperTopping");
            OWLClass HamTopping = Class(ns + "HamTopping");
            OWLClass HerbSpiceTopping = Class(ns + "HerbSpiceTopping");
            OWLClass Hot = Class(ns + "Hot");
            OWLClass HotGreenPepperTopping = Class(ns + "HotGreenPepperTopping");
            OWLClass HotSpicedBeefTopping = Class(ns + "HotSpicedBeefTopping");
            OWLClass IceCream = Class(ns + "IceCream");
            OWLClass InterestingPizza = Class(ns + "InterestingPizza");
            OWLClass JalapenoPepperTopping = Class(ns + "JalapenoPepperTopping");
            OWLClass LaReine = Class(ns + "LaReine");
            OWLClass LeekTopping = Class(ns + "LeekTopping");
            OWLClass Margherita = Class(ns + "Margherita");
            OWLClass MeatTopping = Class(ns + "MeatTopping");
            OWLClass MeatyPizza = Class(ns + "MeatyPizza");
            OWLClass Medium = Class(ns + "Medium");
            OWLClass Mild = Class(ns + "Mild");
            OWLClass MixedSeafoodTopping = Class(ns + "MixedSeafoodTopping");
            OWLClass MozzarellaTopping = Class(ns + "MozzarellaTopping");
            OWLClass Mushroom = Class(ns + "Mushroom");
            OWLClass MushroomTopping = Class(ns + "MushroomTopping");
            OWLClass NamedPizza = Class(ns + "NamedPizza");
            OWLClass Napoletana = Class(ns + "Napoletana");
            OWLClass NonVegetarianPizza = Class(ns + "NonVegetarianPizza");
            OWLClass NutTopping = Class(ns + "NutTopping");
            OWLClass OliveTopping = Class(ns + "OliveTopping");
            OWLClass OnionTopping = Class(ns + "OnionTopping");
            OWLClass ParmaHamTopping = Class(ns + "ParmaHamTopping");
            OWLClass Parmense = Class(ns + "Parmense");
            OWLClass ParmesanTopping = Class(ns + "ParmesanTopping");
            OWLClass PeperonataTopping = Class(ns + "PeperonataTopping");
            OWLClass PeperoniSausageTopping = Class(ns + "PeperoniSausageTopping");
            OWLClass PepperTopping = Class(ns + "PepperTopping");
            OWLClass PetitPoisTopping = Class(ns + "PetitPoisTopping");
            OWLClass PineKernels = Class(ns + "PineKernels");
            OWLClass Pizza = Class(ns + "Pizza");
            OWLClass PizzaBase = Class(ns + "PizzaBase");
            OWLClass PizzaTopping = Class(ns + "PizzaTopping");
            OWLClass PolloAdAstra = Class(ns + "PolloAdAstra");
            OWLClass PrawnsTopping = Class(ns + "PrawnsTopping");
            OWLClass PrinceCarlo = Class(ns + "PrinceCarlo");
            OWLClass QuattroFormaggi = Class(ns + "QuattroFormaggi");
            OWLClass RealItalianPizza = Class(ns + "RealItalianPizza");
            OWLClass RedOnionTopping = Class(ns + "RedOnionTopping");
            OWLClass RocketTopping = Class(ns + "RocketTopping");
            OWLClass Rosa = Class(ns + "Rosa");
            OWLClass RosemaryTopping = Class(ns + "RosemaryTopping");
            OWLClass SauceTopping = Class(ns + "SauceTopping");
            OWLClass Siciliana = Class(ns + "Siciliana");
            OWLClass SlicedTomatoTopping = Class(ns + "SlicedTomatoTopping");
            OWLClass SloppyGiuseppe = Class(ns + "SloppyGiuseppe");
            OWLClass Soho = Class(ns + "Soho");
            OWLClass Spiciness = Class(ns + "Spiciness");
            OWLClass SpicyPizza = Class(ns + "SpicyPizza");
            OWLClass SpicyPizzaEquivalent = Class(ns + "SpicyPizzaEquivalent");
            OWLClass SpicyTopping = Class(ns + "SpicyTopping");
            OWLClass SpinachTopping = Class(ns + "SpinachTopping");
            OWLClass SultanaTopping = Class(ns + "SultanaTopping");
            OWLClass SundriedTomatoTopping = Class(ns + "SundriedTomatoTopping");
            OWLClass SweetPepperTopping = Class(ns + "SweetPepperTopping");
            OWLClass ThinAndCrispyBase = Class(ns + "ThinAndCrispyBase");
            OWLClass TobascoPepperSauce = Class(ns + "TobascoPepperSauce");
            OWLClass TomatoTopping = Class(ns + "TomatoTopping");
            OWLClass UnclosedPizza = Class(ns + "UnclosedPizza");
            OWLClass ValuePartition = Class(ns + "ValuePartition");
            OWLClass VegetableTopping = Class(ns + "VegetableTopping");
            OWLClass VegetarianPizza = Class(ns + "VegetarianPizza");
            OWLClass VegetarianPizzaEquivalent1 = Class(ns + "VegetarianPizzaEquivalent1");
            OWLClass VegetarianPizzaEquivalent2 = Class(ns + "VegetarianPizzaEquivalent2");
            OWLClass VegetarianTopping = Class(ns + "VegetarianTopping");
            OWLClass Veneziana = Class(ns + "Veneziana");
            OWLObjectProperty hasBase = object(ns + "hasBase");
            OWLObjectProperty hasCountryOfOrigin = object(ns + "hasCountryOfOrigin");
            OWLObjectProperty hasIngredient = object(ns + "hasIngredient");
            OWLObjectProperty hasSpiciness = object(ns + "hasSpiciness");
            OWLObjectProperty hasTopping = object(ns + "hasTopping");
            OWLObjectProperty isBaseOf = object(ns + "isBaseOf");
            OWLObjectProperty isIngredientOf = object(ns + "isIngredientOf");
            OWLObjectProperty isToppingOf = object(ns + "isToppingOf");
            OWLNamedIndividual Italy = NamedIndividual(ns + "Italy");
            OWLNamedIndividual Germany = NamedIndividual(ns + "Germany");
            OWLNamedIndividual England = NamedIndividual(ns + "England");
            OWLNamedIndividual France = NamedIndividual(ns + "France");
            OWLNamedIndividual America = NamedIndividual(ns + "America");
            declare(pizza, DeepPanBase, DomainConcept, hasBase, hasCountryOfOrigin,
                    hasIngredient, hasSpiciness, hasTopping, isBaseOf, isIngredientOf,
                    isToppingOf);
            state(pizza, label(GoatsCheeseTopping, "CoberturaDeQueijoDeCabra@pt"),
                    label(GorgonzolaTopping, "CoberturaDeGorgonzola@pt"),
                    label(GreenPepperTopping, "CoberturaDePimentaoVerde@pt"),
                    label(HamTopping, "CoberturaDePresunto@pt"),
                    label(HerbSpiceTopping, "CoberturaDeErvas@pt"),
                    label(HotGreenPepperTopping, "CoberturaDePimentaoVerdePicante@pt"),
                    label(HotSpicedBeefTopping, "CoberturaDeBifePicante@pt"),
                    label(IceCream, "Sorvete@pt"),
                    label(InterestingPizza, "PizzaInteressante@pt"),
                    label(JalapenoPepperTopping, "CoberturaDeJalapeno@pt"),
                    label(LaReine, "LaReine@pt"),
                    label(LeekTopping, "CoberturaDeLeek@pt"),
                    label(Margherita, "Margherita@pt"),
                    label(MeatTopping, "CoberturaDeCarne@pt"),
                    label(MeatyPizza, "PizzaDeCarne@pt"), label(Medium, "Media@pt"),
                    label(MixedSeafoodTopping, "CoberturaDeFrutosDoMarMistos@pt"),
                    label(MozzarellaTopping, "CoberturaDeMozzarella@pt"),
                    label(Mushroom, "Cogumelo@pt"),
                    label(MushroomTopping, "CoberturaDeCogumelo@pt"),
                    label(NamedPizza, "PizzaComUmNome@pt"),
                    label(Napoletana, "Napoletana@pt"),
                    label(NonVegetarianPizza, "PizzaNaoVegetariana@pt"),
                    label(NutTopping, "CoberturaDeCastanha@pt"),
                    label(OliveTopping, "CoberturaDeAzeitona@pt"),
                    label(OnionTopping, "CoberturaDeCebola@pt"),
                    label(ParmaHamTopping, "CoberturaDePrezuntoParma@pt"),
                    label(Parmense, "Parmense@pt"), label(Hot, "Picante@pt"),
                    label(Mild, "NaoPicante@pt"), label(Pizza, "Pizza@en"),
                    label(Rosa, "Rosa@pt"), label(American, "Americana@pt"),
                    label(PineKernels, "CoberturaPineKernels@pt"),
                    label(PepperTopping, "CoberturaDePimentao@pt"),
                    label(PeperoniSausageTopping, "CoberturaDeCalabreza@pt"),
                    label(PetitPoisTopping, "CoberturaPetitPois@pt"),
                    label(PeperonataTopping, "CoberturaPeperonata@pt"),
                    label(ParmesanTopping, "CoberturaDeParmesao@pt"),
                    label(PizzaTopping, "CoberturaDaPizza@pt"),
                    label(PolloAdAstra, "PolloAdAstra@pt"),
                    label(PizzaBase, "BaseDaPizza@pt"), label(Spiciness, "Tempero@pt"),
                    label(SpicyPizza, "PizzaTemperada@pt"),
                    label(SpicyPizzaEquivalent, "PizzaTemperadaEquivalente@pt"),
                    label(SpicyTopping, "CoberturaTemperada@pt"),
                    label(SpinachTopping, "CoberturaDeEspinafre@pt"),
                    label(SultanaTopping, "CoberturaSultana@pt"),
                    label(SundriedTomatoTopping, "CoberturaDeTomateRessecadoAoSol@pt"),
                    label(SweetPepperTopping, "CoberturaDePimentaoDoce@pt"),
                    label(ThinAndCrispyBase, "BaseFinaEQuebradica@pt"),
                    label(TobascoPepperSauce, "MolhoTobascoPepper@pt"),
                    label(TomatoTopping, "CoberturaDeTomate@pt"),
                    label(UnclosedPizza, "PizzaAberta@pt"),
                    label(ValuePartition, "ValorDaParticao@pt"),
                    label(VegetableTopping, "CoberturaDeVegetais@pt"),
                    label(VegetarianPizza, "PizzaVegetariana@pt"),
                    label(VegetarianPizzaEquivalent1, "PizzaVegetarianaEquivalente1@pt"),
                    label(VegetarianPizzaEquivalent2, "PizzaVegetarianaEquivalente2@pt"),
                    label(VegetarianTopping, "CoberturaVegetariana@pt"),
                    label(Veneziana, "Veneziana@pt"),
                    label(PrawnsTopping, "CoberturaDeCamarao@pt"),
                    label(Siciliana, "Siciliana@pt"),
                    label(SlicedTomatoTopping, "CoberturaDeTomateFatiado@pt"),
                    label(SloppyGiuseppe, "SloppyGiuseppe@pt"),
                    label(PrinceCarlo, "CoberturaPrinceCarlo@pt"),
                    label(RealItalianPizza, "PizzaItalianaReal@pt"),
                    label(QuattroFormaggi, "QuatroQueijos@pt"),
                    label(SauceTopping, "CoberturaEmMolho@pt"),
                    label(RocketTopping, "CoberturaRocket@pt"),
                    label(RedOnionTopping, "CoberturaDeCebolaVermelha@pt"),
                    label(RosemaryTopping, "CoberturaRosemary@pt"),
                    label(AmericanHot, "AmericanaPicante@pt"),
                    label(AnchoviesTopping, "CoberturaDeAnchovies@pt"),
                    label(ArtichokeTopping, "CoberturaDeArtichoke@pt"),
                    label(AsparagusTopping, "CoberturaDeAspargos@pt"),
                    label(CajunSpiceTopping, "CoberturaDeCajun@pt"),
                    label(CaperTopping, "CoberturaDeCaper@pt"),
                    label(Capricciosa, "Capricciosa@pt"), label(Cajun, "Cajun@pt"),
                    label(Caprina, "Caprina@pt"),
                    label(CheeseTopping, "CoberturaDeQueijo@pt"),
                    label(CheeseyPizza, "PizzaComQueijo@pt"),
                    label(CheeseyVegetableTopping, "CoberturaDeQueijoComVegetais@pt"),
                    label(ChickenTopping, "CoberturaDeFrango@pt"),
                    label(Country, "Pais@pt"), label(DeepPanBase, "BaseEspessa@pt"),
                    label(Fiorentina, "Fiorentina@pt"),
                    label(FishTopping, "CoberturaDePeixe@pt"),
                    label(FourCheesesTopping, "CoberturaQuatroQueijos@pt"),
                    label(FourSeasons, "QuatroQueijos@pt"),
                    label(FruitTopping, "CoberturaDeFrutas@pt"),
                    label(FruttiDiMare, "FrutosDoMar@pt"),
                    label(GarlicTopping, "CoberturaDeAlho@pt"),
                    label(Giardiniera, "Giardiniera@pt"), label(Soho, "Soho@pt"));
            state(pizza,
                    sub(American, NamedPizza),
                    sub(American, some(hasTopping, MozzarellaTopping)),
                    sub(American, some(hasTopping, PeperoniSausageTopping)),
                    sub(American, some(hasTopping, TomatoTopping)),
                    sub(American,
                            all(hasTopping,
                                    or(MozzarellaTopping, PeperoniSausageTopping,
                                            TomatoTopping))),
                    sub(AmericanHot, NamedPizza),
                    sub(AmericanHot, some(hasTopping, HotGreenPepperTopping)),
                    sub(AmericanHot, some(hasTopping, JalapenoPepperTopping)),
                    sub(AmericanHot, some(hasTopping, MozzarellaTopping)),
                    sub(AmericanHot, some(hasTopping, PeperoniSausageTopping)),
                    sub(AmericanHot, some(hasTopping, TomatoTopping)),
                    sub(AmericanHot,
                            all(hasTopping,
                                    or(HotGreenPepperTopping, JalapenoPepperTopping,
                                            MozzarellaTopping, PeperoniSausageTopping,
                                            TomatoTopping))),
                    sub(AnchoviesTopping, FishTopping),
                    sub(ArtichokeTopping, VegetableTopping),
                    sub(ArtichokeTopping, some(hasSpiciness, Mild)),
                    sub(AsparagusTopping, VegetableTopping),
                    sub(AsparagusTopping, some(hasSpiciness, Mild)),
                    sub(Cajun, NamedPizza),
                    sub(Cajun, some(hasTopping, MozzarellaTopping)),
                    sub(Cajun, some(hasTopping, OnionTopping)),
                    sub(Cajun, some(hasTopping, PeperonataTopping)),
                    sub(Cajun, some(hasTopping, PrawnsTopping)),
                    sub(Cajun, some(hasTopping, TobascoPepperSauce)),
                    sub(Cajun, some(hasTopping, TomatoTopping)),
                    sub(Cajun,
                            all(hasTopping,
                                    or(MozzarellaTopping, OnionTopping,
                                            PeperonataTopping, PrawnsTopping,
                                            TobascoPepperSauce, TomatoTopping))),
                    sub(CajunSpiceTopping, HerbSpiceTopping),
                    sub(CajunSpiceTopping, some(hasSpiciness, Hot)),
                    sub(CaperTopping, VegetableTopping),
                    sub(CaperTopping, some(hasSpiciness, Mild)),
                    sub(Capricciosa, NamedPizza),
                    sub(Capricciosa, some(hasTopping, AnchoviesTopping)),
                    sub(Capricciosa, some(hasTopping, CaperTopping)),
                    sub(Capricciosa, some(hasTopping, HamTopping)),
                    sub(Capricciosa, some(hasTopping, MozzarellaTopping)),
                    sub(Capricciosa, some(hasTopping, OliveTopping)),
                    sub(Capricciosa, some(hasTopping, PeperonataTopping)),
                    sub(Capricciosa, some(hasTopping, TomatoTopping)),
                    sub(Capricciosa,
                            all(hasTopping,
                                    or(AnchoviesTopping, CaperTopping, HamTopping,
                                            MozzarellaTopping, OliveTopping,
                                            PeperonataTopping, TomatoTopping))),
                    sub(Caprina, NamedPizza),
                    sub(Caprina, some(hasTopping, GoatsCheeseTopping)),
                    sub(Caprina, some(hasTopping, MozzarellaTopping)),
                    sub(Caprina, some(hasTopping, SundriedTomatoTopping)),
                    sub(Caprina, some(hasTopping, TomatoTopping)),
                    sub(Caprina,
                            all(hasTopping,
                                    or(GoatsCheeseTopping, MozzarellaTopping,
                                            SundriedTomatoTopping, TomatoTopping))),
                    sub(CheeseTopping, PizzaTopping),
                    eq(CheeseyPizza, and(some(hasTopping, CheeseTopping), Pizza)),
                    sub(CheeseyVegetableTopping, CheeseTopping),
                    sub(CheeseyVegetableTopping, VegetableTopping),
                    sub(ChickenTopping, MeatTopping),
                    sub(ChickenTopping, some(hasSpiciness, Mild)),
                    eq(Country,
                            and(one(Italy, France, England, America, Germany),
                                    DomainConcept)),
                    sub(DeepPanBase, PizzaBase),
                    disjoint(DeepPanBase, ThinAndCrispyBase),
                    disjoint(DomainConcept, ValuePartition),
                    sub(Fiorentina, NamedPizza),
                    sub(Fiorentina, some(hasTopping, GarlicTopping)),
                    sub(Fiorentina, some(hasTopping, MozzarellaTopping)),
                    sub(Fiorentina, some(hasTopping, OliveTopping)),
                    sub(Fiorentina, some(hasTopping, ParmesanTopping)),
                    sub(Fiorentina, some(hasTopping, SpinachTopping)),
                    sub(Fiorentina, some(hasTopping, TomatoTopping)),
                    sub(Fiorentina,
                            all(hasTopping,
                                    or(GarlicTopping, MozzarellaTopping, OliveTopping,
                                            ParmesanTopping, SpinachTopping,
                                            TomatoTopping))),
                    sub(FishTopping, PizzaTopping),
                    sub(FishTopping, some(hasSpiciness, Mild)),
                    sub(FourCheesesTopping, CheeseTopping),
                    sub(FourCheesesTopping, some(hasSpiciness, Mild)),
                    sub(FourSeasons, NamedPizza),
                    sub(FourSeasons, some(hasTopping, AnchoviesTopping)),
                    sub(FourSeasons, some(hasTopping, CaperTopping)),
                    sub(FourSeasons, some(hasTopping, MozzarellaTopping)),
                    sub(FourSeasons, some(hasTopping, MushroomTopping)),
                    sub(FourSeasons, some(hasTopping, OliveTopping)),
                    sub(FourSeasons, some(hasTopping, PeperoniSausageTopping)),
                    sub(FourSeasons, some(hasTopping, TomatoTopping)),
                    sub(FourSeasons,
                            all(hasTopping,
                                    or(AnchoviesTopping, CaperTopping, MozzarellaTopping,
                                            MushroomTopping, OliveTopping,
                                            PeperoniSausageTopping, TomatoTopping))),
                    sub(FruitTopping, PizzaTopping),
                    sub(FruttiDiMare, NamedPizza),
                    sub(FruttiDiMare, some(hasTopping, GarlicTopping)),
                    sub(FruttiDiMare, some(hasTopping, MixedSeafoodTopping)),
                    sub(FruttiDiMare, some(hasTopping, TomatoTopping)),
                    sub(FruttiDiMare,
                            all(hasTopping,
                                    or(GarlicTopping, MixedSeafoodTopping, TomatoTopping))),
                    sub(GarlicTopping, VegetableTopping),
                    sub(GarlicTopping, some(hasSpiciness, Medium)),
                    sub(Giardiniera, NamedPizza),
                    sub(Giardiniera, some(hasTopping, LeekTopping)),
                    sub(Giardiniera, some(hasTopping, MozzarellaTopping)),
                    sub(Giardiniera, some(hasTopping, MushroomTopping)),
                    sub(Giardiniera, some(hasTopping, OliveTopping)),
                    sub(Giardiniera, some(hasTopping, PeperonataTopping)),
                    sub(Giardiniera, some(hasTopping, PetitPoisTopping)),
                    sub(Giardiniera, some(hasTopping, SlicedTomatoTopping)),
                    sub(Giardiniera, some(hasTopping, TomatoTopping)),
                    sub(Giardiniera,
                            all(hasTopping,
                                    or(LeekTopping, MozzarellaTopping, MushroomTopping,
                                            OliveTopping, PeperonataTopping,
                                            PetitPoisTopping, SlicedTomatoTopping,
                                            TomatoTopping))),
                    sub(GoatsCheeseTopping, CheeseTopping),
                    sub(GoatsCheeseTopping, some(hasSpiciness, Mild)),
                    sub(GorgonzolaTopping, CheeseTopping),
                    sub(GorgonzolaTopping, some(hasSpiciness, Mild)),
                    sub(GreenPepperTopping, PepperTopping),
                    sub(HamTopping, MeatTopping),
                    sub(HerbSpiceTopping, PizzaTopping),
                    sub(Hot, Spiciness),
                    sub(HotGreenPepperTopping, GreenPepperTopping),
                    sub(HotGreenPepperTopping, some(hasSpiciness, Hot)),
                    sub(HotSpicedBeefTopping, MeatTopping),
                    sub(HotSpicedBeefTopping, some(hasSpiciness, Hot)),
                    sub(IceCream, DomainConcept),
                    sub(IceCream, some(hasTopping, FruitTopping)),
                    eq(InterestingPizza, and(min(3, hasTopping, OWLThing()), Pizza)),
                    sub(JalapenoPepperTopping, PepperTopping),
                    sub(JalapenoPepperTopping, some(hasSpiciness, Hot)),
                    sub(LaReine, NamedPizza),
                    sub(LaReine, some(hasTopping, HamTopping)),
                    sub(LaReine, some(hasTopping, MozzarellaTopping)),
                    sub(LaReine, some(hasTopping, MushroomTopping)),
                    sub(LaReine, some(hasTopping, OliveTopping)),
                    sub(LaReine, some(hasTopping, TomatoTopping)),
                    sub(LaReine,
                            all(hasTopping,
                                    or(HamTopping, MozzarellaTopping, MushroomTopping,
                                            OliveTopping, TomatoTopping))),
                    sub(LeekTopping, VegetableTopping),
                    sub(LeekTopping, some(hasSpiciness, Mild)),
                    sub(Margherita, NamedPizza),
                    sub(Margherita, some(hasTopping, MozzarellaTopping)),
                    sub(Margherita, some(hasTopping, TomatoTopping)),
                    sub(Margherita, all(hasTopping, or(TomatoTopping, MozzarellaTopping))),
                    sub(MeatTopping, PizzaTopping),
                    eq(MeatyPizza, and(some(hasTopping, MeatTopping), Pizza)),
                    sub(Medium, Spiciness),
                    sub(Mild, Spiciness),
                    sub(MixedSeafoodTopping, FishTopping),
                    sub(MozzarellaTopping, CheeseTopping),
                    sub(MozzarellaTopping, some(hasSpiciness, Mild)),
                    sub(MozzarellaTopping, has(hasCountryOfOrigin, Italy)),
                    sub(Mushroom, NamedPizza),
                    sub(Mushroom, some(hasTopping, MozzarellaTopping)),
                    sub(Mushroom, some(hasTopping, MushroomTopping)),
                    sub(Mushroom, some(hasTopping, TomatoTopping)),
                    sub(Mushroom,
                            all(hasTopping,
                                    or(MozzarellaTopping, MushroomTopping, TomatoTopping))),
                    sub(MushroomTopping, VegetableTopping),
                    sub(MushroomTopping, some(hasSpiciness, Mild)),
                    sub(NamedPizza, Pizza),
                    sub(Napoletana, NamedPizza),
                    sub(Napoletana, some(hasTopping, AnchoviesTopping)),
                    sub(Napoletana, some(hasTopping, CaperTopping)),
                    sub(Napoletana, some(hasTopping, MozzarellaTopping)),
                    sub(Napoletana, some(hasTopping, OliveTopping)),
                    sub(Napoletana, some(hasTopping, TomatoTopping)),
                    sub(Napoletana,
                            all(hasTopping,
                                    or(AnchoviesTopping, CaperTopping, MozzarellaTopping,
                                            OliveTopping, TomatoTopping))),
                    eq(NonVegetarianPizza, and(c(VegetarianPizza), Pizza)),
                    disjoint(NonVegetarianPizza, VegetarianPizza),
                    sub(NutTopping, PizzaTopping),
                    sub(NutTopping, some(hasSpiciness, Mild)),
                    sub(OliveTopping, VegetableTopping),
                    sub(OliveTopping, some(hasSpiciness, Mild)),
                    sub(OnionTopping, VegetableTopping),
                    sub(OnionTopping, some(hasSpiciness, Medium)),
                    sub(ParmaHamTopping, HamTopping),
                    sub(ParmaHamTopping, some(hasSpiciness, Mild)),
                    sub(Parmense, NamedPizza),
                    sub(Parmense, some(hasTopping, AsparagusTopping)),
                    sub(Parmense, some(hasTopping, HamTopping)),
                    sub(Parmense, some(hasTopping, MozzarellaTopping)),
                    sub(Parmense, some(hasTopping, ParmesanTopping)),
                    sub(Parmense, some(hasTopping, TomatoTopping)),
                    sub(Parmense,
                            all(hasTopping,
                                    or(AsparagusTopping, HamTopping, MozzarellaTopping,
                                            ParmesanTopping, TomatoTopping))),
                    sub(ParmesanTopping, CheeseTopping),
                    sub(ParmesanTopping, some(hasSpiciness, Mild)),
                    sub(PeperonataTopping, PepperTopping),
                    sub(PeperonataTopping, some(hasSpiciness, Medium)),
                    sub(PeperoniSausageTopping, MeatTopping),
                    sub(PeperoniSausageTopping, some(hasSpiciness, Medium)),
                    sub(PepperTopping, VegetableTopping),
                    sub(PetitPoisTopping, VegetableTopping),
                    sub(PetitPoisTopping, some(hasSpiciness, Mild)),
                    sub(PineKernels, NutTopping),
                    sub(Pizza, DomainConcept),
                    sub(Pizza, some(hasBase, PizzaBase)),
                    sub(PizzaBase, DomainConcept),
                    sub(PizzaTopping, DomainConcept),
                    sub(PolloAdAstra, NamedPizza),
                    sub(PolloAdAstra, some(hasTopping, CajunSpiceTopping)),
                    sub(PolloAdAstra, some(hasTopping, ChickenTopping)),
                    sub(PolloAdAstra, some(hasTopping, GarlicTopping)),
                    sub(PolloAdAstra, some(hasTopping, MozzarellaTopping)),
                    sub(PolloAdAstra, some(hasTopping, RedOnionTopping)),
                    sub(PolloAdAstra, some(hasTopping, SweetPepperTopping)),
                    sub(PolloAdAstra, some(hasTopping, TomatoTopping)),
                    sub(PolloAdAstra,
                            all(hasTopping,
                                    or(CajunSpiceTopping, ChickenTopping, GarlicTopping,
                                            MozzarellaTopping, RedOnionTopping,
                                            SweetPepperTopping, TomatoTopping))),
                    sub(PrawnsTopping, FishTopping),
                    sub(PrinceCarlo, NamedPizza),
                    sub(PrinceCarlo, some(hasTopping, LeekTopping)),
                    sub(PrinceCarlo, some(hasTopping, MozzarellaTopping)),
                    sub(PrinceCarlo, some(hasTopping, ParmesanTopping)),
                    sub(PrinceCarlo, some(hasTopping, RosemaryTopping)),
                    sub(PrinceCarlo, some(hasTopping, TomatoTopping)),
                    sub(PrinceCarlo,
                            all(hasTopping,
                                    or(LeekTopping, MozzarellaTopping, ParmesanTopping,
                                            RosemaryTopping, TomatoTopping))),
                    sub(QuattroFormaggi, NamedPizza),
                    sub(QuattroFormaggi, some(hasTopping, FourCheesesTopping)),
                    sub(QuattroFormaggi, some(hasTopping, TomatoTopping)),
                    sub(QuattroFormaggi,
                            all(hasTopping, or(TomatoTopping, FourCheesesTopping))),
                    eq(RealItalianPizza, and(has(hasCountryOfOrigin, Italy), Pizza)),
                    sub(RealItalianPizza, all(hasBase, ThinAndCrispyBase)),
                    sub(RedOnionTopping, OnionTopping),
                    sub(RocketTopping, VegetableTopping),
                    sub(RocketTopping, some(hasSpiciness, Medium)),
                    sub(Rosa, NamedPizza),
                    sub(Rosa, some(hasTopping, GorgonzolaTopping)),
                    sub(Rosa, some(hasTopping, MozzarellaTopping)),
                    sub(Rosa, some(hasTopping, TomatoTopping)),
                    sub(Rosa,
                            all(hasTopping,
                                    or(GorgonzolaTopping, MozzarellaTopping,
                                            TomatoTopping))),
                    sub(RosemaryTopping, HerbSpiceTopping),
                    sub(RosemaryTopping, some(hasSpiciness, Mild)),
                    sub(SauceTopping, PizzaTopping),
                    sub(Siciliana, NamedPizza),
                    sub(Siciliana, some(hasTopping, AnchoviesTopping)),
                    sub(Siciliana, some(hasTopping, ArtichokeTopping)),
                    sub(Siciliana, some(hasTopping, GarlicTopping)),
                    sub(Siciliana, some(hasTopping, HamTopping)),
                    sub(Siciliana, some(hasTopping, MozzarellaTopping)),
                    sub(Siciliana, some(hasTopping, OliveTopping)),
                    sub(Siciliana, some(hasTopping, TomatoTopping)),
                    sub(Siciliana,
                            all(hasTopping,
                                    or(AnchoviesTopping, ArtichokeTopping, GarlicTopping,
                                            HamTopping, MozzarellaTopping, OliveTopping,
                                            TomatoTopping))),
                    sub(SlicedTomatoTopping, TomatoTopping),
                    sub(SlicedTomatoTopping, some(hasSpiciness, Mild)),
                    sub(SloppyGiuseppe, NamedPizza),
                    sub(SloppyGiuseppe, some(hasTopping, GreenPepperTopping)),
                    sub(SloppyGiuseppe, some(hasTopping, HotSpicedBeefTopping)),
                    sub(SloppyGiuseppe, some(hasTopping, MozzarellaTopping)),
                    sub(SloppyGiuseppe, some(hasTopping, OnionTopping)),
                    sub(SloppyGiuseppe, some(hasTopping, TomatoTopping)),
                    sub(SloppyGiuseppe,
                            all(hasTopping,
                                    or(GreenPepperTopping, HotSpicedBeefTopping,
                                            MozzarellaTopping, OnionTopping,
                                            TomatoTopping))),
                    sub(Soho, NamedPizza),
                    sub(Soho, some(hasTopping, GarlicTopping)),
                    sub(Soho, some(hasTopping, MozzarellaTopping)),
                    sub(Soho, some(hasTopping, OliveTopping)),
                    sub(Soho, some(hasTopping, ParmesanTopping)),
                    sub(Soho, some(hasTopping, RocketTopping)),
                    sub(Soho, some(hasTopping, TomatoTopping)),
                    sub(Soho,
                            all(hasTopping,
                                    or(GarlicTopping, MozzarellaTopping, OliveTopping,
                                            ParmesanTopping, RocketTopping, TomatoTopping))),
                    eq(Spiciness, or(Hot, Medium, Mild)),
                    sub(Spiciness, ValuePartition),
                    eq(SpicyPizza, and(some(hasTopping, SpicyTopping), Pizza)),
                    eq(SpicyPizzaEquivalent,
                            and(some(hasTopping,
                                    and(some(hasSpiciness, Hot), PizzaTopping)), Pizza)),
                    eq(SpicyTopping, and(some(hasSpiciness, Hot), PizzaTopping)),
                    sub(SpinachTopping, VegetableTopping),
                    sub(SpinachTopping, some(hasSpiciness, Mild)),
                    sub(SultanaTopping, FruitTopping),
                    sub(SultanaTopping, some(hasSpiciness, Medium)),
                    sub(SundriedTomatoTopping, TomatoTopping),
                    sub(SundriedTomatoTopping, some(hasSpiciness, Mild)),
                    sub(SweetPepperTopping, PepperTopping),
                    sub(SweetPepperTopping, some(hasSpiciness, Mild)),
                    sub(ThinAndCrispyBase, PizzaBase),
                    sub(TobascoPepperSauce, SauceTopping),
                    sub(TobascoPepperSauce, some(hasSpiciness, Hot)),
                    sub(TomatoTopping, VegetableTopping),
                    sub(TomatoTopping, some(hasSpiciness, Mild)),
                    sub(UnclosedPizza, NamedPizza),
                    sub(UnclosedPizza, some(hasTopping, MozzarellaTopping)),
                    sub(VegetableTopping, PizzaTopping),
                    eq(VegetarianPizza,
                            and(Pizza, c(some(hasTopping, FishTopping)),
                                    c(some(hasTopping, MeatTopping)))),
                    eq(VegetarianPizzaEquivalent1,
                            and(all(hasTopping, VegetarianTopping), Pizza)),
                    eq(VegetarianPizzaEquivalent2,
                            and(all(hasTopping,
                                    or(CheeseTopping, FruitTopping, HerbSpiceTopping,
                                            NutTopping, SauceTopping, VegetableTopping)),
                                    Pizza)),
                    eq(VegetarianTopping,
                            and(or(CheeseTopping, FruitTopping, HerbSpiceTopping,
                                    NutTopping, SauceTopping, VegetableTopping),
                                    PizzaTopping)),
                    sub(Veneziana, NamedPizza),
                    sub(Veneziana, some(hasTopping, CaperTopping)),
                    sub(Veneziana, some(hasTopping, MozzarellaTopping)),
                    sub(Veneziana, some(hasTopping, OliveTopping)),
                    sub(Veneziana, some(hasTopping, OnionTopping)),
                    sub(Veneziana, some(hasTopping, PineKernels)),
                    sub(Veneziana, some(hasTopping, SultanaTopping)),
                    sub(Veneziana, some(hasTopping, TomatoTopping)),
                    sub(Veneziana,
                            all(hasTopping,
                                    or(CaperTopping, MozzarellaTopping, OliveTopping,
                                            OnionTopping, PineKernels, SultanaTopping,
                                            TomatoTopping))),
                    sub(hasBase, hasIngredient),
                    inverse(hasBase, isBaseOf),
                    func(hasBase),
                    invfunc(hasBase),
                    domain(hasBase, Pizza),
                    range(hasBase, PizzaBase),
                    inverse(hasIngredient, isIngredientOf),
                    transitive(hasIngredient),
                    func(hasSpiciness),
                    range(hasSpiciness, Spiciness),
                    sub(hasTopping, hasIngredient),
                    inverse(isToppingOf, hasTopping),
                    domain(hasTopping, Pizza),
                    range(hasTopping, PizzaTopping),
                    sub(isBaseOf, isIngredientOf),
                    func(isBaseOf),
                    invfunc(isBaseOf),
                    domain(isBaseOf, PizzaBase),
                    range(isBaseOf, Pizza),
                    transitive(isIngredientOf),
                    sub(isToppingOf, isIngredientOf),
                    domain(isToppingOf, PizzaTopping),
                    range(isToppingOf, Pizza),
                    ClassAssertion(Country, America),
                    ClassAssertion(Country, England),
                    ClassAssertion(Country, France),
                    ClassAssertion(Country, Germany),
                    ClassAssertion(Country, Italy),
                    disjoint(ArtichokeTopping, AsparagusTopping, CaperTopping,
                            CheeseTopping, ChickenTopping, FishTopping,
                            FourCheesesTopping, FruitTopping, GarlicTopping,
                            GoatsCheeseTopping, GorgonzolaTopping, GreenPepperTopping,
                            HamTopping, HerbSpiceTopping, HotSpicedBeefTopping,
                            JalapenoPepperTopping, LeekTopping, MeatTopping,
                            MixedSeafoodTopping, MozzarellaTopping, MushroomTopping,
                            NutTopping, OliveTopping, OnionTopping, ParmesanTopping,
                            PeperonataTopping, PeperoniSausageTopping, PepperTopping,
                            PetitPoisTopping, PrawnsTopping, RocketTopping, SauceTopping,
                            SlicedTomatoTopping, SpinachTopping, SundriedTomatoTopping,
                            SweetPepperTopping, TomatoTopping, VegetableTopping),
                    disjoint(IceCream, Pizza, PizzaBase, PizzaTopping),
                    disjoint(American, AmericanHot, Cajun, Capricciosa, Caprina,
                            Fiorentina, FourSeasons, FruttiDiMare, Giardiniera, LaReine,
                            Margherita, Mushroom, Napoletana, Parmense, PolloAdAstra,
                            PrinceCarlo, QuattroFormaggi, Rosa, Siciliana,
                            SloppyGiuseppe, Soho, UnclosedPizza, Veneziana),
                    diff(America, England, France, Germany, Italy),
                    disjoint(Hot, Medium, Mild));
            return pizza;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static OWLOntology patternedPizza(OWLOntologyManager m) {
        try {
            OWLOntology patternedPizza = m.createOntology(IRI("http://patterns/pizza"));
            m.applyChange(new AddImport(patternedPizza,
                    ImportsDeclaration(IRI("http://pizza.com/pizza.owl"))));
            OWLAnnotationProperty named = ann("http://patterns#namedPizza");
            OWLAnnotation ann = ann(
                    named,
                    Literal("?base:CLASS, ?topping:CLASS, ?allToppings:CLASS = createUnion(?topping.VALUES)  BEGIN ADD ?_thisClass subClassOf Pizza, ADD ?_thisClass subClassOf hasTopping some ?topping, ADD ?_thisClass subClassOf hasTopping only ?allToppings, ADD ?_thisClass subClassOf hasBase some ?base END; A pizza with ?base base and ?topping toppings ",
                            string()));
            m.applyChange(new AddOntologyAnnotation(patternedPizza, ann));
            declare(patternedPizza, named);
            return patternedPizza;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static OWLOntology pizzaLuigi(OWLOntologyManager m) {
        String ns = "http://pizza.com/pizza.owl#";
        String ns1 = "http://www.co-ode.org/patterns#";
        try {
            OWLOntology pizza = m.createOntology(IRI("http://patterns/pizzaluigi"));
            m.applyChange(new AddImport(pizza,
                    ImportsDeclaration(IRI("http://pizza.com/pizza.owl"))));
            OWLAnnotationProperty namedPizza = ann(ns1 + "namedPizza");
            OWLAnnotation ann = ann(
                    namedPizza,
                    Literal("?base:CLASS, ?topping:CLASS, ?allToppings:CLASS = createUnion(?topping.VALUES)  BEGIN ADD ?_thisClass subClassOf Pizza, ADD ?_thisClass subClassOf hasTopping some ?topping, ADD ?_thisClass subClassOf hasTopping only ?allToppings, ADD ?_thisClass subClassOf hasBase some ?base END; A pizza with ?base base and ?topping toppings",
                            string()));
            m.applyChange(new AddOntologyAnnotation(pizza, ann));
            OWLClass LuigiPizza = Class("http://patterns/pizzaluigi#LuigiPizza");
            OWLClass ChickenTopping = Class(ns + "ChickenTopping");
            OWLClass DeepPanBase = Class(ns + "DeepPanBase");
            OWLClass HotSpicedBeefTopping = Class(ns + "HotSpicedBeefTopping");
            OWLClass ParmaHamTopping = Class(ns + "ParmaHamTopping");
            OWLClass Pizza = Class(ns + "Pizza");
            OWLClass ThinAndCrispyBase = Class(ns + "ThinAndCrispyBase");
            OWLObjectProperty hasBase = object(ns + "hasBase");
            OWLObjectProperty hasTopping = object(ns + "hasTopping");
            OWLAnnotationProperty LuigiPizzanamedPizzaPatternInstantiation = ann(ns1
                    + "LuigiPizzanamedPizzaPatternInstantiation");
            OWLAnnotationProperty createdBy = ann(ns1 + "createdBy");
            OWLAnnotationProperty namedPizzaPatternInstantiation = ann(ns1
                    + "namedPizzaPatternInstantiation");
            OWLLiteral lit = Literal(
                    "http://www.co-ode.org/patterns#namedPizzaPatternInstantiation",
                    string());
            Set<OWLAnnotation> a = Collections.singleton(ann(createdBy, lit));
            declare(pizza, LuigiPizza, Pizza, ThinAndCrispyBase, hasBase, hasTopping,
                    createdBy, ChickenTopping, DeepPanBase, HotSpicedBeefTopping,
                    namedPizza, ParmaHamTopping,
                    LuigiPizzanamedPizzaPatternInstantiation,
                    namedPizzaPatternInstantiation);
            state(pizza,
                    ann(namedPizzaPatternInstantiation,
                            LuigiPizza.getIRI(),
                            Literal("$namedPizza(DeepPanBase, {HotSpicedBeefTopping, ChickenTopping})",
                                    string())),
                    sub(LuigiPizza, Pizza, a),
                    sub(LuigiPizza, some(hasBase, DeepPanBase), a),
                    sub(LuigiPizza, some(hasTopping, ChickenTopping), a),
                    sub(LuigiPizza, some(hasTopping, HotSpicedBeefTopping), a),
                    sub(LuigiPizza,
                            all(hasTopping, or(HotSpicedBeefTopping, ChickenTopping)), a));
            return pizza;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static OWLOntology dul(OWLOntologyManager m) {
        String ns = "http://www.loa-cnr.it/ontologies/DUL.owl#";
        try {
            OWLOntology dul = m
                    .createOntology(IRI("http://www.loa-cnr.it/ontologies/DUL.owl"));
            OWLClass Abstract = Class(ns + "Abstract");
            OWLClass BiologicalObject = Class(ns + "BiologicalObject");
            OWLClass Concept = Class(ns + "Concept");
            OWLClass Action = Class(ns + "Action");
            OWLClass ChemicalObject = Class(ns + "ChemicalObject");
            OWLClass Configuration = Class(ns + "Configuration");
            OWLClass Agent = Class(ns + "Agent");
            OWLClass Classification = Class(ns + "Classification");
            OWLClass Contract = Class(ns + "Contract");
            OWLClass Amount = Class(ns + "Amount");
            OWLClass Collection = Class(ns + "Collection");
            OWLClass Description = Class(ns + "Description");
            OWLClass Collective = Class(ns + "Collective");
            OWLClass Design = Class(ns + "Design");
            OWLClass CollectiveAgent = Class(ns + "CollectiveAgent");
            OWLClass Community = Class(ns + "Community");
            OWLClass FunctionalSubstance = Class(ns + "FunctionalSubstance");
            OWLClass DesignedArtifact = Class(ns + "DesignedArtifact");
            OWLClass InformationEntity = Class(ns + "InformationEntity");
            OWLClass Goal = Class(ns + "Goal");
            OWLClass DesignedSubstance = Class(ns + "DesignedSubstance");
            OWLClass InformationObject = Class(ns + "InformationObject");
            OWLClass Group = Class(ns + "Group");
            OWLClass Diagnosis = Class(ns + "Diagnosis");
            OWLClass InformationRealization = Class(ns + "InformationRealization");
            OWLClass Entity = Class(ns + "Entity");
            OWLClass LocalConcept = Class(ns + "LocalConcept");
            OWLClass Event = Class(ns + "Event");
            OWLClass Method = Class(ns + "Method");
            OWLClass EventType = Class(ns + "EventType");
            OWLClass Narrative = Class(ns + "Narrative");
            OWLClass FormalEntity = Class(ns + "FormalEntity");
            OWLClass NaturalPerson = Class(ns + "NaturalPerson");
            OWLClass Norm = Class(ns + "Norm");
            OWLClass Object = Class(ns + "Object");
            OWLClass Organism = Class(ns + "Organism");
            OWLClass Organization = Class(ns + "Organization");
            OWLClass Parameter = Class(ns + "Parameter");
            OWLClass Pattern = Class(ns + "Pattern");
            OWLClass Personification = Class(ns + "Personification");
            OWLClass PhysicalAgent = Class(ns + "PhysicalAgent");
            OWLClass PhysicalArtifact = Class(ns + "PhysicalArtifact");
            OWLClass PhysicalAttribute = Class(ns + "PhysicalAttribute");
            OWLClass PhysicalBody = Class(ns + "PhysicalBody");
            OWLClass PhysicalObject = Class(ns + "PhysicalObject");
            OWLClass PhysicalPlace = Class(ns + "PhysicalPlace");
            OWLClass Place = Class(ns + "Place");
            OWLClass Plan = Class(ns + "Plan");
            OWLClass PlanExecution = Class(ns + "PlanExecution");
            OWLClass Process = Class(ns + "Process");
            OWLClass Project = Class(ns + "Project");
            OWLClass Quality = Class(ns + "Quality");
            OWLClass Region = Class(ns + "Region");
            OWLClass Relation = Class(ns + "Relation");
            OWLClass Right = Class(ns + "Right");
            OWLClass Role = Class(ns + "Role");
            OWLClass Set = Class(ns + "Set");
            OWLClass Situation = Class(ns + "Situation");
            OWLClass SocialAgent = Class(ns + "SocialAgent");
            OWLClass SocialObject = Class(ns + "SocialObject");
            OWLClass SocialObjectAttribute = Class(ns + "SocialObjectAttribute");
            OWLClass SocialPerson = Class(ns + "SocialPerson");
            OWLClass SocialRelation = Class(ns + "SocialRelation");
            OWLClass SpaceRegion = Class(ns + "SpaceRegion");
            OWLClass SpatioTemporalRegion = Class(ns + "SpatioTemporalRegion");
            OWLClass Substance = Class(ns + "Substance");
            OWLClass Task = Class(ns + "Task");
            OWLClass Theory = Class(ns + "Theory");
            OWLClass TimeInterval = Class(ns + "TimeInterval");
            OWLClass Transition = Class(ns + "Transition");
            OWLClass TypeCollection = Class(ns + "TypeCollection");
            OWLClass UnitOfMeasure = Class(ns + "UnitOfMeasure");
            OWLClass Workflow = Class(ns + "Workflow");
            OWLClass WorkflowExecution = Class(ns + "WorkflowExecution");
            OWLObjectProperty actsFor = object(ns + "actsFor");
            OWLObjectProperty actsThrough = object(ns + "actsThrough");
            OWLObjectProperty characterizes = object(ns + "characterizes");
            OWLObjectProperty classifies = object(ns + "classifies");
            OWLObjectProperty conceptualizes = object(ns + "conceptualizes");
            OWLObjectProperty concretelyExpresses = object(ns + "concretelyExpresses");
            OWLObjectProperty coparticipatesWith = object(ns + "coparticipatesWith");
            OWLObjectProperty covers = object(ns + "covers");
            OWLObjectProperty defines = object(ns + "defines");
            OWLObjectProperty definesRole = object(ns + "definesRole");
            OWLObjectProperty definesTask = object(ns + "definesTask");
            OWLObjectProperty describes = object(ns + "describes");
            OWLObjectProperty directlyFollows = object(ns + "directlyFollows");
            OWLObjectProperty directlyPrecedes = object(ns + "directlyPrecedes");
            OWLObjectProperty executesTask = object(ns + "executesTask");
            OWLObjectProperty expands = object(ns + "expands");
            OWLObjectProperty expresses = object(ns + "expresses");
            OWLObjectProperty expressesConcept = object(ns + "expressesConcept");
            OWLObjectProperty farFrom = object(ns + "farFrom");
            OWLObjectProperty follows = object(ns + "follows");
            OWLObjectProperty hasCommonBoundary = object(ns + "hasCommonBoundary");
            OWLObjectProperty hasComponent = object(ns + "hasComponent");
            OWLObjectProperty hasConstituent = object(ns + "hasConstituent");
            OWLObjectProperty hasConstraint = object(ns + "hasConstraint");
            OWLObjectProperty hasLocation = object(ns + "hasLocation");
            OWLObjectProperty hasMember = object(ns + "hasMember");
            OWLObjectProperty hasParameter = object(ns + "hasParameter");
            OWLObjectProperty hasPart = object(ns + "hasPart");
            OWLObjectProperty hasParticipant = object(ns + "hasParticipant");
            OWLObjectProperty hasPostcondition = object(ns + "hasPostcondition");
            OWLObjectProperty hasPrecondition = object(ns + "hasPrecondition");
            OWLObjectProperty hasQuality = object(ns + "hasQuality");
            OWLObjectProperty hasRegion = object(ns + "hasRegion");
            OWLObjectProperty hasRole = object(ns + "hasRole");
            OWLObjectProperty hasSetting = object(ns + "hasSetting");
            OWLObjectProperty hasTask = object(ns + "hasTask");
            OWLObjectProperty includesAction = object(ns + "includesAction");
            OWLObjectProperty includesAgent = object(ns + "includesAgent");
            OWLObjectProperty includesEvent = object(ns + "includesEvent");
            OWLObjectProperty includesObject = object(ns + "includesObject");
            OWLObjectProperty includesTime = object(ns + "includesTime");
            OWLObjectProperty introduces = object(ns + "introduces");
            OWLObjectProperty involvesAgent = object(ns + "involvesAgent");
            OWLObjectProperty isAbout = object(ns + "isAbout");
            OWLObjectProperty isActionIncludedIn = object(ns + "isActionIncludedIn");
            OWLObjectProperty isAgentIncludedIn = object(ns + "isAgentIncludedIn");
            OWLObjectProperty isAgentInvolvedIn = object(ns + "isAgentInvolvedIn");
            OWLObjectProperty isCharacterizedBy = object(ns + "isCharacterizedBy");
            OWLObjectProperty isClassifiedBy = object(ns + "isClassifiedBy");
            OWLObjectProperty isComponentOf = object(ns + "isComponentOf");
            OWLObjectProperty isConceptExpressedBy = object(ns + "isConceptExpressedBy");
            OWLObjectProperty isConceptUsedIn = object(ns + "isConceptUsedIn");
            OWLObjectProperty isConceptualizedBy = object(ns + "isConceptualizedBy");
            OWLObjectProperty isConcretelyExpressedBy = object(ns
                    + "isConcretelyExpressedBy");
            OWLObjectProperty isConstituentOf = object(ns + "isConstituentOf");
            OWLObjectProperty isConstraintFor = object(ns + "isConstraintFor");
            OWLObjectProperty isCoveredBy = object(ns + "isCoveredBy");
            OWLObjectProperty isDefinedIn = object(ns + "isDefinedIn");
            OWLObjectProperty isDescribedBy = object(ns + "isDescribedBy");
            OWLObjectProperty isEventIncludedIn = object(ns + "isEventIncludedIn");
            OWLObjectProperty isExecutedIn = object(ns + "isExecutedIn");
            OWLObjectProperty isExpandedIn = object(ns + "isExpandedIn");
            OWLObjectProperty isExpressedBy = object(ns + "isExpressedBy");
            OWLObjectProperty isIntroducedBy = object(ns + "isIntroducedBy");
            OWLObjectProperty isLocationOf = object(ns + "isLocationOf");
            OWLObjectProperty isMemberOf = object(ns + "isMemberOf");
            OWLObjectProperty isObjectIncludedIn = object(ns + "isObjectIncludedIn");
            OWLObjectProperty isObservableAt = object(ns + "isObservableAt");
            OWLObjectProperty isParameterFor = object(ns + "isParameterFor");
            OWLObjectProperty isParametrizedBy = object(ns + "isParametrizedBy");
            OWLObjectProperty isPartOf = object(ns + "isPartOf");
            OWLObjectProperty isParticipantIn = object(ns + "isParticipantIn");
            OWLObjectProperty isPostconditionOf = object(ns + "isPostconditionOf");
            OWLObjectProperty isPreconditionOf = object(ns + "isPreconditionOf");
            OWLObjectProperty isQualityOf = object(ns + "isQualityOf");
            OWLObjectProperty isRealizedBy = object(ns + "isRealizedBy");
            OWLObjectProperty isReferenceOf = object(ns + "isReferenceOf");
            OWLObjectProperty isReferenceOfInformationRealizedBy = object(ns
                    + "isReferenceOfInformationRealizedBy");
            OWLObjectProperty isRegionFor = object(ns + "isRegionFor");
            OWLObjectProperty isRelatedToConcept = object(ns + "isRelatedToConcept");
            OWLObjectProperty isRelatedToDescription = object(ns
                    + "isRelatedToDescription");
            OWLObjectProperty isRoleDefinedIn = object(ns + "isRoleDefinedIn");
            OWLObjectProperty isRoleOf = object(ns + "isRoleOf");
            OWLObjectProperty isSatisfiedBy = object(ns + "isSatisfiedBy");
            OWLObjectProperty isSettingFor = object(ns + "isSettingFor");
            OWLObjectProperty isSpecializedBy = object(ns + "isSpecializedBy");
            OWLObjectProperty isSubordinatedTo = object(ns + "isSubordinatedTo");
            OWLObjectProperty isSuperordinatedTo = object(ns + "isSuperordinatedTo");
            OWLObjectProperty isTaskDefinedIn = object(ns + "isTaskDefinedIn");
            OWLObjectProperty isTaskOf = object(ns + "isTaskOf");
            OWLObjectProperty isTimeIncludedIn = object(ns + "isTimeIncludedIn");
            OWLObjectProperty isTimeOfObservationOf = object(ns + "isTimeOfObservationOf");
            OWLObjectProperty isUnifiedBy = object(ns + "isUnifiedBy");
            OWLObjectProperty nearTo = object(ns + "nearTo");
            OWLObjectProperty overlaps = object(ns + "overlaps");
            OWLObjectProperty parametrizes = object(ns + "parametrizes");
            OWLObjectProperty precedes = object(ns + "precedes");
            OWLObjectProperty realizes = object(ns + "realizes");
            OWLObjectProperty realizesInformationAbout = object(ns
                    + "realizesInformationAbout");
            OWLObjectProperty satisfies = object(ns + "satisfies");
            OWLObjectProperty specializes = object(ns + "specializes");
            OWLObjectProperty unifies = object(ns + "unifies");
            OWLObjectProperty usesConcept = object(ns + "usesConcept");
            OWLDataProperty hasDataValue = DataProperty(ns + "hasDataValue");
            OWLDataProperty hasEventDate = DataProperty(ns + "hasEventDate");
            OWLDataProperty hasIntervalDate = DataProperty(ns + "hasIntervalDate");
            OWLDataProperty hasParameterDataValue = DataProperty(ns
                    + "hasParameterDataValue");
            OWLDataProperty hasProxy = DataProperty(ns + "hasProxy");
            OWLDataProperty hasRegionDataValue = DataProperty(ns + "hasRegionDataValue");
            OWLAnnotationProperty mappableTo = ann(ns + "mappableTo");
            OWLClass Person = Class(ns + "Person");
            declare(dul, DesignedSubstance, SpatioTemporalRegion, InformationEntity);
            state(dul,
                    label(Abstract, "Astratto@it", "Abstract@en"),
                    label(Action, "Action@en", "Azione@it"),
                    label(Agent, "Agent@en", "Agente@it"),
                    label(Amount, "Amount@en", "Quantità@it"),
                    label(BiologicalObject, "Biological object@en"),
                    label(ChemicalObject, "Chemical object@en"),
                    label(Classification, "Classificazione@it", "Classification@en"),
                    label(Collection, "Collezione@it", "Collection@en"),
                    label(Collective, "Collective@en", "Collettivo@it"),
                    label(CollectiveAgent, "Agente collettivo@it", "Collective agent@en"),
                    label(Community, "Community@en", "Comunità@it"),
                    label(Concept, "Concept@en", "Concetto@it"),
                    label(Configuration, "Configurazione@it", "Configuration@en"),
                    label(Contract, "Contratto@it", "Contract@en"),
                    label(Description, "Descrizione@it", "Description@en"),
                    label(Design, "Design@it", "Design@en"),
                    label(DesignedArtifact, "Artefatto progettato@it",
                            "Designed artifact@en"),
                    label(Diagnosis, "Diagnosis@en", "Diagnosi@it"),
                    label(Entity, "Entity@en", "Entità@it"),
                    label(Event, "Event@en", "Evento@it"),
                    label(hasEventDate, "has event date@en", "evento ha data@it"),
                    label(hasIntervalDate, "intervallo ha data@it",
                            "has interval date@en"),
                    label(hasParameterDataValue, "ha valore@it",
                            "has parameter data value@en"),
                    label(EventType, "Tipo di evento@it", "Event type@en"),
                    label(FormalEntity, "Entità formale astratta@it", "Formal entity@en"),
                    label(FunctionalSubstance, "Functional substance@en"),
                    label(Goal, "Goal@en", "Scopo@it"),
                    label(Group, "Gruppo@it", "Group@en"),
                    label(InformationObject, "Information object@en",
                            "Oggetto informativo@it"),
                    label(InformationRealization, "Information realization@en",
                            "Informazione concreta@it"),
                    label(LocalConcept, "Local concept@en"),
                    label(Method, "Metodo@it", "Method@en"),
                    label(Narrative, "Narrative@en"),
                    label(NaturalPerson, "Persona fisica@it", "Natural person@en"),
                    label(Norm, "Norma@it", "Norm@en"),
                    label(Object, "Object@en", "Oggetto@it"),
                    label(Organization, "Organization@en", "Organizzazione@it"),
                    label(Parameter, "Parametro@it"),
                    label(Parameter, "Parameter@en"),
                    label(Pattern, "Pattern@en"),
                    label(Person, "Persona {it}"),
                    label(Person, "Person@en"),
                    label(Personification, "Personification@en"),
                    label(PhysicalAgent, "Physical agent@en", "Agente fisico@it"),
                    label(PhysicalArtifact, "Artefatto fisico@it", "Physical artifact@en"),
                    label(Organism, "Organism@en", "Organismo@it"),
                    label(PhysicalAttribute, "Physical attribute@en",
                            "Caratteristica fisica@it"),
                    label(PhysicalObject, "Oggetto fisico@it", "Physical object@en"),
                    label(PhysicalPlace, "Luogo fisico@it", "Physical place@en"),
                    label(Place, "Place@en", "Luogo@it"),
                    label(PhysicalBody, "Physical body@en"),
                    label(Process, "Process@en", "Processo@it"),
                    label(Plan, "Plan@en", "Piano@it"),
                    label(PlanExecution, "Esecuzione di piano@it", "Plan execution@en"),
                    label(Project, "Project@en", "Progetto@it"),
                    label(Quality, "Qualità@it", "Quality@en"),
                    label(Region, "Region@en", "Regione@it"),
                    label(Relation, "Relation@en", "Relazione@it"),
                    label(Right, "Right@en", "Diritto@it"),
                    label(Role, "Ruolo@it", "Role@en"),
                    label(SocialPerson, "Persona sociale@it", "Social person@en"),
                    label(Set, "Set@en", "Insieme {it}"),
                    label(Situation, "Situazione@it", "Situation@en"),
                    label(SocialAgent, "Social agent@en", "Agente sociale@it"),
                    label(SocialObject, "Social object@en", "Oggetto sociale@it"),
                    label(SocialObjectAttribute, "Social attribute@en",
                            "Caratteristica sociale@it"),
                    label(SocialRelation, "Social relation@en", "Relazione sociale@it"),
                    label(SpaceRegion, "Space region@en", "Regione di spazio@it"),
                    label(Substance, "Sostanza@it", "Substance@en"),
                    label(Task, "Task@en", "Task@it"),
                    label(Theory, "Teoria@it", "Theory@en"),
                    label(TimeInterval, "Intervallo di tempo@it", "Time interval@en"),
                    label(Transition, "Transition@en", "Transizione@it"),
                    label(TypeCollection, "Type collection@en",
                            "Collezione di un tipo@it"),
                    label(UnitOfMeasure, "Unit of measure@en", "Unità di misura@it"),
                    label(Workflow, "Workflow@it", "Workflow@en"),
                    label(WorkflowExecution, "Esecuzione di workflow@it",
                            "Workflow execution@en"),
                    label(actsFor, "agisce per@it", "acts for@en"),
                    label(actsThrough, "acts through@en", "agisce mediante@it"),
                    label(characterizes, "characterizes@en", "caratterizza@it"),
                    label(classifies, "classifies@en", "classifica@it"),
                    label(conceptualizes, "concettualizza@it", "conceptualizes@en"),
                    label(concretelyExpresses, "concretely expresses@en",
                            "esprime concretamente@it"),
                    label(coparticipatesWith, "co-participates with@en",
                            "copartecipa con@it"),
                    label(covers, "covers@en", "ricopre@it"),
                    label(defines, "definisce@it", "defines@en"),
                    label(definesRole, "defines role@en", "definisce il ruolo@it"),
                    label(definesTask, "defines task@en", "definisce il task@it"),
                    label(describes, "descrive@it", "describes@en"),
                    label(directlyFollows, "directly follows@en", "segue direttamente@it"),
                    label(directlyPrecedes, "precede direttamente@it",
                            "directly precedes@en"),
                    label(executesTask, "esegue il task@it", "executes task@en"),
                    label(expands, "expands@en", "espande@it"),
                    label(expresses, "esprime@it", "expresses@en"),
                    label(expressesConcept, "esprime il concetto@it",
                            "expresses concept@en"),
                    label(farFrom, "far from@en"),
                    label(follows, "follows@en", "segue@it"),
                    label(hasCommonBoundary, "has common boundary@en"),
                    label(hasComponent, "has component@en", "ha componente@it"),
                    label(hasConstituent, "ha costituente@it", "has constituent@en"),
                    label(hasConstraint, "ha vincolo@it", "has constraint@en"),
                    label(hasLocation, "ha localizzazione@it", "has location@en"),
                    label(hasMember, "ha membro@it", "has member@en"),
                    label(hasTask, "has task@en", "ha come obiettivo@it"),
                    label(isAgentIncludedIn, "è un agente nel contesto di@it",
                            "is agent included in@en"),
                    label(involvesAgent, "coinvolge agente@it", "involves agent@en"),
                    label(isAbout, "is about@en", "si riferisce a@it"),
                    label(isComponentOf, "è componente di@it", "is component of@en"),
                    label(isConceptExpressedBy, "is concept expressed by@en",
                            "è un concetto espresso da@it"),
                    label(isConcretelyExpressedBy, "è espresso concretamente da@it",
                            "is concretely expressed by@en"),
                    label(isConceptUsedIn, "è un concetto usato in@it",
                            "is concept used in@en"),
                    label(isConceptualizedBy, "è concettualizzato da@it",
                            "is conceptualized by@en"),
                    label(isConstituentOf, "è costituente di@it", "is constituent of@en"),
                    label(isConstraintFor, "è un vincolo per@it", "is constraint for@en"),
                    label(isCoveredBy, "è ricoperto da@it", "is covered by@en"),
                    label(isDefinedIn, "is defined in@en", "è definito in@it"),
                    label(isParameterFor, "è un parametro per@it", "is parameter for@en"),
                    label(isObservableAt, "is observable at@en", "è osservabile a@it"),
                    label(isParticipantIn, "is participant in@en",
                            "è un partecipante a@it"),
                    label(isPostconditionOf, "is postcondition of@en",
                            "è postcondizione di@it"),
                    label(isPreconditionOf, "is precondition of@en",
                            "è precondizione di@it"),
                    label(isQualityOf, "is quality of@en", "è una qualità di@it"),
                    label(isRealizedBy, "is realized by@en", "è realizzato da@it"),
                    label(isReferenceOf, "is reference of@en", "è il riferimento di@it"),
                    label(isParametrizedBy, "is parametrized by@en",
                            "è parametrizzato da@it"),
                    label(isPartOf, "is part of@en", "è parte di@it"),
                    label(isDescribedBy, "è descritto da@it", "is described by@en"),
                    label(isEventIncludedIn, "è un evento nel contesto di@it",
                            "is event included in@en"),
                    label(isExecutedIn, "è eseguito mediante@it", "is executed in@en"),
                    label(isExpandedIn, "è espansa in@it", "is expanded in@en"),
                    label(isExpressedBy, "is expressed by@en", "è espresso da@it"),
                    label(isIntroducedBy, "è introdotto da@it", "is introduced by@en"),
                    label(isLocationOf, "è una localizzazione di@it", "is location of@en"),
                    label(isMemberOf, "è membro di@it", "is member of@en"),
                    label(isObjectIncludedIn, "is object included in@en",
                            "è un oggetto nel contesto di@it"),
                    label(isActionIncludedIn, "è un'azione nel contesto di@it",
                            "is action included in@en"),
                    label(isAgentInvolvedIn, "è un agente coinvolto in@it",
                            "is agent involved in@en"),
                    label(isCharacterizedBy, "è caratterizzato da@it",
                            "is characterized by {@en-us}"),
                    label(isCharacterizedBy, "is characterized by@en"),
                    label(isClassifiedBy, "è classificato da@it", "is classified by@en"),
                    label(includesAction, "include azione@it", "includes action@en"),
                    label(includesAgent, "include l'agente@it", "includes agent@en"),
                    label(includesEvent, "includes event@en", "include l'evento@it"),
                    label(includesObject, "include l'oggetto@it", "includes object@en"),
                    label(includesTime, "include tempo@it", "includes time@en"),
                    label(introduces, "introduce@it", "introduces@en"),
                    label(hasParameter, "has parameter@en", "ha parametro@it"),
                    label(hasPart, "has part@en", "ha parte@it"),
                    label(hasParticipant, "has participant@en", "ha come partecipante@it"),
                    label(hasPostcondition, "has postcondition@en",
                            "ha postcondizione@it"),
                    label(hasPrecondition, "ha precondizione@it", "has precondition@en"),
                    label(hasQuality, "has quality@en", "ha qualità@it"),
                    label(hasRegion, "has region@en", "ha attributo@it"),
                    label(hasRole, "ha ruolo@it", "has role@en"),
                    label(hasSetting, "has setting@en", "è nel contesto di@it"),
                    label(isRegionFor, "is region for@en", "è una regione di@it"),
                    label(isReferenceOfInformationRealizedBy,
                            "è riferimento dell'informazione realizzata da@it",
                            "is reference of information realized by@en"),
                    label(isUnifiedBy, "è unificato da@it", "is unified by@en"),
                    label(realizes, "realizes@en", "realizza@it"),
                    label(usesConcept, "uses concept@en", "usa il concetto@it"),
                    label(hasDataValue, "has data value@en", "ha valore@it"),
                    label(unifies, "unifica@it", "unifies@en"),
                    label(realizesInformationAbout,
                            "realizza informazione che si riferisce a a@it",
                            "realizes information about@en"),
                    label(specializes, "specializza@it", "specializes@en"),
                    label(satisfies, "satisfies@en", "soddisfa@it"),
                    label(overlaps, "sovrapposto a@it", "overlaps@en"),
                    label(nearTo, "near to@en"),
                    label(parametrizes, "parametrizza@it", "parametrizes@en"),
                    label(precedes, "precedes@en", "precede@it"),
                    label(isRoleDefinedIn, "è un ruolo definito in@it",
                            "is role defined in@en"),
                    label(isRoleOf, "è un ruolo di@it", "is role of@en"),
                    label(isSatisfiedBy, "is satisfied by@en", "è soddisfatta da@it"),
                    label(isSettingFor, "include@it", "is setting for@en"),
                    label(isSpecializedBy, "è specializzato da@it",
                            "is specialized by@en"),
                    label(isTaskDefinedIn, "è un task definito in@it",
                            "is task defined in@en"),
                    label(isSubordinatedTo, "is subordinated to@en", "è subordinato a@it"),
                    label(isSuperordinatedTo, "è superordinato a@it",
                            "is superordinated to@en"),
                    label(isTimeIncludedIn, "is time included in@en",
                            "è un tempo nel contesto di@it"),
                    label(isTaskOf, "is task of@en", "è un obiettivo per@it"),
                    label(isTimeOfObservationOf, "è il tempo di osservazione di@it",
                            "is time of observation of@en"),
                    label(isRelatedToConcept, "è associato al concetto@it",
                            "is related to concept@en"),
                    label(isRelatedToDescription, "è associata alla descrizione@it",
                            "is related to description@en"),
                    label(hasProxy, "ha proxy@it", "has proxy@en"),
                    label(hasRegionDataValue, "has region data value@en",
                            "regione ha valore@it"), label(mappableTo, "mappable to@en"));
            state(dul,
                    sub(Pattern, Relation),
                    sub(Abstract, Entity),
                    disjoint(Abstract, Event),
                    disjoint(Abstract, Object),
                    disjoint(Abstract, Quality),
                    sub(Action, Event),
                    sub(Agent, Object),
                    sub(Amount, Region),
                    disjoint(Amount, PhysicalAttribute),
                    disjoint(Amount, SpaceRegion),
                    disjoint(Amount, TimeInterval),
                    sub(BiologicalObject, PhysicalBody),
                    sub(ChemicalObject, PhysicalBody),
                    sub(Classification, Situation),
                    sub(Action, some(hasParticipant, Agent)),
                    sub(Action, min(1, executesTask)),
                    eq(Agent, or(SocialAgent, PhysicalAgent)),
                    sub(Classification, some(isSettingFor, Concept)),
                    sub(Classification, some(isSettingFor, TimeInterval)),
                    sub(Classification, exact(3, isSettingFor)),
                    sub(Collection, all(hasPart, Collection)),
                    sub(Collective, all(hasMember, Agent)),
                    sub(CollectiveAgent, some(actsThrough, some(isMemberOf, Collective))),
                    sub(CollectiveAgent,
                            some(isIntroducedBy,
                                    and(some(unifies, Collective), Description))),
                    sub(Concept, some(isDefinedIn, Description)),
                    sub(Concept, all(hasPart, Concept)),
                    sub(Collection, SocialObject),
                    sub(Collective, Collection),
                    sub(CollectiveAgent, SocialAgent),
                    sub(Community, CollectiveAgent),
                    sub(Concept, SocialObject),
                    disjoint(Concept, Description),
                    disjoint(Concept, InformationObject),
                    disjoint(Concept, Situation),
                    disjoint(Concept, SocialAgent),
                    sub(Configuration, Collection),
                    sub(Contract, Description),
                    sub(Description, SocialObject),
                    disjoint(Description, InformationObject),
                    disjoint(Description, Situation),
                    disjoint(Description, SocialAgent),
                    sub(Design, Description),
                    sub(DesignedArtifact, PhysicalArtifact),
                    sub(DesignedSubstance, DesignedArtifact),
                    sub(DesignedSubstance, FunctionalSubstance),
                    sub(Diagnosis, Description),
                    sub(Event, Entity),
                    sub(DesignedArtifact, some(isDescribedBy, Design)),
                    eq(Entity, or(Abstract, Event, Object, Quality, Region)),
                    sub(Event, some(hasParticipant, Object)),
                    sub(Event, all(hasConstituent, Event)),
                    sub(Event, all(hasPart, Event)),
                    sub(EventType, all(classifies, Event)),
                    sub(Group, all(actsThrough, some(conceptualizes, SocialRelation))),
                    eq(InformationEntity, or(InformationRealization, InformationObject)),
                    sub(InformationObject, some(isRealizedBy, InformationRealization)),
                    sub(InformationObject, min(1, expresses)),
                    eq(InformationRealization,
                            and(some(realizes, InformationObject),
                                    or(and(some(hasParticipant, PhysicalObject), Event),
                                            PhysicalObject))),
                    sub(InformationRealization, some(concretelyExpresses, SocialObject)),
                    sub(InformationRealization, some(realizes, InformationObject)),
                    eq(LocalConcept, and(exact(1, isDefinedIn), Concept)),
                    disjoint(Event, Object),
                    disjoint(Event, Quality),
                    sub(EventType, Concept),
                    disjoint(EventType, Parameter),
                    disjoint(EventType, Role),
                    sub(FormalEntity, Abstract),
                    sub(FunctionalSubstance, Substance),
                    sub(Goal, Description),
                    sub(Group, CollectiveAgent),
                    sub(InformationEntity, Entity),
                    sub(InformationObject, InformationEntity),
                    sub(InformationObject, SocialObject),
                    disjoint(InformationObject, Situation),
                    disjoint(InformationObject, SocialAgent),
                    sub(InformationRealization, InformationEntity),
                    sub(InformationRealization, InformationEntity),
                    sub(LocalConcept, Concept),
                    sub(Method, Description),
                    sub(Narrative, Description),
                    sub(NaturalPerson, Person),
                    sub(NaturalPerson, PhysicalAgent),
                    sub(Norm, Description),
                    sub(Object, Entity),
                    eq(Object, or(SocialObject, PhysicalObject)),
                    sub(Object, some(isParticipantIn, Event)),
                    sub(Object, all(hasConstituent, Object)),
                    sub(Object, all(hasPart, Object)),
                    sub(Object, all(isClassifiedBy, Role)),
                    sub(Parameter, all(classifies, Region)),
                    sub(Parameter, all(hasPart, Parameter)),
                    eq(Person, or(SocialPerson, NaturalPerson)),
                    disjoint(Object, Quality),
                    sub(Organism, BiologicalObject),
                    sub(Organization, SocialAgent),
                    sub(Parameter, Concept),
                    disjoint(Parameter, Role),
                    sub(Person, Agent),
                    sub(Personification, SocialAgent),
                    sub(PhysicalAgent, Agent),
                    sub(PhysicalAgent, PhysicalObject),
                    sub(PhysicalArtifact, PhysicalObject),
                    sub(PhysicalAttribute, Region),
                    disjoint(PhysicalAttribute, SpaceRegion),
                    disjoint(PhysicalAttribute, TimeInterval),
                    sub(PhysicalBody, PhysicalObject),
                    sub(PhysicalObject, Object),
                    disjoint(PhysicalObject, SocialObject),
                    sub(PhysicalPlace, PhysicalObject),
                    sub(Place, SocialObject),
                    sub(Plan, Description),
                    sub(PhysicalAgent, some(conceptualizes, Plan)),
                    sub(PhysicalArtifact, some(isDescribedBy, Plan)),
                    sub(PhysicalAttribute, all(isRegionFor, PhysicalObject)),
                    sub(PhysicalObject, all(hasPart, PhysicalObject)),
                    sub(Place, min(1, isLocationOf)),
                    sub(Plan, some(hasComponent, Goal)),
                    eq(PlanExecution, and(some(satisfies, Plan), Situation)),
                    sub(Project, some(defines, Role)),
                    sub(Project, some(defines, Task)),
                    sub(Project, min(3, defines)),
                    sub(Quality, some(isQualityOf, Entity)),
                    sub(Quality, all(hasConstituent, Quality)),
                    sub(Quality, all(hasPart, Quality)),
                    sub(Region, all(hasConstituent, Region)),
                    sub(Region, all(hasPart, Region)),
                    sub(Region, all(overlaps, Region)),
                    sub(Region, all(precedes, Region)),
                    sub(Right, min(2, definesRole)),
                    sub(Right, min(1, definesTask)),
                    sub(Role, all(classifies, Object)),
                    sub(Role, all(hasPart, Role)),
                    sub(Situation, some(satisfies, Description)),
                    sub(SocialAgent, some(actsThrough, PhysicalAgent)),
                    eq(SocialObject,
                            or(Collection, Concept, Description, InformationObject,
                                    Place, Situation, SocialAgent)),
                    sub(SocialObject, some(isExpressedBy, InformationObject)),
                    sub(SocialObject, all(hasPart, SocialObject)),
                    sub(SocialObjectAttribute, all(isRegionFor, SocialObject)),
                    ann(dataFactory
                            .getOWLAnnotationProperty(OWLRDFVocabulary.OWL_VERSION_INFO
                                    .getIRI()),
                            SocialPerson.getIRI(),
                            Literal("Formerly: Person (changed to avoid confusion with commonsense intuition)",
                                    "")),
                    sub(SocialPerson, exact(1, actsThrough)),
                    sub(SpatioTemporalRegion, some(hasConstituent, SpaceRegion)),
                    sub(SpatioTemporalRegion, some(hasConstituent, TimeInterval)),
                    sub(Task, all(hasPart, Task)),
                    sub(Task, all(isExecutedIn, Action)),
                    sub(Task, all(isTaskDefinedIn, Description)),
                    sub(Task, all(isTaskOf, Role)),
                    sub(Theory, some(hasComponent, Relation)),
                    sub(Transition, some(isSettingFor, Process)),
                    sub(Transition, some(isSettingFor, Situation)),
                    sub(Transition, min(2, includesEvent)),
                    sub(Transition, min(1, includesObject)),
                    sub(Transition, min(3, includesTime)),
                    sub(Transition, min(8, isSettingFor)),
                    sub(UnitOfMeasure, some(parametrizes, Region)),
                    sub(Workflow, some(defines, Role)),
                    sub(Workflow, some(defines, Task)),
                    sub(Workflow, min(3, defines)),
                    eq(WorkflowExecution, and(some(satisfies, Workflow), PlanExecution)),
                    inverse(actsFor, actsThrough),
                    domain(actsFor, Agent),
                    range(actsFor, SocialAgent),
                    domain(actsThrough, SocialAgent),
                    range(actsThrough, Agent),
                    inverse(characterizes, isCharacterizedBy),
                    domain(characterizes, Concept),
                    range(characterizes, Collection),
                    inverse(isClassifiedBy, classifies),
                    domain(classifies, Concept),
                    range(classifies, Entity),
                    inverse(conceptualizes, isConceptualizedBy),
                    domain(conceptualizes, Agent),
                    range(conceptualizes, SocialObject),
                    inverse(concretelyExpresses, isConcretelyExpressedBy),
                    domain(concretelyExpresses, InformationRealization),
                    range(concretelyExpresses, SocialObject),
                    inverse(coparticipatesWith, coparticipatesWith),
                    symmetric(coparticipatesWith),
                    domain(coparticipatesWith, Object),
                    range(coparticipatesWith, Object),
                    inverse(covers, isCoveredBy),
                    domain(covers, Concept),
                    range(covers, Collection),
                    sub(defines, usesConcept),
                    inverse(defines, isDefinedIn),
                    domain(defines, Description),
                    range(defines, Concept),
                    sub(definesRole, defines),
                    inverse(definesRole, isRoleDefinedIn),
                    domain(definesRole, Description),
                    range(definesRole, Role),
                    sub(definesTask, defines),
                    inverse(definesTask, isTaskDefinedIn),
                    domain(definesTask, Description),
                    range(definesTask, Task),
                    inverse(isDescribedBy, describes),
                    domain(describes, Description),
                    range(describes, Entity),
                    sub(directlyFollows, follows),
                    inverse(directlyFollows, directlyPrecedes),
                    sub(directlyPrecedes, precedes),
                    sub(executesTask, isClassifiedBy),
                    inverse(executesTask, isExecutedIn),
                    domain(executesTask, Action),
                    range(executesTask, Task),
                    sub(expands, isRelatedToDescription),
                    inverse(expands, isExpandedIn),
                    domain(expands, Description),
                    range(expands, Description),
                    inverse(isExpressedBy, expresses),
                    domain(expresses, InformationObject),
                    range(expresses, SocialObject),
                    sub(expressesConcept, expresses),
                    inverse(expressesConcept, isConceptExpressedBy),
                    domain(expressesConcept, InformationObject),
                    range(expressesConcept, Concept),
                    inverse(farFrom, farFrom),
                    symmetric(farFrom),
                    domain(farFrom, Entity),
                    range(farFrom, Entity),
                    inverse(precedes, follows),
                    transitive(follows),
                    domain(follows, Entity),
                    range(follows, Entity),
                    inverse(hasCommonBoundary, hasCommonBoundary),
                    symmetric(hasCommonBoundary),
                    domain(hasCommonBoundary, Entity),
                    range(hasCommonBoundary, Entity),
                    sub(hasComponent, hasPart),
                    inverse(hasComponent, isComponentOf),
                    domain(hasComponent, Object),
                    range(hasComponent, Object),
                    inverse(isConstituentOf, hasConstituent),
                    domain(hasConstituent, Entity),
                    range(hasConstituent, Entity),
                    sub(hasConstraint, isClassifiedBy),
                    inverse(isConstraintFor, hasConstraint),
                    domain(hasConstraint, Entity),
                    range(hasConstraint, Parameter),
                    sub(PlanExecution, Situation),
                    sub(Process, Event),
                    sub(Project, Plan),
                    sub(Role, Concept),
                    sub(Quality, Entity),
                    sub(Relation, Description),
                    sub(Region, Abstract),
                    sub(Right, Description),
                    sub(Set, FormalEntity),
                    sub(Situation, SocialObject),
                    disjoint(Situation, SocialAgent),
                    sub(SocialAgent, Agent),
                    sub(SocialAgent, SocialObject),
                    sub(SocialObject, Object),
                    sub(SpaceRegion, Region),
                    sub(Transition, Situation),
                    disjoint(SpaceRegion, TimeInterval),
                    sub(SpatioTemporalRegion, Region),
                    sub(SocialObjectAttribute, Region),
                    sub(SocialPerson, Person),
                    sub(SocialPerson, SocialAgent),
                    sub(SocialRelation, Relation),
                    sub(Substance, PhysicalBody),
                    sub(Task, EventType),
                    sub(Theory, Description),
                    sub(TimeInterval, Region),
                    sub(UnitOfMeasure, Parameter),
                    sub(WorkflowExecution, PlanExecution),
                    sub(TypeCollection, Collection),
                    sub(Workflow, Plan),
                    inverse(isLocationOf, hasLocation),
                    domain(hasLocation, Entity),
                    range(hasLocation, Entity),
                    inverse(hasMember, isMemberOf),
                    domain(hasMember, Collection),
                    range(hasMember, Entity),
                    sub(hasParameter, isRelatedToConcept),
                    inverse(hasParameter, isParameterFor),
                    domain(hasParameter, Concept),
                    range(hasParameter, Parameter),
                    inverse(isPartOf, hasPart),
                    transitive(hasPart),
                    domain(hasPart, Entity),
                    range(hasPart, Entity),
                    inverse(hasParticipant, isParticipantIn),
                    domain(hasParticipant, Event),
                    range(hasParticipant, Object),
                    sub(hasPostcondition, directlyPrecedes),
                    inverse(isPostconditionOf, hasPostcondition),
                    domain(hasPostcondition, Situation),
                    range(hasPostcondition, Situation),
                    sub(hasPrecondition, directlyFollows),
                    inverse(isPreconditionOf, hasPrecondition),
                    domain(hasPrecondition, Situation),
                    range(hasPrecondition, Situation),
                    inverse(isQualityOf, hasQuality),
                    domain(hasQuality, Entity),
                    range(hasQuality, Quality),
                    inverse(hasRegion, isRegionFor),
                    domain(hasRegion, Entity),
                    range(hasRegion, Region),
                    sub(hasRole, isClassifiedBy),
                    inverse(isRoleOf, hasRole),
                    domain(hasRole, Object),
                    range(hasRole, Role),
                    inverse(hasSetting, isSettingFor),
                    domain(hasSetting, Entity),
                    range(hasSetting, Situation),
                    sub(hasTask, isRelatedToConcept),
                    inverse(hasTask, isTaskOf),
                    domain(hasTask, Role),
                    range(hasTask, Task),
                    sub(includesAction, includesEvent),
                    inverse(includesAction, isActionIncludedIn),
                    domain(includesAction, Situation),
                    range(includesAction, Action),
                    sub(includesAgent, includesObject),
                    inverse(isAgentIncludedIn, includesAgent),
                    domain(includesAgent, Situation),
                    range(includesAgent, Agent),
                    sub(includesEvent, isSettingFor),
                    inverse(isEventIncludedIn, includesEvent),
                    domain(includesEvent, Situation),
                    range(includesEvent, Event),
                    sub(includesObject, isSettingFor),
                    inverse(isObjectIncludedIn, includesObject),
                    domain(includesObject, Situation),
                    range(includesObject, Object),
                    sub(includesTime, isSettingFor),
                    inverse(includesTime, isTimeIncludedIn),
                    domain(includesTime, Situation),
                    range(includesTime, TimeInterval),
                    inverse(introduces, isIntroducedBy),
                    domain(introduces, Description),
                    range(introduces, SocialAgent),
                    sub(involvesAgent, hasParticipant),
                    inverse(isAgentInvolvedIn, involvesAgent),
                    domain(involvesAgent, Event),
                    range(involvesAgent, Agent),
                    inverse(isAbout, isReferenceOf),
                    domain(isAbout, InformationObject),
                    range(isAbout, Entity),
                    sub(isActionIncludedIn, isEventIncludedIn),
                    domain(isActionIncludedIn, Action),
                    range(isActionIncludedIn, Situation),
                    sub(isAgentIncludedIn, isObjectIncludedIn),
                    domain(isAgentIncludedIn, Agent),
                    range(isAgentIncludedIn, Situation),
                    sub(isAgentInvolvedIn, isParticipantIn),
                    domain(isAgentInvolvedIn, Agent),
                    range(isAgentInvolvedIn, Event),
                    domain(isCharacterizedBy, Collection),
                    range(isCharacterizedBy, Concept),
                    domain(isClassifiedBy, Entity),
                    range(isClassifiedBy, Concept),
                    sub(isComponentOf, isPartOf),
                    domain(isComponentOf, Object),
                    range(isComponentOf, Object),
                    sub(isConceptExpressedBy, isExpressedBy),
                    domain(isConceptExpressedBy, Concept),
                    range(isConceptExpressedBy, InformationObject),
                    inverse(usesConcept, isConceptUsedIn),
                    domain(isConceptUsedIn, Concept),
                    range(isConceptUsedIn, Description),
                    domain(isConceptualizedBy, SocialObject),
                    range(isConceptualizedBy, Agent),
                    domain(isConcretelyExpressedBy, SocialObject),
                    range(isConcretelyExpressedBy, InformationRealization),
                    domain(isConstituentOf, Entity),
                    range(isConstituentOf, Entity),
                    sub(isConstraintFor, classifies),
                    domain(isConstraintFor, Parameter),
                    range(isConstraintFor, Entity),
                    domain(isCoveredBy, Collection),
                    range(isCoveredBy, Concept),
                    sub(isDefinedIn, isConceptUsedIn),
                    domain(isDefinedIn, Concept),
                    range(isDefinedIn, Description),
                    domain(isDescribedBy, Entity),
                    range(isDescribedBy, Description),
                    sub(isEventIncludedIn, hasSetting),
                    domain(isEventIncludedIn, Event),
                    range(isEventIncludedIn, Situation),
                    sub(isExecutedIn, classifies),
                    domain(isExecutedIn, Task),
                    range(isExecutedIn, Action),
                    sub(isExpandedIn, isRelatedToDescription),
                    domain(isExpandedIn, Description),
                    range(isExpandedIn, Description),
                    domain(isExpressedBy, SocialObject),
                    range(isExpressedBy, InformationObject),
                    domain(isIntroducedBy, SocialAgent),
                    range(isIntroducedBy, Description),
                    domain(isLocationOf, Entity),
                    range(isLocationOf, Entity),
                    domain(isMemberOf, Entity),
                    range(isMemberOf, Collection),
                    sub(isObjectIncludedIn, hasSetting),
                    domain(isObjectIncludedIn, Object),
                    range(isObjectIncludedIn, Situation),
                    sub(isObservableAt, hasRegion),
                    inverse(isTimeOfObservationOf, isObservableAt),
                    domain(isObservableAt, Entity),
                    range(isObservableAt, TimeInterval),
                    sub(isParameterFor, isRelatedToConcept),
                    domain(isParameterFor, Parameter),
                    range(isParameterFor, Concept),
                    sub(isParametrizedBy, isClassifiedBy),
                    inverse(isParametrizedBy, parametrizes),
                    domain(isParametrizedBy, Region),
                    range(isParametrizedBy, Parameter),
                    transitive(isPartOf),
                    domain(isPartOf, Entity),
                    range(isPartOf, Entity),
                    domain(isParticipantIn, Object),
                    range(isParticipantIn, Event),
                    sub(isPostconditionOf, directlyFollows),
                    domain(isPostconditionOf, Situation),
                    range(isPostconditionOf, Situation),
                    sub(isPreconditionOf, directlyPrecedes),
                    domain(isPreconditionOf, Situation),
                    range(isPreconditionOf, Situation),
                    domain(isQualityOf, Quality),
                    range(isQualityOf, Entity),
                    inverse(realizes, isRealizedBy),
                    domain(isRealizedBy, InformationObject),
                    range(isRealizedBy, InformationRealization),
                    domain(isReferenceOf, Entity),
                    range(isReferenceOf, InformationObject),
                    inverse(isReferenceOfInformationRealizedBy, realizesInformationAbout),
                    domain(isReferenceOfInformationRealizedBy, Entity),
                    range(isReferenceOfInformationRealizedBy, InformationRealization),
                    domain(isRegionFor, Region), range(isRegionFor, Entity),
                    inverse(isRelatedToConcept, isRelatedToConcept),
                    symmetric(isRelatedToConcept), domain(isRelatedToConcept, Concept),
                    range(isRelatedToConcept, Concept),
                    inverse(isRelatedToDescription, isRelatedToDescription),
                    symmetric(isRelatedToDescription),
                    domain(isRelatedToDescription, Description),
                    range(isRelatedToDescription, Description),
                    sub(isRoleDefinedIn, isDefinedIn), domain(isRoleDefinedIn, Role),
                    range(isRoleDefinedIn, Description), sub(isRoleOf, classifies),
                    domain(isRoleOf, Role), range(isRoleOf, Object),
                    inverse(isSatisfiedBy, satisfies),
                    domain(isSatisfiedBy, Description), range(isSatisfiedBy, Situation),
                    domain(isSettingFor, Situation), range(isSettingFor, Entity),
                    inverse(specializes, isSpecializedBy), transitive(isSpecializedBy),
                    domain(isSpecializedBy, SocialObject),
                    range(isSpecializedBy, SocialObject),
                    sub(isSubordinatedTo, directlyFollows),
                    sub(isSubordinatedTo, isRelatedToConcept),
                    inverse(isSuperordinatedTo, isSubordinatedTo),
                    domain(isSubordinatedTo, Concept), range(isSubordinatedTo, Concept),
                    sub(isSuperordinatedTo, directlyPrecedes),
                    sub(isSuperordinatedTo, isRelatedToConcept),
                    domain(isSuperordinatedTo, Concept),
                    range(isSuperordinatedTo, Concept),
                    sub(isTaskDefinedIn, isDefinedIn), domain(isTaskDefinedIn, Task),
                    range(isTaskDefinedIn, Description),
                    sub(isTaskOf, isRelatedToConcept), domain(isTaskOf, Task),
                    range(isTaskOf, Role), sub(isTimeIncludedIn, hasSetting),
                    domain(isTimeIncludedIn, TimeInterval),
                    range(isTimeIncludedIn, Situation),
                    sub(isTimeOfObservationOf, isRegionFor),
                    domain(isTimeOfObservationOf, TimeInterval),
                    range(isTimeOfObservationOf, Entity), inverse(isUnifiedBy, unifies),
                    domain(isUnifiedBy, Collection), range(isUnifiedBy, Description),
                    inverse(nearTo, nearTo), symmetric(nearTo), domain(nearTo, Entity),
                    range(nearTo, Entity), inverse(overlaps, overlaps),
                    symmetric(overlaps), domain(overlaps, Entity),
                    range(overlaps, Entity), sub(parametrizes, classifies),
                    domain(parametrizes, Parameter), range(parametrizes, Region),
                    transitive(precedes), domain(precedes, Entity),
                    range(precedes, Entity), domain(realizes, InformationRealization),
                    range(realizes, InformationObject),
                    domain(realizesInformationAbout, InformationRealization),
                    range(realizesInformationAbout, Entity),
                    domain(satisfies, Situation), range(satisfies, Description),
                    transitive(specializes), domain(specializes, SocialObject),
                    range(specializes, SocialObject), domain(unifies, Description),
                    range(unifies, Collection), domain(usesConcept, Description),
                    range(usesConcept, Concept), domain(hasDataValue, Entity),
                    sub(hasEventDate, hasDataValue), domain(hasEventDate, Event),
                    range(hasEventDate, date), sub(hasIntervalDate, hasRegionDataValue),
                    domain(hasIntervalDate, TimeInterval), range(hasIntervalDate, date),
                    sub(hasParameterDataValue, hasDataValue),
                    domain(hasParameterDataValue, Parameter), domain(hasProxy, Entity),
                    range(hasProxy, any), sub(hasRegionDataValue, hasDataValue),
                    domain(hasRegionDataValue, Region));
            return dul;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static OWLOntology patternedDul(OWLOntologyManager m) {
        String ns = "http://www.semanticweb.org/ontologies/2011/1/siblings.owl";
        try {
            OWLOntology siblings = m.createOntology(IRI("http://patterns/patternedDUL"));
            m.applyChange(new AddImport(siblings,
                    ImportsDeclaration(IRI("http://www.loa-cnr.it/ontologies/DUL.owl"))));
            String lit1 = "?informationObject:CLASS, ?informationRealization:CLASS,\n\n ?realizationProperty:OBJECTPROPERTY BEGIN ADD"
                    + "\n ?informationRealization subClassOf InformationRealization, ADD\n ?informationObject subClassOf InformationObject, ADD"
                    + "\n ?realizationProperty subPropertyOf realizes, ADD\n ?informationRealization subClassOf PhysicalObject and"
                    + "\n ?realizationProperty some ?InformationObject END;\n Information Realization Pattern:"
                    + "\n ?informationRealization ?realizationProperty ?informationObject";
            String lit2 = "?person:CLASS, ?role:CLASS, ?timeInterval:CLASS BEGIN ADD\n$thisClass subClassOf Situation, ADD $thisClass subClassOf"
                    + "\nisSettingFor some ?person, ADD $thisClass subClassOf isSettingFor\nsome ?role, ADD $thisClass subClassOf isSettingFor some"
                    + "\n?timeInterval END;\nSituation where ?person play the role ?role during the time\ninterval ?timeInterval";
            OWLAnnotation ann1 = ann(
                    ann("http://www.co-ode.org/patterns#informationRealization"),
                    Literal(lit1, string()));
            OWLAnnotation ann2 = ann(
                    ann("http://www.co-ode.org/patterns#timeIndexedPersonRole"),
                    Literal(lit2, string()));
            m.applyChange(new AddOntologyAnnotation(siblings, ann2));
            m.applyChange(new AddOntologyAnnotation(siblings, ann1));
            declare(siblings,
                    ann("http://www.co-ode.org/patterns#informationRealization"),
                    ann("http://www.co-ode.org/patterns#timeIndexedPersonRole"));
            return siblings;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static final OWLDataFactory dataFactory = OWLManager.getOWLDataFactory();
    private static final OWLDatatype any = dataFactory
            .getOWLDatatype(XSDVocabulary.ANY_URI.getIRI());
    private static final OWLDatatype date = dataFactory.getOWLDatatype(XSDVocabulary.DATE
            .getIRI());

    private static OWLImportsDeclaration ImportsDeclaration(IRI i) {
        return dataFactory.getOWLImportsDeclaration(i);
    }

    private static OWLClass Class(String i) {
        return dataFactory.getOWLClass(IRI(i));
    }

    private static OWLAnnotationProperty RDFSLabel() {
        return dataFactory.getRDFSLabel();
    }

    private static OWLClass OWLThing() {
        return dataFactory.getOWLThing();
    }

    private static OWLDatatype Integer() {
        return dataFactory.getIntegerOWLDatatype();
    }

    private static OWLObjectProperty object(String iri) {
        return dataFactory.getOWLObjectProperty(IRI(iri));
    }

    private static OWLDataProperty DataProperty(String iri) {
        return dataFactory.getOWLDataProperty(IRI(iri));
    }

    private static OWLAnnotationProperty ann(String iri) {
        return dataFactory.getOWLAnnotationProperty(IRI(iri));
    }

    private static OWLNamedIndividual NamedIndividual(String i) {
        return dataFactory.getOWLNamedIndividual(IRI(i));
    }

    private static OWLDeclarationAxiom dec(OWLEntity entity) {
        return dataFactory.getOWLDeclarationAxiom(entity);
    }

    private static OWLObjectIntersectionOf and(OWLClassExpression... classExpressions) {
        return dataFactory.getOWLObjectIntersectionOf(classExpressions);
    }

    private static OWLObjectUnionOf or(OWLClassExpression... classExpressions) {
        return dataFactory.getOWLObjectUnionOf(classExpressions);
    }

    private static OWLObjectComplementOf c(OWLClassExpression classExpression) {
        return dataFactory.getOWLObjectComplementOf(classExpression);
    }

    private static OWLObjectSomeValuesFrom some(OWLObjectPropertyExpression pe,
            OWLClassExpression ce) {
        return dataFactory.getOWLObjectSomeValuesFrom(pe, ce);
    }

    private static OWLObjectAllValuesFrom all(OWLObjectPropertyExpression pe,
            OWLClassExpression ce) {
        return dataFactory.getOWLObjectAllValuesFrom(pe, ce);
    }

    private static OWLObjectHasValue has(OWLObjectPropertyExpression pe,
            OWLIndividual individual) {
        return dataFactory.getOWLObjectHasValue(pe, individual);
    }

    private static OWLObjectMinCardinality min(int cardinality,
            OWLObjectPropertyExpression pe, OWLClassExpression ce) {
        return dataFactory.getOWLObjectMinCardinality(cardinality, pe, ce);
    }

    private static OWLObjectMinCardinality min(int cardinality,
            OWLObjectPropertyExpression pe) {
        return dataFactory.getOWLObjectMinCardinality(cardinality, pe, OWLThing());
    }

    private static OWLObjectExactCardinality exact(int cardinality,
            OWLObjectPropertyExpression pe) {
        return dataFactory.getOWLObjectExactCardinality(cardinality, pe, OWLThing());
    }

    private static OWLObjectOneOf one(OWLIndividual... individuals) {
        return dataFactory.getOWLObjectOneOf(individuals);
    }

    private static OWLDataSomeValuesFrom some(OWLDataPropertyExpression pe,
            OWLDataRange dr) {
        return dataFactory.getOWLDataSomeValuesFrom(pe, dr);
    }

    private static OWLDataHasValue has(OWLDataPropertyExpression pe, OWLLiteral literal) {
        return dataFactory.getOWLDataHasValue(pe, literal);
    }

    private static OWLSubClassOfAxiom sub(OWLClassExpression subClass,
            OWLClassExpression superClass) {
        return dataFactory.getOWLSubClassOfAxiom(subClass, superClass);
    }

    private static OWLSubClassOfAxiom sub(OWLClassExpression subClass,
            OWLClassExpression superClass, Set<OWLAnnotation> a) {
        return dataFactory.getOWLSubClassOfAxiom(subClass, superClass, a);
    }

    private static OWLEquivalentClassesAxiom eq(OWLClassExpression... classExpressions) {
        return dataFactory.getOWLEquivalentClassesAxiom(classExpressions);
    }

    private static OWLEquivalentClassesAxiom eq(Set<OWLAnnotation> a,
            OWLClassExpression... classExpressions) {
        return dataFactory.getOWLEquivalentClassesAxiom(new HashSet<OWLClassExpression>(
                Arrays.asList(classExpressions)), a);
    }

    private static OWLDisjointClassesAxiom disjoint(
            OWLClassExpression... classExpressions) {
        return dataFactory.getOWLDisjointClassesAxiom(classExpressions);
    }

    private static OWLSubObjectPropertyOfAxiom sub(
            OWLObjectPropertyExpression subProperty,
            OWLObjectPropertyExpression superProperty) {
        return dataFactory.getOWLSubObjectPropertyOfAxiom(subProperty, superProperty);
    }

    private static OWLInverseObjectPropertiesAxiom inverse(
            OWLObjectPropertyExpression peA, OWLObjectPropertyExpression peB) {
        return dataFactory.getOWLInverseObjectPropertiesAxiom(peA, peB);
    }

    private static OWLObjectPropertyDomainAxiom domain(
            OWLObjectPropertyExpression property, OWLClassExpression domain) {
        return dataFactory.getOWLObjectPropertyDomainAxiom(property, domain);
    }

    private static OWLObjectPropertyRangeAxiom range(
            OWLObjectPropertyExpression property, OWLClassExpression range) {
        return dataFactory.getOWLObjectPropertyRangeAxiom(property, range);
    }

    private static OWLFunctionalObjectPropertyAxiom func(
            OWLObjectPropertyExpression property) {
        return dataFactory.getOWLFunctionalObjectPropertyAxiom(property);
    }

    private static OWLInverseFunctionalObjectPropertyAxiom invfunc(
            OWLObjectPropertyExpression property) {
        return dataFactory.getOWLInverseFunctionalObjectPropertyAxiom(property);
    }

    private static OWLSymmetricObjectPropertyAxiom symmetric(
            OWLObjectPropertyExpression property) {
        return dataFactory.getOWLSymmetricObjectPropertyAxiom(property);
    }

    private static OWLTransitiveObjectPropertyAxiom transitive(
            OWLObjectPropertyExpression property) {
        return dataFactory.getOWLTransitiveObjectPropertyAxiom(property);
    }

    private static OWLSubDataPropertyOfAxiom sub(OWLDataPropertyExpression subProperty,
            OWLDataPropertyExpression superProperty) {
        return dataFactory.getOWLSubDataPropertyOfAxiom(subProperty, superProperty);
    }

    private static OWLDataPropertyDomainAxiom domain(OWLDataPropertyExpression property,
            OWLClassExpression domain) {
        return dataFactory.getOWLDataPropertyDomainAxiom(property, domain);
    }

    private static OWLDataPropertyRangeAxiom range(OWLDataPropertyExpression property,
            OWLDataRange range) {
        return dataFactory.getOWLDataPropertyRangeAxiom(property, range);
    }

    private static OWLDifferentIndividualsAxiom diff(OWLIndividual... individuals) {
        return dataFactory.getOWLDifferentIndividualsAxiom(individuals);
    }

    private static OWLClassAssertionAxiom ClassAssertion(OWLClassExpression ce,
            OWLIndividual ind) {
        return dataFactory.getOWLClassAssertionAxiom(ce, ind);
    }

    private static OWLAnnotationAssertionAxiom ann(OWLAnnotationProperty property,
            OWLAnnotationSubject subject, OWLAnnotationValue value) {
        return dataFactory.getOWLAnnotationAssertionAxiom(property, subject, value);
    }

    private static OWLAnnotation ann(OWLAnnotationProperty property,
            OWLAnnotationValue value) {
        return dataFactory.getOWLAnnotation(property, value);
    }

    private static IRI IRI(String iri) {
        return IRI.create(iri);
    }

    private static OWLLiteral Literal(String literal, String lang) {
        return dataFactory.getOWLLiteral(literal, lang);
    }

    private static OWLLiteral Literal(String literal, OWLDatatype type) {
        return dataFactory.getOWLLiteral(literal, type);
    }

    private static OWLLiteral Literal(String literal) {
        return dataFactory.getOWLLiteral(literal);
    }

    public static OWLOntology test;
    public static OWLOntology naf;
    public static OWLOntology pizza;
    public static OWLOntology patternedPizza;
    public static OWLOntology patternedDUL;
    public static OWLOntology patternedPizzaLuigi;
    public static OWLOntology food;
    public static OWLOntology dul;
    public static OWLOntology syntax;
    public static OWLOntology siblings;
    public static OWLOntology ondrejtest;
    public static OWLOntology testLongLabels;
    public static OWLOntology sequentialUnion;
    public static OWLDataFactory df = OWLManager.getOWLDataFactory();
    public static OWLOntologyManager managerForPizzaAndSyntax = OWLManager
            .createOWLOntologyManager();
    public static OWLOntologyManager managerForPizzaAndOndrej = OWLManager
            .createOWLOntologyManager();
    static {
        try {
            naf = naf(OWLManager.createOWLOntologyManager());
            test = country(OWLManager.createOWLOntologyManager());
            syntax = syntax(OWLManager.createOWLOntologyManager());
            testLongLabels = testLongLabels(OWLManager.createOWLOntologyManager());
            siblings = siblings(OWLManager.createOWLOntologyManager());
            ondrejtest = ondrejtest(OWLManager.createOWLOntologyManager());
            sequentialUnion = sequentialUnion(OWLManager.createOWLOntologyManager());
            pizza = pizza(OWLManager.createOWLOntologyManager());
            food = food(OWLManager.createOWLOntologyManager());
            // load a copy of pizza and patterned pizza on the same manager
            OWLOntology temp = pizza(OWLManager.createOWLOntologyManager());
            patternedPizza = patternedPizza(temp.getOWLOntologyManager());
            patternedPizzaLuigi = pizzaLuigi(temp.getOWLOntologyManager());
            temp = pizza(OWLManager.createOWLOntologyManager());
            managerForPizzaAndSyntax = syntax(temp.getOWLOntologyManager())
                    .getOWLOntologyManager();
            temp = pizza(OWLManager.createOWLOntologyManager());
            managerForPizzaAndOndrej = ondrejtest(temp.getOWLOntologyManager())
                    .getOWLOntologyManager();
            dul = dul(OWLManager.createOWLOntologyManager());
            temp = dul(OWLManager.createOWLOntologyManager());
            patternedDUL = patternedDul(temp.getOWLOntologyManager());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
