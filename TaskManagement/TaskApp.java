import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TaskApp {
  private static TaskManager taskManager = new TaskManager();
  private static Scanner scanner = new Scanner(System.in);
  private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  
  public static void main(String[] args) {
    boolean running = true;
    while(running) {
      System.out.println("Choose an option:");
      System.out.println("1. Add task");
      System.out.println("2. Update task");
      System.out.println("3. Delete task");
      System.out.println("4. View all tasks");
      System.out.println("5. Exit");
      int option = scanner.nextInt();
      scanner.nextLine(); // consume new line character
      
      switch(option) {
        case 1:
          addTask();
          break;
        case 2:
          updateTask();
          break;
        case 3:
          deleteTask();
          break;
        case 4:
          viewAllTasks();
          break;
        case 5:
          running = false;
          break;
        default:
          System.out.println("Invalid option. Please choose again.");
      }
    }
    scanner.close();
  }
  
  private static void addTask() {
    System.out.println("Enter task name:");
    String name = scanner.nextLine();
    System.out.println("Enter task description:");
    String description = scanner.nextLine();
    System.out.println("Enter deadline (yyyy-MM-dd):");
    Date deadline = null;
    try {
      deadline = dateFormat.parse(scanner.nextLine());
    } catch(ParseException e) {
      System.out.println("Invalid date format. Task not added.");
      return;
    }
    Task task = new Task(0, name, description, deadline);
    taskManager.addTask(task);
    System.out.println("Task added successfully.");
  }
  
  private static void updateTask() {
    System.out.println("Enter task id:");
    int id = scanner.nextInt();
    scanner.nextLine(); // consume new line character
    Task task = taskManager.getTaskById(id);
    if(task == null) {
      System.out.println("Task not found.");
      return;
    }
    System.out.println("Enter new task name (press enter to keep current value):");
    String name = scanner.nextLine();
    if(!name.isEmpty()) {
      task.setName(name);
    }
    System.out.println("Enter new task description (press enter to keep current value):");
    String description = scanner.nextLine();
    if(!description.isEmpty()) {
      task.setDescription(description);
    }
    System.out.println("Enter new deadline (yyyy-MM-dd) (press enter to keep current value):");
    String deadlineStr = scanner.nextLine();
    if(!deadlineStr.isEmpty()) {
      try {
        Date deadline = dateFormat.parse(deadlineStr);
        task.setDeadline(deadline);
      } catch(ParseException e) {
        System.out.println("Invalid date format. Task not updated.");
        return;
      }
    }
    taskManager.updateTask(id, task);
    System.out.println("Task updated successfully.");
  }
  
  private static void deleteTask() {
    System.out.println("Enter task id:");
    int id = scanner.nextInt();
    scanner.nextLine(); // consume new line character
    Task task = taskManager.getTaskById(id);
    if(task == null) {
      System.out.println("Task not found.");
      return;
    }
    taskManager.deleteTask(task);
    System.out.println("Task deleted successfully.");
  }
  
  private static void viewAllTasks() {
    List<Task> tasks = taskManager.getTasks();
    if(tasks.isEmpty()) {
        System.out.println("No tasks found.");
        return;
        }
        System.out.println("ID\tName\tDescription\t\tDeadline");
for(Task task : tasks) {
  System.out.println(task.getId() + "\t" + task.getName() + "\t" + task.getDescription() +    "             \t"  + dateFormat.format(task.getDeadline()));
}

  }
}