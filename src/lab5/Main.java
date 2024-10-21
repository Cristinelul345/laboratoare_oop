package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

interface Task {
    /**
     * Executes the action characteristic of the task.
     */
    void execute();
}

interface Container {
    /**
     * Removes a Task from the Container.
     *
     * @return the removed Task, if the Container is not empty;
     *         null, otherwise
     */
    Task pop();

    /**
     * Inserts a Task in the Container.
     *
     * @param task the inserted Task
     */
    void push(Task task);

    /**
     * Returns the number of elements from the Container.
     *
     * @return The number of elements in this container.
     */
    int size();

    /**
     * Verifies if the Container is empty or not.
     *
     * @return true,  if the Container is empty
     *         false, otherwise
     */
    boolean isEmpty();

    /**
     * Transfers all the elements that exist in a Container in this Container.
     *
     * @param container the Container from which we should transfer elements.
     *                  After the transfer, container.size() == 0
     */
    void transferFrom(Container container);

    /**
     * Return all the tasks stored in the Container.
     *
     * @return The list of the tasks stored in the Container.
     */
    ArrayList<Task> getTasks();
}

interface Minus {
    void minus(float value);
}

interface Plus {
    void plus(float value);
}

interface Mult {
    void mult(float value);
}

interface Div {
    void div(float value);
}

class OutTask implements Task {
    // TODO 1.1.1: Create a field to store the message
    private static String field = "Hello!";

    // TODO 1.1.2: Implement a constructor
    public OutTask(String message) {
        System.out.println(message);
    }

    // TODO 1.1.3: Implement the execute() method
    @Override
    public void execute() {
        new OutTask(field);
    }
}

// TODO 1.2: Implement RandomOutTask
class RandomOutTask implements Task {
    final static Random random1 = new Random(12345);

    public RandomOutTask() {
        final int nxt = random1.nextInt();
        System.out.println(nxt);
    }

    @Override
    public void execute() {
        new RandomOutTask();
    }

}

// TODO 1.2.1: Create a global Random instance which uses 12345 as seed
//  HINT: use final static to store this

// TODO 1.2.2: Generate a random number in constructor
//  HINT: use a final field


// TODO 1.3: Implement CounterOutTask
// TODO 1.3.1: Add a global counter

class CounterOutTask implements Task {
    static Integer counter = 0;

    public CounterOutTask() {
        counter++;
        System.out.println(counter);
    }

    @Override
    public void execute() {
        new CounterOutTask();
    }
}


// TODO 2: Implement Stack and Queue
//  (transferFrom should move all the elements from
//  source container into the current one)

class Stack implements Container {

    ArrayList<Task> list = new ArrayList<Task>();

    //LIFO  (LAST IN FIRST OUT)
    public Task pop() {

        if (list.isEmpty()) {
            return null;
        }
        return list.remove(list.size() - 1);

    }

    public void push(Task task) {
        list.add(task);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Transfers all the elements that exist in a Container in this Container.
     *
     * @param container the Container from which we should transfer elements.
     *                  After the transfer, container.size() == 0
     */
    public void transferFrom(Container container) {
        while (!container.isEmpty()) {
            // Pop elements from the source stack and push them onto this stack
            this.push(container.pop());
        }
    }

    public ArrayList<Task> getTasks() {
        return this.list;
    }
}

class Queue implements Container {
    ArrayList<Task> list = new ArrayList<Task>();

