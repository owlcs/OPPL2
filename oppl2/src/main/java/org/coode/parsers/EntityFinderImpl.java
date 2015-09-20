package org.coode.parsers;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.semanticweb.owlapi.model.*;

/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Medical Informatics Group<br>
 * Date: 16-May-2006<br>
 * <br>
 * <br>
 * matthew.horridge@cs.man.ac.uk<br>
 * www.cs.man.ac.uk/~horridgm<br>
 * <br>
 */
public class EntityFinderImpl implements EntityFinder {

    private final OWLEntityRenderingCache renderingCache;
    private final OWLOntologyManager manager;
    private final boolean useRegularExpressions;
    private static final String WILDCARD = "*";

    /**
     * @param mngr
     *        mngr
     * @param renderingCache
     *        renderingCache
     * @param useRegularExpressions
     *        useRegularExpressions
     */
    public EntityFinderImpl(OWLOntologyManager mngr,
        OWLEntityRenderingCache renderingCache, boolean useRegularExpressions) {
        this.renderingCache = checkNotNull(renderingCache, "renderingCache");
        manager = checkNotNull(mngr, "mngr");
        this.useRegularExpressions = useRegularExpressions;
    }

    @Override
    public Set<OWLClass> getMatchingOWLClasses(String match) {
        return this.getEntities(match, OWLClass.class, useRegularExpressions);
    }

    @Override
    public Set<OWLClass> getMatchingOWLClasses(String match, boolean fullRegExp) {
        return this.getEntities(match, OWLClass.class, fullRegExp);
    }

    @Override
    public Set<OWLObjectProperty> getMatchingOWLObjectProperties(String match) {
        return this.getEntities(match, OWLObjectProperty.class, useRegularExpressions);
    }

    @Override
    public Set<OWLObjectProperty> getMatchingOWLObjectProperties(String match,
        boolean fullRegExp) {
        return this.getEntities(match, OWLObjectProperty.class, fullRegExp);
    }

    @Override
    public Set<OWLDataProperty> getMatchingOWLDataProperties(String match) {
        return this.getEntities(match, OWLDataProperty.class, useRegularExpressions);
    }

    @Override
    public Set<OWLDataProperty> getMatchingOWLDataProperties(String match,
        boolean fullRegExp) {
        return this.getEntities(match, OWLDataProperty.class, fullRegExp);
    }

    @Override
    public Set<OWLNamedIndividual> getMatchingOWLIndividuals(String match) {
        return this.getEntities(match, OWLNamedIndividual.class, useRegularExpressions);
    }

    @Override
    public Set<OWLNamedIndividual> getMatchingOWLIndividuals(String match,
        boolean fullRegExp) {
        return this.getEntities(match, OWLNamedIndividual.class, fullRegExp);
    }

    @Override
    public Set<OWLDatatype> getMatchingOWLDataTypes(String match) {
        return this.getEntities(match, OWLDatatype.class, useRegularExpressions);
    }

    @Override
    public Set<OWLDatatype> getMatchingOWLDataTypes(String match, boolean fullRegExp) {
        return this.getEntities(match, OWLDatatype.class, fullRegExp);
    }

    @Override
    public Set<OWLEntity> getEntities(String match) {
        return this.getEntities(match, OWLEntity.class, useRegularExpressions);
    }

    @Override
    public Set<OWLEntity> getEntities(String match, boolean fullRegExp) {
        return this.getEntities(match, OWLEntity.class, fullRegExp);
    }

    private <T extends OWLEntity> Set<T> getEntities(String match, Class<T> type,
        boolean fullRegExp) {
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
        Set<T> results = new HashSet<>();
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
    private <T extends OWLEntity> Set<T> doWildcardSearch(String _match, Class<T> type) {
        String match = _match;
        Set<T> results = new HashSet<>();
        if (match.equals(WILDCARD)) {
            results = this.getAllEntities(type);
        } else {
            SimpleWildCardMatcher matcher;
            if (match.startsWith(WILDCARD)) {
                if (match.length() > 1 && match.endsWith(WILDCARD)) {
                    // Contains
                    matcher = new SimpleWildCardMatcher() {

                        @Override
                        public boolean matches(String rendering, String s) {
                            return rendering.indexOf(s) != -1;
                        }
                    };
                    match = match.substring(1, match.length() - 1);
                } else {
                    // Ends with
                    matcher = new SimpleWildCardMatcher() {

                        @Override
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

                    @Override
                    public boolean matches(String rendering, String s) {
                        return rendering.startsWith(s) || rendering.startsWith("'" + s);
                    }
                };
            }
            if (match.trim().length() != 0) {
                match = match.toLowerCase();
                for (String rendering : this.getRenderings(type)) {
                    if (rendering.length() > 0
                        && matcher.matches(rendering.toLowerCase(), match)) {
                        results.add(this.getEntity(rendering, type));
                    }
                }
            }
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    private <T extends OWLEntity> Set<T> getAllEntities(Class<T> type) {
        Set<T> entities = new HashSet<>();
        for (OWLOntology ont : manager.getOntologies()) {
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
            return (T) renderingCache.getOWLClass(rendering);
        } else if (type.equals(OWLObjectProperty.class)) {
            return (T) renderingCache.getOWLObjectProperty(rendering);
        } else if (type.equals(OWLDataProperty.class)) {
            return (T) renderingCache.getOWLDataProperty(rendering);
        } else if (type.equals(OWLIndividual.class)) {
            return (T) renderingCache.getOWLIndividual(rendering);
        } else if (type.equals(OWLDatatype.class)) {
            return (T) renderingCache.getOWLDataType(rendering);
        } else {
            return (T) renderingCache.getOWLEntity(rendering);
        }
    }

    private <T extends OWLEntity> Set<String> getRenderings(Class<T> type) {
        if (type.equals(OWLClass.class)) {
            return renderingCache.getOWLClassRenderings();
        } else if (type.equals(OWLObjectProperty.class)) {
            return renderingCache.getOWLObjectPropertyRenderings();
        } else if (type.equals(OWLDataProperty.class)) {
            return renderingCache.getOWLDataPropertyRenderings();
        } else if (type.equals(OWLIndividual.class)) {
            return renderingCache.getOWLIndividualRenderings();
        } else if (type.equals(OWLDatatype.class)) {
            return renderingCache.getOWLDatatypeRenderings();
        } else {
            return renderingCache.getOWLEntityRenderings();
        }
    }

    private interface SimpleWildCardMatcher {

        boolean matches(String rendering, String s);
    }
}
