class RecentCounter {
    ArrayList<Integer> timestamp;
    public RecentCounter() {
       timestamp= new ArrayList<>();
    }
    
    public int ping(int t) {
        timestamp.add(t);
        int ans=0;
        for(int i=timestamp.size()-1;i>=0;i--){
            if(t-timestamp.get(i)<=3000){
                ans++;
            }
            else{
                break;
            }
        }
        return ans;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */