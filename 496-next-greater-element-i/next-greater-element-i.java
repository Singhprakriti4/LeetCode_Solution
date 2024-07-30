class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       int[] ans=new int[nums1.length];
       int[] allbig=new int[nums2.length];
       allbig=allnextbigele(nums2,allbig);
       int k=0;
       for(int i=0;i<nums1.length;i++){
         int j=0;
         while(nums1[i]!=nums2[j]){
            j++;
         }
        ans[k]=allbig[j];
        k++;
       }
       return ans;

    }
    public int[] allnextbigele(int[] nums2,int[] allbig){
        int k=allbig.length-1;
        Stack<Integer> s=new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=nums2[i]){
                s.pop();
            }
            if(s.isEmpty()){
                allbig[k]=-1;
            }
            else{
               allbig[k]=s.peek();
            }
            k--;
            s.push(nums2[i]);
        }
        return allbig;
    }

}