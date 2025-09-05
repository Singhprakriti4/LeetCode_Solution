class Solution {
    //dfs
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int ans=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                ans+=1;
                visited[i]=true;
                dfs(isConnected, visited, i);
            }
        }

        return ans;

    }

    public void dfs(int[][] isConnected, boolean[] visited, int src ){
       for(int i=0;i<isConnected[src].length;i++){
        if(isConnected[src][i]==1 && !visited[i]){
            visited[i]=true;
            dfs(isConnected, visited, i);
        }
       }
    }
}