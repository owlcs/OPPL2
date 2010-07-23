package org.coode.oppl.protege.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import org.coode.oppl.AbstractConstraint;
import org.coode.oppl.ConstraintVisitorEx;
import org.coode.oppl.InCollectionConstraint;
import org.coode.oppl.InCollectionRegExpConstraint;
import org.coode.oppl.InequalityConstraint;
import org.coode.oppl.OPPLQuery;
import org.coode.oppl.OPPLScript;
import org.coode.oppl.protege.ui.message.Error;
import org.coode.oppl.protege.ui.message.MessageListCellRenderer;
import org.coode.oppl.protege.ui.rendering.VariableOWLCellRenderer;
import org.coode.oppl.utils.NamedVariableDetector;
import org.coode.oppl.utils.ParserFactory;
import org.coode.oppl.validation.OPPLScriptValidator;
import org.coode.oppl.variablemansyntax.ConstraintSystem;
import org.coode.oppl.variablemansyntax.Variable;
import org.coode.oppl.variablemansyntax.bindingtree.BindingNode;
import org.coode.oppl.variablemansyntax.generated.SingleValueGeneratedVariable;
import org.protege.editor.core.ui.list.MList;
import org.protege.editor.core.ui.list.MListSectionHeader;
import org.protege.editor.core.ui.util.ComponentFactory;
import org.protege.editor.core.ui.util.InputVerificationStatusChangedListener;
import org.protege.editor.core.ui.util.VerifiedInputEditor;
import org.protege.editor.core.ui.util.VerifyingOptionPane;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.event.EventType;
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.protege.editor.owl.ui.renderer.OWLCellRenderer;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomChange;
import org.semanticweb.owl.model.OWLObject;

public class OPPLBuilder extends JSplitPane implements VerifiedInputEditor, OWLModelManagerListener {
	private class OPPLConstraintList extends MList {
		private static final long serialVersionUID = 4366866288573896156L;
		private final OWLEditorKit owlKit;
		private final ConstraintSystem constraintSystem;
		final OPPLBuilderModel model;
		private final MListSectionHeader HEADER = new MListSectionHeader() {
			public String getName() {
				return "WHERE";
			}

			public boolean canAdd() {
				return true;
			}
		};

		/**
		 * @param owlEditorKit
		 * @param constraintSystem
		 */
		public OPPLConstraintList(OWLEditorKit owlEditorKit, ConstraintSystem constraintSystem,
				OPPLBuilderModel model) {
			if (owlEditorKit == null) {
				throw new NullPointerException("The editorKit cannot be null");
			}
			if (constraintSystem == null) {
				throw new NullPointerException("The constraint system cannot be null");
			}
			this.owlKit = owlEditorKit;
			this.constraintSystem = constraintSystem;
			this.model = model;
			this.clear();
		}

		@Override
		protected void handleEdit() {
			if (this.getSelectedValue() instanceof OPPLConstraintListItem) {
				OPPLConstraintListItem item = (OPPLConstraintListItem) this.getSelectedValue();
				final OPPLConstraintEditor editor = new OPPLConstraintEditor(this.owlKit,
						this.constraintSystem);
				final AbstractConstraint oldConstraint = item.getConstraint();
				editor.setConstraint(oldConstraint);
				final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(editor);
				final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {
					public void verifiedStatusChanged(boolean verified) {
						optionPane.setOKEnabled(verified);
					}
				};
				editor.addStatusChangedListener(verificationListener);
				final JDialog dlg = optionPane.createDialog(this.owlKit.getWorkspace(), null);
				// The editor shouldn't be modal (or should it?)
				dlg.setModal(true);
				dlg.setTitle("Constraint editor");
				dlg.setResizable(true);
				dlg.pack();
				dlg.setLocationRelativeTo(this.owlKit.getWorkspace());
				dlg.addComponentListener(new ComponentAdapter() {
					@Override
					public void componentHidden(ComponentEvent e) {
						Object retVal = optionPane.getValue();
						if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
							AbstractConstraint newConstraint = editor.getConstraint();
							if (newConstraint != oldConstraint) {
								OPPLConstraintList.this.model.removeConstraint(oldConstraint);
								OPPLConstraintList.this.model.addConstraint(newConstraint);
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
			if (this.getSelectedValue() instanceof OPPLConstraintListItem) {
				OPPLConstraintListItem item = (OPPLConstraintListItem) this.getSelectedValue();
				this.model.removeConstraint(item.getConstraint());
			}
		}

		@Override
		protected void handleAdd() {
			final OPPLConstraintEditor editor = new OPPLConstraintEditor(this.owlKit,
					this.constraintSystem);
			final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(editor);
			final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {
				public void verifiedStatusChanged(boolean verified) {
					optionPane.setOKEnabled(verified);
				}
			};
			editor.addStatusChangedListener(verificationListener);
			final JDialog dlg = optionPane.createDialog(this.owlKit.getWorkspace(), null);
			// The editor shouldn't be modal (or should it?)
			dlg.setModal(true);
			dlg.setTitle("Constraint editor");
			dlg.setResizable(true);
			dlg.pack();
			dlg.setLocationRelativeTo(this.owlKit.getWorkspace());
			dlg.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentHidden(ComponentEvent e) {
					Object retVal = optionPane.getValue();
					if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
						AbstractConstraint constraint = editor.getConstraint();
						OPPLConstraintList.this.model.addConstraint(constraint);
					}
					editor.removeStatusChangedListener(verificationListener);
					editor.dispose();
				}
			});
			dlg.setVisible(true);
		}

		public void clear() {
			this.setModel(new DefaultListModel());
			((DefaultListModel) this.getModel()).clear();
			((DefaultListModel) this.getModel()).addElement(this.HEADER);
		}
	}

	private final class SpecializedOPPLSelectClauseList extends OPPLSelectClauseList {
		private static final long serialVersionUID = -567785735962335293L;
		final OPPLBuilderModel model;

		SpecializedOPPLSelectClauseList(OWLEditorKit owlEditorKit,
				ConstraintSystem constraintSystem, OPPLBuilderModel model) {
			super(owlEditorKit, constraintSystem);
			this.model = model;
		}

		@Override
		protected void handleEdit() {
			if (this.getSelectedValue() instanceof OPPLSelectClauseListItem) {
				final OPPLSelectClauseListItem item = (OPPLSelectClauseListItem) this.getSelectedValue();
				final OPPLSelectClauseEditor editor = new OPPLSelectClauseEditor(
						this.getOwlEditorKit(), this.getConstraintSystem());
				editor.setSelectListItem(item);
				final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(editor);
				final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {
					public void verifiedStatusChanged(boolean verified) {
						optionPane.setOKEnabled(verified);
					}
				};
				editor.addStatusChangedListener(verificationListener);
				final JDialog dlg = optionPane.createDialog(
						this.getOwlEditorKit().getWorkspace(),
						null);
				// The editor shouldn't be modal (or should it?)
				dlg.setModal(true);
				dlg.setTitle("Clause editor");
				dlg.setResizable(true);
				dlg.pack();
				dlg.setLocationRelativeTo(this.getOwlEditorKit().getWorkspace());
				dlg.addComponentListener(new ComponentAdapter() {
					@Override
					public void componentHidden(ComponentEvent e) {
						Object retVal = optionPane.getValue();
						if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
							OPPLSelectClauseListItem newItem = editor.getSelectListItem();
							if (item.isAsserted()) {
								SpecializedOPPLSelectClauseList.this.model.removeAssertedAxiom(item.getAxiom());
							} else {
								SpecializedOPPLSelectClauseList.this.model.removePlainAxiom(item.getAxiom());
							}
							if (newItem.isAsserted()) {
								SpecializedOPPLSelectClauseList.this.model.addAddAssertedQueryAxiom(newItem.getAxiom());
							} else {
								SpecializedOPPLSelectClauseList.this.model.addPlainQueryAxiom(newItem.getAxiom());
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
			if (this.getSelectedValue() instanceof OPPLSelectClauseListItem) {
				OPPLSelectClauseListItem item = (OPPLSelectClauseListItem) this.getSelectedValue();
				if (item.isAsserted()) {
					this.model.removeAssertedAxiom(item.getAxiom());
				} else {
					this.model.removePlainAxiom(item.getAxiom());
				}
			}
		}

		@Override
		protected void handleAdd() {
			final OPPLSelectClauseEditor editor = new OPPLSelectClauseEditor(
					this.getOwlEditorKit(), this.getConstraintSystem());
			final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(editor);
			final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {
				public void verifiedStatusChanged(boolean verified) {
					optionPane.setOKEnabled(verified);
				}
			};
			editor.addStatusChangedListener(verificationListener);
			final JDialog dlg = optionPane.createDialog(this.getOwlEditorKit().getWorkspace(), null);
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
					if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
						OPPLSelectClauseListItem selectListItem = editor.getSelectListItem();
						if (selectListItem.isAsserted()) {
							SpecializedOPPLSelectClauseList.this.model.addAddAssertedQueryAxiom(selectListItem.getAxiom());
						} else {
							SpecializedOPPLSelectClauseList.this.model.addPlainQueryAxiom(selectListItem.getAxiom());
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
			private final Variable v;

			SpecializedConstraintVisitor(Variable v) {
				this.v = v;
			}

			public Boolean visit(InCollectionConstraint<? extends OWLObject> c) {
				boolean toReturn = c.getVariable().equals(this.v);
				if (!toReturn) {
					Collection<? extends OWLObject> collection = c.getCollection();
					Iterator<? extends OWLObject> it = collection.iterator();
					NamedVariableDetector variableDetector = new NamedVariableDetector(this.v,
							OPPLBuilderModel.this.getConstraintSystem());
					boolean detected = false;
					while (!detected && it.hasNext()) {
						OWLObject object = it.next();
						detected = object.accept(variableDetector);
					}
					toReturn = detected;
				}
				return toReturn;
			}

			public Boolean visit(InCollectionRegExpConstraint c) {
				boolean toReturn = c.getVariable().equals(this.v);
				if (!toReturn) {
					if (OPPLBuilderModel.this.constraintSystem.getLeaves() != null) {
						for (BindingNode leave : OPPLBuilderModel.this.constraintSystem.getLeaves()) {
							Collection<? extends OWLObject> collection = c.getCollection(leave);
							Iterator<? extends OWLObject> it = collection.iterator();
							NamedVariableDetector variableDetector = new NamedVariableDetector(
									this.v, OPPLBuilderModel.this.getConstraintSystem());
							boolean detected = false;
							while (!detected && it.hasNext()) {
								OWLObject object = it.next();
								detected = object.accept(variableDetector);
							}
							toReturn = detected;
							if (toReturn) {
								return toReturn;
							}
						}
					}
				}
				return toReturn;
			}

			public Boolean visit(InequalityConstraint c) {
				Boolean accept = c.getExpression().accept(
						new NamedVariableDetector(this.v,
								OPPLBuilderModel.this.getConstraintSystem()));
				return c.getVariable().equals(this.v) || accept;
			}
		}

		public OPPLBuilderModel() {
		}

		protected void removeConstraint(AbstractConstraint constraint) {
			boolean affected = this.constraints.remove(constraint);
			if (affected) {
				this.notifyBuilder();
			}
		}

		private final List<OWLAxiomChange> actions = new ArrayList<OWLAxiomChange>();
		private final List<OWLAxiom> assertedQueryAxioms = new ArrayList<OWLAxiom>();
		private final List<OWLAxiom> plainQueryAxioms = new ArrayList<OWLAxiom>();
		private final List<AbstractConstraint> constraints = new ArrayList<AbstractConstraint>();
		private final ConstraintSystem constraintSystem = ParserFactory.getInstance().getOPPLFactory().createConstraintSystem();
		private final List<Variable> variables = new ArrayList<Variable>();

		protected void addAction(OWLAxiomChange action) {
			boolean modified = this.actions.add(action);
			if (modified) {
				this.notifyBuilder();
			}
		}

		protected void addVariable(Variable v) {
			boolean modified = this.variables.add(v);
			if (modified) {
				this.constraintSystem.importVariable(v);
				this.notifyBuilder();
			}
		}

		protected boolean check() {
			boolean enoughVariables = !this.variables.isEmpty();
			boolean enoughQueries = !this.assertedQueryAxioms.isEmpty()
					|| !this.plainQueryAxioms.isEmpty() || !this.constraints.isEmpty();
			boolean enoughActions = !this.actions.isEmpty();
			boolean areThereMinimalElements = enoughVariables && (enoughQueries || enoughActions);
			OPPLScript builtOPPLScript = ParserFactory.getInstance().getOPPLFactory().buildOPPLScript(
					this.constraintSystem,
					this.getVariables(),
					this.getOPPLQuery(),
					this.getActions());
			boolean validated = OPPLBuilder.this.test(
					enoughVariables,
					areThereMinimalElements,
					builtOPPLScript);
			return areThereMinimalElements && validated;
		}

		protected OPPLQuery getOPPLQuery() {
			OPPLQuery query = ParserFactory.getInstance().getOPPLFactory().buildNewQuery(
					this.getConstraintSystem());
			for (OWLAxiom axiom : this.getAssertedQueryAxioms()) {
				query.addAssertedAxiom(axiom);
			}
			for (OWLAxiom axiom : this.getPlainQueryAxioms()) {
				query.addAxiom(axiom);
			}
			for (AbstractConstraint constraint : this.getConstraints()) {
				query.addConstraint(constraint);
			}
			return query;
		}

		/**
		 * @return the constraintSystem
		 */
		public ConstraintSystem getConstraintSystem() {
			return this.constraintSystem;
		}

		/**
		 * @return the variables
		 */
		public List<Variable> getVariables() {
			return new ArrayList<Variable>(this.variables);
		}

		protected void notifyBuilder() {
			OPPLBuilder.this.handleChange();
		}

		private void purgeQuery(Variable v) {
			this.purgeAssertedAxioms(v);
			this.purgePlainAxioms(v);
			this.purgeConstraints(v);
		}

		private void purgeConstraints(final Variable v) {
			for (AbstractConstraint constraint : this.getConstraints()) {
				boolean affected = constraint.accept(new SpecializedConstraintVisitor(v));
				if (affected) {
					this.constraints.remove(constraint);
				}
			}
		}

		private void purgePlainAxioms(Variable v) {
			Set<OWLAxiom> toRemove = new HashSet<OWLAxiom>();
			for (OWLAxiom axiom : this.plainQueryAxioms) {
				Set<Variable> axiomVariables = this.getConstraintSystem().getAxiomVariables(axiom);
				if (axiomVariables.contains(v)) {
					toRemove.add(axiom);
				}
			}
			this.plainQueryAxioms.removeAll(toRemove);
		}

		private void purgeAssertedAxioms(Variable v) {
			Set<OWLAxiom> toRemove = new HashSet<OWLAxiom>();
			for (OWLAxiom axiom : this.assertedQueryAxioms) {
				Set<Variable> axiomVariables = this.getConstraintSystem().getAxiomVariables(axiom);
				if (axiomVariables.contains(v)) {
					toRemove.add(axiom);
				}
			}
			this.assertedQueryAxioms.removeAll(toRemove);
		}

		/**
		 * @param v
		 */
		private void purgeActions(Variable v) {
			Set<OWLAxiomChange> toRemove = new HashSet<OWLAxiomChange>();
			for (OWLAxiomChange action : this.actions) {
				OWLAxiom axiom = action.getAxiom();
				Set<Variable> axiomVariables = this.getConstraintSystem().getAxiomVariables(axiom);
				if (axiomVariables.contains(v)) {
					toRemove.add(action);
				}
			}
			this.actions.removeAll(toRemove);
		}

		protected void removeAction(OWLAxiomChange action) {
			boolean modified = this.actions.remove(action);
			if (modified) {
				this.notifyBuilder();
			}
		}

		protected void removeVariable(Variable v) {
			boolean modified = this.variables.remove(v);
			if (modified) {
				this.purgeQuery(v);
				this.purgeActions(v);
				this.constraintSystem.removeVariable(v);
				this.notifyBuilder();
			}
		}

		protected void replaceVariable(Variable oldVariable, Variable newVariable) {
			boolean modified = this.variables.remove(oldVariable);
			if (modified) {
				if (oldVariable.getType() != newVariable.getType()) {
					this.purgeActions(oldVariable);
					this.purgeQuery(oldVariable);
				}
				this.variables.add(newVariable);
				this.constraintSystem.removeVariable(oldVariable);
				this.constraintSystem.importVariable(newVariable);
				this.notifyBuilder();
			}
		}

		protected void reset() {
			this.variables.clear();
			this.assertedQueryAxioms.clear();
			this.plainQueryAxioms.clear();
			this.constraints.clear();
			this.actions.clear();
			this.notifyBuilder();
		}

		/**
		 * @return the assertedQueryAxioms
		 */
		public List<OWLAxiom> getAssertedQueryAxioms() {
			return new ArrayList<OWLAxiom>(this.assertedQueryAxioms);
		}

		protected void addPlainQueryAxiom(OWLAxiom axiom) {
			boolean modified = this.plainQueryAxioms.add(axiom);
			if (modified) {
				this.notifyBuilder();
			}
		}

		/**
		 * @return the plainQueryAxioms
		 */
		public List<OWLAxiom> getPlainQueryAxioms() {
			return new ArrayList<OWLAxiom>(this.plainQueryAxioms);
		}

		protected void addAddAssertedQueryAxiom(OWLAxiom axiom) {
			boolean modified = this.assertedQueryAxioms.add(axiom);
			if (modified) {
				this.notifyBuilder();
			}
		}

		/**
		 * @return the constraints
		 */
		public List<AbstractConstraint> getConstraints() {
			return new ArrayList<AbstractConstraint>(this.constraints);
		}

		protected void addConstraint(AbstractConstraint constraint) {
			boolean modified = this.constraints.add(constraint);
			if (modified) {
				this.notifyBuilder();
			}
		}

		/**
		 * @return the actions
		 */
		public List<OWLAxiomChange> getActions() {
			return this.actions;
		}

		protected void importOPPLScript(OPPLScript opplScript1) {
			this.reset();
			this.variables.addAll(opplScript1.getVariables());
			this.constraintSystem.clearVariables();
			Set<Variable> variablesToImport = opplScript1.getConstraintSystem().getVariables();
			for (Variable variable : variablesToImport) {
				this.constraintSystem.importVariable(variable);
			}
			this.plainQueryAxioms.addAll(opplScript1.getQuery().getAxioms());
			this.assertedQueryAxioms.addAll(opplScript1.getQuery().getAssertedAxioms());
			this.constraints.addAll(opplScript1.getQuery().getConstraints());
			this.actions.addAll(opplScript1.getActions());
			this.notifyBuilder();
		}

		protected void removeAssertedAxiom(OWLAxiom axiom) {
			boolean modified = this.assertedQueryAxioms.remove(axiom);
			if (modified) {
				this.notifyBuilder();
			}
		}

		protected void removePlainAxiom(OWLAxiom axiom) {
			boolean modified = this.plainQueryAxioms.remove(axiom);
			if (modified) {
				this.notifyBuilder();
			}
		}
	}

	private static final long serialVersionUID = -6106150715610094308L;

	private class OPPLActionList extends ActionList {
		final OPPLBuilderModel model;

		public OPPLActionList(OWLEditorKit kit, OPPLBuilderModel m) {
			super(kit, m.getConstraintSystem(), true);
			this.model = m;
		}

		@Override
		protected void handleAdd() {
			final OWLAxiomChangeEditor actionEditor = new OWLAxiomChangeEditor(
					OPPLBuilder.this.getOWLEditorKit(), this.model.getConstraintSystem());
			final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(
					actionEditor);
			final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {
				public void verifiedStatusChanged(boolean verified) {
					optionPane.setOKEnabled(verified);
				}
			};
			actionEditor.addStatusChangedListener(verificationListener);
			final JDialog dlg = optionPane.createDialog(
					OPPLBuilder.this.getOWLEditorKit().getWorkspace(),
					null);
			// The editor shouldn't be modal (or should it?)
			dlg.setModal(true);
			dlg.setTitle("Action editor");
			dlg.setResizable(true);
			dlg.pack();
			dlg.setLocationRelativeTo(OPPLBuilder.this.getOWLEditorKit().getWorkspace());
			dlg.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentHidden(ComponentEvent e) {
					Object retVal = optionPane.getValue();
					if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
						OWLAxiomChange action = actionEditor.getOwlAxiomChange();
						OPPLActionList.this.model.addAction(action);
					}
					actionEditor.removeStatusChangedListener(verificationListener);
					actionEditor.dispose();
				}
			});
			dlg.setVisible(true);
		}

		@Override
		protected void handleDelete() {
			Object selectedValue = this.getSelectedValue();
			if (OPPLActionListItem.class.isAssignableFrom(selectedValue.getClass())) {
				OPPLActionListItem item = (OPPLActionListItem) selectedValue;
				OWLAxiomChange action = item.getAxiomChange();
				this.model.removeAction(action);
			}
		}

		@Override
		public void setConstraintSystem(ConstraintSystem constraintSystem) {
			this.setCellRenderer(new VariableOWLCellRenderer(OPPLBuilder.this.getOWLEditorKit(),
					constraintSystem, new OWLCellRenderer(OPPLBuilder.this.getOWLEditorKit())));
		}

		private static final long serialVersionUID = -3297222035586803090L;
	}

	private class OPPLActionListItem extends ActionListItem {
		final OPPLBuilderModel model;
		private final OWLEditorKit kit;

		protected OPPLActionListItem(OWLAxiomChange axiomChange, boolean isEditable,
				boolean isDeleteable, OWLEditorKit kit, OPPLBuilderModel m) {
			super(axiomChange, isEditable, isDeleteable);
			this.kit = kit;
			this.model = m;
		}

		@Override
		public void handleEdit() {
			final OWLAxiomChangeEditor actionEditor = new OWLAxiomChangeEditor(this.kit,
					this.model.getConstraintSystem());
			actionEditor.setOWLAxiomChange(this.getAxiomChange());
			final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(
					actionEditor);
			final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {
				public void verifiedStatusChanged(boolean verified) {
					optionPane.setOKEnabled(verified);
				}
			};
			actionEditor.addStatusChangedListener(verificationListener);
			final JDialog dlg = optionPane.createDialog(this.kit.getWorkspace(), null);
			// The editor shouldn't be modal (or should it?)
			dlg.setModal(true);
			dlg.setTitle("Action editor");
			dlg.setResizable(true);
			dlg.pack();
			dlg.setLocationRelativeTo(this.kit.getWorkspace());
			dlg.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentHidden(ComponentEvent e) {
					Object retVal = optionPane.getValue();
					if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
						OWLAxiomChange action = actionEditor.getOwlAxiomChange();
						OPPLActionListItem.this.model.removeAction(OPPLActionListItem.this.getAxiomChange());
						OPPLActionListItem.this.model.addAction(action);
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
	 * 
	 */
	public class OPPLVariableListItem extends VariableListItem {
		final OPPLBuilderModel model;

		/**
		 * @param variable
		 * @param owlEditorKit
		 */
		protected OPPLVariableListItem(Variable variable, OWLEditorKit owlEditorKit,
				boolean isEditable, boolean isDeleatable, OPPLBuilderModel m) {
			super(variable, owlEditorKit, isEditable, isDeleatable);
			this.model = m;
		}

		/**
		 * @see org.protege.editor.core.ui.list.MListItem#getTooltip()
		 */
		@Override
		public String getTooltip() {
			return this.getVariable().toString();
		}

		/**
		 * @see org.protege.editor.core.ui.list.MListItem#handleEdit()
		 */
		@Override
		public void handleEdit() {
			ConstraintSystem cs = this.model.getConstraintSystem();
			final AbstractVariableEditor variableEditor = this.getVariable() instanceof SingleValueGeneratedVariable<?> ? new GeneratedVariableEditor(
					this.getOwlEditorKit(), cs)
					: new VariableEditor(this.getOwlEditorKit(), cs);
			variableEditor.setVariable(this.getVariable());
			final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(
					variableEditor);
			final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {
				public void verifiedStatusChanged(boolean verified) {
					optionPane.setOKEnabled(verified);
				}
			};
			variableEditor.addStatusChangedListener(verificationListener);
			final JDialog dlg = optionPane.createDialog(this.getOwlEditorKit().getWorkspace(), null);
			// The editor shouldn't be modal (or should it?)
			dlg.setModal(true);
			dlg.setTitle("Action editor");
			dlg.setResizable(true);
			dlg.pack();
			dlg.setLocationRelativeTo(this.getOwlEditorKit().getWorkspace());
			dlg.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentHidden(ComponentEvent e) {
					Object retVal = optionPane.getValue();
					if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
						Variable newVariable = variableEditor.getVariable();
						Variable oldVariable = OPPLVariableListItem.this.getVariable();
						OPPLVariableListItem.this.model.replaceVariable(oldVariable, newVariable);
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
		private static final long serialVersionUID = -2540053052502672472L;
		final OPPLBuilderModel model;

		@Override
		protected void handleDelete() {
			Object selectedValue = this.getSelectedValue();
			if (OPPLVariableListItem.class.isAssignableFrom(selectedValue.getClass())) {
				OPPLVariableListItem item = (OPPLVariableListItem) selectedValue;
				this.model.removeVariable(item.getVariable());
			}
		}

		@Override
		protected void handleAdd() {
			final AbstractVariableEditor variableEditor = this.getSelectedValue() instanceof InputVariableSectionHeader ? new VariableEditor(
					this.getOWLEditorKit(), this.model.getConstraintSystem())
					: new GeneratedVariableEditor(this.getOWLEditorKit(),
							this.model.getConstraintSystem());
			final VerifyingOptionPane optionPane = new NoDefaultFocusVerifyingOptionPane(
					variableEditor);
			final InputVerificationStatusChangedListener verificationListener = new InputVerificationStatusChangedListener() {
				public void verifiedStatusChanged(boolean verified) {
					optionPane.setOKEnabled(verified);
				}
			};
			variableEditor.addStatusChangedListener(verificationListener);
			final JDialog dlg = optionPane.createDialog(this.getOWLEditorKit().getWorkspace(), null);
			// The editor shouldn't be modal (or should it?)
			dlg.setModal(true);
			dlg.setTitle("Variable editor");
			dlg.setResizable(true);
			dlg.pack();
			dlg.setLocationRelativeTo(OPPLBuilder.this);
			dlg.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentHidden(ComponentEvent e) {
					Object retVal = optionPane.getValue();
					if (retVal != null && retVal.equals(JOptionPane.OK_OPTION)) {
						Variable variable = variableEditor.getVariable();
						OPPLVariableList.this.model.addVariable(variable);
					}
					variableEditor.removeStatusChangedListener(verificationListener);
					variableEditor.dispose();
				}
			});
			dlg.setVisible(true);
		}

		protected OPPLVariableList(OWLEditorKit owlEditorKit, OPPLBuilderModel model) {
			super(owlEditorKit, model.getConstraintSystem());
			((DefaultListModel) this.getModel()).addElement(new InputVariableSectionHeader());
			((DefaultListModel) this.getModel()).addElement(new GeneratedVariableSectionHeader());
			this.model = model;
		}

		protected void clear() {
			((DefaultListModel) this.getModel()).clear();
			((DefaultListModel) this.getModel()).addElement(new InputVariableSectionHeader());
			((DefaultListModel) this.getModel()).addElement(new GeneratedVariableSectionHeader());
		}

		/**
		 * @param listItem
		 */
		protected void placeListItem(OPPLVariableListItem listItem) {
			DefaultListModel m = (DefaultListModel) OPPLVariableList.this.getModel();
			int i = -1;
			if (listItem.getVariable() instanceof SingleValueGeneratedVariable<?>) {
				i = m.getSize();
			} else {
				Enumeration<?> elements = m.elements();
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
			m.add(i, listItem);
		}
	}

	private final Set<InputVerificationStatusChangedListener> listeners = new HashSet<InputVerificationStatusChangedListener>();
	private final OWLEditorKit owlEditorKit;
	private OPPLVariableList variableList;
	private OPPLSelectClauseList selectList;
	private OPPLConstraintList constraintList;
	private ActionList actionList;
	private OPPLScript opplScript;
	private final OPPLScriptValidator validator;
	private DefaultListModel errorListModel = new DefaultListModel();
	private final JList errorList = new JList(this.errorListModel);
	private final JPanel errorPanel = new JPanel(new BorderLayout());
	private final OPPLBuilderModel opplBuilderModel = new OPPLBuilderModel();

	protected OPPLBuilder(OWLEditorKit owlEditorKit) {
		this(owlEditorKit, null);
	}

	protected OPPLBuilder(OWLEditorKit owlEditorKit, OPPLScriptValidator validator) {
		if (owlEditorKit == null) {
			throw new NullPointerException("The editorKit cannot be null");
		}
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);
		this.setPreferredSize(new Dimension(800, 600));
		JSplitPane builderPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		builderPane.setDividerLocation(.5);
		this.owlEditorKit = owlEditorKit;
		this.validator = validator;
		// Setup the variable list on the left
		// JPanel variablePanel = new JPanel(new BorderLayout());
		this.variableList = new OPPLVariableList(this.owlEditorKit, this.opplBuilderModel);
		// variablePanel.add(this.variableList);
		builderPane.add(ComponentFactory.createScrollPane(this.variableList), JSplitPane.LEFT);
		// Now setup the right hand side panel which will be further split into
		// queries and actions
		final JSplitPane queryActionSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		// Now setup the query split pane
		final JSplitPane queryConstraintSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		// Now the select part
		JPanel queryPanel = new JPanel(new BorderLayout());
		this.selectList = new SpecializedOPPLSelectClauseList(this.owlEditorKit,
				this.opplBuilderModel.getConstraintSystem(), this.opplBuilderModel);
		// this.selectList.getModel().addListDataListener(this.selectListListener);
		queryPanel.add(ComponentFactory.createScrollPane(this.selectList));
		// Now the constraints
		JPanel constraintPanel = new JPanel(new BorderLayout());
		this.constraintList = new OPPLConstraintList(this.owlEditorKit,
				this.opplBuilderModel.getConstraintSystem(), this.opplBuilderModel);
		// this.constraintList.getModel().addListDataListener(
		// this.constraintListListener);
		constraintPanel.add(ComponentFactory.createScrollPane(this.constraintList));
		queryConstraintSplitPane.add(queryPanel, JSplitPane.LEFT);
		queryConstraintSplitPane.add(constraintPanel, JSplitPane.RIGHT);
		// Now setup the action panel
		JPanel actionPanel = new JPanel(new BorderLayout());
		this.actionList = new OPPLActionList(this.owlEditorKit, this.opplBuilderModel);
		// this.actionList.getModel().addListDataListener(this.actionListListener);
		actionPanel.add(ComponentFactory.createScrollPane(this.actionList));
		queryActionSplitPane.add(queryConstraintSplitPane, JSplitPane.TOP);
		queryActionSplitPane.add(actionPanel, JSplitPane.BOTTOM);
		builderPane.add(queryActionSplitPane, JSplitPane.RIGHT);
		queryConstraintSplitPane.setDividerLocation(.5);
		queryConstraintSplitPane.setResizeWeight(.3);
		queryActionSplitPane.setDividerLocation(.5);
		queryActionSplitPane.setResizeWeight(.3);
		this.setDividerLocation(.5);
		this.setResizeWeight(.3);
		this.errorList.setCellRenderer(new MessageListCellRenderer());
		this.errorPanel.add(ComponentFactory.createScrollPane(this.errorList));
		this.errorPanel.setBorder(ComponentFactory.createTitledBorder("Errors:"));
		this.errorPanel.setPreferredSize(new Dimension(100, 500));
		this.add(this.errorPanel, JSplitPane.BOTTOM);
		this.add(builderPane, JSplitPane.TOP);
		builderPane.setDividerLocation(.5);
		builderPane.setResizeWeight(.3);
		this.setDividerLocation(.3);
		this.setResizeWeight(.3);
		this.getOWLEditorKit().getModelManager().addListener(this);
		this.opplBuilderModel.check();
	}

	protected boolean test(boolean enoughVariables, boolean areThereMinimalElements,
			OPPLScript builtOPPLScript) {
		if (!enoughVariables) {
			this.errorListModel.addElement(new Error("No variables "));
		}
		if (!areThereMinimalElements) {
			this.errorListModel.addElement(new Error(
					"The must be at least either one action, or one query, or one constraint"));
		}
		boolean validated = this.validator == null || this.validator.accept(builtOPPLScript);
		if (!validated) {
			this.errorListModel.addElement(new Error("Failed validation: "
					+ this.validator.getValidationRuleDescription()));
		}
		return validated;
	}

	protected void handleChange() {
		this.opplScript = null;
		this.errorListModel.clear();
		boolean isValid = this.opplBuilderModel.check();
		if (isValid) {
			this.opplScript = ParserFactory.getInstance().getOPPLFactory().buildOPPLScript(
					this.opplBuilderModel.getConstraintSystem(),
					this.opplBuilderModel.getVariables(),
					this.opplBuilderModel.getOPPLQuery(),
					this.opplBuilderModel.getActions());
		}
		this.errorPanel.setVisible(!this.errorListModel.isEmpty());
		if (this.errorPanel.isVisible()) {
			this.setDividerLocation(.3);
		}
		this.notifyListeners(isValid);
		this.updateGUI();
	}

	private void updateGUI() {
		List<Variable> variables = this.opplBuilderModel.getVariables();
		this.variableList.clear();
		for (Variable variable : variables) {
			this.variableList.placeListItem(new OPPLVariableListItem(variable, this.owlEditorKit,
					true, true, this.opplBuilderModel));
		}
		this.selectList.clear();
		for (OWLAxiom axiom : this.opplBuilderModel.getAssertedQueryAxioms()) {
			((DefaultListModel) this.selectList.getModel()).addElement(new OPPLSelectClauseListItem(
					true, axiom));
		}
		for (OWLAxiom axiom : this.opplBuilderModel.getPlainQueryAxioms()) {
			((DefaultListModel) this.selectList.getModel()).addElement(new OPPLSelectClauseListItem(
					false, axiom));
		}
		this.constraintList.clear();
		List<AbstractConstraint> constraints = this.opplBuilderModel.getConstraints();
		for (AbstractConstraint constraint : constraints) {
			((DefaultListModel) this.constraintList.getModel()).addElement(new OPPLConstraintListItem(
					this.owlEditorKit, constraint, this.opplBuilderModel.getConstraintSystem()));
		}
		this.actionList.clear();
		List<OWLAxiomChange> actions = this.opplBuilderModel.getActions();
		for (OWLAxiomChange axiomChange : actions) {
			((DefaultListModel) this.actionList.getModel()).addElement(new OPPLActionListItem(
					axiomChange, true, true, this.getOWLEditorKit(), this.opplBuilderModel));
		}
	}

	private void notifyListeners(boolean status) {
		for (InputVerificationStatusChangedListener listener : this.listeners) {
			listener.verifiedStatusChanged(status);
		}
	}

	public void addStatusChangedListener(InputVerificationStatusChangedListener listener) {
		this.listeners.add(listener);
		listener.verifiedStatusChanged(this.opplScript != null);
	}

	public void removeStatusChangedListener(InputVerificationStatusChangedListener listener) {
		this.listeners.remove(listener);
	}

	/**
	 * @return the opplScript
	 */
	public OPPLScript getOPPLScript() {
		return this.opplScript;
	}

	/**
	 * @param opplScript
	 *            the opplScript to set
	 */
	public void setOPPLScript(OPPLScript opplScript) {
		this.opplBuilderModel.importOPPLScript(opplScript);
	}

	protected void clear() {
		this.opplBuilderModel.reset();
	}

	@Override
	public String getName() {
		return "OPPL Builder";
	}

	public void handleChange(OWLModelManagerChangeEvent event) {
		EventType type = event.getType();
		if (type.equals(EventType.REASONER_CHANGED)) {
			this.opplBuilderModel.getConstraintSystem().setReasoner(
					this.getOWLEditorKit().getModelManager().getReasoner());
			this.handleChange();
		}
	}

	/**
	 * @return the owlEditorKit
	 */
	public OWLEditorKit getOWLEditorKit() {
		return this.owlEditorKit;
	}

	public void dispose() {
		this.getOWLEditorKit().getModelManager().removeListener(this);
	}
}
