
public class Board  {


    private int rows;
    private int cols;
    
    /** The grid of pieces */
    private Player[][] grid;
    
    

    public Board(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        grid = new Player[rows][cols];
        // set each cell of the board to null (empty).
        reset();

    }
    
    public void reset() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = null;
            }
        }
    }
    
    public int getRows() {
        return rows;
    }
    
    public int getCols() {
        return cols;
    }
    
    
    /**
    * Returns the Player whose piece occupies the given location, 
    * @param row int
    * @param col int
    */
    public Player getCell(int row, int col ) throws IndexOutOfBoundsException{
        if( (row < 0) || (col < 0) || (row >= rows) || (col >= cols) ) {
            throw new IndexOutOfBoundsException();
        } else {
            return grid[row][col];
        }
    }
    
    //returns true if there are no more plays left
    public boolean boardFilled(){
        for(int i = 0; i<rows; i++){
            for(int x =0; x<cols; x++){
                if(grid[i][x] == null){
                    return false;
                }
            }
        }
    return true;
    }

    // Returns true if move is possible given board state.  
    public boolean possibleMove(Move move) {
        for(int x =0; x<rows; x++){
            if(grid[x][move.getColumn()] == null){
                return true;
            }

        }
        return false;
    }
    
    // Adds a piece to the board for a given Move
    public void addPiece(Move move) {
        if(possibleMove(move)){
            for(int x = 0; x<rows; x++){
                if(grid[x][move.getColumn()] == null){
                    grid[x][move.getColumn()] = move.getPlayer();
                break;
            }
            }
        }
    }

    

    // if the board contains a winning position, returns the Player that wins.
    // Otherwise, returns null.  You could ignore lastMove.
    public Player winner(Move lastMove) {
        // TODO: write this.  Currently, there is never a winnder.
        return null;
    }
    
    
} // end Board class
