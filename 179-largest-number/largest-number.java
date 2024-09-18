class Solution {
    public String largestNumber(int[] nums) {
         StringBuilder ans=new StringBuilder();
        String[] arr=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=Integer.toString(nums[i]);
        }  
        Arrays.sort(arr,(a,b)->(a+b).compareTo(b+a));
        if(arr[arr.length-1].equals("0")){
            return "0";
        }
        for(int i=arr.length-1;i>=0;i--){
            ans.append(arr[i]);
        }
        return ans.toString();
    }
}