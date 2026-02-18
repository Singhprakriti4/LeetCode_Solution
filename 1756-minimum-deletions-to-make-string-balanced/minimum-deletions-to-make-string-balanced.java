class Solution {
    public int minimumDeletions(String s) {
       if(s.length()==1) {
        return 0;
       }
       int[] b1=new int[s.length()]; 
       int[] a2=new int[s.length()]; 

       if(s.charAt(0)=='b'){
        b1[0]=1;
       }

       for(int i=1;i<s.length();i++){
        b1[i]=b1[i-1];

        if(s.charAt(i)=='b'){
            b1[i]+=1;
        }

       }

       if(s.charAt(s.length()-1)=='a'){
        a2[a2.length-1]=1;
       }

       for(int i=s.length()-2;i>=0;i--){
        a2[i]=a2[i+1];

        if(s.charAt(i)=='a'){
            a2[i]+=1;
        }

       }

       int ans=Integer.MAX_VALUE;
       for(int i=0;i<a2.length;i++){
        if(s.charAt(i)=='a'){
            int prevb=b1[i];
            int nexta=a2[i]-1;
            int del=prevb+nexta;
            // System.out.println(del);
            ans=Math.min(ans, del);
        }
       }
       //if i teke no a and b
       int res=b1[b1.length-1];
       ans=Math.min(ans, res);
       res=a2[0];
       ans=Math.min(ans, res);
       if(ans==Integer.MAX_VALUE) return 0;
       return ans;
    }
}