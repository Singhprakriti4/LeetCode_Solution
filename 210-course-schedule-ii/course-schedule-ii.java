class Solution {
    //detect cycle-> do topological sort
    public int[] findOrder(int num, int[][] prerequisites) {

        int[] result=new int[num];
        int k=0;
        ArrayList<Integer>[] adj=new ArrayList[num];
        for(int i=0;i<num;i++){
            ArrayList<Integer> list=new ArrayList<>();
            adj[i]=list;
        }

        for(int i=0;i<prerequisites.length;i++){
            
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            // System.out.println(a+" "+b);

            adj[b].add(a);
        }

        // System.out.print("adj "+adj[1].get(0));

        //detection of cycle in idrected graph -> bfs
        //indegree
        int[] indegree=new int[num];
        for(int i=0;i<adj.length;i++){
            for(int j=0;j<adj[i].size();j++){
                indegree[adj[i].get(j)]+=1;
            }
        }
        // indegree
        // for(int i=0;i<num;i++){
        //     System.out.print(indegree[i]+" ");
        // }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                result[k++]=i;
                q.add(i);
            }
        }

        if(q.isEmpty()){
            // System.out.println("hi");
            return new int[]{};
        }
        while(!q.isEmpty()){
            int node=q.poll();
            for(int i=0;i<adj[node].size();i++){
                int vertex=adj[node].get(i);
                // if(indegree[vertex]<=0){
                //     System.out.println(vertex);

                //    return new int[]{};
                // }
                // else{
                    indegree[vertex]-=1;
                    if(indegree[vertex]==0){
                        result[k++]=vertex;
                        q.add(vertex);
                    // }
                       
                }
            }
        }
        if(k!=num) return new int[] {};
        return result;
    }
}