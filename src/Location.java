public class Location {
  
  final int MIN_DIffiCULtY = 2;
  final int MAX_DIFFICULTY = 8;
  
  private String name;
  private int difficulty;
  private Item treasure;


  public Location() {
    name = GameData.getRandomLocationName();
    difficulty = GameData.randomRoll(MIN_DIffiCULtY, MAX_DIFFICULTY);
    treasure = new Item();
  }

  public String toString() {
    String s = "You enter a " + name + ".\n"; 

    // check if there is a treasure
    if (hasTreasure()) {
      s += treasure.toString();
    }

    return s;
  }

  public boolean hasTreasure() {
    return treasure != null;
  }

  public Item stealTreasure() {
    Item temp = treasure;
    treasure = null;
    return temp;
  }
}

