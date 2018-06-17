public class NthDigit {
    public int findNthDigit(int n) {
        int num=0;
        int count=0;
        for(int i=1;i<214748364;)
        {
            while(i/10!=0)
            {
                num=i%10;
                i=i/10;

            }
            if(i/10==0)
                i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        NthDigit nd=new NthDigit();
        int n=15;
        int result=nd.findNthDigit(n);
        System.out.println(result);
    }
}
