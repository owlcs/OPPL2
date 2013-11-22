package org.coode.oppl.protege.ui;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import org.protege.editor.core.ui.list.MList;

public class OPPLMList extends MList {
    public final DefaultListModel<Object> getDefaultModel() {
        return (DefaultListModel<Object>) getModel();
    }

    @Override
    public void setModel(ListModel model) {
        super.setModel(model);
    }

    public void setDefaultModel(DefaultListModel<Object> model) {
        setModel(model);
    }
}
