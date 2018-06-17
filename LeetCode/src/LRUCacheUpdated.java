/*LRU Cache:
This is the same implementation as that of LRU cache, just that here, each method for doubly linked list is present as public within the DoublyLinkedNode class itself */

import java.util.Hashtable;

public class LRUCacheUpdated {

    Hashtable<Integer,DoublyLinkedNode> myCache=new Hashtable<Integer, DoublyLinkedNode>();  // our cache will be a hash table of Integer value as key and a doubly linked node associated with it as its value
    int count;
    int capacity;
    DoublyLinkedNode head, tail; // we use nodes head and tail so that we can preform operations on all the nodes between them

    public LRUCacheUpdated(int capacity)
    {
        this.count=0;
        this.capacity=capacity;

        head=new DoublyLinkedNode();
        head.prev=null;

        tail=new DoublyLinkedNode();
        tail.next=null;

        head.next=tail;
        tail.prev=head;
    }

    class DoublyLinkedNode
    {
        int key;
        int value;
        DoublyLinkedNode prev;
        DoublyLinkedNode next;

        /* Add the new node after the Head node */

        public void addNode()
        {
            this.prev=head;
            this.next=head.next;
            head.next.prev=this;
            head.next=this;
        }

    /* Remove the node from doubly Linked List */

        public void removeNode()
        {
            DoublyLinkedNode previousNode=this.prev;
            DoublyLinkedNode nextNode=this.next;
            nextNode.prev=previousNode;
            previousNode.next=nextNode;
        }

    /* On each access to the same key, move the respective node to the head of the list signifying that it is the most recently used key */

        private void moveNodeToHead()
        {
            this.removeNode();
            this.addNode();
        }

    /* This is going to be the least recently used key, whose node would be removed from tail */

        public DoublyLinkedNode removeFromTail()
        {
            DoublyLinkedNode node=tail.prev;
            node.removeNode();
            return node;
        }
    }

    public int get(int key)
    {
        DoublyLinkedNode node=myCache.get(key);
        if(node==null)    // if the node corresponding to the key is null, it means the node was removed by LRU cache and hence is unavailable
        {
            return -1;
        }
        else
        {
            node.moveNodeToHead();    // now this key will become the most recently used, since it will go to head's next directly
            return node.value;
        }
    }

    public void put(int key, int value)
    {
        DoublyLinkedNode node=myCache.get(key);
        if(node==null)                    // if inserting a key for the first time
        {
            node=new DoublyLinkedNode();
            node.key=key;
            node.value=value;

            myCache.put(key,node);       // if the entry is being made for the first time, then the entry will be made in the cache and the node would be added to the linked list, just ahead of the head node
            node.addNode();

            count++;

            if(count > capacity)      // after adding a new entry, the least recently used entry will be removed from the cache
            {
                DoublyLinkedNode LRUEntry=node.removeFromTail();
                myCache.remove(LRUEntry.key);
                count--;
            }
        }
        else             // if key is already present, update the node to the head
        {
            node.value=value;
            node.moveNodeToHead();
        }
    }
}
