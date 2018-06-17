/*PROBLEM STATEMENT : Ugly Number

Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.

*/

public class UglyNumber {

    public boolean isUgly(int num) {

        for(int i=2;i<6 && num>0;i++)  //we will check from 2 to 5 whether the number is divisible by any of them, even the number 4
        {
            while(num%i==0)     // if divisible then we will divide the number and again count the mod until the % value is not 0. After it becomes 0, we will try if it is divisible by the next number
                num/=i;
        }

        return num == 1;     // at the end, if the number is completely divisble by 2,3, or 5, we will get num as 1, else we wont, so we will return whatever boolean value we get

    }

    public static void main(String[] args) {
        UglyNumber un=new UglyNumber();
        int num=14;
        boolean result=un.isUgly(num);
        System.out.println(result);
    }
}
