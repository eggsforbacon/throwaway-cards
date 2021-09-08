package model;

public class Deck {

    Queue<Integer> deck;
    Queue<Integer> throwaways;
    
    public Deck(int cards) {
        deck = new Queue<>();
        throwaways = new Queue<>();
        for (int i = 1; i <= cards; i++) {
            deck.enqueue(i);
        }
        shuffleDiscard();
    }

    private void shuffleDiscard() {
        while (deck.size() > 1) {
            throwaways.enqueue(deck.dequeue());
            deck.enqueue(deck.dequeue());
        }
    }

    public String deck() {
        return deck.toString();
    }

    public String throwaways() {
        return throwaways.toString();
    }

}
