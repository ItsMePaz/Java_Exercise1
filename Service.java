import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;

public class Service {

  public static JSONArray movieService() throws IOException {
    String data = new String(Files.readAllBytes(Paths.get("movies.json")));
    JSONArray movieDetailsList = new JSONArray(data);
    return movieDetailsList;
  }
}
