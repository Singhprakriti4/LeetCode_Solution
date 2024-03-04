class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> biglist = new ArrayList<>();
         
        insertionsort(nums);
        // for(int i=0;i<nums.length;i++){
        //     System.out.print(nums[i]);
        // }

        //using two pointer method
        for(int i=0;i<nums.length-2;i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
               
           int j=i+1;
           int k=nums.length-1;
           while(j<k){
               
              if(nums[j] +nums[k]==-nums[i]){
                   
                   
                   biglist.add(Arrays.asList(nums[i],nums[j],nums[k]));
                   while (j<nums.length-1 && nums[j]==nums[j+1]){j++;}
                    while(k>0 && nums[k]==nums[k-1]){k--;}
                   j++;
                   k--;

               }
               else if(nums[j]+nums[k]<-nums[i]){
                   j++;
               }
               else if(nums[j]+nums[k]>-nums[i]){
                   k--;
               }
           }
           }
         }
         return biglist;
     }
    
    public void insertionsort(int[] arr){
        boolean swapped;
        for(int i=0;i<arr.length-1;i++){
            for(int j=1+i;j>0;j--){
                 swapped=false;
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                     swapped=true;
                }
                if(!swapped==true){
                    break;
                }
            }
        }
    }
}