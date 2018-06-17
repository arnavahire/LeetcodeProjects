/* PROBLEM STATEMENT: Largest Number

Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

*/

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {

        // Get the input Integers as Strings

        String[] strs=new String[nums.length];

        for(int i=0;i<nums.length;i++)
            strs[i]=String.valueOf(nums[i]);

        // Sort these strings using custom Comparator

        Arrays.sort(strs,new stringComparator());

        // Corner case where all the elements are 0, in that case return 0

        if(strs[0].equals("0"))
            return "0";

        // Create a new string using StringBuilder and append all the strings to it and return

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<strs.length;i++)
            sb.append(strs[i]);

        return sb.toString();
    }

    class stringComparator implements Comparator<String>
    {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;

            return order2.compareTo(order1);      // we return order2.compareTo() and not order1.compareTo() because we want the arrays to be sorted in descending order of the digits and not in ascending order
        }
    }

    public static void main(String[] args) {
        LargestNumber ln=new LargestNumber();
        int[] nums={3,30,34,2,1};
        String result=ln.largestNumber(nums);
        System.out.println(result);
    }
}
