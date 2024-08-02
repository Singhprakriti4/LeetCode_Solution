class FrontMiddleBackQueue {
    ArrayList<Integer> arr;
    public FrontMiddleBackQueue() {
      arr=new ArrayList<>();  
    }
    
    public void pushFront(int val) {
       arr.add(0,val); 
    }
    
    public void pushMiddle(int val) {
        int mid= arr.size()/2;
        arr.add(mid,val);
    }
    
    public void pushBack(int val) {
        arr.add(val);
    }
    
    public int popFront() {
        if(arr.isEmpty()){
            return -1;
        }
       return arr.remove(0);
    }
    
    public int popMiddle() {
       if(arr.isEmpty()){
            return -1;
        }
        
        int mid= arr.size()%2==0?( arr.size()-1)/2: arr.size()/2;
        return arr.remove(mid);
        
    }
    
    public int popBack() {
       if(arr.isEmpty()){
            return -1;
        }
        return arr.remove(arr.size()-1); 
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */