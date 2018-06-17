public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;      // if number is less than or equal to 0 then return false
        while(n>1)
        {
            if(n%3!=0)
            {
                return false;
            }
            n/=3;
        }
        return true;

    }

    public boolean isPowerOfThreeSecondTry(int n)
    {
        if(n<=0)
            return false;
        while(n%3==0)
        {
            n=n/3;
            if(n==1)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        PowerOfThree pot=new PowerOfThree();
        int a=3;
        boolean result=pot.isPowerOfThree(a);
        System.out.println(result);
    }
}
