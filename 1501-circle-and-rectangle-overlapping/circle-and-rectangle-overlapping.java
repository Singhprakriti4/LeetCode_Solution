class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
       //closest x to center of circle
        int closestx=0;
        if(xCenter<x1){
            closestx=x1;
        }
        else if(xCenter>x2){
            closestx=x2;
        }
        else{
            closestx=xCenter;
        }
        //closest y to center of circle
        int closesty=0;
        if(yCenter<y1){
            closesty=y1;     
        }
        else if(yCenter>y2){
            closesty=y2;
        }
        else{
            closesty=yCenter;
        }

        //distance between center of circle to closest x and y
        int dist=(int)Math.pow(Math.pow(closestx-xCenter,2)+Math.pow(closesty-yCenter,2),0.5);

        if(dist<=radius){
            return true;
        }

        return false;
    }
}