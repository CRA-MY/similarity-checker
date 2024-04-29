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
        int score = checker.checkLength(inputString1, inputString2);
        assertThat(score).isEqualTo(60);
    }

    @Test
    void 글자수가두배이상차이나는경우() {
        String inputString1 = "AB";
        String inputString2 = "ABCE";
        int score = checker.checkLength(inputString1, inputString2);
        assertThat(score).isEqualTo(0);
    }
}