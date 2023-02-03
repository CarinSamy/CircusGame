/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
public interface Abstractbuild {

    void setcolor();

    void setpath();

    String getcolor();
    static final HashMap platesmap = new HashMap();

    public static PlateObject createplate(String color, int posX, int posY) {
        PlateObject plate = (PlateObject) platesmap.get(color);
        if (plate != null) {
            return plate;
        } else {
            if (color.equalsIgnoreCase("pink")) {
                PinkPlate pinkplate=new PinkPlate(posX, posY, Credentials.pinkpath, 0);
                platesmap.put("pink", pinkplate);
                return pinkplate;
            } else if (color.equalsIgnoreCase("black")) {
                BlackPlate blackplate = new BlackPlate(posX, posY, Credentials.blackpath, 0);
                platesmap.put("black", blackplate);
                return blackplate;
            } else if (color.equalsIgnoreCase("brown")) {
                BrownPlate brownplate = new BrownPlate(posX, posY, Credentials.brownpath, 0);
                platesmap.put("brown", brownplate);
                return brownplate;
            } else if (color.equalsIgnoreCase("blue")) {
                BluePlate blueplate=new BluePlate(posX, posY, Credentials.bluepath, 0);
                platesmap.put("blue", blueplate);
                return blueplate;
            } else {
            }
            return null;
        }
    }
}
