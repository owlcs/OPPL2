/**
 * 
 */
package org.coode.parsers.oppl;

import java.util.HashMap;
import java.util.Map;

import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.coode.parsers.OWLEntitySymbol;
import org.coode.parsers.OWLLiteralSymbol;
import org.coode.parsers.OWLType;
import org.coode.parsers.Symbol;
import org.coode.parsers.Type;
import org.coode.parsers.TypeVisitor;
import org.coode.parsers.TypeVisitorEx;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;

/**
 * @author Luigi Iannone
 * 
 */
public enum VariableTypes implements Type {
	CLASS {
		@Override
		public OWLType getOWLType() {
			return OWLType.OWL_CLASS;
		}

		@Override
		public OWLEntitySymbol getSymbol(OWLDataFactory dataFactory, String name) {
			return new OWLEntitySymbol(name, dataFactory.getOWLClass(this.createIRI(name)));
		}

		@Override
		public org.coode.oppl.variabletypes.VariableType<?> getOPPLVariableType() {
			return VariableTypeFactory.getCLASSVariableType();
		}
	},
	OBJECTPROPERTY {
		@Override
		public OWLType getOWLType() {
			return OWLType.OWL_OBJECT_PROPERTY;
		}

		@Override
		public OWLEntitySymbol getSymbol(OWLDataFactory dataFactory, String name) {
			return new OWLEntitySymbol(name, dataFactory.getOWLObjectProperty(this.createIRI(name)));
		}

		@Override
		public org.coode.oppl.variabletypes.VariableType<?> getOPPLVariableType() {
			return VariableTypeFactory.getOBJECTPROPERTYTypeVariableType();
		}
	},
	DATAPROPERTY {
		@Override
		public OWLType getOWLType() {
			return OWLType.OWL_DATA_PROPERTY;
		}

		@Override
		public OWLEntitySymbol getSymbol(OWLDataFactory dataFactory, String name) {
			return new OWLEntitySymbol(name, dataFactory.getOWLDataProperty(this.createIRI(name)));
		}

		@Override
		public org.coode.oppl.variabletypes.VariableType<?> getOPPLVariableType() {
			return VariableTypeFactory.getDATAPROPERTYVariableType();
		}
	},
	ANNOTATIONPROPERTY {
		@Override
		public OWLType getOWLType() {
			return OWLType.OWL_ANNOTATION_PROPERTY;
		}

		@Override
		public Symbol getSymbol(OWLDataFactory dataFactory, String name) {
			return new OWLEntitySymbol(name,
					dataFactory.getOWLAnnotationProperty(this.createIRI(name)));
		}

		@Override
		public org.coode.oppl.variabletypes.VariableType<?> getOPPLVariableType() {
			return VariableTypeFactory.getANNOTATIONPROPERTYVariableType();
		}
	},
	INDIVIDUAL {
		@Override
		public OWLType getOWLType() {
			return OWLType.OWL_INDIVIDUAL;
		}

		@Override
		public OWLEntitySymbol getSymbol(OWLDataFactory dataFactory, String name) {
			return new OWLEntitySymbol(name,
					dataFactory.getOWLNamedIndividual(this.createIRI(name)));
		}

		@Override
		public org.coode.oppl.variabletypes.VariableType<?> getOPPLVariableType() {
			return VariableTypeFactory.getINDIVIDUALVariableType();
		}
	},
	CONSTANT {
		@Override
		public OWLType getOWLType() {
			return OWLType.OWL_CONSTANT;
		}

		@Override
		public Symbol getSymbol(OWLDataFactory dataFactory, String name) {
			return new OWLLiteralSymbol(name, dataFactory.getOWLLiteral(name));
		}

		@Override
		public org.coode.oppl.variabletypes.VariableType<?> getOPPLVariableType() {
			return VariableTypeFactory.getCONSTANTVariableType();
		}
	};
	private final static Map<String, VariableTypes> map = new HashMap<String, VariableTypes>();
	private final static Map<org.coode.oppl.variabletypes.VariableType<?>, VariableTypes> typeMap = new HashMap<org.coode.oppl.variabletypes.VariableType<?>, VariableTypes>();
	private final String NAMESPACE = "http://www.coode.org/oppl/variablemansyntax#";

	protected IRI createIRI(String name) {
		return IRI.create(this.NAMESPACE + name);
	}

	static {
		map.put("CLASS", CLASS);
		map.put("OBJECTPROPERTY", OBJECTPROPERTY);
		map.put("DATAPROPERTY", DATAPROPERTY);
		map.put("INDIVIDUAL", INDIVIDUAL);
		map.put("CONSTANT", CONSTANT);
		map.put("ANNOTATIONPROPERTY", ANNOTATIONPROPERTY);
		typeMap.put(VariableTypeFactory.getCLASSVariableType(), CLASS);
		typeMap.put(VariableTypeFactory.getOBJECTPROPERTYTypeVariableType(), OBJECTPROPERTY);
		typeMap.put(VariableTypeFactory.getDATAPROPERTYVariableType(), DATAPROPERTY);
		typeMap.put(VariableTypeFactory.getINDIVIDUALVariableType(), INDIVIDUAL);
		typeMap.put(VariableTypeFactory.getCONSTANTVariableType(), CONSTANT);
	}

    @Override
	public void accept(TypeVisitor visitor) {
		visitor.visitNonOWLType(this);
	}

    @Override
	public <O> O accept(TypeVisitorEx<O> visitor) {
		return visitor.visitNonOWLType(this);
	}

	public static VariableTypes getVariableType(String string) {
		return map.get(string);
	}

	public static VariableTypes getVariableType(
			org.coode.oppl.variabletypes.VariableType<?> variableType) {
		return typeMap.get(variableType);
	}

	public abstract OWLType getOWLType();

	public abstract Symbol getSymbol(OWLDataFactory dataFactory, String name);

	public abstract org.coode.oppl.variabletypes.VariableType<?> getOPPLVariableType();
}
