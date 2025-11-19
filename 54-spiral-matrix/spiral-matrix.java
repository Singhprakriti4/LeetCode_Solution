class Solution {
    List<Integer> ans=new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        right(0,matrix.length,0,matrix[0].length,matrix);
        return ans;

    }
    public void right(int startr,int endr, int startc, int endc,int[][] matrix){
        //in startr across columns
        if(startr>=endr || startc>=endc){
            return;
        }
        int r=startr;
        int c=startc;
        while(c<endc){
            ans.add(matrix[startr][c]);
            c++;
        }
        down(startr+1,endr,startc,endc,matrix);
    }
    public void down(int startr, int endr, int startc, int endc,int[][] matrix){
        if(startr>=endr || startc>=endc){
            return;
        }
        int r=startr;
        int c=endc-1;
        while(r<endr){
            ans.add(matrix[r][c]);
            r++;
        }
        left(startr,endr,startc,endc-1,matrix);
    }
    public void left(int startr, int endr, int startc, int endc,int[][] matrix){
        if(startr>=endr || startc>=endc){
            return;
        }
        int r=endr-1;
        int c=endc-1;
        while(c>=startc){
            ans.add(matrix[r][c]);
            c--;
        }
        up(startr, endr-1, startc, endc,matrix);
    }
    public void up(int startr, int endr, int startc, int endc,int[][] matrix){
        if(startr>=endr || startc>=endc){
            return;
        }
        int r=endr-1;
        int c=startc;
        while(r>=startr){
            ans.add(matrix[r][c]);
            r--;
        }
        right(startr, endr, startc+1, endc,matrix);
    }
}