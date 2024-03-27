package Model;

public class Player{
    public String name;
    public Cell cellType;
    public Player(String name, Cell cellType){
        this.name = name;
        this.cellType = cellType;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Cell getCellType(){
        return cellType;
    }
    public void setCellType(Cell cellType){
        this.cellType = cellType;
    }
}
