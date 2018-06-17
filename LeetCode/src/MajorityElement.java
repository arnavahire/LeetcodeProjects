import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();  // to store the number and its count
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],1);
            }
            else
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            int value=entry.getValue();
            if(value>(nums.length/2))  // if the value is greater than length/2 i.e it forms a majority then
            {
                return entry.getKey();
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        MajorityElement me=new MajorityElement();

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter array length: ");
        int len=scan.nextInt();
        int[] input=new int[len];
        for(int i=0;i<len;i++)
        {
            System.out.println("Enter element: ");
            input[i]=scan.nextInt();
        }
        int result=me.majorityElement(input);
        System.out.println(result);
    }
}
