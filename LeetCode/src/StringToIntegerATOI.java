public class StringToIntegerATOI {
    public int myAtoi(String str) {

        double result=0;        //do not use long data type for 'result' because it also overflows after a point, so  stick to using double to handle cases of overflow
        int startIndex=0;
        boolean isNegative=false;

        // to handle null string and empty string

        if(str.length()==0 || str==null)
            return 0;

        // Remove trailing and leading whitespaces

        str=str.trim();

        // check if number is negative

        if(str.charAt(0)=='+' || str.charAt(0)=='-')
            startIndex++;

        if(str.charAt(0)=='-')
            isNegative=true;

        for(int i=startIndex;i<str.length();i++)
        {
            if(str.charAt(i) < '0' || str.charAt(i) > '9')
                break;
            int digitVal=str.charAt(i)-'0';
            result=result * 10 + digitVal;
        }

        // Add minus sign if the number is negative

        if(isNegative)
            result = -result;

        // If number is greater than max Integer value then return max value of integer

        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        // If number is smaller than min integer value then return min value of integer

        if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }

    public static void main(String[] args) {
        StringToIntegerATOI stia=new StringToIntegerATOI();
        String str="123";
        String str2="  12 3 ";
        String str3="123@!123";
        String str4="12345678987654321";
        String str5="-1234567897654321";
        String str6="-123";
        String str7="9223372036854775809";

        int result=stia.myAtoi(str7);
        System.out.println(result);
    }
}
