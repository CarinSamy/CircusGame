/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author LENOVO
 */
public abstract class FallingObjects implements GameObject {

    static final int MAX_MSTATE = 1;
    // an array of sprite images that are drawn sequentially
    BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
    int x;
    int y;
    boolean visible;
    int type;//0 moving 1 left 2 right
    boolean horizontalOnly;
    ImageObject image;
    String path;
    String color;
    public Boolean right=false;
    public Boolean left=false;

    public void setSpriteImages(BufferedImage[] spriteImages) {
        this.spriteImages = spriteImages;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ImageObject getimage() {
        return image;
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

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int mX) {
        /*if (type == 1) {
            this.x = image.getX();
        } else {*/
        this.x = mX;
        if(left==true && mX>645)
            this.x=645;
        else if(right==true && mX<80)
            this.x=80;
        //}
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int mY) {
        if (!horizontalOnly) {
            this.y = mY;
        }
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        if (type == 1) {
            horizontalOnly = true;
        }
    }

   public void setimage(ImageObject clownimage) {
        this.image = image;
   }
    public FallingObjects clone(int posX,int posY)  {
        try {
            FallingObjects copy=(FallingObjects) super.clone();
            copy.setX(posX);
            copy.setY(posY);
            return copy;  
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(FallingObjects.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
