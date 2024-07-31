class RecentCounter {
    ArrayList<Integer> timestamp;
    public RecentCounter() {
       timestamp= new ArrayList<>();
    }
    
    public int ping(int t) {
        timestamp.add(t);
        int ans=0;
        int beg=0;
        while(t-timestamp.get(beg)>3000){
            beg++;
        }
        return timestamp.size()-beg;

    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */