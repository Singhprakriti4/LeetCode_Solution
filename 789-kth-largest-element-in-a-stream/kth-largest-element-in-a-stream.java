class KthLargest {
    int[] nums;
    int k;
    PriorityQueue<Integer> minheap=new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.nums=nums;
        for(int num: nums){
            // if(num==null) continue;
            if(minheap.size()<k ) {
                minheap.add(num);
            }
            else{
                if(num>minheap.peek()){
                    minheap.poll();
                    minheap.add(num);
                }
            }
        }
    }
    
    public int add(int val) {
        if(minheap.isEmpty() || minheap.size()<k) {
            minheap.add(val);
        }
        else if(val>minheap.peek()){
            minheap.poll();
            minheap.add(val);
        }
        return minheap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */