import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {

    /* Naive Solution */

    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i++)
            if(nums[i]==nums[i+1])
                return nums[i];

        return 0;
    }

    /* Using Sets */

    public int findDuplicateUsingSets(int[] nums)
    {
        Set<Integer> set=new HashSet<Integer>();

        for(int i=0;i<nums.length;i++)
        {
            if(set.contains(nums[i]))
                return nums[i];
            set.add(nums[i]);
        }

        return 0;
    }

    /* Using cycle detection */

    public int findDuplicateUsingCycleDetection(int[] nums)
    {
        int tortoise=nums[0];
        int hare=nums[0];

        do{
            tortoise=nums[tortoise];
            hare=nums[nums[hare]];
        }while (tortoise!=hare);

        int ptr1=nums[0];
        int ptr2=tortoise;

        while(ptr1!=ptr2)
        {
            ptr1=nums[ptr1];
            ptr2=nums[ptr2];
        }

        return ptr1;
    }



    public static void main(String[] args) {
        FindTheDuplicateNumber ftdn=new FindTheDuplicateNumber();
        int[] nums={1,3,4,3};
        int result=ftdn.findDuplicate(nums);
        System.out.println(result);
    }
}
