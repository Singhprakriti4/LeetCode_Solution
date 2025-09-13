class Solution {
    //dijkastrs
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    //    ArrayList<int[]>[] adj=new ArrayList[n];
    //    for(int i=0;i<adj.length;i++){
    //     adj[i]=new ArrayList<>();
    //    }

    //    for(int i=0;i<flights.length;i++){
    //     adj[flights[i][0]].add(new int[]{flights[i][1],flights[i][2]});
    //    }
    //    PriorityQueue< int[]> q=new PriorityQueue<>((a,b) -> a[0]-b[0]);
    //    q.add(new int[]{0,src,0});

    //    while(!q.isEmpty()){
    //     int[] arr=q.poll();
    //     int cost=arr[0];
    //     int node=arr[1];
    //     int stops=arr[2];

    //     if(node==dst){
    //         return cost;
    //     }
    //     if(stops>k){
    //         continue;
    //     }

    //     for(int i=0;i<adj[node].size();i++){
    //         int vertex=adj[node].get(i)[0];
    //         int price=adj[node].get(i)[1];

    //         q.add(new int[]{cost+price,vertex,stops+1});
    //     }
    //    }

    //    return -1;
// class Solution {
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // build adjacency list
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] f : flights) {
            adj[f[0]].add(new int[]{f[1], f[2]}); // {to, price}
        }

        // PriorityQueue: {cost, node, stops}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src, 0});

        // dist[node][stops] = min cost to reach node with stops
        int[][] dist = new int[n][K + 2];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], u = cur[1], stops = cur[2];

            if (u == dst) return cost;
            if (stops > K) continue;

            for (int[] edge : adj[u]) {
                int v = edge[0], price = edge[1];
                int newCost = cost + price;

                if (newCost < dist[v][stops + 1]) {
                    dist[v][stops + 1] = newCost;
                    pq.add(new int[]{newCost, v, stops + 1});
                }
            }
        }

        return -1;
 
    }
}