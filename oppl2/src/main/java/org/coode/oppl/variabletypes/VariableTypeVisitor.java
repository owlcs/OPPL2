package org.coode.oppl.variabletypes;

public interface VariableTypeVisitor {
    void visitCLASSVariableType(CLASSVariableType classVariableType);

    void visitOBJECTPROPERTYVariableType(
            OBJECTPROPERTYVariableType objectpropertyVariableType);

    void visitDATAPROPERTYVariableType(DATAPROPERTYVariableType datapropertyVariableType);

    void visitINDIVIDUALVariableType(INDIVIDUALVariableType individualVariableType);

    void visitCONSTANTVariableType(CONSTANTVariableType constantVariableType);

    void visitANNOTATIONPROPERTYVariableType(
            ANNOTATIONPROPERTYVariableType annotationpropertyVariableType);
}
