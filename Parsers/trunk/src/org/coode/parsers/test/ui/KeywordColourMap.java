package org.coode.parsers.test.ui;

import java.awt.Color;
import java.util.HashMap;

/**
 * Author: drummond<br>
 * http://www.cs.man.ac.uk/~drummond/<br>
 * <br>
 * <p/>
 * The University Of Manchester<br>
 * Bio Health Informatics Group<br>
 * Date: Sep 23, 2008<br>
 * <br>
 */
public class KeywordColourMap extends HashMap<String, Color> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3232651475451866980L;

	public KeywordColourMap() {
		Color restrictionColor = new Color(178, 0, 178);
		Color logicalOpColor = new Color(0, 178, 178);
		Color axiomColor = new Color(10, 94, 168);
		Color queryColor = new Color(100, 15, 120);
		this.put("some", restrictionColor);
		this.put("only", restrictionColor);
		this.put("value", restrictionColor);
		this.put("exactly", restrictionColor);
		this.put("min", restrictionColor);
		this.put("max", restrictionColor);
		this.put("inv", logicalOpColor);
		this.put("and", logicalOpColor);
		this.put("that", logicalOpColor);
		this.put("or", logicalOpColor);
		this.put("not", logicalOpColor);
		this.put("subClassOf", axiomColor);
		this.put("SubClassOf", axiomColor);
		this.put("disjointWith", axiomColor);
		this.put("DisjointWith", axiomColor);
		this.put("equivalentTo", axiomColor);
		this.put("EquivalentTo", axiomColor);
		this.put("domain", axiomColor);
		this.put("range", axiomColor);
		this.put("instanceOf", axiomColor);
		this.put("types", axiomColor);
		this.put("InstanceOf", axiomColor);
		this.put("minus", queryColor);
		this.put("plus", queryColor);
		this.put("possibly", queryColor);
		this.put("inverseOf", axiomColor);
		this.put("DifferentIndividuals:", axiomColor);
		this.put("SameIndividuals:", axiomColor);
		this.put("Functional:", axiomColor);
		this.put("InverseFunctional:", axiomColor);
		this.put("Symmetric:", axiomColor);
		this.put("AntiSymmetric:", axiomColor);
		this.put("Reflexive:", axiomColor);
		this.put("Irreflexive:", axiomColor);
		this.put("Transitive:", axiomColor);
		this.put("subPropertyOf", axiomColor);
		this.put("disjointUnionOf", axiomColor);
		this.put("o", axiomColor);
		this.put("\u279E", axiomColor);
		this.put("\u2192", axiomColor);
		this.put("\u2227", axiomColor);
	}
}
