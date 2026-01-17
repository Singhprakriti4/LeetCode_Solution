class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int[][] arr=new int[bottomLeft.length][4];
        int len=0;

        for(int i=0;i<bottomLeft.length;i++){
            arr[i][0]=bottomLeft[i][0];
            arr[i][1]=bottomLeft[i][1];
            arr[i][2]=topRight[i][0];
            arr[i][3]=topRight[i][1];
        }

        Arrays.sort(arr,(a,b)->{
            Integer val=Integer.compare(a[1],b[1]);
            if(val!=0) return val;

            return Integer.compare(a[0],b[0]);
        });

        for(int i=0;i<arr.length;i++){

            int downx=arr[i][0];
            int downy=arr[i][1];
            int topx=arr[i][2];
            int topy=arr[i][3];

            for(int j=i+1;j<arr.length;j++){
                int currdownx=arr[j][0];
                int currdowny=arr[j][1];
                int currtopx=arr[j][2];
                int currtopy=arr[j][3];

                if(currdowny>=topy){
                    break;
                }

                if(currdownx>=topx || currtopx<=downx ||
                   currtopy<=downy){
                    continue;
                }

                //finding the length of the max area square
                int currlen=Math.min(Math.min(topy,currtopy)-Math.max(downy,currdowny),
                                    Math.min(topx,currtopx)-Math.max(downx,currdownx));

                len=Math.max(len, currlen);
            }
        }
        return 1L*len*len;
    }
}