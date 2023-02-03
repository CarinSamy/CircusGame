/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ADMIN
 */
public class PinkPlate extends PlateObject  {

    public PinkPlate(int posX, int posY, String path, int type) {
        super(posX, posY, path, type);
    }

  
  
    public void setcolor() {
this.setColor("pink");
    }

    public void setpath() {
this.setPath(Credentials.pinkpath);
    }



    String getcolor() {
return "pink";    }
   
}
