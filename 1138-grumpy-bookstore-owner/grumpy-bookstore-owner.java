class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0){
                ans+=customers[i];
                customers[i]=0;
            }
        }
        int i=0,j=0;
        int maxsum=customers[i];
        while(j-i+1!=minutes){
           j++;
           maxsum+=customers[j];
        }
        int sum=maxsum;
        while(j!=customers.length-1){
          sum-=customers[i];
          i++;
          j++;
          sum+=customers[j];
          if(maxsum<sum){
            maxsum=sum;
          }
        }
        return ans+maxsum;
    }
}