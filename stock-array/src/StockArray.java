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


}
