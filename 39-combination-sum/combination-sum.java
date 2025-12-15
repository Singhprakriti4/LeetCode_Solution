class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        sum(candidates,0,target,new ArrayList<>());
        return ans;
    }
    public void sum(int[] c, int i, int target, List<Integer> inner){
        if(i==c.length) return;
        if(target==0){
            List last=new ArrayList<>(inner);
            ans.add(last);
            return;
        }
        // if(target<0) return;
        if(target-c[i]>=0){
            //can be taken
            inner.add(c[i]);
            sum(c,i,target-c[i],inner);
            inner.remove(inner.size()-1);
        }
        //leave
        sum(c,i+1,target,inner);
    }
}