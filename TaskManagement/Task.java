import java.util.Date;

public class Task {
  private int id;
  private String name;
  private String description;
  private Date deadline;
  
  public Task(int id, String name, String description, Date deadline) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.deadline = deadline;
  }
  
  public int getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }
  
  public String getDescription() {
    return description;
  }
  
  public Date getDeadline() {
    return deadline;
  }
  
  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }

public void setName(String name2) {
}

public void setDescription(String description2) {
}
}
