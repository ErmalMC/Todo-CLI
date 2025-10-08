import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    private ArrayList<Task> tasks;

    public TaskManager() {
        this.tasks = new  ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int id) {
        tasks.removeIf(task -> task.getID() == id);
        System.out.println("Task removed!");
    }

    public void markDone(int id) {
        for (Task task : tasks) {
            if (task.getID() == id) {
                task.setStatus(true);
                return;
            }
        }
        System.out.println("No task found with ID " + id );
    }

    public void showAllTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void saveToFile() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileOutputStream("tasks.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Task task : tasks) {
            printWriter.println(task);
        }
        printWriter.close();

    }

    public void loadFromFile() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream("tasks.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //System.out.println(Task.fromString(line));
            Task task = Task.fromString(line);
            //System.out.println(task);
            tasks.add(task);
        }
        scanner.close();

    }


}
