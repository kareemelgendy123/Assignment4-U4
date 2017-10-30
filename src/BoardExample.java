
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *
 * @author Kareem
 */
public class BoardExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Drawing a board
        Board b = new Board(8,8);
        
        // Putting a peg
        b.putPeg(Color.red, 3, 5);
        b.putPeg(Color.yellow, 6, 4);
        
        // Removing a peg
        b.removePeg(3,5);
        
        // Setting a message
        b.displayMessage("Hello World!");
        
        // Getting click from user
        Coordinate click = b.getClick();
        int clickRow = click.getRow();
        int clickCol = click.getCol();
        
        // Putting a peg on the spot spot clicked
        b.putPeg(Color.white, clickRow, clickCol);
    }
    
}
