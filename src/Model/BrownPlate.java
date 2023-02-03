/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class BrownPlate  extends PlateObject implements Abstractbuild {

    public BrownPlate(int posX, int posY, String path, int type) {
        super(posX, posY, path, type);
    }

  
  
    public void setcolor() {
this.setColor("brown");
    }

    
    public void setpath() {
this.setPath(Credentials.brownpath);
    }


   public String getcolor() {
return "brown";
    }
}
