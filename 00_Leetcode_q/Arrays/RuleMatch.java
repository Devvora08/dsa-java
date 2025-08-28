import java.util.Arrays;
import java.util.List;

public class RuleMatch {
    public static void main(String[] args) {
        List<List<String>> items = Arrays.asList(
                Arrays.asList("phone", "blue", "pixel"),
                Arrays.asList("computer", "silver", "lenovo"),
                Arrays.asList("phone", "gold", "iphone"));
        
        System.out.println(countMatches(items, "color", "silver"));
    }

    static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0;
        int matched = 0;

        if(ruleKey.equals("color")) index = 1;
        if(ruleKey.equals("name")) index = 2;

        for (List<String> innerList : items) {
            if(innerList.get(index).equals(ruleValue)) {
                matched += 1;
            }
        }

        return matched;
    }
}
