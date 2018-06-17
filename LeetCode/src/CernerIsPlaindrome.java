/* PROBLEM STATEMENT:
    Given a number, reverse its digits and add to the original number.
    Now check whether the number formed by performing the above mentioned operations is a Palindrome or not.
    If not, repeat the above process again. Return the number of steps required to reach a Palindromic number.
 */

import java.util.HashSet;
import java.util.Set;

public class CernerIsPlaindrome {

    public int IterationstoMakeAPalindrome(int number)
    {
        Set<Integer> set=new HashSet<Integer>();
        int palindromeNumber=0;
        int count=0;
        while(!set.contains(number))    // if the same number gets created, it means a cycle is being formed, hence we have to stop, hence we store the number in hashmap so that no cycle is repeated
        {
            set.add(number);
            count++;
            int rev=0;
            int newNum=0;
            int originalNumber=number;
            while (number!=0)
            {
                rev=number%10;
                newNum=newNum*10+rev;
                number=number/10;
            }

            palindromeNumber=originalNumber+newNum;

            int revPalindrome=palindromeNumber;
            int newPalindromeNum=0;
            int reversedPal=0;
            while(revPalindrome!=0)
            {
                newPalindromeNum=revPalindrome%10;
                reversedPal=reversedPal*10+newPalindromeNum;
                revPalindrome=revPalindrome/10;
            }

            if(reversedPal==palindromeNumber)
                return count;

            number=palindromeNumber;

        }

        return -1;

    }


    public static void main(String[] args) {
        CernerIsPlaindrome cip=new CernerIsPlaindrome();
        int number=199;
        int reslt=cip.IterationstoMakeAPalindrome(number);
        System.out.println(reslt);
        // System.out.println(Integer.parseInt("1101",2)); // converting binary to decimal using Integer.parseInt() method
    }
}
