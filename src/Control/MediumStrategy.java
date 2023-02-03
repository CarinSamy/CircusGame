/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author ADMIN
 */
public class MediumStrategy extends CircusWorldStrategy {

    public MediumStrategy( int screenWidth, int screenHeight) {
        super( screenWidth, screenHeight);
    }

    @Override
    public int getSpeed() {
        return 12;
    }
    public int getTimeout() {
        return 2;
    }

    @Override
    public int getControlSpeed() {
     return 30;
    }

}
