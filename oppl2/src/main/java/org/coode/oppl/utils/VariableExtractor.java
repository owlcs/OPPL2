/**
 * Copyright (C) 2008, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.coode.oppl.utils;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.datafactory.OPPLOWLDifferentIndividualsAxiom;
import org.coode.oppl.datafactory.OPPLOWLDisjointClassesAxiom;
import org.coode.oppl.datafactory.OPPLOWLDisjointDataPropertiesAxiom;
import org.coode.oppl.datafactory.OPPLOWLDisjointObjectPropertiesAxiom;
import org.coode.oppl.datafactory.OPPLOWLSameIndividualAxiom;
import org.coode.oppl.function.Aggregandum;
import org.coode.oppl.function.Aggregation;
import org.coode.oppl.function.Constant;
import org.coode.oppl.function.Create;
import org.coode.oppl.function.Expression;
import org.coode.oppl.function.GroupVariableAttribute;
import org.coode.oppl.function.IRIVariableAttribute;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.function.OPPLFunctionVisitorEx;
import org.coode.oppl.function.RenderingVariableAttribute;
import org.coode.oppl.function.ToLowerCaseStringManipulationOPPLFunction;
import org.coode.oppl.function.ToUpperCaseStringManipulationOPPLFunction;
import org.coode.oppl.function.ValuesVariableAtttribute;
import org.coode.oppl.function.inline.InlineSet;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.parsers.oppl.VariableIRI;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDatatypeRestriction;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectInverseOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;

/**
 * @author Luigi Iannone
 */
public class VariableExtractor {

    protected final ConstraintSystem cs;
    private final boolean includeGenerated;

    /**
     * @param constraintSystem constraintSystem
     * @param includeGenerated includeGenerated
     */
    public VariableExtractor(ConstraintSystem constraintSystem, boolean includeGenerated) {
        cs = checkNotNull(constraintSystem, "constraintSystem");
        this.includeGenerated = includeGenerated;
    }

    private final class Visitor implements OWLObjectVisitorEx<Set<Variable<?>>> {

        protected final Set<Variable<?>> set = new HashSet<>();
        protected final OPPLFunctionVisitorEx<Set<Variable<?>>> extractor =
            new OPPLFunctionVisitorEx<Set<Variable<?>>>() {

                @Override
                public <O, I> Set<Variable<?>> visitAggregation(Aggregation<O, I> a) {
                    for (Aggregandum<I> agg : a.getToAggregate()) {
                        for (OPPLFunction<? extends I> opplFunction : agg.getOPPLFunctions()) {
                            opplFunction.accept(this);
                        }
                    }
                    return set;
                }

                @Override
                public <O extends OWLObject> Set<Variable<?>> visitInlineSet(InlineSet<O> a) {
                    for (Aggregandum<Collection<O>> agg : a.getAggregandums()) {
                        for (OPPLFunction<Collection<O>> f : agg.getOPPLFunctions()) {
                            f.accept(this);
                        }
                    }
                    return set;
                }

                @Override
                public <P extends OWLObject> Set<Variable<?>> visitGenericOPPLFunction(
                    OPPLFunction<P> a) {
                    return set;
                }

                @Override
                public <O> Set<Variable<?>> visitConstant(Constant<O> a) {
                    O value = a.getValue();
                    if (value instanceof Variable) {
                        return Visitor.this.vetoVariableIntoCollection((Variable<?>) value);
                    }
                    // Some times the parser returns variables as entities
                    if (value instanceof OWLEntity) {
                        Variable<?> variable = cs.getVariable(((OWLEntity) value).getIRI());
                        if (variable != null) {
                            set.add(variable);
                        }
                    }
                    return set;
                }

                @Override
                public <O, I extends OPPLFunction<?>> Set<Variable<?>> visitCreate(Create<I, O> a) {
                    return a.getInput().accept(this);
                }

                @Override
                public <O extends OWLObject> Set<Variable<?>> visitExpression(Expression<O> a) {
                    return a.getExpression().accept(Visitor.this);
                }

                @Override
                public Set<Variable<?>> visitToLowerCaseStringManipulationOPPLFunction(
                    ToLowerCaseStringManipulationOPPLFunction a) {
                    return a.accept(this);
                }

                @Override
                public Set<Variable<?>> visitToUpperCaseStringManipulationOPPLFunction(
                    ToUpperCaseStringManipulationOPPLFunction a) {
                    return a.accept(this);
                }

                @Override
                public <O extends OWLObject> Set<Variable<?>> visitGroupVariableAttribute(
                    GroupVariableAttribute<O> a) {
                    return Visitor.this.vetoVariableIntoCollection(a.getVariable());
                }

                @Override
                public Set<Variable<?>> visitRenderingVariableAttribute(
                    RenderingVariableAttribute a) {
                    return Visitor.this.vetoVariableIntoCollection(a.getVariable());
                }

                @Override
                public Set<Variable<?>> visitIRIVariableAttribute(IRIVariableAttribute i) {
                    return Visitor.this.vetoVariableIntoCollection(i.getVariable());
                }

                @Override
                public <O extends OWLObject> Set<Variable<?>> visitValuesVariableAtttribute(
                    ValuesVariableAtttribute<O> a) {
                    return Visitor.this.vetoVariableIntoCollection(a.getVariable());
                }
            };

