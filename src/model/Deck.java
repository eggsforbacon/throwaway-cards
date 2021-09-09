package model;

public class Deck {

    Queue<Integer> deck;
    Stack<Integer> throwaways;
    
    public Deck(int cards) {
        deck = new Queue<>();
        throwaways = new Stack<>();
        for (int i = 1; i <= cards; i++) {
            deck.enqueue(i);
        }
        System.out.println(deck());
        shuffleDiscard();
    }

    private void shuffleDiscard() {
        while (deck.size() > 1) {
            throwaways.push(deck.front());
            deck.dequeue();
            deck.enqueue(deck.front());
            deck.dequeue();
        }
        throwaways = throwaways.reverse();
    }

    public String deck() {
        return deck.toString();
    }

    public String throwaways() {
        return throwaways.toString();
    }

}
