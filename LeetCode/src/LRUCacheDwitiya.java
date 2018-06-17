import java.util.Hashtable;

public class LRUCacheDwitiya {

    class DoublyLinkedNode
    {
        int key;
        int value;
        DoublyLinkedNode next;
        DoublyLinkedNode prev;
    }

    Hashtable<Integer,DoublyLinkedNode> myLRUCache;
    int count;
    int capacity;
    DoublyLinkedNode head,tail;

    public LRUCacheDwitiya(int capacity)
    {
        myLRUCache=new Hashtable<>();
        this.capacity=capacity;
        this.count=0;

        head=new DoublyLinkedNode();
        tail=new DoublyLinkedNode();
        head.next=tail;
        head.prev=null;
        tail.prev=head;
        tail.next=null;

    }

    private void addNode(DoublyLinkedNode node)   // add from head
    {
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }

    private void removeNode(DoublyLinkedNode node)  // remove from tail
    {
        DoublyLinkedNode prevNode=node.prev;
        DoublyLinkedNode nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }

    private void moveToHead(DoublyLinkedNode node)
    {
        this.removeNode(node);
        this.addNode(node);
    }

    private DoublyLinkedNode removeFromTail()
    {
        DoublyLinkedNode node=tail.prev;
        this.removeNode(node);
        return node;
    }

    public void put(int key, int value)
    {
        DoublyLinkedNode node=myLRUCache.get(key);
        if(node==null)           // first entry into cache
        {
            node=new DoublyLinkedNode();
            node.key=key;
            node.value=value;
            myLRUCache.put(key,node);
            this.addNode(node);
            System.out.println("Added Key-val "+node.key+" "+node.value+" to cache");

            count++;
            if(count > capacity)
            {
                DoublyLinkedNode removedNode=this.removeFromTail();
                myLRUCache.remove(removedNode.key);
                count--;
                System.out.println("Capacity exceeded. Removed key-val "+removedNode.key+" "+removedNode.value);
            }

        }
        else     // if key already present, update the value
        {
            node.value=value;
            this.moveToHead(node);
            System.out.println("Updated key "+node.key+" with value "+node.value);
        }
    }

    public int get(int key)
    {
        DoublyLinkedNode node=myLRUCache.get(key);
        if(node==null)
        {
            System.out.println("Key has no such value. Returning -1");
            return -1;
        }
        else
        {
            this.moveToHead(node);
            System.out.println(" Value: "+node.value);
            return node.value;
        }
    }


    public static void main(String[] args) {
        LRUCacheDwitiya cache=new LRUCacheDwitiya(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
