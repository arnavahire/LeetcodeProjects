public class CernerArmstrongNumber {

    public boolean isArmstrongNumber(int number)
    {
        double result=0;
        int digitsCount=0;
        int originalNumber=number;

        while(number!=0)
        {
            number=number/10;
            digitsCount++;
        }

        number=originalNumber;

        while(number!=0)
        {
            int digit=number%10;
            result=result+Math.pow(digit,digitsCount);   // math.pow() function returns a double hence our result variable is a double
            number=number/10;
        }

        if(originalNumber==(int)result)
            return true;

        return false;

    }

    public static void main(String[] args) {
        CernerArmstrongNumber can=new CernerArmstrongNumber();
        int num=120;
        boolean result=can.isArmstrongNumber(num);
        System.out.println(result);
    }
}
