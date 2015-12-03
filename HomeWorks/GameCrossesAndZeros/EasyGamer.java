
public class EasyGamer {
    private GetXY get;
    private Playground pg;
    private ElementaryLogic mi;
    private Tester te;
    
    public EasyGamer(GetXY get,Playground pg,ElementaryLogic mi,Tester te){
        this.get = get;
        this.mi = mi;
        this.pg = pg;
        this.te = te;
    }
    
    public void playEasy(){
        int[] xy = {-1,-1};
        boolean f = false;
        while(pg.getMoveCount()<8){
            xy = te.getAndTest();
            if (xy[0]<0){
                xy = mi.getPossibleWay(pg);
                if (xy[0]<0){
                    xy = mi.getEmptyPoint(pg);
                }
            }
            pg.putO(xy);
            pg.printPlaygrounnd();
            if(pg.getWinner() != '_'){
                System.out.println(pg.getWinner() + " is win!!!");
                System.exit(0);
            }
        }
        try{
            pg.putX(get.getXY());
        } catch(AlreadyEnteredException ex){
            System.out.println(ex.getMessage());
        }
        pg.printPlaygrounnd();
        System.out.println(pg.getWinner());
    }
}
