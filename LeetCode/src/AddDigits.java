/*PROBLEM STATEMENT:
ADD DIGITS

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
Could you do it without any loop/recursion in O(1) runtime?
*/

public class AddDigits {
    public int addDigits(int num) {
        if(num%9==0 && num!=0)   // 9 is the magical number which gives us the number that we get on adding the digits. So if we divide any number by 9, its remainder gives us the final sum of all digits
            return 9;  // so it the number is divisible by 9 then its addition is 9, else it is the remainder
        else
            return num%9;
    }

    public static void main(String[] args) {
        AddDigits ad=new AddDigits();
        int number=15;
        int result=ad.addDigits(number);
        System.out.println(result);
    }
}
