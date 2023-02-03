/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author ADMIN
 */
public class HardStrategy extends CircusWorldStrategy {

    public HardStrategy(  int screenWidth, int screenHeight) {
        super( screenWidth, screenHeight);
    }

    @Override
    public int getSpeed() {
        return 5;
    }
    public int getTimeout() {
        return 2;
    }

    @Override
    public int getControlSpeed() {
     return 35;
    }

}
