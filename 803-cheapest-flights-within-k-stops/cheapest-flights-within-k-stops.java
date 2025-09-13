class Solution {
    //dijkastrs
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       ArrayList<int[]>[] adj=new ArrayList[n];
       for(int i=0;i<adj.length;i++){
        adj[i]=new ArrayList<>();
       }

       for(int i=0;i<flights.length;i++){
        adj[flights[i][0]].add(new int[]{flights[i][1],flights[i][2]});
       }
       int[] dist=new int[n];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[src]=0;

       Queue<int[]> q=new LinkedList<>();
       q.add(new int[]{0,src,0});

       while(!q.isEmpty()){

        int[] arr=q.poll();
        int cost=arr[0];
        int node=arr[1];
        int stops=arr[2];

        if(stops>k){
            continue;
        }

        for(int i=0;i<adj[node].size();i++){

            int vertex=adj[node].get(i)[0];
            int price=adj[node].get(i)[1];

            if(price+cost<dist[vertex] && stops<=k){
            dist[vertex]=price+cost;
            q.add(new int[]{cost+price,vertex,stops+1});
            
           }
        }
       }

       if(dist[dst]==Integer.MAX_VALUE)return -1;

       return dist[dst];

    }
}