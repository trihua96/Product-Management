package vn.funix.fx16573.csd201.asm;

import java.io.*;
import java.util.Scanner;

public class Asm2 {
    private static final String path = System.getProperty("user.dir") + "\\src\\";
    private static final String fileName = path + "Data.txt";
    private static final String fileNameConsole = path + "console_output.txt";
    private static final Scanner scanner = new Scanner(System.in);
    private static final OperationToProduct operaToProduct = new OperationToProduct();
    private static final MyList<Product> list = new MyList<Product>();
    private static final MyStack<Product> listStack = new MyStack<>();
    private static final MyQueue<Product> listQueue = new MyQueue<>();

    public static void main(String[] ars) throws FileNotFoundException {
            int choice;
            boolean mainLoopAgain = false;
            while (!mainLoopAgain) {

                try {

                    // Creating file output stream
                    FileOutputStream fos = new FileOutputStream(fileNameConsole, true);
                    PrintStream fileOut = new PrintStream(new MultiOutputStream(System.out, fos));

                    // Redirecting standard console output to a file.
                    System.setOut(fileOut);
                    while (true) {
                        // Display menu
                        displayMenu();

                        // Get choice
                        choice = Integer.parseInt(scanner.nextLine());

                        // Quit: choice equals 0
                        if (choice == 0) {
                            System.out.println(" Good bye, have a nice day!");
                            mainLoopAgain = true;
                            break;
                        }
                        try {
                            // Handle options
                            selectOptions(choice);

                        } catch (NumberFormatException ne) {
                            // Case User enter a String
                            System.out.println("Let's enter a number!");

                        } catch (Exception e) {
                            // Get Error from function selectOptions
                            System.out.println(e.getMessage());
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Let's enter a number!");
                }

            }
    }

    public static void displayMenu() {
        System.out.println("\n Choose your option:");
        System.out.println("  1. Read file and add to tail list");
        System.out.println("  2. Enter and add a product to the end of the linked list");
        System.out.println("  3. Display information of products in a linked list");
        System.out.println("  4. Write file from List");
        System.out.println("  5. Search product information by ID");
        System.out.println("  6. Remove product from the list by ID");
        System.out.println("  7. Sort products in LinkedList by ID");
        System.out.println("  8. Decimal Quantity of first product to binary by Recursion");
        System.out.println("  9. Read file and save to stack. Display stack");
        System.out.println("  10. Read file and save to queue. Display queue.");
        System.out.println("  0. Exit\n");
        System.out.print("  Your selection (0 -> 10): ");
    }

    public static void selectOptions(int choice) {
        switch (choice) {
            case 1:
                /**
                 *
                 *  Read file from file Data.TXT;
                 *
                 *  And add to tail Linked list
                 */
                operaToProduct.getAllItemsFromFile(fileName, list);

                break;
            case 2:
                /**
                 *  Add a product to tail Linked list
                 */
                operaToProduct.addLast(list, getInfoProduct());
                break;
            case 3:
                /**
                 *  Traversal over List and Display
                 */
                operaToProduct.displayAll(list);
                break;
            case 4:
                /**
                 *  Write file from data of list
                 */
                operaToProduct.writeAllItemsToFile(fileName, list);
                break;
            case 5:
                /**
                 * Seach info of product by code
                 */
                operaToProduct.searchByCode(list, getCodeToDo());
                break;
            case 6:
                /**
                 * Delete product by code LinkedList
                 */
                operaToProduct.deleteByCode(list, getCodeToDo());

                break;
            case 7:
                /**
                 * Sort product by code LinkedList
                 */
                // Check list is null
                if(list.getHead() == null) {
                    System.out.println("List is null can't Sort");
                    return;
                } else {
                    operaToProduct.sortByCode(list);
                    System.out.println("Sort SUCCESS!");
                }
                break;
            case 8:
                /**
                 * Convert Quantity of fist elemnt in list
                 * to  binary code LinkedList
                 */

                System.out.println("Quantity: " + getFirstQuatity() + " to Binary: "+ operaToProduct.convertToBinary(getFirstQuatity()));
                break;
            case 9:

                /**
                 *  Read file, add to Stack list
                 *  And display Stack list
                 */
                operaToProduct.getAllItemsFromFile(fileName, listStack);
                operaToProduct.displayAll(listStack);
                break;
            case 10:

                /**
                 *  Read file, add to Queue list
                 *  And display Queue list
                 */
                operaToProduct.getAllItemsFromFile(fileName, listQueue);
                operaToProduct.displayAll(listQueue);
                break;
            default:
                System.out.println("**Invalid choice. Try again.**");
        }
    }

    // Get info product from input values
    public static Product getInfoProduct() {

        // Init product object
        Product item;
        // To check info is not valid
        String bCode = "", title = "";
        Integer quantity = 0;
        double price = 0;

        boolean isValid = false;
        while(true) {
            try {
                System.out.println("+--- Add Info Product ---+");

                // Barcode
                while(true) {
                    try {
                        System.out.println("Enter Barcode: ");
                        bCode = scanner.nextLine();
                        
                        // Check input is Empty
                        if (bCode.isEmpty()) {
                            throw new Exception("Data is Empty!");
                        }
                        // Quit: Input is valid
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                // Title
                while (true) {
                    try {
                        System.out.println("Enter Title: ");
                        title = scanner.nextLine();
                        
                        // Check input is Empty
                        if (title.isEmpty()) {
                            throw new Exception("Data is Empty!");
                        }
                        // Quit: Input is valid
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                // Quantity
                while(true) {
                    try {
                        System.out.println("Enter Quantity: ");
                        quantity = Integer.parseInt(scanner.nextLine());
                        
                        // Quit: Input is valid
                        break;
                    } catch (Exception e) {
                        System.out.println("Quantity must be numeric!");
                    }
                }

                // Price
                while(true) {
                    try {
                        System.out.println("Enter Price: ");
                        price = Double.parseDouble(scanner.nextLine());
                        
                        // Quit: Input is valid
                        break;
                    } catch (Exception e) {
                        System.out.println("Price must be numeric!");
                    }
                }
                // Reassign boolean to check valid info
                isValid = true;
                // Add info to item product

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // Quit: if input valid for add info to product;
            if(isValid) {
                break;
            }
        }
        return (item = new Product(bCode, title, quantity, price));
    }

    // Get code from input
    public static String getCodeToDo() {
        String code = "";
        while(true) {
            try {
                // Get ID input
                System.out.println("Enter ID want to find: ");
                code = scanner.nextLine();
                // Check input is Empty
                if (code.isEmpty()) {
                    throw new Exception("Data is Empty!");
                }
                // Quit: Input is valid
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return code;
    }

    // Get Quatity of first element in list
    public static int getFirstQuatity() {
        return list.getHead().getInfo().getQuantity();
    }

    // printStream write to file and output console
    /**
     *  The code below I have referenced from the codeproject.com page
     *  Name author: Lodewijk Pool
     * */
    public static class MultiOutputStream extends OutputStream {
        OutputStream[] outputStreams;
        public MultiOutputStream(OutputStream... outputStreams)
        {
            this.outputStreams= outputStreams;
        }

        @Override
        public void write(int b) throws IOException
        {
            for (OutputStream out: outputStreams)
                out.write(b);
        }

        @Override
        public void write(byte[] b) throws IOException
        {
            for (OutputStream out: outputStreams)
                out.write(b);
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException
        {
            for (OutputStream out: outputStreams)
                out.write(b, off, len);
        }

        @Override
        public void flush() throws IOException
        {
            for (OutputStream out: outputStreams)
                out.flush();
        }

        @Override
        public void close() throws IOException
        {
            for (OutputStream out: outputStreams)
                out.close();
        }
    }
}
