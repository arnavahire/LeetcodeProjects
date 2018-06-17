/* PROBLEM STATEMENT: Convert a binary number to a decimal number
    EX: 1111 -> 15
*/

public class BinaryToDecimal {

    // Using Integer.parseInt() method

    public int BToD(int binaryNumber)
    {
        String str=String.valueOf(binaryNumber);
        return Integer.parseInt(str,2);
    }

    // Without using Integer.parseInt() method

    public int BToDBySelf(int binaryNumber)
    {
        int mod=0;
        int power=0;
        int decimal=0;
        while(true)
        {
            if(binaryNumber==0)
                break;
            else
            {
                mod = binaryNumber % 10;
                decimal += mod * Math.pow(2,power);
                binaryNumber=binaryNumber/10;
                power++;
            }
        }
        return decimal;
    }

    public static void main(String[] args) {
        BinaryToDecimal b2d=new BinaryToDecimal();
        int binNumber=1111;
        int result=b2d.BToDBySelf(binNumber);
        System.out.println(result);
    }
}
