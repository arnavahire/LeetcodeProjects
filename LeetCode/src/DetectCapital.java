/*Problem Statement:
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
*/

/*NOTE:
 ASCII value range for capital letters: 65 to 90
 ASCII value range for small letters: 97 to 122
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int flag=0;                         // we set this if the first letter is capital
        int flag2=0;                        // we set this if the second letter is also capital
        for(int i=0;i<word.length();i++)
        {
            if(i==0)                                          // for the first letter see if it is lower or upper
            {
                if(word.charAt(i)>=65 && word.charAt(i)<=90)
                {
                    flag=1;                                   // set flag=1 if first letter is uppercase
                    continue;
                }
                continue;                                    // if first letter is lower case go to next iteration
            }
            if(i==1 && flag==1)                                // if the first letter is capital we see if the second is also capital
            {
                if(word.charAt(i)>=65 && word.charAt(i)<=90)
                {
                    flag2=1;                                  // we set flag2=1 if the second  letter is also capital
                    continue;
                }
            }
            if(i==1 && flag==0)                             // if the first letter is lowercase , the second should also be lower
            {
                if(word.charAt(i)>=65 && word.charAt(i)<=90)
                    return false;
                continue;
            }
            else if(flag==1 && flag2==1)                    // if both first and second are capital then every letter should be capital
            {
                if(word.charAt(i)>=97 && word.charAt(i)<=122)
                    return false;
                continue;
            }
            else if(flag==1 && flag2==0||flag==0 && flag2==0)   // if first letter is capital and second is small or if first both the letters are small, then all the other letters should be small
            {
                if(word.charAt(i)>=65 && word.charAt(i)<=90)
                    return false;
                continue;
            }

        }
        return true;
    }

    public boolean detectCapitaUseImproved(String word)
    {
        int sum=0;
        for(int i=0;i<word.length();i++)
        {
            if(word.charAt(i)>='A' && word.charAt(i)<'a')       // increment sum by 1 each time we come across a capital letter
                sum+=1;
        }
        if(sum==word.length())            // if all letters are capital return true
            return true;
        if(sum==1 && word.charAt(0)>='A'&& word.charAt(0)<'a') // if the first letter is capital return true
            return true;
        if(sum==0)                         // if all the letters are small return true
            return true;
        return false;                      // else return false
    }

    public static void main(String[] args) {
        DetectCapital dc=new DetectCapital();
        String word="mL";
        boolean result=dc.detectCapitalUse(word);
        System.out.println(result);
        boolean result2=dc.detectCapitaUseImproved(word);
        System.out.println(result2);
    }
}
