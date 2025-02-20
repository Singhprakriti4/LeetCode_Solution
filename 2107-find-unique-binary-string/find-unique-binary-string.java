class Solution {
    String ans="";
    //brute force
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        StringBuilder str=new StringBuilder();
        make(set,n,0,str);
        return ans;
    }
    //create all strings of length n and check if it exists in the nums
    public void make(HashSet<String> set,int n,int currlen,StringBuilder str){
        if(currlen==n){
            if(!set.contains(str.toString())){
                ans=str.toString();
            }
            return;
        }
     str.append('1');
     make(set,n,currlen+1,str);
     str.deleteCharAt(str.length()-1);
     str.append('0');
     make(set,n,currlen+1,str);
     str.deleteCharAt(str.length()-1);
    }
}