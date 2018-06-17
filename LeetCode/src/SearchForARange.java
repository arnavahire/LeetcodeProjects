/* PROBLEM STATEMENT: Search For a range

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

*/

public class SearchForARange {
    public int searchForExtremePositions(int[] nums, int target,boolean flag)
    {
        int i=0;
        int j=nums.length;

        while(i<j)
        {
            int mid=(i+j)/2;
            if( nums[mid]>target || (flag && nums[mid]==target))      // we use flag to find out left and right extremes of the range
                j=mid;
            else
                i=mid+1;
        }

        return i;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] range={-1,-1};

        int leftIndex=searchForExtremePositions(nums,target,true);     // first we try to find left extreme

        if(leftIndex==nums.length || nums[leftIndex]!=target)              // if not found then we output [-1, -1]
            return range;

        range[0]=leftIndex;
        range[1]=searchForExtremePositions(nums,target,false)-1;       // search for right extreme

        return range;
    }
}
