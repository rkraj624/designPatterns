package com.design.patterns.observer;

import java.util.List;
import java.util.ArrayList;

public class ObserverDesignPattern {
    // Subject (Observable)
    static class WeatherStation {
        private int temperature;
        private List<WeatherObserver> observers = new ArrayList<>();

        public void addObserver(WeatherObserver observer) {
            observers.add(observer);
        }
        public void removeObserver(WeatherObserver observer) {
            observers.remove(observer);
        }
        public void setTemperature(int temperature) {
            this.temperature = temperature;
            notifyObservers();
        }
        private void notifyObservers() {
            for (WeatherObserver observer : observers) {
                observer.update(temperature);
            }
        }
    }
    // Observer
    interface WeatherObserver {
        void update(int temperature);
    }
    // Concrete Observer
    static class TemperatureDisplay implements WeatherObserver {
        @Override
        public void update(int temperature) {
            System.out.println("Temperature Display: " + temperature + " degrees Celsius");
        }
    }
        public static void main(String[] args) {
            WeatherStation weatherStation = new WeatherStation();
            TemperatureDisplay temperatureDisplay = new TemperatureDisplay();
            weatherStation.addObserver(temperatureDisplay);
            weatherStation.setTemperature(25); // Notifies the observer
        }
}
