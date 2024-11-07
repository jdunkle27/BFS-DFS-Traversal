public class Sample {
    public static void main(String[] args) throws InterruptedException {
       //This maze was created using https://www.dcode.fr/maze-generator
        String mazeString = """
            X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,\
            X,S,O,O,O,O,O,O,O,O,X,O,O,O,O,O,O,O,O,O,O,O,O,O,O,O,O,O,O,O,X,O,O,O,O,O,X,O,X,O,X,\
            X,X,X,O,X,X,X,X,X,X,X,O,X,O,X,O,X,X,X,O,X,X,X,O,X,X,X,X,X,O,X,O,X,X,X,O,X,O,X,O,X,\
            X,O,O,O,X,O,O,O,X,O,O,O,X,O,X,O,O,O,X,O,X,O,O,O,X,O,O,O,O,O,X,O,O,O,X,O,O,O,O,O,X,\
            X,O,X,X,X,X,X,O,X,X,X,X,X,X,X,X,X,X,X,X,X,O,X,X,X,O,X,O,X,O,X,O,X,X,X,O,X,O,X,X,X,\
            X,O,O,O,X,O,X,O,X,O,O,O,X,O,O,O,X,O,X,O,O,O,O,O,X,O,X,O,X,O,O,O,X,O,O,O,X,O,O,O,X,\
            X,O,X,X,X,O,X,O,X,X,X,O,X,O,X,X,X,O,X,X,X,X,X,X,X,O,X,X,X,X,X,O,X,X,X,X,X,X,X,O,X,\
            X,O,X,O,O,O,O,O,O,O,X,O,O,O,X,O,O,O,O,O,O,O,O,O,X,O,O,O,X,O,X,O,X,O,O,O,O,O,O,O,X,\
            X,O,X,X,X,O,X,X,X,O,X,X,X,O,X,O,X,X,X,X,X,X,X,O,X,O,X,X,X,O,X,X,X,X,X,X,X,O,X,X,X,\
            X,O,O,O,X,O,X,O,X,O,X,O,O,O,X,O,X,O,X,O,O,O,X,O,X,O,X,O,X,O,O,O,X,O,O,O,X,O,X,O,X,\
            X,X,X,O,X,O,X,O,X,X,X,O,X,X,X,O,X,O,X,X,X,O,X,X,X,X,X,O,X,O,X,X,X,O,X,X,X,O,X,O,X,\
            X,O,O,O,X,O,O,O,X,O,O,O,O,O,O,O,O,O,X,O,O,O,O,O,X,O,O,O,O,O,O,O,O,O,O,O,O,O,X,O,X,\
            X,O,X,X,X,X,X,O,X,X,X,X,X,X,X,O,X,X,X,X,X,O,X,X,X,X,X,X,X,X,X,O,X,X,X,O,X,O,X,O,X,\
            X,O,O,O,X,O,O,O,O,O,O,O,X,O,O,O,O,O,O,O,O,O,X,O,O,O,O,O,O,O,X,O,X,O,O,O,X,O,O,O,X,\
            X,O,X,O,X,O,X,X,X,O,X,X,X,O,X,X,X,O,X,O,X,X,X,O,X,X,X,X,X,O,X,X,X,X,X,O,X,X,X,X,X,\
            X,O,X,O,O,O,X,O,O,O,O,O,X,O,X,O,O,O,X,O,X,O,O,O,X,O,O,O,O,O,O,O,X,O,O,O,O,O,X,O,X,\
            X,X,X,X,X,O,X,X,X,O,X,O,X,O,X,X,X,X,X,O,X,O,X,X,X,X,X,X,X,X,X,O,X,X,X,O,X,O,X,O,X,\
            X,O,O,O,X,O,X,O,O,O,X,O,X,O,O,O,O,O,X,O,O,O,O,O,X,O,O,O,O,O,O,O,X,O,O,O,X,O,O,O,X,\
            X,X,X,O,X,O,X,O,X,X,X,O,X,O,X,X,X,O,X,O,X,X,X,O,X,X,X,X,X,X,X,X,X,X,X,O,X,O,X,X,X,\
            X,O,O,O,O,O,X,O,X,O,X,O,O,O,O,O,X,O,X,O,X,O,X,O,O,O,O,O,X,O,X,O,O,O,O,O,X,O,X,O,X,\
            X,O,X,X,X,X,X,X,X,O,X,X,X,X,X,X,X,X,X,X,X,O,X,O,X,X,X,X,X,O,X,X,X,O,X,X,X,X,X,O,X,\
            X,O,O,O,X,O,O,O,X,O,O,O,X,O,O,O,O,O,X,O,O,O,X,O,O,O,O,O,O,O,O,O,O,O,O,O,X,O,O,O,X,\
            X,X,X,O,X,O,X,X,X,O,X,O,X,O,X,O,X,X,X,X,X,O,X,X,X,O,X,X,X,O,X,X,X,X,X,O,X,O,X,X,X,\
            X,O,O,O,O,O,O,O,O,O,X,O,X,O,X,O,O,O,O,O,O,O,X,O,O,O,X,O,O,O,O,O,X,O,X,O,O,O,O,O,X,\
            X,O,X,O,X,O,X,X,X,X,X,O,X,X,X,O,X,X,X,X,X,O,X,O,X,X,X,X,X,X,X,X,X,O,X,O,X,X,X,O,X,\
            X,O,X,O,X,O,O,O,O,O,X,O,X,O,X,O,X,O,O,O,O,O,O,O,O,O,O,O,X,O,X,O,O,O,O,O,X,O,X,O,X,\
            X,O,X,X,X,O,X,O,X,O,X,O,X,O,X,X,X,O,X,O,X,X,X,X,X,X,X,X,X,O,X,X,X,X,X,O,X,O,X,O,X,\
            X,O,O,O,X,O,X,O,X,O,X,O,O,O,X,O,O,O,X,O,O,O,O,O,X,O,O,O,X,O,O,O,X,O,O,O,O,O,X,O,X,\
            X,O,X,X,X,X,X,X,X,X,X,O,X,O,X,O,X,X,X,X,X,X,X,X,X,O,X,X,X,O,X,X,X,X,X,X,X,O,X,O,X,\
            X,O,X,O,O,O,X,O,O,O,X,O,X,O,X,O,O,O,O,O,O,O,X,O,O,O,O,O,O,O,O,O,O,O,X,O,O,O,X,O,X,\
            X,X,X,X,X,O,X,O,X,X,X,X,X,X,X,O,X,X,X,X,X,O,X,X,X,X,X,X,X,X,X,X,X,O,X,X,X,O,X,X,X,\
            X,O,X,O,O,O,O,O,O,O,O,O,O,O,O,O,X,O,O,O,O,O,X,O,X,O,X,O,O,O,O,O,X,O,O,O,O,O,X,O,X,\
            X,O,X,O,X,O,X,O,X,O,X,O,X,X,X,X,X,X,X,O,X,X,X,O,X,O,X,O,X,O,X,X,X,X,X,O,X,X,X,O,X,\
            X,O,X,O,X,O,X,O,X,O,X,O,O,O,X,O,X,O,X,O,X,O,O,O,X,O,X,O,X,O,X,O,X,O,O,O,O,O,O,O,X,\
            X,O,X,O,X,X,X,O,X,X,X,X,X,X,X,O,X,O,X,X,X,O,X,O,X,O,X,O,X,X,X,O,X,O,X,X,X,X,X,X,X,\
            X,O,O,O,X,O,O,O,O,O,O,O,O,O,O,O,O,O,X,O,O,O,X,O,X,O,O,O,O,O,O,O,O,O,O,O,O,O,O,O,X,\
            X,X,X,X,X,O,X,X,X,O,X,X,X,X,X,O,X,X,X,X,X,X,X,O,X,O,X,O,X,X,X,O,X,X,X,O,X,X,X,X,X,\
            X,O,O,O,O,O,O,O,X,O,X,O,O,O,X,O,O,O,X,O,O,O,X,O,X,O,X,O,O,O,X,O,X,O,O,O,O,O,O,O,X,\
            X,O,X,O,X,X,X,X,X,X,X,X,X,O,X,O,X,X,X,O,X,O,X,O,X,O,X,O,X,X,X,O,X,X,X,X,X,O,X,X,X,\
            X,O,X,O,O,O,O,O,X,O,O,O,O,O,O,O,O,O,O,O,X,O,X,O,O,O,X,O,O,O,X,O,X,O,O,O,O,O,O,E,X,\
            X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X,X""";

            Maze m2 = new Maze(mazeString);

            Maze m3 = new Maze(mazeString);

           
            
        System.out.println("Starting DFS traversal...");
        Thread.sleep(2000);
        System.out.print("\033[H\033[2J");
        DFS dfs = new DFS(m2);

        Thread.sleep(2000);
        System.out.println("Starting BFS traversal...");
        Thread.sleep(2000);
        System.out.print("\033[H\033[2J");
        BFS bfs = new BFS(m3);
    }
}
