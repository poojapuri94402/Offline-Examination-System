/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adminui;

import Operations.Validations;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.dao.SubjectInfoDao;
import model.to.SubjectInfoTo;

/**
 *
 * @author POOJA PURI
 */
public class AddSubjectInfo extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddSubjectInfo
     */
   
    public AddSubjectInfo() {
       
        initComponents();
        //this.getContentPane().setBackground(Color.red);
    }

    public AddSubjectInfo(SubjectInfoTo sit) {
        this();
        if (sit != null) {
            jtfSubjectId.setText(sit.getSubjectId());
            jtfSubjectName.setText(sit.getSubjectName());
            jtfDescription.setText(sit.getDescription());
            jtfSubjectId.setEditable(false);
            setTitle("ES:: Update Information");
            btnAdd.setText("Update Subject Information");
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jtfSubjectId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfSubjectName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jtfDescription = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setForeground(javax.swing.UIManager.getDefaults().getColor("Button.focus"));
        setIconifiable(true);
        setMaximizable(true);
        setTitle("ES::ADD SUBJECT INFORMATION");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Adminui/ex.png"))); // NOI18N

        jDesktopPane1.setDesktopManager(null);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setText("Enter Subject ID: ");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setText("Enter Subject Name: ");

        jtfSubjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSubjectNameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setText("Enter Description: ");

        btnAdd.setFont(new java.awt.Font("Jokerman", 1, 24)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 0, 153));
        btnAdd.setText("ADD NEW SUBJECT ");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jtfDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescriptionActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfSubjectId, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfSubjectName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAdd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfDescription, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                            .addComponent(jtfSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtfDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jtfSubjectId, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSubjectId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(btnAdd)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String message = " ";
        boolean allvalid = true;
        String SubjectId = jtfSubjectId.getText().trim();
        String SubjectName = jtfSubjectName.getText().trim();
        String Description = jtfDescription.getText().trim();
        if (Validations.isEmpty(SubjectId)) {
            allvalid = false;
            message += "Please Provide Any Value For SubjectID\n";
            
        }
        if (Validations.isEmpty(SubjectName)) {
            allvalid = false;
            message += "Please Provide Any Value For Subject Name\n";
            
        }
        if (Validations.isEmpty(Description)) {
            allvalid = false;
            message += "Please Provide Any Value For Description\n";
            
        }
        if(!Validations.onlyCharacter(SubjectName)){
            allvalid = false;
            message += "Please Provide Valid Subject Name\n";
        }
        if (allvalid) {
            SubjectInfoTo sit = new SubjectInfoTo();
            sit.setSubjectId(SubjectId);
            sit.setSubjectName(SubjectName);
            sit.setDescription(Description);
            SubjectInfoDao action = new SubjectInfoDao();
            if (btnAdd.getText().contains("ADD")) {
                if (action.insertRecord(sit)) {
                    message = "New Subject Record is Added in The System ";
                    JInternalFrame[] frames = getDesktopPane().getAllFrames();
                    if (frames != null) {
                        for (JInternalFrame jif : frames) {
                            if (jif instanceof ViewSubjectInfo) {
                                ViewSubjectInfo vsi = (ViewSubjectInfo) jif;
                                vsi.bindtableSubjectInfo();
                                break;
                            }
                        }
                    }
                } else {
                    message = action.getErrormessage();
                }
            } else if (btnAdd.getText().contains("Update")) {
                if (action.updateRecord(sit)) {
                    message = "Information is updated in the system";
                } else {
                    message = action.getErrormessage();
                }
                ViewSubjectInfo vsi = new ViewSubjectInfo();
                vsi.setVisible(true);
                getDesktopPane().add(vsi);
                try {
                    vsi.setSelected(true);
                } catch (PropertyVetoException ex) {

                }
                dispose();
            } else {
                message = "Bad Command";
            }
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_btnAddActionPerformed

    private void jtfSubjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSubjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSubjectNameActionPerformed

    private void jtfDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescriptionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jtfDescription;
    private javax.swing.JTextField jtfSubjectId;
    private javax.swing.JTextField jtfSubjectName;
    // End of variables declaration//GEN-END:variables

}
