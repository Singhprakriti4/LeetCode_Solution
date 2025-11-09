class Solution {
    public int countOperations(int num1, int num2) {
        int count=0;
        while(num1!=num2 && num1!=0 && num2!=0){
            // System.out.println(num1+" "+num2);
            int k=0;
            if(num1>num2){
                k=num1/num2;
                num1=num1-(k*num2);
            }
            else{
                k=num2/num1;
                num2=num2-(k*num1);
            }
            count+=k;

        }
        if(num1==0 || num2==0){
            return count;
        }
        return count+1;
    }
}