package pokerdeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;

    public Deck() {
        String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] colores = {"Negro", "Rojo"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        cards = new ArrayList<>();

        for (String palo : palos) {
            String color = (palo.equals("Corazones") || palo.equals("Diamantes")) ? "Rojo" : "Negro";
            for (String valor : valores) {
                cards.add(new Card(palo, color, valor));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (cards.isEmpty()) {
            System.out.println("No quedan cartas en el Deck.");
            return;
        }
        Card card = cards.remove(0);
        System.out.println(card);
        System.out.println("Quedan " + cards.size() + " cartas en el Deck.");
    }

    public void pick() {
        if (cards.isEmpty()) {
            System.out.println("No quedan cartas en el Deck.");
            return;
        }
        Random rand = new Random();
        Card card = cards.remove(rand.nextInt(cards.size()));
        System.out.println(card);
        System.out.println("Quedan " + cards.size() + " cartas en el Deck.");
    }

    public void hand() {
        if (cards.size() < 5) {
            System.out.println("No hay suficientes cartas en el Deck.");
            return;
        }
        for (int i = 0; i < 5; i++) {
            Card card = cards.remove(0);
            System.out.println(card);
        }
        System.out.println("Quedan " + cards.size() + " cartas en el Deck.");
    }
}
