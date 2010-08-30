package org.coode.patterns.protege.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import org.coode.oppl.utils.ArgCheck;
import org.protege.editor.core.ui.list.MListItem;
import org.protege.editor.core.ui.list.MListSectionHeader;

public class VariableListModel<I> implements ListModel {
	protected final static class MySectionHeader implements MListSectionHeader {
		final String header;
		boolean add = true;

		public MySectionHeader(String header) {
			ArgCheck.checkNullArgument("The section header", header);
			this.header = header;
		}

		public String getName() {
			return this.header;
		}

		public boolean canAdd() {
			return this.add;
		}
	}

	private final MySectionHeader myHeader;// = new MySectionHeader();

	public final static class VariableListItem<E> implements MListItem {
		private final E item;

		public E getItem() {
			return this.item;
		}

		public VariableListItem(E b) {
			ArgCheck.checkNullArgument("The element", b);
			this.item = b;
		}

		public String getTooltip() {
			return this.item.toString();
		}

		public boolean handleDelete() {
			return false;
		}

		public void handleEdit() {
		}

		public boolean isDeleteable() {
			return true;
		}

		public boolean isEditable() {
			return true;
		}
	}

	private final List<Object> delegate = new ArrayList<Object>();
	private final Set<ListDataListener> listeners = new HashSet<ListDataListener>();
	private final Collection<I> modelElements;

	public VariableListModel(Collection<I> elements, String sectionHeader) {
		this.modelElements = elements;
		this.myHeader = new MySectionHeader(sectionHeader);
		this.init();
	}

	public VariableListModel(Collection<I> elements, String sectionHeader,
			boolean canAdd) {
		this(elements, sectionHeader);
		this.myHeader.add = canAdd;
	}

	public void init() {
		this.delegate.clear();
		this.delegate.add(this.myHeader);
		for (I bm : this.modelElements) {
			this.delegate.add(new VariableListItem<I>(bm));
		}
		this.notifyListeners();
	}

	protected void notifyListeners() {
		ListDataEvent event = new ListDataEvent(this,
				ListDataEvent.CONTENTS_CHANGED, 0, this.delegate.size() - 1);
		for (ListDataListener l : this.listeners) {
			l.contentsChanged(event);
		}
	}

	public void addListDataListener(ListDataListener l) {
		ArgCheck.checkNullArgument("The listener", l);
		this.listeners.add(l);
	}

	public Object getElementAt(int index) {
		return this.delegate.get(index);
	}

	public int getSize() {
		return this.delegate.size();
	}

	public void removeListDataListener(ListDataListener l) {
		this.listeners.remove(l);
	}
}
