package tankwars;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bullet implements Paintable, Moveble{
    private int number;
    private static BufferedImage[] bullet_image = new BufferedImage[4];
    private int turn; //0=up 1=down 2=right 3=left 4=dead
    private int x;
    private int y;
    private int width;  //when up or down
    private int height; //when up or down
    private boolean alive;
    private boolean bad;
    
    public Bullet(int number){
        System.out.println(number);
        this.number = number;
        alive = false;
    }
    
    @Override
    public BufferedImage getImage() {
        return bullet_image[turn];
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        if(turn == 0 || turn == 1){
            return width;
        } else {
            return height;
        }
    }

    @Override
    public int getHeigth() {
        if(turn == 0 || turn == 1){
            return height;
        } else {
            return width;
        }
    }

    @Override
    public void setImages() {
        try {
            bullet_image[0] = ImageIO.read(TankWarsMain.class.getResourceAsStream("/ball1.png"));
            bullet_image[1] = ImageIO.read(TankWarsMain.class.getResourceAsStream("/ball1.png"));
            bullet_image[2] = ImageIO.read(TankWarsMain.class.getResourceAsStream("/ball2.png"));
            bullet_image[3] = ImageIO.read(TankWarsMain.class.getResourceAsStream("/ball2.png"));
            System.out.println("Bullet image loaded");
        } catch (IOException ex) {}
    }

    @Override
    public void create(int x, int y, int width, int height, int parent, boolean badStatus) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.bad = badStatus;
        alive = true;
    }

    @Override
    public void die() {
        alive = false;
    }

    @Override
    public void goLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fire() {}

    @Override
    public boolean getBad() {
        return bad;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public int getTurn() {
        return turn;
    }
    
}
