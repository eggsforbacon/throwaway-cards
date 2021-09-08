package ui;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;

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
            System.out.println("Discarded cards: " + deck.throwaways());
            System.out.println("Remaining card: " + deck.deck());
        }
    }
}