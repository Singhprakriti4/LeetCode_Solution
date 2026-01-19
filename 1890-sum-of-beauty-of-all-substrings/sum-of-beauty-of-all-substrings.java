class Solution {
    public int beautySum(String s) {
        int sum=0;

       for(int i=0;i<s.length();i++){
        for(int j=i;j<s.length();j++){
            sum+=beauty(s,i,j);
        }
       } 
       return sum;
    }
    public  int beauty(String s, int i, int j){
        int[] arr=new int[26];
        // int min=1;
        for(int k=i;k<=j;k++){
            arr[s.charAt(k)-'a']+=1;
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int v: arr){
            if(v!=0){
                min=Math.min(min, v);
                max=Math.max(max, v);
            }
        }
        return max-min;
    }
}