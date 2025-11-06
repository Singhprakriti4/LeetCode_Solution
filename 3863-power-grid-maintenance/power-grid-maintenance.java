class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        Set<Integer> online=new HashSet<>();
        List<Integer>[] adj=new ArrayList[c+1];
        
        for(int i=1;i<c+1;i++){
            adj[i]=new ArrayList<>();
            online.add(i);
        }

        for(int i=0;i<connections.length;i++){
            int id1=connections[i][0];
            int id2=connections[i][1];

            adj[id1].add(id2);
            adj[id2].add(id1);
        }
        

        HashMap<Integer,TreeSet<Integer>> map=new HashMap<>();
        boolean[] visited=new boolean[c+1];

        for(int i=1;i<c+1;i++){
            if(!visited[i]){
                TreeSet<Integer> list=bfs(i,adj,visited);
                for(int val: list){
                    map.put(val,list);
                }
            }
        }
        
        List<Integer> result=new ArrayList<>();

        for(int i=0;i<queries.length;i++){
            int opr=queries[i][0];
            int id=queries[i][1];

            if(opr==2){

                if(online.contains(id)) online.remove(id);
                // for(Map.Entry<Integer,TreeSet<Integer>> e: map.entrySet()){
                //     TreeSet<Integer> grid=e.getValue();
                //     if(grid.contains(id)){
                //         grid.remove(id);
                //     }
                // }
                TreeSet<Integer> grid = map.get(id);
                grid.remove(id);

            }
            else{

                if(online.contains(id)){
                    result.add(id);
                }
                else{
                    TreeSet<Integer> grid=map.get(id);
                    if(grid.size()==0){
                        result.add(-1);
                    }
                    else{
                        result.add(grid.first());
                    }
                }
            }
        }

        //converting result in an array
        int[] ans=new int[result.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=result.get(i);
        }

        return ans;

    }
    public TreeSet<Integer> bfs(int src,List<Integer>[] adj,boolean[] visited){
        
        TreeSet<Integer> list=new TreeSet<>();
        Queue<Integer> q=new LinkedList<>();

        q.add(src);
        visited[src]=true;

        while(!q.isEmpty()){

            int node=q.poll();
            list.add(node);
            // visited[node]=true;

            List<Integer> neighbours=adj[node];
            for(int v: neighbours){
                if(!visited[v]){
                    visited[v]=true;
                    q.add(v);
                }
            }
        }
        return list;
    }
}