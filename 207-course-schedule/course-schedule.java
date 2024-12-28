class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //1.find at least one with 0 indegree
        //2. no cycle 

        //via dfs
        boolean[] visited=new boolean[numCourses];
        boolean[] currpath=new boolean[numCourses];

        //cycle
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                if(dfs(i,prerequisites,visited,currpath)){
                    return false;
                }
            }
        }
     return true;
    }
    boolean dfs(int node,int[][] prerequisite,boolean[] visited, boolean
    [] currentpath){
        visited[node]=true;
        currentpath[node]=true;

        for(int i=0;i<prerequisite.length;i++){
            if(prerequisite[i][1]==node){
                if(visited[prerequisite[i][0]] && currentpath[prerequisite[i][0]]){
                    return true;
                }
                else if(!visited[prerequisite[i][0]]){
                    if(dfs(prerequisite[i][0],prerequisite,visited,currentpath)){
                        return true;
                    }
                }
            }
        }

        currentpath[node]=false;
        return false;
    }
}