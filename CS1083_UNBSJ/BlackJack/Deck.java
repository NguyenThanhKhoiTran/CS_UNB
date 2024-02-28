/*********************************************************************
 * Standard deck(s) of card - static sized (Array)
 *
 * @author Nguyen Thanh Khoi Tran
 * @date 01-06-2024
 * @version Asg_V1
 ********************************************************************/
import java.util.Random;
public class Deck
{
    // Instance data
    private Card [] cards;
    private static final int CARD_SIZE = 52;
    private int index = 0;
    // Constructor
    public Deck (int K) 
    {
        standardDeckCard (K);
        shuffle ();
    }
    
    // num standard decks of card method
    private void standardDeckCard (int num)
    {
        cards = new Card [CARD_SIZE * num];
        int temp = 0;
        for (int m = 0; m < num; m++)
        {
            for (int f = 1; f < 14; f++)
            {
                for (int s = 1; s < 5; s++) 
                {
                    cards [temp++] = new Card (s, f);
                }
            }
        }
    }
    
    // Shuffle method which is using Fisher-Yates shuffle
    private void shuffle()
    {
        Random rd = new Random();
        for (int i  = 0; i < cards.length; i++)
        {
            int j = rd.nextInt(i + 1);
            Card temp = cards [i];
            cards [i] = cards [j]; //temporary variable
            cards [j] = temp;
        }
    }
    
    // Accessor method for Card (if necessary)
    public Card [] getCard()
    {
        return cards;
    }
    
    // Accessor method for index 
    public int getIndex() 
    {
        return index;
    }
    // Deal card method
    public Card dealCard ()
    {
        return cards [index++];
    }
}
