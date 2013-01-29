package csveditor;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class CsvEditor extends JFrame implements ActionListener {
    final int MAXROW = 10000;
    String filename;
    String[][] data;
    String[] header;
    int  nRow;
    boolean modified = false;

    public CsvEditor(String _filename) throws Exception {
        this.filename = _filename;
        this.setTitle("CsvEditor " + filename);

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(true);
        toolBar.setMargin(new Insets(0,0,0,0));
        getContentPane().add(toolBar, BorderLayout.NORTH);

        JButton btnSave = new JButton(new ImageIcon("save02.png"));
        btnSave.setBorderPainted(false);
        btnSave.setMargin(new Insets(0,0,0,0));
        btnSave.setToolTipText("上書き保存");
        btnSave.setActionCommand("save");
        btnSave.addActionListener(this);
        toolBar.add(btnSave);
        
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we) { 
                saveData();
                System.exit(0);
            }
        });

        data = new String[MAXROW][];
        loadData();

        TableModel dataModel = new AbstractTableModel() {
            public int getColumnCount() { return header.length; }
            public int getRowCount()    { return nRow; }
            public boolean isCellEditable(int row, int col) { return true; }
            public void setValueAt(Object val, int row, int col) { 
                modified = true;
                data[row][col] = (String)val; 
            }
            public String getColumnName(int col) { return header[col]; }

            @Override
            public Object getValueAt(int i, int i1) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };

        JTable table = new JTable(dataModel);
        for (int col = 1; col < header.length; col++)
            setRightAlignment(table, col);
        JScrollPane pane = new JScrollPane(table);
        this.setSize(new Dimension(600, 300));
        JTableHeader jh = table.getTableHeader();
        jh.setFont(new Font(jh.getFont().getFamily(),Font.PLAIN,18));
        table.setFont(new Font(jh.getFont().getFamily(),Font.PLAIN,18));
        table.setRowHeight(22);
        JTextField Text = new JTextField(); 
        Text.setFont(new Font(jh.getFont().getFamily(), Font.PLAIN, 18)); 
        table.setDefaultEditor(Object.class, new DefaultCellEditor(Text)); 
        }

        public void actionPerformed(ActionEvent e) {
            saveData();
        }

        public void setRightAlignment(JTable table, int column) {
            DefaultTableCellRenderer r = new DefaultTableCellRenderer();
            r.setHorizontalAlignment(JLabel.RIGHT);
            table.getColumnModel().getColumn(column).setCellRenderer(r);
        }
        
        void loadData() throws Exception {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            header = line.split(",");
            for (nRow = 0; nRow < MAXROW && (line = br.readLine()) != null; nRow++) {
                data[nRow] = line.split(",");
            }
            br.close();
        }

        String format(String[] items) {
            String line = items[0];
            for (int col = 1; col < items.length; col++)
                line += "," + items[col];
            return line + "\n";
        }

        void saveData() {
            try { 
                BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
                bw.write(format(header));
                for (int row = 0; row < nRow; row++)
                    bw.write(format(data[row]));
                bw.close();
            } catch (Exception e) { 
                JOptionPane.showMessageDialog(null, "ファイル保存に失敗しました");
            }
        }

        public static void main(String[] args) throws Exception {
            new CsvEditor("/Users/square-free/NetBeansProjects/PostCodeSearchSystem/build/classes/PostCode.csv").setVisible(true);
        }
}
