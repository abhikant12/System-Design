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
