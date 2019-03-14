package pl.marcinnowakowski.museum;

import pl.marcinnowakowski.museum.model.Visit;
import pl.marcinnowakowski.museum.parse.InputParser;

import java.util.List;
import java.util.SortedMap;

/*
 * Main application class for count museum visitors application.
 */
public class MuseumVisitorsApplication {

    public static void main(String[] args) {

        if(args.length > 0) {
            System.out.println("Input file not specified");
            System.exit(0);
        }

        final String inputFileName = args[0];
        List<Visit> visits = InputParser.parse(inputFileName);


    }
}
