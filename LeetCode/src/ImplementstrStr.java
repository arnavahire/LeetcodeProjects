import java.util.Scanner;

public class ImplementstrStr {

    public int strStr(String haystack, String needle) {

        int i=0;
        int j=0;
        int k=0;

        while(i<haystack.length() && j<needle.length())
        {
            if(haystack.charAt(i)==needle.charAt(j))    // if equal characters then increment i and j
            {
                i++;
                j++;
            }
            else             // if unequal characters then increment k and set k to i
            {
                k++;
                j=0;
                i=k;
            }
        }
        if(j==needle.length()) // return the index
            return i-j;
        else
            return -1;


    }

    public static void main(String[] args) {

        ImplementstrStr strStr=new ImplementstrStr();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Haystack (Original string): ");
        String haystack=scan.next();
        System.out.println("Enter Needle (Substring): ");
        String needle=scan.next();

        int index=strStr.strStr(haystack,needle);
        System.out.println(index);
    }
}
