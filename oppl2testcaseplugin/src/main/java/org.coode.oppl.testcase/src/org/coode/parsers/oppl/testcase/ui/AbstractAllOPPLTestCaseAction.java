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

/** @author Luigi Iannone */
abstract class AbstractAllOPPLTestCaseAction extends AbstractOWLActiveOntologyAction {
    protected static final Stroke ICON_STROKE = new BasicStroke(2.0f,
            BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    protected final static Icon ICON = new Icon() {
        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            int inset = 4;
            Color oldColour = g.getColor();
            Stroke oldStroke = ((Graphics2D) g).getStroke();
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            ((Graphics2D) g).setStroke(ICON_STROKE);
            g.setColor(Color.GREEN);
            Rectangle bounds = new Rectangle(x, y, getIconWidth(), getIconHeight());
            Polygon triangle = new Polygon(new int[] { (int) bounds.getMinX() + inset,
                    (int) bounds.getMinX() + inset, (int) bounds.getMaxX() - inset },
                    new int[] { (int) bounds.getMinY() + inset,
                            (int) bounds.getMaxY() - inset, (int) bounds.getCenterY() },
                    3);
            ((Graphics2D) g).draw(triangle);
            ((Graphics2D) g).fill(triangle);
            ((Graphics2D) g).setStroke(oldStroke);
            g.setColor(oldColour);
        }

        @Override
        public int getIconWidth() {
            return 16;
        }

        @Override
        public int getIconHeight() {
            return 16;
        }
    };
    private static final long serialVersionUID = -2342285898923424925L;
    protected Set<OPPLTestCase> opplTestCases;
    protected OWLOntologyChangeListener ontologyChangeListener;
    protected OWLModelManagerListener modelManagerListener;

    /** @param name
     * @param owlEditorKit */
    public AbstractAllOPPLTestCaseAction(String name, OWLEditorKit owlEditorKit) {
        super(name, ICON, owlEditorKit);
    }

    @Override
    protected void initialiseAction() {
        if (ontologyChangeListener == null) {
            ontologyChangeListener = new OWLOntologyChangeListener() {
                @Override
                public void ontologiesChanged(List<? extends OWLOntologyChange> changes)
                        throws OWLException {
                    boolean found = false;
                    Iterator<? extends OWLOntologyChange> iterator = changes.iterator();
                    final Set<OWLOntologyChange> relevantChanges = new HashSet<OWLOntologyChange>();
                    while (!found && iterator.hasNext()) {
                        OWLOntologyChange owlOntologyChange = iterator.next();
                        owlOntologyChange.accept(new OWLOntologyChangeVisitorAdapter() {
                            @Override
                            public void visit(RemoveOntologyAnnotation change) {
                                relevantChanges.add(change);
                            }

                            @Override
                            public void visit(AddOntologyAnnotation change) {
                                relevantChanges.add(change);
                            }
                        });
                        // Have to do this as there is not visitor with return
                        // value for
                        // OWLOntologyChange!!
                        found = !relevantChanges.isEmpty();
                    }
                    if (found) {
                        opplTestCases.clear();
                        AbstractAllOPPLTestCaseAction.this.refresh();
                    }
                }
            };
        }
        getOWLEditorKit().getOWLModelManager().getOWLOntologyManager()
                .addOntologyChangeListener(ontologyChangeListener);
        modelManagerListener = new OWLModelManagerListener() {
            @Override
            public void handleChange(OWLModelManagerChangeEvent event) {
                // Force refresh
                opplTestCases.clear();
                AbstractAllOPPLTestCaseAction.this.refresh();
            }
        };
        getOWLEditorKit().getOWLModelManager().addListener(modelManagerListener);
        refresh();
    }

    protected void refresh() {
        OPPLTestCaseAnnotationContainer opplTestCaseAnnotationContainer = new OPPLTestCaseAnnotationContainer(
                getOWLEditorKit());
        if (opplTestCases == null) {
            opplTestCases = new HashSet<OPPLTestCase>();
        }
        opplTestCases.addAll(opplTestCaseAnnotationContainer.getOPPLTestCases());
        setEnabled(!opplTestCases.isEmpty());
    }

    @Override
    protected void disposeOWLActiveOntologyAction() {
        getOWLEditorKit().getOWLModelManager().getOWLOntologyManager()
                .removeOntologyChangeListener(ontologyChangeListener);
        getOWLEditorKit().getOWLModelManager().removeListener(modelManagerListener);
    }

    @Override
    protected void updateAction(OWLOntology ontology) {
        opplTestCases.clear();
        refresh();
    }

    /** @return the opplTestCases */
    public Set<OPPLTestCase> getOPPLTestCases() {
        return new HashSet<OPPLTestCase>(opplTestCases);
    }
}
