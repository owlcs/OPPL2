package org.coode.oppl.variabletypes;

/** @author Luigi Iannone */
public interface VariableTypeVisitor {
    /** @param classVariableType
     *            classVariableType */
    void visitCLASSVariableType(CLASSVariableType classVariableType);

    /** @param objectpropertyVariableType
     *            objectpropertyVariableType */
    void visitOBJECTPROPERTYVariableType(
            OBJECTPROPERTYVariableType objectpropertyVariableType);

    /** @param datapropertyVariableType
     *            datapropertyVariableType */
    void visitDATAPROPERTYVariableType(DATAPROPERTYVariableType datapropertyVariableType);

    /** @param individualVariableType
     *            individualVariableType */
    void visitINDIVIDUALVariableType(INDIVIDUALVariableType individualVariableType);

    /** @param constantVariableType
     *            constantVariableType */
    void visitCONSTANTVariableType(CONSTANTVariableType constantVariableType);

    /** @param annotationpropertyVariableType
     *            annotationpropertyVariableType */
    void visitANNOTATIONPROPERTYVariableType(
            ANNOTATIONPROPERTYVariableType annotationpropertyVariableType);
}
