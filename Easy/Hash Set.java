/*
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
*/
class MyHashSet {

    private static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    private static final int BUCKET_SIZE = 769; // Prime number to minimize collisions
    private Node[] buckets;

    public MyHashSet() {
        buckets = new Node[BUCKET_SIZE];
    }

    private int hash(int key) {
        return key % BUCKET_SIZE;
    }

    public void add(int key) {
        int idx = hash(key);
        Node head = buckets[idx];

        if (head == null) {
            buckets[idx] = new Node(key);
            return;
        }

        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                return; // Key already exists
            }
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }

        curr.next = new Node(key);
    }

    public void remove(int key) {
        int idx = hash(key);
        Node curr = buckets[idx];

        if (curr == null) {
            return;
        }

        // If the key is at the head node
        if (curr.key == key) {
            buckets[idx] = curr.next;
            return;
        }

        // Search for the key in the rest of the chain
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        int idx = hash(key);
        Node curr = buckets[idx];

        while (curr != null) {
            if (curr.key == key) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }
}
