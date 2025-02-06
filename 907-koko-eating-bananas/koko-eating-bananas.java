class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int ans=0;
        int s=1;
        int e=1000000000;
        while(s<=e){
            int mid=s+(e-s)/2;
            // System.out.println(mid);
            long time=timetaken(piles,mid);
            System.out.println(time);
            if(time<=(long)h){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
    //returning time taken at speed of s
    long timetaken(int[] piles,int s){
        long time=0;
        for(int i=0;i<piles.length;i++){
         time= time+ (piles[i]/s) + ((piles[i]%s==0)?0:1) ;
        }
        return time;
    }
}