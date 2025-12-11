class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer,TreeSet<Integer>> rowwise=new HashMap<>();
        HashMap<Integer,TreeSet<Integer>> colwise=new HashMap<>();

        for(int i=0;i<buildings.length;i++){
            int r=buildings[i][0];
            int c=buildings[i][1];
            //row wise
           if(!rowwise.containsKey(r)){
            rowwise.put(r, new TreeSet<>());
           }
           if(!colwise.containsKey(c)){
            colwise.put(c, new TreeSet<>());
           }
           rowwise.get(r).add(c);
           colwise.get(c).add(r);
        }

        int count=0;
        for(int i=0;i<buildings.length;i++){
            int r=buildings[i][0];
            int c=buildings[i][1];

            int currrowmin=-1;
            int currrowmax=-1;
            int currcolmin=-1;
            int currcolmax=-1;
                currrowmin=rowwise.get(r).getFirst();
                currrowmax=rowwise.get(r).getLast();
                currcolmin=colwise.get(c).getFirst();
                currcolmax=colwise.get(c).getLast();
            if(currrowmin<c && currrowmax>c && currcolmax>r && currcolmin<r){
                count+=1;
            }
        }
        
        return count;

    }
}