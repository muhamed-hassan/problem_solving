package com.problem_solving.cards_game;

import java.util.*;

/*
Conan Edogawa got tired of solving cases, and invited his friend, Professor Agasa, over. They decided to play a game of cards.
Conan has n cards, and the ith card has a number ai written on it. They take turns playing, starting with Conan. In each turn, 
the player chooses a card and removes it. Also, he removes all cards having a number strictly lesser than the number on the chosen card. 
Formally, if the player chooses the ith card, he removes that card and removes the jth card for all j such that aj < ai.

A player loses if he cannot make a move on his turn, that is, he loses if there are no cards left. Predict the outcome of the game, 
assuming both players play optimally.

Input Format:
-------------
The first line contains an integer n — the number of cards Conan has.

The next line contains n integers a1, a2, ..., an, where ai is the number on the ith card.

Constraints:
------------
(1 ≤ n ≤ 10^5)
(1 ≤ ai ≤ 10^5)

Output Format:
--------------
If Conan wins, print "Conan" (without quotes), otherwise print "Agasa" (without quotes).

Input	Result
4 5 7   Conan
1 1     Agasa
*/
public class CardsGameProblem {
    
    public String conanOrAgasa(int[] cards) {

        int numberOfCards = cards.length,
            maxCardValue = Arrays.stream(cards).summaryStatistics().getMax(),
            maxCardValueOccurrences = (int) Arrays.stream(cards)
                                                    .filter(card -> card == Arrays.stream(cards).max().getAsInt())
                                                    .count();
        
        boolean connanWins = false,
                maxCardValueSelected,
                noCardsLeft;
        for (int cursor = 0; cursor < numberOfCards; cursor++) {
            
            maxCardValueSelected = (cards[cursor] == maxCardValue) && (maxCardValueOccurrences == 1);
            noCardsLeft = (cursor == numberOfCards - 1);

            if (maxCardValueSelected || noCardsLeft) {
                
                connanWins = (cursor % 2 == 0); //conan's turn -> even #=# agasa's turn -> odd
                break;
            }
        }

        return connanWins ? "Conan" : "Agasa";
    }
    
}
