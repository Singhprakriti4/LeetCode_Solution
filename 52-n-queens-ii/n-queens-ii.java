class Solution {
    //diagonal attack is also considerd
    public int totalNQueens(int n) {

        return nqueens(n,0,new HashSet<>(),new HashSet<>(),new HashSet<>());
    }

    public int nqueens(int n, int r, Set<Integer> toplevelleft,
    Set<Integer> toplevelright, Set<Integer> cols){
        if(r==n){
            return 1;
        }
        //see if we can place the current queen in any of the columns
        int ans=0;

        for(int i=0;i<n;i++){

            int top1=i-r;
            int top2=i+r;

            if(!toplevelleft.contains(top1) && !toplevelright.contains(top2)
            && !cols.contains(i)){

                //queen can be put here
                toplevelleft.add(top1);
                toplevelright.add(top2);
                cols.add(i);
                ans+=nqueens(n,r+1,toplevelleft,toplevelright,cols);
                toplevelleft.remove(top1);
                toplevelright.remove(top2);
                cols.remove(i);
            }
        }

        return ans;
    }
}