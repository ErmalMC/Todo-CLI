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
            System.out.println("\n");
            String input = scanner.nextLine();
            String[] parts = input.split(" ",2);
            String command = parts[0].toLowerCase();

            switch(command){
                case "add":
                    break;
                case "list":
                    break;
                case "done":
                    break;
                case "remove":
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Invalid Command");
            }

        }

    }
}