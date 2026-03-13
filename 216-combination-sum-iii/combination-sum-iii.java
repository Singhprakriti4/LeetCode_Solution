class Solution {
    Set<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {

        result=new HashSet<>();
        combinations(k, n, new HashSet<>());
        List<List<Integer>> combos=new ArrayList<>();
        for(List<Integer> l: result){
            combos.add(l);
        }
        return combos;
        
    }
    public void combinations( int k, int n,
    Set<Integer> ans){
        if(n==0 && ans.size()==k){
            List<Integer> test=new ArrayList<>(ans);
            result.add(test);
            return;
        }

        if(ans.size()>k || (ans.size()<=k && n<0)){
            return ;
        }

        for(int i=1;i<=9;i++){
            if(!ans.contains(i)){
                // ans.add(i);
                ans.add(i);
                combinations(k, n-i, ans);
                ans.remove(i);
                // ans.remove(ans.size()-1);
            }
        }

    }
}