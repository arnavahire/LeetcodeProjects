/*PROBLEM STATEMENT: Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

*/

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : (n / 5) +trailingZeroes(n/5);    // check leetcode explanation. Very well explained
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes ftz=new FactorialTrailingZeroes();
        int number=25;
        int result=ftz.trailingZeroes(number);
        System.out.println(result);
    }
}
