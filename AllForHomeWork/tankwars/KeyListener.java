
package tankwars;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener{
    public static boolean left1 = false;
    public static boolean right1 = false;
    public static boolean up1 = false;
    public static boolean down1 = false;
    public static boolean space1 = false;
    public static boolean left2 = false;
    public static boolean right2 = false;
    public static boolean up2 = false;
    public static boolean down2 = false;
    public static boolean space2 = false;
    
    @Override
    public void keyTyped(KeyEvent e) {}
        

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W: 
                up1 = true;
                break;
            case KeyEvent.VK_S:
                down1 = true;
                break;
            case KeyEvent.VK_A:
                left1 = true;
                break;
            case KeyEvent.VK_D:
                right1 = true;
                break;
            case KeyEvent.VK_SPACE:
                space1 = true;
                break;
            case KeyEvent.VK_UP: 
                up2 = true;
                break;
            case KeyEvent.VK_DOWN:
                down2 = true;
                break;
            case KeyEvent.VK_LEFT:
                left2 = true;
                break;
            case KeyEvent.VK_RIGHT:
                right2 = true;
                break;
            case KeyEvent.VK_P:
                space2 = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W: 
                up1 = false;
                break;
            case KeyEvent.VK_S:
                down1 = false;
                break;
            case KeyEvent.VK_A:
                left1 = false;
                break;
            case KeyEvent.VK_D:
                right1 = false;
                break;
            case KeyEvent.VK_SPACE:
                space1 = false;
                break;
            case KeyEvent.VK_UP: 
                up2 = false;
                break;
            case KeyEvent.VK_DOWN:
                down2 = false;
                break;
            case KeyEvent.VK_LEFT:
                left2 = false;
                break;
            case KeyEvent.VK_RIGHT:
                right2 = false;
                break;
            case KeyEvent.VK_P:
                space2 = false;
                break;
        }
    }
    
}
