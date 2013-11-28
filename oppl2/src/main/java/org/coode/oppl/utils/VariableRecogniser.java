package org.coode.oppl.utils;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import org.coode.oppl.Variable;
import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.variabletypes.InputVariable;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public class VariableRecogniser {
    /** input recognizer */
    public static VariableRecogniser INPUT_VARIABLE_RECOGNISER = new VariableRecogniser(
            new AbstractVariableVisitorExAdapter<Boolean>(false) {
                @Override
                public <P extends OWLObject> Boolean visit(InputVariable<P> v) {
                    return true;
                }
            });
    /** generated recognizer */
    public static VariableRecogniser GENERATED_VARIABLE_RECOGNISER = new VariableRecogniser(
            new AbstractVariableVisitorExAdapter<Boolean>(false) {
                @Override
                public <P extends OWLObject> Boolean visit(GeneratedVariable<P> v) {
                    return true;
                }
            });
    /** regexp recognizer */
    public static VariableRecogniser REGEXP_VARIABLE_RECOGNISER = new VariableRecogniser(
            new AbstractVariableVisitorExAdapter<Boolean>(false) {
                @Override
                public <P extends OWLObject> Boolean visit(
                        RegexpGeneratedVariable<P> regExpGenerated) {
                    return true;
                }
            });
    private final VariableVisitorEx<Boolean> recogniser;

    /** @return the recogniser */
    public VariableVisitorEx<Boolean> getRecogniser() {
        return recogniser;
    }

    /** @param recogniser */
    VariableRecogniser(VariableVisitorEx<Boolean> recogniser) {
        this.recogniser = checkNotNull(recogniser, "recogniser");
    }

    /** @param v
     * @return true if recognised */
    public boolean recognise(Variable<?> v) {
        return v.accept(getRecogniser());
    }
}
