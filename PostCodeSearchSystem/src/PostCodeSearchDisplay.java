
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Norihiro Kajita
 */
public class PostCodeSearchDisplay extends javax.swing.JFrame implements ActionListener {

    private final static String POST_CODE_FILE = "/Users/square-free/NetBeansProjects/PostCodeSearchSystem/build/classes/PostCode.csv";

    /**
     * Creates new form PostCodeSearchDisplay
     */
    public PostCodeSearchDisplay() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        modeBtnGrp = new javax.swing.ButtonGroup();
        searchWordTxtBox = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();
        searchResultTbl = new javax.swing.JTable();
        searchModeBtn = new javax.swing.JRadioButton();
        addModeBtn = new javax.swing.JRadioButton();
        deleteModeBtn = new javax.swing.JRadioButton();
        updateBtn = new javax.swing.JButton();
        addRowBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchWordTxtBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchWordTxtBoxKeyPressed(evt);
            }
        });

        searchResultTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "郵便番号", "住所"
            }
        ));
        DefaultTableModel defTable = (DefaultTableModel) searchResultTbl.getModel();
        scrollPane.setViewportView(searchResultTbl);

        modeBtnGrp.add(searchModeBtn);
        searchModeBtn.setSelected(true);
        searchModeBtn.setText("照会");
        searchModeBtn.setName("Search"); // NOI18N
        searchModeBtn.addActionListener(this);

        modeBtnGrp.add(addModeBtn);
        addModeBtn.setText("追加");
        addModeBtn.addActionListener(this);

        modeBtnGrp.add(deleteModeBtn);
        deleteModeBtn.setText("削除");
        deleteModeBtn.addActionListener(this);

        updateBtn.setText("更新");
        updateBtn.setEnabled(false);
        updateBtn.setVisible(false);
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        addRowBtn.setText("行追加");
        addRowBtn.setEnabled(false);
        addRowBtn.setVisible(false);

        exitBtn.setText("終了");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        clearBtn.setText("クリア");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(52, 52, 52)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(searchModeBtn)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(addModeBtn)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(deleteModeBtn)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(addRowBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(updateBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(clearBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(exitBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(scrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .add(searchWordTxtBox))
                        .add(46, 46, 46))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(searchModeBtn)
                    .add(deleteModeBtn)
                    .add(addModeBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(searchWordTxtBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(scrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 297, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(updateBtn)
                    .add(exitBtn)
                    .add(clearBtn)
                    .add(addRowBtn))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchWordTxtBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchWordTxtBoxKeyPressed

        // 入力されたキーを取得
        int keycode = evt.getKeyCode();

        // Enterキーを入力した場合
        if (keycode == KeyEvent.VK_ENTER) {

            // ファイルオブジェクト
            File objFile = new File(POST_CODE_FILE);

            // ファイル読み込みを行うクラスのインスタンス生成
            PostCodeFileSearcher postCodeFile = new PostCodeFileSearcher(POST_CODE_FILE, searchWordTxtBox.getText());

            try {

                // ファイルが存在しない場合
                if (objFile.exists() == false) {
                    // 警告メッセージを出力
                    JOptionPane.showMessageDialog(this, "ファイルが存在しません。", "Worn", JOptionPane.WARNING_MESSAGE);

                    // ファイルが読み書きできない場合
                } else if (objFile.canWrite() == false || objFile.canRead() == false) {

                    // 警告メッセージを出力
                    JOptionPane.showMessageDialog(this, "ファイルの読み書きができません。", "Worn", JOptionPane.WARNING_MESSAGE);

                    // 該当データが存在しない場合
                } else if (postCodeFile.getRowNum() == 0) {

                    // 警告メッセージを出力
                    JOptionPane.showMessageDialog(this, "該当データが存在しません。", "Worn", JOptionPane.WARNING_MESSAGE);

                    // 該当データが存在する場合
                } else {

                    // デフォルトテーブルを定義
                    DefaultTableModel defTable = (DefaultTableModel) searchResultTbl.getModel();

                    // 行数を設定
                    defTable.setRowCount(postCodeFile.getRowNum());

                    // 読み込んだデータを取得する
                    List<String[]> postCodeData = postCodeFile.getFileData();

                    for (int cntRow = 0; cntRow < postCodeData.size(); cntRow++) {
                        for (int countColumn = 0; countColumn < postCodeData.get(cntRow).length; countColumn++) {
                            searchResultTbl.setValueAt(postCodeData.get(cntRow)[countColumn], cntRow, countColumn);
                        }
                    }
                    
                    if (deleteModeBtn.isSelected() == true){
                        updateBtn.setVisible(true);
                        updateBtn.setEnabled(true);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            
        }

    }//GEN-LAST:event_searchWordTxtBoxKeyPressed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
    	
        if (addModeBtn.isSelected() == true) {
            // デフォルトテーブルを定義
            DefaultTableModel defTable = (DefaultTableModel) searchResultTbl.getModel();
            String[] columnFactor = new String[defTable.getColumnCount()];
            PostCodeFileEditor fileWriter = new PostCodeFileEditor(POST_CODE_FILE);
            
            for (int cntRow = 0; cntRow < defTable.getRowCount(); cntRow++){
                
                for (int cntCol = 0; cntCol < defTable.getColumnCount(); cntCol++){
                    columnFactor[cntCol] = (String) defTable.getValueAt(cntRow, cntCol);
                	if (columnFactor[cntCol] == null || columnFactor[cntCol].length() < 1){
                		columnFactor[cntCol] = "";
                	}
                }

                fileWriter.addData(columnFactor);
            	
            }
        	
            // モードを"照会"にする。
            searchModeBtn.setSelected(true);
        	
        	
            // 警告メッセージを出力
            JOptionPane.showMessageDialog(this, "追加処理を完了しました。", "更新完了", JOptionPane.PLAIN_MESSAGE);
            
            clearBtn.doClick();
        }
    	
    	if (deleteModeBtn.isSelected() == true) {
    		
            // デフォルトテーブルを定義
            DefaultTableModel defTable = (DefaultTableModel) searchResultTbl.getModel();
            PostCodeFileEditor fileWriter = new PostCodeFileEditor(POST_CODE_FILE);
            String[][] selectedData = new String[searchResultTbl.getSelectedRowCount()][defTable.getColumnCount()];
            int selectedRow;
    		
            if (searchResultTbl.getSelectedColumnCount() > 0){
                for (int cntRow = 0; cntRow < searchResultTbl.getSelectedRowCount(); cntRow++){
                    selectedRow = searchResultTbl.getSelectedRows()[cntRow];
                    for (int cntCol = 0 ; cntCol < defTable.getColumnCount() ; cntCol ++){
                        selectedData[cntRow][cntCol] = (String) defTable.getValueAt(selectedRow, cntCol);
                    }
                }
    			
    		fileWriter.deleteData(selectedData);
    			
                // モードを"照会"にする。
        	searchModeBtn.setSelected(true);
        	
        	// 警告メッセージを出力
                JOptionPane.showMessageDialog(this, "削除処理を完了しました。", "更新完了", JOptionPane.PLAIN_MESSAGE);
    		
                clearBtn.doClick();
            }
    	}    	
    }//GEN-LAST:event_updateBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        
        System.exit(0); 
    }//GEN-LAST:event_exitBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        
        // 各項目のクリア
        searchModeBtn.setSelected(true);
        
        searchWordTxtBox.setEnabled(true);
        searchWordTxtBox.setText(null);
        
        DefaultTableModel defTable = (DefaultTableModel) searchResultTbl.getModel();
        defTable.setRowCount(0);
        
        updateBtn.setEnabled(false);
        updateBtn.setVisible(false);

        addRowBtn.setEnabled(false);
        addRowBtn.setVisible(false);
        
    }//GEN-LAST:event_clearBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PostCodeSearchDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PostCodeSearchDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PostCodeSearchDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PostCodeSearchDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PostCodeSearchDisplay().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton addModeBtn;
    private javax.swing.JButton addRowBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JRadioButton deleteModeBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.ButtonGroup modeBtnGrp;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JRadioButton searchModeBtn;
    private javax.swing.JTable searchResultTbl;
    private javax.swing.JTextField searchWordTxtBox;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {

        // デフォルトテーブルを定義
        DefaultTableModel defTable = (DefaultTableModel) searchResultTbl.getModel();

        searchWordTxtBox.setText(null);
        defTable.setRowCount(0);

        if (searchModeBtn.isSelected() == true) {
            searchWordTxtBox.setEnabled(true);
            
            updateBtn.setVisible(false);
            updateBtn.setEnabled(false);

        } else if (addModeBtn.isSelected() == true) {
            searchWordTxtBox.setEnabled(false);

            // 行数を設定
            defTable.setRowCount(10);
            updateBtn.setVisible(true);
            updateBtn.setEnabled(true);

        } else if (deleteModeBtn.isSelected() == true) {
            searchWordTxtBox.setEnabled(true);
            searchResultTbl.setDefaultEditor(Object.class, null);
            
            updateBtn.setVisible(true);
            updateBtn.setEnabled(false);

        }
    }
}
