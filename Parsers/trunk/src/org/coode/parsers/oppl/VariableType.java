/**
 * 
 */
package org.coode.parsers.oppl;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.coode.parsers.OWLEntitySymbol;
import org.coode.parsers.OWLType;
import org.coode.parsers.Symbol;
import org.coode.parsers.Type;
import org.coode.parsers.TypeVisitor;
import org.coode.parsers.TypeVisitorEx;
import org.coode.parsers.oppl.variableattribute.VariableAttribute;
import org.semanticweb.owl.model.OWLDataFactory;

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
			return new OWLEntitySymbol(name, dataFactory.getOWLClass(this.createURI(name)));
		}

		@Override
		public org.coode.oppl.variablemansyntax.VariableType getOPPLVariableType() {
			return org.coode.oppl.variablemansyntax.VariableType.CLASS;
		}

		@Override
		public Set<Symbol> getAttributeSymbols(String variableName) {
			return new HashSet<Symbol>(Arrays.<Symbol> asList(
					VariableAttribute.RENDERING.getSymbol(variableName),
					VariableAttribute.VALUES.getSymbol(variableName)));
		}
	},
	OBJECTPROPERTY {
		@Override
		public OWLType getOWLType() {
			return OWLType.OWL_OBJECT_PROPERTY;
		}

		@Override
		public OWLEntitySymbol getSymbol(OWLDataFactory dataFactory, String name) {
			return new OWLEntitySymbol(name, dataFactory.getOWLObjectProperty(this.createURI(name)));
		}

		@Override
		public org.coode.oppl.variablemansyntax.VariableType getOPPLVariableType() {
			return org.coode.oppl.variablemansyntax.VariableType.OBJECTPROPERTY;
		}

		@Override
		public Set<Symbol> getAttributeSymbols(String variableName) {
			return new HashSet<Symbol>(Arrays.<Symbol> asList(
					VariableAttribute.RENDERING.getSymbol(variableName),
					VariableAttribute.VALUES.getSymbol(variableName)));
		}
	},
	DATAPROPERTY {
		@Override
		public OWLType getOWLType() {
			return OWLType.OWL_DATA_PROPERTY;
		}

		@Override
		public OWLEntitySymbol getSymbol(OWLDataFactory dataFactory, String name) {
			return new OWLEntitySymbol(name, dataFactory.getOWLDataProperty(this.createURI(name)));
		}

		@Override
		public org.coode.oppl.variablemansyntax.VariableType getOPPLVariableType() {
			return org.coode.oppl.variablemansyntax.VariableType.DATAPROPERTY;
		}

		@Override
		public Set<Symbol> getAttributeSymbols(String variableName) {
			return new HashSet<Symbol>(Arrays.<Symbol> asList(
					VariableAttribute.RENDERING.getSymbol(variableName),
					VariableAttribute.VALUES.getSymbol(variableName)));
		}
	},
	INDIVIDUAL {
		@Override
		public OWLType getOWLType() {
			return OWLType.OWL_INDIVIDUAL;
		}

		@Override
		public OWLEntitySymbol getSymbol(OWLDataFactory dataFactory, String name) {
			return new OWLEntitySymbol(name, dataFactory.getOWLIndividual(this.createURI(name)));
		}

		@Override
		public org.coode.oppl.variablemansyntax.VariableType getOPPLVariableType() {
			return org.coode.oppl.variablemansyntax.VariableType.INDIVIDUAL;
		}

		@Override
		public Set<Symbol> getAttributeSymbols(String variableName) {
			return new HashSet<Symbol>(Arrays.<Symbol> asList(
					VariableAttribute.RENDERING.getSymbol(variableName),
					VariableAttribute.VALUES.getSymbol(variableName)));
		}
	},
	CONSTANT {
		@Override
		public OWLType getOWLType() {
			return OWLType.OWL_CONSTANT;
		}

		@Override
		public Symbol getSymbol(OWLDataFactory dataFactory, String name) {
			return new OWLConstantSymbol(name, dataFactory.getOWLUntypedConstant(name));
		}

		@Override
		public org.coode.oppl.variablemansyntax.VariableType getOPPLVariableType() {
			return org.coode.oppl.variablemansyntax.VariableType.CONSTANT;
		}

		@Override
		public Set<Symbol> getAttributeSymbols(String variableName) {
			return new HashSet<Symbol>(Arrays.<Symbol> asList(
					VariableAttribute.RENDERING.getSymbol(variableName),
					VariableAttribute.VALUES.getSymbol(variableName)));
		}
	};
	private final static Map<String, VariableType> map = new HashMap<String, VariableType>();
	private final static Map<org.coode.oppl.variablemansyntax.VariableType, VariableType> typeMap = new HashMap<org.coode.oppl.variablemansyntax.VariableType, VariableType>();
	private final String NAMESPACE = "http://www.coode.org/oppl/variablemansyntax#";

	protected URI createURI(String name) {
		return URI.create(this.NAMESPACE + name);
	}

	static {
		map.put("CLASS", CLASS);
		map.put("OBJECTPROPERTY", OBJECTPROPERTY);
		map.put("DATAPROPERTY", DATAPROPERTY);
		map.put("INDIVIDUAL", INDIVIDUAL);
		map.put("CONSTANT", CONSTANT);
		typeMap.put(org.coode.oppl.variablemansyntax.VariableType.CLASS, CLASS);
		typeMap.put(org.coode.oppl.variablemansyntax.VariableType.OBJECTPROPERTY, OBJECTPROPERTY);
		typeMap.put(org.coode.oppl.variablemansyntax.VariableType.DATAPROPERTY, DATAPROPERTY);
		typeMap.put(org.coode.oppl.variablemansyntax.VariableType.INDIVIDUAL, INDIVIDUAL);
		typeMap.put(org.coode.oppl.variablemansyntax.VariableType.CONSTANT, CONSTANT);
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

	public static VariableType getVariableType(
			org.coode.oppl.variablemansyntax.VariableType variableType) {
		return typeMap.get(variableType);
	}

	public abstract OWLType getOWLType();

	public abstract Symbol getSymbol(OWLDataFactory dataFactory, String name);

	public abstract org.coode.oppl.variablemansyntax.VariableType getOPPLVariableType();

	public abstract Set<Symbol> getAttributeSymbols(String variableName);
}
