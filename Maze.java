import java.util.*;
import java.io.*;
public class Maze{
  private char[][]maze;
  private boolean animate;
  public Maze(String filename) throws FileNotFoundException{
    String line = "";
    int i = 0;
    File f = new File(filename);
    Scanner s = new Scanner(f);
    while(s.hasNextLine()){
      line = s.nextLine();
      i++;
    }
    Scanner c = new Scanner(f);
    maze = new char[line.length()][i];
    i = 0;
    while(c.hasNextLine()){
      line = c.nextLine();
      for (int x = 0; x < line.length(); x++){
        maze[x][i] = line.charAt(x);
      }
      i++;
    }
    animate = false;
  }
  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }
  public void clearTerminal(){
    //erase terminal, go to top left of screen.
    System.out.println("\033[2J\033[1;1H");
  }
  public int solve(){
    int sx = 0;
    int sy = 0;
    for (int i = 0; i < maze.length; i++){
      for (int x = 0; x < maze[i].length; x++){
        if (maze[i][x] == 'S'){
          sx = i;
          sy = x;
        }
      }
    }
    return solve(sx, sy);
  }
  private int solve(int row, int col){
    int fin = 0;
    if (row < 0 || row > maze.length - 1 || col < 0 || col > maze[0].length - 1){
      return -1;
    }
    if(animate){
      clearTerminal();
      System.out.println(this);
      wait(1000);
    }
    if (maze[row][col] == 'E'){
      for (int r = 0; r < maze.length; r++){
        for (int c = 0; c < maze[r].length;c++){
          if (maze[r][c] == '@'){
            fin += 1;
          }
        }
      }
      return fin;
    }
    maze[row][col] = '@';
    if (maze[row + 1][col] != '#' && maze[row + 1][col] != '@' && maze[row + 1][col] != '.'){
      fin = solve(row + 1, col);
      if (fin != -1){
        return fin;
      }
    }
    if (maze[row - 1][col] != '#' && maze[row - 1][col] != '@' && maze[row - 1][col] != '.'){
      fin = solve(row - 1, col);
      if (fin != -1){
        return fin;
      }
    }
    if (maze[row][col + 1] != '#' && maze[row][col + 1] != '@' && maze[row][col + 1] != '.'){
      fin = solve(row, col + 1);
      if (fin != -1){
        return fin;
      }
    }
    if (maze[row][col - 1] != '#' && maze[row][col - 1] != '@' && maze[row][col - 1] != '.'){
      fin = solve(row, col - 1);
      if (fin != -1){
        return fin;
      }
    }
    maze[row][col] = '.';
    return -1;
  }
  public void setAnimate(boolean b){
    animate = b;
  }
  public String toString(){
    String y = "";
    for (int r = 0; r < maze.length; r++){
      for (int c = 0; c < maze[r].length; c++){
        y += maze[r][c];
      }
      y += "\n";
    }
    return y;
  }
}
