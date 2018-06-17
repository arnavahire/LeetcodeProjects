/* PROBLEM STATEMENT: Jolly Jumper Sequence

A sequence of n numbers (n < 3000) is called Jolly Jumper
if the absolute values of the differences between the successive elements take on all possible values from 1 through n-1.
The definition implies that any sequence of a single integer is a jolly jumper.

EX:

Input: 1 4 2 3
Output: True
This sequence 1 4 2 3 is Jolly Jumper because
the absolute differences are 3, 2, and 1.

Input: 1 4 2 -1 6
Output: False
The absolute differences are 3, 2, 3, 7.
This does not contain  all the  values from 1
through n-1. So, this sequence is not Jolly.

Input: 11 7 4 2 1 6
Output: True

*/

import java.util.HashSet;

public class JollyJumperSequence {

    public boolean isJollyJumper(int[] sequence)
    {
        HashSet<Integer> set=new HashSet<>();  // create a hashset and add all the differences in that hashset

        for(int i=0;i<sequence.length-1;i++)
        {
            set.add(Math.abs(sequence[i]-sequence[i+1]));
        }

        for(int i=1;i<sequence.length;i++)       // if all the values ranging from 1 to n-1 are not present in hashset, then it is not a jolly jumper sequence, else it is.
        {
            if(!set.contains(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        JollyJumperSequence jjs=new JollyJumperSequence();
        int[] jollysequence={11,7,4,2,1,6};
        boolean result=jjs.isJollyJumper(jollysequence);
        System.out.println(result);
    }
}
