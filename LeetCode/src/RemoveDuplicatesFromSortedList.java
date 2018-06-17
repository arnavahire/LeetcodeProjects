public class RemoveDuplicatesFromSortedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

      /* Recursion */
  }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        head.next=deleteDuplicates(head.next);  // this will go to the end of list and the start coming back
        if(head.next.val==head.val)
            return head.next;
        return head;

    }
}
