public class Fibonacci {
    public static void main(String[] args) {
        /*
        0 1 2 3 4 5 6
        0 1 1 2 3 5 8
         */
        System.out.println(Fib(6));
    }

    private static int Fib(int n) {
        if (n <= 1) {
            return n;
        }
        return Fib(n - 1) + Fib(n - 2);
    }
}
