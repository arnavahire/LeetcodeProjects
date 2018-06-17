/* PROBLEM STATEMENT: Count and Say

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"

*/

public class CountAndSay {
    public String countAndSay(int n) {
        String result="1";

        for(int i=1;i<n;i++)          // for each iteration amongst n-1 iterations
        {
            String previous=result;   // store the current result in the previous so that we can compute count and say over the previous
            result="";
            int count=1;
            char say = previous.charAt(0);     // let initially say be the first character, in each iteration

            for(int j=1;j<previous.length();j++)   // check from the 2nd index of the string, whether there exists a character that is same as the say character
            {
                if(previous.charAt(j)!=say)     // if different character, then we simply append the count and say, and increment say to the next character
                {
                    result=result+count+say;
                    say=previous.charAt(j);
                    count=1;
                }
                else                      // if character is same, we simply increment the count
                    count++;
            }

            result=result+count+say;
        }

        return result;
    }

    public static void main(String[] args) {
        CountAndSay cas=new CountAndSay();
        int n=5;
        String result=cas.countAndSay(n);
        System.out.println(result);
    }

}
