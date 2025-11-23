class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] r : roads) {
            adj[r[0]].add(new int[]{r[1], r[2]});
            adj[r[1]].add(new int[]{r[0], r[2]});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1], b[1]));

        long[] ways = new long[n];
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new long[]{0, 0}); // node, dist

        int MOD = 1_000_000_007;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int node = (int)cur[0];
            long time = cur[1];

            if (time > dist[node]) continue;

            for (int[] e : adj[node]) {
                int nei = e[0];
                long wt = e[1];
                long newTime = time + wt;

                if (newTime < dist[nei]) {
                    dist[nei] = newTime;
                    ways[nei] = ways[node];
                    pq.add(new long[]{nei, newTime});
                }
                else if (newTime == dist[nei]) {
                    ways[nei] = (ways[nei] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n-1];
    }
}
