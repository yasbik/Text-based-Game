public class Location {
  
  final int MIN_DIffiCULtY = 2;
  final int MAX_DIFFICULTY = 8;
  
  private String name;
  private int difficulty;
  private Item treasure;
  private Monster monster;


  public Location() {
    name = GameData.getRandomLocationName();
    difficulty = GameData.randomRoll(MIN_DIffiCULtY, MAX_DIFFICULTY);
    treasure = new Item();
    monster = new Monster(difficulty);
  }

  public Monster getMonster() {
    return monster;
  }

  public String getName() {
    return name;
  }

  public String toString(String name) {
    String s = name + " enters a " + this.name + ".\n"; 

    // check if there is a treasure
    if (hasTreasure()) {
      s += treasure.toString(name);
    }

    s += "There is a " + monster.getName() + " guarding the treasure.";

    return s;
  }

  public boolean hasTreasure() {
    return treasure != null;
  }

  public Item getTreasure() {
    return treasure;
  }

  public Item stealTreasure() {
    Item temp = treasure;
    treasure = null;
    return temp;
  }
}

