public class StockArray {
    private StockItem[] stock;

    public StockArray(int length) {
        stock = new StockItem[length];
    }

    public void addNewStockItem(int index, String description, int price){
        try{
            stock[index] = new StockItem(description, price);
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("invalid index chosen: " + e.getMessage() );
        }
    }

    public int noOfStockItems(){
        return stock.length;
    }

    public void displayStockItem(int index){
        if(index < stock.length && index >= 0){
            if (stock[index] != null){
                System.out.println(stock[index].toString());
            }
        }
    }

    public void listAllStockItems(){
        for (int i = 0; i < stock.length; i++) {
            displayStockItem(i);
        }
    }

    public void updateStockLevel(int index, int amount){
        if(index < stock.length && index >= 0) {
            if (stock[index] != null) {
                stock[index].doDelivery(amount);
            }
        }
    }
}
