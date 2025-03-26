class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] arr=new int[grid.length*grid[0].length];
        int k=-1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0){
                    arr[++k]=grid[i][j];
                }
                else{
                    //check if they are multiple of a
                    arr[++k]=grid[i][j];
                    System.out.println(arr[k]);
                    System.out.println(arr[k-1]);
                    if(Math.abs(arr[k]-arr[k-1])%x!=0){
                        return -1;
                    }
                    
                }
            }
        }

        Arrays.sort(arr);
        int mid=arr.length/2;
        int ans=0;

        int num=arr[mid];
        for(int i=0;i<arr.length;i++){
            ans+=Math.abs(arr[i]-num)/x;
        }

        return ans;
    }
}