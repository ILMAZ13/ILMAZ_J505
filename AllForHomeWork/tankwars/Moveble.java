
package tankwars;

public interface Moveble extends Paintable{
    public void goLeft();
    public void goRight();
    public void goUp();
    public void goDown();
    public void fire();
    public boolean getBad();
}
