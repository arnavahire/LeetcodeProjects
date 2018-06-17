import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> disappearedElements=new LinkedList<Integer>();

        for(int i=0;i<nums.length;i++)   // first negate all the numbers on the corresponding index positions
        {
            int val=Math.abs(nums[i])-1;
            if(nums[val]>0)
            {
                nums[val]=-nums[val];
            }
        }

        for(int i=0;i<nums.length;i++)     // check if the any element is greater than 0. If it is then append i+1 in the list
        {
            if(nums[i]>0)
            {
                disappearedElements.add(i+1);
            }
        }

        return disappearedElements;

    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray fadiaa=new FindAllNumbersDisappearedInAnArray();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter array length:");
        int len=scan.nextInt();
        int[] input=new int[len];
        for (int i=0;i<len;i++)
        {
            System.out.println("Enter element: ");
            input[i]=scan.nextInt();
        }
        List<Integer> res=fadiaa.findDisappearedNumbers(input);
        for(int i=0;i<res.size();i++)
        {
            System.out.println(res.get(i));
        }

    }
}
