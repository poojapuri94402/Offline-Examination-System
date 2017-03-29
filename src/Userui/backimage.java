/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Userui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author POOJA PURI
 */
public class backimage extends JPanel {

    private Image image;

    public backimage() {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Userui/3.jpg"));
            image = icon.getImage();
        } catch (Exception ex) {
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        if (image == null) {
            super.paintComponent(g);
        } else {
            g.drawImage(image, 0, 0,getWidth(),getHeight(), this);
        }
    }
    }

    

