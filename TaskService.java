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

    public void update(int id, String description){
        find(id).setDescription(description);
    }

    public void delete(int id){
        tasks.remove(find(id));
    }

    public void mark(int id, String status){
        find(id).setStatus(status);
    }

    private Task find(int id){
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task not found."));
    }
}
