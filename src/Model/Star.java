/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ADMIN
 */
public class Star extends FallingObjects implements GameObject,Cloneable {
    public Star(int posX, int posY,int type) {
        this.x = posX;
        this.y = posY;
        this.type = type;
        this.visible = true;
        this.path = Credentials.star;
        // create a bunch of buffered images and place into an array, to be displayed sequentially
        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {

        }
    }

    /* public Star clone(int posX,int posY)  {
        try {
            Star star=(Star) super.clone();
            star.setX(posX);
            star.setY(posY);
            return star;  
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Star.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/
}