        public Visitor() {}

        @Override
        public <T> Set<Variable<?>> doDefault(T object) {
            return Collections.<Variable<?>>emptySet();
        }

        @Override
        public Set<Variable<?>> visit(OWLSubClassOfAxiom axiom) {
            axiom.getSuperClass().accept(this);
            axiom.getSubClass().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
            axiom.getProperty().accept(this);
            axiom.getObject().accept(this);
            axiom.getSubject().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLAnnotationAssertionAxiom axiom) {
            axiom.getSubject().accept(this);
            axiom.getAnnotation().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(IRI iri) {
            return iri.accept(new IRIVisitorExAdapter<Set<Variable<?>>>(set) {

                @Override
                public Set<Variable<?>> visitVariableIRI(VariableIRI i) {
                    return i.getAttribute().accept(extractor);
                }
            });
        }

        @Override
        public Set<Variable<?>> visit(OWLAsymmetricObjectPropertyAxiom axiom) {
            return axiom.getProperty().accept(this);
        }

        @Override
        public Set<Variable<?>> visit(OWLReflexiveObjectPropertyAxiom axiom) {
            return axiom.getProperty().accept(this);
        }

        @Override
        public Set<Variable<?>> visit(OWLDisjointClassesAxiom axiom) {
            if (OPPLOWLDisjointClassesAxiom.class.isAssignableFrom(axiom.getClass())) {
                ((OPPLOWLDisjointClassesAxiom) axiom).getInlineSet().accept(extractor);
            } else {
                axiom.classExpressions().forEach(c -> c.accept(this));
            }
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLDataPropertyDomainAxiom axiom) {
            axiom.getProperty().accept(this);
            axiom.getDomain().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectPropertyDomainAxiom axiom) {
            axiom.getProperty().accept(this);
            axiom.getDomain().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLEquivalentObjectPropertiesAxiom axiom) {
            axiom.properties().forEach(c -> c.accept(this));
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
            axiom.getObject().accept(this);
            axiom.getSubject().accept(this);
            axiom.getProperty().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLDifferentIndividualsAxiom axiom) {
            if (OPPLOWLDifferentIndividualsAxiom.class.isAssignableFrom(axiom.getClass())) {
                return ((OPPLOWLDifferentIndividualsAxiom) axiom).getInlineSet().accept(extractor);
            }
            axiom.individuals().forEach(i -> i.accept(this));
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLDisjointDataPropertiesAxiom axiom) {
            if (OPPLOWLDisjointDataPropertiesAxiom.class.isAssignableFrom(axiom.getClass())) {
                return ((OPPLOWLDisjointDataPropertiesAxiom) axiom).getInlineSet()
                    .accept(extractor);
            }
            axiom.properties().forEach(c -> c.accept(this));
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLDisjointObjectPropertiesAxiom axiom) {
            if (OPPLOWLDisjointObjectPropertiesAxiom.class.isAssignableFrom(axiom.getClass())) {
                return ((OPPLOWLDisjointObjectPropertiesAxiom) axiom).getInlineSet()
                    .accept(extractor);
            }
            axiom.properties().forEach(c -> c.accept(this));
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectPropertyRangeAxiom axiom) {
            axiom.getProperty().accept(this);
            axiom.getRange().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectPropertyAssertionAxiom axiom) {
            axiom.getSubject().accept(this);
            axiom.getProperty().accept(this);
            axiom.getObject().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLFunctionalObjectPropertyAxiom axiom) {
            return axiom.getProperty().accept(this);
        }

        @Override
        public Set<Variable<?>> visit(OWLSubObjectPropertyOfAxiom axiom) {
            axiom.getSubProperty().accept(this);
            axiom.getSuperProperty().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLDisjointUnionAxiom axiom) {
            axiom.classExpressions().forEach(c -> c.accept(this));
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLSymmetricObjectPropertyAxiom axiom) {
            return axiom.getProperty().accept(this);
        }

        @Override
        public Set<Variable<?>> visit(OWLDataPropertyRangeAxiom axiom) {
            axiom.getProperty().accept(this);
            axiom.getRange().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLFunctionalDataPropertyAxiom axiom) {
            return axiom.getProperty().accept(this);
        }

        @Override
        public Set<Variable<?>> visit(OWLEquivalentDataPropertiesAxiom axiom) {
            axiom.properties().forEach(c -> c.accept(this));
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLClassAssertionAxiom axiom) {
            axiom.getIndividual().accept(this);
            axiom.getClassExpression().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLEquivalentClassesAxiom axiom) {
            axiom.classExpressions().forEach(c -> c.accept(this));
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLDataPropertyAssertionAxiom axiom) {
            axiom.getSubject().accept(this);
            axiom.getProperty().accept(this);
            axiom.getObject().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLTransitiveObjectPropertyAxiom axiom) {
            return axiom.getProperty().accept(this);
        }

        @Override
        public Set<Variable<?>> visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
            return axiom.getProperty().accept(this);
        }

