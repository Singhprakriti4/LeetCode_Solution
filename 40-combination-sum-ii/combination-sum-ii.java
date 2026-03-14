class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        result=new ArrayList<>();
        Arrays.sort(candidates);
        combinations(candidates, target, 0, new ArrayList<>());
        return result;
        
    }
    public void combinations(int[] candidates, int sumleft, int begindex,
    List<Integer> arr){
        if(sumleft==0){
            //answer found
            result.add(new ArrayList<>(arr));
            return;
        }
        if(sumleft<0 || begindex==candidates.length){
            return;
        }

        for(int i=begindex; i<candidates.length;i++){
            if(i>begindex && candidates[i]==candidates[i-1]){
                continue;
                //same level ka recursive call has already been initiated
            }
            arr.add(candidates[i]);
            combinations(candidates, sumleft-candidates[i], i+1, arr);
            arr.remove(arr.size()-1);//backtrack + handle the not taken case
        }
    }
}