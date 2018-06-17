import java.util.Scanner;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {

        if(nums.length==0)  // return -1 for empty array
            return -1;

        int totalSum=0;
        for(int i=0;i<nums.length;i++)   // calculate total sum of all elements
        {
            totalSum+=nums[i];
        }
        int left=0;
        for(int i=0;i<nums.length;i++)
        {
            int sum=totalSum-nums[i];  // subtract the current assumed pivot element value from the total sum
            if(left==(sum-left))       // now see if subtracting 'left' from this value is equal to the value to the 'left' of that pivot element, if yes then return it's index
            {
                return i;
            }
            left+=nums[i];            // if the current element is not ivot, then add the value to the 'left' variable
        }
        return -1;

    }

    public static void main(String[] args) {
        FindPivotIndex fpi=new FindPivotIndex();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter array length: ");
        int len=scan.nextInt();
        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++)
        {
            System.out.println("Enter element: ");
            arr[i]=scan.nextInt();
        }
        int result=fpi.pivotIndex(arr);
        System.out.println(result);

    }
}
