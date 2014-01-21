package org.coode.oppl.utils;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.semanticweb.owlapi.model.OWLObject;

/** @author Luigi Iannone */
public class OWLObjectFinder {
    /** @param key
     *            key
     * @param container
     *            container
     * @return list of lists of positions */
    public static List<List<Integer>> findAll(OWLObject key, OWLObject container) {
        checkNotNull(key, "key");
        checkNotNull(container, "container");
        List<List<Integer>> toReturn = key.equals(container) ? Collections
                .singletonList(Collections.singletonList(0)) : findAll(key, container,
                Collections.<Integer> emptyList());
        return toReturn;
    }

    private static List<List<Integer>> findAll(OWLObject key, OWLObject container,
            List<Integer> position) {
        List<List<Integer>> toReturn = new ArrayList<List<Integer>>();
        OWLObjectDecomposer decomposer = new OWLObjectDecomposer();
        List<Object> decomposition = container.accept(decomposer);
        if (!decomposition.isEmpty()) {
            Iterator<Object> iterator = decomposition.iterator();
            int i = 1;
            while (iterator.hasNext()) {
                Object object = iterator.next();
                if (OWLObject.class.isAssignableFrom(object.getClass())) {
                    OWLObject toCompare = (OWLObject) object;
                    ArrayList<Integer> newPosition = new ArrayList<Integer>(position);
                    newPosition.add(i);
                    if (key.equals(toCompare)) {
                        toReturn.add(newPosition);
                    } else {
                        toReturn.addAll(findAll(key, toCompare, newPosition));
                    }
                } else {
                    iterator.remove();
                }
                i++;
            }
        }
        return toReturn;
    }
}
