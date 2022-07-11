package com.gridnine.testing;

import java.time.LocalDateTime;

/**
 * Правило фильтрации перелетов с временем вылета до текущего времени
 */

public class AlreadyDepartedExcludeRule implements Rule {
    @Override
    public boolean check(Flight flight) {
        return flight.getSegments().stream()
                .noneMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now()));
    }
}
