import java.util.HashMap;

/**
 * Created by Annam on 05-08-2015.
 */
class dNode{
    int val;
    int key;
    dNode next;
    dNode prev;
    public dNode(int k,int v)
    {
        this.key=k;
        this.val=v;
    }
}
public class LRUCache {
    int capacity;
    HashMap<Integer,dNode> map=new HashMap<Integer,dNode>();
    dNode head=null,end=null;
    public LRUCache(int capacity)
    {
        this.capacity=capacity;
    }
    public int get(int key) {
        if(map.containsKey(key))
        {
            dNode n=map.get(key);
            remove(n);
            setHead(n);
            return n.val;
        }
        return -1;

    }
    public void remove(dNode n)
    {
        if(n.prev==null) {//head node is to be removed
            head=n.next;
        }
        else
        {
            n.prev.next=n.next;
        }
        if(n.next==null)//end node is to be removed
        {
            end=n.prev;
        }
        else
        {
            n.next.prev=n.prev;
        }

    }

    public void setHead(dNode n)
    {
        n.next=head;
        n.prev=null;

        if(head!=null)
        {
           head.prev=n;
        }
        head=n;
        if(end==null)
            end=n;
    }

    public void set(int key, int value) {
        if(map.containsKey(key))
        {
            dNode n=map.get(key);
            n.val=value;
            remove(n);
            setHead(n);
        }
        else
        {
            dNode n=new dNode(key,value);
            if(map.size()>=capacity)
            {
                map.remove(end.key);
                remove(end);

            }

            setHead(n);
            map.put(key,n);
        }

    }

}
