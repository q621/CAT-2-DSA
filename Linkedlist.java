 class LinkedList<T> {
    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head;

   
    public LinkedList() {
        head = null;
    }
    public void addFirst(T data) {
        Node newNode = new Node(data);
        newNode.next = head; 
        head = newNode;       
    }

  
    public void addLast(T data) {
        Node newNode = new Node(data);
        if (head == null) {
           
            head = newNode;
        } else {
            Node current = head;
          
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; 
        }
    }

  
    public T removeFirst() {
        if (head == null) {
            System.out.println("List is empty, nothing to remove.");
            return null;
        }
        T removedData = head.data;
        head = head.next; 
        return removedData;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

    
        System.out.println("Adding elements at the beginning:");
        list.addFirst(300);
        list.addFirst(200);
        list.addFirst(100);
        list.display();  

        System.out.println("\nAdding elements at the end:");
        list.addLast(400);
        list.addLast(500);
        list.display();

        System.out.println("\nRemoving the first element:");
        Integer removed = list.removeFirst();
        System.out.println("Removed element: " + removed);
        list.display(); 
    }
}
