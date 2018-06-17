/*Problem Statement:
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.
*/

public class NextGreaterElement1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int flag=0;
        int[] max=new int[nums1.length];
        for(int i=0;i<nums1.length;i++)       // for every element in nums1
        {
            int j=0;
            while(nums1[i]!=nums2[j])         // see if the numms1 element matches nums2 element
                j++;
            j++;                             // once match found then check for all the elements after that element
            while(j<nums2.length)
            {
                if(nums2[j]>nums1[i])      // if the element in nums2 is greater than the element in nums1 then add it to our max array
                {
                    max[i]=nums2[j];
                    flag=1;               // set the flag as 1
                    break;
                }
                j++;
            }
            if(flag==0)                 // if no greater element is found then set that max as -1
                max[i]=-1;
            flag=0;                      // reset the flag for next element in nums1
        }
        return max;
    }

    public static void main(String[] args) {
        NextGreaterElement1 nge1=new NextGreaterElement1();
        int[] nums1=new int[]{2,4};
        int[] nums2=new int[]{1,2,3,4};
        int[] result=nge1.nextGreaterElement(nums1,nums2);
        for(int i=0;i<result.length;i++)
        {
            System.out.println(result[i]);
        }
    }
}
