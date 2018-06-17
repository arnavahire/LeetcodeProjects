import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--)
        {
            if(digits[i]<9)
            {
                digits[i]++;  // if the digit is less than 9 then simply add 1 to it and return the array
                return digits;
            }
            digits[i]=0;   // if the digit is 9 then adding 1 will make the digit as 0 and generate a carry
        }

        int[] newArray=new int[digits.length+1];  // suppose if your number is 99, adding 1 to it will give 100, so the length will now be 3, hence we will store MSB as 1 and keep rest of them 0 and return this array
        newArray[0]=1;
        return newArray;

    }

    public static void main(String[] args) {
        int[] digits=new int[]{0};
        PlusOne po=new PlusOne();
        int[] result=po.plusOne(digits);
        for(int i=0;i<result.length;i++)
        {
            System.out.println(result[i]);
        }

    }
}
