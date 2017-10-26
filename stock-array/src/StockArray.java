public class StockArray {
    private StockItem[] stock;

    public StockArray(int length) {
        stock = new StockItem[length];
    }

    public void addNewStockItem(int index, String description, int price){
        if (index < stock.length && index >= 0){
            stock[index] = new StockItem(description, price);
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
