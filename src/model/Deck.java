package model;

public class Deck {

    Queue<Integer> deck;
    
    public Deck(int cards) {
        deck = new Queue<>();
        for (int i = 1; i <= cards; i++) {
            deck.enqueue(i);
        }
    }

    public String deck() {
        return deck.toString();
    }

}
