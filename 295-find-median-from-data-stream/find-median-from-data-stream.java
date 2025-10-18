class MedianFinder {
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;

    public MedianFinder() {
        //initialize both heaps
        minheap=new PriorityQueue<>();
        maxheap=new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        //add in the first heap
       maxheap.add(num);
       minheap.add(maxheap.poll());
       if(minheap.size()>maxheap.size()){
        maxheap.add(minheap.poll());
       }

    }
    
    public double findMedian() {

       int firsthalf=maxheap.size();
       int secondhalf=minheap.size();
    //    System.out.println("first :" +maxheap.peek());
    //    System.out.println("second :" + minheap.peek());

       if(firsthalf==secondhalf){
        //even no of nums
        return ((double)maxheap.peek()+(double)minheap.peek())/2;
       }

       //odd number of nums
       return maxheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */