class Solution {
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       boolean[][] pacific=new boolean[heights.length][heights[0].length]; 
       boolean[][] atlantic=new boolean[heights.length][heights[0].length]; 
       boolean[][] ans=new boolean[heights.length][heights[0].length];
       for(int i=0;i<heights.length;i++){
        for(int j=0;j<heights[0].length;j++){
            if(i==0 || j==0){
                pacific[i][j]=true;
            }
            if(i==heights.length-1 || j==heights[0].length-1){
                atlantic[i][j]=true;
            }
            // System.out.print(pacific[i][j]+" ");
        }
        // System.out.println();
       }
    //    boolean[][] notans=new boolean[heights.length][heights[0].length];


       for(int i=0;i<heights.length;i++){
        for(int j=0;j<heights[0].length;j++){
            // System.out.println(i+" "+j+" ");
        bfs(pacific,atlantic,ans,i,j,heights);
        }
       }
       
       List<List<Integer>> outer=new ArrayList<>();
       for(int i=0;i<ans.length;i++){
        for(int j=0;j<ans[0].length;j++){
            // System.out.print(ans[i][j]+" ");
            if(ans[i][j]){
                List<Integer> inner=new ArrayList<>();
                inner.add(i);
                inner.add(j);
                outer.add(inner);
            }
        }
        // System.out.println();
       }
       return outer;
    }
    public void bfs(boolean[][] p, boolean[][] a, boolean[][] ans,
     int i, int j,int[][] heights){

        if(ans[i][j]==true ) return;

        if(p[i][j] && a[i][j]){
            ans[i][j]=true;
            return;
        }

        boolean pac=false;
        boolean atl=false;

        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[heights.length][heights[0].length];
        q.add(new int[]{i,j});
        visited[i][j]=true;
        if(p[i][j]) pac=true;
        if(a[i][j]) atl=true;

        while(!q.isEmpty()){
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];

            int[] nr={0,0,-1,1};
            int[] nc={-1,1,0,0};

            for(int k=0;k<4;k++){
                int row=r+nr[k];
                int col=c+nc[k];

                if(row>=0 && col>=0 && row<heights.length &&
                col<heights[0].length && !visited[row][col]
                && heights[row][col]<=heights[r][c]){

                    if((p[row][col] && a[row][col]) || ans[row][col]
                    || (pac && atl)){
                        // System.out.println("hqy");
                        ans[i][j]=true;
                        return;
                    }
                    else {
                        if(p[row][col]) pac=true;
                        if(a[row][col]) atl=true;
                        visited[row][col]=true;
                        q.add(new int[]{row,col});
                    }
                }
            }
        }
        if(pac && atl){
                ans[i][j]=true;
                return;
            }
        return;
    }
}