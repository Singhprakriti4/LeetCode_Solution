class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       //making adjecency list+indegreelist
       int[] indegree=new int[numCourses];
       List<Integer>[] adj=new ArrayList[numCourses];

       for(int i=0;i<adj.length;i++){
        adj[i]=new ArrayList<>();
       }

       for(int i=0;i<prerequisites.length;i++){
        int a=prerequisites[i][0];
        int b=prerequisites[i][1];

        adj[b].add(a);
        indegree[a]+=1;
       } 

       //starting the topological sort
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<indegree.length;i++){
        if(indegree[i]==0){
            q.add(i);
        }
       }

       int taken=0;

       while(!q.isEmpty()){
        int c=q.poll();
        taken+=1;
        List<Integer> neighbours=adj[c];
        for(int n: neighbours){
            indegree[n]-=1;
            if(indegree[n]==0){
                q.add(n);
            }
        }
       }

       return taken==numCourses;
    }
}