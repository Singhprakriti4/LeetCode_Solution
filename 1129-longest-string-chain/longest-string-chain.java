class Solution {
    public int longestStrChain(String[] words) {
        int ans=0;
        Arrays.sort(words,
        (a,b)->{
        int l1=a.length();
        int l2=b.length();
        return Integer.compare(l1,l2);
        });

        int[] lis=new int[words.length];

        for(int i=0;i<lis.length;i++){
            //initialisation
            lis[i]=1;
            ans=Math.max(ans, lis[i]);
            for(int j=i-1;j>=0;j--){
                //compare 
                if(issuccessor(words[j], words[i])){
                    lis[i]=Math.max(lis[i], lis[j]+1);
                    ans=Math.max(ans, lis[i]);
                }
            }
        }

        return ans;

    }
    public boolean issuccessor(String pre, String post){
        if(pre.length()!=post.length()-1) return false;
        
        boolean used=false;
        int preptr=0;

        for(int i=0;i<post.length();i++){

            if(preptr<pre.length() && pre.charAt(preptr)==post.charAt(i)){

                preptr++;
                continue;

            }
            if(preptr==pre.length() || pre.charAt(preptr)!=post.charAt(i)){
                if(!used){
                    used=true;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}