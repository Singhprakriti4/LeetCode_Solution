class Solution {
    //diagonal attack is also considerd
    public int totalNQueens(int n) {
        return nqueens(n,0,new HashSet<>());
    }

    public int nqueens(int n, int r, Set<int[]> set){
        if(r==n){
            return 1;
        }

        //see if we can place the current queen in any of the columns
        int ans=0;

        for(int i=0;i<n;i++){
            
            if(checkdiagonal(set,r,i,n) ){
                //queen can be put here
                // String s=r+":"+i;
                int[] s={r,i};
                set.add(s);
                ans+=nqueens(n,r+1,set);
                set.remove(s);
            }
        }

        return ans;
    }
    public boolean checkdiagonal(Set<int[]> set, int r, int c, int n){
        for(int[] arr: set){
            int row=arr[0];
            int col=arr[1];

            if(col==c) return false;
            int diff=r-row;
            if(c-diff==col || c+diff==col) return false;
        }
        return true;
    }
}