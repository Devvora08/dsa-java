// list all factors of a number n. ex - n = 20, factors = {1,2,4,5,10,20}

import java.util.ArrayList;

public class Factors {
    public static void main(String[] args) {
        int num = 20;
        factorsThree(num);
    }

    // O(n)
    static void factor(int n) {
        for(int i = 1; i<n; i++) {
            if(n%i == 0) {
                System.out.println(i);
            }
        }
    }

    // O(sqrt(n))
    static void factorsTwo(int n) {
        for(int i = 1; i<Math.sqrt(n); i++) {
            if(n%i == 0) {
                if(n/i == i) {
                    System.out.println(i);
                }
                else {
                    System.out.println(i);
                    System.out.println(n/i);
                }
            }
        }
    }

    // time + space = O(sqrt(n))
      static void factorsThree(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i<Math.sqrt(n); i++) {
            if(n%i == 0) {
                if(n/i == i) {
                    System.out.println(i);
                }
                else {
                    System.out.println(i);
                    list.add(n/i);
                }
            }
        }

        for(int i = list.size()-1; i>=0; i--) {
            System.out.println(list.get(i));
        }
    }
}
