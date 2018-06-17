public class MergeTwoSortedLists {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    // We use recursion to solve this problem

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)        // if first list is null return second list
            return l2;
        if(l2==null)        // vice versa
            return l1;

        ListNode l3=null;
        if(l1.val<=l2.val)  // if first list's value is less than second then make new node and assign the first list node to it
        {
            l3=l1;
            l3.next=mergeTwoLists(l1.next,l2);  // move list 1 ahead by one place
        }
        else if(l1.val>l2.val)      // vice versa
        {
            l3=l2;
            l3.next=mergeTwoLists(l1,l2.next);
        }
        return l3;
    }
}

