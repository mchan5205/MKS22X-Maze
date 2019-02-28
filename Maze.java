import java.util.*;
import java.io.*;
public class Maze{
  private char[][]maze;
  private boolean animate;
  public Maze(String filename) throws FileNotFoundException{
    String line;
    int i;
    File f = new File(filename);
    Scanner s = new Scanner(f);
    while(s.hasNextLine()){
      line = s.nextLine();
      i++;
    }
    s.reset();
    i = 0;
    maze = new char[line.length][i];
    while(s.hasNextLine()){
      line = s.nextLine();
      for (int x = 0; x < line.length; x++){
        maze[x][i] = line.charAt(x);
      }
      i++
    }
    animate = false;
  }
  public int solve(){
    int sx;
    int sy;
    for (int i = 0; maze.length; i++){
      for (int x = 0; maze[i].length; x++){
        if (maze[i][x] == 'S'){
          sx = i;
          sy = x;
        }
      }
    }
    return solve(sx, sy);
  }
  private int solve(int row, int col){
    if(animate){
      clearTerminal();
      System.out.println(this);
      wait(20);
    }

  }
}
