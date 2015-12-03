
public class HardLogic extends ElementaryLogic{
    private int firstMoveType;
    private boolean moved = false;
    
    
    public void findFirstMoveType(Playground pg){
        if (pg.getMoves()[0][0] * pg.getMoves()[0][1] % 2 == 1){
            firstMoveType = 1;
        } else {
            if (pg.getMoves()[0][0] == pg.getMoves()[0][1]){
                firstMoveType = 2;
            } else {
                firstMoveType = 3;
            }
        }
    }
    
    public int[] getTypeOneNextMove(Playground pg, int i){
        moved = true;
        int [] xy = {-1,-1};
        if (pg.getMoves()[0][0] + pg.getMoves()[i][0] != 4 || pg.getMoves()[0][1] + pg.getMoves()[i][1] != 4){
            xy[0] = 4 - pg.getMoves()[0][0];
            xy[1] = 4 - pg.getMoves()[0][1];
        } else {
            xy[0] = 4 - pg.getMoves()[0][0];
            xy[1] = 2;
        }
        return xy;
    }
    
    public int[] getTypeTwoNextMove(Playground pg){
        int[] xy = {-1,-1};
        for (int i = 0; i < 3; i=i+2) {
            for (int j = 0; j < 3; j=j+2){
                if(pg.getTable()[i][j] == '_'){
                    xy[0] = i+1;
                    xy[1] = j+1;
                    return xy;
                }                  
            }
        }
        return xy;
    }
    
    public int[] getTypeThreeNextMove(Playground pg){
        int[] xy = {-1,-1};
        moved = true;
        if (pg.getMoves()[pg.getMoveCount()-1][0] * pg.getMoves()[pg.getMoveCount()-1][1] % 2 == 1){
            xy[0] = 4 - pg.getMoves()[pg.getMoveCount()-1][0];
            xy[1] = 4 - pg.getMoves()[pg.getMoveCount()-1][1];
        } else {
            if (pg.getMoves()[0][0] == pg.getMoves()[pg.getMoveCount()-1][0] || pg.getMoves()[0][1] == pg.getMoves()[pg.getMoveCount()-1][1]){
                HardLogic mi = new HardLogic();
                xy = mi.getTypeTwoNextMove(pg);
            } else {
                if(pg.getMoves()[0][0] % 2 == 1){
                    xy[0] = pg.getMoves()[0][0];
                } else {
                    xy[0] = pg.getMoves()[2][0];
                }
                if(pg.getMoves()[0][1] % 2 == 1){
                    xy[1] = pg.getMoves()[0][1];
                } else {
                    xy[1] = pg.getMoves()[2][1];
                }
            }
        }
        return xy;
    }

    public boolean isMoved() {
        return moved;
    }
    
    public int getFirstMoveType() {
        return firstMoveType;
    }
}
