package tankwars;

public class Map {
    public static Wall wall = new Wall();
    public static Tank[] tank = new Tank[100];
    public static Bullet[] bullet = new Bullet[500];
    public static Paintable[][] map = new Paintable[Window.width][Window.height];
    
    public static void locate(Paintable obj){
        int x1 = obj.getX();
        int y1 = obj.getY();
        int x2 = (x1 + obj.getWidth())/Window.scale;
        int y2 = (y1 + obj.getHeigth())/Window.scale;
        x1 = x1/Window.scale;
        y1 = y1/Window.scale;
        for(int i = x1; i<=x2;i++){
            for (int j = y1;j<=y2;j++){
                map[i][j] = obj;
            }
        }
    }
    public static void disLocate(Paintable obj){
        int x1 = obj.getX();
        int y1 = obj.getY();
        int x2 = (x1 + obj.getWidth())/Window.scale;
        int y2 = (y1 + obj.getHeigth())/Window.scale;
        x1 = x1/Window.scale;
        y1 = y1/Window.scale;
        for(int i = x1; i<=x2;i++){
            for (int j = y1;j<=y2;j++){
                map[i][j] = null;
            }
        }
    }
    
    public static Paintable check(Paintable obj, int xSpeed, int ySpeed){
        int x1 = obj.getX()+xSpeed;
        int y1 = obj.getY()+ySpeed;
        int x2 = (x1 + obj.getWidth())/Window.scale;
        int y2 = (y1 + obj.getHeigth())/Window.scale;
        x1 = x1/Window.scale;
        y1 = y1/Window.scale;
        if(x1>=0 && y1>=0 && y2<Window.height && x2<Window.width){
            for(int i = x1; i<=x2;i++){
                for (int j = y1;j<=y2;j++){
                    if(map[i][j] != null && map[i][j] != obj){
                        if(obj.getClass() != Wall.class){
                            if(isTouched(obj,map[i][i])){
                                return map[i][j];
                            }
                        } else {
                            return wall;
                        }
                    }
                }
            }
            return null;
        } else {
            return wall;
        }
    }
    
    public static boolean create(Class obj,int x, int y, int width, int height, int parent, boolean badStatus){
        boolean created = false;
        if(obj == Tank.class){
            for(int i = 1; i < tank.length;i++){
                if(!tank[i].isAlive()){
                    tank[i].create(x, y, width, height, parent, badStatus);
                    if(check(tank[i], 0, 0)==null){
                        locate(tank[i]);
                        return true;
                    } else {
                        tank[i] = new Tank(i);
                        return false;
                    }
                }
            }
        }
        if(obj == Bullet.class){
            for(int i = 1; i < bullet.length;i++){
                if(!bullet[i].isAlive()){
                    if(check(bullet[i], 0, 0)==null){
                        locate(bullet[i]);
                        return true;
                    } else {
                        bullet[i] = new Bullet(i);
                        return false;
                    }
                }
            }
        }
        return created;
    }
    
    public static boolean isTouched(Paintable obj1, Paintable obj2){
        boolean xTouch = false;
        boolean yTouch = false;
        if(obj1.getX()<=obj2.getX()+obj2.getWidth() && obj1.getX()+obj1.getWidth()>=obj2.getX()){
            xTouch = true;
        }
        if(obj1.getY()<=obj2.getY()+obj2.getHeigth()&& obj1.getY()+obj1.getHeigth()>=obj2.getY()){
            yTouch = true;
        }
        return xTouch && yTouch;
    }
}
