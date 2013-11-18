package org.coode.patterns.protege.utils;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.coode.patterns.locality.LocalityChecker;
import org.coode.patterns.protege.utils.VariableListModel.VariableListItem;
import org.protege.editor.core.ui.list.MList;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.owl.OWLEditorKit;
import org.semanticweb.owlapi.model.OWLEntity;

/** @author Luigi Iannone */
public class OWLEntitySelector extends JPanel implements VerifiedInputEditor {
    private static final long serialVersionUID = -2876275234475209099L;
    protected MList facetClassView = new MList();
    protected List<OWLEntity> facetClasses = new ArrayList<OWLEntity>();
    protected VariableListModel<OWLEntity> facetClassesModel = new VariableListModel<OWLEntity>(
            facetClasses, "OWL entity selection");
    private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
    private final OWLEditorKit kit;

    @Override
    public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeStatusChangedListener(
            InputVerificationStatusChangedListener listener) {
        listeners.remove(listener);
    }

    /** @param k */
    public OWLEntitySelector(OWLEditorKit k) {
        super(new BorderLayout());
        kit = k;
        facetClasses.addAll(LocalityChecker.collectEntities(k.getOWLModelManager()
                .getOntologies()));
        facetClassView.setCellRenderer(new RenderableObjectCellRenderer(kit));
        facetClassView.setModel(facetClassesModel);
        setOK(false);
        facetClassesModel.init();
        JScrollPane spobjf = ComponentFactory.createScrollPane(facetClassView);
        spobjf.setBorder(ComponentFactory.createTitledBorder("Entity selection"));
        this.add(spobjf);
        facetClassView.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // then status is OK
                    OWLEntitySelector.this.setOK(true);
                }
            }
        });
    }

    protected void setOK(boolean b) {
        for (InputVerificationStatusChangedListener i : listeners) {
            i.verifiedStatusChanged(b);
        }
    }

    /** clear the view */
    public void clear() {
        facetClassView.getSelectionModel().clearSelection();
    }

    /** @return the owl class */
    @SuppressWarnings("unchecked")
    public OWLEntity getOWLClass() {
        if (facetClassView.getSelectedIndex() > -1) {
            OWLEntity p = ((VariableListItem<OWLEntity>) facetClassView
                    .getSelectedValue()).getItem();
            return p;
        }
        return null;
    }
}
