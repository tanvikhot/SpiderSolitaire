import java.util.*;

public class P2_Khot_Tanvi_DeckTester
{
    public static void main(String[] args) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
        P2_Khot_Tanvi_Deck deck = new P2_Khot_Tanvi_Deck();

        String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < symbols.length; i++) {
                P2_Khot_Tanvi_Card card = new P2_Khot_Tanvi_Card(symbols[i], values[i]);
                card.setFaceUp(true);
                deck.add(card);
            }
        }

        System.out.println(deck);
        System.out.print("Shuffle 1 time: ");
        deck.shuffle();
        System.out.println(deck);
        System.out.print("Shuffle 2 times: ");
        deck.shuffle();
        System.out.println(deck);
        System.out.print("Shuffle 3 times: ");
        deck.shuffle();
        System.out.println(deck);
        System.out.println();
        deck.sort();
        System.out.print("After sorting: ");
        System.out.println(deck);

        System.out.println();
        deck.shuffle();
        System.out.print("Shuffled before dealing 10 cards: ");
        System.out.println(deck);
        List<P2_Khot_Tanvi_Card> dealtCards = deck.deal(10);
        System.out.print("Dealt cards: ");
        System.out.println(dealtCards);
        System.out.print("After Dealing 10 cards: ");
        System.out.println(deck);
    }
}
