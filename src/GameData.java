// Game Data - Phase 3
// Returns a Random Location Name
// and contains the basic random number generator
public class GameData{
	 
	// ======== Source Words ========
	// Phase 0 - a random list of words to generate a random location 
	private static String[] locationAdjectives = {"Cold","Damp","Soggy","Hot","Dangerous","Dark","Bright","Cavernous"};
	private static String[] locationNouns = {"Cave","Hallway","Diner","Room"};

	// Phase 1 - a random list of words to generate a random name 
	private static String[] randomNames = {"Dylan", "Siddharth","Rajesh","Antony","Anuraj","Kazi","Abdul","Rutukumar","Jaysukhbhai","Achraf","Harshal","Dnyanesh","Chaahna","Puspakant","Md","Aranoor","Azad","Minjung","Mohammed","Salaheldin","Akashkumar","Sureshbhai","Minyao","Ravi","Suhjin","Tehillah","Tayyab","Habib","Young","Woong","Goransh","Chanbin","Wee","Heong","Tran","Anh","Khoa","Thi","Nguyet","Anh","Nilin","Saadman","Sachin","Ahmed","Chowdhury","Salman","Abdulkadir","Harsh","Dineshkumar","Ahmed","Moazzam","Chongrui","Muhammad","Jawadali","Hassanali","Mozammel","Yashkumar","Jagdishbhai","Jay","Hasmukhbhai","Yanju","Muhammad","Waleed","Khan","Dharmang","Vipin","Viki","Suresh","Mbonimana","Mirabel","Ogochukwu","Ritnesh","Ayush","Dilipkumar","Param","Janakkumar","Yash","Vipulkumar","Aniket","Vipulbhai","Samin","Yasar","Hemanshu","Abu","Yasin","Sahil","Sheikh","Mohammad","Tanvir","Haider","Jaspreet","Lingsheng","Chen-Hao","Shams"};

	//Phase 2
	// Generate a random item name
	private static String[] itemAdjectives = {"Magic","Antique","Smelly","Rusted","Broken","Fragile","Glowing","Strange","Flaming"};
	private static String[] itemNouns = {"Hammer","Shield","Helmet","Shoes","Sword"};

	// Phase 3
	// this list is sorted by difficulty
	private static String[] monsterList = {"Tiny Mouse","Lizard","Fierce Rabbit","Blob Monster","Angry Goblin","Zombie Monster","Goblin King","Giant Spider","Venomous Dinosaur"};
	private static String[] elements = {"Fire", "Water","Air","Earth"};
	// ======== Name Generators ========

	// Phase 3
	// This method returns names of monsters. 
	// The type of monster is determined by the difficulty of the location
	// we can use the difficulty as an index to get a monster from the list
	public static String getMonsterNameByDifficulty(int difficulty){
		String returnMonster = "Default Monster";
		if( difficulty >= 0 && difficulty < monsterList.length){
			returnMonster = monsterList[difficulty];
		}else{
			System.out.println("ERROR1: Monster index out of range " + difficulty);
		}
		return returnMonster;
	}

	public static String randomElement(){
		String returnElement = "";
		int index = randomRoll(0,elements.length);
		returnElement = elements[index];
		return returnElement;
	}

	// Phase 2
	public static String getRandomItemName(){
		int indexAdjective = randomRoll(0,itemAdjectives.length);
		int indexNoun = randomRoll(0,itemNouns.length);
		String returnName = itemAdjectives[indexAdjective] + " " + itemNouns[indexNoun];
		return returnName;
	}

	// Phase 1
	// Generate a random persons name from the list supplied above
	public static String getRandomName(){
		int index = randomRoll(0,randomNames.length);
		String name = randomNames[index];
		return name;
	}

	// Generates a random two word name for the Location and returns it. 
	// Sample names could include: "Cold Cave", "Damp Hallway", "Soggy Room" etc.
	public static String getRandomLocationName(){
		// randomly roll to get the adjective. 
		int indexAdjective = randomRoll(0, locationAdjectives.length);
		// randomly roll to get the noun. 
		int indexNoun = randomRoll(0, locationNouns.length);
		String returnName = locationAdjectives[indexAdjective] + " " + locationNouns[indexNoun];
		return returnName;
	}

	// ======== Utility Functions ========
	// Roll a random int between min (inclusive) and max (exclusive)
	public static int randomRoll(int min, int max){
		// max - min? what about negative

		double random = Math.random();

		int range = max - min;
		int randomNum = min + (int)(random * range);
		return randomNum;
	}
}