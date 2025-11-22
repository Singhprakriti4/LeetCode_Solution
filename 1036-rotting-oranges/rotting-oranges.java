class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

      int totalmin=0;
      int countfresh=0;
      Queue<int[]> q=new LinkedList<>();

      for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==2){
                q.offer(new int[]{i,j});
            }
            if(grid[i][j]==1){
                countfresh+=1;
            }
        }
      }  

      q.offer(new int[]{-1,-1});

      while(!q.isEmpty()){

        int[] arr=q.poll();
        int row=arr[0];
        int col=arr[1];

        if(row!=-1 && col!=-1){
            //go in four directions in search of fresh oranges
            int[] rowptr={-1,+1,0,0};
            int[] colptr={0,0,-1,+1};

            for(int i=0;i<4;i++){
                int r=rowptr[i]+row;
                int c=colptr[i]+col;
                if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1){
                    countfresh-=1;
                    grid[r][c]=2;
                    q.offer(new int[]{r,c});
                }
            }
            
        }
        else{
            totalmin+=1;
            if(!q.isEmpty()){
                q.offer(arr);
            }
        }
      }

      if(countfresh!=0) return -1;

      return totalmin-1;
    }
}