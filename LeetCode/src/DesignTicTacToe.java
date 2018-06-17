/* PROBLEM STATEMENT: Design Tic Tac Toe

Sample input:

[
    [3], // this is the size of n X n tic tac toe
    [0,0,1],[0,2,2],[2,2,1],[1,1,2],[2,0,1],[1,0,2],[2,1,1]   // these are the parameters to game function [rowIndex, columnIndex, player1/player2]
]

Output:

[null,0,0,0,0,0,0,1]

*/

public class DesignTicTacToe {

    int[] rows;
    int[] columns;
    int leftToRightDiagonal;
    int rightToLeftDiagonal;
    int n;

    public DesignTicTacToe(int n)
    {
        this.n=n;
        this.rows=new int[n];
        this.columns=new int[n];
        this.leftToRightDiagonal=0;
        this.rightToLeftDiagonal=0;
    }
    public int game(int row,int col,int player)
    {
        int difference=0;

        if(player==1)           // for player 1, difference= 1
            difference=1;
        else
            difference=-1;      // for player 2, difference= -1

        rows[row]+=difference;          // Ex: if input to game = 0, 0, 1, then we will do 0th rows count as previous count+difference, in this case it will be count+1, since player 1 has played
        columns[col]+=difference;

        if(row==col)                      // if row==col it means its the left diagonal so increase the count by difference
            leftToRightDiagonal+=difference;

        if(row==rows.length-col-1)           // if row==rows.length-col-1, its right diagonal, so increase the count by difference
            leftToRightDiagonal+=difference;

        for(int i=0;i<rows.length;i++)
        {
            if((Math.abs(rows[i])==n)||(Math.abs(columns[i])==n))      // if the count on any index of rows array or columns array becomes n (if n==3, then 3), return the winning player
                return player;
        }

        if((Math.abs(leftToRightDiagonal)==n)||(Math.abs(rightToLeftDiagonal)==n))  // similarly, if any of the diagonals count becomes n, we return the winning player
            return player;

        return 0;            // if nobody wins for that input, game continues and we return 0

    }
}
