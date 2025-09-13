class Pair implements Comparable<Pair>{
    int r;
    int c;
    int w;

    public Pair(int r, int c, int w){
        this.r=r;
        this.c=c;
        this.w=w;
    }

    public int compareTo(Pair that){
        return this.w-that.w;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {

      int[][] dist=new int[heights.length][heights[0].length];
      for(int i=0;i<heights.length;i++){
        Arrays.fill(dist[i],-1);
      }

      PriorityQueue<Pair> q=new PriorityQueue<>();
      q.add(new Pair(0,0,0));
      dist[0][0]=0;

      while(!q.isEmpty()){
        Pair p=q.poll();

        int r=p.r;
        int c=p.c;
        int wt=p.w;
        
        if(r==heights.length-1 && c==heights[0].length-1){
            return wt;
        }

        if(dist[r][c]!=-1 && dist[r][c]<wt){
            continue;
        }

        int[] val1={1,-1,0,0};
        int[] val2={0,0,-1,1};

        for(int i=0;i<4;i++){
            int row=val1[i]+r;
            int col=val2[i]+c;

            if(row>=0 && row<heights.length && col>=0 && col<heights[0].length
            && (dist[row][col]==-1 || dist[row][col] > Math.max(wt,(Math.abs(heights[r][c]-heights[row][col])) ))){

                dist[row][col]=Math.max(wt,Math.abs(heights[r][c]-heights[row][col]) );
                q.add(new Pair(row,col,dist[row][col]));

            }
        }
      }
      return dist[heights.length-1][heights[0].length-1];
    }
}