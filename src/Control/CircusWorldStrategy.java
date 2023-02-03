/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Control.GameConstructor;
import Model.PlateObject;
import Control.PlateDirector;
import Model.Bomb;
import Model.ClownObject;
import Model.Collsion;
import Model.Credentials;
import Model.FallingObjects;
import Model.ImageObject;
import Model.Star;
import java.util.LinkedList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public abstract class CircusWorldStrategy implements World {

    private static final int MAX_TIME = 1 * 80 * 1000;	// 1 minute
    private int score = 0;
    private final long startTime = System.currentTimeMillis();
    private final int width;
    private final int height;
    ClownObject clown;
    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private final List<GameObject> control = new LinkedList<GameObject>();
    int lives = 0;
    ImageObject live1, live2, live3;
    Collsion update;

    public CircusWorldStrategy(int screenWidth, int screenHeight) {
        width = screenWidth;
        height = screenHeight;

        GameConstructor game =new GameConstructor(screenWidth, screenHeight, 27, 10, 40);
        moving.addAll(game.getMoving());
        constant.addAll(game.getConstant());
        control.addAll(game.getControl());
        clown = game.getclown();
        live1 = game.getLive1();
        live2 = game.getLive2();
        live3 = game.getLive3();
        ImageObject livesarray[]={live1,live2,live3};
        update = new Collsion(constant, control, moving,livesarray);
        
    }
    @Override
    public boolean refresh() {
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME; // time end and game over
        for (int i = 0; i < moving.size(); i++) {
          update.updatescreen((FallingObjects) moving.get(i));
          updatechanges();
            if (lives == 3) {
                return timeout;
            }
        }
        return !timeout;

    }

    public abstract int getSpeed();

    public abstract int getControlSpeed();
    void updatechanges(){
   
            this.constant.removeAll(constant);
            this.control.removeAll(control);
            this.moving.removeAll(moving);
            this.constant.addAll(update.getConstant());
            this.control.addAll(update.getControl());
            this.moving.addAll(update.getMoving());
            lives = update.getLives();
            score = update.getScore();
    }
    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getStatus() {
        return "Score=" + score + "   |   Time=" + Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000);	// update status
    }
}
