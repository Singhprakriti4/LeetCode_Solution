class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans=0;
        for(int i=1;i<points.length;i++){
            int prevx=points[i-1][0];
            int prevy=points[i-1][1];

            int currx=points[i][0];
            int curry=points[i][1];

            int c1=0;
            //match the x coordinate and adjust the y coordinate
            int diff=Math.abs(currx-prevx);
            int diffy=Math.abs(diff-Math.abs(curry-prevy));
            c1=diff+diffy;
            // System.out.println(c1);

            //case 2: match the y coor. and adjust the x cords
            int c2=0;
            diff=Math.abs(curry-prevy);
            int diffx=Math.abs(diff-Math.abs(currx-prevx));
            c2=diff+diffx;
            // System.out.println(c2);

            ans+=Math.min(c1,c2);
        }
        return ans;
    }
}