class Solution {
    public int countPalindromes(String s) {
        if(s.length()<5){
            return 0;
        }
        //make normal prefix and suffix for all fo it
        //make a 2 d array for the matrix  
        int[] prefix=new int[10];
        int[] suffix=new int[10];
        int[][] prefix2d=new int[10][10];
        int[][] suffix2d=new int[10][10];
        int mod=1000000007;

        //populating my 2d suffix array
        for(int i=s.length()-1;i>=0;i--){
            int num=s.charAt(i)-'0';
            for(int j=0;j<10;j++){
                suffix2d[num][j]+=suffix[j];
            }
            suffix[num]+=1;
        }

        
        // for(int i=0;i<10;i++){
        //     for(int j=0;j<10;j++){
        //         System.out.print(suffix2d[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        int ans=0;
        for(int i=0;i<=s.length()-3;i++){
            int prev=0;
           if(i-1>=0)
           prev=s.charAt(i-1)-'0';
           int val=s.charAt(i)-'0';
            
            //update prefix 2d array
            if(i-1>=0){
            for(int j=0;j<10;j++){
               prefix2d[j][prev]+= prefix[j];
            }
            prefix[prev]+=1;
            }
            
            // update prefix and suffix array for curr value
            
            
            suffix[val]-=1;

            //update suffix 2d array for current value
             for(int j=0;j<10;j++){
                suffix2d[val][j]-=suffix[j];
             }
            
            // find the pairs and add their possible combos to ans
            for(int j=0;j<10;j++){
            for(int k=0;k<10;k++){
                ans=(int)(ans+(long)prefix2d[j][k]*suffix2d[k][j]%mod)%mod;
            }
            }

        }
        return ans;
    }
}