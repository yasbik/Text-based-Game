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

            System.out.println(map[i].toString());

            if (map[i].hasTreasure()) {
                currentPlayer.addItem(map[i].stealTreasure());
            }
        }

        System.out.println(currentPlayer.getItemsCollected());

        System.out.println("--- The End ---");
    }
}
