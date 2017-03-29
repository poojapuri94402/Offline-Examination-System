/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adminui;

import Operations.Validations;
import java.beans.PropertyVetoException;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.dao.SectionInfoDao;
import model.dao.SubjectInfoDao;
import model.to.SectionInfoTo;
import model.to.SubjectInfoTo;

/**
 *
 * @author POOJA PURI
 */
public class AddSectionInfo extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddSectionInfo
     */
    public AddSectionInfo() {
        initComponents();
        jcbSubjectId.removeAllItems();
        jcbSubjectId.addItem("Choose A Subject ID");
        List<SubjectInfoTo> subjects=new SubjectInfoDao().getAllRecord();
        if(subjects!=null&&subjects.size()>0){
            for(SubjectInfoTo sit: subjects){
                jcbSubjectId.addItem(sit);
            }
        }
    }
    private SectionInfoTo Sit;
    public AddSectionInfo(String SectionId){
        this();
        Sit=new SectionInfoDao().getRecord(SectionId);
        if(Sit!=null){
            for(int i=1;i<jcbSubjectId.getItemCount();i++){
                SubjectInfoTo sit=(SubjectInfoTo)jcbSubjectId.getItemAt(i);
                if(sit.getSubjectId().equals(Sit.getSubjectId())){
                    jcbSubjectId.setSelectedIndex(i);
                    break;
                }}
            jtfSectionID.setText(Sit.getSectionId());
            jtfSectionID.setEditable(false);
            jtfSectionName.setText(Sit.getSectionName());
            jButton1.setText("Update Section Information");
            setTitle("ES:: Update Information");
            
        }
        }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfSubjectID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbSubjectId = new javax.swing.JComboBox<>();
        jtfSectionID = new javax.swing.JTextField();
        jtfSectionName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 204), java.awt.Color.blue, null, null));
        setClosable(true);
        setIconifiable(true);
        setTitle("ES::ADD SECTION INFORMATION");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Adminui/ex.png"))); // NOI18N

        jtfSubjectID.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jtfSubjectID.setText("Choose SubjectID:");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setText("Enter Section Name:");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setText("Enter Section ID:");

        jcbSubjectId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtfSectionName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSectionNameActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Jokerman", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("Add New Section");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jtfSectionID, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSectionName, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSubjectId, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSubjectId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSubjectID))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSectionID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSectionName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String message=" ";
        boolean allvalid=true;
        String SectionID=jtfSectionID.getText().trim();
        String SectionName=jtfSectionName.getText().trim();
        if (jcbSubjectId.getSelectedIndex() == 0) {
            allvalid = false;
            message += "Please Choose Any SubjectID\n";
        }

        if(Validations.isEmpty(SectionID)){
            message+="Please Provide Any Value For SectionID\n";
            allvalid=false;
        }
         if(Validations.isEmpty(SectionName)){
            message+="Please Provide Any Value For SectionName\n";
            allvalid=false;
        }
         if(!Validations.onlyCharacter(SectionName)){
             message+="Please Provide Any Valid SectionName\n";
            allvalid=false;
         }
        if(allvalid){
            SectionInfoTo Sit=new SectionInfoTo();
            SubjectInfoTo sit = (SubjectInfoTo) jcbSubjectId.getSelectedItem();
            Sit.setSectionId(SectionID);
            Sit.setSectionName(SectionName);
            Sit.setSubjectId(sit.getSubjectId());
            SectionInfoDao action=new SectionInfoDao();
            if(jButton1.getText().contains("Add")){
            if(action.insertRecord(Sit)){
                message+="New Record Is Added In The System";
                 JInternalFrame[] frames=getDesktopPane().getAllFrames();
                if(frames!=null){
                for(JInternalFrame jif: frames){
                    if(jif instanceof ViewSectionInfo){
                        ViewSectionInfo vSi=(ViewSectionInfo)jif;
                        vSi.bindtableSectionInfo();
                        break;
                    }
                }
                }
            }else{
                message=action.getErrormessage();
            }}else if(jButton1.getText().contains("Update")){
                if(action.updateRecord(Sit)){
                    message="Information is updated in the system";
                }else{
                    message=action.getErrormessage();
                }
                ViewSectionInfo vSi=new ViewSectionInfo();
                vSi.setVisible(true);
                getDesktopPane().add(vSi);
                try{
                    vSi.setSelected(true);
                }catch(PropertyVetoException ex){
                    
                }
                dispose();
            }else{
                message="Bad Command";
            }
        }
        JOptionPane.showMessageDialog(this, message);
                /*JOptionPane.showMessageDialog(this, message);
            }else{
                message+=action.getErrormessage();
                JOptionPane.showMessageDialog(this, message,"Error Message From System",JOptionPane.ERROR_MESSAGE);
            }
       }
        }*/
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtfSectionNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSectionNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSectionNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<Object> jcbSubjectId;
    private javax.swing.JTextField jtfSectionID;
    private javax.swing.JTextField jtfSectionName;
    private javax.swing.JLabel jtfSubjectID;
    // End of variables declaration//GEN-END:variables
}