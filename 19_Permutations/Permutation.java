// permutation of n length - n!. abc = 3! = 6 combinations

public class Permutation {
    public static void main(String[] args) {
        combinations("", "abc");
    }

    static void combinations(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for(int i = 0; i<=p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            combinations(first + ch + second, up.substring(1));
        }
    }
}

// combinations("", "abc")
//  └── insert 'a' → "a"
//      combinations("a", "bc")
//       ├── insert 'b' → "ba"
//       │    combinations("ba", "c")
//       │     ├── insert 'c' → "cba"
//       │     ├── insert 'c' → "bca"
//       │     └── insert 'c' → "bac"
//       └── insert 'b' → "ab"
//            combinations("ab", "c")
//             ├── insert 'c' → "cab"
//             ├── insert 'c' → "acb"
//             └── insert 'c' → "abc"
