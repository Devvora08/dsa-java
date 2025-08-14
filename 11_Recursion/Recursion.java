public class Recursion {
    public static void main(String[] args) {
        //message(1);
        System.out.println(fibonacci(25));
    }   

    static int fibonacci(int n) {
        if(n<2) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
    static void message(int count) {
        if (count > 5) return;
        System.out.println("Hello world");
        count ++;
        
        message(count);
    }
}