    //FIFO = FIRST IN FIRST OUT
    public Task pop() {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    public void push(Task task) {
        list.add(0, task);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

    public void transferFrom(Container container) {
        while (!container.isEmpty()) {
            // Pop elements from the source queue and push them onto this stack
            this.push(container.pop());
        }
    }

    public ArrayList<Task> getTasks() {
        return this.list;
    }

}

abstract class Album {
    ArrayList<Song> songs = new ArrayList<Song>();

    void addSong(Song song) {
        songs.add(song);
    }

    void removeSong(Song song) {

    }

    @Override
    public String toString() {
        return "Album{" +
                "songs=" + songs +
                '}';
    }
}
// TODO 4.2: Implement DangerousAlbum, ThrillerAlbum and BadAlbum
class DangerousAlbum extends Album {
    @Override
    void removeSong(Song song) {
        for (int i = 2; i < song.getId() / 2; i++) {
            if( song.getId() % i == 0) {
                songs.remove(song);
            }
        }
    }
}

class ThrillerAlbum extends Album {
    @Override
    void removeSong(Song song) {
        if (!song.getComposer().equals("Michael Jackson") || !(song.getId() % 2 == 0)) {
            songs.remove(song);
        }
    }
}
// BadAlbum conține doar melodii care au nume de 3 litere și id număr palindrom
class BadAlbum extends Album {
    @Override
    void removeSong(Song song) {
        if (!(song.getName().length()== 3)) {
            songs.remove(song);
        }

        String palindrom = song.getId().toString();
        int left = 0;
        int right = palindrom.length() - 1;

        while (left < right) {
            if (palindrom.charAt(left) != palindrom.charAt(right)) {
                songs.remove(song);
            }
            left++;
            right--;
        }
    }
}

public class Main {
    private static List<Task> taskList = new ArrayList<>();;

    private static void loadTasks() {
        // TODO: uncomment the lines below

        if (taskList.isEmpty()) {
            taskList.add(new OutTask("First message task"));
            taskList.add(new RandomOutTask());
            taskList.add(new CounterOutTask());
            taskList.add(new OutTask("Second message task"));
            taskList.add(new CounterOutTask());
            taskList.add(new RandomOutTask());
        }
    }

    private static void test1() {
        for (Task task : taskList) {
            task.execute();
        }
    }

    private static void test2() {
        // TODO: uncomment the lines below

        System.out.println("----> Queue");
        Queue q = new Queue();
        for(Task task : taskList) {
            q.push(task);
        }
        q.pop();
        q.pop();
        for (Task task : q.getTasks()) {
            task.execute();
        }

        System.out.println("----> Stack");
        Stack s = new Stack();
        for(Task task : taskList) {
            s.push(task);
        }
        s.pop();
        s.pop();
        for (Task task : s.getTasks()) {
            task.execute();
        }

        System.out.println("----> Testing transferFrom");
        q.transferFrom(s);

        for (Task task : q.getTasks()) {
            task.execute();
        }

        // This should print true
        System.out.println(s.isEmpty());
    }

    static private void test3() {
        // TODO: uncomment the lines below

        Operation op = new Operation(13.5f);
        op.div(0.f);
        op.div(1.f);
        System.out.println(op.getNumber());  // 13.5
        op.mult(2.f);
        System.out.println(op.getNumber());  // 27
        op.minus(3.f);
        System.out.println(op.getNumber());  // 24
        op.plus(7.f);
        System.out.println(op.getNumber());  // 31
    }


    private static void test4() {
        // TODO: uncomment the lines below

        Song song1 = new Song("Bad", 101, "Michael Jackson");
        Song song2 = new Song("Dangerous", 19, "Michael Jackson");
        Song song3 = new Song("Heal the world", 53, "Composer");
        Song song4 = new Song("Thriller", 82, "Michael Jackson" );
        Song song5 = new Song("Beat it", 83, "Michel Jakson");
        Song song6 = new Song("Smooth Criminal", 77, "Composer");

        DangerousAlbum dangerous = new DangerousAlbum();
        dangerous.addSong(song2);
        dangerous.addSong(song3);
        dangerous.addSong(song6);
        System.out.println(dangerous);

        ThrillerAlbum thriller = new ThrillerAlbum();
        thriller.addSong(song4);
        thriller.addSong(song6);
        thriller.addSong(song5);
        System.out.println(thriller);

        BadAlbum bad = new BadAlbum();
        bad.addSong(song1);
        bad.addSong(song6);
        System.out.println(bad);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int task = scanner.nextInt();

        loadTasks();

        if (task == 1) {
            test1();
        } else if (task == 2) {
            test2();
        } else if (task == 3) {
            test3();
        } else {
            test4();
        }
    }
}
