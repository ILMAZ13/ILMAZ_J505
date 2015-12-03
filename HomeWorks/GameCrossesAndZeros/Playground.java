
public class Playground {
    private char[][] table = new char[3][3];
    private int[][]    cross = new int[2][4];
    private int[][]     zero = new int[2][4];
    private int[][]    moves = new int[9][2];
    private int  moveCount = 0;
    
    public Playground(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                table[i][j] = '_';
            }
        }
    }
    
    public void putX(int[] xy) throws AlreadyEnteredException{
        xy[0]--;
        xy[1]--;
        if (table[xy[0]][xy[1]] == '_'){
            table[xy[0]][xy[1]] = 'X';
            cross[0][xy[1]]++;
            cross[1][xy[0]]++;
            if (xy[0] == xy[1]){
                cross[0][3]++;
            }
            if (xy[0] == 2 - xy[1]){
                cross[1][3]++;
            }
            
        } else {
            throw new AlreadyEnteredException("Error!!! This point is already entered!!! Repeat plaese!!!");
        }
        xy[0]++;
        xy[1]++;
        moves[moveCount][0] = xy[0];
        moves[moveCount][1] = xy[1];
        moveCount++;
    }
    
    public void putO(int[] xy){
        xy[0]--;
        xy[1]--;
        table[xy[0]][xy[1]] = 'O';
        zero[0][xy[1]]++;
        zero[1][xy[0]]++;
        if (xy[0] == xy[1]){
            zero[0][3]++;
        }
        if (xy[0] == 2 - xy[1]){
            zero[1][3]++;
        }
        xy[0]++;
        xy[1]++;
        
        moves[moveCount][0] = xy[0];
        moves[moveCount][1] = xy[1];
        moveCount++;
    }

    public int[][] getMoves() {
        return moves;
    }
    
    
    public char getWinner(){
        for (int i = 0; i < 4; i++){
            if (cross[0][i] == 3 || cross[1][i] == 3){
                return 'X';
            }
            if (zero[0][i] == 3 || zero[1][i] == 3){
                return 'O';
            }
        }
        return '_';
    }
    
    public void printPlaygrounnd(){
        System.out.println(" _ _ _ ");
        for (int i = 0; i < 3; i++){
            System.out.println("|" + table[i][0] + "|" + table[i][1] + "|" + table[i][2] + "|");
        }
    }

    public char[][] getTable() {
        return table;
    }

    public int[][] getCross() {
        return cross;
    }

    public int[][] getZero() {
        return zero;
    }

    public int getMoveCount() {
        return moveCount;
    }
    
    
}
