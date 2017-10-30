
import java.awt.Color;

/** This class manages the interactions between the different pieces of
 *  the game: the Board, the Daleks, and the Doctor. It determines when
 *  the game is over and whether the Doctor won or lost.
 */ 
public class CatchGame {

    /**
     * Instance variables go up here
     * Make sure to create a Board, 3 Daleks, and a Doctor
     */
    
    // Creating the board
    private Board b = new Board(12, 12);
    
    // Doctor
    // Randomly generating a position for the doctor on the board
    private Doctor doc = new Doctor ((int)(Math.random()*12), (int)(Math.random()*12));
      
    // dalekOne
    // Randomly generating a position for the first dalek on the board
    private Dalek dalekOne = new Dalek ((int)(Math.random()*12), (int)(Math.random()*12));
     
    // dalekTwo
    // Randomly generating a position for the second dalek on the board
    private Dalek dalekTwo = new Dalek ((int)(Math.random()*12), (int)(Math.random()*12));
     
    // dalekThree
    // Randomly generating a position for the third dalek on the board
    private Dalek dalekThree = new Dalek ((int)(Math.random()*12), (int)(Math.random()*12));
    
    /* 
     * The constructor for the game. 
     * Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    
    public CatchGame(){
        
        // Drawing the Doctor
        b.putPeg(Color.green,doc.getRow(),doc.getCol());
        
        // Drawing the Daleks
        b.putPeg(Color.black,dalekOne.getRow(),dalekOne.getCol()); // First Dalek
        b.putPeg(Color.black,dalekTwo.getRow(),dalekTwo.getCol()); // Second Dalek
        b.putPeg(Color.black,dalekThree.getRow(),dalekThree.getCol()); // Third Dalek
    }
    
    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    
    public void playGame() {
        
        // Boolean variable that determines whether the game is done or not
        boolean status = true;

        ///////////////////////////////MAIN LOOP////////////////////////////////
        // While status is true, the game continues running
        // If status is false, then end game
        while (status) {
            
            // Getting click from user
            Coordinate click = b.getClick();
            
            // Removing the old doctor peg
            b.removePeg(doc.getRow(), doc.getCol());
                        
            // Moving the doctor to the position clicked
            doc.move(click.getRow(), click.getCol());
            
            // Placing the new doctor peg on the clicked position
            b.putPeg(Color.green, doc.getRow(), doc.getCol());
            
        /////////////////////// MOVEMENT OF THE DALEKS /////////////////////////
            // Movement of dalekOne
            if (dalekOne.hasCrashed() == false){
                
                // Removing the old peg
                b.removePeg(dalekOne.getRow(), dalekOne.getCol());
                
                // Moving dalekOne closer to the doctor
                dalekOne.advanceTowards(doc);
                
                // Putting the new peg
                b.putPeg(Color.black, dalekOne.getRow(), dalekOne.getCol());
            }
            
            // Movement of dalekTwo
            if (dalekTwo.hasCrashed() == false){
                
                // Removing the old peg
                b.removePeg(dalekTwo.getRow(), dalekTwo.getCol());
                
                // Moving the dalekTwo closer to the doctor
                dalekTwo.advanceTowards(doc);
                
                // Putting the new peg
                b.putPeg(Color.black, dalekTwo.getRow(), dalekTwo.getCol());
            }
            
            // Movement of dalekThree
            if (dalekThree.hasCrashed() == false){
                
                // Removing the old peg
                b.removePeg(dalekThree.getRow(), dalekThree.getCol());
                
                // Moving the dalekThree closer to the doctor
                dalekThree.advanceTowards(doc);
               
                // Putting the new peg
                b.putPeg(Color.black, dalekThree.getRow(), dalekThree.getCol());
            }
            
            /////////////////////DALEK MOVEMENT AFTER CRASH/////////////////////
                        
            // If dalekTwo and dalekThree crash - dalekOne moves
            if (dalekTwo.hasCrashed() && dalekThree.hasCrashed()) {

                // Only dalekOne advances
                // Removing the old peg
                b.removePeg(dalekOne.getRow(), dalekOne.getCol());
                
                // Moving towards the doctor 
                dalekOne.advanceTowards(doc);
                
                // Placing the new peg
                b.putPeg(Color.black, dalekOne.getRow(), dalekOne.getCol());
            }
            
            // If dalekOne and dalekThree crash - dalekTwo moves
            if (dalekOne.hasCrashed() && dalekThree.hasCrashed()) {
                
                // Only dalekTwo advances
                // Removing the old peg
                b.removePeg(dalekTwo.getRow(), dalekTwo.getCol());
                
                // Moving towards the doctor
                dalekTwo.advanceTowards(doc);
                
                // Placing the new peg             
                b.putPeg(Color.black, dalekTwo.getRow(), dalekTwo.getCol());
            }
            
            // If dalekOne and dalekTwo crash - dalekThree moves
            if (dalekOne.hasCrashed() && dalekTwo.hasCrashed()) {
                
                // Only dalekThree advances
                // Removing old peg
                b.removePeg(dalekThree.getRow(), dalekThree.getCol());
                
                // Moving towards the doctor
                dalekThree.advanceTowards(doc); 
                
                // Placing the new peg
                b.putPeg(Color.black, dalekThree.getRow(), dalekThree.getCol());
            }
            
            //////////////////////////////CRASH SITE////////////////////////////
            
            // If dalekOne and dalekTwo crash
            if (dalekOne.getCol() == dalekTwo.getCol() && dalekOne.getRow() == dalekTwo.getRow()){
                
                // Setting a crash site
                dalekOne.crash();
                dalekTwo.crash();
                
                // Changing the colour of the pegs to red to indicate crash site
                b.putPeg(Color.red, dalekOne.getRow(), dalekOne.getCol());
                b.putPeg(Color.red, dalekTwo.getRow(), dalekTwo.getCol());
            }
            
            // If dalekOne and dalekThree crash
            if (dalekOne.getCol() == dalekThree.getCol() && dalekOne.getRow() == dalekThree.getRow()){
                
                // Setting a crash site
                dalekOne.crash();
                dalekThree.crash();
                
                // Changing the colour of the pegs to red to indicate crash site
                b.putPeg(Color.red, dalekOne.getRow(), dalekOne.getCol());
                b.putPeg(Color.red, dalekThree.getRow(), dalekThree.getCol());
            }
            
            // If dalekTwo and dalekThree crash
            if (dalekTwo.getRow() == dalekThree.getRow() && dalekTwo.getCol() == dalekThree.getCol()){
                
                // Setting a crash site
                dalekTwo.crash();
                dalekThree.crash();
                
                // Changing the colour of the pegs to red to indicate crash site
                b.putPeg(Color.red, dalekTwo.getRow(), dalekTwo.getCol());
                b.putPeg(Color.red, dalekThree.getRow(), dalekThree.getCol());
            }
            
            // If dalekOne, dalekTwo and dalekThree crash
            if (dalekOne.getRow() == dalekTwo.getRow() && dalekOne.getRow() == dalekThree.getRow()
             && dalekOne.getCol() == dalekTwo.getCol() && dalekOne.getCol() == dalekThree.getCol()){
                
                // Setting a crash site
                dalekOne.crash();
                dalekTwo.crash();
                dalekThree.crash();
                
                // Changing the colour of the pegs to red to indicate crash site
                b.putPeg(Color.red, dalekOne.getRow(), dalekOne.getCol());
                b.putPeg(Color.red, dalekTwo.getRow(), dalekTwo.getCol());
                b.putPeg(Color.red, dalekThree.getRow(), dalekThree.getCol());
            
                // Displaying message - You win
                b.displayMessage("YOU WIN!");
                
                // Ending the game
                status = false;
            }
            
            //////////////////////////WIN OR LOSE CASES/////////////////////////

            // If the doctor gets captured
            if (dalekOne.getCol() == doc.getCol() && dalekOne.getRow() == doc.getRow()
             || dalekTwo.getCol() == doc.getCol() && dalekTwo.getRow() == doc.getRow()
             || dalekThree.getCol() == doc.getCol() && dalekThree.getRow() == doc.getRow()){
                
                // Changes the colour of the peg to yellow once captured
                b.putPeg(Color.yellow, doc.getRow(), doc.getCol());
                
                // Displaying a message - Captured, Lost
                b.displayMessage("YOU HAVE BEEN CAPTURED!");
                
                // Break the loop
                break;
            }

            // If all of the daleks crash
            if (dalekOne.hasCrashed() && dalekTwo.hasCrashed() && dalekThree.hasCrashed()) {
                
                // Display message - You win
                b.displayMessage("YOU WIN!");
                
                // Ending the game 
                status = false;
            }
        }
    }
}
