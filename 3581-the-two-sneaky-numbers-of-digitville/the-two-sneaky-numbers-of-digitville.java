class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res=new int[2];
        int ptr=0;

        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                res[ptr]=nums[i];
                ptr+=1;
            }
            set.add(nums[i]);
        }

        return res;
    }
}