        @Override
        public Set<Variable<?>> visit(OWLSubDataPropertyOfAxiom axiom) {
            axiom.getSubProperty().accept(this);
            axiom.getSuperProperty().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
            return axiom.getProperty().accept(this);
        }

        @Override
        public Set<Variable<?>> visit(OWLSameIndividualAxiom axiom) {
            if (OPPLOWLSameIndividualAxiom.class.isAssignableFrom(axiom.getClass())) {
                return ((OPPLOWLSameIndividualAxiom) axiom).getInlineSet().accept(extractor);
            }
            axiom.individuals().forEach(i -> i.accept(this));
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLSubPropertyChainOfAxiom axiom) {
            axiom.getSuperProperty().accept(this);
            axiom.getPropertyChain().forEach(o -> o.accept(this));
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLInverseObjectPropertiesAxiom axiom) {
            axiom.getFirstProperty().accept(this);
            axiom.getSecondProperty().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLClass e) {
            return vetoVariableIntoCollection(cs.getVariable(e.getIRI()));
        }

        @Override
        public Set<Variable<?>> visit(OWLAnnotationProperty e) {
            return vetoVariableIntoCollection(cs.getVariable(e.getIRI()));
        }

        @Override
        public Set<Variable<?>> visit(OWLAnnotation annotation) {
            annotation.getProperty().accept(this);
            annotation.getValue().accept(this);
            return set;
        }

