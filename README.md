Note:
I created a json file for this java exercise that served as the main database for the movies.
Please add the JAR file reference here before use. The JAR file imported can be downloaded here: https://github.com/stleary/JSON-java

Currently Existing Bug:
When asked if the user wants to search again, and the user's choice will be no, the scanner will prompt again before the program terminates.

Here are the Assumptions I made in doing this exercise:

1. Knowing that I will be replicating a feature of a movie website or app, I will need some sort of database to neatly store my hard-coded movie data. I went with creating a JSON file to easily populate the movies, and using Java Archives classes to read the json file.
2. I assumed that everything I will do here will be READ only, therefore I no longer added a function where a user can update the value of isFavorite, or any keys or values.
3. With regards with the structure, apart from knowing I should have a local database file, I also needed to have seperate java files for different major functionalities. Here are the short summary of what each of the included java file here does, and also these are in order that is based on program flow:

   Start of Program

   \*Main.java: I wanted this file to contain less commands as possible. Here includes the command that puts the program in a loop where its continuity will be based on whether the user wants to search again or terminate the program.

   \*HandleQueryTypeInput.java: Here includes the first methods the program will initiate to handle different conditions for user inputs. It will start by accepting what type of filter method the user wants to use. And will then call that filter methods from HandleQueryInput.

   \*HandleQueryInput.java: This file includes methods that will now prompt the user to input the desired query based on what filter method the user chose. It will then use this query to and compare it with the data included in the movies.json file to see if the input data matches a value. If it does, the entire key-value pairs of object housing that matching element gets called and then passed to the ConstructResult.java

   \*ConstructResult.java: This file contains the method that structures the datatypes of each value to be printed, and also the last step before showing the formatted results to the terminal.

   End of Program

   \*ArraySearch.java: This file includes the method to search through every single element of an array, then returns a value "true" if there is a matching element. I used this because I have also assumed that directors, writers, genres, and actors will all be having not just one value, and I needed a class containing a method that returns a boolean value that checks an elements existence in those string arrays.

   \*Service.java: This file lets me parse and return json file.

Here a quick screen recorded demo of all the filter features of the program -> https://drive.google.com/file/d/15N0TkFZC-F7jZcoH-ohmMAPLq-B2Drl4/view?usp=sharing
