class Solution {
    public int maxTwoEvents(int[][] events) {

        int max=0;
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        // for(int i=0;i<events.length;i++){
        //     System.out.println(events[i][0]+" "+events[i][1]+" "+events[i][2]);
        // }
        // System.out.println();

        int[] maxtillnow=new int[events.length];
        maxtillnow[events.length-1]=events[events.length-1][2];

        for(int i=events.length-2;i>=0;i--){
            if(events[i][2]>maxtillnow[i+1]){
                maxtillnow[i]=events[i][2];
            }
            else{
                maxtillnow[i]=maxtillnow[i+1];
            }
        }

        for(int i=0;i<events.length;i++){
            //for each current value find the enxt index
            // whose start time is greater than currnt value end time
            int j=binary(events,i);
            // System.out.println(i+" "+j);
            if(j!=-1){
                //we got the value of j
                int currmax=maxtillnow[j]+events[i][2];
                max=Math.max(max, currmax);
            }
            max=Math.max(max, events[i][2]);//incase ye single hi max nikal gaya
        }
        return max;
    }
    public int binary(int[][] events, int b){
        // if(b==3)
        // System.out.println(events[b][1]);
        int s=b+1;
        int ans=-1;
        int e=events.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            // if(b==3){
            //     System.out.println(events[m][0]);
            // }
            if(events[m][0]>events[b][1]){
                
                ans=m;
                e=m-1;//look phle bhi
            }
            else{
                s=m+1;
            }
        }
        return ans;
    }
}