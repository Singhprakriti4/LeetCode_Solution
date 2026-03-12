class Solution {
    boolean stop=false;
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    public void solve(char[][] board, int row, int col){

        if(row==board.length){
            stop=true;
            return;
        }
        if(stop) return;
        if(board[row][col]!='.'){
            if(col==board[0].length-1){
                solve(board, row+1, 0);
            }
            else{
                solve(board, row, col+1);
            }
            return;
        }

        for(int i=1;i<=9;i++){
            if(possible(i, board, row, col)){
                board[row][col]=(char)(i+'0');
                if(col==8){
                    solve(board, row+1, 0);
                }
                else{
                    solve(board, row, col+1);
                }
                if(stop) return;
                board[row][col]='.';
            }
        }
        
    }
    public boolean possible(int digit, char[][] arr, int row, int col){
        for(int i=0;i<9;i++){
            if(arr[row][i]-'0'==digit || arr[i][col]-'0'==digit){
                return false;
            }
        }
        int c=0;
        if(col>2 && col<6){
            c=3;
        }
        if(col>5)c=6;

        int r=0;
        if(row>2 && row<6){
            r=3;
        }
        if(row>5){
            r=6;
        }
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(arr[i][j]-'0'==digit) return false;
            }
        }
        return true;
    }

}