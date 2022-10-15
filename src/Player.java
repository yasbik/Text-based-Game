public class Player {

  private final int STARTING_HP = 10;

  private String name;
  private int currentHP;
  private ItemList inventory;

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

  public void addItem(Item newItem) {
    inventory.addItem(newItem);
  }

  public String getItemsCollected() {
    String s = "\nYou made it to the end. Your loot bag contains:\nCurrent Items:\n";

    s += inventory.toString();
    s += "\n";

    return s;
}

  public String toString() {
    String s = "--------------------\nCurrent Player: " + name + "\nCurrent HP: " + currentHP + "\n--------------------";
    return s;
  }
}
