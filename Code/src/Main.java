import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        System.out.println("Welcome to your To Do Program");
        System.out.println("Available Commands:");
        System.out.println("1. add <description>");
        System.out.println("2. list");
        System.out.println("3. done <task number>");
        System.out.println("4. remove <task number>");
        System.out.println("5. exit");

        while (true) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ",2);
            String command = parts[0].toLowerCase();

            switch(command){
                case "add":
                    String  description = parts[1];
                    int newID = manager.getTasks().size()+1;
                    manager.addTask(new Task(newID,description,false));
                    manager.saveToFile();
                    break;
                case "list":
                    manager.showAllTasks();
                    break;
                case "done":
                    if (parts.length < 2) {
                        System.out.println("Usage: done <id>");
                        break;
                    }
                    int doneID = Integer.parseInt(parts[1]);
                    manager.markDone(doneID);
                    manager.saveToFile();
                    break;
                case "remove":
                    if (parts.length < 2) {
                        System.out.println("Usage: remove <id>");
                        break;
                    }
                    int removeID = Integer.parseInt(parts[1]);
                    manager.removeTask(removeID);
                    manager.saveToFile();
                    break;
                case "exit":
                    manager.saveToFile();
                    System.out.println("File Saved! Exiting Program");
                    return;
                default:
                    System.out.println("Invalid Command");
            }

        }

    }
}