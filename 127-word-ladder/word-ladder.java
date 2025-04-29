class Solution {
    public int ladderLength(String begin, String end, List<String> wordlist) {
        //if list!contains the beginword-> add it
        boolean hasbegin=false;
        boolean hasend=false;

        for(int i=0;i<wordlist.size();i++){
            if(wordlist.get(i).equals(begin)){
                hasbegin=true;
            }
            if(wordlist.get(i).equals(end)){
                hasend=true;
            }
        }
        
         System.out.println("hi");
        if(!hasend) return 0;
        
        if(!hasbegin) wordlist.add(begin);

    
       Queue<String> q=new LinkedList<>();
       Set<String> s=new HashSet<>();//this acts as visited array
       int ans=1;

       q.add(begin);
       s.add(begin);
       q.add(null);

       while(!q.isEmpty()){
       
        String node=q.poll();

        if(node==null){
            ans+=1;

           if(q.size()!=0){
            q.add(null);
        }
        continue;
        }
        //iterate on array and find the strings diffreng by 1
    
        for(int i=0;i<wordlist.size();i++){
            String vertex=wordlist.get(i);
            

            if(!s.contains(vertex) && difference(node,vertex)==1){
                //add the vertex in the list of node in adj
                
                if(vertex.equals(end)) return ans+1;
                q.add(vertex);
                s.add(vertex);
            }
        }

       }
   
   return 0;

    }
    public int difference(String a, String b){
        int ans=0;

        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)) ans++;
        }
        return ans;
    }
}