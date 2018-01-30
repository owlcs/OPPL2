package org.coode.oppl.utils;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.Collections;
import java.util.List;

import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 */
public class Position {

    /** empty position */
    public static final List<Integer> EMPTY_POSITION =
        Collections.singletonList(Integer.valueOf(-1));
    private static final OWLObjectDecomposer DECOMPOSER = new OWLObjectDecomposer();

    /**
     * @param owlObject owlObject
     * @param position position
     * @return found object, or null
     */
    public static Object get(OWLObject owlObject, List<Integer> position) {
        checkNotNull(owlObject, "owlObject");
        checkNotNull(position, "position");
        Object toReturn = owlObject;
        if (!position.isEmpty()) {
            Integer index = position.get(0);
            List<Object> parts = owlObject.accept(DECOMPOSER);
            if (index.intValue() >= 1 && index.intValue() <= parts.size()) {
                toReturn = parts.get(index.intValue() - 1);
                if (position.size() > 1) {
                    if (toReturn instanceof OWLObject) {
                        List<Integer> newPosition = position.subList(1, parts.size());
                        toReturn = get((OWLObject) toReturn, newPosition);
                    } else {
                        toReturn = null;
                    }
                }
            } else if (index.intValue() != 0) {
                toReturn = null;
            }
        }
        return toReturn;
    }
}
