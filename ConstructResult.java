import org.json.JSONArray;
import org.json.JSONObject;

public class ConstructResult implements ReusScanner {

  static String titleResult;
  static int yearResult;
  static JSONArray genreResults;
  static JSONArray directorResults;
  static JSONArray writerResults;
  static JSONArray actorResults;
  static boolean isFavoriteResults;

  public static void setDetails(JSONObject retrievedDetails) {
    String titleResult = retrievedDetails.getString("title");
    int yearResult = (int) retrievedDetails.get("year");
    JSONArray genreResults = (JSONArray) retrievedDetails.get("genres");
    JSONArray directorResults = (JSONArray) retrievedDetails.get("directors");
    JSONArray writerResults = (JSONArray) retrievedDetails.get("writers");
    JSONArray actorResults = (JSONArray) retrievedDetails.get("actors");
    boolean isFavoriteResults = (boolean) retrievedDetails.get("isFavorite");

    System.out.println("" + "Movie Title: " + " | " + titleResult + " |");
    System.out.println("Year Released: " + " | " + yearResult + " |");
    System.out.print("Genre/s: ");
    for (Object genre : genreResults) {
      System.out.print("| " + genre + " |");
    }
    System.out.println();
    System.out.print("Director/s: ");
    for (Object director : directorResults) {
      System.out.print("| " + director + " |");
    }

    System.out.println();
    System.out.print("Writer/s: ");
    for (Object writer : writerResults) {
      System.out.print("| " + writer + " |");
    }

    System.out.println();
    System.out.print("Actor/s: ");
    for (Object actor : actorResults) {
      System.out.print("| " + actor + " |");
    }

    System.out.print(
      "\n" + "Added to favorites: " + " | " + isFavoriteResults + " |" + "\n"
    );
    System.out.println();
    System.out.println(divider);
    /*   System.out.println(genreResults);
    System.out.println(directorResults);
    System.out.println(writerResults);
    */
  }

  public static boolean UseAgain() {
    System.out.print("\nWould you like to make another search? (y/n): ");
    String qAgain = scanner.nextLine();

    if (!qAgain.equalsIgnoreCase("y")) {
      return false;
    } else {
      return true;
    }
  }
}
