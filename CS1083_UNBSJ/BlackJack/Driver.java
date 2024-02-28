/************************************************************************************
 * Play game BlackJack
 * @author Nguyen Thanh Khoi Tran
 * @date 01-06-2024
 * @version Asg_V1
 ************************************************************************************/
import java.util.Scanner;
import java.util.ArrayList;
public class Driver
{
    public static void main (String [] args) 
    {
        // Declaration
        Scanner sc = new Scanner (System.in);
        // Instantiate a deck of card
        Deck playDeck = new Deck (1);
        
        // Instantiate a player hand and dealer hand
        HandOfCards player = new HandOfCards ();
        HandOfCards dealer = new HandOfCards ();
        
        // Deal 2 cards to players and dealers
        // 1st card
        player.addCard(playDeck.dealCard());
        dealer.addCard(playDeck.dealCard());
        
        // 2nd card
        player.addCard(playDeck.dealCard());
        dealer.addCard(playDeck.dealCard());
        
        // Reveal player hand and score them
        System.out.println ("Player's hand: ");
        display(player,true, false);
        
        // Reveal dealers hand (not score) and 1st card is hidden
        System.out.println ("\n\nDealer's hand: ");
        display(dealer,false, true);
        
        // A player can hit or stay anytime (<=21)
        // If player score >21 (bust) automatically lose
        hitOrStay (sc, playDeck, player);
        
        // Assuming that player stayed and not bust
        // Dealer reveals entire hand and current score 
        if (player.getScore() <= 21) 
        {
            System.out.println ("\n\nDealer's hand: ");
            display(dealer,true, false);
            // If their score <= 16 -> HIT
            // If their score >= 21 -> STAY
            // If dealer has a Ace counting as 11 and not winning -> HIT
            // Dealer loses if they bust
            if (dealer.getScore() <= 16)
            {
                System.out.print ("As dealer\'s score is less than 16,");
                System.out.print (" dealer MUST HIT\n");
                dealer.addCard(playDeck.dealCard());
                display(dealer,true, false);
            }
            else if (dealer.getScore() >=21)
            {
                System.out.print ("\nAs dealer\'s score is greater than 21,");
                System.out.print (" dealer MUST STAY\n");
                System.out.println ("\n\nDealer's hand: ");
                display(dealer,true, false);
            }
            else if (dealer.getAceCountAs11() > 0)
            {
                System.out.print("\nAs dealer has" + dealer.getAceCountAs11());
                System.out.print("\naces counting as 11, so dealer MUST HIT");
                dealer.addCard(playDeck.dealCard());
                display(dealer,true, false);
                if (dealer.getScore() > 21)
                {
                    System.out.print("\nBUST. Dealer lost as dealer\'s ");
                    System.out.print("score is over 21\n");
                    System.out.println("\n>>>>> Player WIN <<<<<<");
                }
            }
            // Determine the winner
            if (dealer.getScore() > player.getScore() && dealer.getScore() <= 21)
            {
                System.out.print("\n\nPlayer's score: " + player.getScore());
                System.out.print("\nDealer's score: " + dealer.getScore());
                System.out.println("\n>>>>> Dealer WIN <<<<<");
            }
            else if (dealer.getScore() < player.getScore() || dealer.getScore() > 21)
            {
                System.out.print("\n\nPlayer's score: " + player.getScore());
                System.out.print("\nDealer's score: " + dealer.getScore());
                System.out.println("\n>>>>> Player WIN <<<<<");
            }
            else 
            {
                System.out.print("\n\nPlayer's score: " + player.getScore());
                System.out.print("\nDealer's score: " + dealer.getScore());
                System.out.println("\n>>>>> Nobody WIN <<<<<<");
            }
        }
    }

    // Display card and score static method
    private static void display (HandOfCards hand, boolean permit, boolean hidFirst)
    {
        ArrayList <Card> cards = hand.getCard();
        // Hide the 1st card and reveal other cards
        for (int i = 0; i < cards.size(); i++)
        {
          if (hidFirst == true && i == 0)
          {
              System.out.println("[ ? , ?]");
          }
          else
          {
              System.out.println(cards.get(i));
          }
        }
        // Calculate score
        if (permit)
        {
            System.out.format (">> Score: %d <<", hand.getScore());
        }
    }
    // Player hit or stay static method
    private static void hitOrStay (Scanner sc, Deck dk, HandOfCards player)
    {
        boolean con = true;
        while (con)
        {
            System.out.println("\n\nPLAYER'S TURN: ");
            System.out.println("Type \"HIT\" or \"STAY\" only");
            System.out.print("Your choice is ==>");
            String temp = sc.nextLine().toUpperCase();
            if (temp.equals("HIT"))
            {
               player.addCard(dk.dealCard()); 
               System.out.println("\nPlayer's Hand:");
               display(player,true,false);
               // Check score if score = 21, must stay
               if(player.getScore() == 21){
                   System.out.println("As player\'s score equals to 21, STAY");
                   con = false;
               }
               // Check score if it is over 21
               if(player.getScore() > 21){
                   System.out.println("\n\nBUST. You lost as your score is over 21");
                   System.out.println(">>>>> Dealer WIN <<<<<");
                   con = false;
               }
            }
            else if (temp.equals("STAY"))
            {
               System.out.println("\nPlayer's Hand:");
               display(player,true,false);
               con = false;
            } 
            else
            {
                System.out.println("\nInvalid input. \"HIT\" or \"STAY\" only");
            }
        }
    }
}
