public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n=s.length();
        int[][] matrix=new int[n][n];
        int index1=0;
        int index2=0;

        for(int i=0;i<n;i++)   // For palindromic size = 1 put all diagonal elements as 1, since a letter is a palindrome of itself
        {
            matrix[i][i]=1;
            index1=index2=i;
        }


        for(int i=0;i<n-1;i++)  // For palindromic size = 2
        {
            if(s.charAt(i)==s.charAt(i+1))   // if both characters are same then matrix[i][i+1]=1
            {
                matrix[i][i+1]=1;
                index1=i;
                index2=i+1;
            }
        }

        int max_length=2;         // we will use this variable to set the value of j

        for(int k=3;k<=n;k++)
        {
            for(int i=0;i<n-max_length;i++)
            {
                int j=i+max_length;           // Ex: for k = 3, i.e from 0 to 2, j=2
                if(s.charAt(i)==s.charAt(j))   // if current characters match
                {
                    if(matrix[i+1][j-1]==1)           // check if the left downward diagonal is also a palindrome i.e the characters inside the current set of characters form a palindrome
                    {
                        matrix[i][j]=1;          // if the current set is palindrome then set the final longest palidromic substrings indices as i,j indicating that this is the longest substring found.
                        index1=i;
                        index2=j;
                    }
                    else
                        matrix[i][j]=0;
                }
                else
                    matrix[i][j]=0;
            }
            max_length++;         // for next palindromic size
        }

        return s.substring(index1,index2+1);  // return the substring from first index to aslt index including the last index, not excluding, hence we do index2+1
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps=new LongestPalindromicSubstring();
        String str="babad";
        String result=lps.longestPalindrome(str);
        System.out.println(result);
    }
}
