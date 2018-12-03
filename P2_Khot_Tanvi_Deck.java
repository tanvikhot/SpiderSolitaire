import java.util.*;

/**
 * This lab was difficult at first because I had to figure out which methods 
 * are needed in each class as I had to use my imagination and think thru to the fully
 * implemented game. Eventually I what was being asked was simple enough for me to 
 * understand since it is broken down very nicely and I came up with some useful methods.
 */
public class P2_Khot_Tanvi_Deck
{

    public ArrayList<P2_Khot_Tanvi_Card> cards;

    public P2_Khot_Tanvi_Deck() {
        this.cards = new ArrayList<P2_Khot_Tanvi_Card>();
    }

    /* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */

    public void add(P2_Khot_Tanvi_Card card) {
        this.cards.add(card);
    }

    public void shuffle() {
        Random rand = new Random();
        int times = rand.nextInt(cards.size() * 20) + 1;
        for (int i = 0; i < times; i++) {
            int firstCard = rand.nextInt(cards.size());
            int secondCard = rand.nextInt(cards.size());
            //            System.out.println("Time number " + i + " switching " + firstCard + "  and " + secondCard);
            if (firstCard != secondCard) {
                P2_Khot_Tanvi_Card temp = cards.get(firstCard);
                cards.set(firstCard, cards.get(secondCard));
                cards.set(secondCard, temp);
            }
        }
    }

    /**
     * This method returns a list of requested cards from the top deck 
     * 
     */
    public List<P2_Khot_Tanvi_Card> deal(int numberOfCards) {
        List<P2_Khot_Tanvi_Card> dealtCards = new ArrayList<P2_Khot_Tanvi_Card>();
        for (int i = 0; i < numberOfCards; i++) {
            if (this.cards.size() > 0) {
                P2_Khot_Tanvi_Card card = this.cards.remove(this.cards.size() - 1);
                dealtCards.add(0, card);
            } else {
                break;
            }
        }
        return dealtCards;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
