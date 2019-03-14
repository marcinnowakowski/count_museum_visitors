package pl.marcinnowakowski.museum.solve;

import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import pl.marcinnowakowski.museum.model.Visit;
import pl.marcinnowakowski.museum.model.VisitorsCount;

public class VisitorCounterTest {

    VisitorCounter visitorCounter;

    @Test
    public void noVisits() {

        VisitorsCount visitorsCount = visitorCounter.searchMaximumVisitorsCount(new ArrayList<>());
    }

    @Test
    public void twoSimultaneousEntryExits() {

        VisitorsCount visitorsCount = visitorCounter.searchMaximumVisitorsCount(
            Arrays.asList(
                Visit.builder().start(LocalTime.of(10,0)).end(LocalTime.of(10,0)).build(),
                Visit.builder().start(LocalTime.of(12,0)).end(LocalTime.of(12,0)).build()
            )
        );
    }

    @Test
    public void oneVisit() {

    }

    @Test
    public void testThreeOverlappingVisits() {

    }
}
