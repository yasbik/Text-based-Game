public class Monster {
    private String name;
    private int difficulty;
    private String elementWeakness;

    public Monster(int newDifficulty) {
        
        name = GameData.getMonsterNameByDifficulty(newDifficulty);
        difficulty = newDifficulty;
        elementWeakness = GameData.randomElement();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    
    public String getElementWeakness() {
        return elementWeakness;
    }

    public void setElementWeakness(String elementWeakness) {
        this.elementWeakness = elementWeakness;
    }


}
