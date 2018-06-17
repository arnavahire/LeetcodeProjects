public class SeggregateEvenAndOddNumbers {

    public int[] seggregateEvenOdd(int[] nums)
    {
        int left=0;
        int right=nums.length-1;

        while(left<right)
        {
            while(nums[left]%2==0 && left<right)
                left++;
            while(nums[right]%2!=0 && left<right)
                right--;
            if(left<right)
            {
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        SeggregateEvenAndOddNumbers seaon=new SeggregateEvenAndOddNumbers();
        int[] nums={12,34,45,9,8,90,3};
        int[] result=seaon.seggregateEvenOdd(nums);
        for(int i=0;i<result.length;i++)
            System.out.println(result[i]);
    }
}
