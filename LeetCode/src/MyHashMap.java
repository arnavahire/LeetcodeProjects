/* PROBLEM STATEMENT: Implement your own version of HASHMAP */

public class MyHashMap {

    class Node
    {
        Object key;
        Object value;
        Node next;
    }

    Node[] bucket;       // Bucket is the array of LinkedList Nodes

    public MyHashMap(int size)
    {
        bucket=new Node[size];     // the size of Hashmap is decided on runtime through constructor
    }

    // GET

    Object get(Object key)
    {
        int keyHash=Math.abs(key.hashCode() % bucket.length);  // for each key, its hash is calculated, and based on that hash it is checked at the respective index position of that key exists

        if(bucket[keyHash]==null)        // if the bucket position is empty, it means no node containing key-val is present, so return null
            return null;
        else
        {
            Node temp=bucket[keyHash];    // else if the key is present, it's value is returned, if not, we go to the next node in the list
            do {
                if(key==temp.key)
                    return temp.value;
                temp=temp.next;
            }while(temp!=null);
        }
        return null;
    }

    // PUT

    void put(Object key, Object value)
    {
        int keyHash=Math.abs(key.hashCode() % bucket.length);

        if(bucket[keyHash]==null)       // if no key-val is present at the bucket index, then we create a node which stores these values
        {
            Node head=new Node();
            bucket[keyHash]=head;
            head.key=key;
            head.value=value;
        }
        else                          // if a linkedList already exists, we check if the key is already present. If yes, then we update the value, else we
        {

            Node temp=bucket[keyHash];   // the node at bucket[keyhash] is taken in temp
            Node prev=new Node();        // prev is the predecessor of temp
            prev.next=temp;
            do {
                if(key==temp.key)        // if key already present, update value and return
                {
                    temp.value=value;
                    return;
                }
                temp=temp.next;          // else increment temp and prev
                prev=prev.next;
            }while(temp!=null);
            prev.next=new Node();        // when temp becomes null, it means u have reached the end of list, so at that time append the key-val to the next of prev
            prev.next.key=key;
            prev.next.value=value;
        }
    }

    // CONTAINS

    public boolean containsKey(Object key)
    {
        int keyHash=Math.abs(key.hashCode() % bucket.length);

        if(bucket[keyHash]==null)
        {
            return false;
        }
        else
        {
            Node temp=bucket[keyHash];
            do{
                if(key==temp.key)
                    return true;
                temp=temp.next;
            }while (temp!=null);
        }
        return false;
    }

    public boolean containsValue(Object value)
    {
        for(int i=0;i<bucket.length;i++)       // for all the buckets it is checked if the value is present, it is returned true if present, else false is returned
        {
            if(bucket[i]==null)
                continue;
            else
            {
                Node temp=bucket[i];
                do {
                    if(temp.value==value)
                        return true;
                    temp=temp.next;
                }while (temp!=null);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        MyHashMap map=new MyHashMap(2);

        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        System.out.println(map.get("1"));
        System.out.println(map.get("2"));
        System.out.println(map.get("3"));
        System.out.println(map.containsKey("1"));
        System.out.println(map.containsValue(2));
        System.out.println(map.containsValue(3));

    }
}
