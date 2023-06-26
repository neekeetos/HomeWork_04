import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Task_01 {
    public static void main(String[] args) {
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();

        deque1.add(1);
        deque1.addFirst(2);
        deque1.addFirst(3);

        deque2.add(4);
        deque2.addFirst(5);
        deque2.addFirst(6);

        Scanner scanner = new Scanner(System.in);

        System.out.println(deque1);
        System.out.println(deque2);
        System.out.println("Выберите команду: 1 - умножение, 2 - сложение");
        int command = scanner.nextInt();
        scanner.close();
        switch (command) {
            case 1:
                Deque<Integer> result1 = multiply(deque1, deque2);
                System.out.println("Произведение: " + result1);
                break;
                
            case 2:
                Deque<Integer> result2 = add(deque1, deque2);
                System.out.println("Сумма: " + result2);
                break;
            default:
                System.out.println("Неверная команда");
        }
    }

    public static Deque<Integer> multiply(Deque<Integer> deque1, Deque<Integer> deque2) {
        
        int num1 = dequeToNum(deque1);
        int num2 = dequeToNum(deque2);

        int product = num1 * num2;

        return numToDeque(product);
    }

    public static Deque<Integer> add(Deque<Integer> deque1, Deque<Integer> deque2) {
        
        int num1 = dequeToNum(deque1);
        int num2 = dequeToNum(deque2);

        int sum = num1 + num2;

        return numToDeque(sum);
    }

    public static int dequeToNum(Deque<Integer> deque) {
        int num = 0;
        int multiplier = 1;

        while (!deque.isEmpty()) {
            int digit = deque.removeFirst();
            num += digit * multiplier;
            multiplier *= 10;
        }

        return num;
    }

    public static Deque<Integer> numToDeque(int num) {
        Deque<Integer> deque = new LinkedList<>();
        int digitCount = String.valueOf(num).length();
        for (int i=0; i<digitCount; i++){
            int digit = num % 10;
            deque.addFirst(digit);
            num /= 10;
        }
        return deque;
    }
}


