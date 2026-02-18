import java.util.List;

public class CLI {
    
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
                    service.update(Integer.parseInt(args[1]), args[2]);
                    System.out.println("Task updated.");
                    break;

                case "delete":
                    service.delete(Integer.parseInt(args[1]));
                    System.out.println("Task deleted.");
                    break;

                case "mark-in-progress":
                    service.mark(Integer.parseInt(args[1]), "in-progress");
                    System.out.println("Task marked in-progress.");
                    break;

                case "mark-done":
                    service.mark(Integer.parseInt(args[1]), "done");
                    System.out.println("Task marked done.");
                    break;

                case "list":
                    String filter = (args.length > 1) ? args[1] : null;
                    for(Task t : service.list(filter)){
                        System.out.println(t);
                    }
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
