import java.util.List;

public class MainTaskTracker {
    
    public static void main(String[] args) {
        if(args.length == 0){
            printUsage();
            return;
        }

        try{
            TaskRepo repo = new TaskRepo();
            List<Task> tasks = repo.load();
            TaskService service = new TaskService(tasks);

            switch(args[0]){
                case "add":
                    System.out.println("Task add (ID: " + service.add(args[1]).getId() + ")");
                    break;

                case "update":
                    System.out.println("Task updated.");
                    break;

                default:
                    printUsage();
            }
            repo.save(tasks);
        } catch (Exception e){
            System.out.print("Error: " + e.getMessage());
        }
    }

    private static void printUsage(){
        System.out.println("""
        Commands:
            add "description"
            update <id> "description"
            delete <id>
            mark-in-progress <id>
            mark-done <id>
            list [todo|in-progress|done]
                """);
    }
}
