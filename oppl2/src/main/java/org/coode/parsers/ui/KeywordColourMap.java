package org.coode.parsers.ui;

import java.awt.Color;
import java.util.HashMap;

/** Author: drummond<br>
 * http://www.cs.man.ac.uk/~drummond/<br>
 * <br>
 * <p/>
 * The University Of Manchester<br>
 * Bio Health Informatics Group<br>
 * Date: Sep 23, 2008<br>
 * <br> */
public class KeywordColourMap extends HashMap<String, Color> {
    
    private static final long serialVersionUID = 3232651475451866980L;

    public KeywordColourMap() {
        Color restrictionColor = new Color(178, 0, 178);
        Color logicalOpColor = new Color(0, 178, 178);
        Color axiomColor = new Color(10, 94, 168);
        Color queryColor = new Color(100, 15, 120);
        put("some", restrictionColor);
        put("only", restrictionColor);
        put("value", restrictionColor);
        put("exactly", restrictionColor);
        put("min", restrictionColor);
        put("max", restrictionColor);
        put("inv", logicalOpColor);
        put("and", logicalOpColor);
        put("that", logicalOpColor);
        put("or", logicalOpColor);
        put("not", logicalOpColor);
        put("subClassOf", axiomColor);
        put("SubClassOf", axiomColor);
        put("disjointWith", axiomColor);
        put("DisjointWith", axiomColor);
        put("equivalentTo", axiomColor);
        put("EquivalentTo", axiomColor);
        put("domain", axiomColor);
        put("range", axiomColor);
        put("instanceOf", axiomColor);
        put("types", axiomColor);
        put("InstanceOf", axiomColor);
        put("minus", queryColor);
        put("plus", queryColor);
        put("possibly", queryColor);
        put("inverseOf", axiomColor);
        put("DifferentIndividuals:", axiomColor);
        put("SameIndividuals:", axiomColor);
        put("Functional:", axiomColor);
        put("InverseFunctional:", axiomColor);
        put("Symmetric:", axiomColor);
        put("AntiSymmetric:", axiomColor);
        put("Reflexive:", axiomColor);
        put("Irreflexive:", axiomColor);
        put("Transitive:", axiomColor);
        put("subPropertyOf", axiomColor);
        put("disjointUnionOf", axiomColor);
        put("o", axiomColor);
        put("\u279E", axiomColor);
        put("\u2192", axiomColor);
        put("\u2227", axiomColor);
    }
}
