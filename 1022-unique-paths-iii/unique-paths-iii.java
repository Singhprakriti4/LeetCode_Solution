class Solution {
    public int uniquePathsIII(int[][] grid) {
        int srow=0;
        int scol=0;
        int obstacles=0;
        
        //finding starting point
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    srow=i;
                    scol=j;
                    // break;
                    
                }
                if(grid[i][j]==-1){
                        obstacles++;
                    }
            }
            
        }
        int cover[]=new int[1];
        //kitte blocks cover hone chahiye
        cover[0]=(grid.length*grid[0].length)-obstacles-1;
        int num=0;

        // System.out.println(srow);
        // System.out.println(scol);
        int[] ans={0};
        paths(grid,srow,scol,ans,0,cover[0]);
        return ans[0];
     
    }
  public void paths(int[][] grid,int row, int col,int[] ans,int n,int cover){
   if(row>=grid.length || col>=grid[0].length || row<0 || col<0 ){
    return;
   }
   else if(grid[row][col]==-1){
    return;
   }
   else if(grid[row][col]==2 && n==cover){
    ans[0]+=1;
    return;
   }
   else if(grid[row][col]==2){
    return;
   }
   int num=grid[row][col];
   grid[row][col]=-1;
   int[] r={0,0,-1,1};
   int[] c ={1,-1,0,0};
   for(int i=0;i<4;i++){
    int ro=row+r[i];
    int co=col+c[i];

        if(ro>=0 && ro<grid.length && co>=0 && co<grid[0].length){
        paths(grid,ro,co,ans,n+1,cover);
        }
   }

        grid[row][col]=num;
   
  }
}