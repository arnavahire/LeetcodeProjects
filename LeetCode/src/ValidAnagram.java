import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    // Brute Force - My Approach

    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<Character, Integer>(); // store each character of 's' and its count in hashmap
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);  // if map contains the character then store the character and its incremented value
            }
            else
                map.put(s.charAt(i),1);  // store <char,1> when we see the character for the first time
        }
        for(int i=0;i<t.length();i++)
        {
            if(map.containsKey(t.charAt(i)))
            {
                map.put(t.charAt(i),map.get(t.charAt(i))-1);  // reduce the count by 1 each time the character i found
                continue;
            }
            else
            {
                return false;  // if map doesn't contain that character then simply return false
            }
        }
        for(Map.Entry<Character,Integer> entry: map.entrySet())   // check if each entry in hashmap has a value 0, if it is greater than zero it means 't' did not have all the characters of 's', if it is less than zero it means that 't' had more characters than 's'
        {
            if(entry.getValue()>0||entry.getValue()<0)
            {
                return false;
            }
        }
        return true;   // return that it is a valid anagram
    }

    // Improved Version

    public boolean improvedIsAnagram(String s, String t)
    {
        char[] arrS=s.toCharArray();
        Arrays.sort(arrS);           // sort the 's' character array using Arrays.sort method
        char[] arrT=t.toCharArray();
        Arrays.sort(arrT);           // sort the 't' character array using Arrays.sort method

        if(String.valueOf(arrS).equalsIgnoreCase(String.valueOf(arrT)))  // check if the sorted strings for 's' and 't' match
            return true;

        return false;
    }

    /*NOTE: Stirng.valueOf() method can also take character array as an argument and convert the character array to String */

    public static void main(String[] args) {
        ValidAnagram va=new ValidAnagram();
        String s1="anagram";
        String s2="nagaram";
        boolean result=va.isAnagram(s1,s2);
        System.out.println(result);
        boolean result2=va.improvedIsAnagram(s1,s2);
        System.out.println(result2);
    }
}
