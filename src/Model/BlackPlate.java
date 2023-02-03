/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ADMIN
 */
public class BlackPlate  extends PlateObject implements Abstractbuild,Cloneable  {

    public BlackPlate(int posX, int posY, String path, int type) {
        super(posX, posY, path, type);
        
    }

  
  
    public void setcolor() {
this.setColor("black");
    }

    public void setpath() {
this.setPath(Credentials.blackpath);
    }

    public String getcolor() {
return "black";    }

    
}
