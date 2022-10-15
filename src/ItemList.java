public class ItemList {

    private final int MAX_INVENTORY_SIZE = 10;

    private int currentItemCount;
    private Item[] itemList;
    private int counter;


    public ItemList() {
        currentItemCount = 0;
        itemList = new Item[MAX_INVENTORY_SIZE];
    }

    public void addItem(Item newItem) {
        itemList[currentItemCount] = newItem;
        currentItemCount++;
    }

    public String toString() {
        String s = new String();

        for (int i = 0; i < currentItemCount; i++) {
            s += itemList[i].getItemName() + "\n";
        }

        return s;
    }
    
}
