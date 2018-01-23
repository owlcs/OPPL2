package org.coode.oppl.testontologies;

import static org.junit.Assert.assertEquals;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asList;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.StringDocumentTarget;
import org.semanticweb.owlapi.model.IRI;
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
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
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
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

@SuppressWarnings({"javadoc", "unchecked"})
public class TestOntologies {

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
        List<OWLAxiom> axioms = new ArrayList<>();
        axioms.add(dec(e));
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
            OWLOntology _naf = m.createOntology(IRI(naf_ns));
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
            declare(_naf, a, aa, ab, ac, ad, bpr, cpr, d, dpr, prange, hasP);
            state(_naf, sub(a, some(hasP, prange)), sub(bpr, prange), sub(c, a), sub(ab, aa),
                sub(ac, aa), sub(ad, aa), sub(b, a), sub(cpr, prange), sub(d, a), sub(dpr, prange),
                sub(ab, some(hasP, bpr)), sub(b, some(hasP, bpr)), sub(c, some(hasP, cpr)),
                sub(d, some(hasP, dpr)));
            state(_naf, label(b, "B"), label(c, "C"));
            return _naf;
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
                sub(WaterBoundaryFragment, BoundaryFragment), domain(adjacentTo, Country),
                range(adjacentTo, Country), domain(borders, Country), range(borders, Country),
                domain(dependencyOf, Country), range(dependencyOf, Country),
                domain(hasBoundary, Country), range(hasBoundary, BoundaryFragment),
                sub(hasLandBoundary, hasBoundary), domain(hasLandBoundary, Country),
                range(hasLandBoundary, LandBoundaryFragment), sub(hasWaterBoundary, hasBoundary),
                domain(hasWaterBoundary, Country), range(hasWaterBoundary, WaterBoundaryFragment),
                range(size, OWL2Datatype.XSD_INT.getDatatype(dataFactory)),
                ClassAssertion(Country, asinara));
            return country;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void same(OWLOntology o1, OWLOntology o2) throws OWLOntologyStorageException {
        Set<OWLAxiom> common = asSet(o1.axioms());
        common.retainAll(asList(o2.axioms()));
        o1.removeAxioms(common);
        o2.removeAxioms(common);
        if (o1.getAxiomCount() == 0 && o2.getAxiomCount() == 0) {
            return;
        }
        StringDocumentTarget t1 = new StringDocumentTarget();
        StringDocumentTarget t2 = new StringDocumentTarget();
        o1.getOWLOntologyManager().saveOntology(o1, t1);
        o2.getOWLOntologyManager().saveOntology(o2, t2);
        assertEquals(
            t1.toString().replace("file:/C:/Tools/Alignement/align-4.0/temp.owl", "urn:temp"),
            t2.toString());
    }

    public static OWLOntology entire(OWLOntologyManager m) {
        String ns = "http://www.ihtsdo.org/";
        try {
            OWLOntology _entire = m.createOntology(IRI("http://www.ihtsdo.org"));
            OWLObjectProperty RoleGroup = object(ns + "RoleGroup");
            OWLObjectProperty SCT_116676008 = object(ns + "SCT_116676008");
            OWLObjectProperty SCT_246075003 = object(ns + "SCT_246075003");
            OWLObjectProperty SCT_246454002 = object(ns + "SCT_246454002");
            OWLObjectProperty SCT_255234002 = object(ns + "SCT_255234002");
            OWLObjectProperty SCT_263502005 = object(ns + "SCT_263502005");
            OWLClass SCT_102298001 = Class(ns + "SCT_102298001");
            OWLClass SCT_102957003 = Class(ns + "SCT_102957003");
            OWLClass SCT_105981003 = Class(ns + "SCT_105981003");
            OWLClass SCT_126732009 = Class(ns + "SCT_126732009");
            OWLClass SCT_368009 = Class(ns + "SCT_368009");
            OWLClass SCT_399617002 = Class(ns + "SCT_399617002");
            OWLClass SCT_414545008 = Class(ns + "SCT_414545008");
            OWLClass SCT_415991003 = Class(ns + "SCT_415991003");
            OWLClass SCT_56265001 = Class(ns + "SCT_56265001");
            OWLObjectProperty SCT_363698007 = object(ns + "SCT_363698007");
            OWLObjectProperty SCT_363705008 = object(ns + "SCT_363705008");
            OWLObjectProperty SCT_363713009 = object(ns + "SCT_363713009");
            OWLObjectProperty SCT_363714003 = object(ns + "SCT_363714003");
            OWLObjectProperty SCT_370135005 = object(ns + "SCT_370135005");
            OWLObjectProperty SCT_47429007 = object(ns + "SCT_47429007");
            OWLObjectProperty has_locus = object(ns + "has_locus");
            OWLObjectProperty has_locus_entire = object(ns + "has_locus_entire");
            OWLObjectProperty PartOf = object(ns + "sep/PartOf");
            OWLObjectProperty cPartOf = object(ns + "sep/cPartOf");
            OWLObjectProperty containedIn = object(ns + "sep/containedIn");
            OWLObjectProperty hasMember = object(ns + "sep/hasMember");
            OWLObjectProperty laterality = object(ns + "sep/laterality");
            OWLObjectProperty rPartOf = object(ns + "sep/rPartOf");
            OWLObjectProperty sPartOf = object(ns + "sep/sPartOf");
            declare(naf, RoleGroup, SCT_116676008, SCT_246075003, SCT_246454002, SCT_255234002,
                SCT_263502005, SCT_102298001, SCT_102957003, SCT_105981003, SCT_126732009,
                SCT_368009, SCT_399617002, SCT_414545008, SCT_415991003, SCT_56265001,
                SCT_363698007, SCT_363705008, SCT_363713009, SCT_363714003, SCT_370135005,
                SCT_47429007, has_locus, has_locus_entire, PartOf, cPartOf, containedIn, hasMember,
                laterality, rPartOf, sPartOf);
            state(_entire, label(SCT_56265001, "Heart disease (disorder)@en"),
                label(SCT_415991003, "Disorder of cardiac ventricle (disorder)@en"),
                label(SCT_368009, "Heart valve disorder (disorder)@en"),
                label(SCT_414545008, "Ischemic heart disease (disorder)@en"),
                label(SCT_399617002, "Carditis (disorder)@en"),
                label(SCT_102298001, "Structure of chordae tendineae cordis (body structure)@en"),
                label(SCT_102957003, "Neurological finding (finding)@en"),
                label(SCT_105981003, "Disorder of cardiac function (disorder)@en"),
                label(SCT_126732009, "Neoplasm of myocardium (disorder)@en"),
                label(RoleGroup, "RoleGroup@en"),
                label(SCT_116676008, "Associated morphology (attribute)@en"),
                label(SCT_246075003, "Causative agent (attribute)@en"),
                label(SCT_246454002, "Occurrence (attribute)@en"),
                label(SCT_255234002, "After (attribute)@en"),
                label(SCT_263502005, "Clinical course (attribute)@en"),
                label(SCT_363698007, "Finding site (attribute)@en"),
                label(SCT_363705008, "Has definitional manifestation (attribute)@en"),
                label(SCT_363713009, "Has interpretation (attribute)@en"),
                label(SCT_363714003, "Interprets (attribute)@en"),
                label(SCT_370135005, "Pathological process (attribute)@en"),
                label(SCT_47429007, "Associated with (attribute)@en"), label(PartOf, "PartOf@en"),
                label(cPartOf, "cPartOf@en"), label(containedIn, "containedIn@en"),
                label(hasMember, "hasMember@en"), label(laterality, "laterality@en"),
                label(rPartOf, "rPartOf@en"), label(sPartOf, "sPartOf@en"));
            OWLClass SCT_312168006 = Class(ns + "SCT_312168006");
            OWLClass SCT_404684003 = Class(ns + "SCT_404684003");
            OWLClass SCT_55342001 = Class(ns + "SCT_55342001");
            OWLClass SCT_74281007 = Class(ns + "SCT_74281007");
            OWLClass SCT_108369006 = Class(ns + "SCT_108369006");
            OWLClass SCT_23583003 = Class(ns + "SCT_23583003");
            OWLClass SCT_49601007 = Class(ns + "SCT_49601007");
            OWLClass E00017 = Class(ns + "sep/E00017");
            OWLClass E00016 = Class(ns + "sep/E00016");
            OWLClass E00612 = Class(ns + "sep/E00612");
            state(_entire, sub(SCT_102298001, SCT_312168006), sub(SCT_102957003, SCT_404684003),
                sub(SCT_105981003, SCT_56265001),
                eq(SCT_126732009,
                    and(SCT_55342001, SCT_56265001,
                        some(RoleGroup,
                            and(some(SCT_363698007, SCT_74281007),
                                some(SCT_116676008, SCT_108369006))))),
                eq(SCT_368009, and(some(RoleGroup, some(has_locus, E00017)), SCT_56265001)),
                eq(SCT_399617002,
                    and(some(RoleGroup,
                        and(some(has_locus, E00016), some(SCT_116676008, SCT_23583003))),
                        SCT_56265001)),
                sub(SCT_414545008, and(some(RoleGroup, some(has_locus, E00016)), SCT_56265001)),
                eq(SCT_415991003, and(some(RoleGroup, some(has_locus, E00612)), SCT_56265001)),
                eq(SCT_56265001, and(some(RoleGroup, some(has_locus, E00016)), SCT_49601007)),
                sub(SCT_246075003, SCT_47429007), sub(cPartOf, PartOf),
                sub(SCT_255234002, SCT_47429007), sub(has_locus_entire, has_locus),
                sub(rPartOf, PartOf), sub(sPartOf, PartOf));
            return _entire;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static OWLOntology syntax(OWLOntologyManager m) {
        String syntax_ns = "http://www.coode.org/oppl/ontologies/syntaxTest.owl";
        try {
            OWLOntology _syntax = m.createOntology(IRI(syntax_ns));
            OWLDataProperty p = DataProperty(syntax_ns + "#aDataProperty");
            state(_syntax, label(p, "aDataProperty"));
            state(_syntax, range(p, OWL2Datatype.XSD_INT.getDatatype(dataFactory)));
            return _syntax;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static OWLOntology siblings(OWLOntologyManager m) {
        String ns = "http://www.semanticweb.org/ontologies/2011/1/siblings.owl";
        try {
            OWLOntology _siblings = m.createOntology(IRI(ns));
            declare(_siblings, object(ns + "#hasSibling"), NamedIndividual(ns + "#Robert"));
            return _siblings;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static OWLOntology ondrejtest(OWLOntologyManager m) {
        String ns = "http://www.semanticweb.org/ontologies/2010/2/Ontology1269524218581.owl";
        try {
            OWLOntology _ondrejtest = m.createOntology();
            OWLClass a = Class(ns + "#A");
            OWLClass c = Class(ns + "#C");
            OWLObjectProperty p = object(ns + "#p");
            declare(_ondrejtest, a, c, p);
            state(_ondrejtest, eq(a, some(p, c)), sub(c, OWLThing()));
            return _ondrejtest;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static OWLOntology sequentialUnion(OWLOntologyManager m) {
        String ns1 = "http://www.semanticweb.com/mergedont";
        String ns = "urn:temp#";
        try {
            OWLOntology _sequentialUnion = m.createOntology(IRI(ns));
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
            OWLObjectProperty has_dpws_statevariable = object(nsf + "has_DPWS_StateVariable");
            OWLObjectProperty has_DPWS_Action = object(nsf + "has_DPWS_Action");
            OWLObjectProperty has_DPWS_Input = object(nsf + "has_DPWS_Input");
            OWLObjectProperty has_DPWS_Output = object(nsf + "has_DPWS_Output");
            OWLObjectProperty has_DPWS_Service = object(nsf + "has_DPWS_Service");
            OWLDataProperty a_has_DPWS_StateVariable_Type =
                DataProperty(nsf + "a_has_DPWS_StateVariable_Type");
            OWLDataProperty has_DPWS_Logical_Device_Name =
                DataProperty(nsf + "has_DPWS_Logical_Device_Name");
            OWLDataProperty x_has_DPWS_StateVariable_Type =
                DataProperty(nsf + "x_has_DPWS_StateVariable_Type");
            OWLDataProperty y_has_DPWS_StateVariable_Type =
                DataProperty(nsf + "y_has_DPWS_StateVariable_Type");
            OWLDataProperty y_has_UPnP_StateVariable_Type =
                DataProperty(nsf1 + "y_has_UPnP_StateVariable_Type");
            OWLDataProperty x_has_UPnP_StateVariable_Type =
                DataProperty(nsf1 + "x_has_UPnP_StateVariable_Type");
            OWLDataProperty has_UPnP_Service_Version =
                DataProperty(nsf1 + "has_UPnP_Service_Version");
            OWLDataProperty has_UPnP_Service_Type = DataProperty(nsf1 + "has_UPnP_Service_Type");
            OWLDataProperty has_UPnP_Service_ID = DataProperty(nsf1 + "has_UPnP_Service_ID");
            OWLDataProperty has_UPnP_Device_Type = DataProperty(nsf1 + "has_UPnP_Device_Type");
            OWLObjectProperty UPnP_is_instance_of_type = object(nsf1 + "UPnP_is_instance_of_type");
            OWLObjectProperty has_UPnP_Action = object(nsf1 + "has_UPnP_Action");
            OWLObjectProperty has_UPnP_Input = object(nsf1 + "has_UPnP_Input");
            OWLObjectProperty has_UPnP_Instance_Input = object(nsf1 + "has_UPnP_Instance_Input");
            OWLObjectProperty has_UPnP_Instance_Output = object(nsf1 + "has_UPnP_Instance_Output");
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
            OWLObjectProperty Sequential_Union_Mapping_First_member =
                object(ns + "Sequential_Union_Mapping_First_member");
            OWLObjectProperty Sequential_Union_Mapping_Second_member =
                object(ns + "Sequential_Union_Mapping_Second_member");
            OWLObjectProperty Simple_Mapping_Input = object(ns + "Simple_Mapping_Input");
            OWLObjectProperty Simple_Mapping_Input_Output =
                object(ns + "Simple_Mapping_Input_Output");
            OWLObjectProperty Simple_Mapping_Output = object(ns + "Simple_Mapping_Output");
            OWLObjectProperty Union_Mapping = object(ns + "Union_Mapping");
            OWLObjectProperty Union_Mapping_First_member =
                object(ns + "Union_Mapping_First_member");
            OWLObjectProperty Union_Mapping_Second_member =
                object(ns + "Union_Mapping_Second_member");
            OWLObjectProperty Exact_Input_Match = object(ns1 + "#Exact_Input_Match");
            OWLObjectProperty Exact_Input_Output_Match = object(ns1 + "#Exact_Input_Output_Match");
            OWLObjectProperty Exact_Output_Match = object(ns1 + "#Exact_Output_Match");
            OWLObjectProperty PlugIn_Input_Output_Match =
                object(ns1 + "#PlugIn_Input_Output_Match");
            OWLObjectProperty PlugIn_Output_Match = object(ns1 + "#PlugIn_Output_Match");
            OWLObjectProperty has_Next = object(ns1 + "#has_Next");
            OWLObjectProperty PlugIn_Input_Match = object(ns1 + "#PlugIn_Input_Match");
            OWLClass SequentialUnionClock = Class(nsf1 + "SequentialUnionClock");
            declare(_sequentialUnion, DPWS_Action, DPWS_Device, DPWS_Service, DPWS_StateVariable,
                DummyOperation, SeqClockStd, Set1, Set2, a, seqentialClock, x, y, newx, newy,
                sequentialunionclock, Set12, Time, UPnP_Action, UPnP_Device, UPnP_Service,
                UPnP_StateVariable, x1, y1, Sequential_Union_Mapping_First_member,
                Sequential_Union_Mapping_Second_member, Simple_Mapping_Input,
                Simple_Mapping_Input_Output, Simple_Mapping_Output, Union_Mapping,
                Union_Mapping_First_member, Union_Mapping_Second_member, has_DPWS_Action,
                has_DPWS_Input, has_DPWS_Output, has_DPWS_Service, has_dpws_statevariable,
                UPnP_is_instance_of_type, has_UPnP_Action, has_UPnP_Input, has_UPnP_Instance_Input,
                has_UPnP_Instance_Output, has_UPnP_Output, has_UPnP_Service, Exact_Input_Match,
                Exact_Input_Output_Match, Exact_Output_Match, PlugIn_Input_Match,
                PlugIn_Input_Output_Match, PlugIn_Output_Match, has_Next,
                a_has_DPWS_StateVariable_Type, has_DPWS_Logical_Device_Name,
                x_has_DPWS_StateVariable_Type, y_has_DPWS_StateVariable_Type, has_UPnP_Device_Type,
                has_UPnP_Service_ID, has_UPnP_Service_Type, has_UPnP_Service_Version,
                x_has_UPnP_StateVariable_Type, y_has_UPnP_StateVariable_Type);
            state(_sequentialUnion,
                sub(DPWS_Action, some(has_dpws_statevariable, DPWS_StateVariable)),
                sub(DPWS_Device, some(has_DPWS_Service, DPWS_Service)),
                sub(DPWS_Service, some(has_DPWS_Action, DPWS_Action)),
                sub(DummyOperation, DPWS_Action), sub(DummyOperation, some(has_DPWS_Input, y)),
                eq(SeqClockStd, Time), sub(SeqClockStd, DPWS_Service),
                sub(SeqClockStd, some(has_DPWS_Action, DummyOperation)),
                sub(SeqClockStd, some(has_DPWS_Action, Set1)),
                sub(SeqClockStd, some(has_DPWS_Action, Set2)), eq(Set1, Set12),
                sub(Set1, DPWS_Action), sub(Set1, some(has_DPWS_Input, x)),
                sub(Set1, some(has_DPWS_Output, a)), sub(Set1, some(Exact_Input_Match, Set12)),
                eq(Set2, Set12), sub(Set2, DPWS_Action), sub(Set2, some(has_DPWS_Input, a)),
                sub(Set2, some(has_DPWS_Output, y)), sub(Set2, some(Exact_Output_Match, Set12)),
                sub(a, DPWS_StateVariable), sub(a, some(a_has_DPWS_StateVariable_Type, string())),
                eq(seqentialClock, SequentialUnionClock), sub(seqentialClock, DPWS_Device),
                sub(seqentialClock, some(has_DPWS_Service, SeqClockStd)),
                sub(seqentialClock,
                    has(has_DPWS_Logical_Device_Name, Literal("hosted:seqentialClock", ""))),
                eq(x, x1), sub(x, DPWS_StateVariable),
                sub(x, some(x_has_DPWS_StateVariable_Type, string())), eq(y, y1),
                sub(y, DPWS_StateVariable), sub(y, some(y_has_DPWS_StateVariable_Type, string())),
                sub(newx, x1), sub(newx, some(UPnP_is_instance_of_type, x1)), sub(newy, y1),
                sub(newy, some(UPnP_is_instance_of_type, y1)),
                sub(SequentialUnionClock, UPnP_Device),
                sub(SequentialUnionClock, some(has_UPnP_Service, Time)),
                sub(SequentialUnionClock,
                    has(has_UPnP_Device_Type,
                        Literal("urn:schemas-upnp-org:device:SequentialUnionClock:1", ""))),
                sub(Set12, UPnP_Action), sub(Set12, some(Simple_Mapping_Input, Set1)),
                sub(Set12, some(Simple_Mapping_Output, Set2)),
                sub(Set12, some(Union_Mapping, Set1)), sub(Set12, some(has_UPnP_Input, x1)),
                sub(Set12, some(has_UPnP_Instance_Input, newx)),
                sub(Set12, some(has_UPnP_Instance_Output, newy)),
                sub(Set12, some(has_UPnP_Output, y1)), sub(Set12, some(Exact_Input_Match, Set1)),
                sub(Set12, some(Exact_Output_Match, Set2)), sub(Time, UPnP_Service),
                sub(Time, some(has_UPnP_Action, Set12)),
                sub(Time, has(has_UPnP_Service_ID, Literal("urn:upnp-org:serviceId:Time.1", ""))),
                sub(Time,
                    has(has_UPnP_Service_Type, Literal("urn:schemas-upnp-org:service:Time:1", ""))),
                sub(Time, has(has_UPnP_Service_Version, Literal("1", ""))),
                sub(UPnP_Action, some(has_UPnP_Input, UPnP_StateVariable)),
                sub(UPnP_Action, some(has_UPnP_Output, UPnP_StateVariable)),
                sub(UPnP_Device, some(has_UPnP_Service, UPnP_Service)),
                sub(UPnP_Service, some(has_UPnP_Action, UPnP_Action)), sub(x1, UPnP_StateVariable),
                sub(x1, some(x_has_UPnP_StateVariable_Type, string())), sub(y1, UPnP_StateVariable),
                sub(y1, some(y_has_UPnP_StateVariable_Type, string())));
            return _sequentialUnion;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static OWLDatatype string() {
        return OWL2Datatype.XSD_STRING.getDatatype(dataFactory);
    }

    public static OWLOntology pizza(OWLOntologyManager m) {
        String ns = "http://pizza.com/pizza.owl#";
        try {
            OWLOntology _pizza = m.createOntology(IRI("http://pizza.com/pizza.owl"));
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
            declare(_pizza, DeepPanBase, DomainConcept, hasBase, hasCountryOfOrigin, hasIngredient,
                hasSpiciness, hasTopping, isBaseOf, isIngredientOf, isToppingOf);
            state(_pizza, label(GoatsCheeseTopping, "CoberturaDeQueijoDeCabra@pt"),
                label(GorgonzolaTopping, "CoberturaDeGorgonzola@pt"),
                label(GreenPepperTopping, "CoberturaDePimentaoVerde@pt"),
                label(HamTopping, "CoberturaDePresunto@pt"),
                label(HerbSpiceTopping, "CoberturaDeErvas@pt"),
                label(HotGreenPepperTopping, "CoberturaDePimentaoVerdePicante@pt"),
                label(HotSpicedBeefTopping, "CoberturaDeBifePicante@pt"),
                label(IceCream, "Sorvete@pt"), label(InterestingPizza, "PizzaInteressante@pt"),
                label(JalapenoPepperTopping, "CoberturaDeJalapeno@pt"),
                label(LaReine, "LaReine@pt"), label(LeekTopping, "CoberturaDeLeek@pt"),
                label(Margherita, "Margherita@pt"), label(MeatTopping, "CoberturaDeCarne@pt"),
                label(MeatyPizza, "PizzaDeCarne@pt"), label(Medium, "Media@pt"),
                label(MixedSeafoodTopping, "CoberturaDeFrutosDoMarMistos@pt"),
                label(MozzarellaTopping, "CoberturaDeMozzarella@pt"),
                label(Mushroom, "Cogumelo@pt"), label(MushroomTopping, "CoberturaDeCogumelo@pt"),
                label(NamedPizza, "PizzaComUmNome@pt"), label(Napoletana, "Napoletana@pt"),
                label(NonVegetarianPizza, "PizzaNaoVegetariana@pt"),
                label(NutTopping, "CoberturaDeCastanha@pt"),
                label(OliveTopping, "CoberturaDeAzeitona@pt"),
                label(OnionTopping, "CoberturaDeCebola@pt"),
                label(ParmaHamTopping, "CoberturaDePrezuntoParma@pt"),
                label(Parmense, "Parmense@pt"), label(Hot, "Picante@pt"),
                label(Mild, "NaoPicante@pt"), label(Pizza, "Pizza@en"), label(Rosa, "Rosa@pt"),
                label(American, "Americana@pt"), label(PineKernels, "CoberturaPineKernels@pt"),
                label(PepperTopping, "CoberturaDePimentao@pt"),
                label(PeperoniSausageTopping, "CoberturaDeCalabreza@pt"),
                label(PetitPoisTopping, "CoberturaPetitPois@pt"),
                label(PeperonataTopping, "CoberturaPeperonata@pt"),
                label(ParmesanTopping, "CoberturaDeParmesao@pt"),
                label(PizzaTopping, "CoberturaDaPizza@pt"), label(PolloAdAstra, "PolloAdAstra@pt"),
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
                label(UnclosedPizza, "PizzaAberta@pt"), label(ValuePartition, "ValorDaParticao@pt"),
                label(VegetableTopping, "CoberturaDeVegetais@pt"),
                label(VegetarianPizza, "PizzaVegetariana@pt"),
                label(VegetarianPizzaEquivalent1, "PizzaVegetarianaEquivalente1@pt"),
                label(VegetarianPizzaEquivalent2, "PizzaVegetarianaEquivalente2@pt"),
                label(VegetarianTopping, "CoberturaVegetariana@pt"),
                label(Veneziana, "Veneziana@pt"), label(PrawnsTopping, "CoberturaDeCamarao@pt"),
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
                label(CaperTopping, "CoberturaDeCaper@pt"), label(Capricciosa, "Capricciosa@pt"),
                label(Cajun, "Cajun@pt"), label(Caprina, "Caprina@pt"),
                label(CheeseTopping, "CoberturaDeQueijo@pt"),
                label(CheeseyPizza, "PizzaComQueijo@pt"),
                label(CheeseyVegetableTopping, "CoberturaDeQueijoComVegetais@pt"),
                label(ChickenTopping, "CoberturaDeFrango@pt"), label(Country, "Pais@pt"),
                label(DeepPanBase, "BaseEspessa@pt"), label(Fiorentina, "Fiorentina@pt"),
                label(FishTopping, "CoberturaDePeixe@pt"),
                label(FourCheesesTopping, "CoberturaQuatroQueijos@pt"),
                label(FourSeasons, "QuatroQueijos@pt"), label(FruitTopping, "CoberturaDeFrutas@pt"),
                label(FruttiDiMare, "FrutosDoMar@pt"), label(GarlicTopping, "CoberturaDeAlho@pt"),
                label(Giardiniera, "Giardiniera@pt"), label(Soho, "Soho@pt"));
            state(_pizza, sub(American, NamedPizza),
                sub(American, some(hasTopping, MozzarellaTopping)),
                sub(American, some(hasTopping, PeperoniSausageTopping)),
                sub(American, some(hasTopping, TomatoTopping)),
                sub(American,
                    all(hasTopping, or(MozzarellaTopping, PeperoniSausageTopping, TomatoTopping))),
                sub(AmericanHot, NamedPizza),
                sub(AmericanHot, some(hasTopping, HotGreenPepperTopping)),
                sub(AmericanHot, some(hasTopping, JalapenoPepperTopping)),
                sub(AmericanHot, some(hasTopping, MozzarellaTopping)),
                sub(AmericanHot, some(hasTopping, PeperoniSausageTopping)),
                sub(AmericanHot, some(hasTopping, TomatoTopping)),
                sub(AmericanHot,
                    all(hasTopping,
                        or(HotGreenPepperTopping, JalapenoPepperTopping, MozzarellaTopping,
                            PeperoniSausageTopping, TomatoTopping))),
                sub(AnchoviesTopping, FishTopping), sub(ArtichokeTopping, VegetableTopping),
                sub(ArtichokeTopping, some(hasSpiciness, Mild)),
                sub(AsparagusTopping, VegetableTopping),
                sub(AsparagusTopping, some(hasSpiciness, Mild)), sub(Cajun, NamedPizza),
                sub(Cajun, some(hasTopping, MozzarellaTopping)),
                sub(Cajun, some(hasTopping, OnionTopping)),
                sub(Cajun, some(hasTopping, PeperonataTopping)),
                sub(Cajun, some(hasTopping, PrawnsTopping)),
                sub(Cajun, some(hasTopping, TobascoPepperSauce)),
                sub(Cajun, some(hasTopping, TomatoTopping)),
                sub(Cajun,
                    all(hasTopping,
                        or(MozzarellaTopping, OnionTopping, PeperonataTopping, PrawnsTopping,
                            TobascoPepperSauce, TomatoTopping))),
                sub(CajunSpiceTopping, HerbSpiceTopping),
                sub(CajunSpiceTopping, some(hasSpiciness, Hot)),
                sub(CaperTopping, VegetableTopping), sub(CaperTopping, some(hasSpiciness, Mild)),
                sub(Capricciosa, NamedPizza), sub(Capricciosa, some(hasTopping, AnchoviesTopping)),
                sub(Capricciosa, some(hasTopping, CaperTopping)),
                sub(Capricciosa, some(hasTopping, HamTopping)),
                sub(Capricciosa, some(hasTopping, MozzarellaTopping)),
                sub(Capricciosa, some(hasTopping, OliveTopping)),
                sub(Capricciosa, some(hasTopping, PeperonataTopping)),
                sub(Capricciosa, some(hasTopping, TomatoTopping)),
                sub(Capricciosa,
                    all(hasTopping,
                        or(AnchoviesTopping, CaperTopping, HamTopping, MozzarellaTopping,
                            OliveTopping, PeperonataTopping, TomatoTopping))),
                sub(Caprina, NamedPizza), sub(Caprina, some(hasTopping, GoatsCheeseTopping)),
                sub(Caprina, some(hasTopping, MozzarellaTopping)),
                sub(Caprina, some(hasTopping, SundriedTomatoTopping)),
                sub(Caprina, some(hasTopping, TomatoTopping)),
                sub(Caprina,
                    all(hasTopping,
                        or(GoatsCheeseTopping, MozzarellaTopping, SundriedTomatoTopping,
                            TomatoTopping))),
                sub(CheeseTopping, PizzaTopping),
                eq(CheeseyPizza, and(some(hasTopping, CheeseTopping), Pizza)),
                sub(CheeseyVegetableTopping, CheeseTopping),
                sub(CheeseyVegetableTopping, VegetableTopping), sub(ChickenTopping, MeatTopping),
                sub(ChickenTopping, some(hasSpiciness, Mild)),
                eq(Country, and(one(Italy, France, England, America, Germany), DomainConcept)),
                sub(DeepPanBase, PizzaBase), disjoint(DeepPanBase, ThinAndCrispyBase),
                disjoint(DomainConcept, ValuePartition), sub(Fiorentina, NamedPizza),
                sub(Fiorentina, some(hasTopping, GarlicTopping)),
                sub(Fiorentina, some(hasTopping, MozzarellaTopping)),
                sub(Fiorentina, some(hasTopping, OliveTopping)),
                sub(Fiorentina, some(hasTopping, ParmesanTopping)),
                sub(Fiorentina, some(hasTopping, SpinachTopping)),
                sub(Fiorentina, some(hasTopping, TomatoTopping)),
                sub(Fiorentina,
                    all(hasTopping,
                        or(GarlicTopping, MozzarellaTopping, OliveTopping, ParmesanTopping,
                            SpinachTopping, TomatoTopping))),
                sub(FishTopping, PizzaTopping), sub(FishTopping, some(hasSpiciness, Mild)),
                sub(FourCheesesTopping, CheeseTopping),
                sub(FourCheesesTopping, some(hasSpiciness, Mild)), sub(FourSeasons, NamedPizza),
                sub(FourSeasons, some(hasTopping, AnchoviesTopping)),
                sub(FourSeasons, some(hasTopping, CaperTopping)),
                sub(FourSeasons, some(hasTopping, MozzarellaTopping)),
                sub(FourSeasons, some(hasTopping, MushroomTopping)),
                sub(FourSeasons, some(hasTopping, OliveTopping)),
                sub(FourSeasons, some(hasTopping, PeperoniSausageTopping)),
                sub(FourSeasons, some(hasTopping, TomatoTopping)),
                sub(FourSeasons,
                    all(hasTopping,
                        or(AnchoviesTopping, CaperTopping, MozzarellaTopping, MushroomTopping,
                            OliveTopping, PeperoniSausageTopping, TomatoTopping))),
                sub(FruitTopping, PizzaTopping), sub(FruttiDiMare, NamedPizza),
                sub(FruttiDiMare, some(hasTopping, GarlicTopping)),
                sub(FruttiDiMare, some(hasTopping, MixedSeafoodTopping)),
                sub(FruttiDiMare, some(hasTopping, TomatoTopping)),
                sub(FruttiDiMare,
                    all(hasTopping, or(GarlicTopping, MixedSeafoodTopping, TomatoTopping))),
                sub(GarlicTopping, VegetableTopping),
                sub(GarlicTopping, some(hasSpiciness, Medium)), sub(Giardiniera, NamedPizza),
                sub(Giardiniera, some(hasTopping, LeekTopping)),
                sub(Giardiniera, some(hasTopping, MozzarellaTopping)),
                sub(Giardiniera, some(hasTopping, MushroomTopping)),
                sub(Giardiniera, some(hasTopping, OliveTopping)),
                sub(Giardiniera, some(hasTopping, PeperonataTopping)),
                sub(Giardiniera, some(hasTopping, PetitPoisTopping)),
                sub(Giardiniera, some(hasTopping, SlicedTomatoTopping)),
                sub(Giardiniera, some(hasTopping, TomatoTopping)),
                sub(Giardiniera, all(hasTopping,
                    or(LeekTopping, MozzarellaTopping, MushroomTopping, OliveTopping,
                        PeperonataTopping, PetitPoisTopping, SlicedTomatoTopping, TomatoTopping))),
                sub(GoatsCheeseTopping, CheeseTopping),
                sub(GoatsCheeseTopping, some(hasSpiciness, Mild)),
                sub(GorgonzolaTopping, CheeseTopping),
                sub(GorgonzolaTopping, some(hasSpiciness, Mild)),
                sub(GreenPepperTopping, PepperTopping), sub(HamTopping, MeatTopping),
                sub(HerbSpiceTopping, PizzaTopping), sub(Hot, Spiciness),
                sub(HotGreenPepperTopping, GreenPepperTopping),
                sub(HotGreenPepperTopping, some(hasSpiciness, Hot)),
                sub(HotSpicedBeefTopping, MeatTopping),
                sub(HotSpicedBeefTopping, some(hasSpiciness, Hot)), sub(IceCream, DomainConcept),
                sub(IceCream, some(hasTopping, FruitTopping)),
                eq(InterestingPizza, and(min(3, hasTopping, OWLThing()), Pizza)),
                sub(JalapenoPepperTopping, PepperTopping),
                sub(JalapenoPepperTopping, some(hasSpiciness, Hot)), sub(LaReine, NamedPizza),
                sub(LaReine, some(hasTopping, HamTopping)),
                sub(LaReine, some(hasTopping, MozzarellaTopping)),
                sub(LaReine, some(hasTopping, MushroomTopping)),
                sub(LaReine, some(hasTopping, OliveTopping)),
                sub(LaReine, some(hasTopping, TomatoTopping)),
                sub(LaReine,
                    all(hasTopping,
                        or(HamTopping, MozzarellaTopping, MushroomTopping, OliveTopping,
                            TomatoTopping))),
                sub(LeekTopping, VegetableTopping), sub(LeekTopping, some(hasSpiciness, Mild)),
                sub(Margherita, NamedPizza), sub(Margherita, some(hasTopping, MozzarellaTopping)),
                sub(Margherita, some(hasTopping, TomatoTopping)),
                sub(Margherita, all(hasTopping, or(TomatoTopping, MozzarellaTopping))),
                sub(MeatTopping, PizzaTopping),
                eq(MeatyPizza, and(some(hasTopping, MeatTopping), Pizza)), sub(Medium, Spiciness),
                sub(Mild, Spiciness), sub(MixedSeafoodTopping, FishTopping),
                sub(MozzarellaTopping, CheeseTopping),
                sub(MozzarellaTopping, some(hasSpiciness, Mild)),
                sub(MozzarellaTopping, has(hasCountryOfOrigin, Italy)), sub(Mushroom, NamedPizza),
                sub(Mushroom, some(hasTopping, MozzarellaTopping)),
                sub(Mushroom, some(hasTopping, MushroomTopping)),
                sub(Mushroom, some(hasTopping, TomatoTopping)),
                sub(Mushroom,
                    all(hasTopping, or(MozzarellaTopping, MushroomTopping, TomatoTopping))),
                sub(MushroomTopping, VegetableTopping),
                sub(MushroomTopping, some(hasSpiciness, Mild)), sub(NamedPizza, Pizza),
                sub(Napoletana, NamedPizza), sub(Napoletana, some(hasTopping, AnchoviesTopping)),
                sub(Napoletana, some(hasTopping, CaperTopping)),
                sub(Napoletana, some(hasTopping, MozzarellaTopping)),
                sub(Napoletana, some(hasTopping, OliveTopping)),
                sub(Napoletana, some(hasTopping, TomatoTopping)),
                sub(Napoletana,
                    all(hasTopping,
                        or(AnchoviesTopping, CaperTopping, MozzarellaTopping, OliveTopping,
                            TomatoTopping))),
                eq(NonVegetarianPizza, and(c(VegetarianPizza), Pizza)),
                disjoint(NonVegetarianPizza, VegetarianPizza), sub(NutTopping, PizzaTopping),
                sub(NutTopping, some(hasSpiciness, Mild)), sub(OliveTopping, VegetableTopping),
                sub(OliveTopping, some(hasSpiciness, Mild)), sub(OnionTopping, VegetableTopping),
                sub(OnionTopping, some(hasSpiciness, Medium)), sub(ParmaHamTopping, HamTopping),
                sub(ParmaHamTopping, some(hasSpiciness, Mild)), sub(Parmense, NamedPizza),
                sub(Parmense, some(hasTopping, AsparagusTopping)),
                sub(Parmense, some(hasTopping, HamTopping)),
                sub(Parmense, some(hasTopping, MozzarellaTopping)),
                sub(Parmense, some(hasTopping, ParmesanTopping)),
                sub(Parmense, some(hasTopping, TomatoTopping)),
                sub(Parmense,
                    all(hasTopping,
                        or(AsparagusTopping, HamTopping, MozzarellaTopping, ParmesanTopping,
                            TomatoTopping))),
                sub(ParmesanTopping, CheeseTopping), sub(ParmesanTopping, some(hasSpiciness, Mild)),
                sub(PeperonataTopping, PepperTopping),
                sub(PeperonataTopping, some(hasSpiciness, Medium)),
                sub(PeperoniSausageTopping, MeatTopping),
                sub(PeperoniSausageTopping, some(hasSpiciness, Medium)),
                sub(PepperTopping, VegetableTopping), sub(PetitPoisTopping, VegetableTopping),
                sub(PetitPoisTopping, some(hasSpiciness, Mild)), sub(PineKernels, NutTopping),
                sub(Pizza, DomainConcept), sub(Pizza, some(hasBase, PizzaBase)),
                sub(PizzaBase, DomainConcept), sub(PizzaTopping, DomainConcept),
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
                        or(CajunSpiceTopping, ChickenTopping, GarlicTopping, MozzarellaTopping,
                            RedOnionTopping, SweetPepperTopping, TomatoTopping))),
                sub(PrawnsTopping, FishTopping), sub(PrinceCarlo, NamedPizza),
                sub(PrinceCarlo, some(hasTopping, LeekTopping)),
                sub(PrinceCarlo, some(hasTopping, MozzarellaTopping)),
                sub(PrinceCarlo, some(hasTopping, ParmesanTopping)),
                sub(PrinceCarlo, some(hasTopping, RosemaryTopping)),
                sub(PrinceCarlo, some(hasTopping, TomatoTopping)),
                sub(PrinceCarlo,
                    all(hasTopping,
                        or(LeekTopping, MozzarellaTopping, ParmesanTopping, RosemaryTopping,
                            TomatoTopping))),
                sub(QuattroFormaggi, NamedPizza),
                sub(QuattroFormaggi, some(hasTopping, FourCheesesTopping)),
                sub(QuattroFormaggi, some(hasTopping, TomatoTopping)),
                sub(QuattroFormaggi, all(hasTopping, or(TomatoTopping, FourCheesesTopping))),
                eq(RealItalianPizza, and(has(hasCountryOfOrigin, Italy), Pizza)),
                sub(RealItalianPizza, all(hasBase, ThinAndCrispyBase)),
                sub(RedOnionTopping, OnionTopping), sub(RocketTopping, VegetableTopping),
                sub(RocketTopping, some(hasSpiciness, Medium)), sub(Rosa, NamedPizza),
                sub(Rosa, some(hasTopping, GorgonzolaTopping)),
                sub(Rosa, some(hasTopping, MozzarellaTopping)),
                sub(Rosa, some(hasTopping, TomatoTopping)),
                sub(Rosa, all(hasTopping, or(GorgonzolaTopping, MozzarellaTopping, TomatoTopping))),
                sub(RosemaryTopping, HerbSpiceTopping),
                sub(RosemaryTopping, some(hasSpiciness, Mild)), sub(SauceTopping, PizzaTopping),
                sub(Siciliana, NamedPizza), sub(Siciliana, some(hasTopping, AnchoviesTopping)),
                sub(Siciliana, some(hasTopping, ArtichokeTopping)),
                sub(Siciliana, some(hasTopping, GarlicTopping)),
                sub(Siciliana, some(hasTopping, HamTopping)),
                sub(Siciliana, some(hasTopping, MozzarellaTopping)),
                sub(Siciliana, some(hasTopping, OliveTopping)),
                sub(Siciliana, some(hasTopping, TomatoTopping)),
                sub(Siciliana,
                    all(hasTopping,
                        or(AnchoviesTopping, ArtichokeTopping, GarlicTopping, HamTopping,
                            MozzarellaTopping, OliveTopping, TomatoTopping))),
                sub(SlicedTomatoTopping, TomatoTopping),
                sub(SlicedTomatoTopping, some(hasSpiciness, Mild)), sub(SloppyGiuseppe, NamedPizza),
                sub(SloppyGiuseppe, some(hasTopping, GreenPepperTopping)),
                sub(SloppyGiuseppe, some(hasTopping, HotSpicedBeefTopping)),
                sub(SloppyGiuseppe, some(hasTopping, MozzarellaTopping)),
                sub(SloppyGiuseppe, some(hasTopping, OnionTopping)),
                sub(SloppyGiuseppe, some(hasTopping, TomatoTopping)),
                sub(SloppyGiuseppe,
                    all(hasTopping,
                        or(GreenPepperTopping, HotSpicedBeefTopping, MozzarellaTopping,
                            OnionTopping, TomatoTopping))),
                sub(Soho, NamedPizza), sub(Soho, some(hasTopping, GarlicTopping)),
                sub(Soho, some(hasTopping, MozzarellaTopping)),
                sub(Soho, some(hasTopping, OliveTopping)),
                sub(Soho, some(hasTopping, ParmesanTopping)),
                sub(Soho, some(hasTopping, RocketTopping)),
                sub(Soho, some(hasTopping, TomatoTopping)),
                sub(Soho,
                    all(hasTopping,
                        or(GarlicTopping, MozzarellaTopping, OliveTopping, ParmesanTopping,
                            RocketTopping, TomatoTopping))),
                eq(Spiciness, or(Hot, Medium, Mild)), sub(Spiciness, ValuePartition),
                eq(SpicyPizza, and(some(hasTopping, SpicyTopping), Pizza)),
                eq(SpicyPizzaEquivalent,
                    and(some(hasTopping, and(some(hasSpiciness, Hot), PizzaTopping)), Pizza)),
                eq(SpicyTopping, and(some(hasSpiciness, Hot), PizzaTopping)),
                sub(SpinachTopping, VegetableTopping),
                sub(SpinachTopping, some(hasSpiciness, Mild)), sub(SultanaTopping, FruitTopping),
                sub(SultanaTopping, some(hasSpiciness, Medium)),
                sub(SundriedTomatoTopping, TomatoTopping),
                sub(SundriedTomatoTopping, some(hasSpiciness, Mild)),
                sub(SweetPepperTopping, PepperTopping),
                sub(SweetPepperTopping, some(hasSpiciness, Mild)),
                sub(ThinAndCrispyBase, PizzaBase), sub(TobascoPepperSauce, SauceTopping),
                sub(TobascoPepperSauce, some(hasSpiciness, Hot)),
                sub(TomatoTopping, VegetableTopping), sub(TomatoTopping, some(hasSpiciness, Mild)),
                sub(UnclosedPizza, NamedPizza),
                sub(UnclosedPizza, some(hasTopping, MozzarellaTopping)),
                sub(VegetableTopping, PizzaTopping),
                eq(VegetarianPizza,
                    and(Pizza, c(some(hasTopping, FishTopping)), c(some(hasTopping, MeatTopping)))),
                eq(VegetarianPizzaEquivalent1, and(all(hasTopping, VegetarianTopping), Pizza)),
                eq(VegetarianPizzaEquivalent2,
                    and(all(hasTopping,
                        or(CheeseTopping, FruitTopping, HerbSpiceTopping, NutTopping, SauceTopping,
                            VegetableTopping)),
                        Pizza)),
                eq(VegetarianTopping,
                    and(or(CheeseTopping, FruitTopping, HerbSpiceTopping, NutTopping, SauceTopping,
                        VegetableTopping), PizzaTopping)),
                sub(Veneziana, NamedPizza), sub(Veneziana, some(hasTopping, CaperTopping)),
                sub(Veneziana, some(hasTopping, MozzarellaTopping)),
                sub(Veneziana, some(hasTopping, OliveTopping)),
                sub(Veneziana, some(hasTopping, OnionTopping)),
                sub(Veneziana, some(hasTopping, PineKernels)),
                sub(Veneziana, some(hasTopping, SultanaTopping)),
                sub(Veneziana, some(hasTopping, TomatoTopping)),
                sub(Veneziana,
                    all(hasTopping,
                        or(CaperTopping, MozzarellaTopping, OliveTopping, OnionTopping, PineKernels,
                            SultanaTopping, TomatoTopping))),
                sub(hasBase, hasIngredient), inverse(hasBase, isBaseOf), func(hasBase),
                invfunc(hasBase), domain(hasBase, Pizza), range(hasBase, PizzaBase),
                inverse(hasIngredient, isIngredientOf), transitive(hasIngredient),
                func(hasSpiciness), range(hasSpiciness, Spiciness), sub(hasTopping, hasIngredient),
                inverse(isToppingOf, hasTopping), domain(hasTopping, Pizza),
                range(hasTopping, PizzaTopping), sub(isBaseOf, isIngredientOf), func(isBaseOf),
                invfunc(isBaseOf), domain(isBaseOf, PizzaBase), range(isBaseOf, Pizza),
                transitive(isIngredientOf), sub(isToppingOf, isIngredientOf),
                domain(isToppingOf, PizzaTopping), range(isToppingOf, Pizza),
                ClassAssertion(Country, America), ClassAssertion(Country, England),
                ClassAssertion(Country, France), ClassAssertion(Country, Germany),
                ClassAssertion(Country, Italy),
                disjoint(ArtichokeTopping, AsparagusTopping, CaperTopping, CheeseTopping,
                    ChickenTopping, FishTopping, FourCheesesTopping, FruitTopping, GarlicTopping,
                    GoatsCheeseTopping, GorgonzolaTopping, GreenPepperTopping, HamTopping,
                    HerbSpiceTopping, HotSpicedBeefTopping, JalapenoPepperTopping, LeekTopping,
                    MeatTopping, MixedSeafoodTopping, MozzarellaTopping, MushroomTopping,
                    NutTopping, OliveTopping, OnionTopping, ParmesanTopping, PeperonataTopping,
                    PeperoniSausageTopping, PepperTopping, PetitPoisTopping, PrawnsTopping,
                    RocketTopping, SauceTopping, SlicedTomatoTopping, SpinachTopping,
                    SundriedTomatoTopping, SweetPepperTopping, TomatoTopping, VegetableTopping),
                disjoint(IceCream, Pizza, PizzaBase, PizzaTopping),
                disjoint(American, AmericanHot, Cajun, Capricciosa, Caprina, Fiorentina,
                    FourSeasons, FruttiDiMare, Giardiniera, LaReine, Margherita, Mushroom,
                    Napoletana, Parmense, PolloAdAstra, PrinceCarlo, QuattroFormaggi, Rosa,
                    Siciliana, SloppyGiuseppe, Soho, UnclosedPizza, Veneziana),
                diff(America, England, France, Germany, Italy), disjoint(Hot, Medium, Mild));
            return _pizza;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static final OWLDataFactory dataFactory = OWLManager.getOWLDataFactory();

    private static OWLClass Class(String i) {
        return dataFactory.getOWLClass(IRI(i));
    }

    private static OWLAnnotationProperty RDFSLabel() {
        return dataFactory.getRDFSLabel();
    }

    private static OWLClass OWLThing() {
        return dataFactory.getOWLThing();
    }

    private static OWLObjectProperty object(String iri) {
        return dataFactory.getOWLObjectProperty(IRI(iri));
    }

    private static OWLDataProperty DataProperty(String iri) {
        return dataFactory.getOWLDataProperty(IRI(iri));
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

    private static OWLObjectHasValue has(OWLObjectPropertyExpression pe, OWLIndividual individual) {
        return dataFactory.getOWLObjectHasValue(pe, individual);
    }

    private static OWLObjectMinCardinality min(int cardinality, OWLObjectPropertyExpression pe,
        OWLClassExpression ce) {
        return dataFactory.getOWLObjectMinCardinality(cardinality, pe, ce);
    }

    private static OWLObjectOneOf one(OWLIndividual... individuals) {
        return dataFactory.getOWLObjectOneOf(individuals);
    }

    private static OWLDataSomeValuesFrom some(OWLDataPropertyExpression pe, OWLDataRange dr) {
        return dataFactory.getOWLDataSomeValuesFrom(pe, dr);
    }

    private static OWLDataHasValue has(OWLDataPropertyExpression pe, OWLLiteral literal) {
        return dataFactory.getOWLDataHasValue(pe, literal);
    }

    private static OWLSubClassOfAxiom sub(OWLClassExpression subClass,
        OWLClassExpression superClass) {
        return dataFactory.getOWLSubClassOfAxiom(subClass, superClass);
    }

    private static OWLEquivalentClassesAxiom eq(OWLClassExpression... classExpressions) {
        return dataFactory.getOWLEquivalentClassesAxiom(classExpressions);
    }

    private static OWLDisjointClassesAxiom disjoint(OWLClassExpression... classExpressions) {
        return dataFactory.getOWLDisjointClassesAxiom(classExpressions);
    }

    private static OWLSubObjectPropertyOfAxiom sub(OWLObjectPropertyExpression subProperty,
        OWLObjectPropertyExpression superProperty) {
        return dataFactory.getOWLSubObjectPropertyOfAxiom(subProperty, superProperty);
    }

    private static OWLInverseObjectPropertiesAxiom inverse(OWLObjectPropertyExpression peA,
        OWLObjectPropertyExpression peB) {
        return dataFactory.getOWLInverseObjectPropertiesAxiom(peA, peB);
    }

    private static OWLObjectPropertyDomainAxiom domain(OWLObjectPropertyExpression property,
        OWLClassExpression domain) {
        return dataFactory.getOWLObjectPropertyDomainAxiom(property, domain);
    }

    private static OWLObjectPropertyRangeAxiom range(OWLObjectPropertyExpression property,
        OWLClassExpression range) {
        return dataFactory.getOWLObjectPropertyRangeAxiom(property, range);
    }

    private static OWLFunctionalObjectPropertyAxiom func(OWLObjectPropertyExpression property) {
        return dataFactory.getOWLFunctionalObjectPropertyAxiom(property);
    }

    private static OWLInverseFunctionalObjectPropertyAxiom invfunc(
        OWLObjectPropertyExpression property) {
        return dataFactory.getOWLInverseFunctionalObjectPropertyAxiom(property);
    }

    private static OWLTransitiveObjectPropertyAxiom transitive(
        OWLObjectPropertyExpression property) {
        return dataFactory.getOWLTransitiveObjectPropertyAxiom(property);
    }

    private static OWLDataPropertyRangeAxiom range(OWLDataPropertyExpression property,
        OWLDataRange range) {
        return dataFactory.getOWLDataPropertyRangeAxiom(property, range);
    }

    private static OWLDifferentIndividualsAxiom diff(OWLIndividual... individuals) {
        return dataFactory.getOWLDifferentIndividualsAxiom(individuals);
    }

    private static OWLClassAssertionAxiom ClassAssertion(OWLClassExpression ce, OWLIndividual ind) {
        return dataFactory.getOWLClassAssertionAxiom(ce, ind);
    }

    private static OWLAnnotationAssertionAxiom ann(OWLAnnotationProperty property,
        OWLAnnotationSubject subject, OWLAnnotationValue value) {
        return dataFactory.getOWLAnnotationAssertionAxiom(property, subject, value);
    }

    private static IRI IRI(String iri) {
        return IRI.create(iri);
    }

    private static OWLLiteral Literal(String literal, String lang) {
        return dataFactory.getOWLLiteral(literal, lang);
    }

    public static OWLOntology test;
    public static OWLOntology naf;
    public static OWLOntology pizza;
    public static OWLOntology syntax;
    public static OWLOntology siblings;
    public static OWLOntology ondrejtest;
    public static OWLOntology sequentialUnion;
    public static OWLOntology entire;
    public static OWLDataFactory df = OWLManager.getOWLDataFactory();
    public static OWLOntologyManager managerForPizzaAndSyntax =
        OWLManager.createOWLOntologyManager();
    public static OWLOntologyManager managerForPizzaAndOndrej =
        OWLManager.createOWLOntologyManager();

    static {
        try {
            naf = naf(OWLManager.createOWLOntologyManager());
            test = country(OWLManager.createOWLOntologyManager());
            syntax = syntax(OWLManager.createOWLOntologyManager());
            siblings = siblings(OWLManager.createOWLOntologyManager());
            ondrejtest = ondrejtest(OWLManager.createOWLOntologyManager());
            sequentialUnion = sequentialUnion(OWLManager.createOWLOntologyManager());
            pizza = pizza(OWLManager.createOWLOntologyManager());
            entire = entire(OWLManager.createOWLOntologyManager());
            // load a copy of pizza and patterned pizza on the same manager
            OWLOntology temp = pizza(OWLManager.createOWLOntologyManager());
            managerForPizzaAndSyntax = syntax(temp.getOWLOntologyManager()).getOWLOntologyManager();
            temp = pizza(OWLManager.createOWLOntologyManager());
            managerForPizzaAndOndrej =
                ondrejtest(temp.getOWLOntologyManager()).getOWLOntologyManager();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
