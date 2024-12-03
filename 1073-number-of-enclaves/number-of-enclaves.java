class Solution {
    public int numEnclaves(int[][] grid) {

        int ans=0;
        Queue<int[]> q=new LinkedList<>();
        
        for(int i=0;i<grid.length;i++){
         if(grid[i][0]==1){
            grid[i][0]=0;
            q.add(new int[]{i,0});
         }
         if(grid[i][grid[0].length-1]==1){
            q.add(new int[]{i,grid[0].length-1});
            grid[i][grid[0].length-1]=0;
         }
        }
        for(int i=0;i<grid[0].length;i++){
          if(grid[0][i]==1){
            grid[0][i]=0;
            q.add(new int[]{0,i});
          }   
          if(grid[grid.length-1][i]==1){
            grid[grid.length-1][i]=0;
            q.add(new int[]{grid.length-1,i});
          }
        }

        int[] rowdiff={0,0,-1,1};
        int[] coldiff={-1,1,0,0};

       while(!q.isEmpty()){
        int[] arr=q.poll();
        int r=arr[0];
        int c=arr[1];

        for(int i=0;i<4;i++){
            int row=r+rowdiff[i];
            int col=c+coldiff[i];

            if(row>=0 && row<grid.length && col>=0 && col<grid[0].length 
             && grid[row][col]==1){
                grid[row][col]=0;
                q.add(new int[] {row,col});
             }
        }

       }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }
}