import java.util.Scanner;

public class TaskTracker {
    
    String msg;
    public TaskTracker(){
        msg = new String();
    }

    public String add(String str){
        msg += str;
        return msg;
    }

    public String delete(String str){
        msg.replaceAll(str, "");
        return msg;
    }

    public void update(String str){
        msg = str;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is your name?");
        String ans = scan.nextLine();

        System.out.println("Hello, " + ans);

        scan.close();
    }
}
