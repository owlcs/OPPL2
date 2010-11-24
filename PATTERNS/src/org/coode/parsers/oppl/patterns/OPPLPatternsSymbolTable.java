/**
 * 
 */
package org.coode.parsers.oppl.patterns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.coode.oppl.Variable;
import org.coode.parsers.Scope;
import org.coode.parsers.oppl.OPPLSymbolTable;
import org.coode.parsers.oppl.OPPLSyntaxTree;
import org.coode.parsers.oppl.VariableType;
import org.coode.patterns.PatternConstraintSystem;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLPatternsSymbolTable extends OPPLSymbolTable {
	private final OWLOntologyManager ontologyManager;

	/**
	 * @param globalScope
	 * @param dataFactory
	 */
	public OPPLPatternsSymbolTable(Scope globalScope, OWLOntologyManager ontologyManager) {
		super(globalScope, ontologyManager.getOWLDataFactory());
		this.ontologyManager = ontologyManager;
	}

	public void resolvePattern(OPPLSyntaxTree reference, String patternName,
			PatternConstraintSystem constraintSystem, Object... args) {
		List<List<Object>> arguments = new ArrayList<List<Object>>(args.length);
		for (Object string : args) {
			List<Object> arg = new ArrayList<Object>(1);
			arg.add(string);
			arguments.add(arg);
		}
		@SuppressWarnings("unchecked")
		Variable<?> resolvedPatternReference = this.getGlobalScope().resolvePatternReference(
				reference,
				patternName,
				constraintSystem,
				this.getErrorListener(),
				arguments.toArray(new List[arguments.size()]));
		if (resolvedPatternReference == null) {
			this.reportIllegalToken(reference, "The pattern reference is invalid");
		} else {
			VariableType type = VariableType.getVariableType(resolvedPatternReference.getType());
			this.define(
					reference.token,
					type.getSymbol(this.getDataFactory(), reference.token.getText()));
		}
	}

	public void resolvePattern(OPPLSyntaxTree reference, String patternName,
			PatternConstraintSystem constraintSystem, Collection<? extends String> visited,
			OWLObject... args) {
		List<List<OWLObject>> arguments = new ArrayList<List<OWLObject>>(args.length);
		for (OWLObject string : args) {
			List<OWLObject> arg = new ArrayList<OWLObject>(1);
			arg.add(string);
			arguments.add(arg);
		}
		@SuppressWarnings("unchecked")
		Variable<?> resolvedPatternReference = this.getGlobalScope().resolvePatternReference(
				reference,
				patternName,
				constraintSystem,
				visited,
				this.getErrorListener(),
				arguments.toArray(new List[arguments.size()]));
		if (resolvedPatternReference == null) {
			this.reportIllegalToken(reference, "The pattern reference is invalid");
		} else {
			VariableType type = VariableType.getVariableType(resolvedPatternReference.getType());
			this.define(
					reference.token,
					type.getSymbol(this.getDataFactory(), reference.token.getText()));
		}
	}

	@Override
	public OPPLPatternScope getGlobalScope() {
		return new OPPLPatternScope(super.getGlobalScope(), this.getOntologyManager());
	}

	/**
	 * @return the ontologyManager
	 */
	public OWLOntologyManager getOntologyManager() {
		return this.ontologyManager;
	}

	public void resolveThisClass(OPPLSyntaxTree thisClass, PatternConstraintSystem constraintSystem) {
		Variable<?> thisClassVariable = constraintSystem.getThisClassVariable();
		VariableType type = VariableType.getVariableType(thisClassVariable.getType());
		this.define(
				thisClass.token,
				type.getSymbol(this.getDataFactory(), thisClass.token.getText()));
	}
}
