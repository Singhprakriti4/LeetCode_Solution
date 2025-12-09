class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length){
            return -1;// enough flowers not found
        }
        int ans=-1;//result
        int s=0;
        int e=1000000000;

        while(s<=e){
            int mid=s+(e-s)/2;
            if(possible(mid,bloomDay,m,k)){
                //can make m or more bouquets
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int day, int[] bloomday, int m, int k){

       int ans=0;
       int count=0;

       for(int i=0;i<bloomday.length;i++){

        if(bloomday[i]<=day){
            count+=1;
        }
        else{
            count=0;
        }
        if(count==k){
            ans+=1;
            count=0;
        }
       }
      return ans>=m;
    }
}