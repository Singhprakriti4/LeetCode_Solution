class Solution {
    public int[] minOperations(String boxes) {
     char[] arr=boxes.toCharArray();
     int[] leftsum=new int[boxes.length()];

     int count=Integer.parseInt(Character.toString(arr[0]));
     leftsum[0]=0;
     for(int i=1;i<leftsum.length;i++){
        leftsum[i]=leftsum[i-1]+count;
        if(arr[i]=='1'){
            count++;
        }
     }

     count=Integer.parseInt(Character.toString(arr[arr.length-1]));
     int[] rightsum=new int[boxes.length()];
     rightsum[rightsum.length-1]=0;
     for(int i=rightsum.length-2;i>=0;i--){
        rightsum[i]=rightsum[i+1]+count;
        if(arr[i]=='1'){
            count++;
        }
     }

     int[] result=new int[boxes.length()];
     for(int i=0;i<result.length;i++){
        result[i]=leftsum[i]+rightsum[i];
     }
     
     return result;
    }
}