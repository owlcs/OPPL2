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
package org.coode.patterns.syntax;

import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.entity.OWLEntityCreationException;
import org.coode.oppl.entity.OWLEntityCreationSet;
import org.coode.oppl.entity.OWLEntityFactory;
import org.coode.oppl.utils.ParserFactory;
import org.coode.oppl.variablemansyntax.VariableTypeVisitorEx;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedVariable;
import org.coode.oppl.variablemansyntax.variabletypes.CLASSVariable;
import org.coode.oppl.variablemansyntax.variabletypes.CONSTANTVariable;
import org.coode.oppl.variablemansyntax.variabletypes.DATAPROPERTYVariable;
import org.coode.oppl.variablemansyntax.variabletypes.INDIVIDUALVariable;
import org.coode.oppl.variablemansyntax.variabletypes.OBJECTPROPERTYVariable;
import org.coode.patterns.PatternException;
import org.coode.patterns.PatternSignature;
import org.semanticweb.owl.expression.OWLEntityChecker;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLOntologyChangeException;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 *         Sep 29, 2008
 */
public class PatternParserUtils {
	public static String create(OWLOntologyManager manager,
			final String toCreate, int i, PatternSignature signature,
			OPPLAbstractFactory factory) throws PatternException,
			OWLEntityCreationException, OWLOntologyChangeException {
		// VariableType ithVariableType = signature.getIthVariableType(i);
		final OWLEntityFactory entityFactory = factory.getOWLEntityFactory();
		OWLEntity createdEntity = null;
		final OWLEntityChecker entityChecker = factory.getOWLEntityChecker();
		OWLEntityCreationSet<? extends OWLEntity> owlCreationSet = null;
		VariableTypeVisitorEx<OWLEntity> entityVisitor = new VariableTypeVisitorEx<OWLEntity>() {
			public OWLEntity visit(SingleValueGeneratedVariable<?> v) {
				switch (v.getType()) {
					case CLASS:
						return entityChecker.getOWLClass(toCreate);
					case OBJECTPROPERTY:
						return entityChecker.getOWLObjectProperty(toCreate);
					case DATAPROPERTY:
						return entityChecker.getOWLDataProperty(toCreate);
					case CONSTANT:
						return null;
					case INDIVIDUAL:
						return entityChecker.getOWLIndividual(toCreate);
					default:
						break;
				}
				// FIXME same as the other method in the other nested class
				return null;
			}

			public OWLEntity visit(INDIVIDUALVariable v) {
				return entityChecker.getOWLIndividual(toCreate);
			}

			public OWLEntity visit(DATAPROPERTYVariable v) {
				return entityChecker.getOWLDataProperty(toCreate);
			}

			public OWLEntity visit(OBJECTPROPERTYVariable v) {
				return entityChecker.getOWLObjectProperty(toCreate);
			}

			public OWLEntity visit(CONSTANTVariable v) {
				// TODO Auto-generated method stub
				return null;
			}

			public OWLEntity visit(CLASSVariable v) {
				return entityChecker.getOWLClass(toCreate);
			}
		};
		createdEntity = signature.getIthVariable(i).accept(entityVisitor);
		if (createdEntity == null) {
			VariableTypeVisitorEx<OWLEntityCreationSet<? extends OWLEntity>> owlSetVisitor = new VariableTypeVisitorEx<OWLEntityCreationSet<? extends OWLEntity>>() {
				public OWLEntityCreationSet<? extends OWLEntity> visit(
						SingleValueGeneratedVariable<?> v) {
					switch (v.getType()) {
						case CLASS:
							try {
								return entityFactory.createOWLClass(toCreate,
										null);
							} catch (OWLEntityCreationException e) {
								throw new RuntimeException(e.getMessage(), e);
							}
						case OBJECTPROPERTY:
							try {
								return entityFactory.createOWLObjectProperty(
										toCreate, null);
							} catch (OWLEntityCreationException e) {
								throw new RuntimeException(e.getMessage(), e);
							}
						case DATAPROPERTY:
							try {
								return entityFactory.createOWLDataProperty(
										toCreate, null);
							} catch (OWLEntityCreationException e) {
								throw new RuntimeException(e.getMessage(), e);
							}
						case CONSTANT:
							return null;
						case INDIVIDUAL:
							try {
								return entityFactory.createOWLIndividual(
										toCreate, null);
							} catch (OWLEntityCreationException e) {
								throw new RuntimeException(e.getMessage(), e);
							}
						default:
							break;
					}
					// FIXME this needs to be reworked in the
					// VariableType.buildOWLObject
					return null;
				}

				public OWLEntityCreationSet<? extends OWLEntity> visit(
						INDIVIDUALVariable v) {
					try {
						return entityFactory
								.createOWLIndividual(toCreate, null);
					} catch (OWLEntityCreationException e) {
						throw new RuntimeException(e.getMessage(), e);
					}
				}

				public OWLEntityCreationSet<? extends OWLEntity> visit(
						DATAPROPERTYVariable v) {
					try {
						return entityFactory.createOWLDataProperty(toCreate,
								null);
					} catch (OWLEntityCreationException e) {
						throw new RuntimeException(e.getMessage(), e);
					}
				}

				public OWLEntityCreationSet<? extends OWLEntity> visit(
						OBJECTPROPERTYVariable v) {
					try {
						return entityFactory.createOWLObjectProperty(toCreate,
								null);
					} catch (OWLEntityCreationException e) {
						throw new RuntimeException(e.getMessage(), e);
					}
				}

				public OWLEntityCreationSet<? extends OWLEntity> visit(
						CONSTANTVariable v) {
					// TODO Auto-generated method stub
					return null;
				}

				public OWLEntityCreationSet<? extends OWLEntity> visit(
						CLASSVariable v) {
					try {
						return entityFactory.createOWLClass(toCreate, null);
					} catch (OWLEntityCreationException e) {
						throw new RuntimeException(e.getMessage(), e);
					}
				}
			};
			owlCreationSet = signature.getIthVariable(i).accept(owlSetVisitor);
			if (owlCreationSet != null) {
				manager.applyChanges(owlCreationSet.getOntologyChanges());
				createdEntity = owlCreationSet.getOWLEntity();
			}
		}
		// switch (ithVariableType) {
		// case CLASS:
		// createdEntity = entityChecker.getOWLClass(toCreate);
		// if (createdEntity == null) {
		// owlCreationSet = entityFactory.createOWLClass(toCreate,
		// null);
		// }
		// break;
		// case OBJECTPROPERTY:
		// createdEntity = entityChecker.getOWLObjectProperty(toCreate);
		// if (createdEntity == null) {
		// owlCreationSet = entityFactory.createOWLObjectProperty(
		// toCreate, null);
		// }
		// break;
		// case DATAPROPERTY:
		// createdEntity = entityChecker.getOWLDataProperty(toCreate);
		// if (createdEntity == null) {
		// owlCreationSet = entityFactory.createOWLDataProperty(
		// toCreate, null);
		// }
		// break;
		// case INDIVIDUAL:
		// createdEntity = entityChecker.getOWLIndividual(toCreate);
		// if (createdEntity == null) {
		// owlCreationSet = entityFactory.createOWLIndividual(
		// toCreate, null);
		// }
		// break;
		// default:
		// break;
		// }
		return createdEntity != null ? ParserFactory.getInstance()
				.getOPPLFactory().getOWLEntityRenderer(
						signature.getPattern().getConstraintSystem()).render(
						createdEntity) : null;
	}
}
