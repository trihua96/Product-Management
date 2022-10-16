package vn.funix.fx16573.csd201.asm;

import java.io.*;
import java.util.Arrays;

/**

 * This class manages all functions relate to the product

 */

public class OperationToProduct {

    /**
     * Reading all products from the file and insert them to the list at tail.
     *
     * @param fileName The file name of the file
     * @param list     The Linked List contains all products that read from file
     */

    public void getAllItemsFromFile(String fileName, MyList<Product> list) {
        // Init product to add list
        Product item;
        try {
            // Creating file Reader
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            // Store each line in file
            String line = "";



            boolean checkFinish = false;    // Check to alert add list finish
            while(true) {
                // Get list to check id
                Node<Product> current = list.getHead();
                // Read file each line
                line = br.readLine();
                if(line == null) {
                    break;
                }

                // Cut values of a line by | in text;
                String[] templates = line.split("\\|");

                // Get barcode with delete space
                String bcode = templates[0].trim();
                // Get title
                String title = templates[1].trim();
                // Get quantity
                Integer quantity = Integer.parseInt(templates[2].trim());
                // Get barcode
                Double price = Double.parseDouble(templates[3].trim());

                // Update templates to Product
                item = new Product(bcode,title,quantity,price);

                // This value to Check Id is duplicate
                boolean checkId = true;
                // Check list is null
                if(current == null) {
                    // Add to list
                   list.insertToTail(item);

                   checkId = false; // This case avoid Id added again
                }

                // Check List each readLine file
                while(current != null) {
                    // If Id in file = Id in list
                    if (current.getInfo().getBcode().equals(item.getBcode())) {
                        // Display Id already exist
                        System.out.println("ID " + item.getBcode() + " available in list!");
                        checkId = false;    // Not add in list
                    }
                    current = current.getNext();

                }
                // If check id true then add in list
                if (checkId) {
                    list.insertToTail(item);    // Add to tail list
                    checkFinish = true;
                }
            }
            // Add to list Succuss if have any item added
            if(checkFinish) {
                System.out.println("Read file & Add product to tail list:\n\t--- SUCCESS! ---");
            } else {
                // This case data in file null
                if(br.readLine() == null) throw new Exception("Data unavailable in file!");
                // This case item have ID duplicate all on list
                throw new Exception("All Id in file duplicates in the list");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Reading all products from the file and insert them to the stack.
     *
     * @param fileName The file name of the file
     * @param stack    The Stack contains all products that read from file
     */

    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
        Product item;
        try {
            // Creating file reader
            FileReader freader = new FileReader(fileName);
            BufferedReader bw = new BufferedReader(freader);

            // Traversal over File
            while(true) {
                // Get each line in file
                String line = bw.readLine();

                // line in file is null
                if(line == null) {
                    break;
                }

                // Cut values of a line by |
                // After get each element add in product;
                String[] templates = line.split("\\|");

                // Get barcode
                String bcode = templates[0].trim();
                // Get title
                String title = templates[1].trim();
                // Get quantity
                Integer quantity = Integer.parseInt(templates[2].trim());
                // Get price
                Double price = Double.parseDouble(templates[3].trim());

                // Create Product
                item = new Product(bcode, title, quantity, price);

                // Add to stack list
                stack.push(item);
            }
            System.out.println("SUCCESS add file to stack LinkedList!");
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Reading all products from the file and insert them to the queue.
     *
     * @param fileName The file name of the file
     * @param queue    The Queue contains all products that read from file
     */

    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) {
        Product item;
        try {
            // Creating file Reader
            FileReader freader = new FileReader(fileName);
            BufferedReader bw = new BufferedReader(freader);

            // Traversal over File
            while(true) {
                String line = bw.readLine();
                // line in file is null
                if(line == null) {
                    break;
                }
                // Cut values of a line by space;
                String[] templates = line.split("\\|");

                // Get barcode
                String bcode = templates[0].trim();
                // Get title
                String title = templates[1].trim();
                // Get quantity
                Integer quantity = Integer.parseInt(templates[2].trim());
                // Get price
                Double price = Double.parseDouble(templates[3].trim());

                // Create Product
                item = new Product(bcode, title, quantity, price);

                // Add to queue list
                queue.enQueue(item);
            }

            System.out.println("SUCCESS add file to stack LinkedList!");
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Adding a product to the list, info of the product input from keyboard.
     *
     * @param list The Linked list
     */

    public void addLast(MyList<Product> list, Product item) {

        // Get list to check id
        Node<Product> current = list.getHead();

        boolean checkId = true; // Variable to check id
        // Traversal id over list
        while (current != null) {
            // Check if id item = id in list that can't be added to list
            if(current.getInfo().getBcode().equals(item.getBcode()))
                checkId = false;

            // Next node
            current = current.getNext();
        }

        if(checkId) {
            // Add item to tail if id valid
            list.insertToTail(item);
            System.out.println("Add product to tail list:\n\t--- SUCCESS! ---");
        } else {
            System.out.println("ID available, can't be added!");
        }
    }


    /**
     * Printing all prodcuts of the list to console screen
     *
     * @param list
     */

    public void displayAll(MyList<Product> list) {
        // Get head node in list
        Node<Product> current = list.getHead();
        // Check List is null
        if(current == null) {
            System.out.println("List is null!");
            return;
        }

        // Display title product
       displayTitleProduct();
        // Traversal list to display product
        while(current != null) {
            // Display product
            System.out.println(current);

            current = current.getNext();
        }
    }
    /**
     * Printing all prodcuts of the Stack list to console screen
     *
     * @param listStack
     */

    public void displayAll(MyStack<Product> listStack) {

        Node<Product> current = listStack.getHead();

        // Check Stack List is null
        if(current == null) {
            System.out.println("List Stack is null!");
            return;
        }
        // Display title product
        displayTitleProduct();
        // Traversal stack list to display product
        while(current != null) {
            // Display product
            System.out.println(current);
            // Next node
            current = current.getNext();
        }
    }
    /**
     * Printing all prodcuts of the Queue list to console screen
     *
     * @param listQueue
     */

    public void displayAll(MyQueue<Product> listQueue) {
        Node<Product> current = listQueue.getHead();

        // Check Queue List is null
        if(current == null) {
            System.out.println("List Queue is null!");
            return;
        }
        // Display title product
        displayTitleProduct();
        // Traversal Queue list to display product
        while(current != null) {
            // Display product in list
            System.out.println(current);
            // Write console to file
            current = current.getNext();
        }
    }


    /**
     * Writing all products from the list to the file
     *
     * @param fileName Input file name
//     * @param list     Input Linked list
     */

    public void writeAllItemsToFile(String fileName, MyList<Product> list) {
        // Create a temp store a head node
        Node<Product> current = list.getHead();
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            while(current != null) {
                // Write a product to file
                bw.write(String.valueOf(current));
                // Next node
                current = current.getNext();
            }
            System.out.println("Write SUCCESS to Data.txt file!");
            bw.flush();
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    /**
     * Searching product by ID input from keyboard.
     *
     * @param list
     */

    public void searchByCode(MyList<Product> list, String code) {

        // current node for traversal
        Node<Product> current = list.getHead();

        if(current == null) {
            System.out.println("List is null");
            return;
        }
        // Display info title of product
        displayTitleProduct();
        while(current != null) {
            // Check barcode = code want to search
            if(current.getInfo().getBcode().equals(code)) {
                // Handle that node with code need search
                list.searchElement(current.getInfo());
                return;
            }
            current = current.getNext();
        }

        // If Id is Unavailable in list
        System.out.println(-1 + " Not found!");
    }


    /**
     * Deleting first product that has the ID input from keyboard from the list.
     *
     * @param list
     */

    public void deleteByCode(MyList<Product> list, String code) {
        Node<Product> current = list.getHead();

        // Check Node head is null
        if(current == null) {
            System.out.println("List is null");
            return;
        }

        while(current != null) {

            // Check bcode = code input
            if(current.getInfo().getBcode().equals(code)) {
                list.deleteElement(current.getInfo());
                return;
            }
            current = current.getNext();
        }
        System.out.println("Given ID is not present in linked list");
    }


    /**
     * Sorting products in linked list by ID
     *
     * @param list The Linked list
     */
    public void sortByCode(MyList<Product> list) {

        MyList<Product> listSmaller = new MyList<>();
        MyList<Product> listGreater = new MyList<>();
        Node<Product> flag, pointer;
        if (list.getHead() == list.getTail()) return;
        flag = list.getHead();
        list.setHead(list.getHead().getNext());
        flag.setNext(null);

        // partition elements for each list(smaller, greater)
        while(list.getHead()!=null){
            pointer = list.getHead();
            list.setHead(list.getHead().getNext());
            pointer.setNext(null);

            // Compare ID to sort elements in list
            // If pointer <= Flag sort element to listSmaller else to listGreater
            if (pointer.getInfo().getBcode().compareTo(flag.getInfo().getBcode()) <= 0) listSmaller.insertToTail(pointer.getInfo());
            else listGreater.insertToTail(pointer.getInfo());
        }

        // Recursion to sort each list(smaller, greater)
        sortByCode(listSmaller);
        sortByCode(listGreater);

        // If listSmaller is not null, set head node of listSmaller to myList
        // Else set head is flag
        if (listSmaller.getHead() !=null){
            list.setHead( listSmaller.getHead());;
            // Connect tail list smaller to flag
            listSmaller.getTail().setNext(flag);
        } else list.setHead(flag);

        // Connect to list greater
        flag.setNext(listGreater.getHead());

        // If list greater is not null, set tail myList is tail of list greater
        if(listGreater.getHead() !=null) list.setTail(listGreater.getTail());
        else list.setTail(flag);    // List greater is null, set tail myList is flag

    }


    /**
     * Convert a decimal to a integer number. Example: input i = 18 -> Output = 10010
     *
     * @param decimalNumber Input decimal number
     * @return a integer numbers
     */

    public int convertToBinary(int decimalNumber) {
        if (decimalNumber == 0)
            return 0;
        return (decimalNumber % 2 + 10 * convertToBinary(decimalNumber / 2));
    }

    public void displayTitleProduct() {
        System.out.printf("%10s | %17s | %12s | %5s%n", "Barcode", "Title", "Quantity", "Price");
        System.out.println("\t-----------------------------------------------");
    }
}