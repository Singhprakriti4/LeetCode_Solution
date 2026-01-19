class Solution {
    boolean stop;
    public void solveSudoku(char[][] board) {
        // res=new char[board.length][board[0].length];
        stop=false;
        boolean[][] fixed=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
                if(board[i][j]!='.'){
                    fixed[i][j]=true;
                }

            }
        }

        solve(board, fixed, 0, 0);
      
    }
    public void solve(char[][] board,boolean[][] fixed,int r,int c){
        //base case
        if(r<0 || r>=board.length ||c<0 ||c >=board[0].length){
            return;
        }
        if(r==board.length-1 && c==board[0].length-1){
            if(fixed[r][c]){
                // res=board.clone();
                stop=true;
                return;
            }
            else{
                //try all options
                for(int i=1;i<=9;i++){
                    if(valid(board,r,c,(char)('0'+i))){
                        board[r][c]=(char)('0'+i);
                        // res=board.clone();
                        stop=true;
                        if(stop) return;
                        board[r][c]='.';
                        return;
                    }
                }
            }
            return;
        }

        //if current r,c is fixed
        if(fixed[r][c]){
            if(c<board[0].length-1){
                solve(board, fixed, r, c+1);
            }
            else{
                solve(board, fixed, r+1, 0);
            }
            if(stop) return;
        }
        else{
            //try out all the possibilities
            for(int i=1;i<=9;i++){
                if(valid(board,r,c,(char)('0'+i))){
                        board[r][c]=(char)('0'+i);
                        if(c<board[0].length-1){
                           solve(board, fixed, r, c+1);
                        }
                        else{
                        solve(board, fixed, r+1, 0);
                        }
                        if(stop) return;
                        board[r][c]='.';
                }
                
            }
        }
    }
    public boolean valid(char[][] board,int r, int c, char ch){
        //horizontally, vertically, same block
        for(int j=0;j<9;j++){
            //if we get char already existing then return false
            if(board[r][j]==ch || board[j][c]==ch){
                return false;
            }
        }
        //same block
        //calculate the starting point
        int row=0;
        int col=0;

        if(r>=0 && r<=2) row=0;
        if(r>=3 && r<=5) row=3;
        if(r>=6 && r<=8) row=6;

        if(c>=0 && c<=2) col=0;
        if(c>=3 && c<=5) col=3;
        if(c>=6 && c<=8) col=6;

        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(board[i][j]==ch) return false;
            }
        }
        return true;
    }
}