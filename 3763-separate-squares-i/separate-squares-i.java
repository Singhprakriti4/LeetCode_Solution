class Solution {
     //overlaps do baar count ho rahe hain
    public double separateSquares(int[][] squares) {
     //sorting on the basis of y axis coordinates
      Arrays.sort(squares, (a,b)-> Integer.compare(a[1],b[1]));//on the basis of forst index
      double totalarea=0;
      double maxheight=0;
      for(int i=0;i<squares.length;i++){
        int x=squares[i][0];
        int y=squares[i][1];
        int l=squares[i][2];

        long curr=1L*l*l;
        totalarea+=curr;
        maxheight=Math.max(maxheight, y+l);
      }

      double target=totalarea/2.0;
    //   System.out.println(totalarea);
    //   System.out.println(areatilly(1.16667,squares));
    //   return 0;

      double s=0;
      double e=maxheight;
      double result=-1;

      while(e - s > 1e-5){
        double mid=s+(e-s)/2;
        double currarea=areatilly(mid, squares);
        // System.out.println(currarea);
        if(currarea>=target){
            result=mid;
            e=mid;
        }
        else{
            s=mid;
        }
      }
      
      return result;
    }
    public double areatilly(double y, int[][] squares){
        double area=0;
        for(int i=0;i<squares.length;i++){
            //if the y coordinate is above the y then break
            if(squares[i][1]>=y){
                break;
            }
            else{
                //we have to take care of the length part
                double a=squares[i][2];//horizontal
                double b=a;//vertical
                if(squares[i][1]+a>y){
                    //b needs to be adjusted
                    b=y-squares[i][1];
                }

                area+=a*b;
            }
        }
        return area;
    }
}