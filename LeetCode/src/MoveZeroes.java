import java.util.Scanner;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {

        int count=0;

        for(int num:nums)
        {
            if(num!=0)            // if number is 0 then skip, else copy that element to the index pointed by count
            {
                nums[count]=num;
                count++;
            }
        }
        while(count<nums.length)  // the 'count' variaable is going to ignore all the 0 entries. So it's count will be less than the array length
        {
            nums[count]=0;        // so now we pad the zeroes at the end
            count++;
        }

        for(int i=0;i<nums.length;i++)
        {
            System.out.print(nums[i]+" ");
        }
    }

    public static void main(String[] args) {
        MoveZeroes mz=new MoveZeroes();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter array length: ");
        int len=scan.nextInt();
        int[] input=new int[len];
        for(int i=0;i<len;i++)
        {
            System.out.println("Enter element: ");
            input[i]=scan.nextInt();
        }
        mz.moveZeroes(input);
    }
}
