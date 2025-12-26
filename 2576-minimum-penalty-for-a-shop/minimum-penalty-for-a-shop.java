class Solution {
    public int bestClosingTime(String customers) {

       int[] prefixsum=new int[customers.length()+1];
       prefixsum[prefixsum.length-1]=0;

       for(int i=customers.length()-1;i>=0;i--) {
        if(customers.charAt(i)=='Y'){
            prefixsum[i]=prefixsum[i+1]+1;
        }
        else{
            prefixsum[i]=prefixsum[i+1];
        }
       }

       int minpenalty=Integer.MAX_VALUE;
       int time=-1;
       int openbutnot=0;

       for(int i=0;i<customers.length();i++){
        int open=openbutnot;
        int close=prefixsum[i];

        int currpenalty=open+close;
        if(currpenalty<minpenalty){
            minpenalty=currpenalty;
            time=i;
        }
        if(customers.charAt(i)=='N'){
            openbutnot+=1;
        }
       }

       //check for the time=customer.length
       if(openbutnot<minpenalty){
        return customers.length();
       }

       return time;
    }
}