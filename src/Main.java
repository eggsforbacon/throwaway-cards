import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        next = null;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> next() {
        return next;
    }

    public T data() {
        return data;
    }
}

class Queue<T> {
    
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(T data) {
        Node<T> element = new Node<>(data);
        if (front == null) {
            rear = element;
            front = element;
        } else {
            rear.setNext(element);
            rear = element;
        }
        size++;
    }

    public T dequeue() {
        Node<T> trash = front;
        if (front == null) throw new NoSuchElementException("Can't dequeue from an empty queue");
        else if (front == rear) front = rear = null;
        else front = front.next();
        size--;
        return trash.data();

    }

    public T front() {
        return front.data();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> head = front;
        // sb.append("(");
        String prefix = "";
        while (head != null) {
            sb.append(prefix).append(head.data());
            prefix = ", ";
            head = head.next();
        }
        // sb.append(")");
        return sb.toString();
    }
}

class Stack<T> {
    
    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(T data) {
        Node<T> element = new Node<>(data);
        element.setNext(top);
        top = element;
        size++;
    }

    public T pop() {
        Node<T> trash = top;
        top = top.next();
        size--;
        return trash.data();
    }

    public T top() {
        return top.data();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> head = top;
        // sb.append("(");
        String prefix = "";
        while (head != null) {
            sb.append(prefix).append(head.data());
            prefix = ", ";
            head = head.next();
        }
        // sb.append(")");
        return sb.toString();
    }

    public Stack<T> reverse() {
        Stack<T> reversed = new Stack<>();
        while (!isEmpty()) {
            reversed.push(pop());
        }
        return reversed;
    }
}

class Deck {

    Queue<Integer> deck;
    Stack<Integer> throwaways;
    
    public Deck(int cards) {
        deck = new Queue<>();
        throwaways = new Stack<>();
        for (int i = 1; i <= cards; i++) {
            deck.enqueue(i);
        }
        shuffleDiscard();
    }

    private void shuffleDiscard() {
        while (deck.size() > 1) {
            throwaways.push(deck.dequeue());
            deck.enqueue(deck.dequeue());
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

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> input = read(in);
        result(input);
        in.close();
    }

    public static ArrayList<Integer> read(Scanner in) {
        ArrayList<Integer> input = new ArrayList<>();
        int line = Integer.parseInt(in.nextLine().trim());
        while (line != 0) {
            input.add(line);
            line = Integer.parseInt(in.nextLine().trim());
        }
        return input;
    }

    public static void result(ArrayList<Integer> input) {
        Deck deck;
        for (int i : input) {
            deck = new Deck(i);
            String leadingText = (deck.throwaways().isEmpty()) ? "Discarded cards:" : "Discarded cards: ";
            System.out.println((leadingText + deck.throwaways()).trim());
            System.out.println("Remaining card: " + deck.deck());
        }
        System.out.println();
    }
}
