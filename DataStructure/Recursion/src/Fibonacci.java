public class Fibonacci {
    public static void main(String[] args) {
        /*
        0 1 2 3 4 5 6
        0 1 1 2 3 5 8
         */
        System.out.println(fib(6));
    }

    private static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
