/**
 * 
 */
package org.coode.parsers;

import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * @author Luigi Iannone
 * 
 */
public class ShortFormEntityRenderer implements OWLEntityRenderer {
	private final ShortFormProvider shortFormProvider;

	/**
	 * @param shortFormProvider
	 */
	public ShortFormEntityRenderer(ShortFormProvider shortFormProvider) {
		if (shortFormProvider == null) {
			throw new NullPointerException(
					"The short form provider cannot be null");
		}
		this.shortFormProvider = shortFormProvider;
	};

	public String render(OWLEntity entity) {
		return this.shortFormProvider.getShortForm(entity);
	}
}
