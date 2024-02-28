/***************************************************************
 * Design cards contain 2 pieces suit and face
 *
 * @author Nguyen Thanh Khoi Tran
 * @date 01-06-2024
 * @version Asg_V1
 ***************************************************************/
public class Card
{
    // Instance data
    private int suit;
    private int face;
    // Constructor
    public Card (int suit, int face) 
    {
        this.suit = suit;
        this.face = face;
    }
    // Accessor method
    public int getSuit() 
    {
        return suit;
    }
    public int getFace() 
    {
        return face;
    }
    // a method that convert from num to String (Suit)
    private String suitWord () 
    {
        String suitAsString = "";
        switch (suit) 
        {
        case 1:
            suitAsString += "HEARTS";
            break;
        case 2:
            suitAsString += "DIAMOND";
            break;
        case 3: 
            suitAsString += "SPADES";
            break;
        case 4:
            suitAsString += "CLUBS";     
            break;
        default:
            suitAsString += "INVALID INPUT";
        }
        return suitAsString;
    }
    // a method that convert from num to String (Face)
    private String faceWord ()
    {
        String faceAsWord = "";
        if (face > 13 || face <= 0) 
        {
            faceAsWord += "INVALID INPUT";
        } 
        else 
        {
            switch (face) 
            {
            case 1:
                faceAsWord += "ACE";
                break;
            case 11:
                faceAsWord += "JACK";
                break;
            case 12: 
                faceAsWord += "QUEEN";
                break;
            case 13:
                faceAsWord += "KING";
                break;
            default:
                faceAsWord += face;           
            }
        }   
        return faceAsWord;
    }
    
    // toString method
    public String toString () 
    {
        String result = "";
        result += String.format("[%s, %s]", suitWord(), faceWord());
        return result;
    }
}
