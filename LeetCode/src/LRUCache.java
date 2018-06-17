/*PROBLEM STATEMENT: LRU Cache
    Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 capacity  );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
         */

import java.util.Hashtable;

public class LRUCache {

    Hashtable<Integer,DoublyLinkedNode> myCache=new Hashtable<Integer, DoublyLinkedNode>();  // our cache will be a hash table of Integer value as key and a doubly linked node associated with it as its value
    int count;
    int capacity;
    DoublyLinkedNode head, tail; // we use nodes head and tail so that we can preform operations on all the nodes between them

    public LRUCache(int capacity)
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
    }

    /* Add the new node after the Head node */

    private void addNode(DoublyLinkedNode node)
    {
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }

    /* Remove the node from doubly Linked List */

    private void removeNode(DoublyLinkedNode node)
    {
        DoublyLinkedNode previousNode=node.prev;
        DoublyLinkedNode nextNode=node.next;
        nextNode.prev=previousNode;
        previousNode.next=nextNode;
    }

    /* On each access to the same key, move the respective node to the head of the list signifying that it is the most recently used key */

    private void moveNodeToHead(DoublyLinkedNode node)
    {
        this.removeNode(node);
        this.addNode(node);
    }

    /* This is going to be the least recently used key, whose node would be removed from tail */

    private DoublyLinkedNode removeFromTail()
    {
        DoublyLinkedNode node=tail.prev;
        this.removeNode(node);
        return node;
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
            this.moveNodeToHead(node);    // now this key will become the most recently used, since it will go to head's next directly
            return node.value;
        }
    }

    public void put(int key, int value)
    {
        DoublyLinkedNode node=myCache.get(key);
        if(node==null)                 // if inserting a key for the first time
        {
            node=new DoublyLinkedNode();
            node.key=key;
            node.value=value;

            myCache.put(key,node);       // if the entry is being made for the first time, then the entry will be made in the cache and the node would be added to the linked list, just ahead of the head node
            this.addNode(node);

            count++;

            if(count > capacity)      // after adding a new entry, the least recently used entry will be removed from the cache
            {
                DoublyLinkedNode LRUEntry=removeFromTail();
                myCache.remove(LRUEntry.key);
                count--;
            }
        }
        else             // if key is already present, update the node to the head
        {
            node.value=value;
            this.moveNodeToHead(node);
        }
    }

}
