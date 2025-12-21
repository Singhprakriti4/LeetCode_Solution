class Solution {
    public String longestPalindrome(String str) {

        int len=0;
        String ans="";
        for(int i=0;i<str.length();i++){
            int curr=expand(i,i,str);
            // System.out.println(curr);
            // if(i==1)
            // System.out.println(curr);
            if(len<curr){
                len=curr;
                int s=i-(curr/2);
                int e=s+curr;
                //  if(i==1){
                // System.out.println(s);
                // System.out.println(e);
                //  }
                ans=str.substring(s,e);
                // if(i==1)
                // System.out.println(ans);
            }
            curr=expand(i,i+1,str);
            if(curr>len){

                len=curr;
                int s=i-(curr/2)+1;
                int e=s+curr;
                ans=str.substring(s,e);
            }
        }
        return ans;
    }
    public int expand(int i, int j, String s){
        int ans=0;
        while(i>=0 && j<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                if(i==j){
                    ans+=1;
                }
                else{
                    ans+=2;
                }
            }
            else{
                break;
            }
            i--;
            j++;
        }
        return ans;
    }
}