class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i=0;i<board.length;i++){
            for( int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean result=word(board,word,i,j,0);
                    if(result){
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
    public boolean word(char[][] board,String word,int r,int c,int ptr){


       if((board[r][c])!=(word.charAt(ptr))){
        return false;
       }

       if(ptr==word.length()-1 && board[r][c]==word.charAt(ptr) ){
        return true;}

       char e=board[r][c];
       board[r][c]='*';
       if(r!=board.length-1){
       if(word(board,word,r+1,c,ptr+1))
        return true;
       }
       if(c!=board[0].length-1){
      if( word(board,word,r,c+1,ptr+1))
      return true;}
       if(r!=0){
       if(word(board,word,r-1,c,ptr+1))
       return true;}
       if(c!=0){
       if(word(board,word,r,c-1,ptr+1))
       return true;}
       board[r][c]=e;
       return false;
    }
}
      
    

