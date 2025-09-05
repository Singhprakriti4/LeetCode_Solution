/*
1) why bfs?
2) why multi source bfs the otherway?
3) why did i not start the visited dist with 0 ?
*/
class Solution {

    //multi source bfs.
    //ripple effect . the closest 1. the zero closest to nay one will get the dist
    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> q=new LinkedList<>();
        int[][] result=new int[mat.length][mat[0].length];
        //for visit tracking + distance storing
        int[][] visited=new int[mat.length][mat[0].length];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                result[i][j]=mat[i][j];
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                    visited[i][j]=1;
                }
            }
        }

       
       
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];

            int[] val1={0,0,1,-1};
            int[] val2={1,-1,0,0};

            for(int i=0;i<4;i++){
                int row=r+val1[i];
                int col=c+val2[i];

                if(row>=0 && col>=0 && row<mat.length && col<mat[0].length
                && visited[row][col]==0){
                    visited[row][col]=visited[r][c]+1;
                    q.add(new int[]{row,col});
                    if(mat[row][col]==1){
                        result[row][col]=visited[row][col]-1;
                    }
                }
            }
        }

        return result;
    }
}