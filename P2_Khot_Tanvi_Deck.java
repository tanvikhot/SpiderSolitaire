import java.util.*;

/**
 * This lab was difficult at first because I had to figure out which methods 
 * are needed in each class as I had to use my imagination and think thru to the fully
 * implemented game. Eventually I what was being asked was simple enough for me to 
 * understand since it is broken down very nicely and I came up with some useful methods.
 */
public class P2_Khot_Tanvi_Deck
{
    String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
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

    public P2_Khot_Tanvi_Card draw(){
        if(cards.size() > 0){
            P2_Khot_Tanvi_Card card = cards.remove(0);
            return card;
        }
        return null;
    }

    public P2_Khot_Tanvi_Card getTopCard(){
        if(cards.size() > 0){
            P2_Khot_Tanvi_Card card = cards.get(cards.size()-1);
            return card;
        }
        return null;
    }
    
    public int size(){
        return cards.size();
    }

    public void clear(){
        this.cards.clear();
    }

    public boolean run(){
        int a = 0;
        if(cards.size() >= 13){
            while(cards.get(a).getValue() != 13){
                a++;
            }
            if(cards.size()-a  >= 13){
                if(cards.get(a + 12).getValue() == 1){
                    for(int i = a; i < cards.size()-1; i++){
                        if(cards.get(i+1).getValue() + 1 == cards.get(i).getValue()){
                            continue;
                        }else{
                            return false;
                        }
                    }
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
            
        }else{
            return false;
        }
    }
    
    public boolean hasRun() {
        boolean hasRun = false;
        if (cards.size() < 13) {
            return false;
        }
        
        int lastCardValue = -1;
        int countCards = 0;
        for (int i = cards.size() - 1; i >= 0; i--) {
            P2_Khot_Tanvi_Card card = cards.get(i);
            if (i == cards.size() - 1 && card.isFaceUp() && card.getValue() == 1) {
                countCards++;
                lastCardValue = 1;
            } else if (card.isFaceUp() && lastCardValue == card.getValue() - 1) {
                countCards++;
                lastCardValue = card.getValue();
            } else {
                hasRun = false;
            }
        }
        if (countCards == 13) {
            return true;
        }
        return hasRun;
    }
    
    public ArrayList<P2_Khot_Tanvi_Card> removeRun() {
        ArrayList<P2_Khot_Tanvi_Card> run = new ArrayList<>();
        if (cards.size() < 13) {
            return null;
        }
        
        for (int i = cards.size() - 1; i >= 0; i--) {
            if (run.size() == 0 && cards.get(i).getValue() == 1) {
                run.add(cards.remove(i));
            } else if (run.get(run.size() - 1).getValue() == cards.get(i).getValue() - 1) {
                run.add(cards.remove(i));
            } else {
                break;
            }
        }
        return run;
    }
    
    public void fillDeck(){
//        for(int a = 1; a <= 4; a++){
            for(int i = 0; i < 13; i++){
                cards.add(new P2_Khot_Tanvi_Card(symbols[i],values[i]));
            }
//        }
    }
}