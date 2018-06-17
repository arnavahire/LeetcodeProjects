import java.util.HashMap;

public class IntersectionOfTwoLinkedLists {


    // Naive Code- Brute Force by me

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode intersection=null;

        ListNode tempA=headA;  // to traverse the first list
        ListNode tempB=headB;  // to traverse the second list

        if(tempA==null || tempB==null)  // if either of the list is empty then return intersection as null
        {
            return null;
        }
        else
        {
            int lenA=0,lenB=0;

            while (tempA!=null)   // find of the listA is short or if listB is short. We are going to iterate only over smaller list
            {
                lenA++;
                tempA=tempA.next;
            }
            while (tempB!=null)
            {
                lenB++;
                tempB=tempB.next;
            }

            if(lenA<=lenB)   // if first list is small then put the second lists elements in a hashmap with key being the integer values to be checked
            {
                HashMap<Integer,Integer> mapB=new HashMap<Integer,Integer>();
                tempB=headB;
                tempA=headA;
                while(tempB!=null)     // putting bigeer lists elements in the map
                {
                    mapB.put(tempB.val,1);
                    tempB=tempB.next;
                }
                while (tempA!=null)
                {
                    if(mapB.containsKey(tempA.val))  // if the key is found then add that key in our final list
                    {
                        if(intersection==null)
                        {
                            intersection=new ListNode(tempA.val);
                        }
                        else
                        {
                            ListNode temporary=intersection;
                            while (temporary.next!=null)
                            {
                                temporary=temporary.next;
                            }
                            ListNode newNode=new ListNode(tempA.val);
                            temporary.next=newNode;
                        }
                    }
                    tempA=tempA.next;
                }
            }
            else   // vice versa- if listB is smaller than list A then
            {
                HashMap<Integer,Integer> mapA=new HashMap<Integer,Integer>();
                tempB=headB;
                tempA=headA;
                while(tempA!=null)
                {
                    mapA.put(tempA.val,1);
                    tempA=tempA.next;
                }
                while (tempB!=null)
                {
                    if(mapA.containsKey(tempB.val))
                    {
                        if(intersection==null)
                        {
                            intersection=new ListNode(tempB.val);
                        }
                        else
                        {
                            ListNode temporary=intersection;
                            while (temporary.next!=null)
                            {
                                temporary=temporary.next;
                            }
                            ListNode newNode=new ListNode(tempB.val);
                            temporary.next=newNode;
                        }
                    }
                    tempB=tempB.next;
                }
            }
        }
        return intersection;

    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists iotll=new IntersectionOfTwoLinkedLists();

        ListNode headA=new ListNode(1);
        ListNode tempA=headA;
        ListNode newNodeA=new ListNode(2);
        tempA.next=newNodeA;
        tempA=tempA.next;

        ListNode headB=new ListNode(3);
        ListNode tempB=headB;
        ListNode newNodeB=new ListNode(2);
        tempB.next=newNodeB;
        tempB=tempB.next;
        newNodeB=new ListNode(4);
        tempB.next=newNodeB;
        tempB=tempB.next;

        ListNode intersection=iotll.getIntersectionNode(headA,headB);
        while(intersection!=null)
        {
            System.out.println(intersection.val);
            intersection=intersection.next;
        }

    }
}
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}