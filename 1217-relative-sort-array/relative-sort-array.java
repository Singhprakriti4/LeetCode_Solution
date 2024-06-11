class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

       int[] ans=new int[arr1.length];
       int ptr2=0,k=0;

       while(ptr2<arr2.length){
        for(int ptr1=0;ptr1<arr1.length;ptr1++){
            if(arr1[ptr1]==arr2[ptr2]){
                ans[k]=arr1[ptr1];
                arr1[ptr1]=Integer.MIN_VALUE;
                k++;
            }
        }
        ptr2++;
       }
       int from=k;
       for(int i=0;i<arr1.length;i++){
           if(arr1[i]!=Integer.MIN_VALUE){
            ans[k]=arr1[i];
            k++;
           }
       }
       Arrays.sort(ans,from,ans.length);
       return ans;
    }
}