/**
 * Copyright (C) 2008, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.coode.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.coode.oppl.Variable;
import org.coode.oppl.VariableType;
import org.coode.oppl.VariableTypeVisitorEx;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.generated.AbstractGeneratedVariable;
import org.coode.oppl.generated.SingleValueGeneratedValue;
import org.coode.oppl.generated.SingleValueGeneratedValueVisitor;
import org.coode.oppl.generated.SingleValueGeneratedValueVisitorEx;
import org.coode.oppl.generated.SingleValueGeneratedVariable;
import org.coode.oppl.rendering.ManchesterSyntaxRenderer;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 * 
 *         Dec 10, 2008
 */
public class PatternReferenceGeneratedVariable extends AbstractGeneratedVariable<PatternReference> {
	public PatternReferenceGeneratedVariable(VariableType type,
			SingleValueGeneratedValue<PatternReference> value) {
		super(value.toString(), type, value);
	}

	/**
	 * @author Luigi Iannone
	 * 
	 *         Dec 10, 2008
	 */
	private static class PatternReferenceGeneratedValue implements
			SingleValueGeneratedValue<PatternReference> {
		private final PatternReference patternReference;

		public PatternReferenceGeneratedValue(PatternReference patternReference) {
			this.patternReference = patternReference;
		}

		/**
		 * @see org.coode.oppl.generated.SingleValueGeneratedValue#getGeneratedValue(org.coode.oppl.bindingtree.BindingNode)
		 */
		public PatternReference getGeneratedValue(BindingNode node) {
			List<List<String>> newArguments = new ArrayList<List<String>>(
					this.patternReference.getExtractedPattern().getInputVariables().size());
			PatternOPPLScript pattern = this.patternReference.getExtractedPattern();
			List<Variable> inputVariables = pattern.getInputVariables();
			PatternConstraintSystem constraintSystem = this.patternReference.getConstraintSystem();
			for (int i = 0; i < inputVariables.size(); i++) {
				Variable inputVariable = inputVariables.get(i);
				OWLObject assignmentValue = node.getAssignmentValue(inputVariable);
				if (assignmentValue != null) {
					ManchesterSyntaxRenderer renderer = this.patternReference.getConstraintSystem().getPatternModelFactory().getRenderer(
							constraintSystem);
					assignmentValue.accept(renderer);
					newArguments.add(Arrays.asList(renderer.toString()));
				} else {
					newArguments.add(Arrays.asList(inputVariable.getName()));
				}
			}
			try {
				return new PatternReference(this.patternReference.getPatternName(),
						constraintSystem, this.patternReference.getOntologyManger(),
						this.patternReference.getErrorListener(),
						newArguments.toArray(new List[inputVariables.size()]));
			} catch (PatternException e) {
				throw new RuntimeException(e);
			}
		}

		public List<PatternReference> computePossibleValues() {
			return new ArrayList<PatternReference>(Collections.singleton(this.patternReference));
		}

		public void accept(SingleValueGeneratedValueVisitor visitor) {
			visitor.visitSingleValueGeneratedValueVisitor(this);
		}

		public <O> O accept(SingleValueGeneratedValueVisitorEx<O> visitor) {
			return visitor.visitSingleValueGeneratedValueVisitor(this);
		}

		@Override
		public String toString() {
			String patternName = "?_" + this.patternReference.getPatternName();
			List<String>[] arguments = this.patternReference.getArguments();
			long hash = 1;
			for (List<String> list : arguments) {
				for (String string : list) {
					hash *= string.hashCode();
				}
			}
			return patternName + hash;
		}
	}

	@Override
	protected OWLObject generateObject(PatternReference reference) {
		try {
			return reference.getResolution().get(0);
		} catch (PatternException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected SingleValueGeneratedVariable<PatternReference> replace(
			SingleValueGeneratedValue<PatternReference> v) {
		return new PatternReferenceGeneratedVariable(this.getType(), v);
	}

	public static SingleValueGeneratedValue<PatternReference> getPatternReferenceGeneratedValue(
			PatternReference patternReference) {
		return new PatternReferenceGeneratedValue(patternReference);
	}

	public String getOPPLFunction() {
		return this.getValue().toString();
	}

	public <P> P accept(VariableTypeVisitorEx<P> visitor) {
		return visitor.visit(this);
	}

	public String getArgumentString() {
		return this.getOPPLFunction();
	}
}
