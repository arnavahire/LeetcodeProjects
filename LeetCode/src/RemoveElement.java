import java.util.Scanner;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=val)
            {
                nums[count]=nums[i];
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        RemoveElement re=new RemoveElement();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter array length: ");
        int len=scan.nextInt();
        int[] input=new int[len];
        for(int i=0;i<len;i++)
        {
            System.out.println("Enter element: ");
            input[i]=scan.nextInt();
        }

        System.out.println("Enter target:");
        int target=scan.nextInt();

        int result=re.removeElement(input,target);
        System.out.println(result);
    }
}
