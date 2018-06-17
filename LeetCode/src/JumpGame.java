/*PROBLEM STATEMENT:

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

*/

import java.util.LinkedList;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length<=1)      /// if the length of array is 0 or 1 then you have reached the last index so return true. Ex:[2]
            return true;

        int max=nums[0];

        for(int i=0;i<nums.length;i++)
        {
            if(max<=i && nums[i]==0)           // if the max number obtained is less than or equal to current i value and if nums[i]=0 that means i+nums[i] will stay the same hence we will return false, since there will be no jump available in that case. Ex: [3,2,1,0,4]
                return false;

            if(i+nums[i]>max)  // if the obtained i+nums[i] is greater than max then set max as i+nums[i] because we will be taking this jump. Ex:[2,3,1,1,4]
                max=i+nums[i];

            if(max>=nums.length-1)      // if the max value is greater than or equal to nums.length-1 then we have jumped to last index so return true. Ex: [2,3,1,1,4]
                return true;
        }

        return false;  // if we dont get our answer inside of the loop, it means our max value was less, hence we will return false

    }

    public boolean canJumpVariation(int[] nums) {
        if(nums.length<=1)      /// if the length of array is 0 or 1 then you have reached the last index so return true. Ex:[2]
            return true;

        int max=nums[0];
        int jumpCount=0;
        LinkedList<Integer> jumps=new LinkedList<Integer>();
        jumps.add(0);                                         // the first index from where we will jump will always be 0, so we add it in our list

        for(int i=0;i<nums.length;i++)
        {
            if(max<=i && nums[i]==0)           // if the max number obtained is less than or equal to current i value and if nums[i]=0 that means i+nums[i] will stay the same hence we will return false, since there will be no jump available in that case. Ex: [3,2,1,0,4]
                return false;

            if(i+nums[i]>max)  // if the obtained i+nums[i] is greater than max then set max as i+nums[i] because we will be taking this jump. Ex:[2,3,1,1,4]
            {
                max=i+nums[i];
                jumps.add(i);  // each time we get a new max value, we will perform a jump, hence we will add that index in the jump list and increment the jumpCount by 1
                jumpCount++;
            }

            if(max>=nums.length-1)      // if the max value is greater than or equal to nums.length-1 then we have jumped to last index so return true. Ex: [2,3,1,1,4]
            {
                jumps.add(nums.length-1);  // the final element where jump has been made will be added in the jump list and the jumpCount will be incremented by 1
                jumpCount++;
                for(int x=0;x<jumps.size();x++)
                {
                    System.out.print(jumps.get(x));
                }
                System.out.println();
                System.out.println(jumpCount);
                return true;
            }
        }

        return false;  // if we dont get our answer inside of the loop, it means our max value was less, hence we will return false
    }

    public static void main(String[] args) {
        JumpGame jg=new JumpGame();
        int[] nums={2,3,1,1,2,4,2,0,1,1};
        boolean result=jg.canJumpVariation(nums);
        System.out.println(result);

    }
}
