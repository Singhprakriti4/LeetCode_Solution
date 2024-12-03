class Solution {
    public void solve(char[][] board) {

        boolean[][] tobechanged=new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O' && !tobechanged[i][0]){
            boolean[][] visited1=new boolean[board.length][board[0].length];
            dfs(i,0,visited1,board,tobechanged);}

            if(board[i][board[0].length-1]=='O' && !tobechanged[i][board[0].length-1]){
             boolean[][] visited2=new boolean[board.length][board[0].length];
            dfs(i,board[0].length-1,visited2,board,tobechanged);}
        }
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O' && !tobechanged[0][i]){
             boolean[][] visited3=new boolean[board.length][board[0].length];
            dfs(0,i,visited3,board,tobechanged);}

            if(board[board.length-1][i]=='O' && !tobechanged[board.length-1][i]){
             boolean[][] visited4=new boolean[board.length][board[0].length];
            dfs(board.length-1,i,visited4,board,tobechanged);}
        }
     

     for(int i=0;i<board.length ;i++){
        for(int j=0;j<board[i].length;j++){
            if(board[i][j]=='O' && tobechanged[i][j]==false){
                board[i][j]='X';
            }
        }
     }

    }
    public void dfs(int row,int col, boolean[][] visited, char[][] board
    , boolean[][] tobechanged){
        // if(board[row][col]=='X'){
        //     return;
        // }
        visited[row][col]=true;
        tobechanged[row][col]=true;

        int[] rowdiff={0,0,-1,1};
        int[] coldiff={-1,1,0,0};

        for(int i=0;i<4;i++){
            int r=row+rowdiff[i];
            int c=col+coldiff[i];

            if(r>=0 && r<board.length && c>=0 && c<board[0].length 
            && board[r][c]=='O' && !visited[r][c]){
                dfs(r,c,visited,board,tobechanged);
            }
        }
    }
}