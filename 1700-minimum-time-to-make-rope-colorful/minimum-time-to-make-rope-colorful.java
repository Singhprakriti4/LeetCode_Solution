class Solution {
    public int minCost(String colors, int[] neededtime) {
        int totaltime=neededtime[0];
        int timetoreduce=0;
        int currmax=neededtime[0];

        for(int i=1;i<colors.length();i++){
            totaltime+=neededtime[i];
            if(colors.charAt(i)==colors.charAt(i-1)){
                //update the max in the cong. same colors
                currmax=Math.max(currmax,neededtime[i]);
            }
            else{
                //prev chain of same colors ended
                timetoreduce+=currmax;
                currmax=neededtime[i];
            }
        }

        return totaltime-timetoreduce-currmax;
    }
}