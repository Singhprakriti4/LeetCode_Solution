class Solution {
    public int minimumIndex(List<Integer> nums) {
      HashMap<Integer,Integer> m=new HashMap<>();
      for(int i=0;i<nums.size();i++){
        if(!m.containsKey(nums.get(i))){
            m.put(nums.get(i),1);
        }
        else{
            // m.put(nums.get(i),m.get(nums.get(i))+1);
            m.put(nums.get(i), m.get(nums.get(i))+1);
        }
      }

      int max=0;
      int max_key=0;
      //iterate on the map and get the maxoccuring element 
      for(Map.Entry<Integer,Integer> e: m.entrySet() ){
        int k=e.getKey();
        int v=e.getValue();
        if(v>max){
            max=v;
            max_key=k;
        }
      }
//   System.out.println(max);
//   System.out.println(max_key);

      if(max<=nums.size()/2){
         return -1;
      }
      
      int curr=0;

      for(int i=0;i<nums.size();i++){
        if(nums.get(i)==max_key) curr++;
        // System.out.println(i+" :"+curr);
        if(curr>((i+1)/2) && (max-curr)>(nums.size()-i-1)/2){
            return i;
        }

      }

 return -1;
    }

}