class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
    ArrayList<Integer> list= new ArrayList<>();
         ArrayList<Integer> possible=new ArrayList<>();

    for(int i=0;i<nums.length;i++){
        possible.add(nums[i]);
    }
     combo(possible,list);
     return ans;
    }
    public void combo(ArrayList<Integer> possible,ArrayList<Integer> list){
        if(possible.size()==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<possible.size();i++){
            list.add(possible.get(i));
            int num=possible.get(i);
            possible.remove(i);
            combo(possible,list);
            possible.add(i,num);
            list.remove(possible.get(i));
        }
    }
}