class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
    if (a[0] == b[0]) {
        return Integer.compare(a[1], b[1]); // sort by second element
    }
    return Integer.compare(a[0], b[0]); // otherwise sort by first element
    });


    List<int[]> list=new ArrayList<>();
    int remove=0;

    for(int i=0;i<intervals.length;i++){
        //list ka last element
        if(list.size()==0){
            list.add(intervals[i]);
            continue;
        }
        else{
            int[] prev=list.get(list.size()-1);
            int[] curr=intervals[i];

            if(curr[0]>=prev[1]){
                //no removal, directly add
                list.add(curr);
            }
            else{
                remove+=1;
                //remove the one with larger end 
                if(prev[1]>curr[1]){
                    list.remove(list.size()-1);
                    list.add(curr);
                }
                // else{
                    //donot add the current one and move forward

                // }
            }
        }
    }
    return remove;
    }
}