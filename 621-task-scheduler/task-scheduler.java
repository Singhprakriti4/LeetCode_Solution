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

        maxheap.addAll(freq.keySet());
        int lastideal=0;
        int steps=0;
        while(!maxheap.isEmpty()){
           //get the top n  and reduce their freq in the map ans if their freq is not equal to 0 the  add them back in the heap
           List<Character> local=new ArrayList<>();
           int k=n+1;
           while(k!=0){
            if(maxheap.size()==0) break;
            char key=maxheap.poll();
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
           maxheap.addAll(local);

        }

        return steps-lastideal;

    }
}