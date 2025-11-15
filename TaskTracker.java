import java.util.List;
import java.util.ArrayList;

public class TaskTracker {
    
    List<String> tasks;
    String task;
    boolean progress;

    public TaskTracker(){
        tasks = new ArrayList<>();
        task = new String();
    }

    // Edit Task
    public String add(String str){
        tasks.add(str);
        return tasks.get(tasks.size() - 1);
    }

    public String delete(String str){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).equals(str)){
                tasks.remove(i);
                return "Task Deleted";
            }
        }
        return "Task Not Nound - No Deletion Required";
    }

    public String update(String str, String newTask){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).equals(str)){
                tasks.get(i).replaceAll(str, newTask);
                return "Task Updated";
            }
        }
        return "Task Not Found - No Update Required";
    }

    // Check Task
    public String check(String str){
        if(progress) return "Complete";
        return "In Progress";
    }
}
