public class GameController {

    private static final int NUMBER_OF_LOCATIONS = 10;
    private Player currentPlayer;
    private Location[] map;
    private static GameController newGame;

    // main function
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

            // enter a location
            enterLocation(map[i]);

            // if player died, break the loop
            if (currentPlayer.getCurrentHP() <= 0) {
                break;
            }
            // otherwise go to the next location
            else {
                System.out.println("----- End of Location -----\n");
            }
        }

        System.out.println("\n" + currentPlayer.getName() + " was killed. ");
        System.out.println(currentPlayer.getItemsCollected());

        System.out.println("--- The End ---\n");
    }

    // method to simulate entering a location
    public void enterLocation(Location newLocation) {

        // temporary variables to help with processing
        int damage, damageBonus, totalDamage, damageTaken;
        String playerName = currentPlayer.getName();
        String monsterName = newLocation.getMonster().getName();

        // print location and monster information
        System.out.println(newLocation.toString(playerName));
        System.out.println(playerName + " encounters the " + monsterName + " with a weakness to " + newLocation.getMonster().getElementWeakness() + ".");

        // damage calculations
        damage = currentPlayer.damageDealt();
        damageBonus = currentPlayer.damageBonus(newLocation.getMonster().getElementWeakness());
        totalDamage = damage + damageBonus;
        damageTaken = newLocation.getMonster().getDifficulty();

        // if the player defeats the monster
        if (totalDamage >= newLocation.getMonster().getDifficulty()) {

            System.out.println(playerName + " defeats the " + monsterName + " dealing " + damage + " plus " + damageBonus + " from elemental items.");
            System.out.println(playerName + " steals the treasure " + newLocation.getTreasure().getItemName() + " of " + newLocation.getTreasure().getElement() + " from the " + newLocation.getName() + ".");

            // steal the treasure and add it to the loot bag
            currentPlayer.addItem(newLocation.stealTreasure());
        }
        // if the player can't defeat the monster
        else {
            // player takes damage
            currentPlayer.takeDamage(newLocation.getMonster().getDifficulty());

            System.out.println(playerName + " deals the " + monsterName + " " + damage + " plus " + damageBonus + " bonus but it is not enough.");
            System.out.println(playerName + " takes " + damageTaken + " from the " + monsterName + ".");

        }
    }
}
