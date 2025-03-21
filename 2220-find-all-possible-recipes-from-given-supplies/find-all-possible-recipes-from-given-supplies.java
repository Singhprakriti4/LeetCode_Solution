class Solution {
    public List<String> findAllRecipes(String[] recipes,
     List<List<String>> ingredients, String[] supplies) {
        List<String> ans=new ArrayList<>();

        //topological sorting is required
        HashMap<String,Integer> indegree=new HashMap<>();
        HashMap<String,List<String>> adj=new HashMap<>();
        Queue<String> q=new LinkedList<>();

        //calculating indegree and the adjecency list 
        //indegree of the suplies will be 0
        for(int i=0;i<supplies.length;i++){
            indegree.put(supplies[i],0);
            //considering that none of the recipies need 0 ingredients
            q.add(supplies[i]);
        }
        for(int i=0;i<recipes.length;i++){
            indegree.put(recipes[i],ingredients.get(i).size());

            List<String> req=ingredients.get(i);
            for(int j=0;j<req.size();j++){
                String node=req.get(j);
                if(!adj.containsKey(node)){
                    List<String> neighbours=new ArrayList<>();
                    neighbours.add(recipes[i]);
                    adj.put(node,neighbours);
                }
                else{
                    adj.get(node).add(recipes[i]);
                }
            }
        }

        while(!q.isEmpty()){
            String node=q.poll();
            //iterate on the adjecent nodes and reduce the count of indegree
            //if the count ==0 and it is present in the recipes set. put in ans
            List<String> nodes_adj=adj.get(node);
            if(nodes_adj!=null){
            for(int i=0;i<nodes_adj.size();i++){
                String val=nodes_adj.get(i);
                indegree.put(val,indegree.get(val)-1);
                int in=indegree.get(val);

                if(in==0){
                    ans.add(val);
                    q.add(val);
                }
            }
            }
        }
        
        return ans;
    }
}