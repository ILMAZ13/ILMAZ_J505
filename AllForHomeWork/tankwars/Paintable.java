package tankwars;

import java.awt.image.BufferedImage;

public interface Paintable {
    
    public boolean isAlive();
    public int getNumber();
    public BufferedImage getImage();
    public int getX();
    public int getY();
    public int getWidth();
    public int getHeigth();
    public void setImages();
    public void create(int x,int y,int width, int height, int parent ,boolean badStatus);
    public void die();
    public int getTurn();
}
