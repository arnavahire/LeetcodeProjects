public class LinkedListCycle2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;

        int flag=0;

        ListNode slow=head;
        ListNode fast=head;

        while (fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                flag=1;      // cycle exists. Now determine starting point of the cycle. EX: [3,2,0,-4] and cycle is at index 1 i.e at element 2, we detect at element -4 that cycle exists
                break;
            }
        }
        if(flag==1)
        {
            slow=head;       // set the slow runner from the head, and keep the fast runner at the position where the cycle was detected. Ex: after cycle detected t -4, we will bring slow to element again 3, and fast will continue from -4
            while (slow!=fast)
            {
                slow=slow.next;      // now until both slow and fast reach the desired node, move both slow and fast ahead by just one node. EX: after incrementing fast and slow we get the start point as index 1 i.e element 2
                fast=fast.next;
            }
            return slow;
        }
        return null;   // if flag = 0 it means no cycle exists hence we will return null as the starting of cycle

    }

    // 2nd Try

    public ListNode detectCycleAgain(ListNode head) {

        if(head==null)
            return null;

        ListNode slow=head;
        ListNode fast=head;
        boolean flag=false;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)
            {
                flag=true;
                break;
            }

        }

        if(flag==true)
        {
            slow=head;
            while(slow!=fast)
            {
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
        return null;        // no cycle exists
    }
}
