class Solution {
    public String kthDistinct(String[] arr, int k) {
       Map<String, Integer> map=new LinkedHashMap<>();
       int nth=0;

       for(int i=0;i<arr.length;i++){
        if(map.containsKey(arr[i])){
          map.put( arr[i] ,map.get(arr[i])+1);
        }
        else{
           map.put(arr[i],1);
       } 
       }
    
       for(String key: map.keySet()){
        if(map.get(key)==1){
            nth++;
            if(nth==k){
                return key;
            }
        }
       }

       return "";
    }
}