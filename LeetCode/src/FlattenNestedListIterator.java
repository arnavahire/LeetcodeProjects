/* PROBLEM STATEMENT: Flatten Nested List Iterator

Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

*/

import java.util.Iterator;

public class FlattenNestedListIterator {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */

    // It is assumed that a NestedInteger object can be an Integer value, or a list of Integers
    // It is assumed that there exists 3 functions of class NestedInteger,
    // 1. isInteger, to determine if the NestedInteger is an Integer or a nested list of Integers
    // 2. getInteger, to get the Integer value from the nestedInteger object
    // 3. getist, to get the list of Integers from the nestedInteger object,

    /*--------------------------------------- CODE -----------------------------------------------*/

    /*public class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> stack;
        public NestedIterator(List<NestedInteger> nestedList) {
            stack=new Stack<NestedInteger>();
            for(int i=nestedList.size()-1;i>=0;i--)
            {
                stack.push(nestedList.get(i));        // create a stack and push the NestedInteger objects onto the stack from the end of the list, so that we get the elements from the beginning to end after popping them
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();       // pop the element at the top of the stack, it is assumed that only integer value exists at the top
        }

        @Override
        public boolean hasNext() {
            while(!stack.isEmpty())
            {
                if(stack.peek().isInteger())          // if the element at the top is integer, return true
                    return true;
                List<NestedInteger> myList=stack.pop().getList();    // if the element at the top is a list, pop the list and push the elements of this list onto the stack from end to beginning
                for(int i=myList.size()-1;i>=0;i--)
                {
                    stack.push(myList.get(i));
                }
            }
            return false;
        }
    }*/

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
