// given a string of digits 2-9, return all possible letter combinations that the number could represent. Return
// ans in any order
// eg - digit = "23" - output = ['ad','ae','af','bd','be','bf','cd','ce','cf'] - phone digits button

public class LetterCombination {
    public static void main(String[] args) {
        pad("","128");
    }

    static void pad(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        for(int i = (digit - 1)*3; i< digit*3 ; i++) {
            char ch = (char) ('a' + i);

            pad(p+ch, up.substring(1));
        }
    }
}

// pad("", "12")
//  ├─ 'a' (digit 1 → a,b,c) 
//  │   ├─ 'd' (digit 2 → d,e,f) → "ad"
//  │   ├─ 'e' → "ae"
//  │   └─ 'f' → "af"
//  ├─ 'b'
//  │   ├─ 'd' → "bd"
//  │   ├─ 'e' → "be"
//  │   └─ 'f' → "bf"
//  └─ 'c'
//      ├─ 'd' → "cd"
//      ├─ 'e' → "ce"
//      └─ 'f' → "cf"
