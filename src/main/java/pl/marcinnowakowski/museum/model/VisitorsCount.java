package pl.marcinnowakowski.museum.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalTime;

/**
 * Describes visitor count for certain time period
 *
 * start - time period start
 * end - time period end
 * count - number of visitors present in time period
 */
@Value
@Builder
public class VisitorsCount {

    LocalTime start;
    LocalTime end;
    int count;
}
