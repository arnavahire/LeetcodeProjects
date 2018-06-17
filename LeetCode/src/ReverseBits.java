/* PROBLEM STATEMENT: Reverse Bits

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer

*/

import java.nio.ByteBuffer;

public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        int var = 0;

        for (int i = 0; i < 32; i++)
        {
            var = n & 1;           // the bitwise & operation will happen with least significant bit of number's binary form and 1 and will be stored in var
            n = n >> 1;            // the original n will shift right by 1. Remember, it will NOT ROTATE, it will delete the current bit
            result = result | var;  // this var bit will be bitwise ORd with result
            if(i < 31)
                result = result << 1;  // except for the last bit, a left shift will be performed for all the bits wherein during each shift, a 0 will be appended to the right of the current bit
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseBits rb=new ReverseBits();
        int result=rb.reverseBits(43261596);
        System.out.println(result);
    }
}
