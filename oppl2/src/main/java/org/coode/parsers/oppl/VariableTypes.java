package org.coode.parsers.oppl;

import java.util.HashMap;
import java.util.Map;

import org.coode.oppl.variabletypes.VariableType;
import org.coode.oppl.variabletypes.VariableTypeFactory;
import org.coode.parsers.*;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;

/**
 * @author Luigi Iannone
 */
public enum VariableTypes implements Type {
    /** class type */
    CLASS {

        @Override
        public OWLType getOWLType() {
            return OWLType.OWL_CLASS;
        }

        @Override
        public OWLEntitySymbol getSymbol(OWLDataFactory dataFactory, String name) {
            return new OWLEntitySymbol(name, dataFactory.getOWLClass(createIRI(name)));
        }

        @Override
        public VariableType<?> getOPPLVariableType() {
            return VariableTypeFactory.getCLASSVariableType();
        }
    },
    /** object property type */
    OBJECTPROPERTY {

        @Override
        public OWLType getOWLType() {
            return OWLType.OWL_OBJECT_PROPERTY;
        }

        @Override
        public OWLEntitySymbol getSymbol(OWLDataFactory dataFactory, String name) {
            return new OWLEntitySymbol(name,
                dataFactory.getOWLObjectProperty(createIRI(name)));
        }

        @Override
        public VariableType<?> getOPPLVariableType() {
            return VariableTypeFactory.getOBJECTPROPERTYTypeVariableType();
        }
    },
    /** data property type */
    DATAPROPERTY {

        @Override
        public OWLType getOWLType() {
            return OWLType.OWL_DATA_PROPERTY;
        }

        @Override
        public OWLEntitySymbol getSymbol(OWLDataFactory dataFactory, String name) {
            return new OWLEntitySymbol(name,
                dataFactory.getOWLDataProperty(createIRI(name)));
        }

        @Override
        public VariableType<?> getOPPLVariableType() {
            return VariableTypeFactory.getDATAPROPERTYVariableType();
        }
    },
    /** annotation property type */
    ANNOTATIONPROPERTY {

        @Override
        public OWLType getOWLType() {
            return OWLType.OWL_ANNOTATION_PROPERTY;
        }

        @Override
        public Symbol getSymbol(OWLDataFactory dataFactory, String name) {
            return new OWLEntitySymbol(name,
                dataFactory.getOWLAnnotationProperty(createIRI(name)));
        }

        @Override
        public VariableType<?> getOPPLVariableType() {
            return VariableTypeFactory.getANNOTATIONPROPERTYVariableType();
        }
    },
    /** individual type */
    INDIVIDUAL {

        @Override
        public OWLType getOWLType() {
            return OWLType.OWL_INDIVIDUAL;
        }

        @Override
        public OWLEntitySymbol getSymbol(OWLDataFactory dataFactory, String name) {
            return new OWLEntitySymbol(name,
                dataFactory.getOWLNamedIndividual(createIRI(name)));
        }

        @Override
        public VariableType<?> getOPPLVariableType() {
            return VariableTypeFactory.getINDIVIDUALVariableType();
        }
    },
    /** constant type */
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
        public VariableType<?> getOPPLVariableType() {
            return VariableTypeFactory.getCONSTANTVariableType();
        }
    };

    private final static Map<String, VariableTypes> map = new HashMap<>();
    private final static Map<VariableType<?>, VariableTypes> typeMap = new HashMap<>();
    private final String NAMESPACE = "http://www.coode.org/oppl/variablemansyntax#";

    protected IRI createIRI(String name) {
        return IRI.create(NAMESPACE + name);
    }

    static {
        map.put("CLASS", CLASS);
        map.put("OBJECTPROPERTY", OBJECTPROPERTY);
        map.put("DATAPROPERTY", DATAPROPERTY);
        map.put("INDIVIDUAL", INDIVIDUAL);
        map.put("CONSTANT", CONSTANT);
        map.put("ANNOTATIONPROPERTY", ANNOTATIONPROPERTY);
        typeMap.put(VariableTypeFactory.getCLASSVariableType(), CLASS);
        typeMap.put(VariableTypeFactory.getOBJECTPROPERTYTypeVariableType(),
            OBJECTPROPERTY);
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

    /**
     * @param string
     *        string
     * @return matching type
     */
    public static VariableTypes getVariableType(String string) {
        return map.get(string);
    }

    /**
     * @param variableType
     *        variableType
     * @return type for variable type
     */
    public static VariableTypes getVariableType(VariableType<?> variableType) {
        return typeMap.get(variableType);
    }

    /**
     * @return owl type
     */
    public abstract OWLType getOWLType();

    /**
     * @param dataFactory
     *        dataFactory
     * @param name
     *        name
     * @return symbol
     */
    public abstract Symbol getSymbol(OWLDataFactory dataFactory, String name);

    /**
     * @return variable type
     */
    public abstract VariableType<?> getOPPLVariableType();
}
