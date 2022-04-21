class MyHashSet {
   List<Integer>lst;
    
    public MyHashSet() {
        lst=new ArrayList<>();
    }
    
    public void add(int key) {
        if(lst.contains(key)){
            return;
        }
        else{
            lst.add(key);
        }
    }
    
    public void remove(int key) {
        if(lst.contains(key)){
            lst.remove(new Integer(key));
        }
    }
    
    public boolean contains(int key) {
        return lst.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */