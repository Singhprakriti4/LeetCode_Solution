class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list=new ArrayList<>();
        bubblesort(nums1);
        bubblesort(nums2);
       
        int j=0,k=0;
        while(j<nums1.length && k<nums2.length){
            if(nums1[j]==nums2[k]){
                list.add(nums1[j]);
                j++;
                k++;
            }
            else if(nums1[j]<nums2[k]){
                j++;
            }
            else{
                k++;
            }
        }
      
       int[] ans= new int[list.size()];
      for(int i=0;i<list.size();i++){
          ans[i]=list.get(i);
      }

        return ans;
    }
    static void bubblesort(int[] arr){
       for(int i=0;i<arr.length;i++){
           for(int j=0;j<arr.length-1-i;j++){
               if(arr[j]>arr[j+1]){
                   int temp=arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
               }
           }
       }
    }
}