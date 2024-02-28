package org.example;
import java.util.Scanner;

public class ShapeDrawer {
    Scanner scanner = new Scanner(System.in);

    public void drawShape(int choice){
        //conditional pilih menu
        switch (choice){
            case 1:
                System.out.print("Masukkan berapa tinggi segitiga sama kaki : ");
                int triangleHeight2 = scanner.nextInt();
                drawTriangleSK(triangleHeight2);
                break;
            case 2:
                System.out.print("Masukkan berapa size kotak : ");
                int size = scanner.nextInt();
                createSquare(size);
                break;
            case 3:
                System.out.print("Masukkan berapa rows rectangle : ");
                int rows = scanner.nextInt();
                System.out.print("Masukkan berapa columns rectangle : ");
                int columns = scanner.nextInt();
                createRectangle(rows, columns);
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public void drawTriangleSK(int triangleHeight2){
        //Nested loop
        //Outer loop
        if (triangleHeight2 <= 0) {
            System.out.println("Invalid Height. Height must be greater than 0.");
            return;
        }
        for(int i = 1; i <= triangleHeight2;i++){
            //inner loop
            for(int j = 1;j <= triangleHeight2 - i; j++){
                System.out.print(" ");
            }
            for(int k = 1;k <= 2 * i -1;k++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public void createSquare(int size) {
        if (size <= 0) {
            System.out.println("Invalid size. Size must be greater than 0.");
            return;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void createRectangle(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            System.out.println("Invalid dimensions. Rows and columns must be greater than 0.");
            return;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public void displayMenu(){
        System.out.println("Selamat datang di ASCII gambar!");
        System.out.println("Pilih gambar:");
        System.out.println("1. Segitiga Sama kaki");//Nested loop
        System.out.println("2. Kotak");//Nested loop, tapi inner loop ada 2
        System.out.println("3. Rectangle");
        System.out.println("4. Exit");
    }

    public void run(){
        //loop while untuk aplikasi terus running sampai ada exit
        while(true){
            displayMenu();
            System.out.println("Masukkan pilihan anda : ");
            int choice = scanner.nextInt();
            drawShape(choice);//Dimana ada conditional
            System.out.println();
        }
    }
    public static void main(String[] args){
        //Inheritance (oop)
        //Untuk running aja
        ShapeDrawer drawer = new ShapeDrawer();
        drawer.run();
    }
}
