class Solution {
    //cycle detection in directed graph (dfs)
    public List<Integer> eventualSafeNodes(int[][] graph) {

        // boolean[] notsafe=new boolean[graph.length];
        Set<Integer> safe=new HashSet<>();
        Set<Integer> unsafe=new HashSet<>();

        boolean[] visited=new boolean[graph.length];
        boolean[] currpath=new boolean[graph.length];

        for(int i=0;i<visited.length;i++){

                if(hascycle(visited,currpath,i,graph,unsafe,safe)){
                    unsafe.add(i);
                }
                else{
                    safe.add(i);
                }
        }

        List<Integer> ans=new ArrayList<>();

        for(int node: safe){

            ans.add(node);
        }
         Collections.sort(ans);
         return ans;

    }
    public boolean hascycle(boolean[] visited, boolean[] currpath, int src,
     int[][] graph, Set<Integer> unsafe, Set<Integer> safe){
        visited[src]=true;
        currpath[src]=true;

        // if(notsafe[src]) return true;
        if(unsafe.contains(src)){
            return true;
        }
        if(safe.contains(src)){
            return false;
        }
        
        for(int i=0;i<graph[src].length;i++){
            int node=graph[src][i];
             if(unsafe.contains(node)){
                return true;
            }
            else if(visited[node] && currpath[node]==true){
                return true;
            }
            else if(!visited[node]){
                if(hascycle(visited,currpath,node,graph,unsafe,safe)) return true;
            }
        }

        currpath[src]=false;
        return false;
    }
}