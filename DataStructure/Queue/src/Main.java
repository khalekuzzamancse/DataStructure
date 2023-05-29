import main.implement.CustomQueue;
import main.implement.MyQueue;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new CustomQueue<>();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.traverse();
    }
}