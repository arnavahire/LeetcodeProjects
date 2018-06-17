/*PROBLEM STATEMENT: Valid Parenthesis

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

*/

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {

        Stack<Character> stack=new Stack<Character>();

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')       // if we find an opening bracket, we push it onto the stack
                stack.push(s.charAt(i));
            else if(s.charAt(i)==')')      // if we find an ending ')' bracket
            {
                if(stack.isEmpty())   // if nothing to pop, it means no opening bracket has been found before the closing bracket, hence it is invalid
                    return false;
                char popped=stack.pop();    // if stack is not empty, we pop the element from the stack, if it is opening '(' bracket, then it is valid so we continue to next iteration else return string as invalid
                if(popped!='(')
                    return false;
            }
            else if(s.charAt(i)==']')   // similarly for ']' bracket
            {
                if(stack.isEmpty())   // nothing to pop
                    return false;
                char popped=stack.pop();
                if(popped!='[')
                    return false;
            }
            else if(s.charAt(i)=='}')  // similarly for '}' bracket
            {
                if(stack.isEmpty())   // nothing to pop
                    return false;
                char popped=stack.pop();
                if(popped!='{')
                    return false;
            }
        }
        if(!stack.isEmpty())   // even if after scanning the entire string, if stack is not empty, it means there are less number of closing brackets than the opening brackets, hence we will output as invalid
            return false;
        return true;

    }

    public static void main(String[] args) {
        ValidParenthesis vp=new ValidParenthesis();
        String input="([{}])";
        boolean result=vp.isValid(input);
        System.out.println(result);
    }
}
