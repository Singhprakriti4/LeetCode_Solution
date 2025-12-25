class Trie {
    Set<String> set;
    public Trie() {
        set=new HashSet<>();
    }
    
    public void insert(String word) {
        set.add(word);
    }
    
    public boolean search(String word) {
        if(set.contains(word)) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        int l=prefix.length();
        for(String s: set){
            if(s.length()>=l){
                if(s.substring(0,l).equals(prefix)){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */