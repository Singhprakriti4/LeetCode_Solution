class Solution {
    public int heightChecker(int[] heights) {
        //int[] expected=Arrays.copyOf(heights,heights.length);

        int[] expected=new int[heights.length];
        
         for(int i=0;i<heights.length;i++){
         expected[i]=heights[i];
         }
        Arrays.sort(expected);
        int ans=0;
        for(int i=0;i<heights.length;i++){
           if(heights[i]!=expected[i]){
            ans++;
           }
        }
        return ans;
    }
}