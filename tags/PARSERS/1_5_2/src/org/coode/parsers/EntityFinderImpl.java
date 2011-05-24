package org.coode.parsers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Medical Informatics Group<br>
 * Date: 16-May-2006<br>
 * <br>
 * <p/>
 * matthew.horridge@cs.man.ac.uk<br>
 * www.cs.man.ac.uk/~horridgm<br>
 * <br>
 */
public class EntityFinderImpl implements EntityFinder {
	private OWLEntityRenderingCache renderingCache;
	private final OWLOntologyManager manager;
	private final boolean useRegularExpressions;
	private static final String WILDCARD = "*";

	public EntityFinderImpl(OWLOntologyManager mngr, OWLEntityRenderingCache renderingCache,
			boolean useRegularExpressions) {
		if (mngr == null) {
			throw new NullPointerException("The manager cannot be null");
		}
		if (renderingCache == null) {
			throw new NullPointerException("The rendering cache cannot be null");
		}
		this.manager = mngr;
		this.renderingCache = renderingCache;
		this.useRegularExpressions = useRegularExpressions;
	}

	public Set<OWLClass> getMatchingOWLClasses(String match) {
		return this.getEntities(match, OWLClass.class, this.useRegularExpressions);
	}

	public Set<OWLClass> getMatchingOWLClasses(String match, boolean fullRegExp) {
		return this.getEntities(match, OWLClass.class, fullRegExp);
	}

	public Set<OWLObjectProperty> getMatchingOWLObjectProperties(String match) {
		return this.getEntities(match, OWLObjectProperty.class, this.useRegularExpressions);
	}

	public Set<OWLObjectProperty> getMatchingOWLObjectProperties(String match, boolean fullRegExp) {
		return this.getEntities(match, OWLObjectProperty.class, fullRegExp);
	}

	public Set<OWLDataProperty> getMatchingOWLDataProperties(String match) {
		return this.getEntities(match, OWLDataProperty.class, this.useRegularExpressions);
	}

	public Set<OWLDataProperty> getMatchingOWLDataProperties(String match, boolean fullRegExp) {
		return this.getEntities(match, OWLDataProperty.class, fullRegExp);
	}

	public Set<OWLNamedIndividual> getMatchingOWLIndividuals(String match) {
		return this.getEntities(match, OWLNamedIndividual.class, this.useRegularExpressions);
	}

	public Set<OWLNamedIndividual> getMatchingOWLIndividuals(String match, boolean fullRegExp) {
		return this.getEntities(match, OWLNamedIndividual.class, fullRegExp);
	}

	public Set<OWLDatatype> getMatchingOWLDataTypes(String match) {
		return this.getEntities(match, OWLDatatype.class, this.useRegularExpressions);
	}

	public Set<OWLDatatype> getMatchingOWLDataTypes(String match, boolean fullRegExp) {
		return this.getEntities(match, OWLDatatype.class, fullRegExp);
	}

	public Set<OWLEntity> getEntities(String match) {
		return this.getEntities(match, OWLEntity.class, this.useRegularExpressions);
	}

	public Set<OWLEntity> getEntities(String match, boolean fullRegExp) {
		return this.getEntities(match, OWLEntity.class, fullRegExp);
	}

	private <T extends OWLEntity> Set<T> getEntities(String match, Class<T> type, boolean fullRegExp) {
		if (match.length() == 0) {
			return Collections.emptySet();
		}
		if (fullRegExp) {
			return this.doRegExpSearch(match, type);
		} else {
			return this.doWildcardSearch(match, type);
		}
	}

