/*Problem Statement:
REMOVE LINKED LIST ELEMENTS

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

*/
public class RemoveLinkedListElements {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode removeElements(ListNode head, int val) {
        ListNode myHead=new ListNode(-1);           // create another Node 'myHead' and make it the predecessor of head
        myHead.next=head;
        ListNode prev=myHead;                         // let 'prev' point to 'myHead'
        ListNode current=head;
        while(current!=null)
        {
            if(current.val==val)            // if the element matches the element to be removed, then 'prev's' next will be 'current's' next. Take ahead current to next node.
                prev.next=current.next;
            else                           // if the element doesn't match then bring 'prev' and 'current' ahead by one node
                prev=prev.next;
            current=current.next;
        }
        myHead=myHead.next;            // since myHead is our new head, and we don't want the value of myHead, we will shift it ahead by one node so that we get the desired result
        return myHead;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements rllle=new RemoveLinkedListElements();
        ListNode x=new ListNode(1);
        x.next=new ListNode(2);
        x.next.next=new ListNode(6);
        x.next.next.next=new ListNode(3);
        x.next.next.next.next=new ListNode(6);
        int val=6;;
        ListNode result=rllle.removeElements(x,val);
        while(result!=null)
        {
            System.out.println(result.val);
            result=result.next;
        }
    }
}
