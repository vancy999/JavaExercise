package org.example;
import java.util.Scanner;

// Custom checked exception
class InvalidYearException extends Exception {
    public InvalidYearException(String message) {
        super(message);
    }
}

// Base class
class Vehicle {
    protected String brand;
    protected String model;
    protected int year;

    public Vehicle(String brand, String model, int year) throws InvalidYearException {
        if (year > 2024) {
            throw new InvalidYearException("Invalid year: " + year);
        }
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void vehicleSound() {
        System.out.println("Vehicle makes a sound");
    }
}

// Car class inheriting from Vehicle
class Car extends Vehicle {
    private int numOfDoors;

    public Car(String brand, String model, int year, int numOfDoors) throws InvalidYearException {
        super(brand, model, year);
        this.numOfDoors = numOfDoors;
    }

    @Override
    public void vehicleSound() {
        System.out.println("Car honks");
    }
}

// Motorcycle class inheriting from Vehicle
class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, String model, int year, boolean hasSidecar) throws InvalidYearException {
        super(brand, model, year);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void vehicleSound() {
        System.out.println("Motorcycle revs");
    }
}

class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter Car details:");
            System.out.print("Brand: ");
            String carBrand = scanner.nextLine();
            System.out.print("Model: ");
            String carModel = scanner.nextLine();
            System.out.print("Year: ");
            int carYear = scanner.nextInt();
            System.out.print("Number of doors: ");
            int numOfDoors = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Vehicle car = new Car(carBrand, carModel, carYear, numOfDoors);
            car.vehicleSound(); // Run vehicleSound for the Car object
        } catch (InvalidYearException e) {
            System.out.println("Error creating Car: " + e.getMessage());
        } finally {
            System.out.println("Car creation attempt completed");
        }

        try {
            System.out.println("\nEnter Motorcycle details:");
            System.out.print("Brand: ");
            String motoBrand = scanner.nextLine();
            System.out.print("Model: ");
            String motoModel = scanner.nextLine();
            System.out.print("Year: ");
            int motoYear = scanner.nextInt();
            System.out.print("Has sidecar (true/false): ");
            boolean hasSidecar = scanner.nextBoolean();
            scanner.nextLine(); // Consume the newline character

            Vehicle motorcycle = new Motorcycle(motoBrand, motoModel, motoYear, hasSidecar);
            motorcycle.vehicleSound(); // Run vehicleSound for the Motorcycle object
        } catch (InvalidYearException e) {
            System.out.println("Error creating Motorcycle: " + e.getMessage());
        } finally {
            System.out.println("Motorcycle creation attempt completed");
        }

        scanner.close();
    }
}

