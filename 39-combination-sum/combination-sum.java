class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        ans=new ArrayList<>();

        HashSet<Integer> set=new HashSet<>();
        for(int num: candidates){
            set.add(num);
        }

        int[] arr=new int[set.size()];
        int idx=0;
        for(int num: set){
            arr[idx++]=num;
        }

        combo(arr, 0, target, new ArrayList<>());
        return ans;

    }
    public void combo(int[] arr, int idx, int target, List<Integer> curr){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target<0 || idx==arr.length){
            return;
        }

        curr.add(arr[idx]);
        combo(arr, idx, target-arr[idx], curr);
        curr.remove(curr.size()-1);
        // curr.add(arr[idx]);
        // combo(arr, idx+1, target-arr[idx], curr);
        // curr.remove(curr.size()-1);
        combo(arr, idx+1, target, curr);
        return;
    }
}