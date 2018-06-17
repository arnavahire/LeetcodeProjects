import java.util.Stack;

public class ImplementQueueUsingStacks {

    class MyQueue {
        Stack<Integer> input=new Stack<Integer>();   // we maintain 2 stacks so that we can get output of a queue
        Stack<Integer> output=new Stack<Integer>();

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            input.push(x);          // we will push only in input stack
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            peek();          // before popping we will see if the output stack is empty, if its empty and we have elements in input stack, we will transfer them to output stack and then pop
            return output.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(output.empty())           // we will transfer data from input stack to output stack only if output stack is empty
            {
                while (!input.isEmpty())
                {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            if(input.empty() && output.empty())  // if both the stacks are empty then only our queue is empty
                return true;
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
