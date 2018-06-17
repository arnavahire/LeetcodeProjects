/* PROBLEM STATEMENT: Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

UPDATE (2017/1/4):
The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

*/

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp=new boolean[s.length()+1];  // we wil1 create a boolean array with 1 extra space to store the final boolean value

        dp[0]=true;                              // set 1st entry in dp array as true

        for(int i=1;i<dp.length;i++)       // begin i from 1st index and not 0th index
        {
            for(int j=0;j<i;j++)
            {
                String subStr=s.substring(j,i);     // calculate substring from j to i (substring will exclude ith index element) and check if it lies in the dictionary and has boolean value at jth index as true
                if(wordDict.contains(subStr) && dp[j]==true)
                {
                    dp[i]=true;                         // if yes then set ith index value as true
                    break;
                }
                else                                    // else false
                    dp[i]=false;
            }
        }

        return dp[dp.length-1];            // return the final boolean value present at the ith index
    }

    public static void main(String[] args) {
        WordBreak wb=new WordBreak();
        String s="mycodeschool";
        List<String> wordDict=new ArrayList<String>();
        wordDict.add("my");
        wordDict.add("code");
        wordDict.add("school");
        boolean result=wb.wordBreak(s,wordDict);
        System.out.println(result);
    }
}
