package ui;

import java.util.Scanner;
import model.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = Integer.parseInt(in.nextLine().trim());
        Deck deck = new Deck(test);
        System.out.println(deck.deck());
        in.close();
    }
}