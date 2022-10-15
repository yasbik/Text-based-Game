public class Item {
    
    private String itemName;
    private String element;

    public Item() {
        itemName = GameData.getRandomItemName();
        element = GameData.randomElement();
    }

    public boolean hasElement(String element) {
        return this.element.equals(element);
    }

    public String toString(String name) {
        String s = name + " sees a " + itemName + " sitting in the corner.\n";
        return s;
    }

    public String getItemName() {
        return itemName;
    }

    public String getElement() {
        return element;
    }
}
