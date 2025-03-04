class Solution {
    public boolean checkPowersOfThree(int n) {
        if(n<=0){
            return false;
        }
        return check(n,0,-1);
    }
    public boolean check(int n, int sum, int power){
        if(power>16){
            return false;
        }
         if(sum==n){
            return true;
         }
         if(sum>n){
            return false;
         }
         return check(n,sum+(int)Math.pow(3,power+1),power+1) || check(n,sum,power+1);
    }
}