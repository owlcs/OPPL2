package org.coode.oppl.protege.ui;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import org.protege.editor.core.ui.list.MList;

/** @author Luigi Iannone */
public class OPPLMList extends MList {
    private static final long serialVersionUID = 20100L;

    /** @return default list model */
    @SuppressWarnings("unchecked")
    public final DefaultListModel<Object> getDefaultModel() {
        return (DefaultListModel<Object>) getModel();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void setModel(ListModel model) {
        super.setModel(model);
    }

    /** @param model */
    public void setDefaultModel(DefaultListModel<Object> model) {
        setModel(model);
    }
}
