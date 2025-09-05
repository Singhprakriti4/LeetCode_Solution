//dfs
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc]==color){
            return image;
        }
        dfs(image, sr, sc, color, image[sr][sc]);

        return image;

    }
    public void dfs(int[][] image, int sr, int sc, int color, int ref){
        image[sr][sc]=color;
        int[] val1={0,0,-1,1};
        int[] val2={1,-1,0,0};

        for(int i=0;i<4;i++){
            int row=sr+val1[i];
            int col=sc+val2[i];

            if(row>=0 && col>=0 && row<image.length && col<image[0].length
            && image[row][col]==ref){
                dfs(image, row, col, color, ref);
            }
        }
    }
}