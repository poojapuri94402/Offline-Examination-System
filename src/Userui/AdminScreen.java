/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Userui;

import Adminui.AddSectionInfo;
import Adminui.AddSubjectInfo;
import Adminui.ViewSectionInfo;
import Adminui.ViewSubjectInfo;
import exam.suite.RegistrationPage;
import exam.suite.ViewUsers;
import java.beans.PropertyVetoException;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import model.dao.DataConnection;

/**
 *
 * @author POOJA PURI
 */
public class AdminScreen extends javax.swing.JFrame {

    /**
     * Creates new form AdminScreen
     */
    public AdminScreen() {
         try{
            ImageIcon icon=new ImageIcon(getClass().getResource("/Userui/ad.jpg"));
            setIconImage(icon.getImage());
        }catch(Exception ex){
            
        }
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deskpane = new javax.swing.JDesktopPane();
        deskPane = new javax.swing.JDesktopPane();
        backimage1 = new Userui.backimage();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmiAddSubject = new javax.swing.JMenu();
        jmiaddSubject = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout deskpaneLayout = new javax.swing.GroupLayout(deskpane);
        deskpane.setLayout(deskpaneLayout);
        deskpaneLayout.setHorizontalGroup(
            deskpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );
        deskpaneLayout.setVerticalGroup(
            deskpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ES: ADMINISTRATION PANEL");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        deskPane.setBackground(new java.awt.Color(255, 255, 255));
        deskPane.setForeground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout backimage1Layout = new javax.swing.GroupLayout(backimage1);
        backimage1.setLayout(backimage1Layout);
        backimage1Layout.setHorizontalGroup(
            backimage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );
        backimage1Layout.setVerticalGroup(
            backimage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );

        deskPane.setLayer(backimage1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout deskPaneLayout = new javax.swing.GroupLayout(deskPane);
        deskPane.setLayout(deskPaneLayout);
        deskPaneLayout.setHorizontalGroup(
            deskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backimage1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        deskPaneLayout.setVerticalGroup(
            deskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backimage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("User");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Adminui/addd.png"))); // NOI18N
        jMenuItem1.setText("Add New User");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Adminui/vieww.png"))); // NOI18N
        jMenuItem4.setText("View Users");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jmiAddSubject.setText("Subject Detail");

        jmiaddSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Adminui/addd.png"))); // NOI18N
        jmiaddSubject.setText("Add Subject Details");
        jmiaddSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiaddSubjectActionPerformed(evt);
            }
        });
        jmiAddSubject.add(jmiaddSubject);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Adminui/vieww.png"))); // NOI18N
        jMenuItem2.setText("View Subject");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmiAddSubject.add(jMenuItem2);

        jMenuBar1.add(jmiAddSubject);

        jMenu2.setText("Section Detail");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Adminui/addd.png"))); // NOI18N
        jMenuItem3.setText("Add Section");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Adminui/vieww.png"))); // NOI18N
        jMenuItem5.setText("View Section");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deskPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deskPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ShowScreen(JInternalFrame jif){
        jif.setVisible(true);
        deskPane.add(jif);
        try{
            jif.setSelected(true);
        }catch(PropertyVetoException ex){
            
        }
    }

    
    private void jmiaddSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiaddSubjectActionPerformed
        ShowScreen(new AddSubjectInfo());
    }//GEN-LAST:event_jmiaddSubjectActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        DataConnection.CloseConnection();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ShowScreen(new ViewSubjectInfo());
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ShowScreen(new AddSectionInfo());
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        ShowScreen(new ViewSectionInfo());
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ShowScreen(new RegistrationPage());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ShowScreen(new ViewUsers());
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Userui.backimage backimage1;
    private javax.swing.JDesktopPane deskPane;
    private javax.swing.JDesktopPane deskpane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenu jmiAddSubject;
    private javax.swing.JMenuItem jmiaddSubject;
    // End of variables declaration//GEN-END:variables
}
