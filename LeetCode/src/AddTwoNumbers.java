/*PROBLEM STATEMENT: ADD TWO NUMBERS

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

*/

public class AddTwoNumbers {

    static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode prev=null;
        ListNode result=null;
        ListNode temp=null;
        int sum=0;

        while(l1!= null || l2!= null)      // continue till both the lists are completely traversed
        {
            sum=carry+(l1!=null? l1.val :0 )+(l2!=null? l2.val:0);    // add the carry value, and both the lists value into sum, if an of the list gets empty,subtitute its value by 0

            carry=( sum>9? 1:0);    // if the sum of digits becomes greater than 9 then set ccarry as 1, else 0

            if(carry==1)           // if carry becomes 1 then set sum as sum%10.Ex:  8+3=11.  so we will store 1 as the digit with 1 as carry
                sum=sum%10;

            temp=new ListNode(sum); // store the sum in a ListNode temp

            if(result==null)         // if the head of our finalList is empty then assign temp to  that head. 'result' in this case
                result=temp;
            else                    // if the head is not null, then simple append the listnode to prevvious node. 'prev' in this case
                prev.next=temp;
            prev=temp;             // set previous as the current node, which will serve as the previous node for next iteration

            if(l1!=null)         // increment both the lists by 1
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }

        if(carry==1)               // if the final carry generated is 1, we will simple append this carry as another digit in our list of nodes
            prev.next=new ListNode(carry);

        return result;        // return head

    }

    public static void main(String[] args) {

    }

}
