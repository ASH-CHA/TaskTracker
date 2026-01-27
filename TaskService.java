import java.time.LocalDateTime;
import java.util.List;

public class TaskService {
    
    private final List<Task> tasks;

    public TaskService(List<Task> tasks){
        this.tasks = tasks;
    }

    public Task add(String description){
        int id = tasks.stream().mapToInt(Task::getId).max().orElse(0) + 1;
        String now = LocalDateTime.now().toString();
        Task task = new Task(id, description, "todo", now, now);
        tasks.add(task);
        return task;
    }
}
