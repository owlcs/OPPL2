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

public class TokenGUI extends JFrame {
    private final TableCellRenderer tableCellRenderer = new TableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            DefaultTableCellRenderer defaultCellRenderer = new DefaultTableCellRenderer();
            if (table.getModel() instanceof TokenTableModel
                    && ((TokenTableModel) table.getModel()).getAnomalies().contains(
                            value.toString())) {
                defaultCellRenderer.setForeground(Color.RED);
            }
            Component toReturn = defaultCellRenderer.getTableCellRendererComponent(table,
                    value, isSelected, hasFocus, row, column);
            return toReturn;
        }
    };
    
    private static final long serialVersionUID = -1567768111421668004L;
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
