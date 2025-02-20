class TreeAncestor {
    int n;
    int[] parent;
    int[][] st1;
    int[] heightofnode;

    //root is 0
    public TreeAncestor(int n, int[] parent) {
        this.n=n;
        this.parent=parent;
        int[][] st=new int[n][20];
        int[] height=new int[n];
        
        //first create tree(adjecency list
        ArrayList<Integer>[] adj =new ArrayList[parent.length];

        for(int i=0;i<parent.length;i++){
            adj[i]=new ArrayList<>();
        }
        
        for(int i=0;i<parent.length;i++){
            //parent to child relation      
            if(parent[i]!=-1){
                adj[parent[i]].add(i);
            }
        }
        //adj list,parent,n, sparse matrix,currnode,height of that node from top
        dfs(adj,-1,n,st,0,0,height);
        //then create sparse tree---> doing dfs
        st1=st;
        heightofnode=height;
    }
    public void dfs(ArrayList<Integer>[] adj,int parent,int size,int[][] st,int curr
    ,int height,int[] heightofnode){

        heightofnode[curr]=height;
        st[curr][0]=parent;
        int j=1;
        int currheight=2;
        while(currheight<=height){
            //populate it
            st[curr][j]=st[st[curr][j-1]][j-1];
            j++;
            currheight*=2;
        }
        //iterating over the childern with height+1,parent=curr,curr=that child
        boolean haschild=false;
        for(int children : adj[curr]){
            haschild=true;
            dfs(adj,curr,n,st,children,height+1,heightofnode);
        }
        if(!haschild){
            return;
        }
    
    }
    
    public int getKthAncestor(int node, int val) {
        //getting the query on st1
        //1. change in binary

        int k=0;
        if(heightofnode[node]<val){
            return -1;
        }
        while(val>0){
            if(val%2!=0){
                node=st1[node][k];
            }
            k++;
            val/=2;
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */