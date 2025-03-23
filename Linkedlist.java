 class LinkedList<T> {
 // Node class representing each element in the list.
    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Pointer to the head of the list.
    private Node head;

    // Constructor to initialize an empty list.
    public LinkedList() {
        head = null;
    }

    /**
     * Inserts a new node at the beginning of the list.
     * Time Complexity: O(1)
     *
     * @param data The data to store in the new node.
     */
    public void addFirst(T data) {
        Node newNode = new Node(data);
        newNode.next = head;  // Link new node to the previous head.
        head = newNode;       // Update head pointer to new node.
    }

    /**
     * Inserts a new node at the end of the list.
     * Time Complexity: O(n) in worst-case for non-empty list.
     *
     * @param data The data to store in the new node.
     */
    public void addLast(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            // If the list is empty, new node becomes the head.
            head = newNode;
        } else {
            Node current = head;
            // Traverse to the last node.
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;  // Append the new node.
        }
    }

    /**
     * Deletes the node at the beginning of the list and returns its data.
     * Time Complexity: O(1)
     *
     * @return The data of the removed node,
     *         or null if the list is empty.
     */
    public T removeFirst() {
        if (head == null) {
            System.out.println("List is empty, nothing to remove.");
            return null;
        }
        T removedData = head.data;
        head = head.next;  // Update head to the next node.
        return removedData;
    }

    /**
     * Displays the contents of the linked list.
     */
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * Main method to demonstrate the LinkedList operations.
     */
    public static void main(String[] args) {
        // Creating a generic linked list to store Integer values.
        LinkedList<Integer> list = new LinkedList<>();

        // Insert nodes at the beginning.
        System.out.println("Adding elements at the beginning:");
        list.addFirst(300);
        list.addFirst(200);
        list.addFirst(100);
        list.display();  // Expected: 100 -> 200 -> 300 -> null

        // Insert nodes at the end.
        System.out.println("\nAdding elements at the end:");
        list.addLast(400);
        list.addLast(500);
        list.display();  // Expected: 100 -> 200 -> 300 -> 400 -> 500 -> null

        // Delete a node from the beginning.
        System.out.println("\nRemoving the first element:");
        Integer removed = list.removeFirst();
        System.out.println("Removed element: " + removed);
        list.display();  // Expected: 200 -> 300 -> 400 -> 500 -> null
    }
}
