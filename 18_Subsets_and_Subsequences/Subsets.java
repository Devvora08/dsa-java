// print all subsets of a given string

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = subsetList(arr);
        for(List<Integer> list : ans) System.out.println(list);
    }

    static void subseq(String processed, String unprocessed) {
        if(unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        } // base condition

        char ch = unprocessed.charAt(0);
        subseq(processed + ch, unprocessed.substring(1));
        subseq(processed, unprocessed.substring(1));
    }

    // find subset using iteration
    static List<List<Integer>> subsetList(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>()); // initially its empty list inside main outer list
        for(int num : arr) {
            int n = outer.size();
            for(int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }

}


// subseq("", "abc")
//     ├── subseq("a", "bc")
//     │     ├── subseq("ab", "c")
//     │     │     ├── subseq("abc", "") → prints "abc"
//     │     │     └── subseq("ab", "") → prints "ab"
//     │     └── subseq("a", "c")
//     │           ├── subseq("ac", "") → prints "ac"
//     │           └── subseq("a", "") → prints "a"
//     └── subseq("", "bc")
//           ├── subseq("b", "c")
//           │     ├── subseq("bc", "") → prints "bc"
//           │     └── subseq("b", "") → prints "b"
//           └── subseq("", "c")
//                 ├── subseq("c", "") → prints "c"
//                 └── subseq("", "") → prints ""


