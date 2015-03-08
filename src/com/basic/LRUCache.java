public class LRUCache {
  private class Node {
    Node prev;
    Node next;
    int key;
    int value;
    
    public Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.prev = null;
      this.next = null;
    }
  }
  
  private int capacity;
  private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
  private Node head = new Node(-1, -1);
  private Node tail = new Node(-1, -1);
  
  public LRUCache(int capacity) {
    this.capacity = capacity;
    tail.prev = head;
    head.next = tail;
  }
  
  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    // remove current
    Node cur = map.get(key);
    cur.prev.next = cur.next;
    cur.next.prev = cur.prev;
    
    // move current to tail
    move_to_tail(cur);
    
    return map.get(key).value;
  }
  
  private void move_to_tail(Node cur) {
    cur.prev = tail.prev;
    tail.prev = cur;
    cur.prev.next = cur;
    cur.next = tail;
    
  }
  
  public void set(int key, int value) {
    if (map.get(key) != -1) {
      map.get(key).value = value;
      return;
    }
    if (map.size() == capacity) {
      map.remove(head.next.key);
      head.next = head.next.next;
      head.next.prev = head;
    }
    Node insert = new Node(key, value);
    map.put(key, insert);
    move_to_tail(insert);
  }
}
