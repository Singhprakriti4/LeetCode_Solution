class Solution {
    public void solve(char[][] board) {

        boolean[][] tobechanged=new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O' && !tobechanged[i][0]){
            dfs(i,0,board,tobechanged);}

            if(board[i][board[0].length-1]=='O' && !tobechanged[i][board[0].length-1]){
            dfs(i,board[0].length-1,board,tobechanged);}
        }
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O' && !tobechanged[0][i]){
            dfs(0,i,board,tobechanged);}

            if(board[board.length-1][i]=='O' && !tobechanged[board.length-1][i]){
            dfs(board.length-1,i,board,tobechanged);}
        }
     

     for(int i=0;i<board.length ;i++){
        for(int j=0;j<board[i].length;j++){
            if(board[i][j]=='O' && tobechanged[i][j]==false){
                board[i][j]='X';
            }
        }
     }

    }
    public void dfs(int row,int col,char[][] board , boolean[][] tobechanged){  
      
        tobechanged[row][col]=true;

        int[] rowdiff={0,0,-1,1};
        int[] coldiff={-1,1,0,0};

        for(int i=0;i<4;i++){
            int r=row+rowdiff[i];
            int c=col+coldiff[i];

            if(r>=0 && r<board.length && c>=0 && c<board[0].length 
            && board[r][c]=='O' && !tobechanged[r][c]){
                dfs(r,c,board,tobechanged);
            }
        }
    }
}