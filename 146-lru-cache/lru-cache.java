class LRUCache {

    int cap;
    LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cap = capacity;

        cache = new LinkedHashMap<>(capacity, 1f, true);
        // true => access-order mode (moves accessed keys to end)
    }

    public int get(int key) {
            return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);

        if (cache.size() > cap) {
            // remove least-recently-used (first entry)
            Iterator<Integer> it = cache.keySet().iterator();
            it.next();
            it.remove();
        }
    }
}
