package ru.job4j;

import ru.job4j.services.starterservice.PostStarterService;
import ru.job4j.services.starterservice.StarterService;

/**
 * This app is designed,convert content of the file, to the the other file
 * with refactored content.
 * This class starts and runs ANY starterService.
 * App entrance point.
 */
public class App {

    private StarterService<String[]> starterService;

    public App(StarterService<String[]> starterService) {
        this.starterService = starterService;
    }
    /**
     *   To run this program, just move in to the target directory and make input
     *   from the command line:
     *   java -jar App.jar
     *   after that you can optionally type input and output file paths (respectively)
     *   each preceded by single whitespace. In case paths will be wrong
     *   - you will see the alerting message
     *   and program will quit.
     */
    public static void main(String[] args ) {
       try {
           App app = new App(new PostStarterService());
           if (args.length == 0) {
               app.starterService.start();
           } else {
               app.starterService.start(args);
           }
       } catch (Exception e) {
           System.out.println("Try to input valid file paths!!!");
       }
    }
}