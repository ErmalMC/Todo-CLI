import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    private ArrayList<Task> tasks;

    public TaskManager(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void showAllTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void ReadFile(){
        Scanner input = null;
        try {
            input = new Scanner(new FileInputStream("tasks.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        while (input.hasNextLine()) {
            System.out.println(input.nextLine());
        }
        input.close();

    }

    public void WriteFile(){
        PrintWriter output = null;
        try {
            output = new PrintWriter(new FileOutputStream("tasks.txt",false));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        output.println("Hello World");
        output.close();
    }

    public void Evaluator(){
        System.out.println("This will be evaluated");
    }
}
