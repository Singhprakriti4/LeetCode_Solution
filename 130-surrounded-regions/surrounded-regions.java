class Solution {
    public void solve(char[][] board) {
       boolean[][] visited=new boolean[board.length][board[0].length];

       int row=0;
       for(int i=0;i<board[0].length;i++){
        if(board[row][i]=='O'){
            dfs(board,visited,row,i);
        }
       }

       if(board.length>1){
        row=board.length-1;
        for(int i=0;i<board[0].length;i++){
        if(board[row][i]=='O'){
            dfs(board,visited,row,i);
        }
       }
       }

       int col=0;
       for(int i=0;i<board.length;i++){
         if(board[i][col]=='O'){
            dfs(board,visited,i,col);
        }
       }

       if(board[0].length>1){
        col=board[0].length-1;
        for(int i=0;i<board.length;i++){
         if(board[i][col]=='O'){
            dfs(board,visited,i,col);
        }
       }
       }

     for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            if(visited[i][j]==false){
                board[i][j]='X';
            }
        }
     }
       
    }

    public void dfs(char[][] board, boolean[][] visited, int r, int c){
        visited[r][c]=true;

        int[] val1={0,0,-1,1};
        int[] val2={-1,1,0,0};

        for(int i=0;i<4;i++){
            int row=r+val1[i];
            int col=c+val2[i];

            if(row>=0 && col>=0 && row<board.length && col<board[0].length
            && !visited[row][col] && board[row][col]=='O'){
                dfs(board, visited, row, col);
            }
        }
    }
}