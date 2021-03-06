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
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.dao.SubjectInfoDao;
import model.to.SubjectInfoTo;

/**
 *
 * @author POOJA PURI
 */
public class ViewSubjectInfo extends javax.swing.JInternalFrame {

    List<SubjectInfoTo> subjects;
    private JPopupMenu popupmenu;
    private int row;
    public ViewSubjectInfo() {
        initComponents();
        bindtableSubjectInfo();
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
                editRecord();
            }
        });
        popupmenu.add(jmiEdit);
    }
    private void editRecord(){
        if(row!=-1&&subjects!=null&&row<subjects.size()){
            SubjectInfoTo sit=subjects.get(row);
            AddSubjectInfo asi=new AddSubjectInfo(sit);
            asi.setVisible(true);
            getDesktopPane().add(asi);
            try{
                asi.setSelected(true);
                }catch(PropertyVetoException ex){
                    
                }
            dispose();
        }
    }
    private void deleteRecord(){
        if(row!=-1&&subjects!=null&&row<subjects.size()){
            int result=JOptionPane.showConfirmDialog(this, "Are you Sure You Want To Delete This Information ?","Message From The System",JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION){
               String message="";
               SubjectInfoTo sit=subjects.get(row);
               if(sit!=null){
                   SubjectInfoDao action=new SubjectInfoDao();
                   if(action.deleteRecord(sit.getSubjectId())){
                       message="Selected Subject Information Is Deleted";
                       bindtableSubjectInfo();
                   }else{
                       message=action.getErrormessage();
                   }
                   JOptionPane.showMessageDialog(this, message);
               }
            }
        }
        row=-1;
    }
    
    public void bindtableSubjectInfo(){
    subjects=new SubjectInfoDao().getAllRecord();
    String[] colnames={"Subject ID","Subject Name","Description"};
    Object[][] records=null;
    if(subjects!=null&& subjects.size()>0){
        records=new Object[subjects.size()][colnames.length];
        int i=0;
        for(SubjectInfoTo sit: subjects){
            records[i]=new Object[]{sit.getSubjectId(),sit.getSubjectName(),sit.getDescription()};
            i++;
        }
    }else{
        records=new Object[1][colnames.length];
        records[0]=new Object[]{"No record","No record","No record"};
    }
    DefaultTableModel dtm=new DefaultTableModel(records, colnames){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
       };
    tableSubjectInfo.getTableHeader().setReorderingAllowed(false);
    tableSubjectInfo.setAutoCreateRowSorter(true);
    tableSubjectInfo.setModel(dtm);
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
        tableSubjectInfo = new javax.swing.JTable();
        btnrefresh = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("ES:VIEW SUBJECT INFORMATION");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Adminui/ex.png"))); // NOI18N

        tableSubjectInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        tableSubjectInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSubjectInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSubjectInfo);

        btnrefresh.setFont(new java.awt.Font("Jokerman", 1, 36)); // NOI18N
        btnrefresh.setForeground(new java.awt.Color(255, 51, 51));
        btnrefresh.setText("Refresh");
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnrefresh)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        bindtableSubjectInfo();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnrefreshActionPerformed

    private void tableSubjectInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSubjectInfoMouseClicked
        if(evt.getButton()==MouseEvent.BUTTON3){
            int rowpoint=tableSubjectInfo.rowAtPoint(evt.getPoint());
            tableSubjectInfo.getSelectionModel().setSelectionInterval(rowpoint, rowpoint);
            popupmenu.show(tableSubjectInfo,evt.getX(),evt.getY());
            row=tableSubjectInfo.getSelectedRow();
        }
    }//GEN-LAST:event_tableSubjectInfoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnrefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSubjectInfo;
    // End of variables declaration//GEN-END:variables
}
