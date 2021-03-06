/*PROBLEM STATEMENT:
CLIMBING STAIRS

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.


Example 1:

Input: 2
Output:  2
Explanation:  There are two ways to climb to the top.

1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output:  3
Explanation:  There are three ways to climb to the top.

1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

*/

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n<=1)         // if n=1 you will need only 1 step to reach the top
            return 1;
        else if(n==2)    // if n=2 you can reach top in 2 ways
            return 2;
        else if(n>=3)    // for every other step you will reach top in a fashion which is the same as Fibonacci series
        {
            int first=1;
            int second=2;
            int third=0;
            for(int i=3;i<=n;i++)
            {
                third=first+second;
                first=second;
                second=third;
            }
            return third;
        }
        else
            return 0;
    }

    public static void main(String[] args) {
        ClimbingStairs cs=new ClimbingStairs();
        int stairsToReachTop=4;
        int result=cs.climbStairs(stairsToReachTop);
        System.out.println(result);
    }
}
