import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/* NOTE: To understand this problem consider example of 11.

   11-> 2-> 4-> 16-> 37-> 58-> 89-> 145-> 42-> 20-> 2

   We can see that after obtaining 2 for the second time, we are going to get an cycle from 2-> 4-> 16-> 37-> 58-> 89-> 145-> 42-> 20->

   Hence we will never get our happy number. So we add this in our set so that when we come across an already existing value we can return false

*/

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<Integer>();
        while(set.add(n))            // the add method in hashset will keep adding numbers to the set as long as they are unique, if we come across a number that is already present in the set, then add method will return false and thus we can say that we won't get a happy number
        {
            int squareSum =0;
            while(n!=0)        // divide a number into individual digit and calculate sum of each digit's square . Westore this result in squareSum
            {
                int rem=n%10;
                squareSum+=rem*rem;
                n=n/10;
            }
            if(squareSum==1)
                return true;
            else
                n=squareSum;
        }

        return false;
        // For checking the elements in the set

        /*Iterator<Integer> itr=set.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }*/

    }

    public static void main(String[] args) {
        HappyNumber hn=new HappyNumber();
        int a=11;
        boolean result=hn.isHappy(a);
        System.out.println(result);
    }
}
