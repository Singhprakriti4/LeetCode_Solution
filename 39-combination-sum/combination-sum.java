class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> list=new ArrayList<>();
        combo(candidates,target,0,0,list);
        return ans;
    }
    public void combo(int[] c,int target,int sum,int index,ArrayList<Integer> list){
        if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum>target || index==c.length){
            return;
        }
       //
       list.add(c[index]);
       combo(c,target,sum+c[index],index,list);
       list.remove(list.size()-1);
       combo(c,target,sum,index+1,list);
    }
}