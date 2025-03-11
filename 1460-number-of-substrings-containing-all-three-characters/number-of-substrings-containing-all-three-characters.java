class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int ans=0;
        int i=0;
        int j=0;
        int a=0;
        int b=0;
        int c=0;

        while(j<n && (a==0 || b==0 || c==0)){
            if(s.charAt(j)=='a')a++;
            if(s.charAt(j)=='b')b++;
            if(s.charAt(j)=='c')c++;
            j++;
        }
        j--;

           System.out.println(j);
        //    System.out.println(a);
        //    System.out.println(b);
        //    System.out.println(c);
        if(a==0 || b==0 || c==0){
            // System.out.println("ji");
            return ans;
        }


        //consider only aage ke substrings 
        while(j<n && i<n){

           if(a!=0 && b!=0 && c!=0){
            ans+=n-j;

            if(s.charAt(i)=='a') a--;
            if(s.charAt(i)=='b') b--;
            if(s.charAt(i)=='c') c--;
            i++;
            
           }
           else{
            //only j will be moved
            j++;
            if(j<n){
            if(s.charAt(j)=='a')a++;
            if(s.charAt(j)=='b')b++;
            if(s.charAt(j)=='c')c++;
            }
            
           }
        }
        
        return ans;
    }
}