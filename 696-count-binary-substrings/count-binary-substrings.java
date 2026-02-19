class Solution {
    public int countBinarySubstrings(String s) {
        int ans=0;
        int curr=0;
        int prev=0;
        curr+=1;
        int i=1;
        while(i<=s.length()){
            if(i==s.length()){
                ans+=Math.min(prev, curr);
                i+=1;
                continue;
            }
            if(s.charAt(i)==s.charAt(i-1)){
                curr+=1;
            }
            else{
                ans+=Math.min(prev, curr);
                prev=curr;
                curr=1;
            }
            i+=1;
        }
        return ans;
    }
}