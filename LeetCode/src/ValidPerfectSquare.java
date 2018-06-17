public class ValidPerfectSquare {

    /*LOGIC:

    This is a math problem：
    1 = 1
    4 = 1 + 3
    9 = 1 + 3 + 5
    16 = 1 + 3 + 5 + 7
    25 = 1 + 3 + 5 + 7 + 9
    36 = 1 + 3 + 5 + 7 + 9 + 11
    ....
    so 1+3+...+(2n-1) = (2n-1 + 1)n/2 = nn

    */

    //Brute Force

    public boolean isPerfectSquare(int num) {
        for(int i=1;i*i<=num;i++)
        {
            if(i*i==num)
                return true;
        }
        return false;
    }

    // Improved

    public boolean isImprovedPerfectSquare(int num) {
        int i=1;
        while(num>0)
        {
            num -= i;
            i+=2;
        }
        return num==0;
    }

    public static void main(String[] args) {
        ValidPerfectSquare vps=new ValidPerfectSquare();
        int number=1;
        boolean result=vps.isPerfectSquare(number);
        System.out.println(result);
    }
}
