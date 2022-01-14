package com.gridnine.testing;

import com.gridnine.testing.moduleSearch.ArriveBeforeDeparture;
import com.gridnine.testing.moduleSearch.FlightBeforeNow;
import com.gridnine.testing.moduleSearch.MoreTwoHoursWait;
import com.gridnine.testing.testclass.Flight;
import com.gridnine.testing.testclass.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println(new FlightBeforeNow().getFilteredFlights(flights));
        System.out.println(new ArriveBeforeDeparture().getFilteredFlights(flights));
        System.out.println(new MoreTwoHoursWait().getFilteredFlights(flights));


    }
}
