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
package org.coode.oppl.protege;

import java.net.URI;
import java.net.URISyntaxException;

import org.protege.editor.owl.model.OWLModelManager;
import org.semanticweb.owl.expression.OWLEntityChecker;
import org.semanticweb.owl.expression.ShortFormEntityChecker;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.util.BidirectionalShortFormProviderAdapter;
import org.semanticweb.owl.util.NamespaceUtil;
import org.semanticweb.owl.util.SimpleShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 *         The University Of Manchester<br>
 *         Bio-Health Informatics Group<br>
 *         Aug 12, 2008
 */
public class RenderingOWLEntityCheckerNoModelManager implements
		OWLEntityChecker {
	protected OWLModelManager owlModelManager = null;
	protected ShortFormEntityChecker shortFormEntityChecker = null;

	/**
	 * @param owlModelManager
	 */
	public RenderingOWLEntityCheckerNoModelManager(
			OWLModelManager owlModelManager) {
		this.owlModelManager = owlModelManager;
		this.shortFormEntityChecker = new ShortFormEntityChecker(
				new BidirectionalShortFormProviderAdapter(owlModelManager
						.getActiveOntologies(), new SimpleShortFormProvider()));
	}

	/**
	 * @see org.semanticweb.owl.expression.OWLEntityChecker#getOWLClass(java.lang.String)
	 */
	public OWLClass getOWLClass(String name) {
		OWLClass toReturn = this.owlModelManager.getOWLClass(name);
		if (toReturn == null) {
			toReturn = this.shortFormEntityChecker.getOWLClass(name);
		}
		if (name.length() > 0 && toReturn == null) {
			try {
				new URI(name);
				NamespaceUtil nsUtil = new NamespaceUtil();
				String[] split = nsUtil.split(name, null);
				if (split.length == 2) {
					toReturn = this.shortFormEntityChecker
							.getOWLClass(split[1]);
				}
			} catch (URISyntaxException e) {
				toReturn = null;
			}
		}
		return toReturn;
	}

	/**
	 * @see org.semanticweb.owl.expression.OWLEntityChecker#getOWLDataProperty(java.lang.String)
	 */
	public OWLDataProperty getOWLDataProperty(String name) {
		OWLDataProperty toReturn = this.owlModelManager
				.getOWLDataProperty(name);
		if (toReturn == null) {
			toReturn = this.shortFormEntityChecker.getOWLDataProperty(name);
		}
		if (name.length() > 0 && toReturn == null) {
			try {
				new URI(name);
				NamespaceUtil nsUtil = new NamespaceUtil();
				String[] split = nsUtil.split(name, null);
				if (split.length == 2) {
					toReturn = this.shortFormEntityChecker
							.getOWLDataProperty(split[1]);
				}
			} catch (URISyntaxException e) {
				toReturn = null;
			}
		}
		return toReturn;
	}

	/**
	 * @see org.semanticweb.owl.expression.OWLEntityChecker#getOWLDataType(java.lang.String)
	 */
	public OWLDataType getOWLDataType(String name) {
		return this.shortFormEntityChecker.getOWLDataType(name);
	}

	/**
	 * @see org.semanticweb.owl.expression.OWLEntityChecker#getOWLIndividual(java.lang.String)
	 */
	public OWLIndividual getOWLIndividual(String name) {
		OWLIndividual toReturn = this.owlModelManager.getOWLIndividual(name);
		if (toReturn == null) {
			toReturn = this.shortFormEntityChecker.getOWLIndividual(name);
		}
		if (name.length() > 0 && toReturn == null) {
			try {
				new URI(name);
				NamespaceUtil nsUtil = new NamespaceUtil();
				String[] split = nsUtil.split(name, null);
				if (split.length == 2) {
					toReturn = this.shortFormEntityChecker
							.getOWLIndividual(split[1]);
				}
			} catch (URISyntaxException e) {
				toReturn = null;
			}
		}
		return toReturn;
	}

	/**
	 * @see org.semanticweb.owl.expression.OWLEntityChecker#getOWLObjectProperty(java.lang.String)
	 */
	public OWLObjectProperty getOWLObjectProperty(String name) {
		OWLObjectProperty toReturn = this.owlModelManager
				.getOWLObjectProperty(name);
		if (toReturn == null) {
			toReturn = this.shortFormEntityChecker.getOWLObjectProperty(name);
		}
		if (name.length() > 0 && toReturn == null) {
			try {
				new URI(name);
				NamespaceUtil nsUtil = new NamespaceUtil();
				String[] split = nsUtil.split(name, null);
				if (split.length == 2) {
					toReturn = this.shortFormEntityChecker
							.getOWLObjectProperty(split[1]);
				}
			} catch (URISyntaxException e) {
				toReturn = null;
			}
		}
		return toReturn;
	}
}
