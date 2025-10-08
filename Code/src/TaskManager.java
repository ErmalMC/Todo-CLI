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
        for (Task task : tasks) {
            if (task.getID() == id) {
                tasks.remove(task);
                System.out.println("Task has been removed");
                return;
            }
        }
        System.out.println("No task found with ID " + id );
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
        String basePath = System.getProperty("user.dir");
        File file = new File(basePath, "tasks.txt");

        if (!file.exists() && basePath.endsWith("Todo-CLI")) {
            file = new File(basePath + File.separator + "Code", "tasks.txt");
        }

        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(file))) {
            for (Task task : tasks) {
                printWriter.println(task);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Cannot write to file: " + file.getAbsolutePath(), e);
        }
    }

    public void loadFromFile() {
        String basePath = System.getProperty("user.dir");
        File file = new File(basePath, "tasks.txt");

        if (!file.exists() && basePath.endsWith("Todo-CLI")) {
            file = new File(basePath + File.separator + "Code", "tasks.txt");
        }

        if (!file.exists()) {
            System.out.println("No existing tasks file found — starting fresh.");
            return;
        }

        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = Task.fromString(line);
                tasks.add(task);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Cannot read file: " + file.getAbsolutePath(), e);
        }
    }



}
