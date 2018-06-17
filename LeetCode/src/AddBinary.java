/*PROBLEM STATEMENT: Add Binary

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

*/

public class AddBinary {

    public String addBinary(String a, String b) {

        StringBuilder sb=new StringBuilder();

        int i=a.length()-1;  // we begin from the last index of each string
        int j=b.length()-1;
        int carry=0;

        while(i>=0 || j>=0)
        {
            int sum=carry;
            if(i>=0)
            {
                sum+=a.charAt(i)-'0';
                i--;
            }
            if(j>=0)
            {
                sum+=b.charAt(j)-'0';
                j--;
            }

            sb.append(sum%2);   // if sum =2 then 0 will be appended, if sum =1 then 1 will be appended

            carry=sum/2;
        }

        if(carry!=0)              // if carry is 1 or greater than 1 then append it to the stringbuilder
            sb.append(carry);

        return sb.reverse().toString();  // since we got the answer in the stringbuilder in reverse order, we will reverse the stringbuilder to get the original answer

    }

    public static void main(String[] args) {
        String a="11";
        String b="1";
        AddBinary ab=new AddBinary();
        String result=ab.addBinary(a,b);
        System.out.println(result);
    }
}
