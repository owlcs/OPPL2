package org.coode.oppl.testcaseontologies;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.StringDocumentTarget;
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
import org.semanticweb.owlapi.vocab.XSDVocabulary;

public class TestCaseTestOntologies {
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

    private static OWLDatatype string() {
        return OWL2Datatype.XSD_STRING.getDatatype(dataFactory);
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

    public static OWLOntology pizza;
    public static OWLDataFactory df = OWLManager.getOWLDataFactory();
    static {
        try {
            pizza = pizza(OWLManager.createOWLOntologyManager());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
