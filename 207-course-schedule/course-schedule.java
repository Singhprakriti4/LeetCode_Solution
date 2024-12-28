class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
          boolean[] visited=new boolean[numCourses];
          boolean[] currpath=new boolean[numCourses];
          
          ArrayList<Integer>[] adj=new ArrayList[numCourses];

          for(int i=0;i<adj.length;i++){
            adj[i]=new ArrayList<>();
          }

          for(int i=0;i<prerequisites.length;i++){
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
          }


       
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,currpath)){
                    return false;
                }
            }
        }
     return true;
    }

    boolean dfs(int node,ArrayList<Integer>[] adj,boolean[] visited, boolean
    [] currentpath){
        visited[node]=true;
        currentpath[node]=true;

        for(int e: adj[node])        {
            if(!visited[e]){
                if(dfs(e,adj,visited,currentpath)){
                    return true;
                }
            }
            else{
                if(currentpath[e]){
                    return true;
                }
            }
        }

        currentpath[node]=false;
        return false;
    }
}