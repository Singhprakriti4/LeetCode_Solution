class MyLinkedList {
      int val;
        MyLinkedList next;
        MyLinkedList head;
        int size;
    public MyLinkedList() {
       size=0;
       head=null;
    }
    
    public int get(int index) {
        if(index<0 || index>=size){
            return -1;
        }
        MyLinkedList temp=head;
        int k=0;
        if(index==0){
            return head.val;
        }
        while(k!=index){
            temp=temp.next;
                k++;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
            MyLinkedList node=new MyLinkedList();
            node.val=val;
            node.next=head;
            head=node;
            size+=1;
    }
    
    public void addAtTail(int val) {
         MyLinkedList node=new MyLinkedList();
         node.val=val;
         if(head==null){
            head=node;
            size+=1;
            return;
         }
        MyLinkedList temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        size++;
        
        
    }
    
    public void addAtIndex(int index, int val) {
        if(index==0){
            addAtHead(val);
            return;
        }
        if(index==size){
            addAtTail(val);
            return;
        }
        if(index>size || index<0){
            return;
        }
       
        MyLinkedList f=head;
         int k=0;
        while(k!=index-1){
            f=f.next;
            k++;
        }
       MyLinkedList node=new MyLinkedList();
       node.val=val;
       node.next=f.next;
       f.next=node;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(size==0 || index>=size || index<0){
            return;
        }
        if(index==0){
            head=head.next;
            size--;
            return;
        }
        int k=0;
        MyLinkedList temp=head;
        while(k!=index-1){
            temp=temp.next;
            k++;
        }
        temp.next=temp.next.next;
        size--; 
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */