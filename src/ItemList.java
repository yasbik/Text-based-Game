public class ItemList {

    private final int MAX_INVENTORY_SIZE = 10;

    private int currentItemCount;
    private Item[] itemList;

    public ItemList() {
        currentItemCount = 0;
        itemList = new Item[MAX_INVENTORY_SIZE];
    }

    public void addItem(Item newItem) {
        itemList[currentItemCount] = newItem;
        currentItemCount++;
    }

    public int itemCount() {
        return currentItemCount;
    }

    public ItemList getItemListWithElement(String element) {

        ItemList newList = new ItemList();

        for (int i = 0; i < currentItemCount; i++) {
            if (itemList[i].hasElement(element)) {
                newList.addItem(itemList[i]);
            }
        }

        return newList;
    }

    public String toString() {
        String s = new String();

        for (int i = 0; i < currentItemCount; i++) {
            s += itemList[i].getItemName() + "\n";
        }

        return s;
    }
    
}
