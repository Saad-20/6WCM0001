import java.util.Scanner;

public class StockArrayTest {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean wait = true;
    private static boolean[] tests;

    public static void main(String[] args){
        StockArray myStock = new StockArray(5);
        parseArgs(args);
        testAddNewStockItem(myStock);
        waitForNextLine();
        testNoOfStockItems(myStock);
        waitForNextLine();
        testDisplayStockItem(myStock);
        waitForNextLine();
        testUpdateStockLevel(myStock);
        testListAllStockItems(myStock);
        waitForNextLine();
        return;
    }
    private static void testAddNewStockItem(StockArray a){
        System.out.println("Testing addNewStockItem");
        System.out.println("Adding 2 new stock items to the StockArray (output should be blank)");
        a.addNewStockItem(3, "Beans", 60);
        a.addNewStockItem(1, "Bread", 100);
        System.out.println("We haven't crashed...");
    }

    private static void testNoOfStockItems(StockArray a){
        System.out.println("Testing noOfStockItems");
        System.out.println("Length of the StockArray (5): " + a.noOfStockItems());
        System.out.println("We haven't crashed...");
    }

    private static void testDisplayStockItem(StockArray a){
        System.out.println("Testing displayStockItem");
        System.out.print("index 3 (expected Beans): ");
        a.displayStockItem(3);
        System.out.print("index 1 (expected Bread): ");
        a.displayStockItem(1);
        System.out.println("index 0 (expect nothing): ");
        a.displayStockItem(0);
        System.out.println("index -1 (expect nothing): ");
        a.displayStockItem(-1);
        System.out.println("index 6 (expect nothing): ");
        a.displayStockItem(6);
        System.out.println("We haven't crashed...");
    }

    private static void testUpdateStockLevel(StockArray a){
        System.out.println("Testing updateStockLevel");
        System.out.println("index 3, adding 5 stock");
        a.updateStockLevel(3, 5);
        System.out.println("index -1, adding 10 stock");
        a.updateStockLevel(-1, 10);
        System.out.println("index 0, adding 200 stock");
        a.updateStockLevel(0, 200);
        System.out.println("index 2953, adding 30 stock");
        a.updateStockLevel(2953, 30);
    }

    private static void testListAllStockItems(StockArray a){
        System.out.println("Testing listAllStockItems");
        a.listAllStockItems();
        System.out.println("We haven't crashed...");
    }
    private static void waitForNextLine(){
        if (wait){
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
        }
    }

    private static void parseArgs(String[] args) {
        for (String s : args) {
            if (s.equals("-y")) {
                wait = false;
            } else if (s.equals("-h")) {
                System.out.println("Usage: java StockArrayTest [OPTIONS]");
                System.out.println("StockArray Test, a set of test routines for the StockArray Class from the 6WCM0001 Module, part of the University of Hertfordshire Computer Science MSc Program");
                System.out.println("The StockArray class file must be in the same directory as this class file");
                System.out.println("Arguments (must be separate):");
                System.out.println("-h          Prints this help and exits");
                System.out.println("-y          Runs through the program without pausing");
                System.exit(0);
            }
        }
    }
}
