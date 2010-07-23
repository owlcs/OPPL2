package org.coode.patterns.protege.utils;

import javax.swing.Icon;

import org.coode.patterns.protege.utils.VariableListModel.VariableListItem;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.renderer.OWLCellRenderer;
import org.semanticweb.owl.model.OWLObject;

/**
 * Specialized OWLCellRenderer that deals with VariableListItems and
 * StaticListItems containing either OWLObjects or PRopertyChainModel,
 * PropertyChainCell or BindingModel objects
 */
public class RenderableObjectCellRenderer extends OWLCellRenderer {
	private OWLEditorKit kit;

	public RenderableObjectCellRenderer(OWLEditorKit edkit) {
		super(edkit);
		this.kit = edkit;
	}

	@Override
	protected String getRendering(Object object) {
		// if the item is an OWLObject, use the default OWLCellRenderer
		// implementation
		if (object == null) {
			return "";
		}
		if (object instanceof OWLObject) {
			return super.getRendering(object);
		}
		// otherwise, instead of a simple toString...
		Object item = null;
		if (object instanceof VariableListItem<?>) {
			item = ((VariableListItem<?>) object).getItem();
		}
		// item contains now the actual element
		if (item != null) {
			// if the item is an OWLObject, use the default OWLCellRenderer
			// implementation
			if (item instanceof OWLObject) {
				return super.getRendering(item);
			}
		}
		// if everything else fails...
		return object.toString();
	}

	@Override
	@SuppressWarnings("unchecked")
	protected Icon getIcon(Object object) {
		Object item = null;
		// handles the special cases of VariableListItem and StaticListItem
		if (object instanceof VariableListItem) {
			item = ((VariableListItem) object).getItem();
		}
		// item contains now the actual element
		if (item != null) {
			return super.getIcon(item);
		}
		return super.getIcon(object);
	}
}
