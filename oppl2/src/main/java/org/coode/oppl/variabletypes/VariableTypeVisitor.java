package org.coode.oppl.variabletypes;

/** @author Luigi Iannone */
public interface VariableTypeVisitor {
    /** @param classVariableType */
    void visitCLASSVariableType(CLASSVariableType classVariableType);

    /** @param objectpropertyVariableType */
    void visitOBJECTPROPERTYVariableType(
            OBJECTPROPERTYVariableType objectpropertyVariableType);

    /** @param datapropertyVariableType */
    void visitDATAPROPERTYVariableType(DATAPROPERTYVariableType datapropertyVariableType);

    /** @param individualVariableType */
    void visitINDIVIDUALVariableType(INDIVIDUALVariableType individualVariableType);

    /** @param constantVariableType */
    void visitCONSTANTVariableType(CONSTANTVariableType constantVariableType);

    /** @param annotationpropertyVariableType */
    void visitANNOTATIONPROPERTYVariableType(
            ANNOTATIONPROPERTYVariableType annotationpropertyVariableType);
}
