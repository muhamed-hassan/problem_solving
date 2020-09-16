package com.problem_solving.cards_game;

import java.util.Arrays;
import java.util.Optional;

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
class CardsGameProblem {

    Optional<String> conanOrAgasa(int[] cards) {
        if (cards == null) throw new IllegalArgumentException("cards can not be null");

        var numberOfCards = cards.length;
        if (numberOfCards == 0) return Optional.empty();

        var maxCardValue = Arrays.stream(cards).max().getAsInt();
        var maxCardValueOccurrences = (int) Arrays.stream(cards)
                                                        .filter(card -> card == maxCardValue)
                                                        .count();
        var conanWins = false;
        var maxCardValueSelected = false;
        var noCardsLeft = false;
        for (var cursor = 0; cursor < numberOfCards; cursor++) {
            maxCardValueSelected = (cards[cursor] == maxCardValue) && (maxCardValueOccurrences == 1);
            noCardsLeft = (cursor == numberOfCards - 1);
            if (maxCardValueSelected || noCardsLeft) {
                conanWins = (cursor % 2 == 0); //conan's turn -> even #=# agasa's turn -> odd
                break;
            }
        }

        return Optional.of(conanWins ? "Conan" : "Agasa");
    }

}
