package com.csc340.Assigment02;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ApiController {

    // Get weather information from WeatherAPI
    @GetMapping("/weather")
    public Object getWeather() {
        try {
            String url = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&past_days=10&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m";
            RestTemplate restTemplate = new RestTemplate();

            // Fetch the response as a raw string
            String jsonResponse = restTemplate.getForObject(url, String.class);

            // Log the raw JSON response to the console
            System.out.println("Raw Weather API Response: " + jsonResponse);

            // Parse the response as JSON
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonResponse);

            // Process the JSON data
            JsonNode hourlyData = root.path("hourly");
            List<Double> temperatureList = new ArrayList<>();

            // Iterate through the temperature_2m array
            hourlyData.get("temperature_2m").forEach(temp -> {
                if (temp.isDouble()) {
                    temperatureList.add(temp.asDouble());
                } else if (temp.isInt()) {
                    // Cast to double from integer
                    temperatureList.add(temp.asInt() * 1.0);
                }
            });

            return temperatureList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error in /weather endpoint: " + ex.getMessage();
        }
    }


        // Get a random dog image from DogAPI
        @GetMapping("/dog")
        public Object getRandomDog() {
            try {
                String url = "https://dog.ceo/api/breeds/image/random";
                RestTemplate restTemplate = new RestTemplate();
                ObjectMapper mapper = new ObjectMapper();

                String jsonResponse = restTemplate.getForObject(url, String.class);
                JsonNode root = mapper.readTree(jsonResponse);

                Dog dog = new Dog("Unknown", root.get("message").asText());
                return dog;
            } catch (JsonProcessingException ex) {
                Logger.getLogger(ApiController.class.getName()).log(Level.SEVERE, null, ex);
                return "error in /dog";
            }
        }
}
