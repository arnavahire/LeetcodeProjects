public class FindPeakElement {

    /* My technique - Probably a brute force */

    public int findPeakElement(int[] nums) {

        if(nums==null || nums.length==0)  // if nums is of length 0 or 1, return 0
            return 0;

        if(nums.length==1)
            return 0;

        if(nums.length==2)             // if nums is of length=2 and element at index 1 is greaater than the element at 0, then return 1, else 0
        {
            if(nums[0]<nums[1])
                return 1;
            else return 0;
        }

        int start=0;
        int end=nums.length-1;

        for(int i=0;i<nums.length;i++)
        {
            if(i==start)                   // if the its the first index and its greater than its succeeding neighbor, return its index
            {
                if(nums[i]>nums[i+1])
                    return i;
            }

            if(i==end)                    // if the its the last index and its greater than its preceding neighbor, return its index
            {
                if(nums[i]>nums[i-1])
                    return i;
            }
            if((nums[i]>nums[i+1]) && (nums[i]>nums[i-1]))          // for all other indices the element has to be greater than the predecessor as well as the successor to be a peak
                return i;
        }

        return -1;

    }

    /* Little More Efficient Technique */

    public int findPeakElementImproved(int[] nums)
    {
        for(int i=0;i<nums.length-1;i++)        // we can return any one of the peaks
        {
            if(nums[i] > nums[i+1])            // any number that is greater than the next number, is a peak, so we can directly return it and if we don't get any such number it means the last element is the peak
                return i;
        }
        return nums.length-1;
    }

    /* Best Solution: Iterative Binary Search */

    public int findPeakElementBinarySearch(int[] nums)
    {
        int lo=0;
        int hi=nums.length-1;

        while(lo<hi)
        {
            int mid=(lo+hi)/2;
            if(nums[mid]>nums[mid+1])       // if the mid element is greater than (mid+1)th element then make hi=mid, else make lo=mid+1
                hi=mid;
            else
                lo=mid+1;
        }
        return lo;
    }

    public static void main(String[] args) {
        FindPeakElement fpe=new FindPeakElement();
        int[] nums={3,4};
        int result=fpe.findPeakElement(nums);
        System.out.println(result);
    }
}
