/**
 * 
 */
package org.coode.parsers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public class ManchesterOWLSyntaxTree extends CommonTree {
    private Type evalType = null;
    private OWLObject owlObject;
    private final List<String> completions = new ArrayList<String>();

    /** @param token */
    public ManchesterOWLSyntaxTree(Token token) {
        super(token);
    }

    /** @return the evalType */
    public Type getEvalType() {
        return evalType;
    }

    /** @param evalType
     *            the evalType to set */
    public void setEvalType(Type evalType) {
        this.evalType = evalType;
    }

    @Override
    public String toString() {
        return token.getText() + " type: "
                + (getEvalType() == null ? "(none)" : getEvalType().toString());
    }

    /** @return the owlObject */
    public OWLObject getOWLObject() {
        return owlObject;
    }

    /** @param owlObject
     *            the owlObject to set */
    public void setOWLObject(OWLObject owlObject) {
        this.owlObject = owlObject;
    }

    /** @param strings */
    public void setCompletions(Collection<? extends String> strings) {
        completions.clear();
        completions.addAll(strings);
    }

    /** @return the completions */
    public List<String> getCompletions() {
        return new ArrayList<String>(completions);
    }
}
