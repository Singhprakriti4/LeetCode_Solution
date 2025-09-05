//bfs
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        int ref=image[sr][sc];

        Queue<int[]> q=new LinkedList<>();
        int[] val1={0,0,-1,1};
        int[] val2={1,-1,0,0};

        q.add(new int[]{sr,sc});
        image[sr][sc]=color;

        while(!q.isEmpty()){
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];

            //go in all 4 directions
            for(int i=0;i<4;i++){
                int row=val1[i]+r;
                int col=val2[i]+c;

                if(row>=0 && col>=0 && row<image.length 
                && col<image[0].length && image[row][col]==ref){
                    image[row][col]=color;
                    q.add(new int[]{row,col});
                }
            }
        }

        return image;
    }
}