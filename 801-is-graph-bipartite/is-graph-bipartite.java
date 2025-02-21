class Solution {
    public boolean isBipartite(int[][] graph) {
        
        Set<Integer> s1=new HashSet<>();
        Set<Integer> s2=new HashSet<>();

 
        int turn=1;
        boolean[] visited=new boolean[graph.length];
         //if there is any disconnected NODE then we will return false
        
        for(int k=0;k<graph.length;k++){
            if(!visited[k]){

        Queue<Integer> q=new LinkedList<>();
  
        q.add(k);
        s1.add(k);

        q.add(null);

        turn=2;

        while(!q.isEmpty()){  
            if(q.peek()==null){
                q.poll();
              if(!q.isEmpty()){
                q.add(null);
                turn++;
              }
            }
            else{
                int node=q.poll();
                for(int i=0;i<graph[node].length;i++){
                    if(!visited[graph[node][i]]){
                        if(turn%2==0){
                            //add in set 2
                            s2.add(graph[node][i]);  
                        }
                        else{
                            //add in set 1
                            s1.add(graph[node][i]);
                        }
                        visited[graph[node][i]]=true;
                        q.add(graph[node][i]);
                    }
                    else{
                        if(turn%2==0){
                            if(s1.contains(graph[node][i])){
                                return false;
                            }
                        }
                        else{
                            if(s2.contains(graph[node][i])){
                                return false;
                            }
                        }
                    }
                }
            }
        }
            }
        }
        return true;
    }
}