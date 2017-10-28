/**
 * Train class for PPD test.
 * 
 * @author ENTER YOUR NAME HERE.
 * @version March 2009
 */
public class Train
{
    //Fields
    /* Destination of the Train */
    private String destination;

    /* Train number - identifies the Train */  
    private int TrainNumber;
    
    /* Capacity of the Train - how many customers can be in it */  
    private int capacity;
    
    /* Number of customers currently in the Train */      
    private int numberInTrain;
    
    /* Ticket price - how much a ticket costs. */
    private int ticketPrice;

    private int totalTakings;

    private Driver currentDriver;

    /** Constructor for Train
     * @param dest the destination of the Train
     * @param num the number of the Train
     * @param cap the capacity of the Train
     */
    public Train(String dest, int num, int cap, int price, String driverName, int driverId)
    {
        destination = dest;
        capacity = cap;
        TrainNumber = num;
        
        numberInTrain = 0;
        ticketPrice = price;
        totalTakings = 0;

        currentDriver = new Driver(driverName, driverId);
    }
   
    //mutators
    /* Records customer taking Train */
    public void enterTrain ()
    {
        if (numberInTrain < capacity) {
            numberInTrain = numberInTrain + 1;
            totalTakings = totalTakings + ticketPrice;
        }
    }

    /* Records customer leaving Train */
    public void leaveTrain ()
    {
        numberInTrain = numberInTrain - 1;
    }

    public int getTotalTakings(){
        return totalTakings;
    }
    public void resetTotalTakings(){
        totalTakings = 0;
    }
    public void setTicketPrice(int price){
        ticketPrice = price;
    }
}