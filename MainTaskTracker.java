import java.util.Scanner;

public class MainTaskTracker {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is your name?");
        String ans = scan.nextLine();

        System.out.println("Hello, " + ans);

        scan.close();
    }
}
