class Solution {
    //cycle detection in directed graph
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> set=new HashSet<>();
        
        for(int i=0;i<graph.length;i++){
            if(graph[i].length==0){
                set.add(i);//safe state
            }
        }

        for(int i=0;i<graph.length;i++){
            if(!set.contains(i)){
                int[] currpath=new int[graph.length];
                dfs(currpath, i, set, graph);
            }
        }

        List<Integer> ans=new ArrayList<>();
        for(int v: set){
            ans.add(v);
        }
        Collections.sort(ans);
        return ans;

       
    }
    public boolean dfs(int[] currpath, int currnode, 
    Set<Integer> set, int[][] graph){
        if(set.contains(currnode)) return true;
        boolean ans=true;
        currpath[currnode]=1;
        for(int n: graph[currnode]){
            //explore all paths from the curr node
            if(currpath[n]==1){
                return false;
            }
            else{
                ans= ans && dfs(currpath, n, set, graph);
            }
        }
        if(ans){
            set.add(currnode);
        }
        currpath[currnode]=0;//reset back to normal
        return ans;
    }
}