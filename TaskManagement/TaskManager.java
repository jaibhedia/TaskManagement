import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TaskManager {
  private List<Task> tasks;
  
  public TaskManager() {
    tasks = new ArrayList<>();
  }
  
  public void addTask(Task task) {
    tasks.add(task);
  }
  
  public void updateTask(int id, Task newTask) {
    Iterator<Task> iterator = tasks.iterator();
    while(iterator.hasNext()) {
      Task task = iterator.next();
      if(task.getId() == id) {
        task.setName(newTask.getName());
        task.setDescription(newTask.getDescription());
        task.setDeadline(newTask.getDeadline());
        break;
      }
    }
  }
  
  public void deleteTask(Task task2) {
    Iterator<Task> iterator = tasks.iterator();
    while(iterator.hasNext()) {
      Task task = iterator.next();
      if(task.getId() == task2.getId()) {
        iterator.remove();
        break;
      }
    }
  }
  
  public List<Task> getTasks() {
    return tasks;
  }

public Task getTaskById(int id) {
    return null;
}

public void updateTask(TaskJava task2) {
}
}
