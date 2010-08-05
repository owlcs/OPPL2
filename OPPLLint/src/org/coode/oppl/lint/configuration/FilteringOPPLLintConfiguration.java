/**
 * 
 */
package org.coode.oppl.lint.configuration;

import org.coode.oppl.lint.filtering.Filter;
import org.coode.oppl.lint.filtering.FilteringOPPLLint;
import org.semanticweb.owl.lint.configuration.PropertyBasedLintConfiguration;

import uk.ac.manchester.cs.owl.lint.commons.AbstractPropertiesBasedLintConfiguration;

/**
 * @author Luigi Iannone
 * 
 */
public class FilteringOPPLLintConfiguration extends AbstractPropertiesBasedLintConfiguration
		implements PropertyBasedLintConfiguration {
	private final Filter<?> filter;

	public FilteringOPPLLintConfiguration(FilteringOPPLLint lint, Filter<?> filter) {
		super(lint);
		if (filter == null) {
			throw new NullPointerException("The filter cannot be null");
		}
		this.filter = filter;
	}

	@Override
	protected String getPropertyFileName() {
		return this.getFilter().getOriginatingFilterClass().getName() + ".properties";
	}

	/**
	 * @return the filter
	 */
	public Filter<?> getFilter() {
		return this.filter;
	}
}
