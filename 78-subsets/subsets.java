class Solution {
    public List<List<Integer>> subsets(int[] nums) {

      List<List<Integer>> outerlist=new ArrayList<>();
      List<Integer> ans=new ArrayList<>();
      subs(nums,0,ans,outerlist);
      return outerlist;
 
    }
    public void subs(int[] nums,int ptr,List<Integer> ans,List<List<Integer>> outerlist){

        if(ptr==nums.length){
            outerlist.add(new ArrayList<>(ans));
            return;
        }
         
        
        ans.add(nums[ptr]);
        subs(nums, ptr+1 , ans ,outerlist);
        ans.remove(ans.size()-1);
        subs(nums,ptr+1,ans,outerlist);

    }

}