/* PROBLEM STATEMENT: Group Anagrams

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.

*/

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map=new HashMap<String, List<String>>();

        for(int i=0;i<strs.length;i++)                             // each anagram will have same ordering of letters after the string gets sorted
        {
            char[] tempArray=strs[i].toLowerCase().toCharArray();    // convert the input to lowercase and put in character array
            Arrays.sort(tempArray);                               // we can us Arrays.sort to sort the elements in ascending order of alphabets
            String sortedString=new String(tempArray);            // we will create a string from the character array

            if(!map.containsKey(sortedString))
            {
                map.put(sortedString,new LinkedList<String>());      // if the sortedString is not present as the key, then we add it to the map and create a new list for it
            }

            map.get(sortedString).add(strs[i]);       // in any of the case we append the string to the list of anagrams

        }

        List<List<String>> finalOutput=new LinkedList<>(); // finally we append all the list of anagrams result in a single list and return that list

        for(Map.Entry<String,List<String>> entry : map.entrySet())
        {
            finalOutput.add(entry.getValue());
        }

        return finalOutput;
    }

    public static void main(String[] args) {
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams ga=new GroupAnagrams();
        List<List<String>> result=ga.groupAnagrams(strs);
        for(int i=0;i<result.size();i++)
        {
            for(int j=0;j<result.get(i).size();j++)
                System.out.println(result.get(i).get(j));
            System.out.println("-----");
        }
    }
}
