
public class Tester {
    private GetXY get;
    private Playground pg;
    private ElementaryLogic mi;
    
    public Tester(GetXY get,Playground pg,ElementaryLogic mi){
        this.get = get;
        this.mi = mi;
        this.pg = pg;
    }
    public int[] getAndTest(){
     int[] xy = {-1,-1};
        boolean f = false;
        while(!f){
            try{
                pg.putX(get.getXY());
                f = true;
            } catch(AlreadyEnteredException ex){
                System.out.println(ex.getMessage());
                f = false;
            }
        }
        f = false;
        if(pg.getWinner() != '_'){
            pg.printPlaygrounnd();
            System.out.println(pg.getWinner() + " is win!!!");
            System.exit(0);
        }
        xy = mi.getNextWinWay(pg);
        if (xy[0]<0){
            xy = mi.getNextProtectWay(pg);
            if (xy[0]<0){
                xy = mi.getCenter(pg);
            }
        }
        return xy;
    }
}
