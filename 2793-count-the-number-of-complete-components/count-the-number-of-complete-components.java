class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
       boolean[] components=new boolean[n];
       int ans=0;

       for(int i=0;i<n;i++){
        if(components[i]==false){
            
           if(bfs(i,edges,components)) ans++;

        }

       }
       return ans; 
    }
       
       public boolean bfs(int node,int[][] edges, boolean[] visited){

        Queue<Integer> q=new LinkedList<>();

        int vertices=0;
        int totaledges=0;

        q.add(node);
        visited[node]=true;

        while(!q.isEmpty()){

            int n=q.poll();
            // System.out.println(n);
            vertices++;
            
            //traverse on the edges

            for(int i=0;i<edges.length;i++){

                if(edges[i][0]==n  || edges[i][1]==n){

                    totaledges++;
                    int adj=-1;
                    if(edges[i][0]==n) {
                        adj=edges[i][1];
                    }
                    else{
                        adj=edges[i][0];
                    }

                    if(!visited[adj]){
                        q.add(adj);
                        visited[adj]=true;
                    }
                }
            }
        }
        // System.out.print(vertices+" ");
        // System.out.println(totaledges);
        if(totaledges==(vertices*(vertices-1))){
            return true;
        }

        return false;

       }
    }
