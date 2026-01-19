class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int[][] presum=new int[mat.length][mat[0].length];

        for(int i=0;i<mat.length;i++){
            presum[i][0]=mat[i][0];
            for(int j=1;j<mat[0].length;j++){
                presum[i][j]=mat[i][j]+presum[i][j-1];
            }
        }

        for(int i=1;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                presum[i][j]+=presum[i-1][j];
            }
        }

        int s=1;
        int e=Math.min(mat.length, mat[0].length);
        int ans=0;
        while(s<=e){
            int m=s+(e-s)/2;
            int val=find(presum,threshold,m);
            if(val==-1){
                //couldnot find
                e=m-1;
            }
            else{
                ans=Math.max(ans, val);
                s=m+1;//in finding the largest square
            }
        }
        return ans;
    }
    public int find(int[][] presum, int target, int len){
        int ans=-1;
        for(int i=len-1;i<presum.length;i++){
            for(int j=len-1;j<presum[0].length;j++){
                int sum=presum[i][j];
                if(i-len>=0){
                    sum-=presum[i-len][j];
                }
                if(j-len>=0){
                    sum-=presum[i][j-len];
                }
                if(i-len>=0 && j-len>=0){
                    sum+=presum[i-len][j-len];
                }
                if(sum<=target){
                    ans=Math.max(ans, len);
                }
            }
        }
        return ans;
    }
}