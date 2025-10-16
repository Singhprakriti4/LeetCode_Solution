class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freq=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            if(!freq.containsKey(tasks[i])){
                freq.put(tasks[i],1);
            }
            else{
                freq.put(tasks[i],freq.get(tasks[i])+1);
            }
        }

        //maxheap
        PriorityQueue<Character> maxheap=new PriorityQueue<>((a,b)->freq.get(b)-freq.get(a));
       

        maxheap.addAll(freq.keySet());//O(k) only since ye ek baar me saare elemnts daala ke maxheapify call kar rha hai
        int lastideal=0;
        int steps=0;

        // it may seem like the TC is O(n*k log k)
        // but if you look at it closely
        // the max no of inserts or poll is n times (for each charactere)
        // so,total TC is O(nlogk)
        while(!maxheap.isEmpty()){
           //get the top n  and reduce their freq in the map ans if their freq is not equal to 0 the  add them back in the heap
           List<Character> local=new ArrayList<>();
           int k=n+1;
           while(k!=0){//O(n+1) or fewer
            if(maxheap.size()==0) break;
            char key=maxheap.poll();//O(log k)
            freq.put(key,freq.get(key)-1);
            if(freq.get(key)!=0){
                local.add(key);
            }
            k--;
           }

           steps+=n+1;
           if(k!=0){
              lastideal=k;
           }

           //add them abck in the heap
           maxheap.addAll(local);//O(k)

        }

        return steps-lastideal;

    }
}