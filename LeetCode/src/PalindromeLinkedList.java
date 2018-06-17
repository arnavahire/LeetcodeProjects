public class PalindromeLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head, fast=head;
        while (fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast!=null)
        {
            slow=slow.next;   // if the length of the linkedlist is odd
        }
        slow=reverseSecondHalfOfList(slow); // get the reversed slow list here
        fast=head;                          // set the fast list to head

        while (slow!=null)              // until slow list doesn't become null check if fast's value is same as slow's value, if not return not palindrome
        {
            if(fast.val==slow.val)
            {
                fast=fast.next;
                slow=slow.next;
            }
            else
            {
                return false;
            }
        }
        return true;    // if palindrome return true

    }

    public ListNode reverseSecondHalfOfList(ListNode head)
    {
        ListNode prev=null;   // set prev = null initially
        while(head!=null)
        {
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}
