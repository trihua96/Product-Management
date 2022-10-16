package vn.funix.fx16573.csd201.asm;

/**

 * Generic version of the LinkedList class.

 *

 * @param <T> the type of the value

 */



public class MyList<T> {

    /**

     * Head node, default is null

     */

    private Node<T> head;



    /**

     * Tail node, default is null

     */

    private Node<T> tail;



    /**

     * Default constructor

     */

    public MyList() {
        this.head = this.tail = null;
    }



    /**

     * Constructor with head and tail

     *

     * @param head Head node of this list

     * @param tail Tail node of this list

     */

    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }



    /**

     * Checking if this list is empty

     *

     * @return true if list is empty

     */

    public boolean isEmpty() {
        return (this.head == null);
    }



    /**

     * Returning the length of this list

     *

     * @return The length of this list

     */

    public int length() {
        Node current = this.head;
        int length = 0;
        while(current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }



    /**

     * Insert an item to the head of this list

     *

     * @param item The item to be inserted

     */

    public void insertToHead(T item) {
        // New Node with item data
        Node<T> newNode = new Node<T>(item);

        // Check list is null
        if(isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        // Set head for new node if not null
        newNode.setNext(this.head);
        this.head = newNode;
    }



    /**

     * Insert an item to the head of this list

     *

     * @param item The item to be inserted

     */

    public void insertToTail(T item) {
        // New Node with item data
        Node<T> newNode = new Node<T>(item);

        // Check list is null
        if(isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        // Set tail for new node if not null
        this.tail.setNext(newNode);
        this.tail = newNode;
    }


    /**

     * Deleting the tail of this list

     */

    public void deleteTail() {

        // Check LinkedList is null then return
        if(isEmpty()){
            return;
        }

        // Check case List have a element
        if(this.head.getNext() == null) {
            // Delete head node
            this.head = this.tail = null;
            return;
        }

        // Traversal LinkedList
        for(Node currentNode = this.head; currentNode != null ; currentNode = currentNode.getNext()) {

            // Check next node = tail node to delete tail node
            if(currentNode.getNext() == this.tail) {
                // Delete tail node
                currentNode.setNext(null);
                // Update tail
                this.tail = currentNode;
                break;
            }
        }
    }


    /**

     * Searching and deleting an item from this list by comparing the ID of items

     * @param item The item to be deleted

     */

    public void deleteElement(T item) {

        // Dummy node with null value;
        Node<T> prev = new Node<T>(null);

        // Dummy node pointing to head node
        prev.setNext(this.head);

        // Next node that points ahead of current node
        Node<T> next = this.head.getNext();

        // Temporary node for traversal
        Node<T> temp = this.head;

        // Boolean value that checks whether value to be deleted exists or not
        boolean exists = false;

        // If head node needs to be deleted
        if(this.head.getInfo() == item) {
            this.head = this.head.getNext();
            // Node to be deleted exists
            exists = true;
            return;
        }

        // Iterating over LinkedList
        while(temp.getNext() != null) {
            // Comparing value of key and current node
            if(temp.getInfo().equals(item)) {
                // If node to be deleted is found previous
                // node now points to next node skipping the
                // current node
                prev.setNext(next);

                exists = true;

                break;
            }

            prev = temp;

            temp = temp.getNext();

            next = temp.getNext();
        }

        // Comparing the last node with the given key value
        if (exists == false && temp.getInfo().equals(item)) {
            // If found , last node is skipped over
            prev.setNext(null);
            // Node to be deleted exists
            exists = true;
        }

        if(exists) {

            System.out.println("Given ID is Deleted");
        }
    }

    /**

     * Searching item from this list by comparing the ID of items

     * @param item The product has been found
     */
    public void searchElement(T item) {
        // Display item;
        System.out.println(item);
    }


    /**

     * Swaping two nodes [firstNode] and [secondNode]

     *

     * @param firstNode

     * @param secondNode

     */

    public void swap(Node<T> firstNode, Node<T> secondNode) {
        if(firstNode == secondNode) return;
        Node<T> preFirstNode = null;
        Node<T> currentFirstNode = head;
        //Search for firstNode
        while(currentFirstNode != null && currentFirstNode != firstNode) {
            preFirstNode = currentFirstNode;
            currentFirstNode = currentFirstNode.getNext();
        }
        //Search for secondNode
        Node<T> preSecondNode = null;
        Node<T> currentSecondNode = head;
        while(currentSecondNode != null && currentSecondNode != secondNode) {
            preSecondNode = currentSecondNode;
            currentSecondNode = currentSecondNode.getNext();
        }
        //If either firstNode or secondNode is not present
        if(currentFirstNode == null || currentSecondNode == null) {
            return;
        }

        if(preFirstNode != null) {
            preFirstNode.setNext(currentSecondNode);
        } else {
            //preFirstNode = null-->currentFirstNode = head --> change head
            head = currentSecondNode;
        }
        if(preSecondNode != null) {
            preSecondNode.setNext(currentFirstNode);
        } else {
            //preSecondNode=null-->currentSecondNode = head --> changeHead
        }
        //Swap next pointers
        Node<T> temp = currentFirstNode.getNext();
        currentFirstNode = currentSecondNode.getNext();
        currentSecondNode.setNext(temp);
    }



    /**

     * Deleting all items in the list

     */

    public void clear() {
        // Head, Tail now points to null
        this.head = this.tail = null;
    }

    /**

     * Getter head & tail node

     */
    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }


    /**

     * Setter head & tail node

     */

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
}

