class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //topological sort using dfs

        //making adjecenty list
        ArrayList<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<adj.length;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        int[] ans=new int[adj.length];
        int ptr=-1;
        Stack<Integer> stk=new Stack<Integer>();
        boolean[] currentpath=new boolean[ans.length];

        boolean[] visited=new boolean[ans.length];
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                if(dfs(i,visited,adj,stk,currentpath)){
                    return new int[]{};
                }
            }
        }
        while(!stk.isEmpty()){
            ans[++ptr]=stk.pop();
        }
     return ans;
    }
    //returns true if there is a cycle
    boolean dfs(int node,boolean[] visited,ArrayList<Integer>[] adj,
    Stack<Integer> stk,boolean[] currentpath){

        visited[node]=true;
        currentpath[node]=true;

        for(int e: adj[node]){
            if(!visited[e]){
               if( dfs(e,visited,adj,stk,currentpath)) 
               return true;
            }
            else{
                if(currentpath[e]){
                    return true;
                }
            }
        }

        stk.push(node);
        currentpath[node]=false;
        return false;

    }
}