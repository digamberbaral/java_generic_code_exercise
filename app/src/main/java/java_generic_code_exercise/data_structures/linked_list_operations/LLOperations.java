package java_generic_code_exercise.data_structures.linked_list_operations;

public class LLOperations {
    Node head;
    int length;

    LLOperations(){
        this.head = null;
        this.length = 0;
    }

    public Node insertAtBeginning(Node head, int value) {
        Node newNode = new Node(value);
        if(head != null){
            newNode.next = head;
        }
        head = newNode;
        length++;
        
        return head;
    }

    public Node insertAtEnd(Node head, int value) {
        Node newNode = new Node(value);
        if(head == null) {
            return newNode; // If the list is empty, return the new node as the head
        }
        Node current = head;
        while(current.next != null) {
            current = current.next; // Traverse to the end of the list
        }
        current.next = newNode; // Link the new node at the end
        length++;

        return head;
    }

    public Node insertAtPosition(Node head, int value, int position) {
        if(position < 0 || position > length) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        Node newNode = new Node(value);
        if(position == 0) {
            return insertAtBeginning(head, value);
        }
        Node current = head;
        for(int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        length++;
        return head;
    }

    public Node deleteAtPosition(Node head, int position) {
        if(position < 0 || position >= length) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if(position == 0) {
            return deleteAtBeginning(head);
        }
        Node current = head;
        for(int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        Node tempNode = current.next;
        current.next = current.next.next;
        tempNode.next = null; // Clear the reference to the deleted node
        length--;
        return head;
    }

    public Node deleteAtBeginning(Node head) {
        if(head == null) {
            return null; // List is empty
        }
        head = head.next; // Move head to the next node
        length--;
        return head;
    }

    public Node deleteAtEnd(Node head){
        if(head == null) {
            return null; // List is empty
        }
        if(head.next == null) {
            head = null; // If there's only one node, set head to null
        } else {
            Node current = head;
            while(current.next != null && current.next.next != null) {
                current = current.next; // Traverse to the second last node
            }
            current.next = null; // Remove the last node
        }
        length--;
        return head;
    }

    public Node reverseList(Node head){
        Node prevNode = head;
        Node currentNode = head.next;

        if(head == null || head.next == null) {
            return head;
        }

        while(currentNode != null){
            Node nextNode = currentNode.next; // Store the next node
            currentNode.next = prevNode; // Reverse the link
            prevNode = currentNode; // Move prevNode to the current node
            currentNode = nextNode; // Move to the next node
        }
        return prevNode; // New head of the reversed list
    }

    public void printList(Node head) {
        Node current = head;
        while(current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args){

        LLOperations ll = new LLOperations();
        ll.head = ll.insertAtBeginning(ll.head, 10);
        ll.head = ll.insertAtBeginning(ll.head, 20);
        ll.head = ll.insertAtBeginning(ll.head, 30);
        ll.head = ll.insertAtBeginning(ll.head, 40);
        ll.head = ll.insertAtBeginning(ll.head, 50);

        System.out.println("Linked List after insertions at beginning:");
        ll.printList(ll.head);

        ll.head = ll.insertAtEnd(ll.head, 60);
        System.out.println("Linked List after insertion at end:");
        ll.printList(ll.head);

        ll.head = ll.deleteAtBeginning(ll.head);
        System.out.println("Linked List after deletion at beginning:");
        ll.printList(ll.head);

        ll.head = ll.deleteAtEnd(ll.head);
        System.out.println("Linked List after deletion at end:");
        ll.printList(ll.head);

        // ll.head = ll.reverseList(ll.head);
        // System.out.println("Linked List after reversal:");
        // ll.printList(ll.head);
    }
}
