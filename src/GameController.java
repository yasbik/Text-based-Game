public class GameController {

    private static final int NUMBER_OF_LOCATIONS = 10;
    private Player currentPlayer;
    private Location[] map;
    private static GameController newGame;

    
    public static void main(String[] args) throws Exception {

        newGame = new GameController();
        newGame.initializeMap(NUMBER_OF_LOCATIONS);
        newGame.startGame();
        
    }

    // method to create and fill location array
    public void initializeMap(int numberOfLocations) {
        
        currentPlayer = new Player();

        // create location array
        map = new Location[NUMBER_OF_LOCATIONS];
        

        // fill array with locations
        for (int i = 0; i < NUMBER_OF_LOCATIONS; i++) {
            map[i] = new Location();
        }
    }

    // method that handles output
    public void startGame() {

        // print player information
        System.out.println(currentPlayer.toString());

        // print map information
        for (int i = 0; i < NUMBER_OF_LOCATIONS; i++) {

            enterLocation(map[i]);

            if (currentPlayer.getCurrentHP() <= 0) {
                break;
            }
            else {
                System.out.println("----- End of Location -----\n");
            }
        }

        System.out.println("\n" + currentPlayer.getName() + " was killed. ");
        System.out.println(currentPlayer.getItemsCollected());

        System.out.println("--- The End ---\n");
    }

    public void enterLocation(Location newLocation) {

        int damage, damageBonus, totalDamage, damageTaken;
        String playerName = currentPlayer.getName();
        String monsterName = newLocation.getMonster().getName();

        System.out.println(newLocation.toString(playerName));

        System.out.println(playerName + " encounters the " + monsterName + " with a weakness to " + newLocation.getMonster().getElementWeakness() + ".");

        damage = currentPlayer.damageDealt();
        damageBonus = currentPlayer.damageBonus(newLocation.getMonster().getElementWeakness());

        totalDamage = damage + damageBonus;

        damageTaken = newLocation.getMonster().getDifficulty();

        if (totalDamage >= newLocation.getMonster().getDifficulty()) {

            System.out.println(playerName + " defeats the " + monsterName + " dealing " + damage + " plus " + damageBonus + " from elemental items.");

            System.out.println(playerName + " steals the treasure " + newLocation.getTreasure().getItemName() + " of " + newLocation.getTreasure().getElement() + " from the " + newLocation.getName() + ".");

            currentPlayer.addItem(newLocation.stealTreasure());

        }
        else {
            currentPlayer.takeDamage(newLocation.getMonster().getDifficulty());

            System.out.println(playerName + " deals the " + monsterName + " " + damage + " plus " + damageBonus + " bonus but it is not enough.");

            System.out.println(playerName + " takes " + damageTaken + " from the " + monsterName + ".");

        }



    }

}
