import java.util.HashSet;
import java.util.Set;

public class Checker {

    public static final int MAX_SCORE_LENGTH = 60;
    public static final int MAX_SCORE_ALPHA = 40;

    public double checkLength(String inputString1, String inputString2) {
        int length1 = inputString1.length();
        int length2 = inputString2.length();
        if (isMaxScore(length1, length2)) return MAX_SCORE_LENGTH;
        if (isZeroScore(length1, length2)) return 0;
        return calcPartialScore(length1, length2);
    }

    public double checkAlpha(String inputString1, String inputString2) {
        inputString1 = filterUpperCase(inputString1);
        inputString2 = filterUpperCase(inputString2);
        return calcAlphaScore(inputString1, inputString2);
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

    public String filterUpperCase(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static double calcAlphaScore(String inputString1, String inputString2) {
        Set<Character> characterSet1 = getCharacterSet(inputString1);
        Set<Character> characterSet2 = getCharacterSet(inputString2);
        Set<Character> intersection = new HashSet<>(characterSet1);
        intersection.retainAll(characterSet2);
        Set<Character> union = new HashSet<>(characterSet1);
        union.addAll(characterSet2);
        return (double) intersection.size() / union.size() * MAX_SCORE_ALPHA;
    }

    private static Set<Character> getCharacterSet(String inputString1) {
        Set<Character> set1 = new HashSet<>();
        for (char c : inputString1.toCharArray()) {
            set1.add(c);
        }
        return set1;
    }
}
