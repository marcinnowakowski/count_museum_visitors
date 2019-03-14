package pl.marcinnowakowski.museum.solve;

import pl.marcinnowakowski.museum.model.Visit;
import pl.marcinnowakowski.museum.model.VisitorsCount;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class VisitorCounter {

    public VisitorsCount searchMaximumVisitorsCount(List<Visit> visits) {

        return iterateAndHoldMaximumVisitorCount(flattenToVisitorsNumberChangeByTimeSortedMap(visits));
    }

    private SortedMap<LocalTime, Integer> flattenToVisitorsNumberChangeByTimeSortedMap(List<Visit> visits) {

        final SortedMap<LocalTime,Integer> visitStartEndSortedMap = new TreeMap<>();

        visits.stream().forEach(visit -> {
            addOneMoreVisitorsNumberChange(visitStartEndSortedMap, visit.getStart());
            addOneLessVisitorsNumberChange(visitStartEndSortedMap, visit.getEnd());
        });

        return visitStartEndSortedMap;
    }

    private VisitorsCount iterateAndHoldMaximumVisitorCount(SortedMap<LocalTime,Integer> visitorsNumberChangeByTimeSortedMap) {

        LocalTime start = LocalTime.MIN;
        LocalTime end = LocalTime.MAX;
        int maxCount = 0;
        int count = 0;

        Map.Entry<LocalTime, Integer> sectionStart = null;
        for(Map.Entry<LocalTime, Integer> sectionEnd : visitorsNumberChangeByTimeSortedMap.entrySet()) {
            // skip times when number of visitor don't change
            // simultaneous entry and exit
            if(sectionEnd.getValue().intValue() == 0) {
                continue;
            }
            // only set sectionStart in first iteration
            if(sectionStart == null) {
                sectionStart = sectionEnd;
                continue;
            }

            // modify count value for the section
            count += sectionStart.getValue();
            // if new maximum visitors number section found, store it
            if(count > maxCount) {
                start = sectionStart.getKey();
                end = sectionEnd.getKey();
                maxCount = count;
            }
            // prepare for next iteration
            sectionStart = sectionEnd;

        }

        return VisitorsCount.builder().start(start).end(end).count(maxCount).build();


    }

    private void addOneMoreVisitorsNumberChange(SortedMap<LocalTime, Integer> entryExitMap, LocalTime time) {
        if(!entryExitMap.containsKey(time)) {
            entryExitMap.put(time, 1);
        } else {
            entryExitMap.put(time, entryExitMap.get(time) + 1);
        }
    }

    private void addOneLessVisitorsNumberChange(SortedMap<LocalTime, Integer> entryExitMap, LocalTime time) {
        if(!entryExitMap.containsKey(time)) {
            entryExitMap.put(time, -1);
        } else {
            entryExitMap.put(time, entryExitMap.get(time) - 1);
        }
    }
}
