class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=1;
        int e=Integer.MAX_VALUE;
        int ans=0;

        while(s<=e){
            int m=s+(e-s)/2;

            if(caneat(m,piles,h)){
                ans=m;
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        return ans;
    }
    public boolean caneat(int s, int[] piles, int h){
        int time=0;
        for(int i=0;i<piles.length;i++){
            time=time+(piles[i]/s);
            if(piles[i]%s!=0){
                time+=1;
            }
        }
        return time<=h;
    }
}