package Model;

public class Board{
    public int size;
    public Cell board[][];

    public Board(int size){
        this.size = size;
        board = new Cell[size][size];
    }

    public boolean getFreeCells(){
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                if(board[i][j] == null){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addAtPostion(int x,int y,Cell cell){
        if(x < 0 || y < 0 || x >= size || y >= size || board[x][y] != null) return false;
        board[x][y] = cell;
        return true;
    }

    public void printBoard(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] != null) System.out.print(board[i][j].cellType.name());     
                else System.out.print(" ");
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

}
