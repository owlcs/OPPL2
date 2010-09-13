/**
 * 
 */
package org.coode.parsers.oppl.testcase.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.Icon;

import org.coode.parsers.oppl.testcase.OPPLTestCase;
import org.coode.parsers.oppl.testcase.protege.OPPLTestCaseAnnotationContainer;
import org.protege.editor.core.ui.view.AbstractOWLActiveOntologyAction;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyChangeListener;
import org.semanticweb.owlapi.model.RemoveOntologyAnnotation;
import org.semanticweb.owlapi.util.OWLOntologyChangeVisitorAdapter;

/**
 * @author Luigi Iannone
 * 
 */
abstract class AbstractAllOPPLTestCaseAction extends
		AbstractOWLActiveOntologyAction {
	private static final Stroke ICON_STROKE = new BasicStroke(2.0f,
			BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
	private final static Icon ICON = new Icon() {
		public void paintIcon(Component c, Graphics g, int x, int y) {
			int inset = 4;
			Color oldColour = g.getColor();
			Stroke oldStroke = ((Graphics2D) g).getStroke();
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			((Graphics2D) g).setStroke(ICON_STROKE);
			g.setColor(Color.GREEN);
			Rectangle bounds = new Rectangle(x, y, this.getIconWidth(), this
					.getIconHeight());
			Polygon triangle = new Polygon(new int[] {
					(int) bounds.getMinX() + inset,
					(int) bounds.getMinX() + inset,
					(int) bounds.getMaxX() - inset },
					new int[] { (int) bounds.getMinY() + inset,
							(int) bounds.getMaxY() - inset,
							(int) bounds.getCenterY() }, 3);
			((Graphics2D) g).draw(triangle);
			((Graphics2D) g).fill(triangle);
			((Graphics2D) g).setStroke(oldStroke);
			g.setColor(oldColour);
		}

		public int getIconWidth() {
			return 16;
		}

		public int getIconHeight() {
			return 16;
		}
	};
	/**
	 * 
	 */
	private static final long serialVersionUID = -2342285898923424925L;
	private Set<OPPLTestCase> opplTestCases;
	private OWLOntologyChangeListener ontologyChangeListener;
	private OWLModelManagerListener modelManagerListener;

	/**
	 * @param name
	 * @param icon
	 * @param owlEditorKit
	 */
	public AbstractAllOPPLTestCaseAction(String name, OWLEditorKit owlEditorKit) {
		super(name, ICON, owlEditorKit);
	}

	/**
	 * @see org.protege.editor.core.ui.view.AbstractOWLActiveOntologyAction#initialiseAction()
	 */
	@Override
	protected void initialiseAction() {
		if (this.ontologyChangeListener == null) {
			this.ontologyChangeListener = new OWLOntologyChangeListener() {
				public void ontologiesChanged(
						List<? extends OWLOntologyChange> changes)
						throws OWLException {
					boolean found = false;
					Iterator<? extends OWLOntologyChange> iterator = changes
							.iterator();
					final Set<OWLOntologyChange> relevantChanges = new HashSet<OWLOntologyChange>();
					while (!found && iterator.hasNext()) {
						OWLOntologyChange owlOntologyChange = iterator.next();
						owlOntologyChange
								.accept(new OWLOntologyChangeVisitorAdapter() {
									@Override
									public void visit(
											RemoveOntologyAnnotation change) {
										relevantChanges.add(change);
									}

									@Override
									public void visit(
											AddOntologyAnnotation change) {
										relevantChanges.add(change);
									}
								});
						// Have to do this as there is not visitor with return
						// value for
						// OWLOntologyChange!!
						found = !relevantChanges.isEmpty();
					}
					if (found) {
						AbstractAllOPPLTestCaseAction.this.opplTestCases
								.clear();
						AbstractAllOPPLTestCaseAction.this.refresh();
					}
				}
			};
		}
		this.getOWLEditorKit().getOWLModelManager().getOWLOntologyManager()
				.addOntologyChangeListener(this.ontologyChangeListener);
		this.modelManagerListener = new OWLModelManagerListener() {
			public void handleChange(OWLModelManagerChangeEvent event) {
				// Force refresh
				AbstractAllOPPLTestCaseAction.this.opplTestCases.clear();
				AbstractAllOPPLTestCaseAction.this.refresh();
			}
		};
		this.getOWLEditorKit().getOWLModelManager().addListener(
				this.modelManagerListener);
		this.refresh();
	}

	private void refresh() {
		OPPLTestCaseAnnotationContainer opplTestCaseAnnotationContainer = new OPPLTestCaseAnnotationContainer(
				this.getOWLEditorKit());
		if (this.opplTestCases == null) {
			this.opplTestCases = new HashSet<OPPLTestCase>();
		}
		this.opplTestCases.addAll(opplTestCaseAnnotationContainer
				.getOPPLTestCases());
		this.setEnabled(!this.opplTestCases.isEmpty());
	}

	/**
	 * @see org.protege.editor.core.ui.view.AbstractOWLActiveOntologyAction#
	 *      disposeOWLActiveOntologyAction()
	 */
	@Override
	protected void disposeOWLActiveOntologyAction() {
		this.getOWLEditorKit().getOWLModelManager().getOWLOntologyManager()
				.removeOntologyChangeListener(this.ontologyChangeListener);
		this.getOWLEditorKit().getOWLModelManager().removeListener(
				this.modelManagerListener);
	}

	/**
	 * @see org.protege.editor.core.ui.view.AbstractOWLActiveOntologyAction#updateAction
	 *      (org.semanticweb.owlapi.model.OWLOntology)
	 */
	@Override
	protected void updateAction(OWLOntology ontology) {
		this.opplTestCases.clear();
		this.refresh();
	}

	/**
	 * @return the opplTestCases
	 */
	public Set<OPPLTestCase> getOPPLTestCases() {
		return new HashSet<OPPLTestCase>(this.opplTestCases);
	}
}
