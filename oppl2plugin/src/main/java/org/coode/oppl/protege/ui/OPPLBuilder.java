package org.coode.oppl.protege.ui;

import static org.coode.oppl.utils.ArgCheck.checkNotNull;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import org.coode.oppl.AbstractConstraint;
import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.ConstraintVisitorEx;
import org.coode.oppl.InCollectionConstraint;
import org.coode.oppl.InequalityConstraint;
import org.coode.oppl.NAFConstraint;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.RegExpConstraint;
import org.coode.oppl.Variable;
import org.coode.oppl.VariableVisitorEx;
import org.coode.oppl.function.Aggregandum;
import org.coode.oppl.function.Aggregation;
import org.coode.oppl.function.Constant;
import org.coode.oppl.function.Create;
import org.coode.oppl.function.Expression;
import org.coode.oppl.function.GroupVariableAttribute;
import org.coode.oppl.function.IRIVariableAttribute;
import org.coode.oppl.function.OPPLFunction;
import org.coode.oppl.function.OPPLFunctionVisitorEx;
import org.coode.oppl.function.RenderingVariableAttribute;
import org.coode.oppl.function.ToLowerCaseStringManipulationOPPLFunction;
import org.coode.oppl.function.ToUpperCaseStringManipulationOPPLFunction;
import org.coode.oppl.function.ValuesVariableAtttribute;
import org.coode.oppl.function.inline.InlineSet;
import org.coode.oppl.generated.GeneratedVariable;
import org.coode.oppl.generated.RegexpGeneratedVariable;
import org.coode.oppl.protege.ProtegeParserFactory;
import org.coode.oppl.protege.ui.message.Error;
import org.coode.oppl.protege.ui.message.MessageListCellRenderer;
import org.coode.oppl.protege.ui.rendering.VariableOWLCellRenderer;
import org.coode.oppl.utils.NamedVariableDetector;
import org.coode.oppl.validation.OPPLScriptValidator;
import org.coode.oppl.variabletypes.InputVariable;
import org.coode.parsers.ui.InputVerificationStatusChangedListener;
import org.coode.parsers.ui.VerifiedInputEditor;
import org.protege.editor.core.ui.list.MListSectionHeader;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.VerifyingOptionPane;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.event.EventType;
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.protege.editor.owl.ui.renderer.OWLCellRenderer;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLObject;

/**
 * @author Luigi Iannone
 */
