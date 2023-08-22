import java.util.Scanner;

interface ReusScanner {
  Scanner scanner = new Scanner(System.in);
  String divider =
    "_________________________________________________________________________________________________________";
}

public class HandleQueryTypeInput extends HandleQueryInput {

  public static int inputTitle;
  public static boolean optionPickTerminant;

  public static void handleOptionsInput() { //This method lets the user input a query type then will repeat if it is invalid
    do { //This method is covered in a do while loop to be able to repeat itself incase of invalid inputs or incase of re-usage
      try {
        System.out.println(divider);
        System.out.println("\nFind your movie by the following: \n");
        System.out.println(
          "| [1] TITLE | [2] GENRE | [3] YEAR RELEASED | [4] DIRECTOR | [5] WRITER | [6] ACTOR | [7] FAVORITES |\n"
        );
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input filter type (1-7): ");

        int inputTitle = scanner.nextInt();
        System.out.println(divider);
        boolean optionPickTerminant = inputTitle >= 1 && inputTitle <= 7; //This expression results a boolean value than depicts if the the user input is between 1 and 7

        switch (inputTitle) {
          case 1:
            HandleQueryInput.handleTitleSearch();
            break;
          case 2:
            HandleQueryInput.handleGenreSearch();
            break;
          case 3:
            HandleQueryInput.handleYearSearch();
            break;
          case 4:
            HandleQueryInput.handleDirectorSearch();
            break;
          case 5:
            HandleQueryInput.handleWriterSearch();
            break;
          case 6:
            HandleQueryInput.handleActorSearch();
            break;
          case 7:
            HandleQueryInput.handleFavoritesSearch();
            break;
          default:
            System.out.println(
              "\nInvalid input! Please try again and input a corresponding filter method."
            );
        }

        if (optionPickTerminant == false) {
          System.out.println(
            "\nInvalid input! Please try again and input a corresponding filter method."
          );
        } else {
          break;
        }
      } catch (Exception e) {
        System.out.println(divider);
        System.out.println(
          "\nInvalid input! Please try again and input a corresponding filter method."
        );
        // TODO: handle exception
      }
    } while (optionPickTerminant == false);
  }
}
