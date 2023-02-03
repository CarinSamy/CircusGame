/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Abstractbuild;
//import Model.FallingPlate;
import Model.PlateObject;

/**
 *
 * @author ADMIN
 */
public class PlateDirector {
    Abstractbuild platebuilder;
    PlateObject product;
    public PlateObject getplate(){
  return  product;
    }
    public void constructplate(String color,int posX,int posY){
       product = Abstractbuild.createplate(color, posX, posY);
    
    }
    
}
