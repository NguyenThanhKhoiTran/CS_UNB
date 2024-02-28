/***************************************************************
 * HandOfCards class - dynamic sized (ArrayList)
 *
 * @author Nguyen Thanh Khoi Tran
 * @date 01-06-2024
 * @version Asg_V1
 ***************************************************************/
import java.util.ArrayList;
public class HandOfCards
{
    // Instance data
    private ArrayList <Card> cards;
    
    // Constructor
    public HandOfCards ()
    {
        this.cards = new ArrayList <Card> ();
    }
    
    // Add card method
    public void addCard (Card newCard)
    {
        cards.add(newCard);
    }
    
    // Accessor method (if necessary)
    public ArrayList<Card> getCard ()
    {
        return cards;
    }
    
    // BlackJack score of the hand method
    public int getScore()
    {
        int score = 0;
        int numAce = 0;
        
        // Checking face of cards
        for (int i = 0; i < cards.size(); i++)
        {
            int value;
            value = cards.get(i).getFace();
            
            // Count how many aces does player/dealer have
            if (value == 1)
            {
                value = 0;
                numAce++;
            }
            
            // Transform J,Q,K into 10 pts
            if (value == 11 || value == 12 || value == 13)
            {
                value = 10;
            }
            
            score += value;
        }
        
        if (numAce != 0)
        {
            for (int i = 0; i < numAce; i++)
            {
                if ((score + 11) <= 21)
                {
                    score += 11;
                }
                else
                {
                    score +=1;
                }
            }
        }
        return score;
    }
    
    // A method that can count how many Ace count as 11 that player has
    public int getAceCountAs11()
    {
        int ace = 0;
        int ace11 = 0;
        int points = 0;
        // Checking face of cards
        for (int i = 0; i < cards.size(); i++)
        {
            int value;
            value = cards.get(i).getFace();
            // Count how many aces does player/dealer have
            if (value == 1)
            {
                value = 0;
                ace++;
            }
            // Transform J,Q,K into 10 pts
            if (value == 11 || value == 12 || value == 13)
            {
                value = 10;
            }
            points += value;
        }
        if (ace != 0)
        {
            for (int i = 0; i < ace; i++)
            {
                if ((points + 11) <= 21)
                {
                    ace11++;
                }
            }
        }
        return ace11;
    }   
}
