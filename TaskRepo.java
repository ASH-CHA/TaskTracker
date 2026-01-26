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

    public void save(List<Task> tasks) throws IOExecption{
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));

        writer.write(toJson(tasks));
        writer.close();
    }

    // JSON Helpers

    private List<Task> parseTasks(String json){
        List<Task> tasks = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\{(.*?)\\}");
        Matcher matcher = Pattern.matcher(json);

        while(matcher.find()){
            tasks.add(Task.fromJson(matcher.group()));
        }
        return tasks;
    }

    private String toJson(List<Task> tasks){
        StringBuilder sb = new StringBuilder("[");

        for(int i = 0; i < tasks.size(); i++){
            sb.append(tasks.get(i).toJson());
            if(i < tasks.size() - 1) sb.append(",");
        }

        sb.append("]");
        return sb.toString();
    }
}
