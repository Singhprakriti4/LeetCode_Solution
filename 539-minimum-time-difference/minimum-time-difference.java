class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] min=new int[timePoints.size()];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<timePoints.size();i++){
            min[i]=Integer.valueOf(timePoints.get(i).substring(0,2))*60+Integer.valueOf(timePoints.get(i).substring(3));
        }
        Arrays.sort(min);
        for(int i=0;i<min.length-1;i++){
           ans=Math.min(ans,min[i+1]-min[i]);
        }

        return Math.min(ans,24*60-min[min.length-1]+min[0]);
    }
}