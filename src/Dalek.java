
/** This class models a Dalek in the game. A Dalek has
 *  a position and can advance towards the Doctor.
 */

public class Dalek {

    // Instance variables - row and col of the dalek
    private int row, col;
    
    // If the dalek has crashed into another dalek or doctor 
    private boolean hasCrashed;
    
    /**
     * Initializes the variables for a Dalek.
     *
     * @param theRow The row this Dalek starts at.
     * @param theCol The column this Dalek starts at.
     */
    
    public Dalek(int theRow, int theCol) {
        // Assigning the row to the instance variable
        this.row = theRow;
        
        // Assigning the col to the instance variable
        this.col = theCol;
        
    }

    /**
     * Attempts to move the Dalek towards the Doctor by the most direct route,
     * moving up, down, right, left or diagonally. For example, if the Doctor is
     * above and to the right of a Dalek, it will move diagonally. If the Doctor
     * is directly below a Dalek, it will move down.
     *
     * @param doc The Doctor to move towards.
     */
    
    public void advanceTowards(Doctor doc) {
        
        // If the doctor position on the row is greater than the dalek position on the row
        if (doc.getRow() > this.row){
            // Add one to the row (Move right)
            this.row++;
           
        // If the doctor position on the row is less than the dalek position on the row
        } else if (doc.getRow() < this.getRow()){
            // Subtract one from the row (Move Left)
            this.row--;
        
        // If the doctor position on the col is greater than the dalek position on the col
        }if (doc.getCol() > this.col){
            // Add one to the col (Move down)
            this.col++;
        
        // If the doctor position on the col is less than the dalek position on the col
        } else if (doc.getCol() < this.col){
            // Subtract one from the col (Move up)
            this.col--;
        }
    }

    /**
     * Returns the row of this Dalek.
     *
     * @return This Dalek's row.
     */
    
    public int getRow() {
        // Returning the row that the dalek is located at
        return this.row;
    }
    
    /**
     * Returns the column of this Dalek.
     *
     * @return This Dalek's column.
     */
    
    public int getCol() {
        // Returning the col that the dalek is located at
        return this.col;
    }
    
    /**
     * Sets the Dalek to be in a crashed state.
     */
    
    public void crash() {
        // If method is called (Daleks crashed) 
        // Return that hasCrashed is true
        this.hasCrashed = true;
    }
    
    /**
     * Returns whether or not this Dalek has crashed.
     *
     * @return true if this Dalek has crashed, false otherwise
     */
    
    public boolean hasCrashed() {
        // If the dalek's crashed
        if (this.hasCrashed == true){
            // Returning true
            return true;
        
        // If the dalek's did not crash
        }else{
            // Returning false
            return false;
        }
    }
}


