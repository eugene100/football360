package football;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple Football.
 */
class FootballTest {
    /**
     * Main test.
    */

    String[] testData;
    String expectedResult;

    FootballTest() {
        String newLine = System.getProperty("line.separator");

        testData = new String[] {
            "Lions 3, Snakes 3",
            "Tarantulas 1, FCAwesome 0",
            "Lions 1, FCAwesome 1",
            "Tarantulas 3, Snakes 1",
            "Lions 4, Grouches 0"};

        expectedResult = String.join(newLine,
            "1: Tarantulas 4",
            "2: Lions 4",
            "3: FCAwesome 1",
            "4: Snakes 1",
            "5: Grouches 0",
            "");
    }

    @Test
    void testFootball() {

        final Competition competition = new Competition();
        for(String match: testData) {
            competition.addMatch(match);
        }
        System.out.println(competition);
        System.out.println(expectedResult);

        assertEquals(expectedResult, competition.toString());
    }
}
