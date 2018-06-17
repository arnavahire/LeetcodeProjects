/*PROBLEM STATEMENT: Excel Sheet Column Number
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        s=s.toUpperCase();
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            result=result*26+(s.charAt(i)-'@');
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber escn=new ExcelSheetColumnNumber();
        String str="BA";
        int result=escn.titleToNumber(str);
        System.out.println(result);
    }
}
