import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int i,j;
        String str=String.valueOf(x);
        char[] input=str.toCharArray();
        if(input.length==0)
        {
            System.out.println("Empty string.");
            return false;
        }
        else if(input.length==1)
        {
            return true;
        }
        else
        {
            i=0;
            j=input.length-1;
            while(i<j)
            {
                if(input[i]==input[j])
                {
                    i++;
                    j--;
                }
                else
                {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean palindromeWithoutExtraSpace(int x){
        if(x<0)
        {
            return false;   // no negative number can be a palindrome
        }
        else
        {
            int num=x;
            int sum=0;
            while(x!=0)        // we will get the entire number here
            {
                int rem=x%10;
                sum=(sum*10)+rem;
                x=x/10;
            }
            if(num==sum)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        PalindromeNumber pn=new PalindromeNumber();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter number:");
        int number=scan.nextInt();
        boolean result=pn.isPalindrome(number);
        System.out.println(result);
        boolean result2=pn.palindromeWithoutExtraSpace(number);
        System.out.println(result2);

    }
}
