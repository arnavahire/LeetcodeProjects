/* PROBLEM STATEMENT: Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

*/

import java.util.LinkedList;
import java.util.Scanner;

public class ReverseInteger {       // use the example of number 1233 to solve this problem.  It will make it easy to understand

    public int reverse(int x) {
        long result=0;             // we are using long variable instead of int to check the problem of underflow and overflow
        int tail=0;

        while(x!=0)
        {
            tail=x%10;                // get the number at units digit
            result=(result*10)+tail;  // add it in the result
            x=x/10;
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)  // if result is greater than max value of integer or less than min value of integer then we return 0
                return 0;
        }

        return (int)result;        // if no overflow / underflow occurs, return the int result

    }

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter a number to be reversed: ");
        int number=scan.nextInt();

        ReverseInteger rev=new ReverseInteger();
        int result=rev.reverse(number);

        System.out.println(result);

    }
}
