/* PROBLEM STATEMENT: Search in a Rotated Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

*/

public class SearchInRotatedSortedArray {

    /* Simplest Technique */

    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
            if(nums[i]==target)
                return i;
        return -1;
    }

    /* Using Binary Search */

    public int searchImproved(int[] nums,int target)
    {
        if(nums.length==0)
            return -1;
        int n=nums.length;
        int minIndex=findMinValueIndex(nums);  // calculate the index of the minimum value
        if(target==nums[minIndex])             // if the target value equals this element then return its index
            return minIndex;
        int start = (target > nums[n-1]) ? 0 : minIndex;   // else set the start bound and end bound of the search depending upon whether target exceeds the last element or is less than that
        int end = (target > nums[n-1]) ? minIndex-1 : n-1 ;

        while(start<=end)               // perform binary search within these start and end bounds
        {
            int mid=(start+end)/2;
            if(target==nums[mid])
                return mid;
            else if(target>nums[mid])
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }

    public int findMinValueIndex(int[] nums)
    {
        int lo=0;
        int hi=nums.length-1;
        while(lo<hi)
        {
            int mid=(lo+hi)/2;
            if(nums[mid] > nums[hi])          // if mid's value is greater than the last element's value we make lo as mid+1
                lo=mid+1;
            else                              // if mid's value is less than last element's value we make hi as mid. Make it mid and NOT mid-1, since the mid element could be the element with smallest value so we should take that into consideration
                hi=mid;
        }
        return lo;      // you can return either lo, hi or mid since all of them will have them same value at this point
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray sirsa=new SearchInRotatedSortedArray();
        int[] nums={8,9,2,3,4};
        int target=9;
        int result=sirsa.searchImproved(nums,target);
        System.out.println(result);
    }
}
