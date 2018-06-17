public class NumberOf1Bits {

    public int BruteForceHammingWeight(int n)
    {
        int count=0;
        for(int i=0;i<32;i++)  // we take i from 0 to 32 because integer is a 32 bit number
        {
            count+=(n>>i) & 1;
        }
        return count;
    }

    public int hammingWeight(int n) {
        n=Integer.bitCount(n);
        return n;
    }

    public static void main(String[] args) {
        int a=11;
        NumberOf1Bits noob=new NumberOf1Bits();
        int result=noob.hammingWeight(a);
        System.out.println(result);

        int result2=noob.BruteForceHammingWeight(a);
        System.out.println(result2);
    }
}
