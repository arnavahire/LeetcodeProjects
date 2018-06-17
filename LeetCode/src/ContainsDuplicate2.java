/*PROBLEM STATEMENT: Contains Duplicate II

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

*/

import java.util.HashMap;

public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();

        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))         // if the map already contains the entry for that nums value,
            {
                if(i-map.get(nums[i])<=k)        // we check if the difference of index between new value and old value falls within the k range, if yes then we return true
                    return true;
            }
            map.put(nums[i],i);         // if the difference is not within range k, or if we do not have an entry for that value, we update our map by adding new entry
        }

        return false;

    }

    public static void main(String[] args) {
        ContainsDuplicate2 cd2=new ContainsDuplicate2();
        int[] nums={1,2};
        int k=2;
        boolean res=cd2.containsNearbyDuplicate(nums,k);
        System.out.println(res);
    }
}
