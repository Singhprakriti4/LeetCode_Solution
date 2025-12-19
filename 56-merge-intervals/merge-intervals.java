class Solution {
    public int[][] merge(int[][] intervals) {

      Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));

      List<List<Integer>> list=new ArrayList<>();
      List<Integer> l=new ArrayList<>();
      l.add(intervals[0][0]);
      l.add(intervals[0][1]);
      list.add(l);

      for(int i=1;i<intervals.length;i++){
        int currstart=intervals[i][0];
        int currend=intervals[i][1];
        int prevstart=list.get(list.size()-1).get(0);
        int prevend=list.get(list.size()-1).get(1);
        
        if(currstart<=prevend){
            //need to be merged
            // list.remove(list.size()-1);
            // list.get(list.size()-1).set()
            list.get(list.size()-1).set(1,Math.max(prevend,currend));
        }
        else{
            List<Integer> currlist=new ArrayList<>();
            //add the new one directly
            currlist.add(currstart);
            currlist.add(currend);
            list.add(currlist);
        }
      }

      int[][] mergedintervals=new int[list.size()][2];
      for(int i=0;i<list.size();i++){
        int start=list.get(i).get(0);
        int end=list.get(i).get(1);

        mergedintervals[i][0]=start;
        mergedintervals[i][1]=end;
      }

      return mergedintervals;
    }
}