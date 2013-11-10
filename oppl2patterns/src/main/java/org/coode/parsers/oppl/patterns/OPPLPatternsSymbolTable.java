/**
 * 
 */
package org.coode.parsers.oppl.patterns;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.coode.oppl.Variable;
import org.coode.parsers.Scope;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.VariableTypes;
import org.coode.patterns.PatternConstraintSystem;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/** @author Luigi Iannone */
public class OPPLPatternsSymbolTable extends OPPLSymbolTable {
    private final OWLOntologyManager ontologyManager;

    /** @param globalScope
     * @param dataFactory */
    public OPPLPatternsSymbolTable(Scope globalScope, OWLOntologyManager ontologyManager) {
        super(globalScope, ontologyManager.getOWLDataFactory());
        this.ontologyManager = ontologyManager;
    }

    public void resolvePattern(OPPLSyntaxTree reference, String patternName,
            PatternConstraintSystem constraintSystem, List<Object>... args) {
        List<List<Object>> arguments = Arrays.asList(args);
        @SuppressWarnings("unchecked")
        Variable<?> resolvedPatternReference = getGlobalScope().resolvePatternReference(
                reference, patternName, constraintSystem, getErrorListener(),
                arguments.toArray(new List[arguments.size()]));
        if (resolvedPatternReference == null) {
            reportIllegalToken(reference, "The pattern reference is invalid");
        } else {
            VariableTypes type = VariableTypes.getVariableType(resolvedPatternReference
                    .getType());
            define(reference.token,
                    type.getSymbol(getDataFactory(), reference.token.getText()));
        }
    }

    public void resolvePattern(OPPLSyntaxTree reference, String patternName,
            PatternConstraintSystem constraintSystem,
            Collection<? extends String> visited, List<Object>... args) {
        List<List<Object>> arguments = Arrays.asList(args);
        @SuppressWarnings("unchecked")
        Variable<?> resolvedPatternReference = getGlobalScope().resolvePatternReference(
                reference, patternName, constraintSystem, visited, getErrorListener(),
                arguments.toArray(new List[arguments.size()]));
        if (resolvedPatternReference == null) {
            reportIllegalToken(reference, "The pattern reference is invalid");
        } else {
            VariableTypes type = VariableTypes.getVariableType(resolvedPatternReference
                    .getType());
            define(reference.token,
                    type.getSymbol(getDataFactory(), reference.token.getText()));
        }
    }

    @Override
    public OPPLPatternScope getGlobalScope() {
        return new OPPLPatternScope(super.getGlobalScope(), getOntologyManager());
    }

    /** @return the ontologyManager */
    public OWLOntologyManager getOntologyManager() {
        return ontologyManager;
    }

    public void resolveThisClass(OPPLSyntaxTree thisClass,
            PatternConstraintSystem constraintSystem) {
        Variable<?> thisClassVariable = constraintSystem.getThisClassVariable();
        VariableTypes type = VariableTypes.getVariableType(thisClassVariable.getType());
        define(thisClass.token,
                type.getSymbol(getDataFactory(), thisClass.token.getText()));
    }
}
