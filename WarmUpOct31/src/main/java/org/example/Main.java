package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Task 1: Create a hash map
        Map<String, Integer> movieRatings = new HashMap<>();

        // Task 2: Add 10 movies with ratings
        movieRatings.put("Interstellar", 10);
        movieRatings.put("Grand Turismo", 6);
        movieRatings.put("John Wick", 9);
        movieRatings.put("2067", 7);
        movieRatings.put("Old Dads", 4);
        movieRatings.put("Spider-Man (No Way Home)", 9);
        movieRatings.put("Barbie", 2);
        movieRatings.put("Alice Darling", 4);
        movieRatings.put("57 Seconds", 5);
        movieRatings.put("Jules", 7);

        // Task 3: Look up the rating of a movie by its title and display it.
        String movieToLookup = "Movie3";
        Integer rating = movieRatings.get(movieToLookup);
        if (rating != null) {
            System.out.println("The rating of " + movieToLookup + " is " + rating);
        } else {
            System.out.println(movieToLookup + " Movie not found, try again.");
        }

        // Task 4: Check if a movie is in the hashmap or not. Display the result.
        String movieToCheck = "Movie7";
        boolean containsMovie = movieRatings.containsKey(movieToCheck);
        System.out.println(movieToCheck + " is " + (containsMovie ? "" : "not ") + "in the database.");

        // Task 5: Print the name of all the movies with a rating above 5.
        System.out.println("Movies with rating above 5:");
        for (Map.Entry<String, Integer> entry : movieRatings.entrySet()) {
            if (entry.getValue() > 5) {
                System.out.println(entry.getKey());
            }
        }
    }
}