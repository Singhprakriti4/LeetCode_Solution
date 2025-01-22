
class Pair implements Comparable<Pair>{
    int node;
    int wt;
    Pair(int node, int wt){
        this.node=node;
        this.wt=wt;
    }
    public int compareTo(Pair that){
        return this.wt-that.wt;
    }
}
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[] cities=new int[n];
        Arrays.fill(cities,Integer.MAX_VALUE);
        //make adjecency list
        ArrayList<ArrayList<Integer>>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
          int from=edges[i][0];
          int to=edges[i][1];
          int dist=edges[i][2];
          ArrayList<Integer> l1=new ArrayList<>();
          l1.add(to);l1.add(dist);
          adj[from].add(l1);
          ArrayList<Integer> l2=new ArrayList<>();
          l2.add(from);l2.add(dist);
          adj[to].add(l2);
        }
        for(int i=0;i<n;i++){
            int[] ans=new int[n];
            int src=i;
            Arrays.fill(ans,Integer.MAX_VALUE);
            ans[src]=0;
            boolean[] visited=new boolean[n];
            
            PriorityQueue<Pair> q=new PriorityQueue<>();
            q.add(new Pair(src,0));
            while(!q.isEmpty()){
                Pair p=q.poll();
                int node=p.node;
                int wt=p.wt;
                if(!visited[node]){
                    visited[node]=true;
                    //iterate on the adjecent nodes
                    ArrayList<ArrayList<Integer>> list=adj[node];
                    for(ArrayList<Integer> neighbours:list){
                        int vertex=neighbours.get(0);
                        int dist=neighbours.get(1);
                        if(!visited[vertex] && ans[vertex] >wt+dist){
                            ans[vertex] = wt+dist;
                            q.add(new Pair(vertex,ans[vertex]));
                        }
                    }
                }
            }
            int citycount=0;
            for(int j=ans.length-1;j>=0;j--){
                if(ans[j]<=distanceThreshold){
                    citycount++;
                }
            }
            cities[src]=citycount;
        }
       int solution=Integer.MAX_VALUE;
       int solution_index=0;
        for(int i=n-1;i>=0;i--){
            if(cities[i]<solution){
                solution=cities[i];
                solution_index=i;
            }
        }

        return solution_index;
    }
}