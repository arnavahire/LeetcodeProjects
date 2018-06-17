import java.util.Scanner;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int count=0;
        int  xor=x^y;

        for(int i=0;i<32;i++)
        {
            count+=((xor>>i)&1);      // it will take the complete 32 bit number stored in xor variable and will perform & with every bit to 1, so that when the result will be one only then the counter will be incremented
        }
        return count;

    }

    public int improvedHammingDistance(int x, int y)
    {
        return Integer.bitCount(x^y);
    }

    public static void main(String[] args) {

        HammingDistance hd=new HammingDistance();
        Scanner scan=new Scanner(System.in);

        System.out.println("Enter number 1:");
        int x=scan.nextInt();
        System.out.println("Enter number 2:");
        int y=scan.nextInt();

        int result=hd.hammingDistance(x,y);
        System.out.println(result);

        int result2=hd.improvedHammingDistance(x,y);
        System.out.println(result2);

    }
}
