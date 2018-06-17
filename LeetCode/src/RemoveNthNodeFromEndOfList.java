/* PROBLEM STATEMENT: Remove Nth Node from End of List

Given a linked list, remove the nth node from the end of list and return its head.

For example,

  Given linked list: 1->2->3->4->5, and n = 2.

  After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:

Given n will always be valid.
Try to do this in one pass.

 */

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode dummyHead=new ListNode(0);   // create a dummy head node which will be the previous of the actual head node
        dummyHead.next=head;
        ListNode temp=head;
        while(temp!=null)          // get the length of the list using count variable
        {
            count++;
            temp=temp.next;
        }
        count-=n;
        ListNode newList=dummyHead;     // now start from the dummyhead, untill count becomes 0, move forward
        while (count>0)
        {
            newList=newList.next;
            count--;
        }
        newList.next=newList.next.next; // when count becomes 0, the node's next will be made as next.next because the next node would be the node to be removed

        return dummyHead.next;          // return whatever is the next node of dummy ead node, it could be head, else in case of just 1 element list, after removing, it will be null
    }

    /************************************ IMPROVED VERSION (Single Pass) ***************************************/

    public ListNode removeNthFromEndOnePass(ListNode head, int n)
    {
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode first=dummyHead;         // use 2 pointers, first and second for single pass
        ListNode second=dummyHead;

        for(int i=0;i<n+1;i++)            // maintain a difference of n nodes between first and second, so iterate 1 till it reaches (n+1)th node
            first=first.next;

        while(first!=null)               // when the first pointer reaches null i.e the end of last node, it means second pointer has reached the (n-1)th node
        {
            first=first.next;
            second=second.next;
        }

        second.next=second.next.next;    // set the next of (n-1)th node as (n+1)th node

        return dummyHead.next;

    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList rnnfrol=new RemoveNthNodeFromEndOfList();
        ListNode list=new ListNode(1);
        list.next=new ListNode(2);
        list.next.next=new ListNode(3);
        list.next.next.next=new ListNode(4);
        list.next.next.next.next=new ListNode(5);
        ListNode head=rnnfrol.removeNthFromEnd(list,3);
        ListNode temp=head;
        while(temp!=null)
        {
            System.out.println(temp.val);
            temp=temp.next;
        }

    }

}
