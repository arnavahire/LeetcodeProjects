/*Problem Statement:
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Ex:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

*/

import java.util.HashMap;

public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();  // create a hashmap that stores a character and its number of occurences
        char[] charArray=s.toCharArray();
        for(int i=0;i<charArray.length;i++)
        {
            if(map.containsKey(charArray[i]))                 // if map already contains the key then we just increase the number of occurence by 1
            {
                map.put(charArray[i],map.get(charArray[i])+1);
            }
            else
            {
                map.put(charArray[i],1);        // for each new entry we make the occurence as 1
            }
        }

        for(int i=0;i<charArray.length;i++)
        {
            if(map.get(charArray[i])==1)           // traverse the original string's characters one by one and then return the first character whose occurence is 1
            {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString fucias=new FirstUniqueCharacterInAString();
        String str="";
        int result=fucias.firstUniqChar(str);
        System.out.println(result);
    }
}
