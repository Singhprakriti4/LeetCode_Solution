class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
       //ArrayList<Integer> exclude=new ArrayList<>(); 
        // int max=0;
        // while(k!=0){           
        //      max=Integer.MIN_VALUE;
        //     int max_index=Integer.MIN_VALUE;

        //     for(int i=0;i<nums.length;i++){
        //         if(exclude.contains(i)){
        //             continue;
        //         }
        //         else if(nums[i]>max){
        //             max_index=i;
        //           max=nums[i];
        //         }
        //     }
        //     exclude.add(max_index);
        //     k--;
        // }
        // return max;
    }
}