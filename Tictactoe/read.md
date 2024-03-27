# Tic Tac Toe — Low Level Design

## The entities that will be involved in our game.
1. Cell -> The smallest unit in the game, representing an individual space on the game board. Each cell can be marked with either an ‘X’ or ‘O,’ denoting the CellType.
2. Board -> The core entity that comprises a 2D array of cells, forming the playable grid for the game. This board is central to various game operations and interactions.
3. Player -> An entity that encompasses the player’s name and the chosen symbol (e.g., ‘X’ or ‘O’). Additional attributes can be included as needed.
4. Game -> Used for Initializing the Game with all its properties.

## Let’s now consider creating a Class Diagram which show relationshi b/w classes
<imag src = "" width = "" height = "">

# Cell entity
A Cell is responsible for determining the symbol (‘X’ or ‘O’), and it’s further divided into two classes: CellX and CellO, both of which are subclasses of the Cell class means CellX and CellO is-a Cell class.

```
public class Cell {
   CellType cellType;
   Cell(CellType cellType){
       this.cellType = cellType;
   }
}
// Cell Class
```
```
public class CellX extends Cell{
    CellX(){
        super(CellType.X);
    }
}
```
```
public class CellO extends  Cell{
    CellO(){
        super(CellType.O);
    }
}
```

### CellType is a enum used to provide symbols.
```
public enum CellType {
    X,
    O
}
```

# Player entity
The Player entity includes a Cell means Player has-a Cell , indicating their chosen symbol (‘X’ or ‘O’), and has attributes for their name, along with corresponding getter and setter methods to access and modify name attribute.

```
public class Player {

    String name;
    Cell cellType;
    Player(String name,Cell cellType){
        this.name = name;
        this.cellType = cellType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCellType(Cell cellType) {
        this.cellType = cellType;
    }

    public Cell getCellType() {
        return cellType;
    }
}
```

# Board entity
Board is a entity having a Cell means board class has-a Cell entity used for creating a 2-D matrix of Cell datatype , having a size which can be added according to our requirement.

The Board class offers functions like:
-printBoard(): This function displays the current state of the board.
-addAtPosition(): It allows us to place 'X' or 'O' symbols at specific positions on the board.
-getFreeCells(): This function checks if there are any empty cells left on the board.

```
public class Board {

    public int size;
    public Cell[][] board;
    Board(int size){
        this.size = size;
        board = new Cell[size][size];
    }
    boolean getFreeCells(){
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                if(board[i][j] == null){
                    return true;
                }
            }
        }
        return false;
    }
    boolean addAtPostion(int x,int y,Cell cell){
        if(board[x][y] != null){
            return false;
        }
        board[x][y] = cell;
        return true;
    }
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].cellType.name() + "   ");
                } else {
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
```

## Game class
The Game class is designed with several key components:
-Game class has-a Board and Player as part of its internal structure.
-The startGame() function initiates the game.
-The isWinner() function is responsible for determining the game's winner.
-It employs a dequeue data structure to manage players, allowing for a turn-based rotation where players are removed from the front and added to the end of the dequeue, ensuring they get their turns.

```
import Model.*;
import java.util.*;

public class Game{

    public Deque<Player> players;
    public Board gameboard;
    public int rowarr[],  colarr[];
    public int dia, revdia;

    public Game(){
        players = new LinkedList<Player>();
        CellX cellX = new CellX();
        players.add(new Player("Player 1",cellX));

        CellO cellY = new CellO();
        players.add((new Player("Player 2",cellY)));
        gameboard = new Board(3);

        rowarr = new int[3];
        colarr = new int[3];
        dia = 0;
        revdia = 0;
    }

    public String startGame(){

        boolean isWinner = true;
        while(isWinner){
            Player playerturn = players.removeFirst();
            gameboard.printBoard();
            boolean freeCells = gameboard.getFreeCells();
            if(!freeCells){
                isWinner = false;
                continue;
            }

            System.out.print("Player " + playerturn.getName() + " Enter Position");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            boolean isValidPosition = gameboard.addAtPostion(inputRow,inputColumn,playerturn.cellType);

            if(!isValidPosition){
                System.out.println("Please Enter valid Position");
                players.addFirst(playerturn);
                continue;
            }
            players.addLast(playerturn);

            boolean iswinner = isWinner(inputRow, inputColumn, playerturn.getName());        // playerturn.cellType.cellType; for 1st commented function;
            if(iswinner){
                 return playerturn.name;
            }
        }
        return "Match Tie";
    }

    // public boolean isWinner(int row,int column,CellType cellType){                          // Time complexity of this fucntin is O(size);        
    //     boolean isrow = true, isColumn = true, isDiagonal = true, isAntiDiagonal = true;

    //     for(int i = 0;i<gameboard.size;i++){
    //         if(gameboard.board[row][i] == null || gameboard.board[row][i].cellType != cellType) isrow = false;
    //         if(gameboard.board[i][column] == null || gameboard.board[i][column].cellType != cellType) isColumn = false;
    //         if(gameboard.board[i][i] == null || gameboard.board[i][i].cellType != cellType)  isDiagonal = false;
    //         if(gameboard.board[i][gameboard.size - 1 - i] == null || gameboard.board[i][gameboard.size - 1 - i].cellType != cellType) isAntiDiagonal = false;
    //     }
    //     return isrow || isColumn || isDiagonal || isAntiDiagonal;
    // }

    public boolean isWinner(int row, int column, String name){                  // Time complexity of this fucntin is O(1);
           if(name == "Player 1"){
                rowarr[row]++; 
                colarr[column]++; 
                if(row == column) dia++;
                if(column == (gameboard.size - 1 - row)) revdia++;
           }
           else{
                rowarr[row]--; 
                colarr[column]--; 
                if(row == column) dia--;
                if(column == (gameboard.size - 1 - row)) revdia--;
            }
        
            if(Math.abs(rowarr[row]) == gameboard.size || Math.abs(colarr[column]) == gameboard.size || Math.abs(dia) == gameboard.size || Math.abs(revdia) == gameboard.size) return true;

            return false;
    }

}
```

## The main class serves as the entry point for starting the game and displaying the game result.
```
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        String result = game.startGame();
        if(result == "Tie"){
            System.out.println("Game is " +  result);
        }else{
            System.out.println("Winner is " + result);
        }

    }
}
```
