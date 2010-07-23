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
import org.semanticweb.owl.model.OWLEntity;

public class OWLEntitySelector extends JPanel implements VerifiedInputEditor {
	private static final long serialVersionUID = -2876275234475209099L;
	protected MList facetClassView = new MList();
	protected List<OWLEntity> facetClasses = new ArrayList<OWLEntity>();
	protected VariableListModel<OWLEntity> facetClassesModel = new VariableListModel<OWLEntity>(
			this.facetClasses, "OWL entity selection");
	private Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
	private OWLEditorKit kit;

	public void addStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.add(listener);
	}

	public void removeStatusChangedListener(
			InputVerificationStatusChangedListener listener) {
		this.listeners.remove(listener);
	}

	public OWLEntitySelector(OWLEditorKit k) {
		super(new BorderLayout());
		this.kit = k;
		this.facetClasses.addAll(LocalityChecker.collectEntities(k
				.getOWLModelManager().getOntologies()));
		this.facetClassView.setCellRenderer(new RenderableObjectCellRenderer(
				this.kit));
		this.facetClassView.setModel(this.facetClassesModel);
		this.setOK(false);
		this.facetClassesModel.init();
		JScrollPane spobjf = ComponentFactory
				.createScrollPane(this.facetClassView);
		spobjf.setBorder(ComponentFactory
				.createTitledBorder("Entity selection"));
		this.add(spobjf);
		this.facetClassView
				.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						if (!e.getValueIsAdjusting()) {
							// then status is OK
							OWLEntitySelector.this.setOK(true);
						}
					}
				});
	}

	protected void setOK(boolean b) {
		for (InputVerificationStatusChangedListener i : this.listeners) {
			i.verifiedStatusChanged(b);
		}
	}

	public void clear() {
		this.facetClassView.getSelectionModel().clearSelection();
	}

	@SuppressWarnings("unchecked")
	public OWLEntity getOWLClass() {
		if (this.facetClassView.getSelectedIndex() > -1) {
			OWLEntity p = ((VariableListItem<OWLEntity>) this.facetClassView
					.getSelectedValue()).getItem();
			return p;
		}
		return null;
	}
}