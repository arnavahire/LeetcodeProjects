/*PROBLEM STATEMENT: ADD STRINGS

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/

import java.util.Stack;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        char[] num1Array=num1.toCharArray();
        char[] num2Array=num2.toCharArray();
        int i=num1Array.length-1,j=num2Array.length-1;  // start from the end of the arrays since they represent the unit digits
        int carry=0;
        Stack<Integer> stack=new Stack<Integer>();
        while(i>-1||j>-1)                       // while both the arrays are not completely traversed
        {
            int first= (i >=0? num1Array[i]-'0':'0'-'0');      // to get the operands, subtract the ascii value of 0 from that operand's ascii value to get the reqd digit value
            int second=(j >=0? num2Array[j]-'0':'0'-'0');

            int sum=carry+first+second;    // sum is given as addition of operrands as well as carry
            carry= (sum>9?1:0);            // set carry as 1 if sum is greater than 9

            if(sum>9)             // if the sum > 9 then set it as sum%10, since 8+3=11 but we store only 1 as the digit value and set carry=1
                sum=sum%10;

            stack.push(sum);     // we push the calculated number on stack since we want to create the number in reverse fashion i.e from right to left of the array and not left to right
            i--;           // we check the next index, i.e lower index
            j--;
        }
        if(carry==1)            // in the addition of the rightmost bit if carry is generated then we add it to the final result
            stack.push(1);

        StringBuilder sb=new StringBuilder();
        while(!stack.empty())
        {
            sb.append(stack.pop());   // we append each integer from rightmost bit to leftmost bit to the stringbuilder and return the result
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AddStrings as=new AddStrings();
        String num1="323";
        String num2="856";
        String result=as.addStrings(num1,num2);
        System.out.println(result);
    }
}
