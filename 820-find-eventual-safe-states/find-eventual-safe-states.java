class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashSet<Integer> terminal=new HashSet<>();
        boolean[] visited=new boolean[graph.length];
        ArrayList<Integer> ans=new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            if(graph[i].length==0){
                terminal.add(i);
            }
        }
        for(int i=0;i<graph.length;i++){
           if( safe(i,graph,terminal,visited))
           ans.add(i);
        }
        Collections.sort(ans);
        return ans;
    }
    public boolean safe(int node,int[][] graph,HashSet<Integer> terminal,boolean[] visited){
        if(terminal.contains(node)){
            return true;
        }
        visited[node]=true;
        for(int i=0;i<graph[node].length;i++){
            if(visited[graph[node][i]]){
                return false;
            }
            if(!safe(graph[node][i],graph,terminal,visited)){
                return false;
            }
        }
        visited[node]=false;
        terminal.add(node);
        return true;
    }
}