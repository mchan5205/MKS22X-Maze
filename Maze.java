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
    int fin;
    if(animate){
      clearTerminal();
      System.out.println(this);
      wait(20);
    }
    if (maze[row][col] == 'E'){
      return ;
    }
    maze[row][col] = '@';
    if (maze[row + 1][col] != 'x' || maze[row + 1][col] != '@' || maze[row + 1][col] != '.'){
      fin = solve[row + 1][col];
      if (fin != -1){
        return fin;
      }
    }
    if (maze[row - 1][col] != 'x' || maze[row - 1][col] != '@' || maze[row - 1][col] != '.'){
      fin = solve[row - 1][col];
      if (fin != -1){
        return fin;
      }
    }
    if (maze[row][col + 1] != 'x' || maze[row][col + 1] != '@' || maze[row][col + 1] != '.'){
      fin = solve[row][col + 1];
      if (fin != -1){
        return fin;
      }
    }
    if (maze[row][col - 1] != 'x' || maze[row][col - 1] != '@' || maze[row][col - 1] != '.'){
      fin = solve[row][col - 1];
      if (fin != -1){
        return fin;
      }
    }
    maze[row][col] = '.';
    return -1;
  }
}
