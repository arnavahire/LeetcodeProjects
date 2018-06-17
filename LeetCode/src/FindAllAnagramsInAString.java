/*PROBLEM STATEMENT: Find all anagrams in a string

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    /********************************** BRUTE FORCE *************************************/

    public List<Integer> findAnagramsBruteForce(String s, String p) {
        List<Integer> list=new ArrayList<Integer>();

        if(s == null ||  s.length() == 0 || p == null || p.length() == 0)
            return list;

        int n=p.length();

        for(int i=0;i<s.length()-(n-1);i++)
        {
            boolean result=isAnagram(s.substring(i,i+n),p);
            if(result==true)
                list.add(i);
        }
        return list;
    }

    public boolean isAnagram(String s,String p)
    {
        char[] sCharArray=s.toLowerCase().toCharArray();
        char[] pCharArray=p.toLowerCase().toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(pCharArray);

        String finalS=String.valueOf(sCharArray);
        String finalP=String.valueOf(pCharArray);

        if(finalS.equals(finalP))
            return true;

        return false;
    }

    public boolean isAnagramOtherVersion(String s, String p)
    {

        s=s.toLowerCase();
        p=p.toLowerCase();
        int[] alphabets=new int[26];

        for(int i=0;i<s.length();i++)
        {
            if(alphabets[s.charAt(i)-'a']==0)
                alphabets[s.charAt(i)-'a']=1;
            else
                alphabets[s.charAt(i)-'a']+=1;
        }

        for(int i=0;i<p.length();i++)
        {
            if(alphabets[p.charAt(i)-'a']==0)
                return false;
            else
                alphabets[p.charAt(i)-'a']-=1;
        }

        for(int i=0;i<alphabets.length;i++)
        {
            if(alphabets[i]!=0)
                return false;
        }
        return true;

    }

    public List<Integer> findAnagrams(String s, String p)
    {
        List<Integer> list=new ArrayList<Integer>();

        int[] targetFreq=new int[26];      // we create an array  of size 26 so that for each alphabet we can maintain a count on its specific location
        int[] stringFreq=new int[26];

        for(int i=0;i<p.length();i++)         // first we calculate the count of p string and store it in targetFreq
        {
            targetFreq[p.charAt(i)-'a']+=1;
        }

        int k=p.length()-1;       // k is the window size's last index
        boolean flag=false;

        for(int i=0;i<s.length()-k;i++)
        {
            int start=i;              // in each iteration, we deice the sliding window's size by start and end index
            int end=i+k;

            if(i==0)                  // only in the first iteration, we will calculate the count of s string and store it in stringFreq
            {
                for(int j=start;j<end+1;j++)
                {
                    stringFreq[s.charAt(j)-'a']+=1;
                }
            }

            for(int j=0;j<targetFreq.length;j++)     // we compare to see if stringFreq and targetFreq have the same count of the alphabets, if not same, it means it is not an anagram
            {
                if(stringFreq[j]!=targetFreq[j])
                {
                    flag=true;
                    break;
                }
            }
            if(flag==true)            // if the frequency of stringFreq and TargetFreq is not same, then we increment the start and end index
                flag=false;
            else
                list.add(start);      // if the frequency match is exact, it means anagram is present and hence we add start index to our final list to be returned

            if(i!=s.length()-k-1)     // we will increment start and end only until end is not equal to s.length-1, because on reaching the end, we cant increment the indices
            {
                stringFreq[s.charAt(start)-'a']-=1;  // we will decrement the count of character present at the start index and will shift our window to next start index
                start++;
                end++;
                stringFreq[s.charAt(end)-'a']+=1;    // we will increment the count of the next end, so that next time, we can check this stringFreq with targetFreq
            }
        }
        return list;

    }

    public static void main(String[] args) {
        FindAllAnagramsInAString faaias=new FindAllAnagramsInAString();
        String s="cbaebabacd";
        String p="abc";
        List<Integer> list=faaias.findAnagrams(s,p);
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
    }
}
