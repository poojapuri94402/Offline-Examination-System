
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adminui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.dao.TestInfoDao;
import model.to.TestInfoTo;

/**
 *
 * @author POOJA PURI
 */
public class ViewExamDetail extends javax.swing.JInternalFrame {

    private String username;
    
    /**
     * Creates new form ViewExamDetail
     */
    List<TestInfoTo> tests;
    private JPopupMenu popupmenu;
    private int row;
    public ViewExamDetail(String username) {
        this();
        this.username = username;
    }
    public ViewExamDetail() {
        initComponents();
         bindtableTestInfo();
             row=-1;
        popupmenu=new JPopupMenu();
        JMenuItem jmiDelete=new JMenuItem("Delete This Record");
        JMenuItem jmiEdit=new JMenuItem("Edit This Record");  
        jmiDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRecord();
            }
        });
        popupmenu.add(jmiDelete);
        jmiEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editrecord();
            }
        });
        popupmenu.add(jmiEdit);
    }
    private void editrecord(){
        if(row!=-1&&tests!=null&&row<tests.size()){
        TestInfoTo tit=tests.get(row);
        AddTestInfo ati=new AddTestInfo(tit.getTestID(),username);
        ati.setVisible(true);
        getDesktopPane().add(ati);
        try{
            ati.setSelected(true);
        }catch(PropertyVetoException ex){
            
        }
            dispose();
        }
        }
    private void deleteRecord(){
        if(row!=-1&&tests!=null&&row<tests.size()){
            int result=JOptionPane.showConfirmDialog(this, "Are you Sure You Want To Delete This Information ?","Message From The System",JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION){
               String message="";
               TestInfoTo tit=tests.get(row);
               if(tit!=null){
                   TestInfoDao action=new TestInfoDao();
                   if(action.deleteRecord(String.valueOf(tit.getTestID()))){
                       message="Selected Test Information Is Deleted";
                       bindtableTestInfo();
                   }else{
                       message=action.getErrormessage();
                   }
                   JOptionPane.showMessageDialog(this, message);
               }
            }
        }
        row=-1;
    }
    public void bindtableTestInfo(){
    tests=new TestInfoDao().getAllRecord();
    String[] colnames={"Test ID","Test Name","Subject ID","Test Level","Total Questions","UserName"};
    Object[][] records=null;
    if(tests!=null&& tests.size()>0){
        records=new Object[tests.size()][colnames.length];
        int i=0;
        for(TestInfoTo tit: tests){
            records[i]=new Object[]{tit.getTestID(),tit.getTestName(),tit.getSubjectID(),tit.getTestLevel(),tit.getTotalQuestion(),tit.getUserName()};
            i++;
        }
    }else{
        records=new Object[1][colnames.length];
        records[0]=new Object[]{"No record","No record","No record","No record","No record","No record"};
    }
    DefaultTableModel dtm=new DefaultTableModel(records, colnames){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
       };
    tableexamde.getTableHeader().setReorderingAllowed(false);
    tableexamde.setAutoCreateRowSorter(true);
    tableexamde.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableexamde = new javax.swing.JTable();
        btnrefreshdetail = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("ES:VIEW EXAM DETAIL");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Adminui/ex.png"))); // NOI18N

        tableexamde.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableexamde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableexamdeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableexamde);

        btnrefreshdetail.setFont(new java.awt.Font("Jokerman", 1, 36)); // NOI18N
        btnrefreshdetail.setText("REFRESH");
        btnrefreshdetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshdetailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(btnrefreshdetail, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnrefreshdetail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnrefreshdetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshdetailActionPerformed
         bindtableTestInfo();
    }//GEN-LAST:event_btnrefreshdetailActionPerformed

    private void tableexamdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableexamdeMouseClicked
        if(evt.getButton()==MouseEvent.BUTTON3){
            int rowpoint=tableexamde.rowAtPoint(evt.getPoint());
            tableexamde.getSelectionModel().setSelectionInterval(rowpoint, rowpoint);
            popupmenu.show(tableexamde,evt.getX(),evt.getY());
            row=tableexamde.getSelectedRow();
        }
    }//GEN-LAST:event_tableexamdeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnrefreshdetail;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableexamde;
    // End of variables declaration//GEN-END:variables
}
