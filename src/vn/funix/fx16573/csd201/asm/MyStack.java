package vn.funix.fx16573.csd201.asm;

import java.util.NoSuchElementException;

/**

 * Generic version of the Stack class.

 *

 * @param <T> the type of the value

 */


public class MyStack<T> {

    /**

     * Head node contains front node in the stack

     */

    private Node<T> head;

    /**

     * Insert an item to the head of this list

     *

     * @param item The item to be inserted

     */
    public void push(T item) {
        this.head = new Node<T>(item, this.head);
    }

    // Delete head node of stack LinkedList
    public T pop() {
        if(this.head == null) {
            throw new NoSuchElementException();
        }

        Node<T> temp = this.head;
        this.head = this.head.getNext();
        return temp.getInfo();
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}

