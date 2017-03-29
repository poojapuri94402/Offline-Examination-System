/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adminui;

import Operations.Validations;
import java.beans.PropertyVetoException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.dao.LoginInfoDAO;
import model.dao.SubjectInfoDao;
import model.dao.TestInfoDao;
import model.to.LoginInfoTo;
import model.to.SubjectInfoTo;
import model.to.TestInfoTo;

/**
 *
 * @author POOJA PURI
 */
public class AddTestInfo extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddTestInfo
     */
    private String username;

    public AddTestInfo(String username) {
        this();
        this.username = username;
    }

    public AddTestInfo() {
        initComponents();
        jcbsubjectid.removeAllItems();
        jcbsubjectid.addItem("Choose A Subject ID");
        List<SubjectInfoTo> subjects = new SubjectInfoDao().getAllRecord();
        if (subjects != null && subjects.size() > 0) {
            for (SubjectInfoTo sit : subjects) {
                jcbsubjectid.addItem(sit);
            }
        }
        /*        jcbUsername.removeAllItems();
        jcbUsername.addItem("Choose A UserName");
        List<LoginInfoTo> login=new LoginInfoDAO().getAllRecord();
        if(login!=null&&subjects.size()>0){
            for(LoginInfoTo lit: login){
                jcbUsername.addItem(String.valueOf(lit));
            }
        }*/
        jcbTestLevel.removeAllItems();
        jcbTestLevel.addItem("OPT FOR A TEST LEVEL");
        jcbTestLevel.addItem("EASY");
        jcbTestLevel.addItem("NORMAL");
        jcbTestLevel.addItem("HARD");

    }
    private TestInfoTo tit;

    public AddTestInfo(int TestID,String username) {
        this();
        this.username = username;
        tit = new TestInfoDao().getRecord(TestID);
        if (tit != null) {
            for (int i = 1; i < jcbsubjectid.getItemCount(); i++) {
                SubjectInfoTo sit = (SubjectInfoTo) jcbsubjectid.getItemAt(i);
                if (sit.getSubjectId().equals(tit.getSubjectID())) {
                    jcbsubjectid.setSelectedIndex(i);
                    break;
                }
            }
            jtfTestName.setText(tit.getTestName());
            for (int i = 1; i < jcbTestLevel.getItemCount(); i++) {
                jcbTestLevel.setSelectedIndex(i);
                break;
            }

            jtfTotalQUestion.setText(String.valueOf(tit.getTotalQuestion()));
            btnProceed.setText(("Update"));
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

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbsubjectid = new javax.swing.JComboBox<>();
        jcbTestLevel = new javax.swing.JComboBox<>();
        jtfTotalQUestion = new javax.swing.JTextField();
        jtfTestName = new javax.swing.JTextField();
        btnProceed = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("ES::ADD EXAM INFORMATION");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Adminui/ex.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setText("Choose Subject ID");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel3.setText("Enter Test Name");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel5.setText("Total Questions");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel6.setText("Test Level");

        jcbsubjectid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbsubjectid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbsubjectidItemStateChanged(evt);
            }
        });

        jcbTestLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnProceed.setFont(new java.awt.Font("Jokerman", 1, 32)); // NOI18N
        btnProceed.setForeground(new java.awt.Color(0, 51, 153));
        btnProceed.setText("ADD EXAM INFO");
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnProceed)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbTestLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTotalQUestion, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTestName, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbsubjectid, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbsubjectid, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfTestName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTestLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfTotalQUestion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        String message = " ";
        boolean allvalid = true;
        /*if (jcbUsername.getSelectedIndex() == 0) {
            allvalid = false;
            message += "Please Choose Any UserName\n";
        }*/
        //String totalques = jtfTotalQUestion.getText().trim();
        if (jcbsubjectid.getSelectedIndex() == 0) {
            allvalid = false;
            message += "Please Choose Any SubjectID\n";
        }

        String TestName = jtfTestName.getText().trim();
        if (jcbTestLevel.getSelectedIndex() == 0) {
            allvalid = false;
            message += "Please Opt For Any Test Level\n";
        }
        String TotalQuestion = jtfTotalQUestion.getText().trim();

        if (Validations.isEmpty(TestName)) {
            message += "Please Provide Any Value For Test Name\n";
            allvalid = false;
        }
        if(!Validations.onlyCharacter(TestName)){
            message += "Please Provide Any Valid Test Name\n";
            allvalid = false;
        }
        if (Validations.isEmpty(TotalQuestion)) {
            //int total = Integer.parseInt(TotalQuestion);

            message += "Please Provide Total Number Of Questions\n";
            allvalid = false;
        } else {
            if (!Validations.isNumeric(TotalQuestion)) {
                message += "Number of Questions Must Be numeric";
                allvalid = false;
            }
        }
        if (allvalid) {
            TestInfoTo tit = new TestInfoTo();
            /* LoginInfoTo lit = (LoginInfoTo) jcbUsername.getSelectedItem();*/
            SubjectInfoTo sit = (SubjectInfoTo) jcbsubjectid.getSelectedItem();
            tit.setTestName(TestName);
            tit.setTestLevel(jcbTestLevel.getSelectedItem().toString());
            tit.setTotalQuestion(Integer.parseInt(TotalQuestion));
            tit.setUserName(username);
            tit.setSubjectID(sit.getSubjectId());
            TestInfoDao action = new TestInfoDao();
            if (btnProceed.getText().contains("ADD")) {
                if (action.insertRecord(tit)) {
                    message += "New Record Is Added In The System";
                    JInternalFrame[] frames = getDesktopPane().getAllFrames();
                    if (frames != null) {
                        for (JInternalFrame jif : frames) {
                            if (jif instanceof ViewExamDetail) {
                                ViewExamDetail ved = (ViewExamDetail) jif;
                                ved.bindtableTestInfo();
                                break;
                            }
                        }
                    }
                    //JOptionPane.showMessageDialog(this, message);
                } else {
                    message += action.getErrormessage();
                    //JOptionPane.showMessageDialog(this, message, "Error Message From System", JOptionPane.ERROR_MESSAGE);
                }
            } else if (btnProceed.getText().contains("Update")) {
                tit.setTestID(this.tit.getTestID());
                tit.setUserName(username);
                if (action.updateRecord(tit)) {
                    message = "Information is updated in the system";
                } else {
                    message = action.getErrormessage();
                }
                    //JOptionPane.showMessageDialog(this, message, "Error Message From System", JOptionPane.ERROR_MESSAGE);

                ViewExamDetail ved = new ViewExamDetail();
                ved.setVisible(true);
                getDesktopPane().add(ved);
                try {
                    ved.setSelected(true);
                } catch (PropertyVetoException ex) {

                }
                dispose();
            } else {
                message = "Bad Command";
            }

        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_btnProceedActionPerformed

    private void jcbsubjectidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbsubjectidItemStateChanged

    }//GEN-LAST:event_jcbsubjectidItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProceed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<Object> jcbTestLevel;
    private javax.swing.JComboBox<Object> jcbsubjectid;
    private javax.swing.JTextField jtfTestName;
    private javax.swing.JTextField jtfTotalQUestion;
    // End of variables declaration//GEN-END:variables
}
