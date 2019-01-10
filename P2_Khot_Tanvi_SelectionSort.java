import java.util.ArrayList;
import java.util.Arrays;

/*
This lab was very interesting as I am very impressed with selectionSort and find it to be
better than bubbleSort because of the efficiency. Testing out selectionSort using ints, Strings
and then integrating it with SpiderSolitaire was rewarding. This makes me visualize how
sorts can be versatile for use in with any data type.
 */

public class P2_Khot_Tanvi_SelectionSort {
  public static void main(String[] args) {
    int[] arr = new int[6];
    arr[0] = 9; arr[1] = 5;
    arr[2] = 1; arr[3] = 3;
    arr[4] = 7; arr[5] = 4;

    String[] strs = new String[] {"Netra", "Gaurav", "Tanvi", "Tanvik", "Sucheta"};

    System.out.println("before: "  + Arrays.toString(arr));
    selectionSort1(arr);
    System.out.println("after : "  + Arrays.toString(arr));

    System.out.println("before: "  + Arrays.toString(strs));
    selectionSort2(strs);
    System.out.println("after : "  + Arrays.toString(strs));

    String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
    int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    P2_Khot_Tanvi_Deck deck = new P2_Khot_Tanvi_Deck();
    for (int i = 0; i < symbols.length; i++) {
      P2_Khot_Tanvi_Card card = new P2_Khot_Tanvi_Card(symbols[i], values[i]);
      card.setFaceUp(true);
      deck.add(card);
    }
    deck.shuffle();
    System.out.println(deck.cards);
    selectionSort(deck.cards);
    System.out.println(deck.cards);
  }

  public static void selectionSort1(int[] arr){
    int count = 1;
    for (int a = 0; a < arr.length - 1; a++) {
      int maxIndex = arr.length - a-1;
      for (int i = 0; i < arr.length-a-1; i++) {
        if (arr[i] > arr[maxIndex]) {
          maxIndex = i;
        }
      }
        int temp = arr[arr.length - a - 1];
        arr[arr.length - a - 1] = arr[maxIndex];
        arr[maxIndex] = temp;
        System.out.println("step " + count++ + ": " + Arrays.toString(arr));

    }
  }

  public static void selectionSort2(String[] arr){
    for (int a = 0; a < arr.length; a++) {
      int maxIndex = a;
      for (int i = a; i < arr.length; i++) {
        if (arr[i].compareTo(arr[maxIndex]) > 0){
          maxIndex = i;
        }
      }
      String temp = arr[maxIndex];
      arr[maxIndex] = arr[a];
      arr[a] = temp;
    }
  }

  public static void selectionSort(ArrayList<P2_Khot_Tanvi_Card> cards){
    for (int a = 0; a < cards.size() - 1; a++) {
      int maxIndex = cards.size() - a-1;
      for (int i = 0; i < cards.size()-a-1; i++) {
        if (cards.get(i).compareTo(cards.get(maxIndex)) > 0) {
          maxIndex = i;
        }
      }
      P2_Khot_Tanvi_Card temp = cards.get(cards.size() - a - 1);
      cards.set(cards.size() - a - 1, cards.get(maxIndex));
      cards.set(maxIndex, temp);
    }
  }

}
