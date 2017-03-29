/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.suite;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author POOJA PURI
 */
public class BackPanel extends JPanel {

    private Image backimage;

    public BackPanel() {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/exam/suite/download8.jpg"));
            backimage = icon.getImage();
        } catch (Exception ex) {
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (backimage == null) {
            super.paintComponent(g);
        } else {
            g.drawImage(backimage, 0, 0,getWidth(),getHeight(), this);
        }
    }

}