        /**
         * @param variable variable
         * @return veto variables
         */
        protected Set<Variable<?>> vetoVariableIntoCollection(Variable<?> variable) {
            if (variable == null) {
                return set;
            }
            VariableVisitorEx<Set<Variable<?>>> variableVetoer =
                new VariableVisitorEx<Set<Variable<?>>>() {

                    @Override
                    public <O extends OWLObject> Set<Variable<?>> visit(GeneratedVariable<O> v) {
                        // Add the variables this generated variable refers to (they
                        // might not be mentioned elsewhere in the axiom)
                        v.getOPPLFunction().accept(extractor);
                        if (isIncludeGenerated()) {
                            set.add(v);
                        }
                        return set;
                    }

                    @Override
                    public <O extends OWLObject> Set<Variable<?>> visit(InputVariable<O> v) {
                        set.add(v);
                        return set;
                    }

                    @Override
                    public <O extends OWLObject> Set<Variable<?>> visit(
                        RegexpGeneratedVariable<O> rexp) {
                        set.add(rexp);
                        return set;
                    }
                };
            return variable.accept(variableVetoer);
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectIntersectionOf desc) {
            desc.operands().forEach(c -> c.accept(this));
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectUnionOf desc) {
            desc.operands().forEach(c -> c.accept(this));
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectComplementOf desc) {
            return desc.getOperand().accept(this);
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectSomeValuesFrom desc) {
            desc.getFiller().accept(this);
            desc.getProperty().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectAllValuesFrom desc) {
            desc.getFiller().accept(this);
            desc.getProperty().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectHasValue desc) {
            desc.getFiller().accept(this);
            desc.getProperty().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectMinCardinality desc) {
            desc.getFiller().accept(this);
            desc.getProperty().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectExactCardinality desc) {
            desc.getFiller().accept(this);
            desc.getProperty().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectMaxCardinality desc) {
            desc.getFiller().accept(this);
            desc.getProperty().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectHasSelf desc) {
            return desc.getProperty().accept(this);
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectOneOf desc) {
            desc.individuals().forEach(i -> i.accept(this));
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLDataSomeValuesFrom desc) {
            desc.getProperty().accept(this);
            desc.getFiller().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLDataAllValuesFrom desc) {
            desc.getProperty().accept(this);
            desc.getFiller().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLDataHasValue desc) {
            desc.getProperty().accept(this);
            desc.getFiller().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLDataMinCardinality desc) {
            desc.getFiller().accept(this);
            desc.getProperty().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLDataExactCardinality desc) {
            desc.getFiller().accept(this);
            desc.getProperty().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLDataMaxCardinality desc) {
            desc.getFiller().accept(this);
            desc.getProperty().accept(this);
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLDataComplementOf node) {
            return node.getDataRange().accept(this);
        }

        @Override
        public Set<Variable<?>> visit(OWLDataOneOf node) {
            node.values().forEach(c -> c.accept(this));
            return set;
        }

        @Override
        public Set<Variable<?>> visit(OWLDatatypeRestriction node) {
            return node.getDatatype().accept(this);
        }

        @Override
        public Set<Variable<?>> visit(OWLLiteral node) {
            return vetoVariableIntoCollection(cs.getVariable(node.getLiteral()));
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectProperty e) {
            return vetoVariableIntoCollection(cs.getVariable(e.getIRI()));
        }

        @Override
        public Set<Variable<?>> visit(OWLObjectInverseOf property) {
            return property.getInverse().accept(this);
        }

        @Override
        public Set<Variable<?>> visit(OWLDataProperty e) {
            return vetoVariableIntoCollection(cs.getVariable(e.getIRI()));
        }

        @Override
        public Set<Variable<?>> visit(OWLNamedIndividual e) {
            return vetoVariableIntoCollection(cs.getVariable(e.getIRI()));
        }
    }

    /**
     * @return the constraintSystem
     */
    public ConstraintSystem getConstraintSystem() {
        return cs;
    }

    /**
     * @return the includeGenerated
     */
    public boolean isIncludeGenerated() {
        return includeGenerated;
    }

    /**
     * @param owlObject owlObject
     * @return variables in the object
     */
    public Set<Variable<?>> extractVariables(OWLObject owlObject) {
        return owlObject.accept(new Visitor());
    }

    /**
     * @param opplFunction opplFunction
     * @return variables in the function
     */
    public Set<Variable<?>> extractVariables(OPPLFunction<?> opplFunction) {
        return opplFunction.accept(new Visitor().extractor);
    }
}
