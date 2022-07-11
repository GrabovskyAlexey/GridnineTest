package com.gridnine.testing;

/**
 * Правило для фильтрации полетов по количеству проведенного на земле времени между сегментами
 */
public class HoursGroundTimeExcludeRule implements Rule{

    private final int groundHours;

    public HoursGroundTimeExcludeRule(int groundHours) {
        this.groundHours = groundHours;
    }

    @Override
    public boolean check(Flight flight) {
        if(flight.getSegments() == null || flight.getSegments().isEmpty()){
            return false;
        }
        if(flight.getSegments().size() == 1){
            return true;
        }
        Segment previous = flight.getSegments().get(0);
        for (int i = 1; i < flight.getSegments().size(); i++) {
            if(previous.getArrivalDate().plusHours(groundHours).isBefore(flight.getSegments().get(i).getDepartureDate())){
                return false;
            }
            previous = flight.getSegments().get(i);
        }
        return true;
    }
}
