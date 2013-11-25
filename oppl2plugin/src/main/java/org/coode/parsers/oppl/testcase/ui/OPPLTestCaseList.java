package org.coode.parsers.oppl.testcase.ui;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

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

/** @author Luigi Iannone */
public abstract class OPPLTestCaseList extends
        AbstractAnnotationsList<OPPLTestCaseAnnotationContainer> {
    /** @author Luigi Iannone */
    public final class OPPLTestCaseListItem extends AnnotationsListItem {
        private final OPPLTestCase opplTestCase;

        /** @param annot
         * @param opplTestCase */
        public OPPLTestCaseListItem(OWLAnnotation annot, OPPLTestCase opplTestCase) {
            super(annot);
            this.opplTestCase = checkNotNull(opplTestCase, "opplTestCase");
        }

        @Override
        public boolean handleDelete() {
            boolean toReturn = super.handleDelete();
            buttons.remove(opplTestCase);
            return toReturn;
        }

        /** @return the OPPLTestCase */
        public OPPLTestCase getOPPLTestCase() {
            return opplTestCase;
        }

        @Override
        public void handleEdit() {
            getEditor().setEditedObject(getOPPLTestCase());
            int ret = JOptionPaneEx.showValidatingConfirmDialog(getOWLEditorKit()
                    .getWorkspace(), "Test Case Editor",
                    getEditor().getEditorComponent(), getEditor(),
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION,
                    getComponentPopupMenu());
            if (ret == JOptionPane.OK_OPTION) {
                OPPLTestCase newOPPLTestCase = getEditor().getEditedObject();
                OWLDataFactory dataFactory = getOWLEditorKit().getOWLModelManager()
                        .getOWLOntologyManager().getOWLDataFactory();
                OWLLiteral literal = dataFactory
                        .getOWLLiteral(newOPPLTestCase.toString());
                IRI annotationIRI = Preferences.getTestCaseAnnotationProperty(
                        getOWLEditorKit().getOWLModelManager().getOWLDataFactory())
                        .getIRI();
                OWLAnnotation newAnnotation = dataFactory.getOWLAnnotation(
                        dataFactory.getOWLAnnotationProperty(annotationIRI), literal);
                if (!newAnnotation.equals(getAnnotation())) {
                    buttons.remove(getOPPLTestCase());
                    List<OWLOntologyChange> changes = getReplaceChanges(getAnnotation(),
                            newAnnotation);
                    getOWLEditorKit().getModelManager().applyChanges(changes);
                }
            }
        }
    }

    private static final long serialVersionUID = 20100L;
    // Have to as the super class header is not visible;
    private final MListSectionHeader header = new MListSectionHeader() {
        @Override
        public String getName() {
            return "OPPL Test Cases";
        }

        @Override
        public boolean canAdd() {
            return true;
        }
    };
    private final OWLEditorKit owlEditorKit;
    private final OPPLTestCaseEditor editor;
    protected final Map<OPPLTestCase, List<MListButton>> buttons = new HashMap<OPPLTestCase, List<MListButton>>();
    private final OWLModelManagerListener modelManagerListener;

    /** @param owlEditorKit */
    public OPPLTestCaseList(OWLEditorKit owlEditorKit) {
        super(owlEditorKit);
        // Have to do this as the super class does not expose the OWLEdtorKit
        this.owlEditorKit = owlEditorKit;
        editor = new OPPLTestCaseEditor(getOWLEditorKit());
        modelManagerListener = new OWLModelManagerListener() {
            @Override
            public void handleChange(OWLModelManagerChangeEvent event) {
                // Force refresh
                buttons.clear();
                OPPLTestCaseList.this.setRootObject(new OPPLTestCaseAnnotationContainer(
                        OPPLTestCaseList.this.getOWLEditorKit()));
            }
        };
        getOWLEditorKit().getOWLModelManager().addListener(modelManagerListener);
    }

    @Override
    protected List<OWLOntologyChange> getAddChanges(OWLAnnotation annot) {
        List<OWLOntologyChange> changes = new ArrayList<OWLOntologyChange>();
        changes.add(new AddOntologyAnnotation(getRoot().getOntology(), annot));
        return changes;
    }

    @Override
    protected List<OWLOntologyChange> getReplaceChanges(OWLAnnotation oldAnnotation,
            OWLAnnotation newAnnotation) {
        List<OWLOntologyChange> changes = new ArrayList<OWLOntologyChange>();
        changes.add(new RemoveOntologyAnnotation(getRoot().getOntology(), oldAnnotation));
        changes.add(new AddOntologyAnnotation(getRoot().getOntology(), newAnnotation));
        return changes;
    }

    @Override
    protected List<OWLOntologyChange> getDeleteChanges(OWLAnnotation annot) {
        List<OWLOntologyChange> changes = new ArrayList<OWLOntologyChange>();
        changes.add(new RemoveOntologyAnnotation(getRoot().getOntology(), annot));
        return changes;
    }

    @Override
    protected void handleOntologyChanges(List<? extends OWLOntologyChange> changes) {
        for (OWLOntologyChange change : changes) {
            if (change instanceof AddOntologyAnnotation
                    || change instanceof RemoveOntologyAnnotation) {
                if (change.getOntology().equals(getRoot().getOntology())) {
                    refresh();
                    return;
                }
            }
        }
    }

    protected OPPLTestCaseEditor getEditor() {
        return editor;
    }

    @Override
    protected void handleAdd() {
        getEditor().setEditedObject(null);
        int ret = JOptionPaneEx.showValidatingConfirmDialog(OPPLTestCaseList.this
                .getOWLEditorKit().getWorkspace(), "OPPL Test Case Editor",
                OPPLTestCaseList.this.getEditor().getEditorComponent(),
                OPPLTestCaseList.this.getEditor(), JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION, OPPLTestCaseList.this
                        .getComponentPopupMenu());
        if (ret == JOptionPane.OK_OPTION) {
            OPPLTestCase OPPLTestCase = getEditor().getEditedObject();
            OWLDataFactory dataFactory = getOWLEditorKit().getOWLModelManager()
                    .getOWLOntologyManager().getOWLDataFactory();
            OWLLiteral literal = dataFactory.getOWLLiteral(OPPLTestCase.toString());
            IRI annotationIRI = Preferences.getTestCaseAnnotationProperty(
                    getOWLEditorKit().getOWLModelManager().getOWLDataFactory()).getIRI();
            OWLAnnotation annotation = dataFactory.getOWLAnnotation(
                    dataFactory.getOWLAnnotationProperty(annotationIRI), literal);
            getOWLEditorKit().getModelManager().applyChanges(getAddChanges(annotation));
        }
    }

    @Override
    public void setRootObject(OPPLTestCaseAnnotationContainer root) {
        super.setRootObject(root);
        List<Object> data = new ArrayList<Object>();
        data.add(header);
        if (root != null) {
            // @@TODO ordering
            for (OWLAnnotation annot : root.getAnnotations()) {
                data.add(new OPPLTestCaseListItem(annot, root.getOPPLTestCase(annot)));
            }
        }
        this.setListData(data.toArray());
        revalidate();
    }

    /** @return the owlEditorKit */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    @Override
    protected List<MListButton> getListItemButtons(MListItem item) {
        // super.getListItemButtons(item) does NOT make a defensive copy!!!!
        List<MListButton> listItemButtons = new ArrayList<MListButton>(
                super.getListItemButtons(item));
        if (item instanceof OPPLTestCaseListItem) {
            final OPPLTestCase opplTestCase = ((OPPLTestCaseListItem) item)
                    .getOPPLTestCase();
            List<MListButton> list = buttons.get(opplTestCase);
            if (list == null) {
                ActionListener actionListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        OPPLTestCaseList.this.runTest(opplTestCase);
                    }
                };
                RunOPPLTestCaseMListButton runButton = new RunOPPLTestCaseMListButton(
                        actionListener);
                if (!listItemButtons.contains(runButton)) {
                    listItemButtons.add(runButton);
                }
                buttons.put(opplTestCase, listItemButtons);
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
        getOWLEditorKit().getOWLModelManager().removeListener(modelManagerListener);
        editor.dispose();
    }
}
