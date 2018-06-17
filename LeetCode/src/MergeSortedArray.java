/*PROBLEM STATEMENT:
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;                  // start from the last index of the nums1 array (excluding the indices left blank for data from 2nd array)
        int j=n-1;                  // start from the last index of the nums2 array
        for(int k=m+n-1;k>=0;k--)   // start from the actual last index of nums1 array and insert elements 1 by 1
        {
            if(i>-1 && j>-1)          // traverse both arrays until none of i and j reach beyond the start of the arrays
            {
                if(nums1[i]>nums2[j])    // if element in nums1 is greater then nums2 then put that element in nums1 later index
                    nums1[k]=nums1[i--];
                else                     // else put nums2 element in the later index of nums1
                    nums1[k]=nums2[j--];
            }
            else if(i>-1)                // if nums2 has been completely traversed by j, then place nums1 elements in the nums1 later indices
                nums1[k]=nums1[i--];
            else if(j>-1)                // if nums1 has been traversed by i, then place nums2 elements in nums1 later indices
                nums1[k]=nums2[j--];
        }
        /*for(int x=0;x<nums1.length;x++)
            System.out.println(nums1[x]);
            */
    }

    public static void main(String[] args) {
        int m=3;
        int n=3;
        int[] nums1={1,3,5,0,0,0};
        int[] nums2={2,4,6};
        MergeSortedArray msa=new MergeSortedArray();
        msa.merge(nums1,m,nums2,n);


    }
}
