package com.problem_solving.cards_game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CardsGameProblemTest {

    private static CardsGameProblem cardsGameProblem;

    @BeforeAll
    public static void setup() {
        cardsGameProblem = new CardsGameProblem();
    }

    @Test
    public void testConanOrAgasa_WhenConanWins_ThenReturnConan() {
        var cards = new int[] { 4, 5, 7 };
        var expectedResult = "Conan";

        Optional<String> actualResult = cardsGameProblem.conanOrAgasa(cards);

        assertEquals(expectedResult, actualResult.get());
    }

    @Test
    public void testConanOrAgasa_WhenAgasaWins_ThenReturnAgasa() {
        var cards = new int[] { 1, 1 };
        var expectedResult = "Agasa";

        Optional<String> actualResult = cardsGameProblem.conanOrAgasa(cards);

        assertEquals(expectedResult, actualResult.get());
    }

    @Test
    public void testConanOrAgasa_WhenCardsArrayIsNull_ThenThrowIllegalArgumentException() {
        int[] cards = null;

        assertThrows(IllegalArgumentException.class,
            () -> cardsGameProblem.conanOrAgasa(cards));
    }

    @Test
    public void testConanOrAgasa_WhenCardsArrayIsEmpty_ThenReturnEmptyOptionaql() {
        var cards = new int[0];
        var expectedResult = Optional.empty();

        Optional<String> actualResult = cardsGameProblem.conanOrAgasa(cards);

        assertEquals(expectedResult, actualResult);
    }

}
