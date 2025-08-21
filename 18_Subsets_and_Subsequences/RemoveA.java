// remove all a's from the string

public class RemoveA {
    public static void main(String[] args) {
        skipA("", "heyallfavoruiteman");
    }

    static void skipA(String processed, String unprocessed) {
        if(unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char letter = unprocessed.charAt(0);
        if(letter == 'a') {
            // skip this
            skipA(processed, unprocessed.substring(1));
        } else {
            skipA(processed + letter, unprocessed.substring(1));
        }
    }
}
