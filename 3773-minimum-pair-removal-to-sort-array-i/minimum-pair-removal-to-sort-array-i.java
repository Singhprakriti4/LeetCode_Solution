class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n=nums.length;
        int ans=0;
        
       ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(nums[i]);
        }

        while(true){
            if(isasc(list)){
                return ans;
            }

            int pt=get(list);
            int sum=list.get(pt)+list.get(pt+1);
            list.remove(pt);
             list.add(pt,sum);
            list.remove(pt+1);
            ans+=1;
           
        }
    }
    public boolean isasc(ArrayList<Integer> list){
        for(int i=1;i<list.size();i++){
          if(list.get(i)<list.get(i-1)){
              return false;
          }  
            
        }
        return true;
    }

    public int get(ArrayList<Integer> list){
        int minsum=Integer.MAX_VALUE;
        int min=-1;
        for(int i=0;i<list.size()-1;i++){
            int curr=list.get(i)+list.get(i+1);
          if(curr<minsum){
              minsum=curr;
              min=i;
          }  
        }
        return min;
    }
}