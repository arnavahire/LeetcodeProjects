import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*Problem Statement:

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:
Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

public class LongestPalindrome {
    public int longestPalindrome(String s) {
       if(s==""||s==null) return 0;
       HashSet<Character> hs=new HashSet<Character>();
       int count=0;
       for(int i=0;i<s.length();i++)
       {
           if(hs.contains(s.charAt(i)))         // if hashset already contains that charcter, remove it from hashset and increase the count by 1
           {
               hs.remove(s.charAt(i));
               count++;
           }
           else
           {
               hs.add(s.charAt(i));            // if a cahracter appears for the first time then just add it to hashset
           }
       }
       if(!hs.isEmpty())      // if hashset is not empty it means it contains odd occurences of characters but in palidnrome we can choose only 1 such character, that too if the length is odd
           return count*2+1;
       return count*2;        // if hashset is empty, it means all the charcters appeard twice making it a perfect fit for making a palindrome
    }

    public static void main(String[] args) {
        LongestPalindrome lp=new LongestPalindrome();
        String str="aA";
        int result=lp.longestPalindrome(str);
        System.out.println(result);


    }
}
