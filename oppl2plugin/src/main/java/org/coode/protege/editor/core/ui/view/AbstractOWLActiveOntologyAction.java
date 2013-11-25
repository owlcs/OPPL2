package org.coode.protege.editor.core.ui.view;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import javax.swing.Icon;

import org.protege.editor.core.ui.view.DisposableAction;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.event.EventType;
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.semanticweb.owlapi.model.OWLOntology;

/** @author Luigi Iannone */
public abstract class AbstractOWLActiveOntologyAction extends DisposableAction {
    private static final long serialVersionUID = 20100L;
    private final OWLModelManagerListener owlModelManagerListener;
    private final OWLEditorKit owlEditorKit;

    /** @param name
     * @param icon
     * @param owlEditorKit */
    public AbstractOWLActiveOntologyAction(String name, Icon icon,
            OWLEditorKit owlEditorKit) {
        super(name, icon);
        this.owlEditorKit = checkNotNull(owlEditorKit, "owlEditorKit");
        owlModelManagerListener = new OWLModelManagerListener() {
            @Override
            public void handleChange(OWLModelManagerChangeEvent event) {
                if (event.isType(EventType.ACTIVE_ONTOLOGY_CHANGED)) {
                    AbstractOWLActiveOntologyAction.this
                            .updateAction(AbstractOWLActiveOntologyAction.this
                                    .getOWLEditorKit().getOWLModelManager()
                                    .getActiveOntology());
                }
            }
        };
        getOWLEditorKit().getOWLModelManager().addListener(owlModelManagerListener);
        initialiseAction();
    }

    protected abstract void initialiseAction();

    protected abstract void updateAction(OWLOntology ontology);

    /** @return the owlEditorKit */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    @Override
    public final void dispose() {
        getOWLEditorKit().getOWLModelManager().removeListener(owlModelManagerListener);
        disposeOWLActiveOntologyAction();
    }

    protected abstract void disposeOWLActiveOntologyAction();
}
