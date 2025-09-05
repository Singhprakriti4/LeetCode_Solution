// multisource bfs
class Solution {
    public int orangesRotting(int[][] grid) {
        int result=bfs(grid);

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        return result;
    }

    public int bfs(int[][] grid){
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    //rotten
                    q.add(new int[]{i,j});
                }
            }
        }

        q.add(new int[]{-1,-1});
        int ans=0;

        //check for edge cases, ans+=1 on null, viisted mark kr dena
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];

            if(r==-1 && c==-1){
                
                if(!q.isEmpty()){
                    ans+=1;
                    q.add(new int[]{-1,-1});
                }
            }
            else{
                //go in 4 valid directions+ check for ==1 condition
                int[] val1={0,0,1,-1};
                int[] val2={1,-1,0,0};

                for(int i=0;i<4;i++){
                    int row=val1[i]+r;
                    int col=val2[i]+c;

                    if(row>=0 && col>=0 && row<grid.length && col<grid[0].length){
                        if(grid[row][col]==1){
                            grid[row][col]=2;
                            q.add(new int[]{row, col});
                        }
                    }
                }
            }

        }
        return ans;
    }
}