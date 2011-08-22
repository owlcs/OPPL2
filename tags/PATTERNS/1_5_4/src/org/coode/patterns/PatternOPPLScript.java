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

import java.util.Collection;
import java.util.Set;

import org.coode.oppl.OPPLScript;
import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.exceptions.RuntimeExceptionHandler;
import org.coode.parsers.ErrorListener;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * Interface that abstracts the commonalities between different parsed Pattenr
 * related entities: namely PatternModel instances and InstantiatedPatternModel
 * ones
 * 
 * @author Luigi Iannone
 * 
 *         Sep 25, 2008
 */
public interface PatternOPPLScript extends OPPLScript {
	/**
	 * @return the name for this PatternOPPLScript
	 */
	public String getName();

	/**
	 * Adds a dependency from this Script to towards the input one
	 * 
	 * @param script
	 */
	void addDependency(PatternOPPLScript script);

	/**
	 * @return true if this PatternOPPLScript depends on the input one, false
	 *         otherwise
	 */
	boolean dependsOn(PatternOPPLScript aPatternOPPLScript);

	/**
	 * @return the pattern URI
	 */
	IRI getIRI();

	/**
	 * Sets the pattern URI
	 * 
	 * @param anURI
	 */
	void setIRI(IRI anURI);

	/**
	 * @return true if this pattern script can be applied to an OWLClass
	 */
	boolean isClassPattern();

	public OWLObject getDefinitorialPortion(Collection<? extends BindingNode> bindingNodes,
			RuntimeExceptionHandler runtimeExceptionHandler) throws PatternException;

	String getRendering();

	/**
	 * @return true is any of the variables used in this PatternOPPLScript is
	 *         scoped, false otherwise
	 */
	boolean hasScopedVariables();

	/**
	 * 
	 * 
	 * @param ontology
	 * 
	 * @return the Set containing the OWLObject elements generated by the
	 *         serialisation of this OPPScript
	 * 
	 * 
	 */
	public Set<OWLObject> getOWLObjects(OWLOntology ontology, ErrorListener errorListener);
}