public class OddEvenLinkedList {

    /* My initial solution */
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
            return null;

        if(head.next==null || head.next.next==null)
        {
            return head;
        }

        ListNode odd=head;
        ListNode even=head;
        ListNode first=null;
        int flag=0;

        while(odd.next!=null && odd.next.next!=null)
        {
            even=odd.next;
            if(flag==0)
            {
                first=even;
                flag=1;
            }
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
        }
        odd.next=first;

        return head;
    }

    /* Optimised Solution */

    public ListNode oddEvenListImproved(ListNode head)
    {
        if(head==null)
            return null;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode first=even;
        while(even!=null && even.next!=null)
        {
            odd.next=even.next;
            even.next=even.next.next;
            even=even.next;
            odd=odd.next;
        }
        odd.next=first;
        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList oell=new OddEvenLinkedList();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        ListNode result=oell.oddEvenList(head);
    }
}
