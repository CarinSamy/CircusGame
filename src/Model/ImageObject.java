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
 * @author LENOVO
 */

//FlyWeight interface is the GameObject interface in the jar

//This class implements FlyWeight Interface

public class ImageObject implements GameObject,Cloneable {
 
    private int x;
    private int y;
    
    private int width;
    private int height;

    private boolean visible;
    
    private static final int MAX_MSTATE = 1;

    private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
    private int type;
    private String path;
public ImageObject(int posX, int posY, String path){
		this(posX, posY, path, 0);
	}
public ImageObject(int posX, int posY, String path, int type){
		this.x = posX;
		this.y = posY;
		this.type = type;
		this.visible = true;
		// create a bunch of buffered images and place into an array, to be displayed sequentially
		try {
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
public ImageObject(){
}
    @Override
    public int getX() {
    return this.x;    }

    @Override
    public void setX(int x) {
    this.x=x;    }

    @Override
    public int getY() {
    return this.y;    }

    @Override
    public void setY(int y) {
    this.y=y;
    }

    @Override
    public int getWidth() {
    return this.width;    }

    @Override
    public int getHeight() {
    return this.height;    }

    @Override
    public boolean isVisible() {
    return this.visible;    }
    
    public void setVisible(){
        this.visible=true;}

    public String getPath(){
    return this.path;}
    
    public void setPath(String path){
    this.path=path;}
    
    @Override
    public BufferedImage[] getSpriteImages() {
    return this.spriteImages;    }
     public ImageObject clone(int posX,int posY)  {
        try {
            ImageObject copy=(ImageObject) super.clone();
            copy.setX(posX);
            copy.setY(posY);
            return copy;  
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(FallingObjects.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
