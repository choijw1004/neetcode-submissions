class MyHashSet {
    HashMap<Integer, Integer> map;

    public MyHashSet() {
        map = new HashMap<>();
    }
    
    public void add(int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
    
    public void remove(int key) {
        map.remove(key);
    }
    
    public boolean contains(int key) {
        if(map.containsKey(key)) return true;
        else return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */