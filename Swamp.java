import java.io.*;
import java.util.*;

public class Swamp
{
    public static void main(String[] args) throws Exception
 {
  int[] dropInPt = new int[2]; 
  int[][] swamp = loadSwamp( args[0], dropInPt );
  int row=dropInPt[0], col = dropInPt[1];
  String path = "";

  printSwamp(          "\n   SWAMP: dropped in at: ["+row+","+col+"]\n",swamp );
  System.out.println("\n  ESCAPE PATHS:\n");

  findExits(swamp, row, col,path);
 } 
    private static void findExits(int[][] swamp, int drop1, int drop2, String path )
  {
    path += "[" + drop1 + "," + drop2 + "]";
    if(drop1 == swamp.length-1 || drop2 == swamp[0].length-1 || drop1==0 || drop2 == 0)
    {
      System.out.println(path);
      return;
    }
    if(swamp[drop1-1][drop2-1] == 1)
    {
      swamp[drop1][drop2]=2;
      findExits(swamp, drop1-1, drop2-1, path);
      swamp[drop1][drop2]=1;
    }
    if(swamp[drop1][drop2-1]==1)
    {
      swamp[drop1][drop2]=2;
      findExits(swamp, drop1, drop2-1, path);
      swamp[drop1][drop2]=1;
    }
    if(swamp[drop1+1][drop2-1]==1)
    {
      swamp[drop1][drop2]=2;
      findExits(swamp, drop1+1, drop2-1, path);
      swamp[drop1][drop2]=1;
    }
    if(swamp[drop1+1][drop2]==1)
    {
      swamp[drop1][drop2]=2;
      findExits(swamp, drop1+1, drop2, path);
      swamp[drop1][drop2]=1;
    }
    if(swamp[drop1+1][drop2+1]==1)
    {
      swamp[drop1][drop2]=2;
      findExits(swamp, drop1+1, drop2+1, path);
      swamp[drop1][drop2]=1;
    }
    if(swamp[drop1][drop2+1]==1)
    {
      swamp[drop1][drop2]=2;
      findExits(swamp, drop1, drop2+1, path);
      swamp[drop1][drop2]=1;
    }
    if(swamp[drop1-1][drop2+1]==1)
    {
      swamp[drop1][drop2]=2;
      findExits(swamp, drop1-1, drop2+1, path);
      swamp[drop1][drop2]=1;
    }
    if(swamp[drop1-1][drop2]==1)
    {
      swamp[drop1][drop2]=2;
      findExits(swamp, drop1-1, drop2, path);
      swamp[drop1][drop2]=1;
    }
    return;
  }
  private static void printSwamp(String label, int[][] swamp )
 {
  System.out.println( label );
  System.out.print("   ");
  for(int c = 0; c < swamp.length; c++)
   System.out.print( c + " " ) ;
  System.out.print( "\n   ");
  for(int c = 0; c < swamp.length; c++)
   System.out.print("- ");
  System.out.print( "\n");

  for(int r = 0; r < swamp.length; r++)
  { System.out.print( r + "| ");
   for(int c = 0; c < swamp[r].length; c++)
    System.out.print( swamp[r][c] + " ");
   System.out.println("|");
  }
  System.out.print( "   ");
  for(int c = 0; c < swamp.length; c++)
   System.out.print("- ");
  System.out.print( "\n");
 }

 
 private static int[][] loadSwamp( String infileName, int[] dropInPt  ) throws Exception
 {
  Scanner infile = new Scanner( new File(infileName) );
  int rows=infile.nextInt();
  int cols = rows;    // ASSUME A SQUARE GRID
  dropInPt[0]=infile.nextInt();  dropInPt[1]=infile.nextInt();
  int[][] swamp = new int[rows][cols];
  for(int r = 0; r < rows ; r++)
   for(int c = 0; c < cols; c++)
    swamp[r][c] = infile.nextInt();

  infile.close();
  return swamp;
 }
}
