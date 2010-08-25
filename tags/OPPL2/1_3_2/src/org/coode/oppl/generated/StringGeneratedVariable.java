package org.coode.oppl.generated;

import java.net.URI;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.VariableType;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.entity.OWLEntityCreationException;
import org.coode.oppl.entity.OWLEntityCreationSet;
import org.coode.oppl.entity.OWLEntityFactory;
import org.coode.oppl.variabletypes.CLASSVariable;
import org.coode.oppl.variabletypes.CONSTANTVariable;
import org.coode.oppl.variabletypes.DATAPROPERTYVariable;
import org.coode.oppl.variabletypes.INDIVIDUALVariable;
import org.coode.oppl.variabletypes.OBJECTPROPERTYVariable;
import org.semanticweb.owl.expression.OWLEntityChecker;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLOntologyChangeException;

public class StringGeneratedVariable extends AbstractGeneratedVariable<String> {
	private final ConstraintSystem constraintSystem;

	protected StringGeneratedVariable(String name, VariableType type,
			SingleValueGeneratedValue<String> value, ConstraintSystem cs) {
		super(name, type, value);
		if (cs == null) {
			throw new NullPointerException("The constraint system cannot be null");
		}
		this.constraintSystem = cs;
	}

	@Override
	protected OWLObject generateObject(final String aValue) {
		OWLObject objectToReturn = null;
		final OWLEntityChecker entityChecker = this.getConstraintSystem().getOPPLFactory().getOWLEntityChecker();
		final OWLEntityFactory ef = this.getConstraintSystem().getOPPLFactory().getOWLEntityFactory();
		final OWLDataFactory df = this.getConstraintSystem().getOPPLFactory().getOWLDataFactory();
		VariableTypeVisitorEx<OWLObject> visitor = new VariableTypeVisitorEx<OWLObject>() {
			public OWLObject visit(SingleValueGeneratedVariable<?> v) {
				// TODO not nice
				switch (v.getType()) {
				case CLASS:
					return this.buildClass(aValue, entityChecker, ef, df);
				case DATAPROPERTY:
					return this.buildDataProperty(aValue, entityChecker, ef, df);
				case OBJECTPROPERTY:
					return this.buildObjectProperty(aValue, entityChecker, ef, df);
				case CONSTANT:
					return this.buildConstant(aValue, df);
				case INDIVIDUAL:
					return this.buildIndividual(aValue, entityChecker, ef, df);
				default:
					return null;
				}
			}

			public OWLObject visit(INDIVIDUALVariable v) {
				return this.buildIndividual(aValue, entityChecker, ef, df);
			}

			private OWLObject buildIndividual(final String aValue,
					final OWLEntityChecker entityChecker, final OWLEntityFactory ef,
					final OWLDataFactory df) {
				OWLObject toReturn = null;
				try {
					toReturn = entityChecker.getOWLIndividual(aValue);
					if (toReturn == null) {
						toReturn = StringGeneratedVariable.this.createUpdates(ef.createOWLIndividual(
								aValue,
								null));
					}
				} catch (OWLEntityCreationException e) {
					toReturn = df.getOWLIndividual(StringGeneratedVariable.this.buildURI(aValue));
				} catch (OWLOntologyChangeException e) {
					throw new RuntimeException(e);
				}
				return toReturn;
			}

			public OWLObject visit(DATAPROPERTYVariable v) {
				return this.buildDataProperty(aValue, entityChecker, ef, df);
			}

			private OWLObject buildDataProperty(final String aValue,
					final OWLEntityChecker entityChecker, final OWLEntityFactory ef,
					final OWLDataFactory df) {
				OWLObject toReturn = null;
				try {
					toReturn = entityChecker.getOWLDataProperty(aValue);
					if (toReturn == null) {
						toReturn = StringGeneratedVariable.this.createUpdates(ef.createOWLDataProperty(
								aValue,
								null));
					}
				} catch (OWLEntityCreationException e) {
					toReturn = df.getOWLDataProperty(StringGeneratedVariable.this.buildURI(aValue));
				} catch (OWLOntologyChangeException e) {
					throw new RuntimeException(e);
				}
				return toReturn;
			}

			public OWLObject visit(OBJECTPROPERTYVariable v) {
				return this.buildObjectProperty(aValue, entityChecker, ef, df);
			}

			private OWLObject buildObjectProperty(final String aValue,
					final OWLEntityChecker entityChecker, final OWLEntityFactory ef,
					final OWLDataFactory df) {
				OWLObject toReturn = null;
				try {
					toReturn = entityChecker.getOWLObjectProperty(aValue);
					if (toReturn == null) {
						toReturn = StringGeneratedVariable.this.createUpdates(ef.createOWLObjectProperty(
								aValue,
								null));
					}
				} catch (OWLEntityCreationException e) {
					toReturn = df.getOWLObjectProperty(StringGeneratedVariable.this.buildURI(aValue));
				} catch (OWLOntologyChangeException e) {
					throw new RuntimeException(e);
				}
				return toReturn;
			}

			public OWLObject visit(CONSTANTVariable v) {
				return this.buildConstant(aValue, df);
			}

			private OWLObject buildConstant(final String aValue, final OWLDataFactory df) {
				return df.getOWLTypedConstant(aValue);
			}

			public OWLObject visit(CLASSVariable v) {
				return this.buildClass(aValue, entityChecker, ef, df);
			}

			private OWLObject buildClass(final String aValue, final OWLEntityChecker entityChecker,
					final OWLEntityFactory ef, final OWLDataFactory df) {
				OWLObject toReturn = null;
				// XXX not too nice a way to handle the case in which the name
				// passed in is not good for a class URI
				// handle the creation of a class using text only valid for a
				// label
				// if (aValue.indexOf('\'') > -1 || aValue.indexOf(' ') > -1) {
				// // then either "'" or " " are in the string - label needed
				// String label = aValue.trim().replace("'", "");
				// String realShortName = label.replace(" ", "_");
				// toReturn = this.buildClass(realShortName, entityChecker,
				// ef, df);
				// OWLLabelAnnotation labelAnnotation = df
				// .getOWLLabelAnnotation(label);
				// OWLAxiomChange extraChange = new AddAxiom(
				// StringGeneratedVariable.this.ontology, df
				// .getOWLEntityAnnotationAxiom(
				// (OWLClass) toReturn,
				// labelAnnotation));
				// try {
				// ParserFactory.getInstance().getOWLOntologyManager()
				// .applyChanges(Arrays.asList(extraChange));
				// } catch (OWLOntologyChangeException e) {
				// throw new RuntimeException(e);
				// }
				// } else {
				try {
					toReturn = entityChecker.getOWLClass(aValue);
					if (toReturn == null) {
						toReturn = StringGeneratedVariable.this.createUpdates(ef.createOWLClass(
								aValue,
								null));
					}
				} catch (OWLEntityCreationException e) {
					toReturn = df.getOWLClass(StringGeneratedVariable.this.buildURI(aValue));
				} catch (OWLOntologyChangeException e) {
					throw new RuntimeException(e);
				}
				// }
				return toReturn;
			}
		};
		objectToReturn = this.accept(visitor);
		return objectToReturn;
		// switch (this.getType()) {
		// case CLASS:
		// try {
		// toReturn = entityChecker.getOWLClass(aValue);
		// if (toReturn == null) {
		// toReturn = this.createUpdates(ef.createOWLClass(aValue,
		// null));
		// }
		// } catch (OWLEntityCreationException e) {
		// toReturn = df.getOWLClass(this.buildURI(aValue));
		// } catch (OWLOntologyChangeException e) {
		// throw new RuntimeException(e);
		// }
		// break;
		// case OBJECTPROPERTY:
		// try {
		// toReturn = entityChecker.getOWLObjectProperty(aValue);
		// if (toReturn == null) {
		// toReturn = this.createUpdates(ef
		// .createOWLObjectProperty(aValue, null));
		// }
		// } catch (OWLEntityCreationException e) {
		// toReturn = df.getOWLObjectProperty(this.buildURI(aValue));
		// } catch (OWLOntologyChangeException e) {
		// throw new RuntimeException(e);
		// }
		// break;
		// case DATAPROPERTY:
		// try {
		// toReturn = entityChecker.getOWLDataProperty(aValue);
		// if (toReturn == null) {
		// toReturn = this.createUpdates(ef.createOWLDataProperty(
		// aValue, null));
		// }
		// } catch (OWLEntityCreationException e) {
		// toReturn = df.getOWLDataProperty(this.buildURI(aValue));
		// } catch (OWLOntologyChangeException e) {
		// throw new RuntimeException(e);
		// }
		// break;
		// case INDIVIDUAL:
		// try {
		// toReturn = entityChecker.getOWLIndividual(aValue);
		// if (toReturn == null) {
		// toReturn = this.createUpdates(ef.createOWLIndividual(
		// aValue, null));
		// }
		// } catch (OWLEntityCreationException e) {
		// toReturn = df.getOWLIndividual(this.buildURI(aValue));
		// } catch (OWLOntologyChangeException e) {
		// throw new RuntimeException(e);
		// }
		// break;
		// case CONSTANT:
		// toReturn = df.getOWLTypedConstant(aValue);
		// break;
		// default:
		// break;
		// }
		// return toReturn;
	}

	private OWLObject createUpdates(OWLEntityCreationSet<? extends OWLEntity> set)
			throws OWLEntityCreationException, OWLOntologyChangeException {
		this.getConstraintSystem().getOntologyManager().applyChanges(set.getOntologyChanges());
		return set.getOWLEntity();
	}

	/**
	 * @param aValue
	 * @return
	 */
	private URI buildURI(String aValue) {
		return URI.create(this.getConstraintSystem().getOntology().getURI().toString() + "#"
				+ aValue);
	}

	public static StringGeneratedVariable buildGeneratedVariable(String name, VariableType type,
			SingleValueGeneratedValue<String> value, ConstraintSystem cs) {
		return new StringGeneratedVariable(name, type, value, cs);
	}

	@Override
	protected SingleValueGeneratedVariable<String> replace(SingleValueGeneratedValue<String> v) {
		return buildGeneratedVariable(this.getName(), this.getType(), v, this.getConstraintSystem());
	}

	public String getOPPLFunction() {
		return "create(" + this.getValue() + ")";
	}

	public String getArgumentString() {
		return this.getValue().toString();
	}

	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}

	/**
	 * @return the constraintSystem
	 */
	public ConstraintSystem getConstraintSystem() {
		return this.constraintSystem;
	}
}
