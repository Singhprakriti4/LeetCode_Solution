class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //sort
        Arrays.sort(g);
        Arrays.sort(s);
       int ans=0;
        if(s.length==0){
            return 0;
        }
        int j=0;
       for(int i=0;i<g.length;i++){
           if(j<s.length){
          if(g[i]==s[j] || g[i]<s[j] ){
              ans++;
              j++;
          }
          else if(g[i]>s[j]){
              //(g[i]!=s[j] || (g[i]<s[j]))
              System.out.println(j);
           while(( j<s.length ) && (g[i]>s[j])){
                  j++;
                   System.out.println(j);
                  
              }
              if((j<s.length)){
                  ans++;
                  j++;
                   System.out.println(j);
              }

          }
           }
       }
       return ans;
    }
}