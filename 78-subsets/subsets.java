class Solution {
    //with backtracking
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        ss(nums,0,list);
        return ans;
    }
    public void ss(int[] nums,int index,ArrayList<Integer> list){
        if(index==nums.length){
           ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        ss(nums,index+1,list);
        list.remove(list.size()-1);
        ss(nums,index+1,list);

    }
}