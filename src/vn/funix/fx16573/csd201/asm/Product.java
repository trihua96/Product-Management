package vn.funix.fx16573.csd201.asm;

/**

 * Product class

 */

public class Product {
    private String bcode;
    private String title;
    private int quantity;
    private double price;

    /**

     * Default constructor

     */

    public Product() {

    }

    /**

     * Constructor method to initialize a product

     *

     * @param bcode    Product's bar code

     * @param title    Product's title

     * @param quantity Product's quantity

     * @param price    Product's price

     */

    public Product(String bcode, String title, Integer quantity, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }


    // Getter & Settter
    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**

     * Convert this product to String for printing

     */

    @Override

    public String toString() {
        return String.format("%10s | %17s | %12d | %5.3f%n", this.bcode, this.title, this.quantity, this.price);
    }

}

