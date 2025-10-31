class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int s=0;
        int e=0;
        int len=0;
        int flipped=0;
        ArrayList<Integer> list=new ArrayList<>();

        while(e<nums.length && s<nums.length){
            if(nums[e]==1){
                len=Math.max(len,e-s+1);
                e++;
            }
            else{
                //either you can flip or you can't
                if(flipped<k){
                    //can be flipped
                    flipped+=1;
                    len=Math.max(len,e-s+1);
                    list.add(e);
                     e++;
                }
                else{
                    // shift s to the +1 index of first flipped in the frame
                    if(list.size()==0){
                        s=e+1;
                        e=s;
                    }
                    else{
                    int idx=list.get(0);
                    s=idx+1;
                    flipped-=1;
                    list.remove(0);
                    }
                }
            }
        }
        return len;
    }
}