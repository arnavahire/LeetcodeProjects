/* PROBLEM STATEMENT: Permutations

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList=new ArrayList<List<Integer>>();
        List<Integer> currentList=new ArrayList<Integer>();
        helper(nums,resultList,currentList);
        return resultList;
    }

    public void helper(int[] nums, List<List<Integer>> resultList, List<Integer> currentList)
    {
        if(currentList.size()==nums.length)               // if the currentlist size matches the lenggth of nums array then append this list to resultlist
        {
            resultList.add(new ArrayList(currentList));
            return;
        }

        for(int i=0;i<nums.length;i++)                  // for every integer in nums
        {
            if(currentList.contains(nums[i]))           // if the currentlist already has the integer, then continue to next iteration
                continue;
            currentList.add(nums[i]);                   // else add the integer to currentlist and call helper function to recursively add other elements to the list
            helper(nums,resultList,currentList);
            currentList.remove(currentList.size()-1);  // remove the currently inserted element after all the calls to helper function for adding 1 permutation to the final resultList are finished, so that next permutation can be formed
        }

    }

    public static void main(String[] args) {
        Permutations p=new Permutations();
        int[] nums={1,2,3};
        List<List<Integer>> result=p.permute(nums);
        for(int i=0;i<result.size();i++)
        {
            for(int j=0;j<result.get(i).size();j++)
            {
                System.out.println(result.get(i).get(j));
            }
            System.out.println("**********************");
        }
    }

}
