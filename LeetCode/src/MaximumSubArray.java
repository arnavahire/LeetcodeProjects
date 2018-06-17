import java.util.Scanner;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; //dp[i] means the maximum subarray ending with nums[i];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);  //add the previous to the current if previous value is greater than zero
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /* Variation - To give the start and end Index also along with the max result */

    public int maximumSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max=dp[0];
        int endIndex=0;
        int startIndex=0;

        for (int i = 1; i < nums.length; i++)
        {
            dp[i]=nums[i]+( (dp[i-1]) > 0 ? dp[i-1] : 0 );
            max=Math.max(max,dp[i]);
            if(dp[i]==max)
                endIndex=i;
        }

        int maxSum=0;
        for(int i=0;i<endIndex+1;i++)
        {
            int sum=0;
            for(int j=i;j<endIndex+1;j++)
            {
                sum+=nums[j];
            }
            if(sum > maxSum) {
                maxSum = sum;
                startIndex = i;
            }
        }

        System.out.println("Start: "+startIndex+" End: "+endIndex);

        return max;

    }

    public static void main(String[] args) {
        MaximumSubArray msa=new MaximumSubArray();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter array length:");
        int len=scan.nextInt();
        int[] input=new int[len];
        for (int i=0;i<len;i++)
        {
            System.out.println("Enter element: ");
            input[i]=scan.nextInt();
        }
        int res=msa.maximumSubArray(input);
        System.out.println(res);

    }
}
