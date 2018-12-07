import java.util.*;


public class P2_Khot_Tanvi_Board
{
    /* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
    // Attributes
    ArrayList<P2_Khot_Tanvi_Deck> stacks;
    P2_Khot_Tanvi_Deck drawPile;
    ArrayList<P2_Khot_Tanvi_Deck> completedStacks;

    /**
     *  Sets up the Board and fills the stacks and draw pile from a Deck
     *  consisting of numDecks Decks.  The number of Cards in a Deck
     *  depends on the number of suits. Here are examples:
     *
     *  # suits     # numDecks      #cards in overall Deck
     *      1            1          13 (all same suit)
     *      1            2          26 (all same suit)
     *      2            1          26 (one of each suit)
     *      2            2          52 (two of each suit)
     *      4            2          104 (two of each suit)
     *
     *  Once the overall Deck is built, it is shuffled and half the cards
     *  are placed as evenly as possible into the stacks.  The other half
     *  of the cards remain in the draw pile.  If you'd like to specify
     *  more than one suit, feel free to add to the parameter list.
     */
    public P2_Khot_Tanvi_Board(int numStacks, int numDecks) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
        // Build the deck
        P2_Khot_Tanvi_Deck deck = new P2_Khot_Tanvi_Deck();
        for (int i = 0; i < numDecks; i++) {
            deck.fillDeck();
        }
        deck.shuffle();

        // Draw cards from deck and move to stacks
        stacks = new ArrayList<>(numStacks);
        for (int i=0; i < numStacks; i++) {
            stacks.add(new P2_Khot_Tanvi_Deck());
        }

        // most online games I saw leave an exact
        // multiple of numStacks cards in the drawPile
        int cardsForDrawPile = deck.size()/2/numStacks*numStacks;

        // remaining cards go on the stacks
        int cardsForStacks = deck.size() - cardsForDrawPile;
        for (int i = 0; i < cardsForStacks; i++) {
            int currentStack = i % numStacks;
            P2_Khot_Tanvi_Card card = deck.draw();
            if (card != null) {
                stacks.get(currentStack).add(card);
            }
        }
        for (P2_Khot_Tanvi_Deck stack : stacks) {
            stack.getTopCard().setFaceUp(true);
        }

        // remaining cards go to the drawPile
        drawPile = deck;
    }

    /**
     *  Moves a run of cards from src to dest (if possible) and flips the
     *  next card if one is available.  Change the parameter list to match
     *  your implementation of Card if you need to.
     */
    public void makeMove(String symbol, int src, int dest) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
        if (src >= stacks.size() || dest >= stacks.size()) {
            System.out.println("****Invalid move****\n\n");
            return;
        }
        P2_Khot_Tanvi_Deck stackSrc = stacks.get(src);
        P2_Khot_Tanvi_Deck stackDest = stacks.get(dest);

        int indexRequestedCard = stackSrc.getRunStartForSymbol(symbol);

        if (indexRequestedCard == -1) {
            System.out.println("****Invalid move****\n\n");
            return;
        }

        int lastCardValue = stackSrc.getCard(indexRequestedCard).getValue();

        if (stackDest.size() > 0 && stackDest.getTopCard().getValue() != lastCardValue + 1) {
            System.out.println("****Invalid move****\n\n");
            return;
        }

        ArrayList<P2_Khot_Tanvi_Card> run = stackSrc.getRun(indexRequestedCard);
        stackDest.addAll(run);
        if (stackSrc.size() > 0) {
            stackSrc.getTopCard().setFaceUp(true);
        }
    }

    /**
     *  Moves one card onto each stack, or as many as are available
     */
    public void drawCards() {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
        for (int i = 0; i < stacks.size(); i++) {
            P2_Khot_Tanvi_Card card = drawPile.draw();
            if (card != null) {
                card.setFaceUp(true);
                stacks.get(i).add(card);
            }
        }
    }

    /**
     *  Returns true if all stacks and the draw pile are all empty
     */
    public boolean isEmpty() {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
        for (P2_Khot_Tanvi_Deck stack : stacks) {
            if (stack.size() > 0) {
                return false;
            }
        }

        if (drawPile.size() > 0) {
            return false;
        }
        return true;
    }

    /**
     *  If there is a run of A through K starting at the end of sourceStack
     *  then the run is removed from the game or placed into a completed
     *  stacks area.
     *
     *  If there is not a run of A through K starting at the end of sourceStack
     *  then an invalid move message is displayed and the Board is not changed.
     */
    public void clear(int sourceStack) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
        if (sourceStack >= stacks.size()) {
            System.out.println("\n\n****Invalid move****\n\n");
            return;
        }
        if (stacks.get(sourceStack).hasRun()) {
            stacks.get(sourceStack).removeRun();
        } else {
            System.out.println("****Invalid move****\n\n");
        }
        if (stacks.get(sourceStack).size() > 0) {
            stacks.get(sourceStack).getTopCard().setFaceUp(true);
        }
    }

    /**
     * Prints the board to the terminal window by displaying the stacks, draw
     * pile, and done stacks (if you chose to have them)
     */
    public void printBoard() {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
                int i=1;
        for (P2_Khot_Tanvi_Deck stack : stacks) {
            System.out.println(i + ": " + stack.toString());
            i++;
        }
        System.out.println();
        System.out.println("Draw Pile:");
        System.out.println(drawPile);
    }
}
