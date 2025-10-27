class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length];
        
        //i need a way to store the next greater elemnt of all th
        //elrmrnts in arr2 in one oteration

        Stack<Integer> stk=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums2.length;i++){
            if(stk.isEmpty()){
                stk.push(i);
            }
            else if(nums2[i]<nums2[stk.peek()]){
                stk.push(i);
            }
            else{
            
                while(!stk.isEmpty() && nums2[i]>nums2[stk.peek()]){
                    //since numbers are unique there fore no '=' case will apper
                    //and there will not be overwritten value for any key
                    map.put(nums2[stk.pop()],nums2[i]);
                }
                stk.push(i);
            }
        }
        while(!stk.isEmpty()){
            map.put(nums2[stk.pop()],-1);
        }

        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }

        return ans;
    }
}