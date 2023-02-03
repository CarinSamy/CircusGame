package Model;


import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlateObject extends FallingObjects implements GameObject,Cloneable {

 public PlateObject(boolean horizontalOnly) {
        this.horizontalOnly = horizontalOnly;
    }
    public PlateObject(int posX, int posY, String path, int type) {
        this.x = posX;
        this.y = posY;
        this.type = type;
        this.visible = true;
        this.path = path;
        
        // create a bunch of buffered images and place into an array, to be displayed sequentially
        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {

        }
    }
  

     /* public PlateObject clone(int posX,int posY)  {
        try {
            PlateObject plate=(PlateObject) super.clone();
            plate.setX(posX);
            plate.setY(posY);
            return plate;  
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Bomb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/
}
