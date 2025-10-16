class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

       PriorityQueue<Integer> minheap=new PriorityQueue<>();
       HashMap<Integer,Integer> map=new HashMap<>();

       for(int i=0;i<hand.length;i++){
        // minheap.add(hand[i]);// cannot do it here since, heap me distinct value daalna hai
        if(!map.containsKey(hand[i])){
            map.put(hand[i],1);
        }
        else{
            map.put(hand[i],map.get(hand[i])+1);
        }
       }

       minheap.addAll(map.keySet());


       while(!minheap.isEmpty()){
        //per cycle
        int len=groupSize;
        int prev=-1;
        List<Integer> buffer=new ArrayList<>();
        while(len>0){
            if(minheap.isEmpty()) return false;
            //poll and store
            int key=minheap.poll();
            if(prev!=-1 && key!=prev+1){
            
                System.out.println("key: prev"+ key + ": "+prev);
                return false;
            }
            prev=key;
            map.put(key,map.get(key)-1);
            if(map.get(key)!=0){
                buffer.add(key);
            }
            len--;
        }

        // if(len!=0) return false;
        minheap.addAll(buffer);
       }

       return true;

    }
}