public class Checker {

    public static final int MAX_SCORE_LENGTH = 60;

    public int checkLength(String inputString1, String inputString2) {
        if (inputString1.length() == inputString2.length()) {
            return MAX_SCORE_LENGTH;
        }
        if (inputString1.length() >= inputString2.length() * 2
        || inputString2.length() >= inputString1.length() * 2) {
            return 0;
        }
        return 0;
    }
}
