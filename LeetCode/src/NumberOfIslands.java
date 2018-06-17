/* PROBLEM STATEMENT: Number Of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

*/

import java.util.Scanner;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {

        if(grid==null || grid.length==0)
            return 0;

        int nRows=grid.length;
        int nCols=grid[0].length;
        int count=0;

        for(int i=0;i<nRows;i++)
        {
            for(int j=0;j<nCols;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row,int col)
    {
        int nRows=grid.length;
        int nCols=grid[0].length;

        if(row < 0 || col < 0 || row >= nRows || col >= nCols || grid[row][col]=='0')
            return;

        grid[row][col]='0';

        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row,col+1 );

    }

    public static void main(String[] args) {
        NumberOfIslands noi=new NumberOfIslands();
        char[][] grid=new char[4][5];
        Scanner scan=new Scanner(System.in);
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                System.out.println("Enter input: ");
                grid[i][j]=scan.next().charAt(0);
            }
        }

        int result=noi.numIslands(grid);
        System.out.println(result);
    }
}
