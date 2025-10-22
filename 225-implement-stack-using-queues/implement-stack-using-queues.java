class MyStack {
    Queue<Integer> mainq;
    Queue<Integer> helperq;

    public MyStack() {
        mainq=new LinkedList<>() ;   
        helperq=new LinkedList<>();    
    }
    
    public void push(int x) {
        mainq.offer(x);
    }
    
    public int pop() {

        if(empty()) return -1;

        //transfer in the helper q
        int ans=-1;
        while(mainq.size()>1){
            int val=mainq.poll();
            helperq.offer(val);
        }
        //donot insert the last one
        ans=mainq.poll();

        //add everything back
        while(!helperq.isEmpty()){
            mainq.offer(helperq.poll());
        }
        return ans;
    }
    
    public int top() {
         if(empty()) return -1;

        //transfer in the helper q
        int ans=-1;

        while(!mainq.isEmpty()){
            int val=mainq.poll();
            helperq.offer(val);
            ans=val;
        }

        //add everything back
        while(!helperq.isEmpty()){
            mainq.offer(helperq.poll());
        }
        return ans;
    }
    
    public boolean empty() {
        return mainq.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */