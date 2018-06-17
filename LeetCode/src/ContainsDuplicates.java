import java.util.HashSet;
import java.util.LinkedList;

public class ContainsDuplicates {

    // Brute Force : Using List

    public boolean containsDuplicate(int[] nums) {
        LinkedList<Integer> list=new LinkedList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!list.contains(nums[i]))
                list.add(nums[i]);
            else
                return true;
        }
        return false;
    }

    // Improved Time Complexity using Hashset , since the lookup time is only 0(1) for HashSet because of the use of hash function where as it is 0(n) for LinkedList/ArrayList

    public boolean containsDuplicateImproved(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!set.contains(nums[i]))
                set.add(nums[i]);
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicates cd=new ContainsDuplicates();
        int[] nums={1,2,3,4};
        boolean result=cd.containsDuplicate(nums);
        System.out.println(result);
        boolean result2=cd.containsDuplicateImproved(nums);
        System.out.println(result2);
    }
}
