/**
 * 
 */
package org.coode.parsers.oppl;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.coode.parsers.OWLEntitySymbol;
import org.coode.parsers.OWLType;
import org.coode.parsers.Symbol;
import org.coode.parsers.Type;
import org.coode.parsers.TypeVisitor;
import org.coode.parsers.TypeVisitorEx;
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
	};
	private final static Map<String, VariableType> map = new HashMap<String, VariableType>();
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

	public abstract OWLType getOWLType();

	public abstract Symbol getSymbol(OWLDataFactory dataFactory, String name);
}
