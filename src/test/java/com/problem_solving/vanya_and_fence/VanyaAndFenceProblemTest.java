package com.problem_solving.vanya_and_fence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class VanyaAndFenceProblemTest {

    private static VanyaAndFenceProblem vafp;

    @BeforeAll
    public static void setup() {
        vafp = new VanyaAndFenceProblem();
    }

    @Test
    public void testFindTheMinimumPossibleValidWidthOfTheRoad_WhenParametersAreValid_ThenReturnTheCalculatedResult() {
        int numberOfFriends = 6, heightOfFence = 5;
        var friendsHeights = new int[] { 7, 6, 8, 9, 10, 5 };
        var expectedResult = 11;

        var actualResult = vafp.findTheMinimumPossibleValidWidthOfTheRoad(numberOfFriends, heightOfFence, friendsHeights);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestFindTheMinimumPossibleValidWidthOfTheRoadWhenParametersAreInvalid")
    public void testFindTheMinimumPossibleValidWidthOfTheRoad_WhenParametersAreInvalid_ThenThrowIllegalArgumentException(int numberOfFriends, int heightOfFence, int[] friendsHeights) {
        assertThrows(IllegalArgumentException.class,
            () ->  vafp.findTheMinimumPossibleValidWidthOfTheRoad(numberOfFriends, heightOfFence, friendsHeights));
    }

    private static Stream<Arguments> provideArgsForTestFindTheMinimumPossibleValidWidthOfTheRoadWhenParametersAreInvalid() {
        var validNumberOfFriends = 6;
        var invalidNumberOfFriends = 0;

        var validHeightOfFence = 5;
        var invalidHeightOfFence = 0;

        int[] validFriendsHeights = { 7, 6, 8, 9, 10, 5 };
        var emptyFriendsHeights = new int[0];
        int[] nullFriendsHeights = null;

        return Stream.of(
            Arguments.of(invalidNumberOfFriends, validHeightOfFence, validFriendsHeights),
            Arguments.of(validNumberOfFriends, invalidHeightOfFence, validFriendsHeights),
            Arguments.of(validNumberOfFriends, validHeightOfFence, emptyFriendsHeights),
            Arguments.of(validNumberOfFriends, validHeightOfFence, nullFriendsHeights)
        );
    }

}
