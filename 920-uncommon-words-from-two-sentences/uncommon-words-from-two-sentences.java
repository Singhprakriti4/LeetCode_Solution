class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> ans=new ArrayList<>();
        Map<String,Integer> m=new HashMap<>();
        int p1=0;
        int p2=0;
        String[] arr1=s1.split(" ");
        String[] arr2=s2.split(" ");
        for(int i=0;i<arr1.length;i++){
         if(m.containsKey(arr1[i])){
           m.put(arr1[i],m.get(arr1[i])+1);
         }
         else{
            m.put(arr1[i],1);
         }
        }
        for(int i=0;i<arr2.length;i++){
         if(m.containsKey(arr2[i])){
           m.put(arr2[i],m.get(arr2[i])+1);
         }
         else{
            m.put(arr2[i],1);
         }
        }

        for (Map.Entry<String, Integer> entry : m.entrySet()) {
    if(entry.getValue()==1){
        ans.add(entry.getKey());
    }
}

     return ans.toArray(new String[0]);  
    }
}