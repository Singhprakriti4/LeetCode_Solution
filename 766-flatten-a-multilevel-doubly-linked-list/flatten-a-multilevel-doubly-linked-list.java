/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node n;
    public Node flatten(Node head) {
        n=head;
        traverse();

        return head;
    }
    public void traverse(){
        if(n==null){
            return;
        }
        if(n.next==null){
            if(n.child==null) return;
            else{
                n.next = n.child;
                n.child.prev=n;
                n.child=null;   
                n = n.next;
                traverse();
            }
             return;
        }
        if(n.child==null){
            n=n.next;
            traverse();
        }
        else{
            Node p=n.next;
            n.next=n.child;
            n.child.prev=n;
            n.child=null;
            n=n.next;
            traverse();
            n.next=p;
            p.prev=n;
            n=n.next;
            traverse();
        }
    }
}