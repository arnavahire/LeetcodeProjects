import java.util.Scanner;

/*NOTE: We can also use StringBuilder class instead of creating character array since stringbuilder allows appending of characters unlike strings
*/

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
        {
            return "";
        }
        else
        {
            String resultString=strs[0];
            for(int i=1;i<strs.length;i++)
            {
                char[] resultStringChar=resultString.toCharArray();  // convert resultString to character Array
                char[] newElementChar=strs[i].toCharArray();         // convert new element string also to char array
                if(resultStringChar.length<=newElementChar.length)     // if the resultstring's length is less than or equal to new elements length then
                {
                    resultString="";
                    for(int j=0;j<resultStringChar.length;j++)
                    {
                        if(resultStringChar[j]==newElementChar[j])
                        {
                            resultString=resultString+String.valueOf(resultStringChar[j]);  // add each matched character to resultString
                        }
                        else                                                                // else break
                        {
                            break;
                        }
                    }
                }
                else                // vice versa
                {
                    resultString="";
                    for(int j=0;j<newElementChar.length;j++)
                    {
                        if(resultStringChar[j]==newElementChar[j])
                        {
                            resultString=resultString+String.valueOf(resultStringChar[j]);
                        }
                        else
                        {
                            break;
                        }
                    }
                }
            }
            return resultString;
        }
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp=new LongestCommonPrefix();

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter array length: ");
        int len=scan.nextInt();
        String[] arr=new String[len];

        for(int i=0;i<arr.length;i++)
        {
            System.out.println("Enter element:");
            arr[i]=scan.next();
        }

        String result=lcp.longestCommonPrefix(arr);
        System.out.println(result);

    }
}
