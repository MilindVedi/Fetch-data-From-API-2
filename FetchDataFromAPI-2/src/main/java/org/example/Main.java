package org.example;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            // Define API URL
            String apiUrl = "https://api.nationalize.io/?name=nathaniel";

            // Create URL object
            URL url = new URL(apiUrl);

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get response code
            int responseCode = connection.getResponseCode();

            // Check if response code is successful
            if (responseCode == HttpURLConnection.HTTP_OK) {

                  /*
                  Scanner scanner = new Scanner(connection.getInputStream(), "UTF-8").useDelimiter("\\A");

                // Read input stream and store in a string
                String response = scanner.hasNext() ? scanner.next() : "";
                 // Close scanner
                scanner.close();

                // Print JSON data
                System.out.println(response);
                */


                // Get input stream from connection
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                // Read input stream line by line and append to StringBuilder
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Print JSON data
                System.out.println(response.toString());
            } else {
                // Print error message
                System.out.println("Error fetching data. Response code: " + responseCode);
            }
        } catch (Exception e) {
            // Print exception message
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}
