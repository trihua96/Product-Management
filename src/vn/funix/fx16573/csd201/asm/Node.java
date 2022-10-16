package vn.funix.fx16573.csd201.asm;



/**

 * Generic version of the Node class.

 *

 * @param <T> the type of the value

 */

public class Node<T> {



    /**

     * The info of this node

     */

    private T info;



    /**

     * The next node

     */

    private Node next;



    /**

     * Default constructor

     */

    public Node() {

    }



    /**

     * Constructor with info and next node

     *

     * @param info The info of this node

     * @param next The next Node of this node

     */

    public Node(T info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(T info) {
        this(info,null);
    }


    /**

     * Overriding to convert this node to String

     */

    @Override

    public String toString() {
        return "" + this.info;
    }


    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
