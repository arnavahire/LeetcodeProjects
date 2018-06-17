/* PROBLEM STATEMENT: 4SumII

Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

*/

import java.util.HashMap;


/* LOGIC: Take the arrays A and B, and compute all the possible sums of two elements. Put the sum in the Hash map, and increase the hash map value if more than 1 pair sums to the same value.

Compute all the possible sums of the arrays C and D. If the hash map contains the opposite value of the current sum, increase the count of four elements sum to 0 by the counter in the map.*/
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        int count=0;

        for(int i=0;i<A.length;i++)           // compute all the sums of A and B and store them in map as <sum,1>, if the sum of elements are same, then update map as <sum,Previous_value++>
        {
            for(int j=0;j<B.length;j++)
            {
                int sum=A[i]+B[j];
                if(map.containsKey(sum))
                    map.put(sum,map.get(sum)+1);
                else
                    map.put(sum,1);
            }
        }

        for(int i=0;i<C.length;i++)          // Compute al sums of C and D and negate the sum and search if this key is present in the map, if yes, the value in the map for that key is gives our count for that sum
        {
            for(int j=0;j<D.length;j++)
            {
                int sum=-(C[i]+D[j]);
                if(map.containsKey(sum))
                    count+=map.get(sum);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FourSumII fs2=new FourSumII();
        int[] A={1,2};
        int[] B={-2,-1};
        int[] C={-1,2};
        int[] D={0,2};
        int result=fs2.fourSumCount(A,B,C,D);
        System.out.println(result);
    }
}
