package org.coode.parsers.oppl.testcase.protege;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.List;

import org.coode.oppl.OPPLAbstractFactory;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.protege.ProtegeOPPLFactory;
import org.coode.parsers.oppl.testcase.AbstractOPPLTestCaseFactory;
import org.coode.parsers.oppl.testcase.OPPLTest;
import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.OPPLTestCaseImpl;
import org.protege.editor.owl.OWLEditorKit;

/**
 * @author Luigi Iannone
 */
public class ProtegeOPPLTestCaseFactory implements AbstractOPPLTestCaseFactory {

    private final OWLEditorKit owlEditorKit;

    /**
     * @param owlEditorKit
     *        owlEditorKit
     */
    public ProtegeOPPLTestCaseFactory(OWLEditorKit owlEditorKit) {
        this.owlEditorKit = checkNotNull(owlEditorKit, "owlEditorKit");
    }

    @Override
    public OPPLTestCase buildOPPLTestCase(String name, OPPLScript opplContent,
        List<? extends OPPLTest> tests, boolean requiresInference) {
        return new OPPLTestCaseImpl(name, opplContent, tests, requiresInference);
    }

    @Override
    public OPPLAbstractFactory getOPPLFactory() {
        return new ProtegeOPPLFactory(getOWLEditorKit());
    }

    /**
     * @return the owlEditorKit
     */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }
}
