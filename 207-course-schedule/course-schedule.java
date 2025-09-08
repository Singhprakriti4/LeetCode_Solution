class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<adj.length;i++){
            ArrayList<Integer> list=new ArrayList<>();
            adj[i]=list;
        }

        for(int i=0;i<prerequisites.length;i++){
            int from=prerequisites[i][1];
            int to=prerequisites[i][0];

            adj[from].add(to);
        }

        boolean[] visited=new boolean[numCourses];
        boolean[] currpath=new boolean[numCourses];
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                if(dfs(visited,currpath,adj,i,-1)) return false;
            }
        }

        return true;
    }
    public boolean dfs(boolean[] visited,boolean[] currpath, ArrayList<Integer>[] adj,
    int node, int parent){
        visited[node]=true;
        currpath[node]=true;

        for(int i=0;i<adj[node].size();i++){
            int vertex=adj[node].get(i);
            if(!visited[vertex]){
                if(dfs(visited,currpath,adj,vertex,node)) return true;
            }
            else if(currpath[vertex]==true){
                return true;
            }
        }

        currpath[node]=false;
        return false;
    }
}