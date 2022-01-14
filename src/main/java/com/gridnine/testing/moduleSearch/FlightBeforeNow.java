package com.gridnine.testing.moduleSearch;


import com.gridnine.testing.testclass.Flight;
import com.gridnine.testing.testclass.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightBeforeNow implements FlightFilter {
    //проверяет условие - вылет до текущего момента времени

    public boolean search(Flight flight) {
        for (Segment seg : flight.getSegments()) {
            if (seg.getDepartureDate().isBefore(LocalDateTime.now())) return false;

        }
        return true;
    }

    @Override
    public List<Flight> getFilteredFlights(List<Flight> flightList) {
        List<Flight> filtred = new ArrayList<>();

        for (Flight flight : flightList) {
            if (search(flight)) {
                filtred.add(flight);
            }
        }
        return filtred;
    }
}
