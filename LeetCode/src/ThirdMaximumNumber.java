/*Problem Statement: Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
Ex:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.

Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

*/

public class ThirdMaximumNumber {
    /* NOTE: You cannot compare int object to null, hence we use Integer to declare our integers so that we can compare them to null. Also, in case of comparison, we use .equals method of the Integer class to check if two objects are same
    */

    public int thirdMax(int[] nums) {
        Integer max1=null;          // we use 3 max variables here that are null initially
        Integer max2=null;
        Integer max3=null;
        for(Integer n:nums)
        {
            if(n.equals(max1)||n.equals(max2)||n.equals(max3))   // check if that number is equal  to any of the max . If yes then go to next number
                continue;
            if(max1 == null || n > max1)                            // if either max1 is null or if there exists a number larger than max1 then make that as max1
            {
                max3=max2;
                max2=max1;
                max1=n;
            }
            else if(max2 == null || n > max2)             // similarly if you find a number that is smaller than max1 but greater than max2 then assign it to max2
            {
                max3=max2;
                max2=n;
            }
            else if(max3 == null || n > max3)            // same goes for max3
            {
                max3=n;
            }
        }
        return max3 == null ? max1 : max3;         // return max1 if max3 does not exist, else return max3

    }
}
