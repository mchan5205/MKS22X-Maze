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
