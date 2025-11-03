class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

    HashMap<Integer, Integer> map=new HashMap<>();
    int currodds=0;
    int ans=0;

    for(int i=0;i<nums.length;i++){

        if(nums[i]%2==1){
            currodds+=1;
        }

        if(currodds==k){
            ans+=1;
            if(map.containsKey(0)){
                ans+=map.get(0);
            }
        }

            if(currodds>k && map.containsKey(currodds-k)){
                ans+=map.get(currodds-k);
            }
        
         map.put(currodds,map.getOrDefault(currodds,0)+1);
    }
    
    // for(Map.Entry<Integer,Integer> e: map.entrySet()){
    //     System.out.println(e.getKey()+": "+e.getValue());
    // }

    return ans;


    }
} 