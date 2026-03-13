class Solution {
    Set<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        result=new HashSet<>();
        combos(nums, 0, new ArrayList<>());

        List<List<Integer>> combinations=new ArrayList<>();
        for(List<Integer> l: result){
            combinations.add(l);
        }
        return combinations;
    }
    public void combos(int[] nums, int idx, List<Integer> ans){
        if(idx==nums.length){
            List<Integer> test=new ArrayList<>(ans);
            result.add(test);
            return;
        }

        //take or leave
        combos(nums, idx+1, ans);
        ans.add(nums[idx]);
        combos(nums, idx+1, ans);
        ans.remove(ans.size()-1);
    }
}