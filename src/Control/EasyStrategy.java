package Control;

public class EasyStrategy extends CircusWorldStrategy {

    public EasyStrategy( int screenWidth, int screenHeight) {
        super(screenWidth, screenHeight);
    }

    @Override
    public int getSpeed() {
        return 20;
    }
    public int getTimeout() {
        return 2;
    }

    @Override
    public int getControlSpeed() {
     return 20;
    }

}
