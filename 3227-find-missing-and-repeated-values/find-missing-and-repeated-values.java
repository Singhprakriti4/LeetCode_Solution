class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans=new int[2];

        int n=grid.length;
        int[] test=new int[n*n+1];
        Arrays.fill(test,-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(test[grid[i][j]]==-1){
                   test[grid[i][j]]=0; 
                }
                else{
                    ans[0]=grid[i][j];
                }
            }
        }
        for(int i=1;i<test.length;i++){
            if(test[i]==-1){
                ans[1]=i;
            }
        }
        return ans;
    }
}