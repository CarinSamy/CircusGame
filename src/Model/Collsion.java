/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Control.Sound;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Collsion {

    ClownObject clown;
    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private final List<GameObject> control = new LinkedList<GameObject>();
    private List<GameObject> left = new LinkedList<GameObject>();
    private List<GameObject> right = new LinkedList<GameObject>();
    int rightc = 0, leftc = 0;
    int lives = 0;
    private int score = 0;
    private final long startTime = System.currentTimeMillis();
    ImageObject live1, live2, live3;
    //private static Collsion collsion;
    private static final int MAX_TIME = 1 * 80 * 1000;

    public Collsion(List<GameObject> constant, List<GameObject> control, List<GameObject> moving,ImageObject livesarray[]) {
        live1=livesarray[0];
        live2=livesarray[1];
        live3=livesarray[2];
        this.constant.addAll(constant);
        this.control.addAll(control);
        this.moving.addAll(moving);
        clown = (ClownObject) control.get(0);
    }

     /*    public synchronized static Collsion getCollsion(List<GameObject> constant, List<GameObject> control, List<GameObject> moving,ImageObject livesarray[]) {
     if (collsion == null) {
     collsion = new Collsion(constant, control, moving,livesarray);
     }
     return collsion;
     }*/
      Sound sound=new Sound();
            public void playMusic(int i){
    sound.setFile(i);
    sound.play();
    sound.loop();
}
            public void stopMusic(){
                sound.stop();
            }
            public void playSE(int i){
                sound.setFile(i);
                sound.play();
            }
    public List<GameObject> getConstant() {
        return constant;
    }

    public List<GameObject> getMoving() {
        return moving;
    }

    public List<GameObject> getControl() {
        return control;
    }

    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }

    public void updatescreen(FallingObjects o) {
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME;
        boolean bomb = false;
        boolean star = false;
        FallingObjects copy;
        o.setY((o.getY() + 1));
        if (o instanceof Bomb) {
            bomb = true;
        } else if (o instanceof Star) {
            star = true;
        }
        if (o.getY() == Credentials.screenHeight) {
            o.setY(-1 * (int) (Math.random() * o.getHeight()));
            o.setX((int) (Math.random() * Credentials.screenWidth));
        }
        if (!timeout & o.isVisible() && intersectleft(clown, o)) {
            
            if (bomb) {
                playSE(2);
                updatelives();
                moving.remove(o);
            } else if (star) {
                playSE(1);
                moving.remove(o);
                updatescore();
            } else {
                 playSE(3);
                System.out.println("leftc =" + leftc);
                o.setType(1);
 
                o.setHorizontalOnly(false);
                copy = o.clone(o.getX(), o.getY() + 5);
                copy.setHorizontalOnly(false);
                copy.left = true;
                copy.setX(clown.getX() - 5);
                //leftc=40-leftc;

                if ((clown.getY() + 40 - leftc) < 40) {
                    control.removeAll(left);
                    left.removeAll(left);
                    leftc = 0;
                    updatelives();
                    moving.remove(o);
                }
                copy.setY(clown.getY() + 40 - leftc);
                leftc = leftc + 10;
                copy.setHorizontalOnly(true);
                control.add(copy);
                left.add(copy);
                moving.remove(o);
                //  score = Math.max(0, score - 10);

                updateLeft();
            }

        } else if (!timeout & o.isVisible() && intersectright(clown, o)) {
            System.out.println("intersected right");
            o.setType(1);
            if (bomb) {
                 playSE(2);
               updatelives();
                moving.remove(o);
            }
                 else if (star) {
                      playSE(1);
                moving.remove(o);
                updatescore();
            }
                 else {
                      playSE(3);
                o.setHorizontalOnly(false);
                copy = o.clone(o.getX(), o.getY() + 5);
                copy.setHorizontalOnly(false);
                copy.right = true;
                copy.setX(clown.getX() + 80);
                if ((clown.getY() + 40 - rightc) < 40) {
                        control.removeAll(right);
                        right.removeAll(right);
                        rightc = 0;
                        updatelives();
                        moving.remove(o);
                }
                copy.setY(clown.getY() + 40 - rightc);
                rightc = rightc + 10;
                copy.setHorizontalOnly(true);
                control.add(copy);
                right.add(copy);
                moving.remove(o);
                // score = Math.max(0, score - 10);
                updateright();
            }

        }

    }
    

    private boolean intersectleft(GameObject o1, GameObject o2) {
        Point left = new Point(clown.getX() + 20, clown.getY());
        int o2lastx = o2.getX() + o2.getWidth();
        int top = left.y + 40 - leftc;
       
        return (o2.getY() >= top && o2.getY() <= top + 20 && o2.getX() - 10 <= left.x && left.x <= o2lastx);
    }

    private boolean intersectright(GameObject o1, GameObject o2) {

        Point right = new Point(clown.getX() + clown.getWidth(), clown.getY());

        int o2lastx = o2.getX() + o2.getWidth();
        int top = right.y + 40 - rightc;
        if (o2 instanceof PlateObject) {
           
            return (o2.getY() >= top && o2.getY() <= top + 20 && o2.getX() <= right.x - 40 && right.x - 10 <= o2lastx);
        } else {
            return (o2.getY() >= top && o2.getY() <= top + 30 && o2.getX() <= right.x && right.x <= o2lastx + 30);
        }
       
    }

    private void updateLeft() {
        if (left.size() >= 3) {
            FallingObjects p1 = (FallingObjects) left.get(left.size() - 1);
            FallingObjects p2 = (FallingObjects) left.get(left.size() - 2);
            FallingObjects p3 = (FallingObjects) left.get(left.size() - 3);
            if (p1.getPath().equals(p2.getPath()) && p2.getPath().equals(p3.getPath())) {
                left.remove(left.size() - 1);
                left.remove(left.size() - 1);
                left.remove(left.size() - 1);
                control.remove(p1);
                control.remove(p2);
                control.remove(p3);
                leftc = leftc - 30;
                score++;
                 playSE(1);
            }
        }
    }

    private void updateright() {
        if (right.size() >= 3) {
            FallingObjects p4 = (FallingObjects) right.get(right.size() - 1);
            FallingObjects p5 = (FallingObjects) right.get(right.size() - 2);
            FallingObjects p6 = (FallingObjects) right.get(right.size() - 3);
            if (p4.getPath().equals(p5.getPath()) && p5.getPath().equals(p6.getPath())) {
                right.remove(right.size() - 1);
                right.remove(right.size() - 1);
                right.remove(right.size() - 1);
                rightc = rightc - 30;
                control.remove(p4);
                control.remove(p5);
                control.remove(p6);
                score++;
                 playSE(1);
            }
        }
    }

    private void updatelives() {
        if (lives == 0) {
            constant.remove(live1);
        } else if (lives == 1) {
            constant.remove(live2);
        } else if (lives == 2) {
            constant.remove(live3);
             playSE(4);
        }
        lives++;
    }

    private void updatescore() {
        score = score + 10;
    }
    
    
}
