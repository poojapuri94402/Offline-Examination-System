/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.suite;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.dao.TestQuestionDao;
import model.to.TestQuestionTo;

/**
 *
 * @author POOJA PURI
 */
public class TestScreen extends javax.swing.JFrame implements Runnable {

    List<TestQuestionTo> questions;
    int qno;
    int time;
    boolean startflag;
    JButton[] buttons;
    String username;
    int testid;
    public void run() {

        while (startflag) {
            time--;
            int minute = time / 60;
            int second = time % 60;
            String message = "";
            message += (minute < 9 ? ("0" + minute) : String.valueOf(minute));
            message += ":";
            message += (second < 9 ? ("0" + second) : String.valueOf(second));
            lbltime.setText(message);
            if (time == 0) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }
            if (time == 0) {
                processQuestions(qno);
                JOptionPane.showMessageDialog(this, "Time Out!!!");
                endTest();
                System.exit(0);
            }
        }
    }
    List<String> answers;

    public TestScreen(String username , int testid){
        this();
        this.username = username;
        this.testid = testid;
        questions = new TestQuestionDao().getAllRecord(testid);
        if (questions != null && questions.size() > 0) {
            answers = new ArrayList<>();
            for (int i = 0; i < questions.size(); i++) {
                answers.add("");
            }
            time = questions.size() * 10;
            buttons = new JButton[questions.size()];
            int rows = buttons.length / 3 + 1;
            GridLayout layout = new GridLayout(rows, 3, 10, 10);
            buttonpanel.setLayout(layout);
            ButtonAction action = new ButtonAction();
            for (int i = 0; i < buttons.length; i++) {
                int val = i + 1;
                buttons[i] = new JButton(String.valueOf(val));
                buttons[i].setBackground(Color.GREEN);
                 buttons[i].addActionListener(action);
                buttonpanel.add(buttons[i]);
            }
            startflag = true;
            new Thread(this).start();
            displayQuestion(qno);
        }
    }
    private class ButtonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
                JButton btn = (JButton)e.getSource();
                int index = Integer.parseInt(btn.getText()) - 1;
                processQuestions(qno);
                qno = index;
                displayQuestion(qno);
            }
        }
        
    }
    
    public TestScreen() {
        setUndecorated(true);
        initComponents();
        setSize(getToolkit().getScreenSize());
        
    }

    private void processQuestions(int index) {
        if (answers != null && index < answers.size()) {
            String answer = "";
            if (jrbOptionA.isSelected()) {
                answer = "A";
            } else if (jrbOptionB.isSelected()) {
                answer = "B";
            } else if (jrbOptionC.isSelected()) {
                answer = "C";
            } else if (jrbOptionD.isSelected()) {
                answer = "D";
            }
            answers.set(index, answer);
            if(!answer.equals("")){
                buttons[index].setBackground(Color.YELLOW);
            }
        }
    }

    private void displayQuestion(int index) {
        if (questions != null && index < questions.size()) {
            TestQuestionTo question = questions.get(index);
            jtaQuestionText.setText(question.getQuestionText());
            jrbOptionA.setText(question.getOptionA());
            jrbOptionB.setText(question.getOptionB());
            jrbOptionC.setText(question.getOptionC());
            jrbOptionC.setText(question.getOptionD());
            bgOptions.clearSelection();
            String answer = answers.get(index);
            if(answer.equals("")){
                buttons[index].setBackground(Color.GRAY);
            }
            if (answer.equals("A")) {
                jrbOptionA.setSelected(true);
            } else if (answer.equals("B")) {
                jrbOptionB.setSelected(true);
            } else if (answer.equals("C")) {
                jrbOptionC.setSelected(true);
            } else if (answer.equals("D")) {
                jrbOptionD.setSelected(true);
            }
        }
    }

    private void endTest() {
        if (questions != null && questions.size() > 0) {
            int TotalQuestion = questions.size();
            int TotalRight, TotalAttempt, TotalMarks, ObtainedMarks;
            TotalRight = TotalAttempt = TotalMarks = ObtainedMarks = 0;
            for (int i = 0; i < TotalQuestion; i++) {
                TestQuestionTo question = questions.get(i);
                String answer = answers.get(i);
                TotalMarks += question.getMarks();
                if (!answers.equals("")) {
                    TotalAttempt++;
                    if (answer.equals(question.getAnswer())) {
                        TotalRight++;
                        ObtainedMarks += question.getMarks();
                    }
                }
            }
            String message = "\n Total Questions :" + TotalQuestion + "\n";
            message += "\n Total Marks :" + TotalMarks + "\n";
            message += "\n Total Attempted :" + TotalAttempt + "\n";
            message += "\n Total Right :" + TotalRight + "\n";
            message += "\n Obtained Marks :" + ObtainedMarks + "\n";
            JOptionPane.showMessageDialog(this, message);
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

        bgOptions = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaQuestionText = new javax.swing.JTextArea();
        jrbOptionA = new javax.swing.JRadioButton();
        jrbOptionB = new javax.swing.JRadioButton();
        jrbOptionC = new javax.swing.JRadioButton();
        jrbOptionD = new javax.swing.JRadioButton();
        btnprevious = new javax.swing.JButton();
        btnendtest = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        buttonpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jtaQuestionText.setEditable(false);
        jtaQuestionText.setColumns(20);
        jtaQuestionText.setRows(5);
        jScrollPane1.setViewportView(jtaQuestionText);

        bgOptions.add(jrbOptionA);
        jrbOptionA.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jrbOptionA.setText("Option A");

        bgOptions.add(jrbOptionB);
        jrbOptionB.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jrbOptionB.setText("Option B");

        bgOptions.add(jrbOptionC);
        jrbOptionC.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jrbOptionC.setText("Option C");

        bgOptions.add(jrbOptionD);
        jrbOptionD.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jrbOptionD.setText("Option D");

        btnprevious.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnprevious.setText("PREVIOUS");
        btnprevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpreviousActionPerformed(evt);
            }
        });

        btnendtest.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnendtest.setText("END TEST");
        btnendtest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnendtestActionPerformed(evt);
            }
        });

        btnnext.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnnext.setText("NEXT");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 30)); // NOI18N
        jLabel1.setText("Remaining Time:");

        lbltime.setFont(new java.awt.Font("Comic Sans MS", 1, 30)); // NOI18N
        lbltime.setText("00:00");

        buttonpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        javax.swing.GroupLayout buttonpanelLayout = new javax.swing.GroupLayout(buttonpanel);
        buttonpanel.setLayout(buttonpanelLayout);
        buttonpanelLayout.setHorizontalGroup(
            buttonpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );
        buttonpanelLayout.setVerticalGroup(
            buttonpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbOptionD)
                    .addComponent(jrbOptionC)
                    .addComponent(jrbOptionB)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnprevious)
                        .addGap(37, 37, 37)
                        .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnendtest, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jrbOptionA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltime))
                    .addComponent(buttonpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jrbOptionA)
                        .addGap(18, 18, 18)
                        .addComponent(jrbOptionB)
                        .addGap(18, 18, 18)
                        .addComponent(jrbOptionC)
                        .addGap(30, 30, 30)
                        .addComponent(jrbOptionD)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnprevious, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnendtest, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(buttonpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnendtestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnendtestActionPerformed
        startflag = false;
        processQuestions(qno);
        endTest();
        System.exit(0);
    }//GEN-LAST:event_btnendtestActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        if (qno < questions.size() - 1 && questions != null) {
            processQuestions(qno);
            qno++;
            displayQuestion(qno);
        } else {
            JOptionPane.showMessageDialog(this, "Last Question");
        }
    }//GEN-LAST:event_btnnextActionPerformed

    private void btnpreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpreviousActionPerformed
        if (qno > 0 && questions != null) {
            processQuestions(qno);
            qno--;
            displayQuestion(qno);
        } else {
            JOptionPane.showMessageDialog(this, "First Question");
        }
    }//GEN-LAST:event_btnpreviousActionPerformed

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
            java.util.logging.Logger.getLogger(TestScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgOptions;
    private javax.swing.JButton btnendtest;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnprevious;
    private javax.swing.JPanel buttonpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbOptionA;
    private javax.swing.JRadioButton jrbOptionB;
    private javax.swing.JRadioButton jrbOptionC;
    private javax.swing.JRadioButton jrbOptionD;
    private javax.swing.JTextArea jtaQuestionText;
    private javax.swing.JLabel lbltime;
    // End of variables declaration//GEN-END:variables
}
