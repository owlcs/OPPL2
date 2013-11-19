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

/** @author Luigi Iannone
 * @param <I> */
public class VariableListModel<I> implements ListModel<Object> {
    protected final static class MySectionHeader implements MListSectionHeader {
        final String header;
        boolean add = true;

        public MySectionHeader(String header) {
            ArgCheck.checkNullArgument("The section header", header);
            this.header = header;
        }

        @Override
        public String getName() {
            return this.header;
        }

        @Override
        public boolean canAdd() {
            return this.add;
        }
    }

    private final MySectionHeader myHeader;// = new MySectionHeader();

    /** @author Luigi Iannone
     * @param <E> */
    public final static class VariableListItem<E> implements MListItem {
        private final E item;

        /** @return item */
        public E getItem() {
            return this.item;
        }

        /** @param b */
        public VariableListItem(E b) {
            ArgCheck.checkNullArgument("The element", b);
            this.item = b;
        }

        @Override
        public String getTooltip() {
            return this.item.toString();
        }

        @Override
        public boolean handleDelete() {
            return false;
        }

        @Override
        public void handleEdit() {}

        @Override
        public boolean isDeleteable() {
            return true;
        }

        @Override
        public boolean isEditable() {
            return true;
        }
    }

    private final List<Object> delegate = new ArrayList<Object>();
    private final Set<ListDataListener> listeners = new HashSet<ListDataListener>();
    private final Collection<I> modelElements;

    /** @param elements
     * @param sectionHeader */
    public VariableListModel(Collection<I> elements, String sectionHeader) {
        this.modelElements = elements;
        this.myHeader = new MySectionHeader(sectionHeader);
        this.init();
    }

    /** @param elements
     * @param sectionHeader
     * @param canAdd */
    public VariableListModel(Collection<I> elements, String sectionHeader, boolean canAdd) {
        this(elements, sectionHeader);
        this.myHeader.add = canAdd;
    }

    /** init */
    public void init() {
        this.delegate.clear();
        this.delegate.add(this.myHeader);
        for (I bm : this.modelElements) {
            this.delegate.add(new VariableListItem<I>(bm));
        }
        this.notifyListeners();
    }

    protected void notifyListeners() {
        ListDataEvent event = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0,
                this.delegate.size() - 1);
        for (ListDataListener l : this.listeners) {
            l.contentsChanged(event);
        }
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        ArgCheck.checkNullArgument("The listener", l);
        this.listeners.add(l);
    }

    @Override
    public Object getElementAt(int index) {
        return this.delegate.get(index);
    }

    @Override
    public int getSize() {
        return this.delegate.size();
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.listeners.remove(l);
    }
}
