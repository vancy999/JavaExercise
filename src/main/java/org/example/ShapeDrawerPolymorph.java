package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

interface Shape{
    void draw(int height, int size);
}

class drawTriangle implements Shape{
    @Override
    public void draw(int height, int size){
        //Nested loop
        //Outer loop
        for(int i = 1; i <= height;i++){
            //inner loop
            for(int j = 1;j <= height - i; j++){
                System.out.print(" ");
            }
            for(int k = 1;k <= 2 * i -1;k++){
                System.out.print("*");
            }

            System.out.println();
        }
    }
}

class drawSquare implements Shape{
    @Override
    public void draw(int height, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

class drawRectangle implements Shape{
    @Override
    public void draw(int height, int size) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

public class ShapeDrawerPolymorph{
    Scanner scanner = new Scanner(System.in);

    public void displayMenu(){
        System.out.println("Selamat datang di ASCII gambar!");
        System.out.println("Pilih gambar:");
        System.out.println("1. Segitiga");//Nested loop
        System.out.println("2. Kotak");//Nested loop, tapi inner loop ada 2
        System.out.println("3. Rectangle");
        System.out.println("4. Exit");
    }

    public void drawShape(int choice){
        //conditional pilih menu
        try{
            switch (choice){
                case 1:
                    System.out.print("Masukkan berapa tinggi segitiga sama kaki : ");
                    int height = scanner.nextInt();
                    new drawTriangle().draw(height, 1);
                    break;
                case 2:
                    System.out.print("Masukkan berapa size kotak : ");
                    int height2 = scanner.nextInt();
                    int size = scanner.nextInt();
                    new drawSquare().draw(height2, size);
                    break;
                case 3:
                    System.out.print("Masukkan berapa rows rectangle : ");
                    int height3 = scanner.nextInt();
                    System.out.print("Masukkan berapa columns rectangle : ");
                    int size2 = scanner.nextInt();
                    new drawRectangle().draw(height3, size2);
                    break;
                case 4:
                    System.exit(0);
                    break;
//                default:
//                    System.out.println("Invalid input");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Input must be a valid integer. Please try again.");
            // Clear the invalid input from the scanner
            scanner.next();
        }
    }
    public void run(){
        //loop while untuk aplikasi terus running sampai ada exit
        while(true){
            displayMenu();
            System.out.println("Masukkan pilihan anda : ");
            try{
                int choice = scanner.nextInt();
                drawShape(choice);//Dimana ada conditional
                System.out.println();
            } catch(InputMismatchException e){
                System.out.println("Input must be a valid integer. Please try again.");
                // Clear the invalid input from the scanner
                scanner.next();
            }
        }
    }
    public static void main(String[] args){
        //Inheritance (oop)
        //Untuk running aja
        ShapeDrawerPolymorph drawer = new ShapeDrawerPolymorph();
        drawer.run();
    }
}