package org.coode.parsers.oppl.testcase.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.coode.oppltestcase.ui.utils.JOptionPaneEx;
import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.protege.OPPLTestCaseAnnotationContainer;
import org.coode.parsers.oppl.testcase.protege.Preferences;
import org.protege.editor.core.ui.list.MListButton;
import org.protege.editor.core.ui.list.MListItem;
import org.protege.editor.core.ui.list.MListSectionHeader;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.protege.editor.owl.ui.list.AbstractAnnotationsList;
import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.RemoveOntologyAnnotation;

public abstract class OPPLTestCaseList extends
		AbstractAnnotationsList<OPPLTestCaseAnnotationContainer> {
	/**
	 * @author Luigi Iannone
	 * 
	 */
	public final class OPPLTestCaseListItem extends AnnotationsListItem {
		private final OPPLTestCase opplTestCase;

		/**
		 * @param annot
		 */
		public OPPLTestCaseListItem(OWLAnnotation annot,
				OPPLTestCase opplTestCase) {
			super(annot);
			if (opplTestCase == null) {
				throw new NullPointerException(
						"The pattern model cannot be null");
			}
			this.opplTestCase = opplTestCase;
		}

		@Override
		public boolean handleDelete() {
			boolean toReturn = super.handleDelete();
			OPPLTestCaseList.this.buttons.remove(this.opplTestCase);
			return toReturn;
		}

		/**
		 * @return the OPPLTestCase
		 */
		public OPPLTestCase getOPPLTestCase() {
			return this.opplTestCase;
		}

		@Override
		public void handleEdit() {
			OPPLTestCaseList.this.getEditor().setEditedObject(
					this.getOPPLTestCase());
			int ret = JOptionPaneEx.showValidatingConfirmDialog(
					OPPLTestCaseList.this.getOWLEditorKit().getWorkspace(),
					"Test Case Editor", OPPLTestCaseList.this.getEditor()
							.getEditorComponent(), OPPLTestCaseList.this
							.getEditor(), JOptionPane.PLAIN_MESSAGE,
					JOptionPane.OK_CANCEL_OPTION, OPPLTestCaseList.this
							.getComponentPopupMenu());
			if (ret == JOptionPane.OK_OPTION) {
				OPPLTestCase newOPPLTestCase = OPPLTestCaseList.this
						.getEditor().getEditedObject();
				OWLDataFactory dataFactory = OPPLTestCaseList.this
						.getOWLEditorKit().getOWLModelManager()
						.getOWLOntologyManager().getOWLDataFactory();
				OWLLiteral literal = dataFactory.getOWLLiteral(newOPPLTestCase
						.toString());
				IRI annotationIRI = Preferences.getTestCaseAnnotationProperty(
						OPPLTestCaseList.this.getOWLEditorKit()
								.getOWLModelManager().getOWLDataFactory())
						.getIRI();
				OWLAnnotation newAnnotation = dataFactory.getOWLAnnotation(
						dataFactory.getOWLAnnotationProperty(annotationIRI),
						literal);
				if (!newAnnotation.equals(this.getAnnotation())) {
					OPPLTestCaseList.this.buttons
							.remove(this.getOPPLTestCase());
					List<OWLOntologyChange> changes = OPPLTestCaseList.this
							.getReplaceChanges(this.getAnnotation(),
									newAnnotation);
					OPPLTestCaseList.this.getOWLEditorKit().getModelManager()
							.applyChanges(changes);
				}
			}
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6792396788714900301L;
	// Have to as the super class header is not visible;
	private MListSectionHeader header = new MListSectionHeader() {
		public String getName() {
			return "OPPL Test Cases";
		}

		public boolean canAdd() {
			return true;
		}
	};
	private final OWLEditorKit owlEditorKit;
	private final OPPLTestCaseEditor editor;
	private final Map<OPPLTestCase, List<MListButton>> buttons = new HashMap<OPPLTestCase, List<MListButton>>();
	private final OWLModelManagerListener modelManagerListener;

	/**
	 * @param owlEditorKit
	 */
	public OPPLTestCaseList(OWLEditorKit owlEditorKit) {
		super(owlEditorKit);
		// Have to do this as the super class does not expose the OWLEdtorKit
		this.owlEditorKit = owlEditorKit;
		this.editor = new OPPLTestCaseEditor(this.getOWLEditorKit());
		this.modelManagerListener = new OWLModelManagerListener() {
			public void handleChange(OWLModelManagerChangeEvent event) {
				// Force refresh
				OPPLTestCaseList.this
						.setRootObject(new OPPLTestCaseAnnotationContainer(
								OPPLTestCaseList.this.getOWLEditorKit()));
			}
		};
		this.getOWLEditorKit().getOWLModelManager().addListener(
				this.modelManagerListener);
	}

	@Override
	protected List<OWLOntologyChange> getAddChanges(OWLAnnotation annot) {
		List<OWLOntologyChange> changes = new ArrayList<OWLOntologyChange>();
		changes.add(new AddOntologyAnnotation(this.getRoot().getOntology(),
				annot));
		return changes;
	}

	@Override
	protected List<OWLOntologyChange> getReplaceChanges(
			OWLAnnotation oldAnnotation, OWLAnnotation newAnnotation) {
		List<OWLOntologyChange> changes = new ArrayList<OWLOntologyChange>();
		changes.add(new RemoveOntologyAnnotation(this.getRoot().getOntology(),
				oldAnnotation));
		changes.add(new AddOntologyAnnotation(this.getRoot().getOntology(),
				newAnnotation));
		return changes;
	}

	@Override
	protected List<OWLOntologyChange> getDeleteChanges(OWLAnnotation annot) {
		List<OWLOntologyChange> changes = new ArrayList<OWLOntologyChange>();
		changes.add(new RemoveOntologyAnnotation(this.getRoot().getOntology(),
				annot));
		return changes;
	}

	@Override
	protected void handleOntologyChanges(
			List<? extends OWLOntologyChange> changes) {
		for (OWLOntologyChange change : changes) {
			if (change instanceof AddOntologyAnnotation
					|| change instanceof RemoveOntologyAnnotation) {
				if (change.getOntology().equals(this.getRoot().getOntology())) {
					this.refresh();
					return;
				}
			}
		}
	}

	protected OPPLTestCaseEditor getEditor() {
		return this.editor;
	}

	@Override
	protected void handleAdd() {
		this.getEditor().setEditedObject(null);
		int ret = JOptionPaneEx.showValidatingConfirmDialog(
				OPPLTestCaseList.this.getOWLEditorKit().getWorkspace(),
				"OPPL Test Case Editor", OPPLTestCaseList.this.getEditor()
						.getEditorComponent(), OPPLTestCaseList.this
						.getEditor(), JOptionPane.PLAIN_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION, OPPLTestCaseList.this
						.getComponentPopupMenu());
		if (ret == JOptionPane.OK_OPTION) {
			OPPLTestCase OPPLTestCase = this.getEditor().getEditedObject();
			OWLDataFactory dataFactory = this.getOWLEditorKit()
					.getOWLModelManager().getOWLOntologyManager()
					.getOWLDataFactory();
			OWLLiteral literal = dataFactory.getOWLLiteral(OPPLTestCase
					.toString());
			IRI annotationIRI = Preferences.getTestCaseAnnotationProperty(
					this.getOWLEditorKit().getOWLModelManager()
							.getOWLDataFactory()).getIRI();
			OWLAnnotation annotation = dataFactory.getOWLAnnotation(dataFactory
					.getOWLAnnotationProperty(annotationIRI), literal);
			this.getOWLEditorKit().getModelManager().applyChanges(
					this.getAddChanges(annotation));
		}
	}

	@Override
	public void setRootObject(OPPLTestCaseAnnotationContainer root) {
		super.setRootObject(root);
		java.util.List<Object> data = new ArrayList<Object>();
		data.add(this.header);
		if (root != null) {
			// @@TODO ordering
			for (OWLAnnotation annot : root.getAnnotations()) {
				data.add(new OPPLTestCaseListItem(annot, root
						.getOPPLTestCase(annot)));
			}
		}
		this.setListData(data.toArray());
		this.revalidate();
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}

	@Override
	protected List<MListButton> getListItemButtons(MListItem item) {
		// super.getListItemButtons(item) does NOT make a defensive copy!!!!
		List<MListButton> listItemButtons = new ArrayList<MListButton>(super
				.getListItemButtons(item));
		if (item instanceof OPPLTestCaseListItem) {
			final OPPLTestCase opplTestCase = ((OPPLTestCaseListItem) item)
					.getOPPLTestCase();
			List<MListButton> list = this.buttons.get(opplTestCase);
			if (list == null) {
				ActionListener actionListener = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						OPPLTestCaseList.this.runTest(opplTestCase);
					}
				};
				RunOPPLTestCaseMListButton runButton = new RunOPPLTestCaseMListButton(
						actionListener);
				if (!listItemButtons.contains(runButton)) {
					listItemButtons.add(runButton);
				}
				this.buttons.put(opplTestCase, listItemButtons);
			} else {
				listItemButtons = list;
			}
		}
		return listItemButtons;
	}

	protected abstract void runTest(OPPLTestCase opplTestCase);

	@Override
	public void dispose() {
		super.dispose();
		this.getOWLEditorKit().getOWLModelManager().removeListener(
				this.modelManagerListener);
	}
}
