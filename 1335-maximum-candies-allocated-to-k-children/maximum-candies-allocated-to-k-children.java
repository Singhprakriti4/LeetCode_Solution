class Solution {
    public int maximumCandies(int[] candies, long k) {
       int max=0;
       for(int i=0;i<candies.length;i++){
        if(candies[i]>max){
            max=candies[i];
        }
       }
       if(k==0){
        return 0;
       }

       int ans=0;
       int start=0;
       int end=max;
       while(start<=end){
        int mid=start+(end-start)/2;
        if(possible(mid,candies,k)){
            ans=mid;
            start=mid+1;
        }
        else{
            end=mid-1;
        }
       }
       return ans;
    }
    public boolean possible(int size,int[] candies,long k){
        if(size==0){
            return true;
        }
        long kids=0;
        for(int i=0;i<candies.length;i++){
            kids+=candies[i]/size;
            if(kids>=k){
                return true;
            }
        }
        return false;
    }
}