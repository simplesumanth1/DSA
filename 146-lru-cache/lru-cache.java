class LRUCache {
    static class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
        
    }
    HashMap<Integer,Node>map;
    int capacity;
    Node head;
    Node tail;


    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            int ans = temp.val;
            remove(temp);
            insert(temp);
            return ans;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            remove(temp);
            map.remove(key);
        }else if(map.size()==capacity){
            Node temp = tail.prev;
            remove(temp);
            map.remove(temp.key);

        }
        Node node = new Node(key,value);
        insert(node);
        map.put(key,node);
        
    }
    public void insert(Node node){
        head.next.prev = node;
        node.next = head.next ;
        node.prev = head;
        head.next = node;
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */