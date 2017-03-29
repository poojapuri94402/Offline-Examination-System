/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adminui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

/**
 *
 * @author POOJA PURI
 */
public class BackImage extends JComponent  {

    @Override
    public void paint(Graphics g) {
        g.drawImage(i, 0, 0, null); //To change body of generated methods, choose Tools | Templates.
    }
Image i;
//Creating Constructer
public BackImage(Image i) {
this.i = i;
 
}   

}
