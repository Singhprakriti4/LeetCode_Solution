class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        ss(nums,0,list);
        return ans;
    }
    public void ss(int[] nums,int index,ArrayList<Integer> list){
        if(index==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        //find the count
        int i=index;
        int count=1;
        //calculate count 
        while(i+1<nums.length && nums[i]==nums[i+1]){
            count++;
            i++;
        }
        int c=count;
        while(c!=0){
            list.add(nums[index]);
            ss(nums,index+count,list);
            c--;
        }
        while(count!=0){
            list.remove(list.size()-1);
            count--;
        }
        //without considering
        ss(nums,i+1,list);

    }
}