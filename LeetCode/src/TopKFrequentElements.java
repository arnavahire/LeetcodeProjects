/* PROBLEM STATEMENT: Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

*/
import java.util.*;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        // Declare a bucket of Lists that store keys of hashmaps in a list present at the respective locations determined by the frequencies of the keys i.e their respective hashmap values
        List<Integer>[] bucket=new List[nums.length+1];
        // NOTE:We create the bucket of nums.length+1 because suppose if we have 1 element only its count will be one,
        // So it will check at the 1th position of the bucket if this key is stored,
        // but 1st location won't exist because our list array will have only 0th location since size is 1,
        // hence array index out of bounds exception will take place.
        // Hence if nums array is an array of size n, we will create bucket of n+1 size so that the bucket can access the nth location, in a case where only 1 element exists and it has a frequency of n.  So that case will be taken care of

        HashMap<Integer,Integer> frequencyMap=new HashMap<Integer, Integer>();

        // Store all the numbers and their frequencies in a hashmap
        for(int number:nums)
        {
            if(!frequencyMap.containsKey(number))
                frequencyMap.put(number,1);
            else
                frequencyMap.put(number,frequencyMap.get(number)+1);
        }

        // Add all the keys to the bucket locations determined by their frequencies
        for(int key:frequencyMap.keySet())
        {
            int frequency=frequencyMap.get(key);
            if(bucket[frequency]==null)
                bucket[frequency]=new ArrayList<Integer>();
            bucket[frequency].add(key);
        }

        List<Integer> result=new ArrayList<Integer>();

        // We will start from the end of bucket list, because the end locations will give us the keys that appeared more frequently
        for(int pos=bucket.length-1; pos>=0; pos--)
        {
            if(bucket[pos]!=null)
            {
                for(int i=0; i<bucket[pos].size() && result.size()<k; i++)
                {
                    result.add(bucket[pos].get(i));
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        TopKFrequentElements tkfe=new TopKFrequentElements();
        int[] nums={1};
        int k=2;
        List<Integer> result=tkfe.topKFrequent(nums,k);
        for(int i=0;i<result.size();i++)
        {
            System.out.println(result.get(i));
        }
    }
}
