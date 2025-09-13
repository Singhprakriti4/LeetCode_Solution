class Solution {
    //recursion
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ans=-1;
        Queue<int[]> q=new LinkedList<>();
        if(grid[0][0]!=0) return -1;

        q.add(new int[]{0,0,1});
        grid[0][0]=-1;

        while(!q.isEmpty()){
            int[] arr=q.poll();
            int row=arr[0];
            int col=arr[1];
            int dist=arr[2];
            if(row==grid.length-1 && col==grid[0].length-1){
                return dist;
            }

            //move in 8 directions
            int[] val1={-1,-1,-1,1,1,1,0,0};
            int val2[]={-1,0,1,-1,0,1,-1,1};

            for(int i=0;i<8;i++){
                int r=row+val1[i];
                int c=col+val2[i];

                if(r>=0 && c>=0 && r<grid.length && c<grid[0].length
                && grid[r][c]==0){
                    q.add(new int[]{r,c,dist+1});
                    grid[r][c]=-1;
                }
            }
        }
        return -1;
    }
}