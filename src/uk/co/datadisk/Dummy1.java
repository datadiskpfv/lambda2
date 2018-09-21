package uk.co.datadisk;

import java.io.IOException;

public class Dummy1 {

    public static void main(String[] args) {
        // clear the screen
        System.out.println("Hello");
        clearScreen();
        System.out.println("World");
        clearScreen();
        System.out.println("You should only see this line");
    }

    private static void clearScreen() {
        try {
            // Does not not for windows 10
            // Runtime.getRuntime().exec( "cls");

            // This works
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {}
    }
}
