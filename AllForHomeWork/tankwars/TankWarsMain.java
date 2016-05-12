package tankwars;

public class TankWarsMain {
    public static final String NAME = "Tank Wars v2.0";
    
    public static void main(String[] args) {
        for(int i = 0; i<100;i++){
            Map.tank[i] = new Tank(i);
        }
        Map.tank[0].setImages();
        for(int i = 0; i < 500;i++){
            Map.bullet[i] = new Bullet(i);
        }
        Map.bullet[0].setImages();
        if(Map.create(Tank.class, 100, 100, 100, 200, 0, true)){
            System.out.println("created1");
        }
        if(Map.create(Tank.class, 15, 15, 200, 100, 0, true)){
            System.out.println("created2");
        } else {
            System.out.println("no");
        }
        Window window = new Window(NAME);
        new Thread(window).start();
    }
    
}
