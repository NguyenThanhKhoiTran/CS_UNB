// This class supports in colours and graphics
import java.awt.*;
import java.awt.event.*;

// This class supports in GUI
import javax.swing.*;
/********************************************************
 * Rule of the game class
 * @author Nguyen Thanh Khoi Tran
 * @date 23-01-2024
 * @version V1.0
 ********************************************************/
public class Rule extends JPanel
{
 /***********************************************************
  * OUTLINE
  * 
  * ***************** OPENING QUESTION **********************
  * Player who pressed the button first will guess the number 
  * out of 100 people in the actual survey, other player will 
  * guess the actual number is higher or lower than the guess 
  * of the first player. The player who predicts correctly will 
  * play first.
  * *********************************************************
  * 
  * Reveal the first card and ask each player (OFCG) to:
  * + Open the next card (O)
  * + Freeze (F)
  * + Change the base card (C)
  * + Guess the opponent's next card (G)
  * 
  * *Player chose "O"
  * Ask player the next card is higher or lower than the base
  * one, if the answer is correct, then reveal and ask OFCG. 
  * If not, then opponent's turn.
  * 
  * *Player chose "F": Freeze card and then opponent's turn
  * 
  * *Player chose "C"
  * Player's base card will be discarded and replaced with 
  * other card, then ask OFCG
  * 
  * *Player chose "G"
  * Player need to guess exactly the number of opponent's
  * face card. If the prediction is correct, player can 
  * open the next card. Otherwise, the base card will be 
  * discarded, replaced and hidden.
  * 
  * After finished one turn, each player will answer the 
  * the opening question to take the priority of playing
  * first.
  * 
  * ******************** SPECIAL RULE ********************
  * Once player predicts correctly 03 successive times and
  * chose "F", opponent must answer the Opening question.
  * If the answer is higher or lower than the actual number
  * by ten, the base card will be discarded, replaced and 
  * hidden.
  * ******************************************************
  * 
  *********************************************************/
 // Initialization
  
 // Constructor
 public Rule ()
 {
     this.setFocusable (true);
     this.setDoubleBuffered (true);
 }
 
 @Override
 public void paintComponent (Graphics g)
 {
     super.paintComponent(g);
     Graphics2D g2d = (Graphics2D) g;
     
     // Anti-aliasing
     RenderingHints rh = new RenderingHints (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
     g2d.setRenderingHints(rh);
     
     // Draw a big rectangle to contain the rule inside
     
 }
}