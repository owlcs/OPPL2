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
package org.coode.oppl.utils;

import org.coode.oppl.ConstraintSystem;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;

/** @author Luigi Iannone */
public class VariableDetector extends AbstractVariableDetector {
    /** @param constraintSystem */
    public VariableDetector(ConstraintSystem constraintSystem) {
        super(constraintSystem);
    }

    @Override
    public Boolean visit(OWLClass e) {
        return constraintSystem.isVariableIRI(e.getIRI());
    }

    @Override
    public Boolean visit(OWLLiteral e) {
        return constraintSystem.isVariable(e);
    }

    @Override
    public Boolean visit(OWLObjectProperty e) {
        return constraintSystem.isVariableIRI(e.getIRI());
    }

    @Override
    public Boolean visit(OWLDataProperty e) {
        return constraintSystem.isVariableIRI(e.getIRI());
    }

    @Override
    public Boolean visit(OWLNamedIndividual e) {
        return constraintSystem.isVariableIRI(e.getIRI());
    }

    @Override
    public Boolean visit(OWLAnnotationProperty e) {
        return constraintSystem.isVariableIRI(e.getIRI());
    }
}
