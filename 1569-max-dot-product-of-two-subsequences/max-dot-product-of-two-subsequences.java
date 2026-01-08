class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length][nums2.length];
        int k=Integer.MIN_VALUE;    

       for(int row=nums1.length-1;row>=0;row--){
            int col=nums2.length-1;
            if(row==nums1.length-1){
                dp[row][col]=nums1[row]*nums2[col];
                k=Math.max(k, dp[row][col]);
            
            }
            else{
                dp[row][col]=Math.max(dp[row+1][col], 
                nums1[row]*nums2[col]);
                k=Math.max(k, dp[row][col]);
            }
        }
        for(int col=nums2.length-2;col>=0;col--){
            int row=nums1.length-1;
            dp[row][col]=Math.max(dp[row][col+1], nums1[row]*nums2[col]);
            k=Math.max(k, dp[row][col]);
        }


        for(int r=nums1.length-2;r>=0;r--){
            for(int c=nums2.length-2;c>=0;c--){
                dp[r][c]=Math.max(dp[r+1][c+1],
                Math.max(nums1[r]*nums2[c],
                Math.max(nums1[r]*nums2[c]+dp[r+1][c+1],Math.max(dp[r+1][c],dp[r][c+1]))));
                k=Math.max(k, dp[r][c]);
            }
        }
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return k;
    }
}