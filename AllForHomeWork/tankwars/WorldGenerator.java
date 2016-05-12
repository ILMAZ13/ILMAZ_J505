
package tankwars;

/**
 *
 * @author Artem
 */
public class WorldGenerator {
    // Object index
    public static final int FLOOR = -1;
    public static final int WALL = 1;
    public static final int EMPTY = 0;
    
    /*
    * linearity = 0.5..1;
    */
    public static int[][] generate(int countRoom, int roomMaxSize, int roomMinSize, double linearity){
        int[][] mapStructure = WorldGenerator.generateStructure(countRoom, Math.max(linearity, 0.5));
        return WorldGenerator.generateRooms(mapStructure, roomMaxSize, roomMinSize);
    }
    public static int[][] generate(int[][] mapStructure, int roomMaxSize, int roomMinSize){
        return WorldGenerator.generateRooms(mapStructure, roomMaxSize, roomMinSize);
    }
    private static int[][] generateStructure(int countRoom, double linearity){
        int[][] tempMap = new int[countRoom][countRoom];
        
        int lineSize = (int)Math.round(Math.max(linearity, 0.5) * countRoom);
        
        int[][] lineOfRoom = new int[lineSize][2];
        int lineOfRoomCount = 1;
        int currentCountRoom = 1;
        lineOfRoom[0][0] = (int)Math.round(countRoom / 2);
        lineOfRoom[0][1] = (int)Math.round(countRoom / 2);
        tempMap[lineOfRoom[0][0]][lineOfRoom[0][1]] = 1;
        
        while (currentCountRoom < countRoom){
            int tempRoom = (int)Math.round(Math.random() * (lineOfRoomCount - 1));
            int x = lineOfRoom[tempRoom][0];
            int y = lineOfRoom[tempRoom][1];
            int xx = (int)Math.round(Math.random() * 2 - 1);
            int yy = (int)Math.round(Math.random() * 2 - 1);
            lineOfRoom[0][0] = x;
            lineOfRoom[0][1] = y;
            lineOfRoomCount = 1;
            for(int i = 0; i < lineSize - 1; i++){
                
                if (x + xx < 0){
                    xx = 0;
                }
                else{
                    if (x + xx >= countRoom){
                        xx = 0;
                    }
                }
                if (y + yy < 0){
                    yy = 0;
                }
                else{
                    if (y + yy >= countRoom){
                        yy = 0;
                    }
                }
                if ((xx != 0) && (yy != 0)){
                    int r = (int)Math.round(Math.random());
                    if (r == 0){
                        xx = 0;
                    }
                    else{
                        yy = 0;
                    }
                }
                lineOfRoom[lineOfRoomCount][0] = x + xx;
                lineOfRoom[lineOfRoomCount][1] = y + yy;
                if (tempMap[lineOfRoom[lineOfRoomCount][0]][lineOfRoom[lineOfRoomCount][1]] != 1){
                    currentCountRoom += 1;
                }
                tempMap[lineOfRoom[lineOfRoomCount][0]][lineOfRoom[lineOfRoomCount][1]] = 1;
                lineOfRoomCount += 1;
                if (currentCountRoom >= countRoom){
                    break;
                }
            }
        }
        //---cut 0-0-0-0-0-0-0-0-0 Kerry King style
        int x0 = 0;
        for(int i = 0; i < tempMap.length; i++){
            boolean f = true;
            for(int j = 0; j < tempMap[0].length; j++){
                if (tempMap[i][j] == 1){
                    f = false;
                }
            }
            if (f){
                x0++;
            }
            else{
                break;
            }
        }
        int y0 = 0;
        for(int i = 0; i < tempMap[0].length; i++){
            boolean f = true;
            for(int j = 0; j < tempMap.length; j++){
                if (tempMap[j][i] == 1){
                    f = false;
                }
            }
            if (f){
                y0++;
            }
            else{
                break;
            }
        }
        int x1 = tempMap.length;
        for(int i = tempMap.length - 1; i >= 0; i--){
            boolean f = true;
            for(int j = 0; j < tempMap[0].length; j++){
                if (tempMap[i][j] == 1){
                    f = false;
                }
            }
            if (f){
                x1--;
            }
            else{
                break;
            }
        }
        int y1 = tempMap[0].length;
        for(int i = tempMap[0].length - 1; i >= 0; i--){
            boolean f = true;
            for(int j = 0; j < tempMap.length; j++){
                if (tempMap[j][i] == 1){
                    f = false;
                }
            }
            if (f){
                y1--;
            }
            else{
                break;
            }
        }
        int[][] tempMap2 = new int[x1 - x0][y1 - y0];
        for(int i = x0; i < x1; i++){
            for(int j = y0; j < y1; j++){
                tempMap2[i - x0][j - y0] = tempMap[i][j];
            }
        }
        return tempMap2;
    }
    private static int[][] generateRooms(int[][] mapStructure, int roomMaxSize, int roomMinSize){
        int border = 10;
        int weight = mapStructure.length * roomMaxSize + border;
        int height = mapStructure[0].length * roomMaxSize + border;
        
        int[][] tempMap = new int[weight][height];
        /*
        *   tempMap:
                0 = empty
        *      -1 = floor
        *       1 = wall
        */
        int countRoom = 0;
        //calculate rooms
        for(int i = 0; i < mapStructure.length; i++){
            for(int j = 0; j < mapStructure[0].length; j++){
                if (mapStructure[i][j] == 1){
                    countRoom += 1;
                }
            }
        }
        //--------------------------------
        
        //fill array
        for(int i = 0; i < weight; i++){
            for(int j = 0; j < height; j++){
                tempMap[i][j] = EMPTY;
            }
        }
        //generate rooms
        int[] roomStartX = new int[countRoom];
        int[] roomStartY = new int[countRoom];
        int[] roomEndX = new int[countRoom];
        int[] roomEndY = new int[countRoom];
        int[][] roomLink = new int[mapStructure.length][mapStructure[0].length];
        //fill link
        for(int i = 0; i < roomLink.length; i++){
            for(int j = 0; j < roomLink[0].length; j++){
                roomLink[i][j] = -1;
            }
        }
        //----------
        int currentRoom = 0;
        for(int i = 0; i < mapStructure.length; i++){
            for(int j = 0; j < mapStructure[0].length; j++){
                if (mapStructure[i][j] == 1){
                    roomStartX[currentRoom] = (int)Math.round(Math.random() * ((roomMaxSize - roomMinSize)));
                    roomStartY[currentRoom] = (int)Math.round(Math.random() * ((roomMaxSize - roomMinSize)));
                    roomEndX[currentRoom] = roomStartX[currentRoom] + roomMinSize + (int)Math.round(Math.random() * (roomMaxSize - roomMinSize - roomStartX[currentRoom] ));
                    roomEndY[currentRoom] = roomStartY[currentRoom] + roomMinSize + (int)Math.round(Math.random() * (roomMaxSize - roomMinSize - roomStartY[currentRoom]));
                    roomStartX[currentRoom] += i * roomMaxSize + border / 2;
                    roomStartY[currentRoom] += j * roomMaxSize + border / 2;
                    roomEndX[currentRoom] += i * roomMaxSize + border / 2;
                    roomEndY[currentRoom] += j * roomMaxSize + border / 2;
                    roomLink[i][j] = currentRoom;
                    for(int ii = roomStartX[currentRoom]; ii < roomEndX[currentRoom]; ii++){
                        for(int jj = roomStartY[currentRoom]; jj < roomEndY[currentRoom]; jj++){
                            //make floor of room
                            tempMap[ii][jj] = FLOOR;
                        }
                    }
                    currentRoom += 1;
                }
            }
        }  
        //generate corridors
        for(int i = 0; i < roomLink.length - 1; i++){
            for(int j = 0; j < roomLink[0].length - 1; j++){
                if (roomLink[i][j] != -1){
                    if (roomLink[i + 1][j] != -1){
                        int startX = roomEndX[roomLink[i][j]];
                        int endX = roomStartX[roomLink[i + 1][j]];
                        int startY = roomStartY[roomLink[i][j]] + (int)Math.round((roomEndY[roomLink[i][j]] - roomStartY[roomLink[i][j]]) / 2);
                        int endY = roomStartY[roomLink[i + 1][j]] + (int)Math.round((roomEndY[roomLink[i + 1][j]] - roomStartY[roomLink[i + 1][j]]) / 2);
                        int tempX = Math.max(startX - 1, 0);
                        int tempY = Math.max(startY - 1, 0);
                        while(tempX <= endX){
                            tempMap[tempX][tempY] = FLOOR;
                            tempX += 1;
                            
                        }
                        tempMap[tempX][tempY] = FLOOR;
                        while(tempY != endY){
                            if (tempY >= endY){
                                tempY -= 1;
                            }
                            else{
                                tempY += 1;
                            }
                            tempMap[tempX][tempY] = FLOOR;
                        }
                    }
                    if (roomLink[i][j + 1] != -1){
                        int startY = roomEndY[roomLink[i][j]];
                        int endY = roomStartY[roomLink[i][j + 1]];
                        int startX = roomStartX[roomLink[i][j]] + (int)Math.round((roomEndX[roomLink[i][j]] - roomStartX[roomLink[i][j]])/2) + 1;
                        int endX = roomStartX[roomLink[i][j + 1]] + (int)Math.round((roomEndX[roomLink[i][j + 1]] - roomStartX[roomLink[i][j + 1]])/2) + 1;
                        int tempX = Math.max(startX - 1, 0);
                        int tempY = Math.max(startY - 1, 0);
                        while(tempY <= endY){
                            tempMap[tempX][tempY] = FLOOR;
                            tempY += 1;
                            
                        }
                        tempMap[tempX][tempY] = FLOOR;
                        while(tempX != endX){
                            if (tempX > endX){
                                tempX -= 1;
                            }
                            else{
                                tempX += 1;
                            }
                            tempMap[tempX][tempY] = FLOOR;
                        }
                    }
                }
            }
        }
        // generate walls
        for(int i = 1; i < tempMap.length - 1; i++){
            for(int j = 1; j < tempMap[0].length - 1; j++){
                if (tempMap[i][j] == FLOOR){
                    if (tempMap[i + 1][j] == EMPTY){
                        tempMap[i + 1][j] = WALL;
                    }
                    if (tempMap[i + 1][j + 1] == EMPTY){
                        tempMap[i + 1][j + 1] = WALL;
                    }
                    if (tempMap[i][j + 1] == EMPTY){
                        tempMap[i][j + 1] = WALL;
                    }
                    if (tempMap[i - 1][j + 1] == EMPTY){
                        tempMap[i - 1][j + 1] = WALL;
                    }
                    if (tempMap[i - 1][j] == EMPTY){
                        tempMap[i - 1][j] = WALL;
                    }
                    if (tempMap[i - 1][j - 1] == EMPTY){
                        tempMap[i - 1][j - 1] = WALL;
                    }
                    if (tempMap[i][j - 1] == EMPTY){
                        tempMap[i][j - 1] = WALL;
                    }
                    if (tempMap[i + 1][j - 1] == EMPTY){
                        tempMap[i + 1][j - 1] = WALL;
                    }
                }
            }
        } 
        return tempMap;
    }
}
