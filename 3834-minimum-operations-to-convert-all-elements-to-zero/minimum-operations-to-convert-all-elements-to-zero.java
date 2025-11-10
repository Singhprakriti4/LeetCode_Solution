// class Solution {
//     public int minOperations(int[] nums) {
//        Stack<Integer> stk=new Stack<>();
//        int ans=0;
//        for(int i=0;i<nums.length;i++){

//         if(nums[i]==0) continue;
//         while(!stk.isEmpty() && nums[i]<nums[stk.peek()]){
//                 stk.pop();
//         }
//         if(stk.isEmpty() || nums[i]>nums[stk.peek()]){
//             ans+=1;
//             stk.push(i);
//         }
//        }

//        return ans;
//     }
// }
class Solution {

    public int minOperations(int[] nums) {
        List<Integer> s = new ArrayList<>();
        int res = 0;
        for (int a : nums) {
            while (!s.isEmpty() && s.get(s.size() - 1) > a) {
                s.remove(s.size() - 1);
            }
            if (a == 0) continue;
            if (s.isEmpty() || s.get(s.size() - 1) < a) {
                res++;
                s.add(a);
            }
        }
        return res;
    }
}