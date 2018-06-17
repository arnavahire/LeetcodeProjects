/*PROBLEM STATEMENT: Word Pattern

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

*/

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        char[] charArray=pattern.toCharArray();       // create a char array so that we can separate each character of the pattern
        String[] splits=str.split(" ");         // split the string on blank space, so that we get separate strings corresponding to pattern
        if(charArray.length!=splits.length)          // if the length of pattern and the generated list of strings doesn match then return false
            return false;

        HashMap<Character,String> map=new HashMap<Character, String>();  // map each character of a pattern to a string

        for(int i=0;i<charArray.length;i++)
        {
            if(!map.containsKey(charArray[i]) && !map.containsValue(splits[i]))   // if the map doesnt contain the pattern's character as well as the string value, only then add it to map
                map.put(charArray[i],splits[i]);
            else if(!map.containsKey(charArray[i]) && map.containsValue(splits[i]))  // if the map doesn't contain the pattern's character but contains the value, return false, since we can map a value to only 1 character
                return false;
            else                   // if the map contains the key already, check if the value correponding to the key, and the string in question match, return false if they don't match
            {
                if(!map.get(charArray[i]).equals(splits[i]))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wp=new WordPattern();
        String pattern="abba";
        String str="dog cat cat dog";
        boolean result=wp.wordPattern(pattern,str);
        System.out.println(result);
    }
}
