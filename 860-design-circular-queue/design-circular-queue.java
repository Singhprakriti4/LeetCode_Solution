class MyCircularQueue {
    
    int[] arr;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        arr=new int[k];
        front=-1;
        rear=-1;
    }
    
    public boolean enQueue(int value) {
        if(front==-1 && rear==-1){
            front++;
            rear++;
            arr[0]=value;
            return true;
        }
        else if(rear<arr.length-1 && rear+1!=front){
             rear++;
             arr[rear]=value;
             return true;
        }
        else if(rear==arr.length-1 && front!=0){
            rear=0;
            arr[rear]=value;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(front==-1 && rear==-1){
           return false;
        }
       else if(front==rear){
            front=-1;
            rear=-1;
        }
        else if(front==arr.length-1){
            front=0;
        }
        else{
            front+=1;
        }
        return true;
    }
    
    public int Front() {
         if(front==-1 && rear==-1){
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        if(front==-1 && rear==-1){
            return -1;
        }
        return arr[rear];
    }
    
    public boolean isEmpty() {
        if(rear==-1 && front==-1){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(front==rear+1){
            return true;
        }
        else if(rear==arr.length-1 && front==0){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */