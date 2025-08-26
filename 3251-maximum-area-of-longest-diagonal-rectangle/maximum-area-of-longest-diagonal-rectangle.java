class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {

      float diag=0;
      int area  =0;

      for(int i=0;i<dimensions.length;i++){
        float curr_diag=0;
        int curr_area=0;

        //calculation
        curr_diag=(float)Math.sqrt(Math.pow(dimensions[i][0],2)+Math.pow(dimensions[i][1],2));
        curr_area= dimensions[i][0]*dimensions[i][1];
        
        if(curr_diag>diag){
            //
            diag=curr_diag;
            area=curr_area;
        }
        else if(curr_diag==diag){
            //geratest area
            if(curr_area>area){
                area=curr_area;
            }
        }
      }

      return area;
    }
}