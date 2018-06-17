/* PROBLEM STATEMENT: Shortest Unsorted Continuous Subarray

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.

*/

import java.util.Arrays;

public class ShortestUnsortedContinuousSubArray {
    public int findUnsortedSubarray(int[] nums) {
        int[] sortedNums=nums.clone();
        Arrays.sort(sortedNums);               // create another copy of the array and sort the copy.
        int start=nums.length-1;
        int end=0;                             // let start be the last index and end be the first index
        for(int i=0;i<nums.length;i++)
        {
            if(sortedNums[i]!=nums[i])         // if the elements at a given position don't match, select the lowest index as the start and the highest index as the end
            {
                start=Math.min(start,i);
                end=Math.max(end,i);
            }
        }

        return ( end - start > 0 ? end - start + 1 : 0);
    }

    /*NOTE: We use clone and do not directly assign nums array is because even if we assign nums to sortedNums,
            sortedNum points to same array, and sorted it would result sorting of original nums araay too and
            this would give us wrong result. clone method creates another array of same values thus clearing the confusion.
    */

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubArray sucs=new ShortestUnsortedContinuousSubArray();
        int[] nums={2,6,4,8,10,9,15};
        int result=sucs.findUnsortedSubarray(nums);
        System.out.println(result);
    }
}
