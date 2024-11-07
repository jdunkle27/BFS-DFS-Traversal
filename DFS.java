/**
 * This class is the DFS class. It requires Maze.java and Tile.java
 * This class takes in a Maze and performs a DFS traversal on it.
 * @author Jonathan Dunkle
 * @version 11.6
 */

import java.util.Scanner;
import java.util.Stack;


public class DFS {
    private Maze maz;
    private Stack<Tile> s;
    private Tile t;
    private int steps; //Debug variable

    //This array provides the directions for the traversal.
    private final int[][] DIRECTIONS = {
        {0, 1}, //East [0]
        {1, 0}, //South [1]
        {0, -1}, //West [2]
        {-1, 0} //North [3]
    };


    //Constructor that takes in a Maze object and then starts the conductSearch method.
    public DFS(Maze m) throws InterruptedException{
        Tile start = m.getStart();
        Tile end = m.getEnd();

        conductSearch(m, start, end);
    }

     //The main DFS traversal is done here
    public void conductSearch(Maze m, Tile start, Tile end) throws InterruptedException{
        steps = 0;
        maz = m;
        start.visit();
        s = new Stack<Tile>();
        s.push(start);

         //Prints the maze in its original form
        System.out.println(maz);

         //Starts a keyboard scanner to slow the traversal process down.
       // Scanner keyboard = new Scanner(System.in);

         //Main loop of the traversal, runs while the stack is not empty.
        while(!s.isEmpty()){
            //Pops a tile from the stack and marks it as visited.
            t= s.pop();
            m.updateTile(t.x(),t.y());

           t.setSteps(steps); //Debug tools

           //Prints the current coordinates and the maze, marking where the algorithm has visited.
            //System.out.println(t.x() + "," + t.y());
            System.out.println(maz);
            

            //Checks to see if the algorithm is at the end.
            if(t.x() == end.x() && t.y() == end.y()){
                System.out.println("Found End in " + steps + " steps");
                return;
            }


            for(int i = 0 ; i < DIRECTIONS.length; i++){
                //Checks all the tiles around the current one to see if they are walkable.
                if(maz.checkTile(t.x() + DIRECTIONS[i][1], t.y() + DIRECTIONS[i][0])){
                    //Adds everything to the stack.
                    s.push(maz.getTile(t.x() + DIRECTIONS[i][1], t.y() + DIRECTIONS[i][0]));
                }
            }
            //Makes user press enter to view the next step.
            //System.out.println(keyboard.nextLine());
            Thread.sleep(20);
            steps++;
        }
        //keyboard.close();
    }
}
