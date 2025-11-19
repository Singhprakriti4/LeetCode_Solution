class Solution {
    public int[][] generateMatrix(int n) {
       int[][] matrix=new int[n][n]; 
       right(0,n,0,n,matrix,1);
       return matrix;
    }
     public void right(int startr,int endr, int startc, int endc,
     int[][] matrix, int num){
        //in startr across columns
        if(startr>=endr || startc>=endc){
            return;
        }
        int r=startr;
        int c=startc;
        while(c<endc){
            matrix[r][c]=num;
            num+=1;
            c++;
        }
        down(startr+1,endr,startc,endc,matrix,num);
    }
    public void down(int startr, int endr, int startc, int endc,
    int[][] matrix, int num){
        if(startr>=endr || startc>=endc){
            return;
        }
        int r=startr;
        int c=endc-1;
        while(r<endr){
            matrix[r][c]=num;
            num+=1;
            r++;
        }
        left(startr,endr,startc,endc-1,matrix,num);
    }
    public void left(int startr, int endr, int startc, int endc,
    int[][] matrix, int num){
        if(startr>=endr || startc>=endc){
            return;
        }
        int r=endr-1;
        int c=endc-1;
        while(c>=startc){
            matrix[r][c]=num;
            num+=1;
            c--;
        }
        up(startr, endr-1, startc, endc,matrix, num);
    }
    public void up(int startr, int endr, int startc, int endc,
    int[][] matrix, int num){
        if(startr>=endr || startc>=endc){
            return;
        }
        int r=endr-1;
        int c=startc;
        while(r>=startr){
            matrix[r][c]=num;
            num+=1;
            r--;
        }
        right(startr, endr, startc+1, endc, matrix, num);
    }

}