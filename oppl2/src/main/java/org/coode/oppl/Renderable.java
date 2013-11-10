package org.coode.oppl;


/** Functional interface for anything which can be rendered with a
 * ConstraintSystem */
public interface Renderable {
    String render(ConstraintSystem constraintSystem);
}
