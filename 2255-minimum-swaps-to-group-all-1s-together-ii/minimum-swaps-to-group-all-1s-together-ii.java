class Solution {
    public int minSwaps(int[] nums) {
        //toatl 1's

        int total=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                total++;
            }
        }
        if(total==nums.length){
            return 0;
        }

        //new array
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            arr.add(nums[i]);
        }
        for(int i=0;i<total;i++){
            arr.add(nums[i]);
        }
        //making the window of size total
        int ans=Integer.MAX_VALUE;
        int start=0;
        int end=0;
        int count_0=0;
        while(end-start!=total){
          if(arr.get(end)==0){
            count_0++;
          }
          end++;
        }
        if(count_0<ans){
            ans=count_0;
        }
        //sliding of the window
        while(end!=arr.size()){
            if(arr.get(end)==0){
                count_0++;
            }
            if(arr.get(start)==0){
                count_0--;
            }
             if(count_0<ans){
            ans=count_0;
        }
            end++;
            start++;
        }
       return ans; 
    }
}