public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount=0;     // to maintain max consecutive 1s at any instance
        int count=0;        // to keep track of consecutive 1s until a 0 is encountered
        if(nums.length==0)  // if array is null then return 0
            return 0;
        else
        {
            if(nums[0]==1)  // if the first element in the array is 1, then set both 'count'=1 and 'maxCount'=1 else both will be 0
            {
                maxCount=1;
                count=1;
            }
        }
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                count++;
                if(count>maxCount)
                    maxCount=count;
            }
            else
            {
                count=0;
            }
        }
        return maxCount;

    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,0,1,1,0,1};
        MaxConsecutiveOnes mco=new MaxConsecutiveOnes();
        int result=mco.findMaxConsecutiveOnes(arr);
        System.out.println(result);
    }
}
