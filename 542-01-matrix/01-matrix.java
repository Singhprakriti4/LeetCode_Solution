class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans=new int[mat.length][mat[0].length];
        // boolean[][] visited=new boolean[mat.length][mat[0].length];
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                    q.add(new int[] {i,j});
                    // visited[i][j]=true;
                }
                else{
                    ans[i][j]=Integer.MAX_VALUE;
                }
            }
        }
       
       int[] rowdiff={-1,1,0,0};
       int[] coldiff={0,0,-1,1};

       while(!q.isEmpty()){
        int[] arr=q.poll();
        int r=arr[0];
        int c=arr[1];

        for(int i=0;i<4;i++){
            int rownum=r+rowdiff[i];
            int colnum=c+coldiff[i];

            if(rownum>=0 && rownum<mat.length && colnum>=0 &&
            colnum<mat[0].length && ans[rownum][colnum]>ans[r][c]+1){
                // visited[rownum][colnum]=true;
                q.add(new int[]{rownum,colnum});
                ans[rownum][colnum]=ans[r][c]+1;
            }
        }

     }
     return ans;

    }
}