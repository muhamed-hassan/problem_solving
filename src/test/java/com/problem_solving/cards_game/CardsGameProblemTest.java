package com.problem_solving.cards_game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CardsGameProblemTest {
    
    private static CardsGameProblem cardsGameProblem;
    
    @BeforeAll
    public static void setUp() {
        cardsGameProblem = new CardsGameProblem();
    }
    
    @Test
    public void testConanOrAgasa_WhenConanWins() {
        var cards = new int[]{4, 5, 7};
        
        String winner = cardsGameProblem.conanOrAgasa(cards);
        
        assertEquals("Conan", winner);        
    }

    @Test
    public void testConanOrAgasa_WhenAgasaWins() {
    	var cards = new int[]{1, 1};
        
        String winner = cardsGameProblem.conanOrAgasa(cards);
        
        assertEquals("Agasa", winner);        
    }
    
}
