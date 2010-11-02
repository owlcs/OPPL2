/**
 * 
 */
package org.coode.parsers.oppl;

import java.util.HashMap;
import java.util.Map;

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
public enum VariableType implements Type {
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
		public org.coode.oppl.VariableType getOPPLVariableType() {
			return org.coode.oppl.VariableType.CLASS;
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
		public org.coode.oppl.VariableType getOPPLVariableType() {
			return org.coode.oppl.VariableType.OBJECTPROPERTY;
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
		public org.coode.oppl.VariableType getOPPLVariableType() {
			return org.coode.oppl.VariableType.DATAPROPERTY;
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
		public org.coode.oppl.VariableType getOPPLVariableType() {
			return org.coode.oppl.VariableType.INDIVIDUAL;
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
		public org.coode.oppl.VariableType getOPPLVariableType() {
			return org.coode.oppl.VariableType.CONSTANT;
		}
	};
	private final static Map<String, VariableType> map = new HashMap<String, VariableType>();
	private final static Map<org.coode.oppl.VariableType, VariableType> typeMap = new HashMap<org.coode.oppl.VariableType, VariableType>();
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
		typeMap.put(org.coode.oppl.VariableType.CLASS, CLASS);
		typeMap.put(org.coode.oppl.VariableType.OBJECTPROPERTY, OBJECTPROPERTY);
		typeMap.put(org.coode.oppl.VariableType.DATAPROPERTY, DATAPROPERTY);
		typeMap.put(org.coode.oppl.VariableType.INDIVIDUAL, INDIVIDUAL);
		typeMap.put(org.coode.oppl.VariableType.CONSTANT, CONSTANT);
	}

	public void accept(TypeVisitor visitor) {
		visitor.visitNonOWLType(this);
	}

	public <O> O accept(TypeVisitorEx<O> visitor) {
		return visitor.visitNonOWLType(this);
	}

	public static VariableType getVariableType(String string) {
		return map.get(string);
	}

	public static VariableType getVariableType(org.coode.oppl.VariableType variableType) {
		return typeMap.get(variableType);
	}

	public abstract OWLType getOWLType();

	public abstract Symbol getSymbol(OWLDataFactory dataFactory, String name);

	public abstract org.coode.oppl.VariableType getOPPLVariableType();
}
