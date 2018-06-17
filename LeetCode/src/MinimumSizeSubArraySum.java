public class MinimumSizeSubArraySum {


    /*SOLUTION */

    public int minSubArrayLen(int s, int[] nums) {

        /* Use a sum to understand this problem more clearly */
        int start=0;
        int end=0;
        int sum=0;
        int minSize=Integer.MAX_VALUE;

        while(end<nums.length)
        {
            while(end<nums.length && sum<s)        // add all the elements in the sum till sum < s and end < nums.length
            {
                sum=sum+nums[end];
                end++;
            }
            while(start<nums.length && sum>=s)     // remove the elements from start and increment start each time till sum >=s is valid,
            {
                minSize=Math.min(minSize,end-start);
                sum=sum-nums[start];
                start++;
            }
        }

        return (minSize!=Integer.MAX_VALUE) ? minSize : 0;
    }

    /* THIS CODE IS NOT THE SOLUTION FOR THE MINIMUM SIZE SUBARRAY SUM SINCE IN THIS SUM, WE ARE LOOKING FOR A CONTIGUOUS ARRAY AND NOT A CONTINUOUS ARRAY. THIS SOLUTION IS FOR A CONTINUOUS SUBARRAY*/
    public int minSubArrayLen1234(int s, int[] nums) {
        int start=0;
        int end=0;
        int minSize=Integer.MAX_VALUE;
        int sum=0;
        int minStart=0;
        int minEnd=0;

        while(start<nums.length)
        {
            sum+=nums[end];
            if(sum>=s)
            {
                int size=(end-start)+1;
                if(size<minSize)
                {
                    minSize=size;
                    minStart=start;
                    minEnd=end;
                }
                sum=0;
                start++;
                end=start;
            }
            else if(sum<s)
            {
                if(end<nums.length-1)     // if end pointer is not at the last index, simply increment end
                    end++;
                else                      // if end pointer is at the last index, increment start and set end as start to begin finding a new array
                {
                    start++;
                    end = start;
                }
            }
        }
        return (minSize != Integer.MAX_VALUE) ? minSize : 0;
    }

    /* Aniruddh Chaturvedi's Solution*/

    public int minSubArrayLen1(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(end < nums.length) {
            while(end < nums.length && sum < s) {
                sum = sum + nums[end];
                end++;
            }
            while(start < nums.length && sum >= s) {
                min = Math.min(min, end - start);
                sum = sum - nums[start];
                start++;
            }
        }
        if(min == Integer.MAX_VALUE) return 0;
        else return min;
    }

    public static void main(String[] args) {
        MinimumSizeSubArraySum mssas=new MinimumSizeSubArraySum();
        int[] nums={2,3,1,2,4,3};
        int s=11;
        int result=mssas.minSubArrayLen(s,nums);
        System.out.println(result);
    }
}
