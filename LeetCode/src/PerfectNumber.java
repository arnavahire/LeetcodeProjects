public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num==1)            // number is 1 and it divides itself so it is not a perfect number
            return false;
        int sum=0;
        for(int i=2;i<Math.sqrt(num);i++)     // iterate till square root of the original number
        {
            if(num%i==0)                     // if the i divides that number then add it to sum
            {
                sum+=i;
                if(i!=(num/i))                // if i divides the number then even num/i should divide it since num/i is the quotient
                    sum+=num/i;             // so add that number too
            }
        }
        sum++;          // add 1 lastly because it divides every other number

        if(sum==num)
            return true;
        return false;
    }

    public static void main(String[] args) {
        PerfectNumber pn=new PerfectNumber();
        int number=28;
        boolean result=pn.checkPerfectNumber(number);
        System.out.println(result);
    }
}
