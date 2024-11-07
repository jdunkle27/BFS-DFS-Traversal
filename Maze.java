/**
 * This class is the Maze class. It is reliant on the Tile class.
 * Mazes can be generated or custom made via the multiple constructors.
 * All mazes will be square.
 * @author Jonathan Dunkle
 * @version 11.6
 */


public class Maze {
    private Tile[][] mazTiles;
    private int size, maxObs;

    /**
     * Constructs a random Maze with 1/3 of the tiles being obstacles.
     * Random maze generation may be impossible.
     * @param s The length and width of the Maze
    */
    public Maze(int s){
        size = s;
        mazTiles = new Tile[size][size];
        maxObs = (int)((Math.pow(size, 2)) * .3333);
        addObstacles();
        selectStart();
        selectEnd();

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(mazTiles[i][j] == null){
                    
                    mazTiles[i][j] = new Tile();
                }
            }
        }
    }

    /**
     * Maze constructor that takes in an array of tiles as is.
     * @param arr An array of Tile objects. This array must be square.
     */
    public Maze(Tile[][] arr){
        mazTiles = arr;
    }

    /**
     *  Maze constructor that takes large strings so mazes can be made more visually.
     *  The string must be comprised of X's where there are obstacles, O's where the maze is walkable,
     *  and an S and E for the start and finish respectively.
     * @param str A string that reflects a square maze with the described parameters.
     */
    public Maze(String str) {
        String[] arr = str.split(",");
        size = (int)Math.sqrt(arr.length);
        int count = 0;
        Tile[][] tileArr = new Tile[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                tileArr[i][j]= new Tile(arr[count], j, i);
                count++;
            }
        }
       mazTiles = tileArr;
    }

    /**
     * Part of the random maze generation. Adds obstacles to the maze.
     * This may add obstacles that make it impossible to complete the maze.
     */
    private void addObstacles(){
        int[] positions = new int[maxObs *2];
        for(int i = 0; i < positions.length; i++){
            positions[i] = (int)(Math.random() * size);
        }

        for(int i = 0; i < positions.length; i++){
            mazTiles[positions[i]][positions[i + 1]] = new Tile(false,false,false, i + 1, i);
            i++;
        }
    }

     /**
     * Part of the random maze generation. Adds an end to the maze.
     * This may add an end that makes it impossible to complete the maze.
     */
    private void selectEnd() {
        int x = (int)(Math.random() * size);
        int y = (int)(Math.random() * size);

        mazTiles[y][x] = new Tile(true, false, true, x, y);
    }

    /**
     * Part of the random maze generation. Adds a start to the maze.
     * This may add a start that makes it impossible to complete the maze.
     */
    private void selectStart() {
        int x = (int)(Math.random() * size);
        int y = (int)(Math.random() * size);

        mazTiles[y][x] = new Tile(true, true, false, x, y);
    }

    /**
     * Gets the square size of the maze
     * @return Size of the maze
     */
    public int getSize(){
        return size;
    } 

    /**
     * Checks to see is a given tile is able to be visited.
     * @param x The x coordinate of the tile.
     * @param y The y coordinate of the tile.
     * @return True if the tile can be visited, false otherwise.
     */
    public boolean checkTile(int x, int y){
        if(x < 0 || y < 0)
            return false;

        if(x >= size || y >= size)
            return false;

        return mazTiles[y][x].isWalkable() && !mazTiles[y][x].isVisited();
    }

    /**
     * Returns a given tile.
     * @param x The x coordinate of the tile.
     * @param y The y coordinate of the tile.
     * @return The tile at the x,y coordinate.
     */
    public Tile getTile(int x, int y){
        return mazTiles[y][x];
    }

    /**
     * Marks a given tile as visited.
     * @param x The x coordinate of the tile.
     * @param y The y coordinate of the tile.
     */
    public void updateTile(int x, int y){
        mazTiles[y][x].visit();
    }

    /**
     * Returns the starting Tile of the maze.
     * @return Starting Tile.
     */
    public Tile getStart(){
        for(int i = 0; i < mazTiles.length; i++){
            for(int j = 0; j < mazTiles[i].length; j++){
                if(mazTiles[i][j].isStart()){
                    return mazTiles[i][j];
                    }
            }
        }
        return null;
    }

    /**
     * Returns the ending Tile.
     * @return Ending Tile.
     */
    public Tile getEnd(){
        for(int i = 0; i < mazTiles.length; i++){
            for(int j = 0; j < mazTiles[i].length; j++){
                if(mazTiles[i][j].isEnd()){
                    return mazTiles[i][j];
                    }
            }
        }
        return null;
    }


    @Override
    public String toString(){
        String str = "";
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                str += mazTiles[i][j];
            }
            str += "\n";
        }
        return str;
    }
}
