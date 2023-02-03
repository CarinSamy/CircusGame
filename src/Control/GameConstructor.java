package Control;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */

import Model.Bomb;
import Model.ClownObject;
import Model.Credentials;
import Model.FallingObjects;
import Model.ImageObject;
import Model.PlateObject;
import Model.Star;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class GameConstructor {
    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> control = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    PlateObject pinkplate ,blackplate,brownplate,blueplate;
    Bomb bomb;
    Star star;
    ClownObject clown;
    PlateDirector Director ;
    int screenwidth,screenlength;
    String[] colors = {"black", "blue", "brown", "pink"};
    FallingObjects[] fallings=new FallingObjects[6];
    ImageObject live1,live2,live3;
    int numberofbombs,numberofstars,numberofplates;
    public GameConstructor(int screenwidth,int screenlength,int numberofbombs,int numberofstars,int numberofplates) {
        bomb = new Bomb(-20, -20, 0);
        star = new Star(0, 0, 0);
        live1=new ImageObject(160, 25, Credentials.heart);
        live2=live1.clone(80,25);
        live3=live1.clone(0, 25);
        this.numberofbombs=numberofbombs;
        this.numberofstars=numberofstars;
        this.numberofplates=numberofplates;
        Director = new PlateDirector();
        Director.constructplate("black", -50, -50);
        blackplate = Director.getplate();
        Director.constructplate("pink", -100, -100);
        pinkplate = Director.getplate();
        Director.constructplate("brown", -200, -200);
        brownplate = Director.getplate();
        Director.constructplate("blue", -300, -45);
        this.screenlength=screenlength;
        this.screenwidth=screenwidth;
        blueplate = Director.getplate();
        setmoving();
        clown = ClownObject.getclownobject();
        control.add(clown); 
        constant.add(new ImageObject(0, 0, Credentials.background));
        constant.add(live2);
        constant.add(live3);
        constant.add(live1);
        
        
    }
    
    
    public FallingObjects[] getfallingobjects(){
    fallings[0]=bomb;
    fallings[1]=star;
    fallings[2]=blackplate;
    fallings[3]=blueplate;
    fallings[4]=brownplate;
    fallings[5]=pinkplate;
    return fallings;
    }
    private void setmoving(){
        fallings=getfallingobjects();
        ArrayList<FallingObjects>plates=new ArrayList<FallingObjects>();
        for(int i=0;i<4;i++){
        plates.add(fallings[2+i]);
        }
      for (int i = 0; i < numberofplates; i++) {
            if (i % numberofbombs == 0) {
                Bomb bombcopy = (Bomb) bomb.clone((int) (Math.random() * screenwidth), 5 * i);
                moving.add(bombcopy);
            }
            PlateObject platecopy = (PlateObject) plates.get(i % 4).clone((int) (Math.random() * screenwidth), (int) (Math.random() * screenlength / 2));
            moving.add(platecopy);
            if (i % numberofstars == 0) {
                Star starcopy = (Star) star.clone(0 - 50 * (4 * i), 43);
                moving.add(starcopy);
            }
        }
    }
    public List<GameObject> getMoving() {
        return moving;
    }
    public ClownObject getclown(){
    return clown;
    }
    public List<GameObject> getConstant() {
        return constant;
    }

    public List<GameObject> getControl() {
        return control;
    }

    public ImageObject getLive1() {
        return live1;
    }

    public ImageObject getLive2() {
        return live2;
    }

    public ImageObject getLive3() {
        return live3;
    }
    
    
}
