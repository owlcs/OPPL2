/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.protege.OPPLTestCaseAnnotationContainer;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.owl.ui.view.AbstractActiveOntologyViewComponent;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * @author Luigi Iannone
 * 
 */
public class OPPLTestCaseView extends AbstractActiveOntologyViewComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8432231579317686072L;
	private OPPLTestCaseList list;
	private final OPPLTestCaseRunPanel testCaseRunPanel = new OPPLTestCaseRunPanel();
	private AbstractAllOPPLTestCaseAction runAllTestAction;

	/**
	 * @see org.protege.editor.owl.ui.view.AbstractActiveOntologyViewComponent#
	 *      initialiseOntologyView()
	 */
	@Override
	protected void initialiseOntologyView() throws Exception {
		this.setLayout(new BorderLayout());
		JSplitPane mainPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		mainPanel.setDividerLocation(.5);
		mainPanel.setResizeWeight(.5);
		this.list = new OPPLTestCaseList(this.getOWLEditorKit()) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -4600121675171808887L;

			@Override
			protected void runTest(OPPLTestCase opplTestCase) {
				OPPLTestCaseView.this.testCaseRunPanel.runTests(Collections
						.singleton(opplTestCase));
			}
		};
		this.list.setRootObject(new OPPLTestCaseAnnotationContainer(this
				.getOWLEditorKit()));
		JScrollPane listPane = ComponentFactory.createScrollPane(this.list);
		this.runAllTestAction = new AbstractAllOPPLTestCaseAction("Run All",
				this.getOWLEditorKit()) {
			private static final long serialVersionUID = -4024619398479531818L;

			public void actionPerformed(ActionEvent e) {
				Set<OPPLTestCase> opplTestCases = this.getOPPLTestCases();
				OPPLTestCaseView.this.testCaseRunPanel.runTests(opplTestCases);
			}
		};
		JToolBar toolBar = ComponentFactory.createViewToolBar();
		toolBar.add(this.runAllTestAction);
		JPanel leftPanel = new JPanel(new BorderLayout());
		leftPanel.add(listPane, BorderLayout.CENTER);
		leftPanel.add(toolBar, BorderLayout.NORTH);
		mainPanel.setLeftComponent(leftPanel);
		mainPanel.setRightComponent(this.testCaseRunPanel);
		this.add(mainPanel);
	}

	/**
	 * @see org.protege.editor.owl.ui.view.AbstractActiveOntologyViewComponent#
	 *      disposeOntologyView()
	 */
	@Override
	protected void disposeOntologyView() {
		if (this.list != null) {
			this.list.dispose();
		}
		if (this.runAllTestAction != null) {
			this.runAllTestAction.dispose();
		}
	}

	/**
	 * @see org.protege.editor.owl.ui.view.AbstractActiveOntologyViewComponent#updateView
	 *      (org.semanticweb.owlapi.model.OWLOntology)
	 */
	@Override
	protected void updateView(OWLOntology activeOntology) throws Exception {
		this.list.setRootObject(new OPPLTestCaseAnnotationContainer(this
				.getOWLEditorKit()));
	}
}
