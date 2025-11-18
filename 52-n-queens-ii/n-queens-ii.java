class Solution {
    //diagonal attack is also considerd
    public int totalNQueens(int n) {
        return nqueens(n,0,new HashSet<>());
    }

    public int nqueens(int n, int r, Set<String> set){
        if(r==n){
            return 1;
        }

        //see if we can place the current queen in any of the columns
        int ans=0;

        for(int i=0;i<n;i++){
            
            if(checkdiagonal(set,r,i,n) ){
                //queen can be put here
                String s=r+":"+i;
                set.add(s);
                ans+=nqueens(n,r+1,set);
                set.remove(s);
            }
        }

        return ans;
    }
    public boolean checkdiagonal(Set<String> set, int r, int c, int n){
        // int testr=r;
        // int testc=c;

        // while(testr>=0 && testc<n){
        //     if(set.contains(testr+":"+testc)){
        //         return false;
        //     }
        //     testr-=1;
        //     testc+=1;
        // }

        // testr=r;
        // testc=c;
        // while(testr>=0 && testc>=0){
        //     if(set.contains(testr+":"+testc)) return false;
        //     testr-=1;
        //     testc-=1;
        // }

        // testr=r;
        // testc=c;
        // while(r>=0){
        //     if(set.contains(testr+":"+testc)) return false;
        //     testr--;
        // }

        // return true;
        for(String str: set){
            String[] arr=str.split(":");
            int row=Integer.parseInt(arr[0]);
            int col=Integer.parseInt(arr[1]);

            if(col==c) return false;
            int diff=r-row;
            if(c-diff==col || c+diff==col) return false;
        }
        return true;
    }
}