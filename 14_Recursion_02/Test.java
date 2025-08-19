public class Test {
    public static void main(String[] args) {
        func(5);
    }   
    
    static void funcRev(int n) {
        if(n == 0) { return ;}

        funcRev(n-1);            // will print in reverse order
        System.out.println(n);
    }

    static void func(int n) {
        if(n == 0) { return ;}
           
        System.out.println(n);
        func(--n);
    }

    static void funcBoth(int n) {
        if(n == 0) { return ;}
           
        System.out.println(n);
        funcBoth(n-1);
        System.out.println(n);
    }

}
