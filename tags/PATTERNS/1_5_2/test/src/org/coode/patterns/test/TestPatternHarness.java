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
package org.coode.patterns.test;

import java.util.List;

import org.coode.oppl.exceptions.QuickFailRuntimeExceptionHandler;
import org.coode.patterns.ClassPatternExecutor;
import org.coode.patterns.NonClassPatternExecutor;
import org.coode.patterns.PatternModelFactory;
import org.coode.patterns.PatternOPPLScript;
import org.coode.patterns.UnsuitableOPPLScriptException;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChangeException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 * @author Luigi Iannone
 * 
 *         Jun 12, 2008
 */
public class TestPatternHarness {
	private IRI iri = IRI.create("http://mytest.com/testpatternharness#test");
	private OWLOntologyManager manager;
	private OWLOntology ontology;
	private PatternModelFactory factory;

	protected TestPatternHarness(OWLOntology ontology, OWLOntologyManager manager) {
		this.manager = manager;
		this.ontology = ontology;
		this.factory = new PatternModelFactory(ontology, manager);
	}

	public void executeNonClass(PatternOPPLScript editor) throws UnsuitableOPPLScriptException {
		QuickFailRuntimeExceptionHandler handler = new QuickFailRuntimeExceptionHandler();
		NonClassPatternExecutor patternExecutor = new NonClassPatternExecutor(
				this.factory.createInstantiatedPatternModel(
						this.factory.createPatternModel(editor),
						handler), this.ontology, this.manager, this.iri, handler);
		List<OWLAxiomChange> changes = patternExecutor.visit(editor);
		for (OWLAxiomChange change : changes) {
			try {
				this.manager.applyChange(change);
			} catch (OWLOntologyChangeException e) {
				e.printStackTrace();
			}
		}
	}

	public void executeClass(OWLClass clazz, PatternOPPLScript editor)
			throws UnsuitableOPPLScriptException {
		QuickFailRuntimeExceptionHandler handler = new QuickFailRuntimeExceptionHandler();
		ClassPatternExecutor patternExecutor = new ClassPatternExecutor(clazz,
				this.factory.createInstantiatedPatternModel(
						this.factory.createPatternModel(editor),
						handler), this.ontology, this.manager, this.iri, handler);
		List<OWLAxiomChange> changes = patternExecutor.visit(editor);
		for (OWLAxiomChange change : changes) {
			try {
				this.manager.applyChange(change);
			} catch (OWLOntologyChangeException e) {
				e.printStackTrace();
			}
		}
	}
}
