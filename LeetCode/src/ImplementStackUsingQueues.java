/* PROBLEM STATEMENT : Implement Stack using queues

Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

*/

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    int top;/** Initialize your data structure here. */
    Queue<Integer> q1=new LinkedList<Integer>();
    Queue<Integer> q2=new LinkedList<Integer>();
    public ImplementStackUsingQueues() {
         top=-1;
    }

    /** Push element x onto stack. */
    public void push(int x) {
            q1.add(x);
            top=x;

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size()>1)    // until we get the last element, we remove all elements from q1 and put them into q2
        {
            int popped=q1.remove();
            q2.add(popped);

        }
        int returnValue=q1.remove();   // we remove (pop) the last element from q1

        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;      // at the end, we will get an empty q2 queue
        return returnValue;
    }

    /** Get the top element. */
    public int top() {
        while(q1.size()>=1)
        {
            if(q1.size()==1)      // if the last element is being popped from q1 and is being placed in q2, it will be the top which we will be returning
            {
                top=q1.remove();
                q2.add(top);
            }
            else      // else an element will just be popped and put in q2
            {
                int popped = q1.remove();
                q2.add(popped);
            }
        }

        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;      // at the end, we will get an empty q2 queue and q1 will have data

        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
