import java.io.File;

public class TaskRepo {
    
    private static final String FILE_NAME = "tasks.jason";

    public List<Task> load() throws IOException{
        File file = new File(FILE_NAME);
        if(!file.exists()) return new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder json = new StringBuilder();
        String line;

        while((line = reader.readLine()) != null) json.append(line);
        reader.close();

        return parseTasks(json.toString());
    }
}
