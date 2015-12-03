
public class ElementaryLogic {
    public int[] getNextWinWay(Playground pg){
        int[] xy = {-1,-1};
        for (int i = 0; i < 3; i++){
            if (pg.getZero()[0][i] == 2 && pg.getCross()[0][i] == 0){
                for (int j = 0; j <3; j++){
                    if (pg.getTable()[j][i] == '_'){
                        xy[0] = j+1;
                        xy[1] = i+1;
                        return xy;
                    }
                }
            }
            if (pg.getZero()[1][i] == 2 && pg.getCross()[1][i] == 0){
                for (int j = 0; j <3; j++){
                    if (pg.getTable()[i][j] == '_'){
                        xy[0] = i+1;
                        xy[1] = j+1;
                        return xy;
                    }
                }
            }
        }
        if (pg.getZero()[0][3] == 2 && pg.getCross()[0][3] == 0){
            for (int j = 0; j <3; j++){
                if (pg.getTable()[j][j] == '_'){
                    xy[0] = j+1;
                    xy[1] = j+1;
                    return xy;
                }
            }
        }
        if (pg.getZero()[1][3] == 2 && pg.getCross()[1][3] == 0){
            for (int j = 0; j <3; j++){
                if (pg.getTable()[j][2-j] == '_'){
                    xy[0] = j+1;
                    xy[1] = 2-j+1;
                    return xy;
                }
            }
        }
        return xy;
    }
    
    public int[] getNextProtectWay(Playground pg){
        int[] xy = {-1,-1};
        for (int i = 0; i < 3; i++){
            if (pg.getZero()[0][i] == 0 && pg.getCross()[0][i] == 2){
                for (int j = 0; j <3; j++){
                    if (pg.getTable()[j][i] == '_'){
                        xy[0] = j+1;
                        xy[1] = i+1;
                        return xy;
                    }
                }
            }
            if (pg.getZero()[1][i] == 0 && pg.getCross()[1][i] == 2){
                for (int j = 0; j <3; j++){
                    if (pg.getTable()[i][j] == '_'){
                        xy[0] = i+1;
                        xy[1] = j+1;
                        return xy;
                    }
                }
            }
        }
        if (pg.getZero()[0][3] == 0 && pg.getCross()[0][3] == 2){
            for (int j = 0; j <3; j++){
                if (pg.getTable()[j][j] == '_'){
                    xy[0] = j+1;
                    xy[1] = j+1;
                    return xy;
                }
            }
        }
        if (pg.getZero()[1][3] == 0 && pg.getCross()[1][3] == 2){
            for (int j = 0; j <3; j++){
                if (pg.getTable()[j][2-j] == '_'){
                    xy[0] = j+1;
                    xy[1] = 2-j+1;
                    return xy;
                }
            }
        }
        return xy;
    }
    public int[] getPossibleWay(Playground pg){
        int[] xy = {-1,-1};
        if (pg.getZero()[0][3] == 1 && pg.getCross()[0][3] == 0){
            for (int j = 0; j <3; j++){
                if (pg.getTable()[j][j] == '_'){
                    xy[0] = j+1;
                    xy[1] = j+1;
                    return xy;
                }
            }
        }
        if (pg.getZero()[1][3] == 1 && pg.getCross()[1][3] == 0){
            for (int j = 0; j <3; j++){
                if (pg.getTable()[j][2-j] == '_'){
                    xy[0] = j+1;
                    xy[1] = 2-j+1;
                    return xy;
                }
            }
        }
        for (int i = 0; i < 3; i++){
            if (pg.getZero()[0][i] == 1 && pg.getCross()[0][i] == 0){
                for (int j = 0; j <3; j++){
                    if (pg.getTable()[j][i] == '_'){
                        xy[0] = j+1;
                        xy[1] = i+1;
                        return xy;
                    }
                }
            }
            if (pg.getZero()[1][i] == 1 && pg.getCross()[1][i] == 0){
                for (int j = 0; j <3; j++){
                    if (pg.getTable()[i][j] == '_'){
                        xy[0] = i+1;
                        xy[1] = j+1;
                        return xy;
                    }
                }
            }
        }
        return xy;
    }
    public int[] getCenter(Playground pg){
        int[] xy = {-1,-1};
        if (pg.getTable()[1][1] == '_'){
            xy[0] = 2;
            xy[1] = 2;
        }
        return xy;
    } 
    public int[] getEmptyPoint(Playground pg){
        int[] xy = {-1,-1};
        for(int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                if(pg.getTable()[i][j] == '_'){
                    xy[0] = i+1;
                    xy[1] = j+1;
                    return xy;
                }
            }
        }
        return xy;
    }
}
