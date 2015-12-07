package main;

import controller.Controller;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //Executing run method in controller. Starts the game
        Controller controller = new Controller();
        controller.run();
    }
}
