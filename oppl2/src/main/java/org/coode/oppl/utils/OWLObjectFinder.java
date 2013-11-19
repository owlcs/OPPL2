package org.coode.oppl.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.semanticweb.owlapi.model.OWLObject;

public class OWLObjectFinder {
    public static List<List<Integer>> findAll(OWLObject key, OWLObject container) {
        if (key == null) {
            throw new NullPointerException("The key cannot be null");
        }
        if (container == null) {
            throw new NullPointerException("The container cannot be null");
        }
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
