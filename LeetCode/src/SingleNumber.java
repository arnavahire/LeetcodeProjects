import java.util.Scanner;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            result^=nums[i];  // carry out xor operation with every element of the array. the final value will give us the answer
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber sn=new SingleNumber();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter array length:");
        int len=scan.nextInt();
        int[] input=new int[len];
        for (int i=0;i<len;i++)
        {
            System.out.println("Enter element: ");
            input[i]=scan.nextInt();
        }
        int res=sn.singleNumber(input);
        System.out.println(res);
    }
}
