package pl.marcinnowakowski.museum.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalTime;

/**
 * Describes single visit
 *
 * start - visitor entry
 * end - visitor exit
 */
@Value
@Builder
public class Visit {

    LocalTime start;
    LocalTime end;
}
