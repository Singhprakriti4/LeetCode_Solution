class Solution {
    public int maximalRectangle(char[][] matrix) {
        //let us run the histogram problem on each row here and the problem is solved

        //get the heights(vertical) of ecah cell
        int[][] height=new int[matrix.length][matrix[0].length];
        
        for(int col=0;col<matrix[0].length;col++){
            Stack<Integer> stk=new Stack<>();
            for(int row=matrix.length-1;row>=0;row--){
                // System.out.println("a");
                if(matrix[row][col]=='1'){
                    stk.push(row);
                    // System.out.println("a");
                }
                else{
                    while(!stk.isEmpty() && matrix[stk.peek()][col]=='1'){
                        // height[stk.pop()][col]=
                        int val=stk.pop();
                        // System.out.println("b");
                        height[val][col]=val-row;
                    }
                }
            }
            while(!stk.isEmpty()){
                int val=stk.pop();
                height[val][col]=val+1;
            }
        }
        // for(int i=0;i<height.length;i++){
        //     for(int col=0;col<height[0].length;col++){
        //         System.out.print(height[i][col]+" ");
        //     }
        //     System.out.println();
        // }
        int ans=0;

        //now go in each row and repeat the larget rectangle in histogram in the heights
        for(int row=0;row<height.length;row++){
          int[] arr=height[row];

          int[] nextsmaller=new int[arr.length];
          Stack<Integer> stk=new Stack<>();
          Arrays.fill(nextsmaller, arr.length);
          for(int i=0;i<arr.length;i++){
            while(!stk.isEmpty() && arr[i]<arr[stk.peek()]){
                nextsmaller[stk.pop()]=i;
            }
            stk.push(i);
          }

          stk=new Stack<>();
          int[] prevsmaller=new int[arr.length];
          Arrays.fill(prevsmaller, -1);
          for(int i=arr.length-1;i>=0;i--){
            while(!stk.isEmpty() && arr[i]<arr[stk.peek()]){
                prevsmaller[stk.pop()]=i;
            }
            stk.push(i);
          }

          for(int i=0;i<arr.length;i++){
            ans=Math.max(ans, (nextsmaller[i]-prevsmaller[i]-1)*arr[i]);
          }
        }

        return ans;
    }
}