class Pair implements Comparable<Pair>{
    int node;
    long dist;
    Pair(int node, long dist){
        this.node=node;
        this.dist=dist;
    }
    public int compareTo(Pair that){
        return Long.compare(this.dist, that.dist);
    }
} 
class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        //making adjecency list
        ArrayList<ArrayList<Integer>>[] adj=new ArrayList[n];
        for(int i=0;i<adj.length;i++){
            adj[i]=new ArrayList<>();
        }  
        for(int i=0;i<roads.length;i++){
            adj[roads[i][0]].add(new ArrayList<>(List.of(roads[i][1],roads[i][2])));
            adj[roads[i][1]].add(new ArrayList<>(List.of(roads[i][0],roads[i][2])));
        }
        
        long[] ans=new long[n];
        int[] ways=new int[n];
        Arrays.fill(ans,Long.MAX_VALUE);

        PriorityQueue<Pair> q=new PriorityQueue<>();
        q.add(new Pair(0,0));
        ans[0]=0;
        ways[0]=1;

        while(!q.isEmpty()){
            Pair p=q.poll();
            int node=p.node;
            long dist=p.dist;
          
                //neighbours
                ArrayList<ArrayList<Integer>> neighbours=adj[node];
                for(ArrayList<Integer> list:neighbours){
                    int vertex=list.get(0);
                    int weight=list.get(1);
                    if(ans[vertex]==weight+dist){
                        ways[vertex]=(ways[vertex]+ways[node])%MOD;
                    }
                    else if(ans[vertex]>weight+dist){
                        ways[vertex]=ways[node];
                        ans[vertex]=weight+dist;
                        q.add(new Pair(vertex,ans[vertex]));
                    }
                }
            
        }
        System.out.println(ans[n-1]);
        return ways[n-1]%MOD;
    }
}