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


    }

    public void loadFromFile() {


    }


}
