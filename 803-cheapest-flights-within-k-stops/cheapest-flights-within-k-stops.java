class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       int[] dist=new int[n];
       Arrays.fill(dist, Integer.MAX_VALUE);
       dist[src]=0;

      for(int i=0;i<=k;i++){
        //relax each edge 
        int[] temp=dist.clone();

        for(int j=0;j<flights.length;j++){
            int from=flights[j][0];
            int to=flights[j][1];
            int wt=flights[j][2];

            if(dist[from] !=Integer.MAX_VALUE &&
            temp[to]>dist[from]+wt){
                temp[to]=dist[from]+wt;
            }

        }
        dist=temp;
      }

      if(dist[dst]==Integer.MAX_VALUE) return -1;
      return dist[dst];
    }
}