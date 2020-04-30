package code.luqh.algorithm.skiplist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * @author luqh
 * @date 2018/12/19
 **/
public class SkipList<K extends Comparable<K>, V> implements Iterable<K> {

    protected static final Random randomGenerator = new Random();
    protected static final double DEFAULT_PROBABILITY = 0.5;

    private Node<K, V> head;

    private double probability;

    private int size;

    public SkipList() {
        this(DEFAULT_PROBABILITY);
    }

    public SkipList(double probability) {
        this.head = new Node<>(null, null, 0);
        this.probability = probability;
        this.size = 0;
    }

    protected void checkKeyValidity(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key must be not null!");
        }
    }

    protected boolean lessThanOrEqual(K a, K b) {
        return a.compareTo(b) <= 0;
    }

    protected boolean isBuildLevel() {
        return randomGenerator.nextDouble() < probability;
    }

    protected void horizontalInsert(Node<K, V> x, Node<K, V> y) {
        y.setPrevious(x);
        y.setNext(x.getNext());
        if (x.getNext() != null) {
            x.getNext().setPrevious(y);
        }
        x.setNext(y);
    }

    protected void verticalLink(Node<K,V> x, Node<K, V> y) {
        x.setDown(y);
        y.setUp(x);
    }

    protected Node<K, V> findNode(K key) {
        Node<K, V> node = head;
        Node<K, V> next = null;
        K nodeKey = null;

        while (true) {
            next = node.getNext();
            while (next != null && lessThanOrEqual(next.getKey(), key)) {
                node = next;
                next = node.getNext();
            }
            nodeKey = node.getKey();
            if (nodeKey != null && nodeKey.compareTo(key) == 0) {
                break;
            }
            if (node.getDown() != null) {
                node = node.getDown();
            } else {
                break;
            }
        }

        return node;
    }

    public V get(K key) {
        checkKeyValidity(key);
        Node<K, V> node = findNode(key);
        if (node.getKey().compareTo(key) == 0) {
            return node.getValue();
        } else {
            return null;
        }
    }

    public void add(K key, V value) {
        checkKeyValidity(key);

        Node<K, V> node = findNode(key);

        if (node.getKey() != null && node.getKey().compareTo(key) == 0) {
            node.setValue(value);
            return;
        }

        Node<K, V> newNode = new Node<>(key, value, node.getLevel());
        horizontalInsert(node, newNode);

        int currentLevel = node.getLevel();
        int headLevel = head.getLevel();
        while(isBuildLevel()) {
            if (currentLevel >= headLevel) {
                Node<K, V> newHead = new Node<>(null, null, headLevel + 1);
                verticalLink(newHead, head);
                head = newHead;
                headLevel = head.getLevel();
            }
            while (node.getUp() == null) {
                node = node.getPrevious();
            }
            node = node.getUp();

            Node<K, V> tmp = new Node<>(key, value, node.getLevel());
            horizontalInsert(node, tmp);
            verticalLink(tmp, newNode);
            newNode = tmp;
            currentLevel++;
        }
        size++;
    }

    public void remove(K key) {
        checkKeyValidity(key);
        Node<K, V> node = findNode(key);
        if (node == null || node.getKey().compareTo(key) != 0) {
            throw new NoSuchElementException("The key is not exist!");
        }

        while (node.getDown() != null) {
            node = node.getDown();
        }

        Node<K,V> prev;
        Node<K, V> next;

        while (node != null) {
            prev = node.getPrevious();
            next = node.getNext();
            if (prev != null) {
                prev.setNext(next);
            }
            if (next != null) {
                next.setPrevious(prev);
            }
            node = node.getUp();
        }

        while (head.getNext() == null && head.getDown() != null) {
            head = head.getDown();
            head.setUp(null);
        }
        size--;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    @Override
    public Iterator<K> iterator() {
        return new SkipListIterator<>(head);
    }

    protected static class SkipListIterator<K extends Comparable<K>, V> implements Iterator<K> {

        private Node<K, V> node;


        public SkipListIterator(Node<K, V> node) {
            while (node.getDown() != null) {
                node = node.getDown();
            }
            while (node.getPrevious() != null) {
                node = node.getPrevious();
            }
            if (node.getNext() != null) {
                node = node.getNext();
            }
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return this.node != null;
        }

        @Override
        public K next() {
            K result = node.getKey();
            node = node.getNext();
            return result;
        }
    }

    public static void main(String[] args) {
        SkipList<Integer, String> skipList = new SkipList<>();
        for (int i = 0; i < 10; i++) {
            skipList.add(i, String.valueOf(i));
        }
        assert skipList.size() == 10;
        assert !skipList.empty();
//        assert !skipList.contains(11);
        assert skipList.get(5).equals("5");
        int count = 0;
        for (Integer i : skipList) {
            System.out.println(i);
            assert i.equals(count++);
        }

        skipList.remove(9);
        assert skipList.size() == 9;
        assert skipList.get(9) == null;
        skipList.remove(8);
        skipList.remove(7);
        skipList.remove(6);
        skipList.remove(5);
        skipList.remove(4);
        skipList.remove(3);
        skipList.remove(2);
        skipList.remove(1);
        skipList.remove(0);
        assert skipList.size() == 0;
        assert skipList.empty();
    }
}
