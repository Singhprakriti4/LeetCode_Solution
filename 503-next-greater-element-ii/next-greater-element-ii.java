class Solution {
    public int[] nextGreaterElements(int[] nums) {
       Stack<Integer> stk=new Stack<>();
       Map<Integer,Integer> map=new HashMap<>();

       for(int i=0;i<nums.length;i++){
        while(!stk.isEmpty() && nums[i]>nums[stk.peek()]){
            map.put(stk.pop(),nums[i]);
        }
        stk.push(i);
       } 

       for(int i=0;i<nums.length;i++){
        while(!stk.isEmpty() && nums[i]>nums[stk.peek()]){
            // if(!map.containsKey())
            map.put(stk.pop(),nums[i]);
        }
        stk.push(i);
       }

       int[] ans=new int[nums.length];
       for(int i=0;i<nums.length;i++){
        ans[i]=map.getOrDefault(i,-1);
       }

       return ans;
    }
}