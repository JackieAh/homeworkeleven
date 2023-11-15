package com.proftelran.org.lessoneleven.homeworkeleven;

import com.proftelran.org.lessonfour.homeworkfour.Card;
import com.proftelran.org.lessonfour.homeworkfour.Ranks;
import com.proftelran.org.lessonfour.homeworkfour.Suits;

import java.util.Collections;
import java.util.Stack;


public class Solitaire {
    public static void main(String[] args) {
        Stack<Card> deck = createDeck();
        shuffleDeck(deck);
        Stack<Card> playedDeck = play(deck);
        System.out.println(playedDeck);
        System.out.println(playedDeck.size());
        isSuccessful(playedDeck);
    }

    public static Stack<Card> createDeck() {
        Stack<Card> deck = new Stack<>();
        for (Suits suit : Suits.values()) {
            for (Ranks rank : Ranks.values()) {
                Card card = new Card(rank, suit);
                deck.add(card);
            }
        }
        return deck;
    }

    public static Stack<Card> shuffleDeck(Stack<Card> deck) {
        Collections.shuffle(deck);
        return deck;
    }

    public static Stack<Card> play(Stack<Card> deck) {
        Stack<Card> playedDeck = new Stack<>();
        for (Card card : deck) {
            if (!playedDeck.isEmpty() && (playedDeck.peek().suit == card.suit || playedDeck.peek().rank == card.rank)) {
                playedDeck.pop();
                continue;
            }
            playedDeck.push(card);

        }
        return playedDeck;
    }

    public static boolean isSuccessful(Stack<Card> playedDeck) {
        int clubsCount = 0, diamondsCount = 0, heartsCount = 0, spadesCount = 0;
        for (Card card : playedDeck) {
            switch (card.suit) {
                case CLUBS:
                    clubsCount++;
                    break;
                case DIAMONDS:
                    diamondsCount++;
                    break;
                case HEARTS:
                    heartsCount++;
                    break;
                case SPADES:
                    spadesCount++;
                    break;
            }
        }
        if ((clubsCount == 1 || clubsCount % 2 != 0) &&
                (diamondsCount == 1 || diamondsCount % 2 != 0) &&
                (heartsCount == 1 || heartsCount % 2 != 0) &&
                (spadesCount == 1 || spadesCount % 2 != 0)) {
            System.out.println("Success! It's a match!");
            return true;
        } else {
            System.out.println("Bad luck this time, try again!");
            return false;
        }
    }
}