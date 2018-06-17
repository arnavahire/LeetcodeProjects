/*Problem Statement:
*Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
*/

public class NumberComplement {
    public int findComplement(int num) {
        return ~num & (Integer.highestOneBit(num)-1);  // ~ gives us bitwise complement of original number, we AND that with the output of highest bit of the original number minus 1
    }

    public static void main(String[] args) {
        NumberComplement nc=new NumberComplement();
        int result=nc.findComplement(3);
        System.out.println(result);
    }
}
