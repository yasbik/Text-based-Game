public class Player {

  private final int STARTING_HP = 10;
  private final int MIN_DAMAGE = 1;
  private final int MAX_DAMAGE = 8;

  private String name;
  private int currentHP;
  private ItemList inventory;

  public ItemList getItemList() {
    return inventory;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }

  public void setCurrentHP(int currentHP) {
    this.currentHP = currentHP;
  }

  public int getCurrentHP() {
    return currentHP;
  }

  public Player() {
    name = GameData.getRandomName();
    currentHP = STARTING_HP;
    inventory = new ItemList();
  }

  public int damageDealt() {
    return GameData.randomRoll(MIN_DAMAGE, MAX_DAMAGE);
  }

  public int damageBonus(String element) { 
    ItemList newList = inventory.getItemListWithElement(element);
    return newList.itemCount();
  }

  public void takeDamage(int damageAmount) {
    currentHP -= damageAmount;
  }

  public void addItem(Item newItem) {
    inventory.addItem(newItem);
  }

  public String getItemsCollected() {
    String s = name + "'s loot bag contains:\nCurrent Items:\n";

    s += inventory.toString();
    s += "\n";

    return s;
}

  public String toString() {
    String s = "--------------------\nCurrent Player: " + name + "\nCurrent HP: " + currentHP + "\n--------------------";
    return s;
  }
}
