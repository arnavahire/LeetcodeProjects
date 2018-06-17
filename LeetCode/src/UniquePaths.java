/* PROBLEM STATEMENT: Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

*/

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int rows=m+1;           // create an additional row (0th row) and an additional column (0th column) which will contain only 0's
        int cols=n+1;

        int[][] matrix=new int[rows][cols];

        matrix[1][1]=1;        // set the matrix[1][1] cell as 1

        for(int i=1;i<rows;i++)
        {
            for(int j=1;j<cols;j++)
            {
                if(i==1 && j==1)       // for matrix[1][1] we already have value set to be 1
                    continue;
                matrix[i][j]=matrix[i][j-1]+matrix[i-1][j]; // for all other cells we have way to come to that cell ony from top or from left, so inorder to get the unique ways we simply add the two ways and store that value in current cell
            }
        }

        return matrix[rows-1][cols-1];

        /* Example:
        Matrix: 3X4

        start
         *  *   *   *
         *  *   *   *
         *  *   *   *
                   end

         we have to find unique ways to reach from start to end

         Our matrix: 4X5

         0  0   0   0   0
         0  1   1   1   1
         0  1   2   3   4
         0  1   3   6   10 --> answer

         hence we can reach end in 10 ways

         */
    }

    public static void main(String[] args) {
        UniquePaths up=new UniquePaths();
        int m=3;
        int n=7;
        int result=up.uniquePaths(m,n);
        System.out.println(result);
    }
}
