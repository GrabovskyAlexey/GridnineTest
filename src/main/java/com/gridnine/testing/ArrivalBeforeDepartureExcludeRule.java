package com.gridnine.testing;

/**
 * Правило для фильтрации полетов с временем прибытия раньше времени вылета
 */
public class ArrivalBeforeDepartureExcludeRule implements Rule{
    @Override
    public boolean check(Flight flight) {
        return flight.getSegments().stream()
                .noneMatch(segment -> segment.getDepartureDate().isAfter(segment.getArrivalDate()));
    }
}
