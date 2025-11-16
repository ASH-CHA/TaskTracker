import java.util.Scanner;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.File;
//import java.io.IOException;

public class MainTaskTracker {
    
    public static void main(String[] args) {
        TaskTracker newTask = new TaskTracker();
        Scanner scan = new Scanner(System.in);

        System.out.print("Add Task: ");
        String ans = scan.nextLine();

        newTask.add(ans);

        scan.close();

        //ObjectMapper objectMapper = new ObjectMapper();
        //File jsonFile = new File("tasks.json");
    }
}
