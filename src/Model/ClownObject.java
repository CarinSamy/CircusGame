/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ADMIN
 */
public class ClownObject implements GameObject {

    private static final int MAX_MSTATE = 1;
    // an array of sprite images that are drawn sequentially
    private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
    private int x;
    private int y;
    private boolean visible;
    private int type;//0 moving 1 left 2 right
    private boolean horizontalOnly;
    private static ImageObject image;
    private String path;
    private static ClownObject clown = null;

    public void setSpriteImages(BufferedImage[] spriteImages) {
        this.spriteImages = spriteImages;
    }
    public  ImageObject getclownimage() {
        return image;
    }

    public void setimage(ImageObject image) {
        this.image = image;
    }

  /*  public PlateObject(int posX, int posY, String path) {
        this(posX, posY, path, 0);
    }*/

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private ClownObject() {
        this.x = Credentials.screenWidth / 3;
        this.y =  (int) (Credentials.screenHeight * 0.5);
        this.visible = true;
        this.path = Credentials.clown;
        horizontalOnly=true;
        image = new ImageObject(this.x , this.y,Credentials.clown );
        // create a bunch of buffered images and place into an array, to be displayed sequentially
        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {

        }
    }
    public synchronized static ClownObject getclownobject(){
    if(clown == null){
        clown=new ClownObject();
    }
    return clown;
    }
  
    @Override
    public int getX() {
        return x;
    }

    @Override
    public  void setX(int mX) {
        //System.out.println(clown.getX()+"       dfdsfsdfdsfdsfds      ");
        if (type == 1) {
            this.x = image.getX();
        
        } else {
            this.x = mX;
          
        }
        
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int mY) {
       /* if (!horizontalOnly) {
            this.y = mY;
        }*/
    }

    public boolean isHorizontalOnly() {
        return horizontalOnly;
    }

    public void setHorizontalOnly(boolean horizontalOnly) {
        this.horizontalOnly = horizontalOnly;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    @Override
    public int getWidth() {
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}