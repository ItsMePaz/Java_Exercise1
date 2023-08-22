import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class HandleQueryInput implements ReusScanner {

  static void handleTitleSearch() { //This method handles the Title search query of the user
    System.out.print("\nInput Title: ");
    String titleInput = scanner.nextLine();
    System.out.println(divider);
    System.out.println(
      "\nYou searched for " + titleInput + " and here are the result/s: "
    );
    System.out.println(divider);
    int a = 0; //This will increment each time the loop below does a cycle. It will have a max value of the max number of movie objects in the databse
    try {
      for (int i = 0; i < Service.movieService().length(); i++) { //This maps through each title in different existing movie object. If a matching title value is found, that title and its neighboring movie detail values are passed on to be constructed.
        JSONObject object = Service.movieService().getJSONObject(i);
        String movieTitle = (String) object.get("title");
        if (movieTitle.equalsIgnoreCase(titleInput)) { //This if-statement checkes if there are completely like elements
          ConstructResult.setDetails(object);
        } else {
          a++;
          if (a == Service.movieService().length()) { //If 'a' reaches the max value, it means there is no like elements found, therefore the user's queried movie is not in the database.
            System.out.println(divider);
            System.out.println("\nTitle not found in the database.");
          }
          continue;
        }
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  static void handleGenreSearch() { //This method handles the Genre search query of the user
    System.out.print("\nInput Genre: ");
    String genreInput = scanner.nextLine();
    System.out.println(
      "\nYou searched for " + genreInput + " and here are the result/s: "
    );
    System.out.println(divider);
    int a = 0;
    try {
      for (int i = 0; i < Service.movieService().length(); i++) { //This maps through each genre and its deeper array in different existing movie object. If a matching title value is found, that title and its neighboring movie detail values are passed on to be constructed.
        JSONObject object = Service.movieService().getJSONObject(i);
        JSONArray movieGenres = (JSONArray) object.get("genres");
        ArrayList<String> genreArray = new ArrayList<String>();
        for (int l = 0; l < movieGenres.length(); l++) {
          genreArray.add(movieGenres.getString(l));
        }
        System.out.println();
        if (ArraySearch.searchThrough(genreArray, genreInput) == true) {
          ConstructResult.setDetails(object);
        } else {
          a++;
          if (a == (genreArray.size() - 1) && a == (genreArray.size())) {
            System.out.println(divider);
            System.out.println("\nGenre not found in the database.\n");
          }
          continue;
        }
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } //
  }

  static void handleYearSearch() { //This method handles the Year search query of the user
    System.out.print("\nInput Year: ");
    String yearInputString = scanner.nextLine();
    Integer yearInput = Integer.parseInt(yearInputString); //This parses the user's input to an integer, using Integer and nextInt on the previous line results in an exception
    System.out.println(divider);
    System.out.println(
      "\nYou searched for " + yearInput + " and here are the result/s: "
    );
    System.out.println(divider);
    int a = 0;
    try {
      for (int i = 0; i < Service.movieService().length(); i++) {
        JSONObject object = Service.movieService().getJSONObject(i);
        int movieYear = (int) object.get("year");
        if (movieYear == yearInput) {
          ConstructResult.setDetails(object);
        } else {
          a++;
          if (a == Service.movieService().length()) {
            System.out.println(divider);
            System.out.println("\nYear not found in the database.");
          }
          continue;
        }
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  static void handleDirectorSearch() { //This method handles the Director search query of the user
    System.out.print("\nInput Director's full name: ");
    String directorInput = scanner.nextLine();
    System.out.println(
      "\nYou searched for " + directorInput + " and here are the result/s: "
    );
    System.out.println(divider);
    int a = 0;
    try {
      for (int i = 0; i < Service.movieService().length(); i++) { //This maps through each director and its deeper array in different existing movie object. If a matching title value is found, that title and its neighboring movie detail values are passed on to be constructed.
        JSONObject object = Service.movieService().getJSONObject(i);
        JSONArray movieDirectors = (JSONArray) object.get("directors");
        ArrayList<String> directorArray = new ArrayList<String>();
        for (int l = 0; l < movieDirectors.length(); l++) {
          directorArray.add(movieDirectors.getString(l));
        }
        System.out.println();
        if (ArraySearch.searchThrough(directorArray, directorInput) == true) {
          ConstructResult.setDetails(object);
        } else {
          a++;
          if (a == (directorArray.size() - 1)) {
            System.out.println("Director not found in the database.\n\n");
          }
          continue;
        }
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } //
  }

  static void handleWriterSearch() { //This method handles the Writer search query of the user
    System.out.print("\nInput Writer's full name: ");
    String writerInput = scanner.nextLine();
    System.out.println(
      "\nYou searched for " + writerInput + " and here are the result/s:"
    );
    System.out.println(divider);
    int a = 0;
    try {
      for (int i = 0; i < Service.movieService().length(); i++) { //This maps through each writer and its deeper array in different existing movie object. If a matching title value is found, that title and its neighboring movie detail values are passed on to be constructed.
        JSONObject object = Service.movieService().getJSONObject(i);
        JSONArray movieWriters = (JSONArray) object.get("writers");
        ArrayList<String> writerArray = new ArrayList<String>();
        for (int l = 0; l < movieWriters.length(); l++) {
          writerArray.add(movieWriters.getString(l));
        }
        System.out.println();
        if (ArraySearch.searchThrough(writerArray, writerInput) == true) {
          ConstructResult.setDetails(object);
        } else {
          a++;
          if (a == (writerArray.size()) - 1 && a == (writerArray.size())) {
            System.out.println("Writer not found in the database.\n");
            continue;
          }
        }
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } //
  }

  static void handleActorSearch() { //This method handles the Actor search query of the user
    System.out.print("\nInput Actor's full name: ");
    String actorInput = scanner.nextLine();
    System.out.println(
      "\nYou searched for " + actorInput + " and here are the result/s:"
    );
    System.out.println(divider);
    int a = 0;
    try {
      for (int i = 0; i < Service.movieService().length(); i++) { //This maps through each actor and its deeper array in different existing movie object. If a matching title value is found, that title and its neighboring movie detail values are passed on to be constructed.
        JSONObject object = Service.movieService().getJSONObject(i);
        JSONArray movieActors = (JSONArray) object.get("actors");
        ArrayList<String> actorArray = new ArrayList<String>();
        for (int l = 0; l < movieActors.length(); l++) {
          actorArray.add(movieActors.getString(l));
        }
        System.out.println();
        if (ArraySearch.searchThrough(actorArray, actorInput) == true) {
          ConstructResult.setDetails(object);
        } else {
          a++;
          if (a == (actorArray.size() - 1) && a == actorArray.size()) {
            System.out.println("Actor not found in the database.\n\n");
          }
          continue;
        }
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } //
  }

  static void handleFavoritesSearch() { //This method handles the Favorite search query of the user
    System.out.println("\nHere are your favorite movies: ");

    int a = 0;
    try {
      for (int i = 0; i < Service.movieService().length(); i++) {
        JSONObject object = Service.movieService().getJSONObject(i);
        Boolean movieFavorite = (Boolean) object.get("isFavorite");
        if (movieFavorite == true) {
          ConstructResult.setDetails(object);
        } else {
          a++;
          if (a == Service.movieService().length()) {
            System.out.println("You have no favorites listed.");
          }
          continue;
        }
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
