class Solution {
    public boolean lemonadeChange(int[] bills) {

        int curr5=0;
        int curr10=0;
        int curr20=0;

        boolean ans=true;

        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
               curr5+=1;
            }
            else{

                int tobereturned=bills[i]-5;
                if(tobereturned==5){
                    if(curr5<1){
                        return false;
                    }
                    curr5-=1;
                }
                else if(tobereturned==10){
                    if(curr10==0 && curr5<2){
                        return false;
                    }
                    else if(curr10!=0){
                        curr10-=1;
                     }
                    else if(curr5>=2){
                        curr5-=2;
                    }
                    else{
                        return false;
                    }
                }
                else if(tobereturned==15){
                    if(curr5==0){
                        return false;
                    }
                    else if(curr5>=1 && curr10>=1){
                        curr5-=1;
                        curr10-=1;
                    }
                    else if(curr5>=3){
                         curr5-=3;
                    }
                    else{
                        return false;
                    }
                }

               if(bills[i]==10) curr10+=1;
               else curr20+=1;

            }
        }
        return ans;
    }
}