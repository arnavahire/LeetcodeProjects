/*

* Given a string find longest palindromic subsequence in this string.
 *
 * Time complexity - O(n2)
 * Space complexity - O(n2
 *
 * Youtube link - https://youtu.be/_nCsPn7_OgI
 *
 * References
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/

*/

public class LongestPalindromicSubsequence {
    public int longestPalindromicSubSequence(String s)
    {
        int n=s.length();
        int[][] matrix=new int[n][n];

        for(int i=0;i<n;i++)   // for palindromic size =  1
        {
            matrix[i][i]=1;
        }

        for(int i=0;i<n-1;i++)  // for palindromic size = 2
        {
            if(s.charAt(i)==s.charAt(i+1))
                matrix[i][i+1]=2;
            else
            {
                if(matrix[i][i]>=matrix[i+1][i+1])  // else we calculate max of the value to the left of the current position in the matrix and to the below of the current position
                    matrix[i][i+1]=matrix[i][i];
                else
                    matrix[i][i+1]=matrix[i+1][i+1];
            }
        }

        int max_length=2;

        for(int k=3;k<=n;k++)   // for size 3 and above
        {
            for(int i=0;i<n-max_length;i++)
            {
                int j=i+max_length;
                if(s.charAt(i)==s.charAt(j))           // if the characters at i and j  match then we add 2 to the value obtained from matrix[i+1][j-1]
                {
                    matrix[i][j]=matrix[i+1][j-1]+2;
                }
                else
                {
                    if(matrix[i][j-1]>=matrix[i+1][j])  // else we calculate max of the value to the left of the current position in the matrix and to the below of the current position
                        matrix[i][j]=matrix[i][j-1];
                    else
                        matrix[i][j]=matrix[i+1][j];
                }
            }
            max_length++;      // to increase the difference between i and j values each time we consider a greater palindromic size
        }

        return matrix[0][n-1];    // the element obtained at [0][n-1] position is the longest palidromic subsequence

    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps=new LongestPalindromicSubsequence();
        String str="agbdba";
        int result=lps.longestPalindromicSubSequence(str);
        System.out.println(result);
    }
}
