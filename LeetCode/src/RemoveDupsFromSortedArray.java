import java.util.Scanner;
public class RemoveDupsFromSortedArray {

    public int removeDups(int[] nums){

        if(nums.length==0)
        {
            return 0;
        }
        else
        {
            int i=0;
            for(int j=1;j<nums.length;j++)
            {
                if(nums[j]==nums[i])
                {

                }
                else
                {
                    i++;
                    nums[i]=nums[j];
                }
            }
            return i+1;
        }
    }

    public static void main(String[] args) {
        RemoveDupsFromSortedArray rdups=new RemoveDupsFromSortedArray();

        int[] arr;
        System.out.println("Enter length of array: ");
        Scanner scan=new Scanner(System.in);
        int len=scan.nextInt();
        arr=new int[len];
        for(int i=0;i<len;i++)
        {
            System.out.println("Enter element: ");
            arr[i]=scan.nextInt();
        }
        int result=rdups.removeDups(arr);
        System.out.println(result);

    }
}
