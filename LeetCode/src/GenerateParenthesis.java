/* PROBLEM STATEMENT: Generate Parenthesis

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> output=new ArrayList<String>();
        helper(n,0,0,"",output);
        return output;
    }

    public void helper(int n, int o, int c, String s,List<String> output)
    {
        if(o==n && c==n)
        {
            output.add(s);
            return;
        }

        if(o > n || c > n)
            return;

        if(o < n)
            helper(n,o+1,c,s+"(",output);
        if(c < o)
            helper(n,o,c+1,s+ ")",output);
    }

    public static void main(String[] args) {
        GenerateParenthesis gp=new GenerateParenthesis();
        int n=3;
        List<String> result=gp.generateParenthesis(n);
        for(int i=0;i<result.size();i++)
            System.out.println(result.get(i));
    }
}
