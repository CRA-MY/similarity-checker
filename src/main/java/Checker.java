public class Checker {

    public static final int MAX_SCORE_LENGTH = 60;

    public int checkLength(String inputString1, String inputString2) {
        int length1 = inputString1.length();
        int length2 = inputString2.length();
        if (length1 == length2) {
            return MAX_SCORE_LENGTH;
        }
        if (length1 >= length2 * 2
        || length2 >= length1 * 2) {
            return 0;
        }
        
        return 0;
    }
}
