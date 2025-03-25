class Solution {
    public boolean checkValidCuts(int n, int[][] h) {
       Arrays.sort(h,(a,b)->Integer.compare(a[3],b[3]));
       int[] minhr=new int[h.length];
       minhr[h.length-1]=-1;
       int minh=Integer.MAX_VALUE;
       for(int i=h.length-2;i>=0;i--){
        minh=Math.min(minh,h[i+1][1]);
        minhr[i]=minh;
       }
       int counth=0;
       for(int i=0;i<h.length-1;i++){
        if(minhr[i]>=h[i][3]){
            counth++;
        }
         if(counth==2 ){
            return true;
        }
       }
       int[][] v=h;
       Arrays.sort(v,(a,b)->Integer.compare(a[2],b[2]));
       int[] minvr=new int[h.length];
       minvr[h.length-1]=-1;
       int minv=Integer.MAX_VALUE;
       for(int i=v.length-2;i>=0;i--){
        minv=Math.min(minv,h[i+1][0]);
        minvr[i]=minv;
       }
       int countv=0;
       for(int i=0;i<v.length-1;i++){
        if(minvr[i]>=h[i][2]){
            countv++;
        }
        if(countv==2 ){
            return true;
        }
       }
       

       return false;
    }
}