public class OPPLBuilder extends JSplitPane
    implements VerifiedInputEditor, OWLModelManagerListener {

    private class OPPLConstraintList extends OPPLMList {

        private static final long serialVersionUID = 20100L;
        private final OWLEditorKit owlKit;
        private final ConstraintSystem constraintSystem;
        final OPPLBuilderModel model;
        private final MListSectionHeader HEADER = new MListSectionHeader() {

            @Override
            public String getName() {
                return "WHERE";
            }

            @Override
            public boolean canAdd() {
                return true;
            }
        };

        /**
         * @param owlEditorKit owlEditorKit
         * @param constraintSystem constraintSystem
         * @param model model
         */
        public OPPLConstraintList(OWLEditorKit owlEditorKit, ConstraintSystem constraintSystem,
            OPPLBuilderModel model) {
            owlKit = checkNotNull(owlEditorKit, "owlEditorKit");
            this.constraintSystem = checkNotNull(constraintSystem, "constraintSystem");
            this.model = model;
            clear();
        }

        @Override
        protected void handleEdit() {
            if (getSelectedValue() instanceof OPPLConstraintListItem) {
                OPPLConstraintListItem item = (OPPLConstraintListItem) getSelectedValue();
                final OPPLConstraintEditor editor =
                    new OPPLConstraintEditor(owlKit, constraintSystem);
                final AbstractConstraint oldConstraint = item.getConstraint();
                editor.setConstraint(oldConstraint);
                final VerifyingOptionPane optionPane =
                    new NoDefaultFocusVerifyingOptionPane(editor);
                final InputVerificationStatusChangedListener verificationListener =
                    verified -> optionPane.setOKEnabled(verified);
                editor.addStatusChangedListener(verificationListener);
                final JDialog dlg = optionPane.createDialog(owlKit.getWorkspace(), null);
                // The editor shouldn't be modal (or should it?)
                dlg.setModal(true);
                dlg.setTitle("Constraint editor");
                dlg.setResizable(true);
                dlg.pack();
                dlg.setLocationRelativeTo(owlKit.getWorkspace());
                dlg.addComponentListener(new ComponentAdapter() {

                    @Override
                    public void componentHidden(ComponentEvent e) {
                        Object retVal = optionPane.getValue();
                        if (retVal != null
                            && retVal.equals(Integer.valueOf(JOptionPane.OK_OPTION))) {
                            AbstractConstraint newConstraint = editor.getConstraint();
                            if (newConstraint != oldConstraint) {
                                model.removeConstraint(oldConstraint);
                                model.addConstraint(newConstraint);
                            }
                        }
                        editor.removeStatusChangedListener(verificationListener);
                        editor.dispose();
                    }
                });
                dlg.setVisible(true);
            }
        }

        @Override
        protected void handleDelete() {
            if (getSelectedValue() instanceof OPPLConstraintListItem) {
                OPPLConstraintListItem item = (OPPLConstraintListItem) getSelectedValue();
                model.removeConstraint(item.getConstraint());
            }
        }

        @Override
        protected void handleAdd() {
            final OPPLConstraintEditor editor = new OPPLConstraintEditor(owlKit, constraintSystem);
            final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(editor);
            final InputVerificationStatusChangedListener verificationListener =
                verified -> optionPane.setOKEnabled(verified);
            editor.addStatusChangedListener(verificationListener);
            final JDialog dlg = optionPane.createDialog(owlKit.getWorkspace(), null);
            // The editor shouldn't be modal (or should it?)
            dlg.setModal(true);
            dlg.setTitle("Constraint editor");
            dlg.setResizable(true);
            dlg.pack();
            dlg.setLocationRelativeTo(owlKit.getWorkspace());
            dlg.addComponentListener(new ComponentAdapter() {

                @Override
                public void componentHidden(ComponentEvent e) {
                    Object retVal = optionPane.getValue();
                    if (retVal != null && retVal.equals(Integer.valueOf(JOptionPane.OK_OPTION))) {
                        AbstractConstraint constraint = editor.getConstraint();
                        model.addConstraint(constraint);
                    }
                    editor.removeStatusChangedListener(verificationListener);
                    editor.dispose();
                }
            });
            dlg.setVisible(true);
        }

        public void clear() {
            setModel(new DefaultListModel());
            getDefaultModel().clear();
            getDefaultModel().addElement(HEADER);
        }
    }

    private final class SpecializedOPPLSelectClauseList extends OPPLSelectClauseList {

        private static final long serialVersionUID = 20100L;
        final OPPLBuilderModel model;

        SpecializedOPPLSelectClauseList(OWLEditorKit owlEditorKit,
            ConstraintSystem constraintSystem, OPPLBuilderModel model) {
            super(owlEditorKit, constraintSystem);
            this.model = model;
        }

        @Override
        protected void handleEdit() {
            if (getSelectedValue() instanceof OPPLSelectClauseListItem) {
                final OPPLSelectClauseListItem item = (OPPLSelectClauseListItem) getSelectedValue();
                final OPPLSelectClauseEditor editor =
                    new OPPLSelectClauseEditor(getOwlEditorKit(), getConstraintSystem());
                editor.setSelectListItem(item);
                final VerifyingOptionPane optionPane =
                    new NoDefaultFocusVerifyingOptionPane(editor);
                final InputVerificationStatusChangedListener verificationListener =
                    verified -> optionPane.setOKEnabled(verified);
                editor.addStatusChangedListener(verificationListener);
                final JDialog dlg = optionPane.createDialog(getOwlEditorKit().getWorkspace(), null);
                // The editor shouldn't be modal (or should it?)
                dlg.setModal(true);
                dlg.setTitle("Clause editor");
                dlg.setResizable(true);
                dlg.pack();
                dlg.setLocationRelativeTo(getOwlEditorKit().getWorkspace());
                dlg.addComponentListener(new ComponentAdapter() {

                    @Override
                    public void componentHidden(ComponentEvent e) {
                        Object retVal = optionPane.getValue();
                        if (retVal != null
                            && retVal.equals(Integer.valueOf(JOptionPane.OK_OPTION))) {
                            OPPLSelectClauseListItem newItem = editor.getSelectListItem();
                            if (item.isAsserted()) {
                                model.removeAssertedAxiom(item.getAxiom());
                            } else {
                                model.removePlainAxiom(item.getAxiom());
                            }
                            if (newItem.isAsserted()) {
                                model.addAddAssertedQueryAxiom(newItem.getAxiom());
                            } else {
                                model.addPlainQueryAxiom(newItem.getAxiom());
                            }
                        }
                        editor.removeStatusChangedListener(verificationListener);
                        editor.dispose();
                    }
                });
                dlg.setVisible(true);
            }
        }

        @Override
        protected void handleDelete() {
            if (getSelectedValue() instanceof OPPLSelectClauseListItem) {
                OPPLSelectClauseListItem item = (OPPLSelectClauseListItem) getSelectedValue();
                if (item.isAsserted()) {
                    model.removeAssertedAxiom(item.getAxiom());
                } else {
                    model.removePlainAxiom(item.getAxiom());
                }
            }
        }

        @Override
        protected void handleAdd() {
            final OPPLSelectClauseEditor editor =
                new OPPLSelectClauseEditor(getOwlEditorKit(), getConstraintSystem());
            final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(editor);
            final InputVerificationStatusChangedListener verificationListener =
                verified -> optionPane.setOKEnabled(verified);
            editor.addStatusChangedListener(verificationListener);
            final JDialog dlg = optionPane.createDialog(getOwlEditorKit().getWorkspace(), null);
            // The editor shouldn't be modal (or should it?)
            dlg.setModal(true);
            dlg.setTitle("Clause editor");
            dlg.setResizable(true);
            dlg.pack();
            dlg.setLocationRelativeTo(OPPLBuilder.this);
            dlg.addComponentListener(new ComponentAdapter() {

                @Override
                public void componentHidden(ComponentEvent e) {
                    Object retVal = optionPane.getValue();
                    if (retVal != null && retVal.equals(Integer.valueOf(JOptionPane.OK_OPTION))) {
                        OPPLSelectClauseListItem selectListItem = editor.getSelectListItem();
                        if (selectListItem.isAsserted()) {
                            model.addAddAssertedQueryAxiom(selectListItem.getAxiom());
                        } else {
                            model.addPlainQueryAxiom(selectListItem.getAxiom());
                        }
                    }
                    editor.removeStatusChangedListener(verificationListener);
                    editor.dispose();
                }
            });
            dlg.setVisible(true);
        }
    }

    private final class OPPLBuilderModel {

        private final class SpecializedConstraintVisitor implements ConstraintVisitorEx<Boolean> {

            class VariableFinder implements OPPLFunctionVisitorEx<Boolean> {
                @Override
                public <O, I> Boolean visitAggregation(Aggregation<O, I> aggregation) {
                    return Boolean
                        .valueOf(aggregation.toAggregate().flatMap(Aggregandum::opplFunctions)
                            .anyMatch(f -> f.accept(this).booleanValue()));
                }

                @Override
                public Boolean visitToLowerCaseStringManipulationOPPLFunction(
                    ToLowerCaseStringManipulationOPPLFunction f) {
                    return f.accept(this);
                }

                @Override
                public Boolean visitToUpperCaseStringManipulationOPPLFunction(
                    ToUpperCaseStringManipulationOPPLFunction f) {
                    return f.accept(this);
                }

                @Override
                public <O extends OWLObject> Boolean visitInlineSet(InlineSet<O> inlineSet) {
                    return Boolean
                        .valueOf(inlineSet.aggregandums().flatMap(Aggregandum::opplFunctions)
                            .anyMatch(f -> f.accept(this).booleanValue()));
                }

                @Override
                public <O> Boolean visitConstant(Constant<O> constant) {
                    return Boolean.valueOf(constant.getValue().equals(v));
                }

                @Override
                public <P extends OWLObject> Boolean visitGenericOPPLFunction(
                    OPPLFunction<P> opplFunction) {
                    return Boolean.FALSE;
                }

                @Override
                public <O, I extends OPPLFunction<?>> Boolean visitCreate(Create<I, O> create) {
                    return create.getInput().accept(this);
                }

                @Override
                public <O extends OWLObject> Boolean visitExpression(Expression<O> expression) {
                    return expression.getExpression().accept(variableDetector);
                }

                @Override
                public <O extends OWLObject> Boolean visitGroupVariableAttribute(
                    GroupVariableAttribute<O> a) {
                    return Boolean.valueOf(a.getVariable().equals(v));
                }

                @Override
                public Boolean visitIRIVariableAttribute(IRIVariableAttribute a) {
                    return Boolean.valueOf(a.getVariable().equals(v));
                }

                @Override
                public Boolean visitRenderingVariableAttribute(RenderingVariableAttribute r) {
                    return Boolean.valueOf(r.getVariable().equals(v));
                }

                @Override
                public <O extends OWLObject> Boolean visitValuesVariableAtttribute(
                    ValuesVariableAtttribute<O> r) {
                    return Boolean.valueOf(r.getVariable().equals(v));
                }
            }

            protected final Variable<?> v;
            protected final NamedVariableDetector variableDetector;

            SpecializedConstraintVisitor(Variable<?> v) {
                this.v = v;
                variableDetector = new NamedVariableDetector(this.v, getConstraintSystem());
            }

            @Override
            public Boolean visit(NAFConstraint nafConstraint) {
                return nafConstraint.getAxiom().accept(variableDetector);
            }

            @Override
            public Boolean visit(InCollectionConstraint<? extends OWLObject> c) {
                boolean toReturn = c.getVariable().equals(v);
                if (!toReturn) {
                    toReturn =
                        c.collection().anyMatch(o -> o.accept(variableDetector).booleanValue());
                }
                return Boolean.valueOf(toReturn);
            }

            @Override
            public Boolean visit(RegExpConstraint c) {
                return Boolean.valueOf(c.getVariable().equals(v)
                    || c.getExpression().accept(new VariableFinder()).booleanValue());
            }

            @Override
            public Boolean visit(InequalityConstraint c) {
                return Boolean.valueOf(c.getVariable().equals(v) || c.getExpression()
                    .accept(new NamedVariableDetector(v, getConstraintSystem())).booleanValue());
            }
        }

        public OPPLBuilderModel(OWLEditorKit owlEditorKit) {
            assert owlEditorKit != null;
            constraintSystem = ProtegeParserFactory.getInstance(getOWLEditorKit()).getOPPLFactory()
                .createConstraintSystem();
        }

        protected void removeConstraint(AbstractConstraint constraint) {
            boolean affected = constraints.remove(constraint);
            if (affected) {
                notifyBuilder();
            }
        }

        private final List<OWLAxiomChange> actions = new ArrayList<>();
        private final List<OWLAxiom> assertedQueryAxioms = new ArrayList<>();
        private final List<OWLAxiom> plainQueryAxioms = new ArrayList<>();
        private final List<AbstractConstraint> constraints = new ArrayList<>();
        protected final ConstraintSystem constraintSystem;
        private final List<Variable<?>> variables = new ArrayList<>();

        protected void addAction(OWLAxiomChange action) {
            boolean modified = actions.add(action);
            if (modified) {
                notifyBuilder();
            }
        }

        protected void addVariable(Variable<?> v) {
            boolean modified = variables.add(v);
            if (modified) {
                constraintSystem.importVariable(v);
                notifyBuilder();
            }
        }

        protected boolean check() {
            boolean enoughVariables = !variables.isEmpty();
            boolean enoughQueries = !assertedQueryAxioms.isEmpty() || !plainQueryAxioms.isEmpty()
                || !constraints.isEmpty();
            boolean enoughActions = !actions.isEmpty();
            boolean areThereMinimalElements = enoughVariables && (enoughQueries || enoughActions);
            OPPLScript builtOPPLScript = ProtegeParserFactory.getInstance(getOWLEditorKit())
                .getOPPLFactory()
                .buildOPPLScript(constraintSystem, getVariables(), getOPPLQuery(), getActions());
            boolean validated = test(enoughVariables, areThereMinimalElements, builtOPPLScript);
            return areThereMinimalElements && validated;
        }

        protected OPPLQuery getOPPLQuery() {
            OPPLQuery query = ProtegeParserFactory.getInstance(getOWLEditorKit()).getOPPLFactory()
                .buildNewQuery(getConstraintSystem());
            for (OWLAxiom axiom : getAssertedQueryAxioms()) {
                query.addAssertedAxiom(axiom);
            }
            for (OWLAxiom axiom : getPlainQueryAxioms()) {
                query.addAxiom(axiom);
            }
            for (AbstractConstraint constraint : getConstraints()) {
                query.addConstraint(constraint);
            }
            return query;
        }

        /**
         * @return the constraintSystem
         */
        public ConstraintSystem getConstraintSystem() {
            return constraintSystem;
        }

        /**
         * @return the variables
         */
        public List<Variable<?>> getVariables() {
            return new ArrayList<>(variables);
        }

        protected void notifyBuilder() {
            OPPLBuilder.this.handleChange();
        }

        private void purgeQuery(Variable<?> v) {
            purgeAssertedAxioms(v);
            purgePlainAxioms(v);
            purgeConstraints(v);
        }

        private void purgeConstraints(final Variable<?> v) {
            for (AbstractConstraint constraint : getConstraints()) {
                boolean affected =
                    constraint.accept(new SpecializedConstraintVisitor(v)).booleanValue();
                if (affected) {
                    constraints.remove(constraint);
                }
            }
        }

        private void purgePlainAxioms(Variable<?> v) {
            List<OWLAxiom> toRemove = new ArrayList<>();
            for (OWLAxiom axiom : plainQueryAxioms) {
                Set<Variable<?>> axiomVariables = getConstraintSystem().getAxiomVariables(axiom);
                if (axiomVariables.contains(v)) {
                    toRemove.add(axiom);
                }
            }
            plainQueryAxioms.removeAll(toRemove);
        }

        private void purgeAssertedAxioms(Variable<?> v) {
            List<OWLAxiom> toRemove = new ArrayList<>();
            for (OWLAxiom axiom : assertedQueryAxioms) {
                Set<Variable<?>> axiomVariables = getConstraintSystem().getAxiomVariables(axiom);
                if (axiomVariables.contains(v)) {
                    toRemove.add(axiom);
                }
            }
            assertedQueryAxioms.removeAll(toRemove);
        }

        /**
         * @param v v
         */
        private void purgeActions(Variable<?> v) {
            List<OWLAxiomChange> toRemove = new ArrayList<>();
            for (OWLAxiomChange action : actions) {
                OWLAxiom axiom = action.getAxiom();
                Set<Variable<?>> axiomVariables = getConstraintSystem().getAxiomVariables(axiom);
                if (axiomVariables.contains(v)) {
                    toRemove.add(action);
                }
            }
            actions.removeAll(toRemove);
        }

        protected void removeAction(OWLAxiomChange action) {
            boolean modified = actions.remove(action);
            if (modified) {
                notifyBuilder();
            }
        }

        protected void removeVariable(Variable<?> v) {
            boolean modified = variables.remove(v);
            if (modified) {
                purgeQuery(v);
                purgeActions(v);
                constraintSystem.removeVariable(v);
                notifyBuilder();
            }
        }

        protected void replaceVariable(Variable<?> oldVariable, Variable<?> newVariable) {
            boolean modified = variables.remove(oldVariable);
            if (modified) {
                if (oldVariable.getType() != newVariable.getType()) {
                    purgeActions(oldVariable);
                    purgeQuery(oldVariable);
                }
                variables.add(newVariable);
                constraintSystem.removeVariable(oldVariable);
                constraintSystem.importVariable(newVariable);
                notifyBuilder();
            }
        }

        protected void reset() {
            variables.clear();
            assertedQueryAxioms.clear();
            plainQueryAxioms.clear();
            constraints.clear();
            actions.clear();
            notifyBuilder();
        }

        /**
         * @return the assertedQueryAxioms
         */
        public List<OWLAxiom> getAssertedQueryAxioms() {
            return new ArrayList<>(assertedQueryAxioms);
        }

        protected void addPlainQueryAxiom(OWLAxiom axiom) {
            boolean modified = plainQueryAxioms.add(axiom);
            if (modified) {
                notifyBuilder();
            }
        }

        /**
         * @return the plainQueryAxioms
         */
        public List<OWLAxiom> getPlainQueryAxioms() {
            return new ArrayList<>(plainQueryAxioms);
        }

        protected void addAddAssertedQueryAxiom(OWLAxiom axiom) {
            boolean modified = assertedQueryAxioms.add(axiom);
            if (modified) {
                notifyBuilder();
            }
        }

        /**
         * @return the constraints
         */
        public List<AbstractConstraint> getConstraints() {
            return new ArrayList<>(constraints);
        }

        protected void addConstraint(AbstractConstraint constraint) {
            boolean modified = constraints.add(constraint);
            if (modified) {
                notifyBuilder();
            }
        }

        /**
         * @return the actions
         */
        public List<OWLAxiomChange> getActions() {
            return actions;
        }

        protected void importOPPLScript(OPPLScript script) {
            reset();
            variables.addAll(script.getVariables());
            constraintSystem.clearVariables();
            Set<Variable<?>> variablesToImport = script.getConstraintSystem().getVariables();
            for (Variable<?> variable : variablesToImport) {
                constraintSystem.importVariable(variable);
            }
            OPPLQuery query = script.getQuery();
            if (query != null) {
                plainQueryAxioms.addAll(query.getAxioms());
                assertedQueryAxioms.addAll(query.getAssertedAxioms());
                constraints.addAll(query.getConstraints());
            }
            actions.addAll(script.getActions());
            notifyBuilder();
        }

        protected void removeAssertedAxiom(OWLAxiom axiom) {
            boolean modified = assertedQueryAxioms.remove(axiom);
            if (modified) {
                notifyBuilder();
            }
        }

        protected void removePlainAxiom(OWLAxiom axiom) {
            boolean modified = plainQueryAxioms.remove(axiom);
            if (modified) {
                notifyBuilder();
            }
        }
    }

    private static final long serialVersionUID = 20100L;

    private class OPPLActionList extends ActionList {

        final OPPLBuilderModel model;

        public OPPLActionList(OWLEditorKit kit, OPPLBuilderModel m) {
            super(kit, m.getConstraintSystem(), true);
            model = m;
        }

        @Override
        protected void handleAdd() {
            final OWLAxiomChangeEditor actionEditor =
                new OWLAxiomChangeEditor(getOWLEditorKit(), model.getConstraintSystem());
            final VerifyingOptionPane optionPane =
                new NoDefaultFocusVerifyingOptionPane(actionEditor);
            final InputVerificationStatusChangedListener verificationListener =
                verified -> optionPane.setOKEnabled(verified);
            actionEditor.addStatusChangedListener(verificationListener);
            final JDialog dlg = optionPane.createDialog(getOWLEditorKit().getWorkspace(), null);
            // The editor shouldn't be modal (or should it?)
            dlg.setModal(true);
            dlg.setTitle("Action editor");
            dlg.setResizable(true);
            dlg.pack();
            dlg.setLocationRelativeTo(getOWLEditorKit().getWorkspace());
            dlg.addComponentListener(new ComponentAdapter() {

                @Override
                public void componentHidden(ComponentEvent e) {
                    Object retVal = optionPane.getValue();
                    if (retVal != null && retVal.equals(Integer.valueOf(JOptionPane.OK_OPTION))) {
                        OWLAxiomChange action = actionEditor.getOwlAxiomChange();
                        model.addAction(action);
                    }
                    actionEditor.removeStatusChangedListener(verificationListener);
                    actionEditor.dispose();
                }
            });
            dlg.setVisible(true);
        }

        @Override
        protected void handleDelete() {
            Object selectedValue = getSelectedValue();
            if (OPPLActionListItem.class.isAssignableFrom(selectedValue.getClass())) {
                OPPLActionListItem item = (OPPLActionListItem) selectedValue;
                OWLAxiomChange action = item.getAxiomChange();
                model.removeAction(action);
            }
        }

        @Override
        public void setConstraintSystem(ConstraintSystem constraintSystem) {
            setCellRenderer(new VariableOWLCellRenderer(getOWLEditorKit(), constraintSystem,
                new OWLCellRenderer(getOWLEditorKit())));
        }

        private static final long serialVersionUID = 20100L;
    }

    private class OPPLActionListItem extends ActionListItem {

        final OPPLBuilderModel model;
        private final OWLEditorKit kit;

        protected OPPLActionListItem(OWLAxiomChange axiomChange, boolean isEditable,
            boolean isDeleteable, OWLEditorKit kit, OPPLBuilderModel m) {
            super(axiomChange, isEditable, isDeleteable);
            this.kit = kit;
            model = m;
        }

        @Override
        public void handleEdit() {
            final OWLAxiomChangeEditor actionEditor =
                new OWLAxiomChangeEditor(kit, model.getConstraintSystem());
            actionEditor.setOWLAxiomChange(getAxiomChange());
            final VerifyingOptionPane optionPane =
                new NoDefaultFocusVerifyingOptionPane(actionEditor);
            final InputVerificationStatusChangedListener verificationListener =
                verified -> optionPane.setOKEnabled(verified);
            actionEditor.addStatusChangedListener(verificationListener);
            final JDialog dlg = optionPane.createDialog(kit.getWorkspace(), null);
            // The editor shouldn't be modal (or should it?)
            dlg.setModal(true);
            dlg.setTitle("Action editor");
            dlg.setResizable(true);
            dlg.pack();
            dlg.setLocationRelativeTo(kit.getWorkspace());
            dlg.addComponentListener(new ComponentAdapter() {

                @Override
                public void componentHidden(ComponentEvent e) {
                    Object retVal = optionPane.getValue();
                    if (retVal != null && retVal.equals(Integer.valueOf(JOptionPane.OK_OPTION))) {
                        OWLAxiomChange action = actionEditor.getOwlAxiomChange();
                        model.removeAction(OPPLActionListItem.this.getAxiomChange());
                        model.addAction(action);
                    }
                    actionEditor.removeStatusChangedListener(verificationListener);
                    actionEditor.dispose();
                }
            });
            dlg.setVisible(true);
        }
    }

    /**
     * @author Luigi Iannone
     */
    public class OPPLVariableListItem extends VariableListItem {

        protected final OPPLBuilderModel model;

        /**
         * @param variable variable
         * @param owlEditorKit owlEditorKit
         * @param isEditable isEditable
         * @param isDeleatable isDeleatable
         * @param m m
         */
        protected OPPLVariableListItem(Variable<?> variable, OWLEditorKit owlEditorKit,
            boolean isEditable, boolean isDeleatable, OPPLBuilderModel m) {
            super(variable, m.constraintSystem, owlEditorKit, isEditable, isDeleatable);
            model = m;
        }

        @Override
        public String getTooltip() {
            return getVariable().toString();
        }

        @Override
        public void handleEdit() {
            final ConstraintSystem cs = model.getConstraintSystem();
            final AbstractVariableEditor<?> variableEditor =
                getVariable().accept(new VariableVisitorEx<AbstractVariableEditor<?>>() {

                    @Override
                    public <P extends OWLObject> AbstractVariableEditor<?> visit(
                        InputVariable<P> v) {
                        VariableEditor ve = new VariableEditor(owlEditorKit, cs);
                        ve.setVariable(v);
                        return ve;
                    }

                    @Override
                    public <P extends OWLObject> AbstractVariableEditor<?> visit(
                        GeneratedVariable<P> v) {
                        GeneratedVariableEditor generatedVariableEditor =
                            new GeneratedVariableEditor(owlEditorKit, cs);
                        generatedVariableEditor.setVariable(v);
                        return generatedVariableEditor;
                    }

                    @Override
                    public <P extends OWLObject> AbstractVariableEditor<?> visit(
                        RegexpGeneratedVariable<P> regExpGenerated) {
                        RegExpVariableEditor regExpVariableEditor =
                            new RegExpVariableEditor(owlEditorKit, cs);
                        regExpVariableEditor.setVariable(regExpGenerated);
                        return regExpVariableEditor;
                    }
                });
            final VerifyingOptionPane optionPane =
                new NoDefaultFocusVerifyingOptionPane(variableEditor);
            final InputVerificationStatusChangedListener verificationListener =
                verified -> optionPane.setOKEnabled(verified);
            variableEditor.addStatusChangedListener(verificationListener);
            final JDialog dlg = optionPane.createDialog(getOwlEditorKit().getWorkspace(), null);
            // The editor shouldn't be modal (or should it?)
            dlg.setModal(true);
            dlg.setTitle(variableEditor.getEditorName());
            dlg.setResizable(true);
            dlg.pack();
            dlg.setLocationRelativeTo(getOwlEditorKit().getWorkspace());
            dlg.addComponentListener(new ComponentAdapter() {

                @Override
                public void componentHidden(ComponentEvent e) {
                    Object retVal = optionPane.getValue();
                    if (retVal != null && retVal.equals(Integer.valueOf(JOptionPane.OK_OPTION))) {
                        Variable<?> newVariable = variableEditor.getVariable();
                        Variable<?> oldVariable = OPPLVariableListItem.this.getVariable();
                        model.replaceVariable(oldVariable, newVariable);
                    }
                    variableEditor.removeStatusChangedListener(verificationListener);
                    variableEditor.dispose();
                    OPPLBuilder.this.handleChange();
                }
            });
            dlg.setVisible(true);
        }
    }

    private class OPPLVariableList extends VariableList {

        private static final long serialVersionUID = 20100L;
        protected final OPPLBuilderModel model;

        @Override
        protected void handleDelete() {
            Object selectedValue = getSelectedValue();
            if (OPPLVariableListItem.class.isAssignableFrom(selectedValue.getClass())) {
                OPPLVariableListItem item = (OPPLVariableListItem) selectedValue;
                model.removeVariable(item.getVariable());
            }
        }

        @Override
        protected void handleAdd() {
            final AbstractVariableEditor<?> variableEditor =
                getSelectedValue() instanceof InputVariableSectionHeader
                    ? new VariableEditor(getOWLEditorKit(), model.getConstraintSystem())
                    : new GeneratedVariableEditor(getOWLEditorKit(), model.getConstraintSystem());
            final VerifyingOptionPane optionPane =
                new NoDefaultFocusVerifyingOptionPane(variableEditor);
            final InputVerificationStatusChangedListener verificationListener =
                verified -> optionPane.setOKEnabled(verified);
            variableEditor.addStatusChangedListener(verificationListener);
            final JDialog dlg = optionPane.createDialog(getOWLEditorKit().getWorkspace(), null);
            // The editor shouldn't be modal (or should it?)
            dlg.setModal(true);
            dlg.setTitle(variableEditor.getEditorName());
            dlg.setResizable(true);
            dlg.pack();
            dlg.setLocationRelativeTo(OPPLBuilder.this);
            dlg.addComponentListener(new ComponentAdapter() {

                @Override
                public void componentHidden(ComponentEvent e) {
                    Object retVal = optionPane.getValue();
                    if (retVal != null && retVal.equals(Integer.valueOf(JOptionPane.OK_OPTION))) {
                        Variable<?> variable = variableEditor.getVariable();
                        model.addVariable(variable);
                    }
                    variableEditor.removeStatusChangedListener(verificationListener);
                    variableEditor.dispose();
                }
            });
            dlg.setVisible(true);
        }

        protected OPPLVariableList(OWLEditorKit owlEditorKit, OPPLBuilderModel model) {
            super(owlEditorKit, model.getConstraintSystem());
            getDefaultModel().addElement(new InputVariableSectionHeader());
            getDefaultModel().addElement(new GeneratedVariableSectionHeader());
            this.model = model;
        }

        protected void clear() {
            getDefaultModel().clear();
            getDefaultModel().addElement(new InputVariableSectionHeader());
            getDefaultModel().addElement(new GeneratedVariableSectionHeader());
        }

        /**
         * @param listItem listItem
         */
        protected void placeListItem(OPPLVariableListItem listItem) {
            int i = -1;
            if (listItem.getVariable() instanceof GeneratedVariable<?>) {
                i = getModel().getSize();
            } else {
                Enumeration<?> elements = getDefaultModel().elements();
                boolean found = false;
                while (!found && elements.hasMoreElements()) {
                    i++;
                    Object element = elements.nextElement();
                    found = element instanceof GeneratedVariableSectionHeader;
                }
                if (!found) {
                    throw new RuntimeException("Section lost");
                }
            }
            getDefaultModel().add(i, listItem);
        }
    }

    private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<>();
    protected final OWLEditorKit owlEditorKit;
    private final OPPLVariableList variableList;
    private final OPPLSelectClauseList selectList;
    private final OPPLConstraintList constraintList;
    private final ActionList actionList;
    private OPPLScript opplScript;
    private final OPPLScriptValidator validator;
    private final DefaultListModel errorListModel = new DefaultListModel();
    private final JList errorList = new JList(errorListModel);
    private final JPanel errorPanel = new JPanel(new BorderLayout());
    private final OPPLBuilderModel opplBuilderModel;

    protected OPPLBuilder(OWLEditorKit owlEditorKit) {
        this(owlEditorKit, null);
    }

    protected OPPLBuilder(OWLEditorKit owlEditorKit, OPPLScriptValidator validator) {
        this.owlEditorKit = checkNotNull(owlEditorKit, "owlEditorKit");
        this.validator = validator;
        opplBuilderModel = new OPPLBuilderModel(getOWLEditorKit());
        setOrientation(JSplitPane.VERTICAL_SPLIT);
        setPreferredSize(new Dimension(800, 600));
        JSplitPane builderPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        builderPane.setDividerLocation(.5);
        // Setup the variable list on the left
        // JPanel variablePanel = new JPanel(new BorderLayout());
        variableList = new OPPLVariableList(this.owlEditorKit, opplBuilderModel);
        // variablePanel.add(this.variableList);
        builderPane.add(ComponentFactory.createScrollPane(variableList), JSplitPane.LEFT);
        // Now setup the right hand side panel which will be further split into
        // queries and actions
        final JSplitPane queryActionSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        // Now setup the query split pane
        final JSplitPane queryConstraintSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        // Now the select part
        JPanel queryPanel = new JPanel(new BorderLayout());
        selectList = new SpecializedOPPLSelectClauseList(this.owlEditorKit,
            opplBuilderModel.getConstraintSystem(), opplBuilderModel);
        // this.selectList.getModel().addListDataListener(this.selectListListener);
        queryPanel.add(ComponentFactory.createScrollPane(selectList));
        // Now the constraints
        JPanel constraintPanel = new JPanel(new BorderLayout());
        constraintList = new OPPLConstraintList(this.owlEditorKit,
            opplBuilderModel.getConstraintSystem(), opplBuilderModel);
        // this.constraintList.getModel().addListDataListener(
        // this.constraintListListener);
        constraintPanel.add(ComponentFactory.createScrollPane(constraintList));
        queryConstraintSplitPane.add(queryPanel, JSplitPane.LEFT);
        queryConstraintSplitPane.add(constraintPanel, JSplitPane.RIGHT);
        // Now setup the action panel
        JPanel actionPanel = new JPanel(new BorderLayout());
        actionList = new OPPLActionList(this.owlEditorKit, opplBuilderModel);
        // this.actionList.getModel().addListDataListener(this.actionListListener);
        actionPanel.add(ComponentFactory.createScrollPane(actionList));
        queryActionSplitPane.add(queryConstraintSplitPane, JSplitPane.TOP);
        queryActionSplitPane.add(actionPanel, JSplitPane.BOTTOM);
        builderPane.add(queryActionSplitPane, JSplitPane.RIGHT);
        queryConstraintSplitPane.setDividerLocation(.5);
        queryConstraintSplitPane.setResizeWeight(.3);
        queryActionSplitPane.setDividerLocation(.5);
        queryActionSplitPane.setResizeWeight(.3);
        this.setDividerLocation(.5);
        setResizeWeight(.3);
        errorList.setCellRenderer(new MessageListCellRenderer());
        errorPanel.add(ComponentFactory.createScrollPane(errorList));
        errorPanel.setBorder(ComponentFactory.createTitledBorder("Errors:"));
        errorPanel.setPreferredSize(new Dimension(100, 500));
        this.add(errorPanel, JSplitPane.BOTTOM);
        this.add(builderPane, JSplitPane.TOP);
        builderPane.setDividerLocation(.5);
        builderPane.setResizeWeight(.3);
        this.setDividerLocation(.3);
        setResizeWeight(.3);
        getOWLEditorKit().getModelManager().addListener(this);
        opplBuilderModel.check();
    }

    protected boolean test(boolean enoughVariables, boolean areThereMinimalElements,
        OPPLScript builtOPPLScript) {
        if (!enoughVariables) {
            errorListModel.addElement(new Error("No variables "));
        }
        if (!areThereMinimalElements) {
            errorListModel.addElement(new Error(
                "The must be at least either one action, or one query, or one constraint"));
        }
        boolean validated = validator == null || validator.accept(builtOPPLScript);
        if (!validated) {
            errorListModel.addElement(
                new Error("Failed validation: " + validator.getValidationRuleDescription()));
        }
        return validated;
    }

    protected void handleChange() {
        opplScript = null;
        errorListModel.clear();
        boolean isValid = opplBuilderModel.check();
        if (isValid) {
            opplScript = ProtegeParserFactory.getInstance(getOWLEditorKit()).getOPPLFactory()
                .buildOPPLScript(opplBuilderModel.getConstraintSystem(),
                    opplBuilderModel.getVariables(), opplBuilderModel.getOPPLQuery(),
                    opplBuilderModel.getActions());
        }
        errorPanel.setVisible(!errorListModel.isEmpty());
        if (errorPanel.isVisible()) {
            this.setDividerLocation(.3);
        }
        notifyListeners(isValid);
        updateGUI();
    }

    private void updateGUI() {
        List<Variable<?>> variables = opplBuilderModel.getVariables();
        variableList.clear();
        for (Variable<?> variable : variables) {
            variableList.placeListItem(
                new OPPLVariableListItem(variable, owlEditorKit, true, true, opplBuilderModel));
        }
        selectList.clear();
        for (OWLAxiom axiom : opplBuilderModel.getAssertedQueryAxioms()) {
            selectList.getDefaultModel().addElement(new OPPLSelectClauseListItem(true, axiom));
        }
        for (OWLAxiom axiom : opplBuilderModel.getPlainQueryAxioms()) {
            selectList.getDefaultModel().addElement(new OPPLSelectClauseListItem(false, axiom));
        }
        constraintList.clear();
        List<AbstractConstraint> constraints = opplBuilderModel.getConstraints();
        for (AbstractConstraint constraint : constraints) {
            constraintList.getDefaultModel().addElement(new OPPLConstraintListItem(owlEditorKit,
                constraint, opplBuilderModel.getConstraintSystem()));
        }
        actionList.clear();
        List<OWLAxiomChange> actions = opplBuilderModel.getActions();
        for (OWLAxiomChange axiomChange : actions) {
            actionList.getDefaultModel().addElement(new OPPLActionListItem(axiomChange, true, true,
                getOWLEditorKit(), opplBuilderModel));
        }
    }

    private void notifyListeners(boolean status) {
        for (InputVerificationStatusChangedListener listener : listeners) {
            listener.verifiedStatusChanged(status);
        }
    }

    @Override
    public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
        listeners.add(listener);
        listener.verifiedStatusChanged(opplScript != null);
    }

    @Override
    public void removeStatusChangedListener(InputVerificationStatusChangedListener listener) {
        listeners.remove(listener);
    }

    /**
     * @return the opplScript
     */
    public OPPLScript getOPPLScript() {
        return opplScript;
    }

    /**
     * @param opplScript the opplScript to set
     */
    public void setOPPLScript(OPPLScript opplScript) {
        opplBuilderModel.importOPPLScript(opplScript);
    }

    protected void clear() {
        opplBuilderModel.reset();
    }

    @Override
    public String getName() {
        return "OPPL Builder";
    }

    @Override
    public void handleChange(OWLModelManagerChangeEvent event) {
        EventType type = event.getType();
        if (type.equals(EventType.REASONER_CHANGED)) {
            opplBuilderModel.getConstraintSystem()
                .setReasoner(getOWLEditorKit().getModelManager().getReasoner());
            this.handleChange();
        }
    }

    /**
     * @return the owlEditorKit
     */
    public OWLEditorKit getOWLEditorKit() {
        return owlEditorKit;
    }

    /** dispose listener */
    public void dispose() {
        getOWLEditorKit().getModelManager().removeListener(this);
    }
}
