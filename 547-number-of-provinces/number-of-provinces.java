/*
bfs
using Queue
*/ 

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int[] visited=new int[n+1];

        //making the adjecency list
        ArrayList<Integer>[] adj=new ArrayList[n+1];
        adj[0]=new ArrayList<>();
        
        for(int i=0;i<isConnected.length;i++){
            adj[i+1]=new ArrayList<>();
            int row=i;
            for(int col=0;col<n;col++){
                if(isConnected[row][col]==1){
                    adj[row+1].add(col+1);
                }
            }
        }
       

        int ans=0;
        //0 : not visited, 1: visited
        for(int i=1;i<visited.length;i++){
            
            if(visited[i]==0){
                ans+=1;
                visited[i]=1;
                bfs(adj,visited,i);
            }
        }
        return ans;
    }
    public void bfs(ArrayList<Integer>[] adj, int[] visited, int src){
        Queue<Integer> q=new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()){
            int city=q.poll();
            // visited[city]=1;

            //visit its unvisited neighbours
            for(int i=0;i<adj[city].size();i++){
                if(visited[adj[city].get(i)]==0){
                    visited[adj[city].get(i)]=1;
                    q.add(adj[city].get(i));
                }
            }
            
        }
    }
}