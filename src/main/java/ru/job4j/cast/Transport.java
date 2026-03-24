package ru.job4j.cast;

public class Transport {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle plane = new Plane();

        Vehicle[] transports = new Vehicle[]{bus, train, plane};
        for (Vehicle object : transports) {
            object.move();
        }
    }
}