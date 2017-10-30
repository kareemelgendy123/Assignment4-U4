
import java.awt.Color;


/** This class models the Doctor in the game. A Doctor has
 *  a position and can move to a new position.
 */
public class Doctor {
    
    // Instance variables 
    // Row and col of the doctor
    private int row, col;
    
    /**
     * Initializes the variables for a Doctor.
     *
     * @param theRow The row this Doctor starts at.
     * @param theCol The column this Doctor starts at.
     */
    
    public Doctor(int theRow, int theCol) {
        
        // Assigning the row to the instance variable
        this.row = theRow;
        // Assigning the col to the instance variable
        this.col = theCol;
    }

    /**
     * Move the Doctor. If the player clicks on one of the squares immediately
     * surrounding the Doctor, the peg is moved to that location. Clicking on
     * the Doctor does not move the peg, but instead allows the Doctor to wait
     * in place for a turn. Clicking on any other square causes the Doctor to
     * teleport to a random square (perhaps by using a �sonic screwdriver�).
     * Teleportation is completely random.
     *
     * @param newRow The row the player clicked on.
     * @param newCol The column the player clicked on.
     */
    public void move(int newRow, int newCol){
        
        // Generating a random row on the board
        int randomRow = (int) (Math.random() * 12);
        // Generating a random column on the board
        int randomCol = (int) (Math.random() * 12);
        
        // If the doctor is going to move one spot around it's current position   
        if (this.row - newRow <= 1 && this.row - newRow >= -1 
         && this.col - newCol <= 1 && this.col - newCol >= -1){
            // Assign the position to its corresponding instance variable
            this.row = newRow;
            this.col = newCol;
        
        // If the user clicks on a spot further than 1 box away
        } else {
            // Assigning the random position to its corresponding instance variable
            this.row = randomRow;
            this.col = randomCol;
        }
    }

    
    /**
     * Returns the row of this Doctor.
     *
     * @return This Doctor's row.
     */
    
    public int getRow() {
        // Returning the row that the doctor is located at
        return this.row;
    }

    /**
     * Returns the column of this Doctor.
     *
     * @return This Doctor's column.
     */
    public int getCol() {
        // Returning the col that the doctor is located at
        return this.col;
    }

}
