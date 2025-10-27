class Solution {
    int mod=1000000007;
    //aim is to find that for each index, find out the no of subararys where it will be the minimum elemnt
    //then we can multiply it with the arr[index] 
    //and then sum it all up

    public int sumSubarrayMins(int[] arr) {

        int ans=0;
        //arr1 will help us tell the next smallest element: 

        int[] arr1=new int[arr.length];
        //-1 will tell that there is not element smaller after this idx

        Arrays.fill(arr1,-1);
        Stack<Integer> stk=new Stack<>();

        for(int i=0;i<arr.length;i++){
           while(!stk.isEmpty() && arr[i]<arr[stk.peek()]){
            arr1[stk.pop()]=i;
           } 
           stk.push(i);
        }
        
        //arr 2 will tell us the previous smaller index from curr index: 
        int[] arr2=new int[arr.length];
        //-1 tells there is no element lesser before this index
        Arrays.fill(arr2,-1);
        stk=new Stack<>();//in order to empty the previous stk 

        for(int i=arr.length-1;i>=0;i--){
            while(!stk.isEmpty() && arr[i]<=arr[stk.peek()]){
                arr2[stk.pop()]=i;
            }
            stk.push(i);
        }

        for(int i=0;i<arr.length;i++){

            int left;
            int right;
           if(arr1[i]==-1){
            //no of suarrays to the right
            right=arr.length-i-1;
           }
           else{
            right=arr1[i]-i-1;
           }
           if(arr2[i]==-1){
            //no of subarrays to the left
            left=i;
           }
           else{
            left=i-arr2[i]-1;
           }

        //    ans= ans+ (((left+right+(left*right)+1)%mod)*(arr[i]%mod));
        long val = (1L * (left + right + (1L * left * right) + 1) * arr[i]) % mod;
    ans = (int)((ans + val) % mod);
        }

        return ans;
    }
}