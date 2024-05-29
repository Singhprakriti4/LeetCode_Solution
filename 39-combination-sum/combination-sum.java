class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> ans=new ArrayList<>();
       List<Integer> innerlist=new ArrayList<>(); 
       combo(0,candidates,target,ans,innerlist,0);
       return ans;
    }
    public void combo(int index, int[] candidates,int target , List<List<Integer>> ans,List<Integer> inner,int sum){
        if(sum==target){
            ans.add(new ArrayList<>(inner));
            return;
        }
        if(index==candidates.length || sum>target){
            return;
        }

        inner.add(candidates[index]);
        combo(index,candidates,target,ans,inner,sum+candidates[index]);
        inner.remove(inner.size()-1);
        combo(index+1,candidates,target,ans,inner,sum);

    }
}