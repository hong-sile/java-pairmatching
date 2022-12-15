package pairmatching;

import java.io.IOException;
import pairmatching.controller.Controller;

public class Application {
    public static void main(String[] args) {
        try {
            Controller controller = new Controller();
            controller.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
