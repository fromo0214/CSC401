package Assignment_1.NKings;

public class Queen {
    //initializing variables for the board
     int row;
     int col;

    public Queen(){

    }

    //Creating a constructor
    public Queen(int row, int column){
        this.row = row;
        this.col = column;
    }

    public int calculateConflicts(Queen[] queens){
        int conflicts = 0;
        //Iterates through the board and calculates if there are any collisions between the queens 
        for(Queen queen : queens){
            if(queen != this && (queen.row==this.row || queen.col == this.col || Math.abs(queen.row - this.row) == Math.abs(queen.col - this.col))){
                conflicts++;
            }
        }
        return conflicts;
    }
    
}
