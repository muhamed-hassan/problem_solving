package com.problem_solving.cards_game;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardsGameProblemTest {
    
    private CardsGameProblem cardsGameProblem;
    
    @Before
    public void setUp() {
        
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
