class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] visited=new boolean[heights.length][heights[0].length];
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<heights.length;i++){
            q.add(new int[]{i,0});
            visited[i][0]=true;
        }
        for(int j=1;j<heights[0].length;j++){
            q.add(new int[]{0,j});
            visited[0][j]=true;
        }
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];
            int[] nr={0,0,-1,1};
            int[] nc={1,-1,0,0};
            for(int i=0;i<4;i++){
                int row=nr[i]+r;
                int col=nc[i]+c;
                if(row>=0 && row<heights.length && 
                col>=0 && col<heights[0].length && heights[row][col]>=heights[r][c]
                && !visited[row][col]){
                    visited[row][col]=true;
                    q.add(new int[]{row,col});
                }
            }
        }

        q=new LinkedList<>();
        boolean[][] visited2=new boolean[heights.length][heights[0].length];
        List<List<Integer>> outer=new ArrayList<>();

        for(int i=0;i<heights.length;i++){
            q.add(new int[]{i,heights[0].length-1});
            visited2[i][heights[0].length-1]=true;
            // if(visited[i][heights[0].length-1]){
            //     List<Integer> inner=new ArrayList<>();
            //     inner.add(i);
            //     inner.add(heights[0].length-1);
            //     outer.add(inner);
            // }
        }
        for(int i=heights[0].length-2;i>=0;i--){
            q.add(new int[]{heights.length-1, i});
            visited2[heights.length-1][i]=true;
            // if(visited[heights.length-1][i]){
            //     List<Integer> inner=new ArrayList<>();
            //     inner.add(heights.length-1);
            //     inner.add(i);
            //     outer.add(inner);
            // }
        }
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];
            if(visited[r][c]){
                List<Integer> inner=new ArrayList<>();
                inner.add(r);
                inner.add(c);
                outer.add(inner);
            }
            int[] nr={0,0,-1,1};
            int[] nc={1,-1,0,0};
            for(int i=0;i<4;i++){
                int row=nr[i]+r;
                int col=nc[i]+c;
                if(row>=0 && row<heights.length && 
                col>=0 && col<heights[0].length && heights[row][col]>=heights[r][c]
                && !visited2[row][col]){
                    visited2[row][col]=true;
                    q.add(new int[]{row,col});
                }
            }
        }
        return outer;
    }
}