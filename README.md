## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

---

# About the Project

This Java project simulates a simple text-based game implementing a set of related classes of objects:
•	GameController: This contains the main structure of our project and runs the main logic loop and printing the output to the console. 
•	Location: A single room or space in our map. Has a name and difficulty. Eventually will hold an item and monster.  
•	Player: The hero of our story. The main character and player avator. The player class contains stats and game state information about the Player. 
•	Item: An item found in our journey.
•	Monster: An adversary encountered in the dungeon. If you defeat the monster you get the Item in the Location
•	GameData: This class will be provided and gives you some static methods to generate random names and numbers. 
