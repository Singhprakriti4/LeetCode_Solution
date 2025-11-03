class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //let us remove the subarray of length totallength-k with the minimum sum
        if(k==0){
            return 0;
        }
        
        int totalscore=0;
        int ans=0;
        int sumsubarray=0;
        int minsumsubarray=Integer.MAX_VALUE;
        int i=0;

        for(int j=0;j<cardPoints.length;j++){
            totalscore+=cardPoints[j];
            sumsubarray+=cardPoints[j];

            if(j-i+1==cardPoints.length-k){
                //both the pointers will move with comparison
                minsumsubarray=Math.min(minsumsubarray, sumsubarray);
                sumsubarray-=cardPoints[i];
                i++;
            }
        }
        if(k==cardPoints.length){
            return totalscore;
        }
        return totalscore-minsumsubarray;
    }
}