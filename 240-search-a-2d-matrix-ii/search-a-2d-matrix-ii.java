class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=matrix.length;
        int n=matrix[0].length;
        if(target>matrix[l-1][n-1]) return false;

        int r=l-1;
        int c=n-1;
        while(r>=0 && c>=0){
            //for the cirrent roe
            if(target<matrix[r][0]){
                //not in currrnt row
                r-=1;
            }
            else{
                boolean ans=false;
                int s=0;
                int e=c;
                while(s<=e){
                    int m=s+(e-s)/2;
                    int val=matrix[r][m];
                    if(val==target){
                        ans=true;
                        return true;
                    }
                    else if(val>target){
                        e=m-1;
                    }
                    else{
                        s=m+1;
                    }
                }
                if(!ans){
                    r-=1;
                    //not in the current row;
                }
            }

            if(target<matrix[0][c]){
                //not in current column;
                c-=1;
            }
            else{
                int s=0;
                int e=r;
                boolean ans=false;
                
                while(s<=e){
                    int m=s+(e-s)/2;
                    int val=matrix[m][c];
                    if(val==target){
                        ans=true;
                        return true;
                    }
                    else if(val>target){
                        e=m-1;
                    }
                    else{
                        s=m+1;
                    }
                }
                if(!ans){
                    c-=1;
                    //not in the current column
                }
            }
        }
        return false;
    }
}