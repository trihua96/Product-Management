package vn.funix.fx16573.csd201.asm;


import java.util.NoSuchElementException;

/**

 * Generic version of the Queue class.

 *

 * @param <T> the type of the value

 */

public class MyQueue<T> {

    /**

     * Head node contains front node in the queue

     */

    private Node<T> head;

    /**

     * Tail node contains last node in the queue

     */

    private Node<T> tail;

    public MyQueue() {
        this.head = this.tail = null;
    }

    /**

     * Insert an item to the head of this list

     *

     * @param item The item to be inserted

     */
    public void enQueue(T item) {
        if(this.head == null) {
            this.head = this.tail = new Node<T>(item);
            return;
        }
        this.tail.setNext(new Node<T>(item));
        this.tail = this.tail.getNext();
    }

    // Delete node
    public T deQueue() {
        if(this.head == null) {
            throw new NoSuchElementException();
        }
       T item = this.head.getInfo();
        this.head = this.head.getNext();
        if(this.head == null) {
            this.tail = null;
        }
        return item;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
}


