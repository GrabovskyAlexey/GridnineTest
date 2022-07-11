package com.gridnine.testing;

public class Main {
    public static void main(String[] args) {
        Filter filter = new FilterImpl();
        filter.addRule(new AlreadyDepartedExcludeRule());

        System.out.println(filter.filter(FlightBuilder.createFlights()));

        filter.clearRules();
        filter.addRule(new ArrivalBeforeDepartureExcludeRule());

        System.out.println(filter.filter(FlightBuilder.createFlights()));

        filter.clearRules();
        filter.addRule(new HoursGroundTimeExcludeRule(2));

        System.out.println(filter.filter(FlightBuilder.createFlights()));
    }
}
