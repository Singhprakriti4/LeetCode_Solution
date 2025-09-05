/*
bfs
w/o making the adjecency list
using Queue
*/ 
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int[] visited=new int[n+1];

        int ans=0;
        //0 : not visited, 1: visited
        for(int i=1;i<visited.length;i++){
            
            if(visited[i]==0){
                ans+=1;
                visited[i]=1;
                bfs(isConnected,visited,i);
            }
        }
        return ans;
    }
    public void bfs(int[][] isConnected, int[] visited, int src){
        Queue<Integer> q=new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()){
            int city=q.poll();
            // visited[city]=1;

            //visit its unvisited neighbours
            for(int i=0;i<isConnected[0].length;i++){
                int row=city-1;
                int col=i;

                if(isConnected[row][col]==1 && visited[col+1]==0){
                    visited[col+1]=1;
                    q.add(col+1);
                }
            }
        }
    }
}