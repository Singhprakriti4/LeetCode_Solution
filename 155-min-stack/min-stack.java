class MinStack {
    ArrayList<Integer> stk;
    ArrayList<Integer> min;
    public MinStack() {
        stk=new ArrayList<>();
         min=new ArrayList<>();
    }
    
    public void push(int val) {
          if(min.size()==0 || val<=min.get(min.size()-1)){
            min.add(val);
          }
          stk.add(val);
    }
    
    public void pop() {
        if(stk.get(stk.size()-1).equals(min.get(min.size()-1))){
            min.remove(min.size()-1);
        }
        stk.remove(stk.size()-1);

    }
    
    public int top() {
        return stk.get(stk.size()-1);
    }
    
    public int getMin() {
    
        return min.get(min.size()-1);

        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */