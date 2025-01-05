class Pair implements Comparable<Pair>{
    int v;
    int wt;
    Pair(int v, int wt){
        this.v=v;
        this.wt=wt;
    }
    public int compareTo(Pair that){
        return this.wt-that.wt;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        boolean[] visited=new boolean[n];
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        PriorityQueue<Pair> q=new PriorityQueue<>();
        q.add(new Pair(k,0));
        ans[k-1]=0;

        while(!q.isEmpty()){
            Pair p=q.poll();
            int node=p.v;
            if(visited[node-1]){
                continue;
            }
            visited[node-1]=true;
            for(int i=0;i<times.length;i++){
                if(times[i][0]==node){
                    int vertex=times[i][1];
                    int weight=times[i][2];
                    if(!visited[vertex-1] && ans[vertex-1]>ans[node-1]+weight){
                        ans[vertex-1]=ans[node-1]+weight;
                        q.add(new Pair(vertex,ans[vertex-1]));
                    }
                }
            }
        }
       int result=-1;
       for(int i=0;i<ans.length;i++){
        if(ans[i]==Integer.MAX_VALUE){
            return -1;
        }
         result=(result<ans[i])?ans[i]:result;
       }
       return result;
    }
}