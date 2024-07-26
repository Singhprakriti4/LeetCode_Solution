class MyQueue {
     Stack<Integer> main_stk=new Stack<>();
        Stack<Integer> helper_stk=new Stack<>();
    public MyQueue() {
       
    }
    
    public void push(int x) {
        main_stk.push(x);
    }
    
    public int pop() {
        while(main_stk.size()!=0){
            helper_stk.push(main_stk.pop());
        }
        int ans=helper_stk.pop();
        while(helper_stk.size()!=0){
            main_stk.push(helper_stk.pop());
        }
        return ans;
    }
    
    public int peek() {
        while(!main_stk.isEmpty()){
            helper_stk.push(main_stk.pop());
        }
        int value=helper_stk.peek();
        while(!helper_stk.isEmpty()){
            main_stk.push(helper_stk.pop());
        }
        return value;
    }
    
    public boolean empty() {
        if(main_stk.size()==0){
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */