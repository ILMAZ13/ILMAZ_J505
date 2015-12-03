
public class HardGamer {
    private GetXY get;
    private Playground pg;
    private HardLogic mi;
    private Tester te;
    
    public HardGamer(GetXY get,Playground pg,HardLogic mi,Tester te){
        this.get = get;
        this.mi = mi;
        this.pg = pg;
        this.te = te;
    }
    public void playHard(){
        int[] xy  = {-1,-1};
        int[] xy1 = {-1,-1};
        while (pg.getMoveCount()<8){
            xy = te.getAndTest();
            if(xy[0]<0){
                    mi.findFirstMoveType(pg);
                if (mi.getFirstMoveType() == 1 && !mi.isMoved()){
                    xy = mi.getTypeOneNextMove(pg,pg.getMoveCount()-1);
                } else {
                    if (mi.getFirstMoveType() == 2 && !mi.isMoved()){
                        xy = mi.getTypeTwoNextMove(pg);
                    } else {
                        if (mi.getFirstMoveType() == 3 && !mi.isMoved() && pg.getMoveCount() == 3){
                            xy = mi.getTypeThreeNextMove(pg);
                        } else {
                            xy = mi.getPossibleWay(pg);
                            if (xy[0]<0){
                                xy = mi.getEmptyPoint(pg);
                            }
                        }
                    }
                }
            }
            pg.putO(xy);
            pg.printPlaygrounnd();
            if(pg.getWinner() != '_'){
                System.out.println(pg.getWinner()  + " is win!!!");
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
