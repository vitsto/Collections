import java.util.*;

public class ShopQueue {
    static String[] people = {"Маша", "Даша", "Саша", "Глаша", "Света",
            "Люба", "Таня", "Ира", "Настя", "Олеся", "Регина",
            "Андрей", "Денис", "Аркадий", "Антон", "Артем", "Федор",
            "Руслан", "Алексей", "Дима", "Вася", "Сергей", "Петя", "Егор"};
    static ArrayList<String> names = new ArrayList<>(Arrays.asList(people));
    static Queue<String> queue1 = new ArrayDeque<>(5);
    static Queue<String> queue2 = new ArrayDeque<>(5);
    static Queue<String> queue3 = new ArrayDeque<>(5);

    public static void main(String[] args) {
        initializeQueue(queue1);
        initializeQueue(queue2);
        System.out.println(queue1);
        System.out.println(queue2);
        System.out.println(queue3);
        System.out.println(".....");

        for (int i = 0; i < 10; i++) {
            String person = names.remove(new Random().nextInt(names.size()));
            addPersonToQueue(person);
            System.out.println(queue1);
            System.out.println(queue2);
            System.out.println(queue3);
            System.out.println(".....");
        }

        for (int i = 0; i < 25; i++) {
            removePersonFromQueue();
            System.out.println(queue1);
            System.out.println(queue2);
            System.out.println(queue3);
            System.out.println(".....");
        }

    }

    public static void addPersonToQueue(String person) {
        if (queue1.size() == 5 && queue2.size() == 5) {
            if (queue3.isEmpty()) {
                System.out.println("Галяяя!");
            }
            queue3.add(person);
        } else {
            if (queue1.size() < queue2.size()) {
                queue1.add(person);
            } else {
                queue2.add(person);
            }
        }
    }

    public static void removePersonFromQueue() {
        List<Queue<String>> queues = new ArrayList<>();
        if (!queue1.isEmpty()) {
            queues.add(queue1);
        }
        if (!queue2.isEmpty()) {
            queues.add(queue2);
        }
        if (!queue3.isEmpty()) {
            queues.add(queue3);
        }
        if (!queues.isEmpty()) {
            String personFromQueue = queues.get(new Random().nextInt(queues.size())).poll();
            names.add(personFromQueue);
        } else {
            System.out.println("Все очереди пусты");
        }
    }

    public static void initializeQueue(Queue<String> queue) {
        int count = new Random().nextInt(5);
        for (int i = 0; i < count; i++) {
            queue.offer(names.remove(new Random().nextInt(names.size())));
        }
    }
}
