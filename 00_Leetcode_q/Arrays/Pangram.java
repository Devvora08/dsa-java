//check if sentence is pangram
// Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
// Output: true

public class Pangram {
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }

    static boolean checkIfPangram(String sentence) {
        for(char ch = 'a'; ch <= 'z'; ch++) {
            if(!sentence.contains(ch+"")) {
                return false;
            }
        }

        return true;
    }
}
