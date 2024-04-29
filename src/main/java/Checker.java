import java.math.BigDecimal;

public class Checker {

    public static final int MAX_SCORE_LENGTH = 60;

    public double checkLength(String inputString1, String inputString2) {
        int length1 = inputString1.length();
        int length2 = inputString2.length();
        if (isMaxScore(length1, length2)) return MAX_SCORE_LENGTH;
        if (isZeroScore(length1, length2)) return 0;
        return calcPartialScore(length1, length2);
    }

    private static double calcPartialScore(int length1, int length2) {
        return Math.round((1 - (double) Math.abs(length1 - length2) / Math.min(length1, length2)) * MAX_SCORE_LENGTH * 1000) / 1000.0;
    }

    private static boolean isZeroScore(int length1, int length2) {
        return length1 >= length2 * 2 || length2 >= length1 * 2;
    }

    private boolean isMaxScore(int length1, int length2) {
        return length1 == length2;
    }
}
