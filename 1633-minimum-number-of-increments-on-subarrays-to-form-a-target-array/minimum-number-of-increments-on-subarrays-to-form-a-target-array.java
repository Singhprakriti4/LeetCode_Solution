class Solution {
    public int minNumberOperations(int[] target) {
        int prev=0;
        int curr=0;
        int ans=0;
        
        for(int i=0;i<target.length;i++){
            curr=target[i];
            if(curr-prev>0){
                ans+=curr-prev;
            }
            prev=curr;
        }
        return ans;
    }
}