package org.coode.parsers.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import org.coode.parsers.utils.TokenFileSorter;

/** @author Luigi Iannone */
public class TokenGUI extends JFrame {
    private final TableCellRenderer tableCellRenderer = new TableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable t, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            DefaultTableCellRenderer defaultCellRenderer = new DefaultTableCellRenderer();
            if (t.getModel() instanceof TokenTableModel
                    && ((TokenTableModel) t.getModel()).getAnomalies().contains(
                            value.toString())) {
                defaultCellRenderer.setForeground(Color.RED);
            }
            Component toReturn = defaultCellRenderer.getTableCellRendererComponent(t,
                    value, isSelected, hasFocus, row, column);
            return toReturn;
        }
    };
    private static final long serialVersionUID = 20100L;
    private final File file;
    private final JTable table = new JTable();

    /** @param file */
    public TokenGUI(File file) {
        this.file = file;
        init();
        initGUI();
    }

    private void initGUI() {
        setLayout(new BorderLayout());
        JPanel summaryPanel = new JPanel();
        summaryPanel.add(new JLabel("Min unused index "
                + ((TokenTableModel) table.getModel()).getMinUnusedTokenIndex()));
        summaryPanel.add(new JLabel("Max unused index "
                + ((TokenTableModel) table.getModel()).getMaxUsedTokenIndex()));
        this.add(summaryPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(table), BorderLayout.CENTER);
        table.getColumn(TokenTableModel.TOKEN_NAME).setCellRenderer(tableCellRenderer);
    }

    private void init() {
        if (file.isDirectory()) {
            String[] list = file.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".tokens");
                }
            });
            List<TokenFileSorter> tokenFileSorters = new ArrayList<TokenFileSorter>(
                    list.length);
            for (String string : list) {
                tokenFileSorters
                        .add(new TokenFileSorter(new File(file, string).getPath()));
            }
            table.setModel(new TokenTableModel(tokenFileSorters));
        }
    }

    /** @param args */
    public static void main(String[] args) {
        TokenGUI frame = new TokenGUI(new File(args[0]));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
