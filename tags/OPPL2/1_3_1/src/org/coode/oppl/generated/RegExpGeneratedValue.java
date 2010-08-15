package org.coode.oppl.generated;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.coode.oppl.bindingtree.BindingNode;
import org.coode.oppl.entity.OWLEntityRenderer;
import org.coode.oppl.utils.DefaultOWLObjectVisitorEx;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLTypedConstant;
import org.semanticweb.owl.model.OWLUntypedConstant;

public abstract class RegExpGeneratedValue<O extends OWLObject> extends
		DefaultOWLObjectVisitorEx<List<String>> implements SingleValueGeneratedValue<List<O>> {
	private final OWLEntityRenderer renderer;
	private final SingleValueGeneratedValue<String> expression;
	private final List<O> candidates = new ArrayList<O>();
	private final Map<O, List<String>> matches = new HashMap<O, List<String>>();
	private boolean matched = false;

	private RegExpGeneratedValue(Collection<? extends O> candidates,
			SingleValueGeneratedValue<String> exp, OWLEntityRenderer r) {
		this.candidates.addAll(candidates);
		this.expression = exp;
		this.renderer = r;
	}

	public List<List<O>> computePossibleValues() {
		return new ArrayList<List<O>>(Collections.singleton(this.candidates));
	}

	public List<O> getGeneratedValue(BindingNode node) {
		String exp = this.expression.getGeneratedValue(node);
		return this.getMatches(exp);
	}

	private List<O> getMatches(String exp) {
		this.matched = true;
		if (exp != null) {
			Pattern regExpression = Pattern.compile(exp);
			List<O> toReturn = new ArrayList<O>();
			for (O e : this.candidates) {
				String toMatch = this.render(e);
				List<String> group = actualMatch(regExpression, toMatch);
				if (group.size() > 0) {
					this.matches.put(e, group);
					toReturn.add(e);
				}
			}
			return toReturn;
		}
		return Collections.emptyList();
	}

	private String render(O owlObject) {
		DefaultOWLObjectVisitorEx<String> myRenderer = new DefaultOWLObjectVisitorEx<String>() {
			@Override
			protected String doDefault(OWLObject object) {
				return object.toString();
			}

			@Override
			public String visit(OWLClass desc) {
				return RegExpGeneratedValue.this.renderer.render(desc);
			}

			@Override
			public String visit(OWLObjectProperty property) {
				return RegExpGeneratedValue.this.renderer.render(property);
			}

			@Override
			public String visit(OWLDataProperty property) {
				return RegExpGeneratedValue.this.renderer.render(property);
			}

			@Override
			public String visit(OWLIndividual individual) {
				return RegExpGeneratedValue.this.renderer.render(individual);
			}
		};
		return owlObject.accept(myRenderer);
	}

	public static List<String> actualMatch(Pattern regExpression, String toMatch) {
		List<String> group = new ArrayList<String>();
		try {
			Matcher m = regExpression.matcher(toMatch);
			if (m.lookingAt()) {
				MatchResult mr = m.toMatchResult();
				for (int i = 0; i <= mr.groupCount(); i++) {
					group.add(mr.group(i));
				}
			}
		} catch (IllegalStateException e) {
			// XXX needs logging or something
			// System.out.println("RegExpGeneratedValue.actualMatch() Matching \""
			// + regExpression + "\" to \"" + toMatch
			// + "\": no match found");
		}
		return group;
	}

	private List<String> retrieve(OWLObject e) {
		if (!this.matched) {
			new RuntimeException(
					"Error: matches have not been made yet. Call getGeneratedValue(BindingNode) first. Empty list returned.").printStackTrace();
		}
		if (this.matches.containsKey(e)) {
			return this.matches.get(e);
		}
		return Collections.emptyList();
	}

	// Overriding of
	// org.coode.oppl.utils.DefaultOWLObjectVisitorEx<List<String>>
	@Override
	protected List<String> doDefault(OWLObject object) {
		return Collections.emptyList();
	}

	@Override
	public List<String> visit(OWLClass cls) {
		return this.retrieve(cls);
	}

	@Override
	public List<String> visit(OWLObjectProperty property) {
		return this.retrieve(property);
	}

	@Override
	public List<String> visit(OWLDataProperty property) {
		return this.retrieve(property);
	}

	@Override
	public List<String> visit(OWLIndividual individual) {
		return this.retrieve(individual);
	}

	@Override
	public List<String> visit(OWLTypedConstant node) {
		return this.retrieve(node);
	}

	@Override
	public List<String> visit(OWLUntypedConstant node) {
		return this.retrieve(node);
	}

	// End of Overriding of
	// org.coode.oppl.utils.DefaultOWLObjectVisitorEx<List<String>>
	@Override
	public String toString() {
		return this.expression.toString();
	}

	public boolean isMatched() {
		return this.matched;
	}

	public void accept(SingleValueGeneratedValueVisitor visitor) {
		visitor.visitRegExpGeneratedValue(this);
	}

	public <P> P accept(SingleValueGeneratedValueVisitorEx<P> visitor) {
		return visitor.visitStringGeneratedValue(this);
	}

	/**
	 * @return the expression
	 */
	public SingleValueGeneratedValue<String> getExpression() {
		return this.expression;
	}

	public abstract RegExpGenerated<O> getGeneratedVariable(String name);

	public static RegExpGeneratedValue<OWLClass> getOWLClassExpGeneratedValue(
			Collection<? extends OWLClass> candidates, SingleValueGeneratedValue<String> exp,
			OWLEntityRenderer r) {
		return new RegExpGeneratedValue<OWLClass>(candidates, exp, r) {
			@Override
			public RegExpGenerated<OWLClass> getGeneratedVariable(String name) {
				return new RegExpCLASSVariable(name, this);
			}
		};
	}

	public static RegExpGeneratedValue<OWLObjectProperty> getOWLObjectPropertyExpGeneratedValue(
			Collection<? extends OWLObjectProperty> candidates,
			SingleValueGeneratedValue<String> exp, OWLEntityRenderer r) {
		return new RegExpGeneratedValue<OWLObjectProperty>(candidates, exp, r) {
			@Override
			public RegExpGenerated<OWLObjectProperty> getGeneratedVariable(String name) {
				return new RegExpOBJECTPROPERTYVariable(name, this);
			}
		};
	}

	public static RegExpGeneratedValue<OWLDataProperty> getOWLDataPropertyExpGeneratedValue(
			Collection<? extends OWLDataProperty> candidates,
			SingleValueGeneratedValue<String> exp, OWLEntityRenderer r) {
		return new RegExpGeneratedValue<OWLDataProperty>(candidates, exp, r) {
			@Override
			public RegExpGenerated<OWLDataProperty> getGeneratedVariable(String name) {
				return new RegExpDATAPROPERTYVariable(name, this);
			}
		};
	}

	public static RegExpGeneratedValue<OWLIndividual> getOWLIndividualExpGeneratedValue(
			Collection<? extends OWLIndividual> candidates, SingleValueGeneratedValue<String> exp,
			OWLEntityRenderer r) {
		return new RegExpGeneratedValue<OWLIndividual>(candidates, exp, r) {
			@Override
			public RegExpGenerated<OWLIndividual> getGeneratedVariable(String name) {
				return new RegExpINDIVIDUALVariable(name, this);
			}
		};
	}

	public static RegExpGeneratedValue<OWLConstant> getOWLConstantExpGeneratedValue(
			Collection<? extends OWLConstant> candidates, SingleValueGeneratedValue<String> exp,
			OWLEntityRenderer r) {
		return new RegExpGeneratedValue<OWLConstant>(candidates, exp, r) {
			@Override
			public RegExpGenerated<OWLConstant> getGeneratedVariable(String name) {
				return new RegExpCONSTANTVariable(name, this);
			}
		};
	}
}
