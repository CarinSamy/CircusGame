/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class BluePlate  extends PlateObject implements Abstractbuild  {

    public BluePlate(int posX, int posY, String path, int type) {
        super(posX, posY, path, type);
    }

  
  
    public void setcolor() {
this.setColor("blue");
    }

    
    public void setpath() {
this.setPath(Credentials.bluepath);
    }

     public String getcolor() {
return "blue";
    }
}
