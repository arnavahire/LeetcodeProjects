public class LinkedListCycle {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public boolean hasCycle(ListNode head) {

        if(head==null)        // no cycle present if head = null
            return false;

        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null)  // the loop will continue until the fast runner doesn't reach null
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
