import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        int rows=coins.length+1;     // we will add 1 extra row at the beginning of all rows
        int cols=amount+1;           // we will add 1 extra col at the beginning of all columns
        int[][] matrix=new int[rows][cols];

        for(int i=0;i<rows;i++)
        {
            matrix[i][0] = 0;                           // the 0th column will have all 0s
            for (int j = 1; j < cols; j++) {
                matrix[i][j] = Integer.MAX_VALUE - 1;     // the 0th row will have all values as max values except the 0th location
            }
        }

        for(int i=1;i<rows;i++)
        {
            for(int j=1;j<cols;j++)
            {
                if(j<coins[i-1])               // if the amount at jth index is less than the value at i-1th index of coin array, we take the value i-1th matrix position.( We do, i-1 because in matrix, we add additional row at the beginning and hence the total row count increases by 1)
                {
                    matrix[i][j]=matrix[i-1][j];
                }
                else        // if the amount at jth index is equal or greater than coins[i-1] we choose the minimum of 2 values
                {
                    matrix[i][j]=Math.min(matrix[i-1][j],matrix[i][j-coins[i-1]]+1);  // choose minimum between the top value and the value obtained from the same row
                }
            }
        }

        return ((matrix[rows-1][cols-1]==Integer.MAX_VALUE-1)||(matrix[rows-1][cols-1]==Integer.MAX_VALUE)) ? -1 : matrix[rows-1][cols-1];
        // if the desired amount cannot be obtained,
        // the value to be returnedmight be either Integer.Max_Value (If value comes from top) or Integer.Max_Value (if value comes from the same row),
        // in that case return -1, else return the value

    }

    public static void main(String[] args) {
        CoinChange cc=new CoinChange();
        int[] coins={2};
        int amount=11;
        int result=cc.coinChange(coins,amount);
        System.out.println(result);

    }
}
