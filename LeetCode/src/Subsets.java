/* PROBLEM STATEMENT: Subsets

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


*/

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset=new ArrayList<Integer>();
        List<List<Integer>> subsetList=new ArrayList<>();
        helper(subsetList,subset,nums,0);
        return subsetList;
    }

    public void helper(List<List<Integer>> subsetList,List<Integer> subset,int[] nums,int index)
    {
        subsetList.add(new ArrayList(subset));              // each list forming a subset, gets appended to the subsetList first

        if(subset.size()==nums.length)                   // if the subset's length equals the length of nums array then we return
            return;

        for(int i=0;i<nums.length;i++)
        {
            if(i < index || subset.contains(nums[i]))    // if the value of i is less than the supplied index value, or if the list contains the value, then we continue to next iteration
                continue;
            subset.add(nums[i]);                         // we add the value to the list in each iteration that doesn't follow the above IF condition
            helper(subsetList,subset,nums,i);            // we send the current index value 'i' to the next helper function along with other parameters so that this 'i' will be the 'index' value for reference
            subset.remove(subset.size()-1);         // we remove the last element of the subset  after each helper has been executed
        }

    }

    public static void main(String[] args) {
        Subsets s=new Subsets();
        int[] nums={1,2,3};
        List<List<Integer>> result=s.subsets(nums);
        for(int i=0;i<result.size();i++)
        {
            for(int j=0;j<result.get(i).size();j++)
            {
                System.out.println(result.get(i).get(j));
            }
            System.out.println("*******************");
        }
    }
}
