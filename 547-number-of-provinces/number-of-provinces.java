class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans=0;
        if(isConnected.length==0){
            return ans;
        }
        boolean[] visited=new boolean[isConnected.length];
        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                ans++;
                bfs(isConnected,visited,i);
            }
        }
        return ans;
    }
    public void bfs(int[][] isConnected,boolean[] visited,int start ){
       Queue<Integer> q=new LinkedList<>();
       q.add(start);
       visited[0]=true;
       while(!q.isEmpty()){
        int val=q.poll();
        for(int i=0;i<isConnected.length;i++){
          if(isConnected[val][i]==1 && !visited[i]){
            visited[i]=true;
            q.add(i);
          }
        }
       }
    }
}