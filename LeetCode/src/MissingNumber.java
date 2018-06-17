public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n=nums.length;               // since we have 0 in our array, that wont make any difference in carrying out the sum since it wont add up to any value. So actually the missing values position in the array is taken up by 0.
        int sum=n*(n+1)/2;               // hence we have to find out the sum of first n natural numbers which is given by n*(n+1)/2. And the reqd n will be the actual length of the array
        for(int i=0;i<nums.length;i++)
        {
            sum-=nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        MissingNumber mn=new MissingNumber();
        int[] missingnumberArray={0,2,3,4};
        int result=mn.missingNumber(missingnumberArray);
        System.out.println(result);
    }
}
