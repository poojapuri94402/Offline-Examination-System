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
import model.dao.SectionInfoDao;
import model.to.SectionInfoTo;

/**
 *
 * @author POOJA PURI
 */
public class ViewSectionInfo extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewSectionInfo
     */
    List<SectionInfoTo> section;
    private JPopupMenu popupmenu;
    private int row;
    public ViewSectionInfo() {
        initComponents();
        bindtableSectionInfo();
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
        if(row!=-1&&section!=null&&row<section.size()){
        SectionInfoTo Sit=section.get(row);
        AddSectionInfo aSi=new AddSectionInfo(Sit.getSectionId());
        aSi.setVisible(true);
        getDesktopPane().add(aSi);
        try{
            aSi.setSelected(true);
        }catch(PropertyVetoException ex){
            
        }
            dispose();
        }
        }
    /*private void deleterecord(){
        if(row!=-1&&section!=null&&row<section.size()){
            int result=JOptionPane.showConfirmDialog(this, "Are you Sure You Want To Delete This Information ?","Message From The System",JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION){
               String message="";
               SectionInfoTo Sit=section.get(row);
               if(Sit!=null){
                   SectionInfoDao action=new SectionInfoDao();
                   if(action.deleteRecord(Sit.getSectionId())){
                       message="Selected Section Information Is Deleted";
                       bindtableSectionInfo();
                       JOptionPane.showMessageDialog(this, message);
                   }else{
                       message=action.getErrormessage();
                       JOptionPane.showMessageDialog(this, message,"Error Message From System",JOptionPane.ERROR_MESSAGE);

                   }
                   
               }
            }
        }
        row=-1;
    }*/
            private void deleteRecord(){
        if(row!=-1&&section!=null&&row<section.size()){
            int result=JOptionPane.showConfirmDialog(this, "Are you Sure You Want To Delete This Information ?","Message From The System",JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION){
               String message="";
               SectionInfoTo Sit=section.get(row);
               if(Sit!=null){
                   SectionInfoDao action=new SectionInfoDao();
                   if(action.deleteRecord(Sit.getSectionId())){
                       message="Selected Subject Information Is Deleted";
                       bindtableSectionInfo();
                   }else{
                       message=action.getErrormessage();
                   }
                   JOptionPane.showMessageDialog(this, message);
               }
            }
        }
        row=-1;
    }

    public void bindtableSectionInfo(){
    section=new SectionInfoDao().getAllRecord();
    String[] colnames={"Section Id","Section Name","Subject Id"};
    Object[][] records=null;
    if(section!=null&& section.size()>0){
        records=new Object[section.size()][colnames.length];
        int i=0;
        for(SectionInfoTo Sit: section){
            records[i]=new Object[]{Sit.getSectionId(),Sit.getSectionName(),Sit.getSubjectId()};
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
    tableviewsection.getTableHeader().setReorderingAllowed(false);
    tableviewsection.setAutoCreateRowSorter(true);
    tableviewsection.setModel(dtm);

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
        tableviewsection = new javax.swing.JTable();
        btnrefreshsection = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("ES: VIEW SECTION INFORMATION");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Adminui/ex.png"))); // NOI18N

        tableviewsection.setModel(new javax.swing.table.DefaultTableModel(
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
        tableviewsection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableviewsectionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableviewsection);

        btnrefreshsection.setBackground(new java.awt.Color(0, 0, 0));
        btnrefreshsection.setFont(new java.awt.Font("Jokerman", 1, 36)); // NOI18N
        btnrefreshsection.setText("REFRESH");
        btnrefreshsection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshsectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btnrefreshsection, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnrefreshsection, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnrefreshsectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshsectionActionPerformed
         bindtableSectionInfo();
    }//GEN-LAST:event_btnrefreshsectionActionPerformed

    private void tableviewsectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableviewsectionMouseClicked
        if(evt.getButton()==MouseEvent.BUTTON3){
            int rowpoint=tableviewsection.rowAtPoint(evt.getPoint());
            tableviewsection.getSelectionModel().setSelectionInterval(rowpoint, rowpoint);
            popupmenu.show(tableviewsection,evt.getX(),evt.getY());
            row=tableviewsection.getSelectedRow();
        }
    }//GEN-LAST:event_tableviewsectionMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnrefreshsection;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableviewsection;
    // End of variables declaration//GEN-END:variables
}
