//custom class to store (node row, node col, cost to come here)
class Triple implements Comparable<Triple>{
    int r;
    int c;
    int wt;

    Triple(int r,int c, int wt){
        this.r=r;
        this.c=c;
        this.wt=wt;
    }

    public int compareTo(Triple that){
        return this.wt-that.wt;
    }
    
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;

        boolean[][] visited=new boolean[m][n];
        PriorityQueue<Triple> q=new PriorityQueue<>();
        q.add(new Triple(0,0,0));

        while(!q.isEmpty()){
            Triple t=q.poll();
            int row=t.r;
            int col=t.c;
            if(row==m-1 && col==n-1){
                return t.wt;
            }
            if(visited[row][col]){continue;}

            visited[row][col]=true;
            int[] rowadd={0,0,1,-1};
            int[] coladd={1,-1,0,0};

            for(int i=0;i<4;i++){
                int currr=row+rowadd[i];
                int currc=col+coladd[i];

                if(currr>=0 && currr<m && currc>=0 && currc<n && !visited[currr][currc]){
                 q.add(new Triple(currr,currc,Math.max(Math.abs(heights[currr][currc] - heights[row][col]),t.wt)));
                }
            }

        }
        return -1;
    }
}