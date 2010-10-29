package org.coode.oppl.function;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLObject;

public class Adapter {
	public static <O extends OWLObject> OPPLFunction<O> buildOWLObjectAdater(
			O value) {
		return new Constant<O>(value);
	}

	public static <O extends OWLObject> Set<OPPLFunction<O>> buildOWLObjectCollectionAdapter(
			Collection<? extends O> collection) {
		Set<OPPLFunction<O>> toReturn = new HashSet<OPPLFunction<O>>(collection
				.size());
		for (O o : collection) {
			toReturn.add(buildOWLObjectAdater(o));
		}
		return toReturn;
	}
}
