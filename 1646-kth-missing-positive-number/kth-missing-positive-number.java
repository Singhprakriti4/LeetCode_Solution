class Solution {
    public int findKthPositive(int[] arr, int k) {

        int s=0;
        int e=arr.length-1;
        int idx=-1;//wp phla index jo humare k ya more tha  k values ko rakhta hai

        while(s<=e){
            int m=s+(e-s)/2;
            int val=arr[m];
            int missing=(val-1)-m;//what the index should be and what it is currently
            if(missing>=k){
                idx=m;
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        System.out.println(idx);
        if(idx==0){
            return k;
        }
        if(idx==-1){
           int l=arr[arr.length-1]-1-(arr.length-1);
           return arr[arr.length-1]+(k-l);
        }

        
        int prevval=arr[idx-1];
        int lost=(prevval-1)-(idx-1);
        int newk=k-lost;
        return prevval+newk;
    }
}