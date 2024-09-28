class MyCircularDeque {
    static class Node{
        int val;
        Node prev,next;
        public Node(int val){
            this.val = val;
        }
    }
    private int cnt;
    private int n;
    private Node front;
    private Node rear;

    public MyCircularDeque(int k) {
        this.cnt=0;
        this.n=k;
        this.front=null;
        this.rear=null;
        
    }
    
    public boolean insertFront(int value) {
        if(isFull())return false;
        Node node = new Node(value);
        if(front==null && rear == null){
            front=rear = node;
        }else{
            node.next = front;
            front.prev = node;
            front = node;
        }
        cnt++;
        return true;
        
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        Node node = new Node(value);
        if(front==null && rear==null)front =rear = node;
        else{
            rear.next = node;
            node.prev = rear;
            rear = node;
        }
        cnt++;
        return true;
        
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        if(front==rear)front=rear=null;
        else{
            front = front.next;
            front.prev = null;
        }
        cnt--;
        return true;
        
    }
    
    public boolean deleteLast() {
        if(isEmpty())return false;
        if(rear==front)rear=front=null;
        else{
            rear = rear.prev;
            rear.next = null;
        }
        cnt--;
        return true;
        
    }
    
    public int getFront() {
        if(isEmpty())return -1;
        return front.val;
        
    }
    
    public int getRear() {
        if(isEmpty())return -1;
        return rear.val;
    }
    
    public boolean isEmpty() {
        return cnt==0;
        
    }
    
    public boolean isFull() {
        return cnt==n;
        
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */