/*PROBLEM STATEMENT: Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.

*/

import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<Character, Character>();

        if(s.length()!=t.length())   // if the strings have different length then they are not isomorphic
            return false;

        for(int i=0;i<s.length();i++)
        {
            if(!map.containsKey(s.charAt(i)))   // when encountering a new character in string s
            {
                if(!map.containsValue(t.charAt(i)))     // no 2 keys should map to same value
                    map.put(s.charAt(i),t.charAt(i));  // we add s's charcter as key to hashmap, and t's character as value to hashmap
                else
                    return false;
            }
            else      // ifs's character is already present in hashmap as key
            {
                if(!map.get(s.charAt(i)).equals(t.charAt(i)))   // if the corresponding hashmap value and the chaacter of string t do not match, we return false
                    return false;
            }
        }
        return true;


    }

    public static void main(String[] args) {
        IsomorphicStrings is=new IsomorphicStrings();
        String s="paper";
        String t="title";
        boolean result=is.isIsomorphic(s,t);
        System.out.println(result);
    }
}
