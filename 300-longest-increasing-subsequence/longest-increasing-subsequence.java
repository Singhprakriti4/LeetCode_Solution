class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list=new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
            }
            else{
                //find it's correct place
                binary(list,nums[i]);
            }
        }
        return list.size();
    }
    public void binary(List<Integer> list, int num){
        //find the first elemnt that is just greater than the currnet num
        int s=0;
        int e=list.size()-1;
        int ans=-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(list.get(m)>num){
                ans=m;
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        if(ans!=-1){
        if(ans==0 ||  list.get(ans-1)<num)
        list.set(ans,num);
        }
    }
}