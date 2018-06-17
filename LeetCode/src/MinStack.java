import java.util.EmptyStackException;
import java.util.Stack;

/* We can solve the problem of MAX Stack in a similar way */

public class MinStack {
    int min=Integer.MAX_VALUE;   // set min as max value
    Stack<Integer> s;

    /** initialize your data structure here. */
    public MinStack() {
        s=new Stack<Integer>();

    }

    public void push(int x) {
        if(x<=min)          // if the number to be pushed is less than min then set min as that number and push previous min on stack
        {
            s.push(min);
            min=x;
        }
        s.push(x);    // if number is greater than min, only push that number
    }

    public void pop() {
        int popped=s.pop();  // pop the current top element
        if(popped==min)        // if popped element is min then we have to change the min
        {
            min=s.pop();       // the new min is obtained by popping the previously pushed min
        }
    }

    public int top() {
        if(!s.empty()) return s.peek();
        else throw new EmptyStackException();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {

    }
}
