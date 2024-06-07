class Solution {
    public String getPermutation(int n, int k) {

        String a="";
        for(int i=1;i<=n;i++){
            a=a+i;
        }
        StringBuilder ans=new StringBuilder();
        permutations(ans,a,k);
        return ans.toString();
        
    }
    public void permutations(StringBuilder ans,String up,int k){

        if(up.length()==1){
            ans.append(up.charAt(0));
            return;
        }

        int l=up.length();
        int fact=factorial(l-1);
        int f=k/fact;
        if(k%fact==0){
            f=f-1;
        }

        permutations(ans.append(up.charAt(f)),up.substring(0,f)+up.substring(f+1),k-(f*fact));

    }
    public int factorial(int N){
        if(N==1){
            return N;
        }
        return N*factorial(N-1);
    }
}