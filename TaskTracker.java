import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class TaskTracker {
    
    // Revaluate all methods and instance variables [Keep variables under Task Properties]
    // Add HashMap<Task, ProgressStatus>
    List<String> tasks;
    String task;
    boolean progress;

    // Task Properties
    String id;
    String description;
    String[] status = new String[]{"todo", "in-progress", "done"};
    LocalDateTime createdAt;
    LocalDateTime updatedAt;


    public TaskTracker(){
        tasks = new ArrayList<>();
        task = new String();
    }

    // Edit Task
    public void add(String str){
        tasks.add(str);
        System.out.println("Added \"" + tasks.get(tasks.size() - 1) + "\"");
    }

    public void delete(String str){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).equals(str)){
                tasks.remove(i);
                System.out.println("Task Deleted");
                break;
            }
        }
        System.out.println("Task Not Nound - No Deletion Required");
    }

    public void update(String str, String newTask){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).equals(str)){
                tasks.get(i).replaceAll(str, newTask);
                System.out.println("Task Updated");
                break;
            }
        }
        System.out.println("Task Not Found - No Update Required");
    }

    // Check Task
    public void check(String str){
        if(progress) System.out.println("Complete");
        System.out.println("In Progress");
    }

    // List Tasks
    public void listAllTasks(){
        for(int i = 0; i < tasks.size(); i++){
            System.out.println(tasks.get(i));
        }
    }

    public void listDoneTasks(){
        for(int i = 0; i < tasks.size(); i++){
            if(progress){
                System.out.println(tasks.get(i));
            }
        }
    }

    public void listNotDoneTasks(){
        for(int i = 0; i < tasks.size(); i++){
            if(!progress){
                System.out.println(tasks.get(i));
            }
        }
    }


}
