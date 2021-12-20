/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.swing;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class MImage {
    
    public static Image getAppIcon() {
        URL url = com.raven.swing.MImage.class.getResource("/com/raven/icon/logoI.png");
        return new ImageIcon(url).getImage();
    }

    
}
