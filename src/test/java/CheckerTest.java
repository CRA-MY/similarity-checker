import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CheckerTest {
    Checker checker;

    @BeforeEach
    void setUp() {
        checker = new Checker();
    }

    @Test
    void 글자수가같은경우() {
        String inputString1 = "ABCD";
        String inputString2 = "ABCE";
        assertThatScoreLength(inputString1, inputString2, 60);
    }

    @Test
    void 글자수가두배이상차이나는경우() {
        String inputString1 = "AB";
        String inputString2 = "ABCE";
        assertThatScoreLength(inputString1, inputString2, 0);
    }

    @Test
    void 부분점수를받는경우() {
        String inputString1 = "ABC";
        String inputString2 = "ABCE";
        assertThatScoreLength(inputString1, inputString2, 40);
    }

    @Test
    void 알파벳이모두같은경우() {
        String inputString1 = "ABCDE";
        String inputString2 = "ABCDE";
        assertThatScoreAlpha(inputString1, inputString2, 40);
    }

    @Test
    void 같은알파벳이없는경우() {
        String inputString1 = "ABCD";
        String inputString2 = "EFG";
        assertThatScoreAlpha(inputString1, inputString2, 0);
    }

    @Test
    void 부분적으로알파벳이있는경우() {
        String inputString1 = "AA";
        String inputString2 = "AAE";
        assertThatScoreAlpha(inputString1, inputString2, 20);
    }

    @Test
    void 소문자가포함되어무시되는경우() {
        String inputString1 = "AAe";
        String inputString2 = "AAE";
        assertThatScoreAlpha(inputString1, inputString2, 20);
    }

    private void assertThatScoreLength(String inputString1, String inputString2, int expectedScore) {
        assertThat(checker.checkLength(inputString1, inputString2))
                .isEqualTo(expectedScore);
    }

    private void assertThatScoreAlpha(String inputString1, String inputString2, int expectedScore) {
        assertThat(checker.checkAlpha(inputString1, inputString2))
                .isEqualTo(expectedScore);
    }
}