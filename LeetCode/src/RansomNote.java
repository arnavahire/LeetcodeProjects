import java.util.HashMap;
import java.util.LinkedList;

public class RansomNote {

    //Brute Force

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<magazine.length();i++)
        {
            if(map.containsKey(magazine.charAt(i)))
            {
                map.put(magazine.charAt(i),map.get(magazine.charAt(i))+1);  // if the character is already present in hashmap increment count by 1
            }
            else
            {
                map.put(magazine.charAt(i),1);  // store character and 1 if found for the first time
            }
        }

        for(int i=0;i<ransomNote.length();i++)
        {
            if(map.containsKey(ransomNote.charAt(i)))             // if the character is present in map, reduce its count by 1,
            {
                map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i))-1);
                if(map.get(ransomNote.charAt(i))<0)            // if the count< 0 it means the occurences for that character are not enough in the magazine to create ransomnote
                    return false;
            }
            else             // if map doesn't contain the character at all, return false at that very instant
            {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        RansomNote rn=new RansomNote();
        String s1="a";
        String s2="b";
        boolean result=rn.canConstruct(s1,s2);
        System.out.println(result);
    }
}
