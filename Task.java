import java.util.HashMap;
import java.util.Map;
import java.time.LocalTime;

public class Task {

    // Task Properties
    int id;
    String description;
    String status;
    String createdAt;
    String updatedAt;


    public Task(int id, String description, String status, String createdAt, String updatedAt){
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getter Methods
    public int getId(){ return id; }
    public String getDescription(){ return description; }
    public String getStatus(){ return status; }
    public String getCreatedAt(){ return createdAt; }
    public String getUpdatedAt(){ return updatedAt; }


    // Setter Methods
    public void setDescription(String description){
        this.description = description;
        this.updatedAt = LocalTime.now().toString();
    }

    public void setStatus(String status){
        this.status = status;
        this.updatedAt = LocalTime.now().toString();
    }

    @Override
    public String toString(){
        return String.format("[%d] %s (%s)", id, description, status);
    }

    // Manipulate tasks.json file
    public String toJson(){
        return String.format(
            "{\"id\":%d,\"description\":\"%s\",\"status\":\"%s\",\"createdAt\":\"%s\",\"updatedAt\":\"%s\"}",
            id, description, status, createdAt, updatedAt
        );
    }

    public static Task fromJson(String json){
        Map<String, String> map = new HashMap<>();
        json = json.replace("{", "").replace("}", "");

        for(String pair : json.split(",")){
            String[] kv = pair.split(":", 2);
            map.put(kv[0].replace("\"", ""), kv[1].replace("\"", ""));
        }

        return new Task(
            Integer.parseInt(map.get("id")),
            map.get("description"),
            map.get("status"),
            map.get("createdAt"),
            map.get("updatedAt")
        );
    }
}
