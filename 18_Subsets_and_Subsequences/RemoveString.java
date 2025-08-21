// remove entire substring from the input
// 'fhgappledsf' - sub = apple - ans = fhgdsf

public class RemoveString {
    public static void main(String[] args) {
        String apple = "fhgappldsf";
        System.out.println(skipAppNotAppleString(apple));
    }

    static String skipString(String unprocessed) {
        if(unprocessed.isEmpty()) {
            return "";
        }
      
        if(unprocessed.startsWith("apple")) {
            // skip this
            return skipString(unprocessed.substring(5));
        } else {
            return unprocessed.charAt(0) + skipString(unprocessed.substring(1));
        }
    }

    static String skipAppNotAppleString(String unprocessed) {
        if(unprocessed.isEmpty()) {
            return "";
        }
      
        if(unprocessed.startsWith("app") && !unprocessed.startsWith("apple")) {
            // skip this
            return skipString(unprocessed.substring(3));
        } else {
            return unprocessed.charAt(0) + skipAppNotAppleString(unprocessed.substring(1));
        }
    }
}
