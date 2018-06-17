/* PROBLEM STATEMENT: Rotate Image

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

*/

public class RotateImage {
    public void rotate(int[][] matrix) {

        /* Take the transpose */

        /*  Original
            1  2  3
            4  5  6
            7  8  9
        */

        /*  Transpose
            1  4  7
            2  5  8
            3  6  9
        */

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=i;j<matrix[0].length;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        /* Now change the elements horizontally to get the rotated image */

        /*  Final
            7  4  1
            8  5  2
            9  6  3
        */

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length/2;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix[0].length-1-j];
                matrix[i][matrix[0].length-1-j]=temp;
            }
        }

        /* For Printing the rotated Array*/
        System.out.println("AFTER:");
        for(int i=0;i<matrix.length;i++)
        {
            System.out.println();
            for(int j=0;j<matrix[0].length;j++)
                System.out.print(matrix[i][j]+" ");
        }
    }

    public static void main(String[] args) {
        RotateImage ri=new RotateImage();
        int[][]matrix=new int[3][3];
        matrix[0][0]=1;
        matrix[0][1]=2;
        matrix[0][2]=3;
        matrix[1][0]=4;
        matrix[1][1]=5;
        matrix[1][2]=6;
        matrix[2][0]=7;
        matrix[2][1]=8;
        matrix[2][2]=9;
        System.out.println("BEFORE:");
        for(int i=0;i<matrix.length;i++)
        {
            System.out.println();
            for(int j=0;j<matrix[0].length;j++)
                System.out.print(matrix[i][j]+" ");
        }
        System.out.println();
        ri.rotate(matrix);

    }
}
