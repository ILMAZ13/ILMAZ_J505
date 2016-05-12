package tankwars;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Tank implements Moveble {
    private int number;
    private static BufferedImage tank_image;
    private int turn = 90; //degrees
    private int x;
    private int y;
    private int width;  //when up or down
    private int height; //when up or down
    private long lastFireTime = System.currentTimeMillis();
    private int firePause = 300; //ms
    private boolean alive;
    private int liveCount;
    private boolean bad;
    private int speed = 8;
            
    public Tank(int number){
        System.out.println(number);
        this.number = number;
        alive = false;
    }

    @Override
    public BufferedImage getImage() {
        return tank_image;
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
        if(turn==0 || Math.abs(turn) == 180){
            return width;
        } else {
            return height;
        }
    }

    @Override
    public int getHeigth() {
        if (turn == 0 || Math.abs(turn) == 180){
            return height;
        } else {
            return width;
        }
    }

    @Override
    public void setImages() {
        try {
            tank_image = ImageIO.read(TankWarsMain.class.getResourceAsStream("/tank1.png"));
            System.out.println("Tank image loaded");
        } catch (IOException ex) {}
    }

    @Override
    public void create(int x, int y, int width, int height, int parent, boolean badStatus) {
        this.bad = badStatus;
        liveCount = 2;
        alive = true;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        //
    }

    @Override
    public void die() {
        if(liveCount>0){
            liveCount--;
        } else {
            alive = false;
            Map.disLocate(this);
        }
    }

    @Override
    public void goLeft() {
        if(Map.check(this, -speed, 0)==null){
            Map.disLocate(this);
            x-=speed;
            Map.locate(this);
        }
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
    public void fire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
