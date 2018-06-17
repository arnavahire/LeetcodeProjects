/* PROBLEM STATEMENT: Merge K Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    /* BRUTE FORCE */

    public ListNode mergeAllLists(ListNode[] listOfLists)
    {
        ListNode finalList=null;

        for(int i=0;i<listOfLists.length;i++)
        {
            finalList=mergeList(finalList,listOfLists[i]);
        }

        return finalList;
    }

    public ListNode mergeList(ListNode l1, ListNode l2)
    {
        if(l1==null && l2==null)
            return null;

        if(l1==null)
            return l2;

        if(l2==null)
            return l1;

        ListNode i=l1;
        ListNode j=l2;
        ListNode l3=null;

        if(l1.val<=l2.val)
        {
            l3=l1;
            l3.next=mergeList(l1.next,l2);
        }
        else
        {
            l3=l2;
            l3.next=mergeList(l1,l2.next);
        }

        return l3;
    }

    /* Using priority queue */

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null || lists.length==0)         // if the lists array is null or if the length of the array is zero return null
            return null;

        PriorityQueue<ListNode> queue=new PriorityQueue<>(lists.length,new valueComparator());

        ListNode dummy=new ListNode(-1);
        ListNode current=dummy;

        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)                     // if a list is null, then we do not add it to priority queue
                queue.add(lists[i]);
        }

        while(!queue.isEmpty())
        {
            current.next=queue.poll();
            current=current.next;
            if(current.next!=null)
                queue.add(current.next);
        }

        return dummy.next;

    }



    public static void main(String[] args) {
        MergeKSortedLists mksl=new MergeKSortedLists();
        ListNode head1=new ListNode(1);
        head1.next=new ListNode(5);
        head1.next.next=new ListNode(7);
        head1.next.next.next=new ListNode(10);
        head1.next.next.next.next=new ListNode(11);

        ListNode head2=new ListNode(2);
        head2.next=new ListNode(4);
        head2.next.next=new ListNode(6);
        head2.next.next.next=new ListNode(8);
        head2.next.next.next.next=new ListNode(9);

        ListNode head3=new ListNode(3);
        head3.next=new ListNode(4);
        head3.next.next=new ListNode(6);
        head3.next.next.next=new ListNode(12);
        head3.next.next.next.next=new ListNode(13);

        ListNode[] listofLists={head1,head2,head3};

       /* ListNode result=mksl.mergeAllLists(listofLists);

        while(result!=null)
        {
            System.out.println(result.val);
            result=result.next;
        }*/

       ListNode result=mksl.mergeKLists(listofLists);
        while(result!=null)
        {
            System.out.println(result.val);
            result=result.next;
        }
    }
}

class valueComparator implements Comparator<ListNode>
{
    public int compare(ListNode l1,ListNode l2)
    {
        return l1.val-l2.val;
    }
}
