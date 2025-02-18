class ThroneInheritance {

    private HashMap<String,ArrayList<String>> map=new HashMap<>();
    private String king;
    private HashSet<String> dead=new HashSet<>();

    public ThroneInheritance(String kingName) {
        this.king=kingName;
        map.put(king,new ArrayList<>());
    }
    
    public void birth(String parent, String child) {
        //adding them into their parents' place
        map.get(parent).add(child);
        //vreating space for their future kidds
        map.put(child,new ArrayList<>());
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        //perform dfs just donot add people that are dead into the ans
        List<String> ans=new ArrayList<>();
        dfs(ans,king);
        return ans;
    }
    
    public void dfs(List<String> ans,String name){
        if(!dead.contains(name)){
            ans.add(name);
        }
        //iterate on all its childern
        ArrayList<String> children=map.get(name);
        for(String s:children){
            //call dfs for all its children
            dfs(ans,s);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */