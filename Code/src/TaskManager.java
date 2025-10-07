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

    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    public void updateTask(Task task, boolean status) {
        task.setStatus(status);
    }

    public void showAllTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }


}
