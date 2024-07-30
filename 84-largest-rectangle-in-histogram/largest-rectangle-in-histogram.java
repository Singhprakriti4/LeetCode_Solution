class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] pre_small=new int[heights.length];
        int[] post_small=new int[heights.length];
        pre_small=psi(heights,pre_small);
        post_small=nsi(heights,post_small);
        int max_area=-1;
        for(int i=0;i<heights.length;i++){
            int area=heights[i]*(post_small[i]-pre_small[i]-1);
            if(area>max_area){
                max_area=area;
            }
        }
        return max_area;
    }
    public int[] psi(int[] heights,int[] ans){
        Stack<Integer> stk=new Stack<>();
        int k=0;
        for(int i=0;i<heights.length;i++){
              while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
                   stk.pop();
              }
              if(stk.isEmpty()){
                ans[k]=-1;
              }
              else{
                ans[k]=stk.peek();
              }
              stk.push(i);
              k++;
        }
        return ans;
    }
    public int[] nsi(int[] heights,int[] ans){
         Stack<Integer> stk=new Stack<>();
         int k=ans.length-1;
        for(int i=heights.length-1;i>=0;i--){
              while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
                   stk.pop();
              }
              if(stk.isEmpty()){
                ans[k]=heights.length;
              }
              else{
                ans[k]=stk.peek();
              }
              stk.push(i);
              k--;
        }
        return ans;
    }
}