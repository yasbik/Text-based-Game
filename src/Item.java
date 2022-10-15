public class Item {
    
    private String itemName;

    public Item() {
        itemName = GameData.getRandomItemName();
    }

    public String toString() {
        String s = "You see a " + itemName + " sitting in the corner.\n";
        return s;
    }

    public String getItemName() {
        return itemName;
    }
}
