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
        this.updatedAt = java.time.LocalTime.now().toString();
    }

    public void setStatus(String status){
        this.status = status;
        this.updatedAt = java.time.LocalTime.now().toString();
    }

    @Override
    public String toString(){
        return String.format("[%d] %s (%s)", id, description, status);
    }

    // Manipulate tasks.json file
    
}
