class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //topological sort using bfs
        //making adjecenty and calculating indegree
        int[] indegree=new int[numCourses];
        ArrayList<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<adj.length;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]+=1;
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        
        int[] ans=new int[numCourses];
        int ptr=-1;
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

       while(!q.isEmpty()){
        int v=q.poll();
        ans[++ptr]=v;
        for(int e:adj[v]){
            indegree[e]--;
            if(indegree[e]==0){
                q.add(e);
            }
            if(indegree[e]<0){
                return new int[]{};
            }
        }
       }
       if(ptr<ans.length-1){
        return new int[]{};
       }
       return ans;
        
    }
}