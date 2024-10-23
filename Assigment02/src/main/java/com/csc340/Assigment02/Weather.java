package com.csc340.Assigment02;

import java.util.List;

public class Weather {
    private List<Double> temperature;
    private List<Double> humidity;
    private List<Double> windSpeed;

    // Constructor, getters, and setters
    public Weather(List<Double> temperature, List<Double> humidity, List<Double> windSpeed) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    public List<Double> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<Double> temperature) {
        this.temperature = temperature;
    }

    public List<Double> getHumidity() {
        return humidity;
    }

    public void setHumidity(List<Double> humidity) {
        this.humidity = humidity;
    }

    public List<Double> getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(List<Double> windSpeed) {
        this.windSpeed = windSpeed;
    }
}
