class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans=0;
        int timer=0;
        int i=happiness.length-1;
        while(timer<k){
            // System.out.println(happiness[i]+" "+ans);
            int curr=happiness[i]-timer;
            // System.out.println(curr);
            if(curr<=0){
                return ans;
            }
            else{
                ans+=curr;
            }
            timer+=1;
            i--;
        }
        return ans;
    }
}