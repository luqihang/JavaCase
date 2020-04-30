package code.luqh.algorithm.skiplist;

/**
 * @author luqh
 * @date 2018/12/19
 **/
public class Node<K extends Comparable<K>, V> {

    private K key;
    private V value;
    private int level;
    private Node<K, V> up, down, next, previous;

    public Node(K key, V value, int level) {
        this.key = key;
        this.value = value;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                ", level=" + level +
                '}';
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Node<K, V> getUp() {
        return up;
    }

    public void setUp(Node<K, V> up) {
        this.up = up;
    }

    public Node<K, V> getDown() {
        return down;
    }

    public void setDown(Node<K, V> down) {
        this.down = down;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    public Node<K, V> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<K, V> previous) {
        this.previous = previous;
    }
}
