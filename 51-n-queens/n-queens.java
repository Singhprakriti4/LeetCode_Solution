class Solution {
    List<List<String>> outer=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] usedcols=new int[n];
        int[] leftdiag=new int[2*n];
        int[] rightdiag=new int[2*n];

        solve(n,0,new ArrayList<>(),usedcols, leftdiag,rightdiag);
        return outer;
    }
    public void solve(int n, int r, List<String> inner,
    int[] usedcols, int[] leftdiag, int[] rightdiag){
        if(r==n){
            outer.add(new ArrayList<>(inner));
            return;
        }

        for(int i=0;i<n;i++){
            int c=i;
            if(usedcols[i]==0 && leftdiag[c-r+n-1]==0 &&
            rightdiag[c+r]==0){
                usedcols[i]=1;
                leftdiag[c-r+n-1]=1;
                rightdiag[c+r]=1;
                //i-1times . 1time q . n-i-1 times .
                StringBuilder sb=new StringBuilder();
                int pre=i;
                while(pre>0){
                    sb.append('.');
                    pre-=1;
                }
                sb.append('Q');
                int post=n-i-1;
                while(post>0){
                    sb.append('.');
                    post-=1;
                }
                String str=sb.toString();
                inner.add(str);
                solve(n,r+1,inner,usedcols, leftdiag,rightdiag);
                inner.remove(str);
                usedcols[i]=0;
                leftdiag[c-r+n-1]=0;
                rightdiag[c+r]=0;
            }
        }
        return;
    }
}