import java.util.Scanner;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {

        s=s.trim(); // to remove extra spaces in ths string if present
        if(s==null || s.equalsIgnoreCase(""))  // if after trimiing string becomes empty then return 0
        {
            return 0;
        }
        String[] splits=s.split(" ");   // else split the string and take the last word in the string and return its length
        return splits[splits.length-1].length();

    }

    public static void main(String[] args) {
        LengthOfLastWord lolw=new LengthOfLastWord();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str="arnav is smarter";
        int result=lolw.lengthOfLastWord(str);
        System.out.println(result);
    }
}
