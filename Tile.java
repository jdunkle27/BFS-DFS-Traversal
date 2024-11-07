/**
 * This class is the Tile class. It is mostly useless on its own without the Maze.java class.
 * Tiles can be walkable, start, or end. 
 * @author Jonathan Dunkle
 * @version 11.6
 */

public class Tile {
    private boolean walkable, isStart, isEnd, visited;
    private int xPos, yPos, steps; //Steps is a debug variable

    public Tile(){
        this(true, false, false, 0, 0);
    }

    public Tile(boolean walk, boolean start, boolean end, int x, int y){
        this.walkable = walk;
        this.isStart = start; 
        this.isEnd = end;
        visited = false;
        xPos = x;
        yPos = y;
        steps = 0;
    }

    public Tile(String str, int x, int y){
        if(str.equals("X"))
            setParams(false, false, false,x,y);

        else if(str.equals("O"))
            setParams(true,false,false,x,y);      
        
        else if(str.equals("E"))
            setParams(true,false,true,x,y);

        else
            setParams(true,true,false,x,y);
    }

    private void setParams(boolean walk, boolean start, boolean end, int x, int y){
        this.walkable = walk;
        this.isStart = start; 
        this.isEnd = end;
        visited = false;
        xPos = x;
        yPos = y;
        steps = 0;
    }

    public int x(){
        return xPos;
    }

    public int y(){
        return yPos;
    }

    public void setX(int x){
        xPos = x;
    }

    public void setY(int y){
        yPos = y;
    }

    public void visit(){
        visited = true;
    }

    public boolean isVisited(){
        return visited;
    }

    public boolean isWalkable(){
        return walkable;
    }

    public boolean isEnd(){
        return this.isEnd;
    }

    public boolean isStart(){
        return this.isStart;
    }

    public void setSteps(int steps){
        this.steps = steps;
    }

    @Override
    public String toString(){
        if(walkable == false)
            return "███";
        else if(this.isStart)
            return " S ";
        else if(this.isEnd)
            return " E ";
        else if(visited)
            return "▓▓▓";
            //return "▓" + steps + "▓";
        else   
            return "░░░";
    }
}
