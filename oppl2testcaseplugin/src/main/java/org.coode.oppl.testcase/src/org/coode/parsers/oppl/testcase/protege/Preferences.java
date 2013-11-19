
package org.coode.parsers.oppl.testcase.protege;

import org.protege.editor.core.prefs.PreferencesManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLDataFactory;

/** @author Luigi Iannone */
public class Preferences {
    private static final String TEST_CASE_IRI_STRING_DEFAULT = "http://www.coode.org/oppl/testCase";
    private static final String TEST_CASE_IRI_STRING = "testCaseIRIString";

    /** @param dataFactory
     * @return annotation property for test */
    public static OWLAnnotationProperty getTestCaseAnnotationProperty(
            OWLDataFactory dataFactory) {
        PreferencesManager preferenceManager = PreferencesManager.getInstance();
        org.protege.editor.core.prefs.Preferences preferences = preferenceManager
                .getApplicationPreferences(Preferences.class);
        String iriString = preferences.getString(TEST_CASE_IRI_STRING,
                TEST_CASE_IRI_STRING_DEFAULT);
        return dataFactory.getOWLAnnotationProperty(IRI.create(iriString));
    }
}
