import java.util.Scanner;

import static sun.swing.MenuItemLayoutHelper.max;
import java.math.*;
public class HouseRobber {

    public int rob(int[] nums) {
        int a=0;
        int b=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i%2==0)                  // 'a' keeps a track of houses at even index
            {
                a=Math.max(a+nums[i],b);
            }
            else                        // 'b' keeps a track of houses at odd index
            {
                b=Math.max(a,b+nums[i]);
            }
        }
        return Math.max(a,b);    // the maximum between a and b is returned

    }

    public int houseRob(int[] nums)
    {
        int a=0;
        int b=0;

        for(int i=0;i<nums.length;i++)
        {
            if(i%2==0)                     // if current index is even , calculate max between current value of a and prev value of b
                a=Math.max(a+nums[i],b);
            else                           // if current index is odd, calculate max between current value of b and prev value of a
                b=Math.max(a,b+nums[i]);
        }
        return Math.max(a,b);              // At the index we,get the max values for a and b, so return max value between a and b


    }


    public static void main(String[] args) {
        HouseRobber hr=new HouseRobber();

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter number of houses: ");

        int totalHouses=scan.nextInt();
        int[] input=new int[totalHouses];

        for(int i=0;i<totalHouses;i++)
        {
            System.out.println("Enter money for House "+i+": ");
            input[i]=scan.nextInt();
        }

        int result=hr.rob(input);
        System.out.println(result);

    }
}