	private <T extends OWLEntity> Set<T> doRegExpSearch(String match, Class<T> type) {
		Set<T> results = new HashSet<T>();
		try {
			Pattern pattern = Pattern.compile(match);
			for (String rendering : this.getRenderings(type)) {
				Matcher m = pattern.matcher(rendering);
				if (m.find()) {
					T ent = this.getEntity(rendering, type);
					if (ent != null) {
						results.add(ent);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	/*
	 * @@TODO fix wildcard searching - it does not handle the usecases correctly
	 * eg A*B will not work, and endsWith is implemented the same as contains
	 * (probably right but this should not be implemented separately)
	 */
	private <T extends OWLEntity> Set<T> doWildcardSearch(String match, Class<T> type) {
		Set<T> results = new HashSet<T>();
		if (match.equals(WILDCARD)) {
			results = this.getAllEntities(type);
		} else {
			SimpleWildCardMatcher matcher;
			if (match.startsWith(WILDCARD)) {
				if (match.length() > 1 && match.endsWith(WILDCARD)) {
					// Contains
					matcher = new SimpleWildCardMatcher() {
						public boolean matches(String rendering, String s) {
							return rendering.indexOf(s) != -1;
						}
					};
					match = match.substring(1, match.length() - 1);
				} else {
					// Ends with
					matcher = new SimpleWildCardMatcher() {
						public boolean matches(String rendering, String s) {
							return rendering.indexOf(s) != -1;
						}
					};
					match = match.substring(1, match.length());
				}
			} else {
				// Starts with
				if (match.endsWith(WILDCARD) && match.length() > 1) {
					match = match.substring(0, match.length() - 1);
				}
				// @@TODO handle matches exactly?
				matcher = new SimpleWildCardMatcher() {
					public boolean matches(String rendering, String s) {
						return rendering.startsWith(s) || rendering.startsWith("'" + s);
					}
				};
			}
			if (match.trim().length() != 0) {
				match = match.toLowerCase();
				for (String rendering : this.getRenderings(type)) {
					if (rendering.length() > 0) {
						if (matcher.matches(rendering.toLowerCase(), match)) {
							results.add(this.getEntity(rendering, type));
						}
					}
				}
			}
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	private <T extends OWLEntity> Set<T> getAllEntities(Class<T> type) {
		Set<T> entities = new HashSet<T>();
		for (OWLOntology ont : this.manager.getOntologies()) {
			if (type.equals(OWLClass.class)) {
				entities.addAll((Set<T>) ont.getClassesInSignature());
			} else if (type.equals(OWLObjectProperty.class)) {
				entities.addAll((Set<T>) ont.getObjectPropertiesInSignature());
			} else if (type.equals(OWLDataProperty.class)) {
				entities.addAll((Set<T>) ont.getDataPropertiesInSignature());
			} else if (type.equals(OWLIndividual.class)) {
				entities.addAll((Set<T>) ont.getIndividualsInSignature());
			} else if (type.equals(OWLDatatype.class)) {
				entities.addAll((Set<T>) ont.getDatatypesInSignature());
			}
		}
		return entities;
	}

	@SuppressWarnings("unchecked")
	private <T extends OWLEntity> T getEntity(String rendering, Class<T> type) {
		if (type.equals(OWLClass.class)) {
			return (T) this.renderingCache.getOWLClass(rendering);
		} else if (type.equals(OWLObjectProperty.class)) {
			return (T) this.renderingCache.getOWLObjectProperty(rendering);
		} else if (type.equals(OWLDataProperty.class)) {
			return (T) this.renderingCache.getOWLDataProperty(rendering);
		} else if (type.equals(OWLIndividual.class)) {
			return (T) this.renderingCache.getOWLIndividual(rendering);
		} else if (type.equals(OWLDatatype.class)) {
			return (T) this.renderingCache.getOWLDataType(rendering);
		} else {
			return (T) this.renderingCache.getOWLEntity(rendering);
		}
	}

	private <T extends OWLEntity> Set<String> getRenderings(Class<T> type) {
		if (type.equals(OWLClass.class)) {
			return this.renderingCache.getOWLClassRenderings();
		} else if (type.equals(OWLObjectProperty.class)) {
			return this.renderingCache.getOWLObjectPropertyRenderings();
		} else if (type.equals(OWLDataProperty.class)) {
			return this.renderingCache.getOWLDataPropertyRenderings();
		} else if (type.equals(OWLIndividual.class)) {
			return this.renderingCache.getOWLIndividualRenderings();
		} else if (type.equals(OWLDatatype.class)) {
			return this.renderingCache.getOWLDatatypeRenderings();
		} else {
			return this.renderingCache.getOWLEntityRenderings();
		}
	}

	private interface SimpleWildCardMatcher {
		boolean matches(String rendering, String s);
	}
}
