class Solution {
    public int largestRectangleArea(int[] heights) {
        //har block bina apneaap ko bina shrink kre kitna extend kr skta hai
        //we will get each height ke according answer

        //next smaller aur previous smaller ki indexes mil jaye toh job done
        int[] nextsmaller=new int[heights.length];
        Arrays.fill(nextsmaller, heights.length);//for those who donot have a next smaller(the tallest one and last one)
        
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!stk.isEmpty() && heights[i]<heights[stk.peek()]){
                nextsmaller[stk.pop()]=i;
            }
            stk.push(i);
        }

        stk=new Stack<>();
        int[] prevsmaller=new int[heights.length];
        Arrays.fill(prevsmaller, -1);//for the ones with no prev smaller(eg: the first elemnt and the tallest one)

        for(int i=heights.length-1;i>=0;i--){
            while(!stk.isEmpty() && heights[i]<heights[stk.peek()]){
                prevsmaller[stk.pop()]=i;
            }
            stk.push(i);
        }
       
       int maxarea=0;
       for(int i=0;i<heights.length;i++){
        int width=nextsmaller[i]-prevsmaller[i]-1;
        int height=heights[i];
        int localarea=width*height;
        maxarea=Math.max(maxarea, localarea);
       }
      return maxarea;
    }
}